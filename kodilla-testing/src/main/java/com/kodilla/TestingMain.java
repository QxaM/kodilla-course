package com.kodilla;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if(result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int resultCalc = calculator.add(2,7);
        System.out.println("Testing - first unit test for class Calculator: ");
        if(resultCalc == (2+7)){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        resultCalc = calculator.substract(2, 7);
        System.out.println("Testing - second unit test for class Calculator: ");
        if(resultCalc == (2-7)){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}