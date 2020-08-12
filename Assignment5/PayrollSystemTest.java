// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.
/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 5        Summer 2020  *
 *                                                          *
 *  Class Name:  PayrollSystemTest                          *
 *                                                          *
 *  Programmer:  Edgar Villagran  Z1861047                  *
 *                                                          *
 *  Purpose:  Demonstrate ploymorphism by using the         *
 *    sub-classes of Employee.  Creates instances of classes*
 *    then outputs earnings plus bonus if current month is  *
 *    birthday month.                                       *
 *                                                          *
 ************************************************************/
import java.util.Scanner;
public class PayrollSystemTest 
{
   public static void main(String[] args) 
   {
      //Create Dates
      Date se= new Date(6,15,1955);
      Date he= new Date(12,29,1960);
      Date ce= new Date(9,8,1954);
      Date bpc= new Date(3,2,1965);


      // create subclass objects
      SalariedEmployee salariedEmployee =
              new SalariedEmployee("John", "Smith", "111-11-1111",se.toString() ,800.00);

      HourlyEmployee hourlyEmployee =
              new HourlyEmployee("Karen", "Price", "222-22-2222",he.toString() ,16.75, 40);

      CommissionEmployee commissionEmployee =
              new CommissionEmployee(
                      "Sue", "Jones", "333-33-3333", ce.toString(),10000, .06);

      BasePlusCommissionEmployee basePlusCommissionEmployee =
              new BasePlusCommissionEmployee(
                      "Bob", "Lewis", "444-44-4444",bpc.toString() ,5000, .04, 300);

      System.out.println("\nEmployees processed individually:");

      System.out.printf("%n%s%n%s: $%,.2f%n%n",
              salariedEmployee, "earned", salariedEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
              hourlyEmployee, "earned", hourlyEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
              commissionEmployee, "earned", commissionEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
              basePlusCommissionEmployee,
              "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4];

      // initialize array with Employees
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee;
      employees[3] = basePlusCommissionEmployee;



      System.out.print("Enter the current month(1 - 12): ");

      Scanner sc=new Scanner(System.in);
      int currentMonth=sc.nextInt();


      System.out.printf("Employees processed polymorphically:%n%n");

      // generically process each element in array employees
      for (Employee currentEmployee : employees)
      {
         System.out.println(currentEmployee); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee instanceof BasePlusCommissionEmployee)
         {
            // downcast Employee reference to
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee =
                    (BasePlusCommissionEmployee) currentEmployee;

            employee.setBaseSalary(1.10 * employee.getBaseSalary());

            System.out.printf(
                    "new base salary with 10%% increase is: $%,.2f%n",
                    employee.getBaseSalary());
         }

         //Split the current employee birthdate, and index at the month. Turn that string to int
         int m=Integer.parseInt(currentEmployee.getBirthDate().split("/",-2)[0]);

         if (m==currentMonth){
            System.out.printf(
                    "earned $%,.2f%s%n%n", currentEmployee.earnings()," plus $100.00 birthday bonus");
         }
         else {
            System.out.printf(
                    "earned $%,.2f%n%n", currentEmployee.earnings());
         }
      }

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++)
         System.out.printf("Employee %d is a %s%n", j,
                 employees[j].getClass().getName());
      } // end main
   } // end class PayrollSystemTest

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
