import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/****************************************************************
 *                                                              *
 *  CSCI 470-1/502-1       Assignment 6        Summer 2020      *
 *                                                              *
 *  Class Name:  MileRedeemer                                   *
 *                                                              *
 *  Programmer:  Edgar Villagran  Z1861047                      *
 *                                                              *
 *  Purpose: Encapsulates the logic to redeem mileage. Also     *
 *      provides required logic to choose traveling locations.  *
 *      -No Changes made.                                       *
 *                                                              *
 ****************************************************************/
public class MileRedeemer {

    private Destination[] destinationArray;
    private int remainingMiles;

    public Destination[] getDestinationArray() {
        return destinationArray;
    }

    /************************************************************
     *                                                          *
     *  Methods: readDestinations                               *
     *                                                          *
     *  Purpose:  takes in file Scanner as paramater, uses the  *
     *      file to parse information and fill Destination      *
     *      objects. Then sorts array of objects based on       *
     *      normal miles.                                       *
     *                                                          *
     ************************************************************/
    public void readDestinations(Scanner fileScanner)throws IOException
    {
        ArrayList<Destination> destinationsArrayList= new ArrayList<Destination>();

        //Read line by line of the file
        while (fileScanner.hasNextLine()) {
            //Get line data
            String data = fileScanner.nextLine();

            //Parse data and split each piece by ;
            String[] temp = data.split(";", -2);

            //Parse months by split -
            String[] tempMonths=temp[4].split("-",2);

            //Create new Destination object
            Destination d= new Destination();

            //Parse data and store each into its designated variable
            d.setDestinationCity(temp[0]);
            d.setNormalMiles(Integer.parseInt(temp[1]));
            d.setOffSeasonMiles(Integer.parseInt(temp[2]));
            d.setAddMilesforUp(Integer.parseInt(temp[3]));
            d.setStarMonthFF(Integer.parseInt(tempMonths[0]));
            d.setEndMonthFF(Integer.parseInt(tempMonths[1]));

            //System.out.printf("%d%s%d%n",d.getStarMonthFF()," ",d.getEndMonthFF());

            //Add current destination object into arrayList
            destinationsArrayList.add(d);

        }
        //Convert Into Array.... Was getting errors converting and equaling it directly to destinationArray
        //So i had to do it this way
        Destination[] destinationArrayw=(Destination[]) destinationsArrayList.toArray(new Destination[destinationsArrayList.size()]);
        destinationArray=destinationArrayw;

        //Sort destinationArray in decending normal miles
        Arrays.sort(destinationArray, new MileageComparator());


    }
    /************************************************************
     *                                                          *
     *  Methods: get-methods                                    *
     *                                                          *
     *  Purpose:  return each variable belonging to the class   *
     *                                                          *
     ************************************************************/
    public int getRemainingMiles() {
        return remainingMiles;
    }

    /************************************************************
     *                                                          *
     *  Methods: getCityNames                                   *
     *                                                          *
     *  Purpose:  return array of city names.                   *
     *                                                          *
     ************************************************************/
    public String[] getCityNames() {
        //Create ArrayList to store into
        ArrayList<String> cityNamesAL=new ArrayList<String>();

        for(int i=0; i<destinationArray.length; i++){
            cityNamesAL.add(destinationArray[i].getDestinationCity());
        }

        //Convert ArrayList to String array
       String[] cityNames= (String[]) cityNamesAL.toArray(new String[cityNamesAL.size()]);


        return cityNames;
    }
    /************************************************************
     *                                                          *
     *  Methods: redeemMiles                                    *
     *                                                          *
     *  Purpose:  Provides main logic to determine possible     *
     *      locations to go to. DOes so by comparing given data *
     *      to start/end month, normal, offseason mileage and   *
     *      additional miles required to upgrade. Then returns  *
     *      city names travel to.                               *
     *                                                          *
     ************************************************************/
    String[]redeemMiles(int miles, int month) {
        //Update remainingMiles
        remainingMiles = miles;

        //Create Array for destinations that have been chosen
        ArrayList<Destination> destinationObjects= new ArrayList<Destination>();

        //Iterate through each object in the destinationArray
        for (Destination d : destinationArray) {

            //Test if month lie within star-end month of destination
            if (d.getStarMonthFF() <= month && d.getEndMonthFF() >= month) {

                //Check to see if it has enough remaining miles to cover
                if (d.getOffSeasonMiles() <= remainingMiles) {

                    //If so add to destinationObjects
                    destinationObjects.add(d);

                    //Update remainingMiles
                    remainingMiles -= d.getOffSeasonMiles();
                }
            }

            else {
                //If enough miles remaining
                if (d.getNormalMiles() <= remainingMiles) {

                    //If so add to destinationObjects
                    destinationObjects.add(d);

                    //Update remainingMiles
                    remainingMiles -= d.getNormalMiles();
                }


            }
        }
        //Store cities to print out and what class it will be
        ArrayList<String> printOut= new ArrayList<String>();

        //Upgrade any flights from economic to 1st class
        for (Destination d: destinationObjects){

            //If we have enough remaining miles for upgraded seat
            if (d.getAddMilesforUp()<=remainingMiles){

                //Update remainingMiles
                remainingMiles-=d.getAddMilesforUp();

                //Add string to properly print to PrintOut
                printOut.add("* A trip to "+d.getDestinationCity()+" in First Class");
            }
            else{
                printOut.add("* A trip to "+d.getDestinationCity()+" in Economy Class");
            }
        }

        //return printOut as a fixed array
        String[] finalout=printOut.toArray(new String[printOut.size()]);
        return finalout;
    }


}




