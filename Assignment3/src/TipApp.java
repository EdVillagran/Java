/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 3        Summer 2020  *
 *                                                          *
 *  Class Name: TipApp                                      *
 *                                                          *
 *  Programmer:  Edgar Villagran  Z1861047                  *
 *                                                          *
 *  Purpose: Driver Class for Tip Calculator. Interacts with*
 *  user to retrieve required info and calls TipCalculator  *
 *  to calculate output.                                    *
 *                                                          *
 ************************************************************/
import java.util.Scanner;  // Import the Scanner class removed like instruction says to do.
public class TipApp {
    /************************************************************
     *                                                          *
     *  Methods: main                                           *
     *                                                          *
     *  Purpose: Doesn't do much in this program other than call *
     *  calculateTips method.                                   *
     *                                                          *
     ************************************************************/

    public static void main(String[] args){

        calculateTips();


    }
    /************************************************************
     *                                                          *
     *  Methods: calculateTips                                  *
     *                                                          *
     *  Purpose: To do the logic to retrieve required info from *
     *  uaer and using that info to provide total bill amount   *
     *  and individual share.                                   *
     *                                                          *
     ************************************************************/
    public static void calculateTips(){
        char another='y';
        //Will redo the program if the user chooses too
        do {


            TipCalculator tipCalc= new TipCalculator();  //Create TipCalculator Object
            Scanner sc = new Scanner(System.in);  // Create a Scanner object

            System.out.println("*** Tip Calculator ***\n");
            System.out.printf("%s","Enter the bill amount: ");

            //Check to make sure correct input is entered, if not prompt again

            double n=-1;
            while(n<0) {

                while (!sc.hasNextDouble()) {
                    System.out.println("Please Enter a valid bill.\n");
                    System.out.printf("%s", "Enter the bill amount: ");
                    sc.next();
                }
                n=sc.nextDouble();
                if (n <0) {
                    System.out.println("Please Enter a valid bill.\n");
                    System.out.printf("%s", "Enter the bill amount: ");
                }
            }
            //call set function to set the class private variables
            tipCalc.setBill_amount(n);

            System.out.printf("%s","Enter your desired tip percentage (20 equals 20%): ");
            int m=-1;
            //Check to make sure correct input is entered, if not prompt again
            while(m<0) {
                while (!sc.hasNextInt()) {
                    System.out.println("Please Enter a valid tip.\n");
                    System.out.printf("%s", "Enter your desired tip percentage (20 equals 20%): ");
                    sc.next();
                }

                m=sc.nextInt();
                if (m <0) {
                    System.out.println("Please Enter a valid tip.\n");
                    System.out.printf("%s", "Enter your desired tip percentage (20 equals 20%): ");
                }
            }
            //call set function to set the class private variables
            tipCalc.setTip_percent(m);

            System.out.printf("%s","Enter the size of your party: ");
            //Check to make sure correct input is entered, if not prompt again
            m=-1;
            while(m<0) {
                while (!sc.hasNextInt()) {
                    System.out.println("Please Enter a valid party size.\n");
                    System.out.printf("%s", "Enter the size of your party: ");
                    sc.next();
                }
                m=sc.nextInt();
                if (m <0) {
                    System.out.println("Please Enter a valid party size.\n");
                    System.out.printf("%s", "Enter the size of your party: ");
                }
            }
            //call set function to set the class private variables
            tipCalc.setParty_size(m);

            //Remaining is to output proper values by calling TipCalculator's methods
            System.out.println("\n*** Your Bill ***\n");
            System.out.printf("%s%.2f%n","Bill Amount: $",tipCalc.getBill_amount());
            System.out.printf("%s%d%s%n","Tip Percentage: ",tipCalc.getTip_percent(),"%");
            System.out.printf("%s%d%n%n","Party Size: ",tipCalc.getParty_size());

            System.out.printf("%s%.2f%n","Total Bill(with Tip): $",tipCalc.getTotalBill());
            System.out.printf("%s%.2f%n","Share for Each Individual: $",tipCalc.getIndividualShare());

            //Finally prompt for another bill, if y then repeat
            System.out.printf("%s","Another bill?(y/n): ");
            another=sc.next().charAt(0);
        }
        while(another=='y');

    }
}

