package com.tests;

import com.service.TripParser;
import com.service.TripService;
import com.tourist_trips.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripServiceTest {

    private TripService tripService;

    @BeforeEach
    void setUp() {
        tripService = new TripService();

        // Load trips from TripParser
        List<Trip> trips = TripParser.getAllTrips();
        for (Trip trip : trips) {
            tripService.addTrip(trip);
        }
    }

    @Test
    void testFilterTripsByTransport() {
        // Example of filtering trips by transport
        List<Trip> filteredTrips = tripService.filterTrips("Bus", null, 0);
        assertFalse(filteredTrips.isEmpty(), "Filtered trips should not be empty");

        for (Trip trip : filteredTrips) {
            assertEquals("Bus", trip.getTransport(), "All trips should have Bus transport");
        }
    }

    @Test
    void testFilterTripsByFood() {
        // Example of filtering trips by food
        List<Trip> filteredTrips = tripService.filterTrips(null, "Breakfast included", 0);
        assertFalse(filteredTrips.isEmpty(), "Filtered trips should not be empty");

        for (Trip trip : filteredTrips) {
            assertEquals("Breakfast included", trip.getFood(), "All trips should have Vegetarian food");
        }
    }

    @Test
    void testSortTripsByDaysAscending() {
        List<Trip> sortedTrips = tripService.sortTripsByDays(true);

        for (int i = 0; i < sortedTrips.size() - 1; i++) {
            assertTrue(sortedTrips.get(i).getDays() <= sortedTrips.get(i + 1).getDays(),
                    "Trips should be sorted in ascending order by days");
        }
    }

    @Test
    void testSortTripsByDaysDescending() {
        List<Trip> sortedTrips = tripService.sortTripsByDays(false);

        for (int i = 0; i < sortedTrips.size() - 1; i++) {
            assertTrue(sortedTrips.get(i).getDays() >= sortedTrips.get(i + 1).getDays(),
                    "Trips should be sorted in descending order by days");
        }
    }

    @Test
    void testSortTripsByTransport() {
        List<Trip> sortedTrips = tripService.sortTripsByTransport();

        for (int i = 0; i < sortedTrips.size() - 1; i++) {
            assertTrue(sortedTrips.get(i).getTransport().compareTo(sortedTrips.get(i + 1).getTransport()) <= 0,
                    "Trips should be sorted in alphabetical order by transport");
        }
    }
}