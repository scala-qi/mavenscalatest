package com.qi

object PersonTest {


  def sum(a:Int,b:Int): Int ={
    a+b
  }


  def main(args: Array[String]): Unit = {

    val p=new Person
    p.setName("张三")
    p.setAge(12)
    p.setBirthday("20180101")

    println(s"name:${p.getName},age:${p.getAge},birthday:${p.getBirthday}")

  }

}
