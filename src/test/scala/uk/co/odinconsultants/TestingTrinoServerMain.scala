package uk.co.odinconsultants
import io.trino.server.testing.TestingTrinoServer

object TestingTrinoServerMain {

  def main(args: Array[String]): Unit = {
    val server: TestingTrinoServer = TestingTrinoServer.create()
    println("Started")
    server.close()
  }

}
