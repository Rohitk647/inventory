package com.rohit;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Util util=new Util();
        Scanner console = new Scanner(System.in);
        String command;
        System.out.println("Enter Input");
        while (true){
            command = console.nextLine();
            if(command.equals("#"))
                break;
            else {
                util.option(command);
            }
        }
    }
}
