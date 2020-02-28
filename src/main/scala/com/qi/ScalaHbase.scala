package com.qi

import org.apache.hadoop.hbase.client.Get
import org.apache.hadoop.hbase.util.Bytes

object ScalaHbase {

  var table=HbaseUtil.getTable("bd20:wc")

  def getDataFromTable(): Unit = {
    var get =new Get(Bytes.toBytes("1000"))
    var result=table.get(get)
    HbaseUtil.printResult(result)
  }

  def main(args: Array[String]): Unit = {

    getDataFromTable()
  }

}
