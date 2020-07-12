/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 2        Summer 2020  *
 *                                                          *
 *  Class Name:  Put the name of the class here.            *
 *                                                          *
 *  Programmer:  Edgar Villagran  Z1861047                  *
 *                                                          *
 *  Purpose:  Invoice class Creates Invoice for items       *
 *  puchased. It uses a part number, description, quantity  *
 *  and price to describe each item. Then provides total    *
 *  cost of order based on item cost * quantity.            *
 *                                                          *
 ************************************************************/
public class Invoice {
    String partNum, partDesc;   //part Number, Part description
    int quantity;               //quantity of part bought
    double price;               // part price


    // Constructor that initializes the four instance variables
    public Invoice(String partNum, String partDesc, int quantity, double price){
        this.partNum=partNum;
        this.partDesc=partDesc;
        this.quantity=quantity;
        this.price=price;

    }
    //Constructor that does not, meant to be used to create instance and
    //Initialize variables using set methods.
    public Invoice(){
        System.out.println(" ");
    }

    /************************************************************
     *                                                          *
     *  Method Name:  Put the method's name here.               *
     *                                                          *
     *  Purpose:  initialize each variable belonging to the     *
     *  class.                                                  *
     *                                                          *
     ************************************************************/
    public void setPartDesc(String partDesc) {
        this.partDesc = partDesc;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /************************************************************
     *                                                          *
     *  Methods: get-methods                                    *
     *                                                          *
     *  Purpose:  return each variable belonging to the class   *
     *                                                          *
     ************************************************************/
    public String getPartDesc() {
        return partDesc;
    }

    public String getPartNum() {
        return partNum;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    /************************************************************
     *                                                          *
     *  Methods:getInvoiceAmount                                *
     *                                                          *
     *  Purpose:  calculates the invoice amount then returns    *
     *  the amount as a double value. If the quantity or price  *
     *  are >=0 it returns 0. If not then it returns price*qty. *
     *                                                          *
     ************************************************************/
    public double getInvoiceAmount(){
        //In line if statement returns price of 0 or quantity * price
        //return (quantity <= 0 || price==0) ? 0: quantity*price;

        return quantity * price;

    }
}
