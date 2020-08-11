package pl.edu.agh.sukiennik.thesis.simulations

import java.util.UUID

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class BootLoadSimulation extends Simulation {

  val baseUrl: String = System.getProperty("TARGET_URL")
  val sim_users: Int = System.getProperty("SIM_USERS").toInt

  val httpConf: HttpProtocolBuilder = http.baseURL(baseUrl)

  val headers: Map[String, String] = Map("Accept" -> """application/json""")

  val passThroughPage: ChainBuilder = repeat(30) {
    exec(http("passthrough-messages")
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
    exec(http("passthrough-messages-multiple")
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

  val scn: ScenarioBuilder = scenario("Passthrough Page")
    .exec(passThroughPage)

  val scnMultiple: ScenarioBuilder = scenario("Passthrough Page Multiple")
    .exec(passThroughMultiplePage)

  setUp(scn.inject(rampUsers(sim_users).over(30 seconds)).protocols(httpConf),
    scnMultiple.inject(rampUsers(sim_users).over(30 seconds)).protocols(httpConf))
}
