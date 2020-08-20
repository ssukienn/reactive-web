package pl.edu.agh.sukiennik.thesis.simulations

import java.util.UUID

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class LoadSimulation extends Simulation {

  val baseUrl: String = System.getProperty("TARGET_URL")
  val concurrentUsers: Int = System.getProperty("CONC_USERS").toInt
  val solution: String = System.getProperty("SOLUTION")

  val httpConf: HttpProtocolBuilder = http.baseURL(baseUrl)

  val headers: Map[String, String] = Map("Accept" -> """application/json""")

  def endpointPage(pageName: String, pageUrl: String, times: Int,
                   minPause: Duration = 1 second, maxPause: Duration = 2 second,
                   responseDelay: Int = 300, responseSize: Int = 1
                  ): ChainBuilder = {
    repeat(times) {
      exec(http(pageName)
        .post(pageUrl)
        .header("Content-Type", "application/json")
        .body(StringBody(
          s"""
             | {
             |   "id": "${UUID.randomUUID().toString}",
             |   "payload": "test payload",
             |   "delay": ${responseDelay},
             |   "size": ${responseSize}
             | }
        """.stripMargin)))
        .pause(minPause, maxPause)
    }
  }

  val times = 30
  val responseDelay = 0
  val responseSize = 10000

  val noLogicScn: ScenarioBuilder = scenario("No Logic Page")
    .exec(endpointPage("no-logic", "/passthrough/messages", times = times, responseDelay = responseDelay))

  val noLogicMultipleScn: ScenarioBuilder = scenario("No Logic Page Multiple")
    .exec(endpointPage("no-logic-multiple", "/passthrough/messages/multiple", times = times, responseDelay = responseDelay, responseSize = responseSize))

  val mapScn: ScenarioBuilder = scenario("Map Page")
    .exec(endpointPage(s"${solution}-map", s"/${solution}/map", times = times, responseDelay = responseDelay))

  val mapMultipleScn: ScenarioBuilder = scenario("Map Page Multiple")
    .exec(endpointPage(s"${solution}-map-multiple", s"/${solution}/map/multiple", times = times, responseDelay = responseDelay, responseSize = responseSize))

  val filterScn: ScenarioBuilder = scenario("Filter Page")
    .exec(endpointPage(s"${solution}-filter", s"/${solution}/filter", times = times, responseDelay = responseDelay))

  val filterMultipleScn: ScenarioBuilder = scenario("Filter Page Multiple")
    .exec(endpointPage(s"${solution}-filter-multiple", s"/${solution}/filter/multiple", times = times, responseDelay = responseDelay, responseSize = responseSize))

  val averageScn: ScenarioBuilder = scenario("Avg Page")
    .exec(endpointPage(s"${solution}-average", s"/${solution}/average", times = times, responseDelay = responseDelay))

  val averageMultipleScn: ScenarioBuilder = scenario("Avg Page Multiple")
    .exec(endpointPage(s"${solution}-average-multiple", s"/${solution}/average/multiple", times = times, responseDelay = responseDelay, responseSize = responseSize))

  setUp(
    mapScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
    mapMultipleScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf)
    /*filterScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
    filterMultipleScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
    averageScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
    averageMultipleScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf)*/
  )
}
