package com.service;

import com.tourist_trips.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TripParser {
    static public List<Trip> getAllTrips(){
        return parseTrips("src/resources/trips.xml");
    }

    static private List<Trip> parseTrips(String filePath) {
        List<Trip> trips = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File xmlFile = new File(filePath);
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList tripList = doc.getElementsByTagName("Trip");

            for (int i = 0; i < tripList.getLength(); i++) {
                Node tripNode = tripList.item(i);
                if (tripNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element tripElement = (Element) tripNode;

                    Trip trip = createTripFromElement(tripElement);
                    if (trip != null) {
                        trips.add(trip);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trips;
    }

    static private Trip createTripFromElement(Element tripElement) {
        Trip trip = null;

        String destination = tripElement.getElementsByTagName("Destination").item(0).getTextContent();
        int days = Integer.parseInt(tripElement.getElementsByTagName("Days").item(0).getTextContent());
        String transport = tripElement.getElementsByTagName("Transport").item(0).getTextContent();
        String food = tripElement.getElementsByTagName("Food").item(0).getTextContent() ;

        if (tripElement.getElementsByTagName("Vacation").getLength() > 0) {
            trip = new VacationTrip();
            setCommonTripDetails(trip, destination, days, transport, food);

            Element vacation = (Element) tripElement.getElementsByTagName("Vacation").item(0);
            ((VacationTrip) trip).setResortType(vacation.getElementsByTagName("ResortType").item(0).getTextContent());
            ((VacationTrip) trip).setStarRating(Integer.parseInt(vacation.getElementsByTagName("StarRating").item(0).getTextContent()));
            ((VacationTrip) trip).setBeachAccess(Boolean.parseBoolean(vacation.getElementsByTagName("BeachAccess").item(0).getTextContent()));

        } else if (tripElement.getElementsByTagName("Excursion").getLength() > 0) {
            trip = new ExcursionTrip();
            setCommonTripDetails(trip, destination, days, transport, food);

            Element excursion = (Element) tripElement.getElementsByTagName("Excursion").item(0);
            ((ExcursionTrip) trip).setGuideIncluded(Boolean.parseBoolean(excursion.getElementsByTagName("GuideIncluded").item(0).getTextContent()));
            ((ExcursionTrip) trip).setExcursionDuration(Integer.parseInt(excursion.getElementsByTagName("ExcursionDuration").item(0).getTextContent()));

            NodeList landmarks = excursion.getElementsByTagName("LandmarksCovered");
            for (int j = 0; j < landmarks.getLength(); j++) {
                ((ExcursionTrip) trip).getLandmarksCovered().add(landmarks.item(j).getTextContent());
            }

        } else if (tripElement.getElementsByTagName("Treatment").getLength() > 0) {
            trip = new TreatmentTrip();
            setCommonTripDetails(trip, destination, days, transport, food);

            Element treatment = (Element) tripElement.getElementsByTagName("Treatment").item(0);
            ((TreatmentTrip) trip).setMedicalProgram(treatment.getElementsByTagName("MedicalProgram").item(0).getTextContent());
            ((TreatmentTrip) trip).setDoctorConsultationIncluded(Boolean.parseBoolean(treatment.getElementsByTagName("DoctorConsultationIncluded").item(0).getTextContent()));
            ((TreatmentTrip) trip).setNumberOfTherapies(Integer.parseInt(treatment.getElementsByTagName("NumberOfTherapies").item(0).getTextContent()));

        } else if (tripElement.getElementsByTagName("Shopping").getLength() > 0) {
            trip = new ShoppingTrip();
            setCommonTripDetails(trip, destination, days, transport, food);

            Element shopping = (Element) tripElement.getElementsByTagName("Shopping").item(0);
            ((ShoppingTrip) trip).setShoppingCenter(shopping.getElementsByTagName("ShoppingCenter").item(0).getTextContent());
            ((ShoppingTrip) trip).setDiscountsAvailable(Boolean.parseBoolean(shopping.getElementsByTagName("DiscountsAvailable").item(0).getTextContent()));
            ((ShoppingTrip) trip).setNumberOfShops(Integer.parseInt(shopping.getElementsByTagName("NumberOfShops").item(0).getTextContent()));
        }

        return trip;
    }

    static private void setCommonTripDetails(Trip trip, String destination, int days, String transport, String food) {
        trip.setDestination(destination);
        trip.setDays(days);
        trip.setTransport(transport);
        trip.setFood(food);
    }

}