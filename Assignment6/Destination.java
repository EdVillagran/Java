/****************************************************************
 *                                                              *
 *  CSCI 470-1/502-1       Assignment 6        Summer 2020      *
 *                                                              *
 *  Class Name:  Destination                                    *
 *                                                              *
 *  Programmer:  Edgar Villagran  Z1861047                      *
 *                                                              *
 *  Purpose: Encapsulated all information about the destination *
 *      and mileages required to fly.  -No Changes Made         *
 *                                                              *
 ****************************************************************/
public class Destination {
    /************************************************************
     *  Variables:                                              *
     *     destinationCity- Name of the city                    *
     *     normalMiles- Amount of miles for economy class       *
     *     OffSeasonMiles- milage needed for offseason ticket   *
     *     addMilesforUp-additional mileage to upgrade          *
     *     starMonthFF- start month for offseason miles         *
     *     endMonthFF- end month for offseason miles            *
     *                                                          *
     ************************************************************/
    private String destinationCity;
    private int normalMiles, offSeasonMiles, addMilesforUp, starMonthFF, endMonthFF;

    //No Argument Constructor to create class object
    public Destination(){}
    /************************************************************
     *                                                          *
     *  Methods: get-methods                                    *
     *                                                          *
     *  Purpose:  return each variable belonging to the class   *
     *                                                          *
     ************************************************************/

    public String getDestinationCity() {
        return destinationCity;
    }

    public int getNormalMiles() {
        return normalMiles;
    }

    public int getOffSeasonMiles() {
        return offSeasonMiles;
    }

    public int getAddMilesforUp() {
        return addMilesforUp;
    }

    public int getStarMonthFF() {
        return starMonthFF;
    }

    public int getEndMonthFF() {
        return endMonthFF;
    }

    /************************************************************
     *                                                          *
     *  Methods: set-methods                                    *
     *                                                          *
     *  Purpose:  initialize each variable belonging to the     *
     *  class.                                                  *
     *                                                          *
     ************************************************************/

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setNormalMiles(int normalMiles) {
        this.normalMiles = normalMiles;
    }

    public void setOffSeasonMiles(int offSeasonMiles) {
        this.offSeasonMiles = offSeasonMiles;
    }

    public void setAddMilesforUp(int addMilesforUp) {
        this.addMilesforUp = addMilesforUp;
    }

    public void setStarMonthFF(int starMonthFF) {
        this.starMonthFF = starMonthFF;
    }

    public void setEndMonthFF(int endMonthFF) {
        this.endMonthFF = endMonthFF;
    }
}
