package com.qi

import org.apache.hadoop.hbase.client.{Admin, ConnectionFactory, Result, Table}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{CellUtil, HBaseConfiguration, TableName}


object HbaseUtil {

  val CONFIGURATION = HBaseConfiguration.create()
  var connection=ConnectionFactory.createConnection(CONFIGURATION)

  def setConnection(): Unit = {

      connection = ConnectionFactory.createConnection(CONFIGURATION)

  }


   def getAdmin(): Admin ={
     if (connection==null){
       setConnection()
     }
     var admin= connection.getAdmin
     return admin
  }

  def getTable(tName:String): Table ={
    if (connection==null){
      setConnection()
    }
    return  connection.getTable(TableName.valueOf(tName))
  }

  def printResult(result:Result): Unit ={

      while(result.advance()){
        var cell=result.current()
        var rowkey=CellUtil.cloneRow(cell)
        var family=CellUtil.cloneFamily(cell)
        var qualify=CellUtil.cloneQualifier(cell)
        var value=CellUtil.cloneValue(cell)
        var timeStamp=cell.getTimestamp
        System.out.println(s"rowKey:${Bytes.toString(rowkey)}\n" +
          s"family:${Bytes.toString(family)}\n" +
          s"qualify:${Bytes.toString(qualify)}\n" +
          s"timeStamp:${timeStamp}\n" +
          s"value:${Bytes.toString(value)}")
      }

  }

}
