import java.util.*;

public class BookingSystem {
    public static void main(String[] args) {

        ArrayList<Booking> bookings = new ArrayList<>();
        ArrayList<Flight> flights = new ArrayList<>();
         flights.add(new Flight("Indigo"));
         flights.add(new Flight("SpiceJet"));

         Scanner sc = new Scanner(System.in);
         int userOption = 1;

         while(userOption != 4) {
             System.out.println("Flight booking System.");
             System.out.println("1. Ticket Booking.");
             System.out.println("2. Ticket Cancellation.");
             System.out.println("3. Print Flight Details.");
             System.out.println("4. Exit.");

             System.out.println("Enter your choice:");
             userOption = sc.nextInt();

             if (userOption == 1) {
                 for (Flight f : flights) {
                     System.out.print(f.getFlightName() + " - ");
                 }
                 System.out.println();
                 System.out.println("Enter the flight name:");
                 String flightName = sc.next().toLowerCase();
                 boolean found = false;

                 for (Flight f : flights) {

                     if (f.getFlightName().equalsIgnoreCase(flightName)) {
                         f.DisplayFlightDetails();
                         Booking book = new Booking(flightName);
                         if (f.isAvailable(book.getSeatsCount())) {
                             bookings.add(book);
                             f.increasePrice(book.getSeatsCount());
//                             f.increasePrice(bookings.size());
                             f.reduceSeatCount(book.getSeatsCount());
                             System.out.println("Booking added Successfully for BookingId : " + book.getBookingID());
                         } else {
                             System.out.println("Sorry No seats Available");
                         }
                         found = true;
                         break;
                     }
                 }
                 if (!found) {
                     System.out.println("Please enter a valid Flight Name!!!");
                 }
             } else if (userOption == 2) {
                 for (Flight f : flights) {
                     System.out.print(f.getFlightName() + " - ");
                 }
                 System.out.println();
                 System.out.println("Enter the flight name:");
                 String flightName = sc.next().toLowerCase();
                 boolean flightFound = false;
                 boolean bookingFound = false;

                 for (Flight f : flights) {
                     if (f.getFlightName().equalsIgnoreCase(flightName)) {
                         flightFound = true;
                         System.out.println("Enter thr Booking ID:");
                         String id = sc.next().toUpperCase();
                         for (Booking b : bookings) {
                             if (b.getBookingID().equalsIgnoreCase(id)) {
                                 bookingFound = true;
                                 f.increaseSeatCount(b.getSeatsCount());
                                 f.decreasePrice(b.getSeatsCount());
                                 bookings.remove(b);
                                 System.out.println("Booking Cancelled successfully.. Refund issued for " + b.getSeatsCount() + " seat.");
                             }
                         }
                         if (!bookingFound) {
                             System.out.println("No Bookings Found for BookingID: " + id);
                         }
                     }
                 }
                 if (!flightFound) {
                     System.out.println("Enter a valid Flight name!!");
                 }
             }

             else if (userOption == 3) {
                 for (Flight f : flights) {
                     System.out.print(f.getFlightName() + " - ");
                 }
                 System.out.println();
                 System.out.println("Enter the flight name:");
                 String flightName = sc.next().toLowerCase();
                 boolean flightFound = false;
                 boolean bookingFound = false;

                 for (Flight f : flights) {
                     if (f.getFlightName().equalsIgnoreCase(flightName)) {
                         flightFound = true;
                         f.DisplayFlightDetails();
                         for (Booking b : bookings) {
                             if (b.getFlightName().equalsIgnoreCase(flightName)) {
                                 bookingFound =true;
                                 System.out.println(b);
                             }
                         }
                         if (!bookingFound) {
                             System.out.println("No Bookings Available for the Flight.");
                         }
                     }
                 }
                 if (!flightFound) {
                     System.out.println("Please Enter a valid Flight name!!");
                 }
             }

             if(userOption ==4){
                 System.out.println("Exiting.....");
                 System.exit(0);
             }
         }
    }
}