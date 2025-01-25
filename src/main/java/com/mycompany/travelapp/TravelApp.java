package com.mycompany.travelapp;

/**
 *
 * @author Dhairya Pal N01576099
 */
import java.util.Scanner;
import java.util.ArrayList;

public class TravelApp {
    static int confirmation_number; //Variable to store the confirmation number when user types it
    static int choice; //Variable to store user's choice (1 for booking and 2 for cancelling
    static ArrayList<Flight> flights = new ArrayList<>();
    
    static String cityOrigin;
    static String cityDestination;
    static String passengerName;
    static String date;

    public static void main(String[] args) {   
        Scanner scanner = new Scanner(System.in); //Scanner object to take input from the user
        
        while (true){
            //Asks whether the user wants to book or cancel a flight
            System.out.print("Welcome to Flight booking/cancellation system!\nPlease enter:\n");
            System.out.println("1 for booking a flight,");
            System.out.println("2 for cancelling a flight");        
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 2) {
                System.out.print("Please enter the confirmation number of your booking: ");
                confirmation_number = scanner.nextInt();
                scanner.nextLine();
                boolean found = false; //Variable to store whether the flight was found or not
                for (int i = 0; i < flights.size(); i++) {
                    if (confirmation_number == flights.get(i).confirmationNumber) {
                        found = true;
                        System.out.printf("Flight details:\n%s is travelling from %s to %s on %s. The seat costs $%.2f.\n", flights.get(i).passengerName, flights.get(i).originCity, flights.get(i).destinationCity, flights.get(i).date, flights.get(i).price);
                        System.out.println("Are you sure you want to cancel this booking? Type 0 for no, any other number for yes: ");
                        int remove_choice = scanner.nextInt(); //Variable to store user's choice
                        scanner.nextLine();
                        if (remove_choice == 0) {
                            System.out.println("Flight cancelling aborted! Returning to the main menu...");
                            break;
                        }
                        else {
                            flights.remove(i);
                            System.out.println("Flight was cancelled successfully! Returning to the main menu...");
                            break;
                        }
                    }
                }
                if (!found) { System.out.println("Flight wasn't found! Returning to the main menu..."); }
            }

            else if (choice == 1) {
                System.out.print("Please enter the city of departure: ");
                cityOrigin = scanner.nextLine();
                System.out.print("Please enter the city of landing: ");
                cityDestination = scanner.nextLine();
                System.out.print("Please enter the travel date: ");
                date = scanner.nextLine();
                System.out.print("Please enter the passenger name: ");
                passengerName = scanner.nextLine();

                Flight flight = new Flight();
                flight.setDate(date);
                flight.setPassengerName(passengerName);
                flight.setOriginCity(cityOrigin);
                flight.setDestinationCity(cityDestination);

                System.out.println("Flight successfully booked! Please note the following details:");
                System.out.println("Confirmation number: " + flight.confirmationNumber);
                System.out.println("Price: " + flight.price);            

                flights.add(flight);
            }
        }
    }
}
