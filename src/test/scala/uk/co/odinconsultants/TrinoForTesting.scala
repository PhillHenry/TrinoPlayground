package uk.co.odinconsultants

import io.trino.server.DevelopmentServer
import io.trino.cli.Trino

object TrinoForTesting {

  def main(args: Array[String]): Unit = {
    System.setProperty("config", "etc/config.properties")
    System.setProperty("log.levels-file", "etc/log.properties")
    DevelopmentServer.main(Array("-ea"))
    println("main finished")
    Trino.main(Array.empty[String])
  }

}
