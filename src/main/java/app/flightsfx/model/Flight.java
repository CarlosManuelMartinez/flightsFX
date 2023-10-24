package app.flightsfx.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departure;
    private LocalTime duration;

    public Flight(String number, String destination, LocalDateTime departure,
                  LocalTime duration) {
        this.flightNumber = number;
        this.destination = destination;
        this.departure = departure;
        this.duration = duration;
    }

    public Flight(String number) {
        this.flightNumber = number;
    }

    public String toString() {
        String flightString = "";
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM" + "/yyyy");
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");
        String departure = this.departure.format(formatterDate);
        String duration = this.departure.format(formatterHour);
        flightString =
                this.flightNumber + ";" + this.destination + ";" + departure + ";" + this.duration;
        return flightString;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
