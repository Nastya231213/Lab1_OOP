package com.service;

import com.tourist_trips.Trip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TripService {
    private List<Trip> trips;

    public TripService() {
        this.trips = new ArrayList<>();
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public List<Trip> filterTrips(String transport, String food, int days) {
        return trips.stream()
                .filter(trip -> (transport == null || trip.getTransport().equalsIgnoreCase(transport)))
                .filter(trip -> (food == null || trip.getFood().equalsIgnoreCase(food)))
                .filter(trip -> (days == 0 || trip.getDays() == days))
                .collect(Collectors.toList());
    }
    public List<Trip> sortTripsByDays(boolean ascending) {
        trips.sort(Comparator.comparingInt(Trip::getDays));
        if (!ascending) {
            Collections.reverse(trips);
        }
        return trips;
    }

    public List<Trip> sortTripsByTransport() {
        trips.sort(Comparator.comparing(Trip::getTransport));
        return trips;
    }

    public List<Trip> sortTripsByFood() {
        trips.sort(Comparator.comparing(Trip::getFood));
        return trips;
    }

}

