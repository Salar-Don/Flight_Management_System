import java.util.ArrayList;
public class Flight {
    int Flight_Number;
    int Total_Seats;
    String Origin;
    String Destination;
    int Fare;
    String ArrivalTime;
    String DepartureTime;
    String AirPlane;


    public String getAirPlane() {
        return AirPlane;
    }

    public void setAirPlane(String airPlane) {
        AirPlane = airPlane;
    }
    void Display()
    {
        System.out.println("Flight No: " + Flight_Number + " From " + Origin + " To " + Destination);
        System.out.println("Departure Time : " + DepartureTime + " - Arrival Time : " + ArrivalTime + " - Date : " + Date );
        System.out.println("AirCraft Type :" + AirPlane + " - Seats : " + Total_Seats + " - Fare :" + Fare);
        System.out.println("[-----------------------]");
    }


    public Flight()
    {
        AirPlane = "";
    Flight_Number = 0;
    Total_Seats = 0;
    Fare = 0;
    Origin = "";
    Destination = "";
    ArrivalTime = "";
    DepartureTime = "";
    Date = "";

    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    String Date;


    public int getTotal_Seats() {
        return Total_Seats;
    }

    public void setTotal_Seats(int total_Seats) {
        Total_Seats = total_Seats;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public int getFare() {
        return Fare;
    }

    public void setFare(int fare) {
        Fare = fare;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }
    void setFlight_Number(int num)
    {
        Flight_Number = num;
    }
    int getFlight_Number()
    {
        return Flight_Number;
    }



}
