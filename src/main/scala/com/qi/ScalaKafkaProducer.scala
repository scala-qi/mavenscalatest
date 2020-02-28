package com.qi

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object ScalaKafkaProducer {

  var properties=new Properties()
  properties.setProperty("bootstrap.servers", "master:9092,slave1:9092,slave2:9092")
  properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
  properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
  var producer = new KafkaProducer[String, String](properties)

  def sendMsg(key:String,value:String): Unit ={
    var record=new ProducerRecord[String,String]("bd20test2", 0, key, value)
    producer.send(record)
  }


  def close(): Unit ={
    if(producer!=null){
      producer.flush()
      producer.close()
    }
  }

  def main(args: Array[String]): Unit = {

      for(i<-0 to 100){
        sendMsg("key"+i,"scala-client-value"+i)
      }
    close()
  }

}


