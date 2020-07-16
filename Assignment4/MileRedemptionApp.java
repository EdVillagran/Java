import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/****************************************************************
 *                                                              *
 *  CSCI 470-1/502-1       Assignment 4        Summer 2020      *
 *                                                              *
 *  Class Name:  MileageRedemptionApp                           *
 *                                                              *
 *  Programmer:  Edgar Villagran  Z1861047                      *
 *                                                              *
 *  Purpose: House main() and use functions of other classes.   *
 *      It will guide user to gather information and determine  *
 *      Locations that can be travelled to and best-case use of *
 *      mileage.                                                *
 *                                                              *
 ****************************************************************/
public class MileRedemptionApp {
    public static void main(String[] args) throws IOException {

        //Used to re-run program
        char another='y';

        while (another=='y') {

            //Get file name and open File
            Scanner sc = new Scanner(System.in);
            System.out.printf("%s", "Enter filename: ");
            String fileName = sc.nextLine();

            //create Scanner object for file
            Scanner filesc = new Scanner(new File(fileName));

            //Create instance of class MileRedeemer
            MileRedeemer mr = new MileRedeemer();

            //Call readDestinations
            mr.readDestinations(filesc);

            //Call and store cityNames
            String[] cityNames = mr.getCityNames();

            //Output Welcome and destinations
            System.out.println("-----------------------------------------------------------");
            System.out.println("WELCOME TO THE JAVA AIRLINES OFF SEASON MILES REDEMPTION APP");
            System.out.println("-----------------------------------------------------------\n");
            System.out.println("List of destinations your client can travel to:\n");

            for (String element : cityNames) {
                System.out.println(element);
            }

            System.out.println("----------------------------------");

            //Gather necessary info
            System.out.print("Please enter clients accumelated Frequent Flier Miles: ");
            int ffmiles = sc.nextInt();

            System.out.print("\nPlease enter your client's month of departure (1-12): ");
            int month = sc.nextInt();

            //Call redeemMiles to get best use of miles
            String[] rMiles = mr.redeemMiles(ffmiles, month);

            //If at least 1 destination then display
            if (rMiles.length > 0) {
                System.out.println("\nYour client's Frequent Flyer Miles can be used to redeem the following tickets:\n");
                for (String x : rMiles)
                    System.out.println(x);

                System.out.printf("%s%d%n","\nYour client's remaining Frequent Flyer Miles: ",mr.getRemainingMiles());


            }
            //Else nothing available to display
            else {
                System.out.println("\n*** Your client has not accumulated enough Frequent Flyer Miles ***");
            }

            //Close File
            filesc.close();

            //Ask if they have another client to get info
            System.out.print("Another (y/n): ");
            another=sc.next().charAt(0);
        }

        //Output End of program
        System.out.println("---------------------------------------------------------------------");
        System.out.println("THANK YOU FOR USING THE JAVA AIRLINES OFF SEASON MILES REDEMPTION APP");
        System.out.println("---------------------------------------------------------------------\n");

    }
}
