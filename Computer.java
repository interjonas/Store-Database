//// Assignment #: 8
//         Name: Jonas Khan
//    StudentID: 1206550640
//      Lecture: TTH 10:30-11:45
//  Description: The Computer class describes attributes in a computer
//               and provides accessor and mutator methods for each
//               instance variables as well as toString method.

import java.text.*;   //to use NumberFormat class
import java.io.*;

public class Computer implements Comparable, Serializable
{
    private String brandName;
    private double price;
    private int memory;
    public CPU cpu;

    /************************************************************************
    Constructor method to initialize each variable.
    ************************************************************************/
    public Computer()
    {
        brandName = "?";
        price = 0.00;
        memory = 0;
        cpu = new CPU();        //initialize the CPU() object
    }

    /************************************************************************
    Accessor method:
    This method returns the brand name of a computer.
    ************************************************************************/
    public String getBrandName()
    {
        return brandName;
    }

    /************************************************************************
    Accessor method:
    This method returns the price of a computer.
    ************************************************************************/
    public double getPrice()
    {
        return price;
    }

    /************************************************************************
    Accessor method:
    This method returns the capacity memory of a computer.
    ************************************************************************/
    public int getMemory()
    {
        return memory;
    }

    /************************************************************************
    Accessor method:
    This method returns a CPU object of a computer.
    ************************************************************************/
    public CPU getCPU()
    {
        return cpu;
    }


    /************************************************************************
    Modifier method:
    This method sets the brand name of a computer given by its parameter.
    ************************************************************************/
    public void setBrandName(String brand)
    {
        brandName = brand;
    }

    /************************************************************************
    Modifier method:
    This method sets the price of a computer given by its parameter.
    ************************************************************************/
    public void setPrice(double price)
    {
        this.price = price;
    }

    /************************************************************************
    Modifier method:
    This method set the memory amount of a computer given by its parameter.
    ************************************************************************/
    public void setMemory(int memoryAmount)
    {
        memory = memoryAmount;
    }

    /************************************************************************
    Modifier method:
    This method sets the type and the speed in the CPU object
    ************************************************************************/
    public void setCPU(String cpuType, int cpuSpeed)
    {
        cpu.setType(cpuType);
        cpu.setSpeed(cpuSpeed);
    }

    /************************************************************************
    This method returns a String containing attribute(variable) values
    of a computer.
    ************************************************************************/
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String result;
        result = "\nBrandName:\t" + brandName +
                 "\nCPU:\t\t" + cpu.toString() +
                 "\nMemory:\t\t" + memory + "M" +
                 "\nPrice:\t\t" + fmt.format(price) + "\n\n";

        return result;
    }

       // compareTo method returns 0 if this computer is same as the
       // other computer (parameter of the method), returns a negative integer
       // if this computer is less, and returns a positive integer if this computer
       // is larger.
       public int compareTo(Object other)
         {
               int result;

               if (this.brandName.compareTo(((Computer) other).brandName) == 0)
                {
                 if (((Comparable) this.cpu).compareTo(((Computer)other).cpu)== 0)
                  {
                     result = (this.memory - ((Computer) other).memory);
                  }
                 else
                  {
                     result = (((Comparable) this.cpu).compareTo(((Computer)other).cpu));
                  }
                }
               else
                result = (this.brandName.compareTo(((Computer) other).brandName));

              return result;
        }
}// end of Computer class.
