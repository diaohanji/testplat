package com.yskj.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Reflect {
    public static void main(String[] args) {
        Student st = new Student();
        st.print();


        //另一种方式
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass.getName());
        Class<? extends Student> aClass = st.getClass();
        try {
            Class<?> aClass1 = Class.forName("com.yskj.controller.Student");

            Method[] methods = aClass1.getDeclaredMethods();
            for (Method a : methods) {
                System.out.println(a);
            }

            System.out.println(aClass1+"****8");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }




}

class Student{
    void print(){
        System.out.println("我是一名学生");
    }
}