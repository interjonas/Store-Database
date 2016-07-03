// Assignment #: 8
// Name: Jonas Khan
// StudentID: 1206550640
// Lecture: TTH 10:30-11:45
// This file is given by the instructor.
// Description: This is a utility class that takes a string containing
// a customer's information and parse it to create a customer object.

import java.util.StringTokenizer;

public class CustomerParser {

 public static Customer customerParser(String lineToParse)
  {
   String temp1 = new String();
   String temp2 = new String();
   String temp3 = new String();
   String temp4 = new String();
   String name = new String();

   //find the index where each colon or comma is located
   int commaIndex = lineToParse.indexOf(',');
   int colon1Index = lineToParse.indexOf(':');
   int colon2Index = lineToParse.indexOf(':',colon1Index+1);

   Customer customer = new Customer();

   StringTokenizer tokenizer1 = new StringTokenizer(lineToParse, ":");

     // extract the name of the customer
     if (tokenizer1.hasMoreTokens() && colon1Index > 0)
      {
       name = tokenizer1.nextToken();

       name=name.trim();
       if ( commaIndex > -1 )
        {
         StringTokenizer tokenizer2 = new StringTokenizer(name, ",");

         // extract the last name of the customer
         if (tokenizer2.hasMoreTokens() && commaIndex > 0)
          {
           temp1 = tokenizer2.nextToken();
           customer.setLastName(temp1.trim());
          }

         // extract the first name of the customer
         if (tokenizer2.hasMoreTokens() && commaIndex >= 0
            && (colon1Index-commaIndex) > 0)
          {
           temp2 = tokenizer2.nextToken();
           customer.setFirstName(temp2.trim());
          }
        }
      }

     // extract the customer ID
     if (tokenizer1.hasMoreTokens() && (colon2Index-colon1Index) > 1)
      {
       temp3 = tokenizer1.nextToken();
       customer.setCustomerID(temp3.trim());
      }

     try
      {
       // extract the cash amount that the customer has
       if (tokenizer1.hasMoreTokens() && (lineToParse.length()-colon2Index)>1)
        {
         temp4 = tokenizer1.nextToken();
         customer.setCashAmount( Double.parseDouble(temp4.trim()));
        }
      }
     catch(NumberFormatException exception)
      {
       System.out.print("Invalid String\n");
      }

     return customer;
   }
} // end of CustomerParser class


