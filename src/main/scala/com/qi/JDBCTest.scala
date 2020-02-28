package com.qi

import java.sql.DriverManager

object JDBCTest {

  val url="jdbc:mysql://localhost:3306/db_practice"
  val driverClass="com.mysql.jdbc.Driver"
  val username="root"
  val password="123456"

  Class.forName(driverClass)
  val connrction=DriverManager.getConnection(url,username,password)

  def getSomeData(): Unit ={
    val sql="select * from student"
    val stmt=connrction.createStatement()

    val rs=stmt.executeQuery(sql)
    while (rs.next()){
      println(s"studentId:${rs.getInt("sno")},studentName:${rs.getString("sname")}" +
        s",studentAge:${rs.getDate("sage")},studentSex:${rs.getString("ssex")}")
    }
  }

  def main(args: Array[String]): Unit = {
    getSomeData()
  }

}
