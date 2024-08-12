import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
public class Main {
    // We should start our program from here
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.println(CommandColors.PURPLE + "Welcome to AirLINE Reservations System " + CommandColors.RESET);
            System.out.println(CommandColors.PURPLE + "Lets Book a flight together!! " + CommandColors.RESET);
            int option = 0;
            while (true) {
                System.out.println(CommandColors.WHITE + "\n1. Book Now" + CommandColors.RESET);
                System.out.println(CommandColors.WHITE + "2. Display Booking" + CommandColors.RESET);
                System.out.print(CommandColors.WHITE + "Select an option: " + CommandColors.RESET);
                if (kb.hasNextInt()) {
                    option = kb.nextInt();
                    if (option == 1 || option == 2) {
                        break;
                    } else {
                        System.out.println(CommandColors.RED + "Invalid option. Please enter 1 or 2." + CommandColors.RESET);
                    }
                } else {
                    System.out.println(CommandColors.RED + "Invalid input. Please enter a number: " + CommandColors.RESET);
                    kb.next();
                }
            }

            if (option == 1) {
                bookFlight(kb);
            } else {
                displayBooking(kb);
            }
        }


    }

    public static void bookFlight(Scanner kb) {
        int departureOption = 0;
        String departureCity = null;
        while (true) {
            System.out.println(CommandColors.WHITE + "\nEnter Departure City " + CommandColors.RESET);
            System.out.print(CommandColors.WHITE + "1. Riyadh(RUH) \n2. Dammam(DMM) \n3. Jeddah(JED) \n4. Madina(MED)\nSelect an option: " + CommandColors.RESET);

            if (kb.hasNextInt()) {
                departureOption = kb.nextInt();
                if (departureOption >= 1 && departureOption <= 4) {
                    break;
                } else {
                    System.out.println(CommandColors.WHITE + "Invalid option. Please enter a number between 1 and 4." + CommandColors.RESET);
                }
            } else {
                System.out.println(CommandColors.WHITE + "Invalid input. Please enter a number." + CommandColors.RESET);
                kb.next();
            }
        }

        if (departureOption == 1) {
            System.out.println(CommandColors.WHITE + "\nEnter Arrival City " + CommandColors.RESET);
            System.out.print(CommandColors.WHITE + " 2. Dammam(DMM) \n 3. Jeddah(JED) \n 4. Madina(MED)\nSelect an option: " + CommandColors.RESET);
            departureCity = "RUH";
        } else if (departureOption == 2) {
            System.out.println(CommandColors.WHITE + "\nEnter Arrival City " + CommandColors.RESET);
            System.out.print(CommandColors.WHITE + " 1. Riyadh(RUH) \n 3. Jeddah(JED) \n 4. Madina(MED)\nSelect an option: " + CommandColors.RESET);
            departureCity = "DMM";
        } else if (departureOption == 3) {
            System.out.println(CommandColors.WHITE + "\nEnter Arrival City " + CommandColors.RESET);
            System.out.print(CommandColors.WHITE + " 1. Riyadh(RUH) \n 2. Dammam(DMM) \n 4. Madina(MED)\nSelect an option: " + CommandColors.RESET);
            departureCity = "JED";
        } else if (departureOption == 4) {
            System.out.println(CommandColors.WHITE + "\nEnter Arrival City " + CommandColors.RESET);
            System.out.print(CommandColors.WHITE + " 1. Riyadh(RUH) \n 2. Dammam(DMM) \n 3. Jeddah(JED)\nSelect an option: " + CommandColors.RESET);
            departureCity = "MED";
        }
        int arrivalOption =0;
        String arrivalCity = null;
        while (true) {
            if (kb.hasNextInt()) {
                arrivalOption = kb.nextInt();
                if (arrivalOption == 1) {arrivalCity = "RUH"; } else if (arrivalOption == 2) { arrivalCity = "DMM";}
                else if (arrivalOption == 3) { arrivalCity = "JED";} else if (arrivalOption == 4) { arrivalCity = "MED";}
                if ((departureOption == 1 && arrivalOption >= 2 && arrivalOption <= 4) ||
                        (departureOption == 2 && (arrivalOption == 1 || arrivalOption == 3 || arrivalOption == 4)) ||
                        (departureOption == 3 && (arrivalOption == 1 || arrivalOption == 2 || arrivalOption == 4)) ||
                        (departureOption == 4 && (arrivalOption == 1 || arrivalOption == 2 || arrivalOption == 3))) {
                    break;
                } else {
                    System.out.print(CommandColors.RED + "Invalid option. Please enter a valid arrival city: " + CommandColors.RESET);
                }
            } else {
                System.out.print(CommandColors.RED + "Invalid input. Please enter a number: " + CommandColors.RESET);
                kb.next();
            }
        }
        ArrayList<Flights.Flight> availableFlights = Flights.searchForFlightsWArrivalAndDeparture(departureCity,arrivalCity);
        int flightNumber;
        Flights.Flight selectedFlight;
        while (true) {
            for (Flights.Flight flight: availableFlights) {
                System.out.printf("\nFlight Number: %10s\n",flight.getFlightNumber());
                System.out.printf("%s ==> %s\n",flight.getDepartureCity(),flight.getArrivalCity());
                System.out.printf("%s ==> %s\n\n",flight.getDepartureDate_Time().toString().substring(0,16),flight.getArrivalDate_Time().toString().substring(0,16));
            }
            System.out.print("Enter the number of the flight you want: ");
            flightNumber = kb.nextInt();
            selectedFlight = Flights.searchByFlightNumber(flightNumber,availableFlights);
            if (selectedFlight == null) {
                System.out.println(CommandColors.RED + "Please enter valid flight number! " + CommandColors.RESET);
                continue;
            }
            break;

        }
        int numberOfPassenger;
        while (true) {
            System.out.print("Enter the number of passengers (0< ): ");
            if (kb.hasNextInt()) {
                numberOfPassenger = kb.nextInt();
                if(numberOfPassenger > 0 && numberOfPassenger <= 20) {
                    break;
                } else {
                    System.out.println(CommandColors.RED + "Invalid input, make sure it's between 1 and 20" + CommandColors.RESET);
                }
            } else {
                System.out.println(CommandColors.RED + "Invalid input, enter a number." + CommandColors.RESET);
            }

        }
        Reservations.Reservation currentReservation = Reservations.createNewReservation();

        for (int i = 1;i <= numberOfPassenger;i++){
            System.out.printf("Passenger %s First Name: ",i);
            String passengerFName = kb.next();
            kb.nextLine();
            System.out.printf("Passenger %s Last Name: ",i);
            String passengerLName = kb.nextLine();
            int passengerAge;
            while(true){
                System.out.printf("Passenger %s Age: ",i);
                if(kb.hasNextInt()) {
                    passengerAge = kb.nextInt();
                    if (passengerAge >=18 && passengerAge < 90) {
                        break;
                    } else {
                        System.out.println(CommandColors.RED + "Invalid input. ensure that age between 18 and 90" + CommandColors.RESET);
                    }
                } else {
                    System.out.println(CommandColors.RED + "Invalid input, enter an integer." + CommandColors.RESET);
                    kb.next();
                }

            }
            System.out.printf("Passenger %s Passport Number: ",i);
            String passengerPass = kb.next();


            Flights.printSeatsMap(selectedFlight);
            String selectedSeat;
            Flights.Flight.Seat classSeat;
            while (true){
                System.out.print("Select your seat: ");
                selectedSeat = kb.next();
                ArrayList<Character> characters = new ArrayList<Character>();
                characters.add('A'); characters.add('B'); characters.add('C'); characters.add('D');
                boolean specialCondition = selectedSeat.length() == 2 && characters.contains(selectedSeat.charAt(0)) && Integer.parseInt(selectedSeat.substring(1,2)) <=4 && Integer.parseInt(selectedSeat.substring(1,2)) >=1;
                if (specialCondition) {
                    char column = selectedSeat.charAt(0);
                    int row = Integer.parseInt(selectedSeat.substring(1));
                    classSeat = Flights.SearchForSeatByColumn(column,row,selectedFlight);
                    if(classSeat.isAvailable()) {
                        Flights.makeSeatUnavailable(column,row,selectedFlight.getFlightNumber());
                        break;
                    } else {
                        System.out.println(CommandColors.RED + "Invalid input. Enter available seat" + CommandColors.RESET);
                    }
                } else {
                    System.out.println(CommandColors.RED + "Invalid input. Check your input please" + CommandColors.RESET);
                }


            }

            currentReservation.ticketsList.add(new Ticket(passengerFName,passengerLName,passengerAge,passengerPass,selectedFlight,classSeat));

        }
        Reservations.reservationArrayList.add(currentReservation);
        System.out.println(CommandColors.GREEN +"\nThanks for using our AirLines System!" + CommandColors.RESET);
        System.out.printf(CommandColors.GREEN + "Your Reservation Number:"+ CommandColors.BLUE +" %10s\n\n" + CommandColors.RESET,currentReservation.getReservationNumber());
        Flights.writeInFile("flights.dat");
        Reservations.writeInFile("reservations.dat");


    }

    public static void displayBooking(Scanner kb) {
        System.out.print("Enter your reservation Number: ");
        if(kb.hasNextLong()) {
            long reservationNumber = kb.nextLong();
            Reservations.Reservation reservation = Reservations.SearchForReservation(reservationNumber);
            if (reservation != null) {
                System.out.println("___________________________________");
                System.out.printf(CommandColors.GREEN + "Your Reservation Number:"+ CommandColors.BLUE +" %10s\n" + CommandColors.RESET,reservation.getReservationNumber());
                for (int i = 1; i <= reservation.getTicketsList().size();i++) {
                    Ticket ticket = reservation.getTicketsList().get(i-1);
                    System.out.printf("\nPassenger %s: \n",i);
                    System.out.printf("Name: %-5s\n",ticket.getPassengerLastName() +", " +ticket.getPassengerFirstName());
                    System.out.printf("Age: %-5s\n",ticket.getPassengerAge());
                    System.out.printf("Passport Number: %-5s\n",ticket.getPassportNumber());
                    System.out.printf("Flight Number: %-5s\n",ticket.getFlight().getFlightNumber());
                    System.out.printf("Gate Number: %-5s\n",ticket.getFlight().getGateNumber());
                    System.out.printf("Seat: %s%s\n",ticket.getSeat().getColumn(),ticket.getSeat().getRow());
                    System.out.println("___________________________________");
                }

            } else {
                System.out.println(CommandColors.RED + " We couldn't find a reservation with that reference" + CommandColors.RESET);
            }
        } else {
            System.out.println(CommandColors.RED + "Invalid input. Please enter a valid number" + CommandColors.RESET);
        }
    }
}
