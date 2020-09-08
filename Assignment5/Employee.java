// Fig. 10.4: Employee.java
// Employee abstract superclass.
/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 5        Summer 2020  *
 *                                                          *
 *  Class Name:  Employee                                   *
 *                                                          *
 *  Purpose:  Super Class to Employee- Changes made: added  *
 *  birthDate variable as a private instance                *
 *                                                          *
 ************************************************************/
public abstract class Employee 
{
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final String birthDate;

   // constructor
   public Employee(String firstName, String lastName, 
      String socialSecurityNumber,String birthDate)
   {
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;
      this.birthDate=birthDate;
   } 

   // return first name
   public String getFirstName()
   {
      return firstName;
   } 

   // return last name
   public String getLastName()
   {
      return lastName;
   } 

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   }

   //return birth date
   public String getBirthDate() {
      return birthDate;
   }

   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format("%s %s%nsocial security number: %s %nbirth date: %s",
         getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDate());
   } 

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
} // end abstract class Employee



