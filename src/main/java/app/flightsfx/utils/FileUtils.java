package app.flightsfx.utils;

import app.flightsfx.model.Flight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /*The structure of the text file containing the flight information (flights.txt) will be as follows:
        flight_number;destination;departure;duration
        For instance:
        IB601N;Oviedo;28/10/2017 11:33;0:50
        RY112A;Edinburgh;31/10/2017 16:05;2:35
        where the attributes are separated by ';'
        You can add as many classes as you need inside this package.*/


    //to load flights from a given text file
    public static List<Flight> loadFlights() {
        List<Flight> flights = new ArrayList<>();
        try (BufferedReader inputFile = new BufferedReader(new FileReader(new File("flights.txt")))) {
            String line = null;
            while (null != (line = inputFile.readLine())) {
                System.out.println(line);
                flights.add(flightFromTextLine(line));
                System.out.println(line);
            }
        } catch (IOException fileError) {
            System.err.println("Error reading file: " + fileError.getMessage());
        }

        return flights;
    }

    //to save a list of flights in a text file
    public static void saveFlights(List<Flight> flights) {

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("flights.txt", true)));

            for (Flight f : flights) {
                printWriter.println(f);
            }

        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public static boolean saveFlightsTest(List<Flight> flights) {

        boolean saved = false;
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("flights.txt", true)));

            for (Flight f : flights) {
                printWriter.println(f);
            }

            saved = true;
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            saved = false;
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

        return saved;
    }

    public static Flight flightFromTextLine(String flightString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy" +
                " HH:mm");
        String[] s = flightString.split(";");
        String flightNumber = s[0];
        String destination = s[1];
        LocalDateTime departure = LocalDateTime.parse(s[2], formatter);
        LocalTime duration = LocalTime.parse(s[3]);

        return new Flight(flightNumber, destination, departure, duration);
    }
}
