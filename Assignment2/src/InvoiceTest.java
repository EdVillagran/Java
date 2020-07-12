/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 2        Summer 2020  *
 *                                                          *
 *  Class Name: InvoiceTest                                 *
 *                                                          *
 *  Programmer:  Edgar Villagran  Z1861047                  *
 *                                                          *
 *  Purpose:  InvoiceTest is used to test the Invoice class *
 *  by creating several different invoices using both the   *
 *  initialized constructor and the one that takes no args. *
 *                                                          *
 ************************************************************/
public class InvoiceTest{
    public static void main(String[] args) {
        //Creating new class objects using the initializing constructor
        Invoice Invoice1 =  new Invoice("AB-23-0001","10mm Socket",20,4.83);
        Invoice Invoice2 =  new Invoice("AB-24-0002","1/2in Torque Wrench",5,19.91);
        Invoice Invoice3 =  new Invoice("AB-23-0005","Rubber Mallet",35,2.15);

        //Creating new class objects using the constructor that does not take in arguments
        Invoice Invoice4=new Invoice();
        Invoice4.setPartNum("BC-15-0153");
        Invoice4.setPartDesc("Cart Wheel");
        Invoice4.setQuantity(15);
        Invoice4.setPrice(21.93);
        //One testing for 0 quantity
        Invoice Invoice5=new Invoice();
        Invoice5.setPartNum("BC-15-0155");
        Invoice5.setPartDesc("Cart");
        Invoice5.setQuantity(0);
        Invoice5.setPrice(20);

        //Printing all Invoice instances
        printInvoice(Invoice1,1);
        printInvoice(Invoice2,2);
        printInvoice(Invoice3,3);
        printInvoice(Invoice4,4);
        printInvoice(Invoice5,5);

    }
    /************************************************************
     *                                                          *
     *  Method: printInvoice                                    *
     *                                                          *
     *  Purpose: Takes an Invoice object as a parameter and it  *
     *  properly prints each attribute. Being that we are       *
     *  making and printing multiple Invoices, it's more        *
     *  efficient making prints its own function.               *
     *                                                          *
     ***********************************************************/
    public static void printInvoice(Invoice i, int invoiceNum){
        System.out.printf("%s%d%n","Invoice #" ,invoiceNum);
        System.out.printf("%s%s%n%n","\t\t Part No.: ",i.getPartNum());
        System.out.printf("%s%s%n%n","\t Item Desc.: ",i.getPartDesc());
        System.out.printf("%s%d%n%n","\t\t Quantity: ",i.getQuantity());
        System.out.printf("%s%s%n%n","\tItem Price: ",i.getPrice());
        System.out.format("%s%s%n%n","Invoice Subtotal:\t $",i.getInvoiceAmount());
        System.out.println("****************************************");
    }
}
