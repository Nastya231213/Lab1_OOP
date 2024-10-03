package com.menu;

import com.service.TripParser;
import com.service.TripService;
import com.tourist_trips.Trip;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        TripService tripService = new TripService();
        List<Trip> allTrips = TripParser.getAllTrips();
        for (Trip trip : allTrips) {
            tripService.addTrip(trip);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Trip Selection Console!");
        System.out.println("Here are the available trips:");

        for (Trip trip : allTrips) {
            System.out.println(trip);
        }

        System.out.println("\nWould you like to filter trips by:");
        System.out.println("1. Transport Type");
        System.out.println("2. Food Type");
        System.out.println("3. Number of Days");
        System.out.println("4. No sorting");
        int filterChoice = scanner.nextInt();
        scanner.nextLine();

        String transport = null;
        String food = null;
        int days = 0;

        switch (filterChoice) {
            case 1:
                System.out.println("Enter transport type (e.g., Flight, Train, Bus):");
                transport = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter food type (e.g., All-Inclusive, Breakfast Included):");
                food = scanner.nextLine();
                break;
            case 3:
                System.out.println("Enter number of days:");
                days = scanner.nextInt();
                scanner.nextLine();
                break;
            default:
                System.out.println("No filter selected.");
        }

        List<Trip> filteredTrips = tripService.filterTrips(transport, food, days);

        System.out.println("\nWould you like to sort trips by:");
        System.out.println("1. Number of Days (Ascending)");
        System.out.println("2. Number of Days (Descending)");
        System.out.println("3. No Sorting");
        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1:
                filteredTrips = tripService.sortTripsByDays(true);
                break;
            case 2:
                filteredTrips = tripService.sortTripsByDays(false);
                break;
            default:
                System.out.println("No sorting selected.");
        }

        System.out.println("\nHere are the filtered and sorted trips:");
        for (Trip trip : filteredTrips) {
            System.out.println(trip);
        }
    }
}
