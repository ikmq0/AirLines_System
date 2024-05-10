import java.util.Scanner;
public class Main {
    // We should start our program from here
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println(CommandColors.GREEN + "Welcome to AirLINE Reservation System " + CommandColors.RESET);
        System.out.println(CommandColors.GREEN + "Lets Book a flight together!! " + CommandColors.RESET);

        int option = 0;
        while (true) {
            System.out.println(CommandColors.BLUE + "1. Book Now" + CommandColors.RESET);
            System.out.println(CommandColors.BLUE + "2. Manage Booking" + CommandColors.RESET);
            System.out.println(CommandColors.BLUE + "Select an option: " + CommandColors.RESET);

            if (kb.hasNextInt()) {
                option = kb.nextInt();
                if (option == 1 || option == 2) {
                    break;
                } else {
                    System.out.println(CommandColors.BLUE + "Invalid option. Please enter 1 or 2." + CommandColors.RESET);
                }
            } else {
                System.out.println(CommandColors.BLUE + "Invalid input. Please enter a number." + CommandColors.RESET);
                kb.next();
            }
        }
        if (option == 1) {
            System.out.println(CommandColors.WHITE + "Enter Departure City " + CommandColors.RESET);
            System.out.println(CommandColors.WHITE + " (1) Riyad(RUD) \n (2) Dammam(DMM) \n (3) Jeddah(JDD) \n (4) Madina(MED)" + CommandColors.RESET);
        }
    }
    }