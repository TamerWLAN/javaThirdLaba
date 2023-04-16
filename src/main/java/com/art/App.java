package com.art;

import java.sql.SQLOutput;

public class App
{
    public static void main( String[] args )
    {
        Timer tester = new Timer(100000);

        System.out.println(tester.testAll());
    }
}