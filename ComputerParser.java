// Assignment #: 8
//         Name: Jonas Khan
//    StudentID: 1206550640
//      Lecture: TTH 10:30-11:45
// This file is given by the instructor.
// Description: This is a utility class that takes a string containing
// a computer's information and parse it to create a computer object.

import java.util.*;

public class ComputerParser
 {

 /********************************************************
 The computerParser method will parse a string containing
 information on a computer, pull out the information,
 create a new computer object, set the attributes of the object,
 and return it to the calling method.
 ********************************************************/
 public static Computer computerParser(String lineToParse)
  {
   String brandName = new String("?");
   String price = new String("0.00");
   String memory = new String();
   String cpu = new String();
   String cpuType = new String("?");
   String cpuSpeed = new String("0");

   //check the index of each colon and comma to see the existence
   //of brandname, cpuType, cpuSpeed, memory, and price
   int colonIndex = lineToParse.indexOf(':');
   int colon2Index = lineToParse.indexOf(':',colonIndex+1);
   int colon3Index = lineToParse.indexOf(':',colon2Index+1);
   int comma1Index = lineToParse.indexOf(',');

   Computer computer1 = new Computer();  //create a computer object to be returned

   try
    {
	 //first, tokenize the string using only colon
     StringTokenizer tokenizer1 = new StringTokenizer(lineToParse, ":");

     //if brandname is in the string, extract it and assign it to the computer
     if (tokenizer1.hasMoreTokens() && colonIndex > 0)
      {
       brandName = tokenizer1.nextToken().trim();
       computer1.setBrandName(brandName);
      }

     //if cpu information is in the string, extract it and assign it to the computer
     if (tokenizer1.hasMoreTokens() && (colon2Index-colonIndex) > 1)
      {
       cpu = tokenizer1.nextToken().trim();
       StringTokenizer tokenizer2 = new StringTokenizer(cpu, ","); //takenize with comma

       //if cpuType exists in the string
       if (comma1Index-colonIndex > 1 && comma1Index >= 0)
         cpuType = tokenizer2.nextToken().trim();

       //if cpuSpeed exists in the string
       if (lineToParse.length()-comma1Index > 1 && comma1Index >= 0)
         cpuSpeed = tokenizer2.nextToken().trim();

       computer1.setCPU(cpuType, Integer.parseInt(cpuSpeed));
      }

      //if memory exists in the string, extract it and assign it to the computer
      if (tokenizer1.hasMoreTokens() && (colon3Index-colon2Index) > 1)
      {
       memory = tokenizer1.nextToken().trim();
       computer1.setMemory(Integer.parseInt(memory));
      }

     //if price exists in the string, extract it and assign it to the computer
     if (tokenizer1.hasMoreTokens() && (lineToParse.length()-colon3Index) > 1)
      {
         price = tokenizer1.nextToken().trim();
         computer1.setPrice(Double.parseDouble(price));
      }

     return computer1;
    }
   //NumberFormatException can be thrown by parseInt or parseDouble method
   catch(NumberFormatException exception)
    {
     System.out.print("Invalid String\n");
     computer1 = new Computer(); // setting default computer object
     return computer1;
    }
  }

} // end of ComputerParser class
