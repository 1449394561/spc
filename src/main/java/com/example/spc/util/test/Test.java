package com.example.spc.util.test;

public class Test {

    public static void main(String[] args) {

// TODO Auto-generated method stub


        Father father = new Son();

        father.sleep();

        father.eat();



        System.out.println(" ");

        Father f = new Son();

        Son son = (Son) f;

        son.eat();

        son.sleep();

        son.play();

    }

}