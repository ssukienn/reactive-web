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

  val passThroughPage: ChainBuilder = repeat(30) {
    exec(http("no-logic")
      .post("/passthrough/messages")
      .header("Content-Type", "application/json")
      .body(StringBody(
        s"""
           | {
           |   "id": "${UUID.randomUUID().toString}",
           |   "payload": "test payload",
           |   "delay": 300
           | }
        """.stripMargin)))
      .pause(1 second, 2 seconds)
  }

  val passThroughMultiplePage: ChainBuilder = repeat(30) {
    exec(http("no-logic-multiple")
      .post("/passthrough/messages/multiple")
      .header("Content-Type", "application/json")
      .body(StringBody(
        s"""
           | {
           |   "id": "${UUID.randomUUID().toString}",
           |   "payload": "test payload",
           |   "delay": 300,
           |   "size": 500
           | }
        """.stripMargin)))
      .pause(1 second, 2 seconds)
  }

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

    val noLogicScn: ScenarioBuilder = scenario("No Logic Page")
      .exec(endpointPage("no-logic", "/passthrough/messages", 30))

    val noLogicMultipleScn: ScenarioBuilder = scenario("No Logic Page Multiple")
      .exec(endpointPage("no-logic-multiple", "/passthrough/messages/multiple", 30, responseSize = 500))

  val mapScn: ScenarioBuilder = scenario("Map Page")
    .exec(endpointPage("map", s"/${solution}/map", 30))

  val mapMultipleScn: ScenarioBuilder = scenario("Map Page Multiple")
    .exec(endpointPage("map-multiple", s"/${solution}/map/multiple", 30, responseSize = 500))

  val filterScn: ScenarioBuilder = scenario("Filter Page")
    .exec(endpointPage("filter", s"/${solution}/filter", 30))

  val filterMultipleScn: ScenarioBuilder = scenario("Filter Page Multiple")
    .exec(endpointPage("filter-multiple", s"/${solution}/filter/multiple", 30, responseSize = 500))

  val averageScn: ScenarioBuilder = scenario("Avg Page")
    .exec(endpointPage("average", s"/${solution}/average", 30))

  val averageMultipleScn: ScenarioBuilder = scenario("Avg Page Multiple")
    .exec(endpointPage("average-multiple", s"/${solution}/average/multiple", 30, responseSize = 500))
  
  val scn: ScenarioBuilder = scenario("Passthrough Page")
    .exec(passThroughPage)

  val scnMultiple: ScenarioBuilder = scenario("Passthrough Page Multiple")
    .exec(passThroughMultiplePage)

    setUp(scn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
      scnMultiple.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
      mapScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
      mapMultipleScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
      filterScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
      filterMultipleScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
      averageScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf),
      averageMultipleScn.inject(rampUsers(concurrentUsers).over(30 seconds)).protocols(httpConf))
  }
