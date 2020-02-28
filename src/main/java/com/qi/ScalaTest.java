package com.qi;

public class ScalaTest {

    public static void main(String[] args){
        int result=PersonTest.sum(1,4);
        System.out.print(result);

        Student student=new Student();
        student.studentNo_$eq("094504");
        student.setAge(22);
        student.setBirthday("2013-2-1");

        System.out.println("name:"+student.getName()+",age:" +
                ""+student.getAge()+",birthday:"+student.getBirthday()+
                ",studentNo:"+student.studentNo()
        );
    }
}
