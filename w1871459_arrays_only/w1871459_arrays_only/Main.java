package com.loshithan;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
     * declared the variables and cabin array to access by all methods
     */
    static int cabinNum=0;
    static String cabinName;
    static String[] cabins = new String[12];
    static Scanner s = new Scanner(System.in);
    static String choice;

    public static void main(String[] args) {
	// write your code here

        initialise(cabins); //better to initialise in procedure
        menu();








    //    }
    }

    /**
     *
     * @param cabinRef takes cabin array and stores the value "e" init
     */
    private static void initialise( String cabinRef[])
    {
        for (int x = 0; x < 12; x++ ) cabinRef[x] = "e";
        System.out.println( "initilise ");
    }

    /**
     * @exception IOException On input error
     */

    private static void Adds_customer(){


            try{System.out.println("Enter room number (1-12) or 13 to stop:");
            cabinNum = s.nextInt()-1 ;
            }
            catch (Exception e){
                System.out.println("enter Integer Value!");
                menu();
            }

            if (cabinNum+1 > 12){
                System.out.println("exit");
                menu();
            }
            else{

                    System.out.println("Enter name for room " + (cabinNum+1) + " :");
                    cabinName = s.next();


                cabins[cabinNum] = cabinName;
            }
        System.out.println("customer added successfully!");

    }

    /**
     * view empty and occupied cabins
     */
    private static void Views_All_cabins(){
        for (int x = 0; x < 12; x++ )
        {
            if (!cabins[x].equals("e")){
            System.out.println("room " + (x+1) + " occupied by " + cabins[x]);
            }
            else{
                System.out.println("room "+ (x+1)+" is empty ");
            }
        }

    }

    /**
     * displays only the empty cabins
     */
    private static void Display_Empty_cabins(){
        for (int x = 0; x < 12; x++ )
        {
            if (cabins[x].equals("e"))
                System.out.println("room " + (x+1) + " is empty");
        }
        System.out.println( );

    }

    private static void menu(){

        do {
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("A: Add customer into cabins");
            System.out.println("V: View all cabins");
            System.out.println("E: Display Empty cabins");
            System.out.println("D: Delete customer from cabin");
            System.out.println("F: Find cabin from customer name");
            System.out.println("S: Store program data into file");
            System.out.println("L: Load program data from file");
            System.out.println("O: View passengersOrdered alphabetically by name");
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("Enter option: ");
            choice = s.next().toUpperCase(Locale.ROOT);
            switch (choice) {
                case "A" -> Adds_customer();
                case "V" -> Views_All_cabins();
                case "E" -> Display_Empty_cabins();
                case "D" -> Delete_customer();
                case "F" -> Find_customer();
                case "S" -> Store_program();
                case "L" -> Load_program();
                case "O" -> Order_passengers();


            }
        } while (!choice.equals("X"));


    }
    private static void Delete_customer(){
//
        System.out.println("Enter cabin to remove: ");
        int removeindex= s.nextInt()-1;
        for (int i = 0; i < cabins.length; i++) {
            if (removeindex==i){
                cabins[i]="e";
            }

        }


    }
    private static void Find_customer(){
        System.out.println("give the name of owner: ");
        String find_cabin = s.next();

        for (int x = 0; x < 12; x++ )
        {
            if (find_cabin.equals(cabins[x])){
                System.out.println(find_cabin+" owns cabin number: "+(x+1));
            }

        }

    }

    /**
     * @exception FileNotFoundException if exist get file and proceed else create new file
     * this method takes the cabin array and stores the customer details to file
     */
    private static void Store_program(){

        File file = new File("file.txt");
        try {
            if(file.createNewFile()){
                System.out.println("file created:" + file.getName());
            }
            else{
                System.out.println("file doesn't exist !");

            }
            FileWriter fw = new FileWriter("file.txt");
            for (int x = 0; x <12; x++ )
            {

//

                    if (!cabins[x].equals("e")){
                        fw.write("room " + (x+1) + " occupied by " + cabins[x]+"\n");
                    }
                    else{
                        fw.write("room "+ (x+1)+" is empty "+"\n");
                    }




            }
            fw.close();
            System.out.println("program stored successfully!");
        } catch (IOException e) {
            System.out.println("error occured!");
            e.printStackTrace();
        }


    }
    private static void Load_program()  {
    try {
        File file = new File("file.txt");
        Scanner reader = new Scanner(file);
        while (reader.hasNext()) {
            String data = reader.nextLine();
            System.out.println(data+"\n");
        }
    }catch(FileNotFoundException e){
        System.out.println("error occured!");
        e.printStackTrace();
    }


    }

    /**
     * Bubble sort is used in order_passenger method to arrange customers alphbatically
     */
    private static void Order_passengers(){
        for (int i = 0; i < cabins.length; i++) {
            for (int j = i+1; j < cabins.length; j++) {
                if (cabins[i].compareToIgnoreCase(cabins[j])>0){
                    String temp = cabins[i];
                    cabins[i]=cabins[j];
                    cabins[j]=temp;

                }

            }

        }


        for (int x = 0; x < 12; x++ )
        {
            if (!cabins[x].equals("e")){
                System.out.println("room " + (x+1) + " occupied by " + cabins[x]);
            }
            else{
                System.out.println("room "+ (x+1)+" is empty ");
            }
        }

        }


}
