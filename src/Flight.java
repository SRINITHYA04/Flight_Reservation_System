import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class Flight {
    private String flightName;
    private int capacity =50;
    private int ticketPrice =5000;

    public Flight(String name){
        this.flightName = name.toLowerCase();
    }

    public String getFlightName(){ return flightName; }


    public void DisplayFlightDetails(){
        System.out.println("Flight name:"+ flightName);
        System.out.println("No. of seats available: "+capacity);
        System.out.println("Current Ticket Price: "+ ticketPrice);

    }


    public boolean isAvailable(int seatCount) { return seatCount < capacity; }

    public void increasePrice(int seatsCount) { ticketPrice += seatsCount*200; }
    public void decreasePrice(int seatsCount) { ticketPrice -= seatsCount*200; }

    public void reduceSeatCount(int seatsCount) { capacity -=seatsCount; }
    public void increaseSeatCount(int seatsCount) { capacity +=seatsCount; }
}
