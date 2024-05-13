import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Reservations extends Main {
    public static ArrayList<Reservation> reservationArrayList = readFile("reservations.dat");
    static Random random = new Random();
    public static void writeInFile(String fileExtension){
        try {
            FileOutputStream location = new FileOutputStream(fileExtension);
            ObjectOutputStream writer = new ObjectOutputStream(location);
            writer.writeObject(reservationArrayList);
            writer.close();
            location.close();
        } catch (IOException ioe) {
            System.out.println("Error saving the file !! ");
        }
    }
    static ArrayList<Reservation> list = null;
    public static ArrayList<Reservation> readFile(String fileExtension){
        try {
            FileInputStream location = new FileInputStream(fileExtension);
            ObjectInputStream reader = new ObjectInputStream(location);
            list = (ArrayList<Reservation>) reader.readObject();
            reader.close();
            return list;
        } catch (IOException ioe) {
            System.out.println("Error reading the file !! ");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found !! ");

        }
        return null;
    }
    public static class Reservation extends Reservations implements Serializable {
        ArrayList<Ticket> ticketsList;
        private long reservationNumber;

        public Reservation(ArrayList<Ticket> ticketsList, long reservationNumber) {
            this.ticketsList = ticketsList;
            this.reservationNumber = reservationNumber;
        }

        public Reservation() {
        }
        public ArrayList<Ticket> getTicketsList() {
            return ticketsList;
        }

        public long getReservationNumber() {
            return reservationNumber;
        }

        @Override
        public String toString() {
            return "Reservation{" +
                    "ticketsList=" + ticketsList +
                    ", reservationNumber=" + reservationNumber +
                    '}';
        }
    }


    public static Reservation createNewReservation(){
        long generatedNumber =random.nextLong(1000,9999);
        while(SearchForReservation(generatedNumber) != null) {
            generatedNumber =random.nextLong(1000,9999);
        }

        return new Reservation(new ArrayList<>(),generatedNumber);

    }

    public static Reservation SearchForReservation(long number) {
        for(Reservation r : Reservations.reservationArrayList) {
            if (r.getReservationNumber() == number) return r;
        }
        return null;
    }


}