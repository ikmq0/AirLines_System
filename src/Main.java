import java.util.Scanner;
public class Main {
    // We should start our program from here
    public static void main(String[] args) {
        Flights.initializeFlights();
        Scanner kb = new Scanner(System.in);

        System.out.println(CommandColors.GREEN + "Welcome to AirLINE Reservation System " + CommandColors.RESET);
        System.out.println(CommandColors.GREEN + "Lets Book a flight together!! " + CommandColors.RESET);

        int option = 0;
        while (true) {
            System.out.println(CommandColors.WHITE + "1. Book Now" + CommandColors.RESET);
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
                System.out.println(CommandColors.RED + "Invalid input. Please enter a number." + CommandColors.RESET);
                kb.next();
            }
        }

        if (option == 1) {
            bookFlight(kb);
        } else {
            System.out.println(CommandColors.WHITE + "Please enter your reservation number" + CommandColors.RESET);
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
            System.out.print(CommandColors.WHITE + " 2. Dammam(DMM) \n 3. Jeddah(JED) \n 4. Madina(MED)\nSelect an option:" + CommandColors.RESET);
            departureCity = "RUH";
        } else if (departureOption == 2) {
            System.out.println(CommandColors.WHITE + "\nEnter Arrival City " + CommandColors.RESET);
            System.out.print(CommandColors.WHITE + " 1. Riyadh(RUD) \n 3. Jeddah(JED) \n 4. Madina(MED)\nSelect an option:" + CommandColors.RESET);
            departureCity = "DMM";
        } else if (departureOption == 3) {
            System.out.println(CommandColors.WHITE + "\nEnter Arrival City " + CommandColors.RESET);
            System.out.print(CommandColors.WHITE + " 1. Riyadh(RUD) \n 2. Dammam(DMM) \n 4. Madina(MED)\nSelect an option:" + CommandColors.RESET);
            departureCity = "JED";
        } else if (departureOption == 4) {
            System.out.println(CommandColors.WHITE + "\nEnter Arrival City " + CommandColors.RESET);
            System.out.print(CommandColors.WHITE + " 1. Riyadh(RUD) \n 2. Dammam(DMM) \n 3. Jeddah(JED)\nSelect an option:" + CommandColors.RESET);
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
                    System.out.println(CommandColors.WHITE + "Invalid option. Please enter a valid arrival city." + CommandColors.RESET);
                }
            } else {
                System.out.println(CommandColors.RED + "Invalid input. Please enter a number." + CommandColors.RESET);
                kb.next();
            }
        }
        System.out.println(Flights.searchForFlightsWArrivalAndDeparture(departureCity,arrivalCity));
    }
}