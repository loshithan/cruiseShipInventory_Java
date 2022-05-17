package com.loshithan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Ship {

    private static Scanner s = new Scanner(System.in);
    private static Passenger[][] passengers = new Passenger[12][3];
    private static Cabin[] cabins = new Cabin[12];
    private static CircularQueue q = new CircularQueue();


    public static void main(String[] args) {
        /**create passenger obj array and cabin obj array.
         * initialise cabin obj to cabin obj array
         */


        cabins[0] = new Cabin();
        cabins[1] = new Cabin();
        cabins[2] = new Cabin();
        cabins[3] = new Cabin();
        cabins[4] = new Cabin();
        cabins[5] = new Cabin();
        cabins[6] = new Cabin();
        cabins[7] = new Cabin();
        cabins[8] = new Cabin();
        cabins[9] = new Cabin();
        cabins[10] = new Cabin();
        cabins[11] = new Cabin();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                passengers[i][j] = new Passenger();
            }
        }

        initialise(cabins);
        menu();


    }

    /**
     * add method is used to set firstname, surname , expense to each passenger and for loops
     * are labelled to break the loop if needed
     * @param passengers
     * @param cabins
     * @exception IndexOutOfBoundsException
     **/
    public static void addPassenger(Passenger[][] passengers, Cabin[] cabins) {
        String fName;
        String sName;
        int exp;
        String clk;
        System.out.println("press Y to add to cabins or press N to add to Queue: ");
        clk = s.next();
        //below if is stated for directly inserting to queue "checking purpose only"
        if(clk.equals("y")) {
            if (Is_empty()) {
                first:
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 3; j++) {
                        try {
                            int pasNum = 0;
                            int cabinNum = 0;
                            fName = null;
                            sName = null;
                            exp = 0;
                            try {
                                System.out.println("enter cabin number: ");
                                cabinNum = s.nextInt()-1;
                                System.out.println("enter passenger number: ");
                                pasNum = s.nextInt()-1;


                                System.out.println("enter first name: ");
                                fName = s.next();
                                System.out.println("enter sur name: ");
                                sName = s.next();
                                System.out.println("enter expense: ");
                                exp = s.nextInt();
                            } catch (InputMismatchException exception) {
                                System.out.println("Input appropriate Values!!!");
                            }


                            passengers[cabinNum][pasNum].setFname(fName);
                            passengers[cabinNum][pasNum].setSname(sName);
                            passengers[cabinNum][pasNum].setExp(exp);

                            if (cabins[cabinNum].getMainname().equals("e")) {
                                System.out.println("cabin is empty");
                                System.out.println("passenger successfully set to the cabin!");
                                cabins[cabinNum].setMainame("occupied");


                            }
                            System.out.println("wanna quit press Y or press N to continue: ");
                            String x = s.next();
                            if (x.toUpperCase(Locale.ROOT).equals("Y")) {
                                break first;
                            }
                        } catch (IndexOutOfBoundsException exception) {
                            System.out.println(" cabin number should be 1-12 & passenger number should be 1-3");
                            q.enQueue(passengers[i][j]);
                            System.out.println("passenger has been added to waiting list");
                        }


                    }
                }


            } else {
                System.out.println("enter passenger detail to waiting list");
                Passenger passenger = new Passenger();

                System.out.println("enter first name: ");
                fName = s.next();
                System.out.println("enter sur name: ");
                sName = s.next();
                System.out.println("enter expense: ");
                exp = s.nextInt();
                passenger.setFname(fName);
                passenger.setSname(sName);
                passenger.setExp(exp);
                q.enQueue(passenger);
            }
        }else{
            System.out.println("enter passenger detail to waiting list");
            Passenger passenger = new Passenger();

            System.out.println("enter first name: ");
            fName = s.next();
            System.out.println("enter sur name: ");
            sName = s.next();
            System.out.println("enter expense: ");
            exp = s.nextInt();
            passenger.setFname(fName);
            passenger.setSname(sName);
            passenger.setExp(exp);
            q.enQueue(passenger);

            System.out.println("passenger added to waiting list successfully!");
        }




    }

    /**
     * view cabins methods checks the cabins name if its equal to e if empty assigns passenger to cabin
     **/
    public static void viewCabin(Cabin[] cabins, Passenger[][] passengers) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (cabins[i].getMainname().equals("e")) {
                    System.out.println("cabin " + (i+1) + " is empty");
                }
                else if (passengers[i][j].getFname().equals("empty")) {
                    System.out.println("cabin " + (i+1) + " is not full");
                } else if (cabins[i].getMainname().equals("occupied"))
                    System.out.println("cabin " + (i+1) + " is occupied by " + passengers[i][j].getFname() + " " + passengers[i][j].getSname());
            }


        }
    }

    //    public static void view(Passenger[][] passengers) {
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(passengers[i][j].getFname());
//
//
//            }
//        }
//
//
//    }
    private static void initialise(Cabin[] cabin) {
        for (int x = 0; x < 12; x++) {
            cabin[x].setMainame("e");
            for (int i = 0; i < 3; i++) {
                passengers[x][i].setFname("empty");
                passengers[x][i].setSname("empty");
                passengers[x][i].setExp(0);
            }


        }

    }

    /**
     * each passenger expense displayed by getting looping passsenger array and getexp method; sum var provided to calculate tot exp
     **/
    private static void displayExpenses(Passenger[][] passengers) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            System.out.println("cabin "+ i);
            for (int j = 0; j < 3; j++) {

                System.out.println("passenger "+ (j+1)+ " charged " + passengers[i][j].getExp());

                sum+=passengers[i][j].getExp();



            }
            System.out.println(" ");
        }
        System.out.println("Total cost of passengers is "+ sum);
    }

    /**
     * find cabin methods finds a cabin by passenger first name
     **/
    private static void findCabin(Passenger[][] passengers) {
        System.out.println("Enter passenger first name to find cabin: ");
        String cus = s.next();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (passengers[i][j].getFname().equals(cus)) {
                    System.out.println("passenger assigned in Cabin: " + (i+1));
                } else {
                    System.out.println("no passenger in the name of " + cus);
                }


            }
        }
    }

    private static void emptyCabins(Cabin[] cabins) {
        for (int i = 0; i < 12; i++) {
            if (cabins[i].getMainname().equals("e")) {
                System.out.println("cabin " + (i+1) + " is empty ");
            }
        }
    }

    private static void Store_program(Passenger[][] passengers) {

        File file = new File("file.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("file created:" + file.getName());
            } else {
                System.out.println("file doesn't exist !");

            }
            FileWriter fw = new FileWriter("file.txt");
            firstLoop:
            for (int x = 0; x < 12; x++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println("do you want to quit this program? press y else press n");
                    String opt = s.next();
                    if (opt.toUpperCase(Locale.ROOT) == "Y") {
                        break firstLoop;
                    } else {

                        System.out.println("enter cabin number: ");
                        int cabinNum = s.nextInt()-1;
                        System.out.println("enter passenger number: ");
                        int pasNum = s.nextInt()-1;
                        if (passengers[cabinNum][pasNum].getFname().equals("empty")) {
                            System.out.println("cabin is empty enter passenger details to store");

                            System.out.println("enter first name: ");
                            String fName2 = s.next();
                            System.out.println("enter sur name: ");
                            String sName2 = s.next();
                            fw.write("cabin number " + (cabinNum+1) + " is occupied by " + fName2 + " " + sName2 + "\n");
                        } else {
                            String fName2 = passengers[cabinNum][pasNum].getFname();
                            String sName2 = passengers[cabinNum][pasNum].getSname();
                            fw.write("cabin number " + (cabinNum+1) + " occupied by " + fName2 + " " + sName2 + "\n");
                        }
                        fw.close();
                    }


                }

            }

        } catch (IOException e) {
            System.out.println("error occured!");
            e.printStackTrace();
        }


    }

    private static void menu() {

        String choice;
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
            System.out.println("T: Display Expenses");
            System.out.println("X : To exit program");
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("Enter option: ");
            choice = s.next().toUpperCase(Locale.ROOT);
            switch (choice) {
                case "A" -> addPassenger(passengers, cabins);
                case "V" -> viewCabin(cabins, passengers);
                case "E" -> emptyCabins(cabins);
                case "D" -> Delete_customer();
                case "F" -> findCabin(passengers);
                case "S" -> Store_program(passengers);
                case "L" -> Load_program();
                case "O" -> Order_passengers(passengers);
                case "T" -> displayExpenses(passengers);


            }
        } while (!choice.equals("X"));
    }

    /**
     * @param passengers
     * ordering is done by appending first names of passengers into arraylist
     * collection.sort() method from java collection is called to sort alphabatically
     **/
    private static void Order_passengers(Passenger[][] passengers) {
        ArrayList<String> listName = new ArrayList<>();


        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (passengers[i][j].getFname().equals("empty")) {
                    listName.add(passengers[i][j].getFname() + " in cabin" + (i+1));
                } else {
                    listName.add(passengers[i][j].getFname() + " is in cabin" + (i+1));
                }
            }
        }
        Collections.sort(listName);
        for (String value : listName) {

            System.out.println(value);

        }
    }

    private static void Load_program() {
        try {
            File file = new File("file.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                String data = reader.nextLine();
                System.out.println(data + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("error occured!");
            e.printStackTrace();
        }
    }

    /**
     * delete method deletes the passenger by intialising the attributes to its initial values
     **/
    private static void Delete_customer() {
        System.out.println("Enter customer's firstName to remove: ");
        String cusName = s.next();

        if (!q.isEmpty()) {

            System.out.println("press y to add a person to the space else press N : ");
            String choice = s.next();
            if (choice.toUpperCase(Locale.ROOT).equals("Y")) {
                Passenger pas = (Passenger) q.deQueue();
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (passengers[i][j].getFname().equals(cusName)) {
                            passengers[i][j] = pas;


                            System.out.println("Customer " + cusName + " is removed from cabin " + (i + 1));
                            System.out.println("Customer " + pas.getFname() + " is added to  cabin " + (i + 1));
                        }
                    }
                }
            } else {
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (passengers[i][j].getFname().equals(cusName)) {
                            passengers[i][j].setFname("empty");
                            passengers[i][j].setSname("empty");
                            passengers[i][j].setExp(0);
                            System.out.println("Customer " + cusName + " is removed from cabin " + (i + 1));

                        }


                    }
                }
            }
        } else {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 3; j++) {
                    if (passengers[i][j].getFname().equals(cusName)) {
                        passengers[i][j].setFname("empty");
                        passengers[i][j].setSname("empty");
                        passengers[i][j].setExp(0);
                        System.out.println("Customer " + cusName + " is removed from cabin " + (i + 1));


                    }
                }
            }
        }
    }
    /**
     *
     * @return  true if all cabins are empty else false
     *
     */
    private static boolean Is_empty() {
        int count = 0;
        for (int i = 0; i < 12; i++) {
            if (cabins[i].getMainname().equals("e"))
                count++;

        }
        return count == 12;

    }


}

