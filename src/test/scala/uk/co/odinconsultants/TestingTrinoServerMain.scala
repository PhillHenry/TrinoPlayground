package uk.co.odinconsultants
import io.trino.server.testing.TestingTrinoServer

import java.sql.{Connection, DriverManager, ResultSet, Statement}

object TestingTrinoServerMain {

  def main(args: Array[String]): Unit = {
    Class.forName("io.trino.jdbc.TrinoDriver")
    val server    : TestingTrinoServer = TestingTrinoServer.create()
    val connection: Connection = createConnection(server)
    val statement : Statement          = connection.createStatement()
    val sql       : String             = """CREATE TABLE accounts (
                |    account_id bigint,
                |    balance decimal(16,2),
                |    tid bigint,
                |    last_updated timestamptz)
                |PARTITIONED BY (bucket(128, account_id));""".stripMargin
    println("Started")
    statement.execute(sql)
    val resultSet: ResultSet = statement.getResultSet
    print(resultSet.first())
    server.close()
  }

  private def createConnection(server: TestingTrinoServer): Connection  =  {
    val url: String = s"jdbc:trino://${server.getAddress}/"
    DriverManager.getConnection(url, "a_user", null)
  }

}
