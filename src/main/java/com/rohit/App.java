package com.rohit;

import com.rohit.controller.CommandInterpretor;

import java.util.Scanner;

/**
 * Inventory Management
 */
public class App
{
    public static void main( String[] args )
    {
        CommandInterpretor commandInterpretor=new CommandInterpretor();
        Scanner console = new Scanner(System.in);
        String command;
        System.out.println("Enter Input");
        while (true){
            command = console.nextLine();
            if(command.equals("#"))
                break;
            else {
                commandInterpretor.execute(command);
            }
        }
    }
}
