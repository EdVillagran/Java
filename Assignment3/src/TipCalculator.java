/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 3        Summer 2020  *
 *                                                          *
 *  Class Name: TipCalculator                               *
 *                                                          *
 *  Programmer:  Edgar Villagran  Z1861047                  *
 *                                                          *
 *  Purpose: Contains private variables for bill information*
 *  Uses set % get methods for each variable and calculates *
 *  Total bill as well as each persons share.               *
 *                                                          *
 ************************************************************/
public class TipCalculator {
    private double bill_amount;
    private int tip_percent; //no one says ill tip 15.5%
    private int party_size;

    public TipCalculator(){
        bill_amount=0;
        tip_percent=20;
        party_size=1;
    }

    /************************************************************
     *                                                          *
     *  Methods: set-methods                                    *
     *                                                          *
     *  Purpose:  initialize each variable belonging to the     *
     *  class.                                                  *
     *                                                          *
     ************************************************************/
    public void setBill_amount(double bill_amount) {
        this.bill_amount = bill_amount;
    }

    public void setParty_size(int party_size) {
        this.party_size = party_size;
    }

    public void setTip_percent(int tip_percent) {
        this.tip_percent = tip_percent;
    }

    /************************************************************
     *                                                          *
     *  Methods: get-methods                                    *
     *                                                          *
     *  Purpose:  return each variable belonging to the class   *
     *                                                          *
     ************************************************************/
    public double getBill_amount() {
        return bill_amount;
    }

    public int getParty_size() {
        return party_size;
    }

    public int getTip_percent() {
        return tip_percent;
    }

    /************************************************************
     *                                                          *
     *  Methods: getTotalBill                                   *
     *                                                          *
     *  Purpose:  returns total bill                            *
     *                                                          *
     ************************************************************/
    public double getTotalBill(){
        bill_amount+=tip_percent*bill_amount*.01;
        return bill_amount;
    }

    /************************************************************
     *                                                          *
     *  Methods: getIndividualShare                             *
     *                                                          *
     *  Purpose:  returns value of an equal share of the bill   *
     *   for its party size                                     *
     *                                                          *
     ************************************************************/
    public double getIndividualShare(){
        bill_amount/=party_size;
        return bill_amount;
    }

}