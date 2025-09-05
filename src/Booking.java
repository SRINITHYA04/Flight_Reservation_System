import java.util.*;
public class Booking {
    private static int customerCount=1;

    private String BookingID ="T";
    private String passengerName ;
    private int age;
    private int seatsCount;
    private String flightname;

    public Booking(String FlightName){
        Scanner sc = new Scanner(System.in);

        BookingID+=customerCount++;
        this.flightname = FlightName;

        System.out.println("Enter your name:");
        this.passengerName = sc.next().toLowerCase();

        System.out.println("Enter your age: ");
        this.age = sc.nextInt();

        System.out.println("Enter the no.of seats needed: ");
        this.seatsCount = sc.nextInt();
    }

    public int getSeatsCount() {return seatsCount;}
    public String getBookingID(){ return BookingID; }
    public String getFlightName(){ return flightname; }

    @Override
    public String toString(){
        System.out.println("Passengers: ");
        return "BooKingID :"+BookingID+", Name:"+passengerName+", Age:"+age+", seats:"+seatsCount;
    }

}
