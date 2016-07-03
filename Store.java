import java.util.Collections;
import java.util.ArrayList;
public class Store 
{
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Computer> computerList = new ArrayList<Computer>();
	int counter=0;
	int counter1=0;
	
public Store()
{
	
}


public int customerExists(String a)
{
	int r=10;
	String j = a;
	for (int i=0; i<customerList.size();i++) 
	{
		String e =customerList.get(i).getCustomerID();
		if (e.equals(j)) 
			{
				r=0;
			}
	}
	if (r==10) 
	{
		r=-1;
	}
		
counter++;
return r;


}
public boolean addCustomer(String a)
{
	boolean status =true;
	if (counter==0){
	customerList.add(CustomerParser.customerParser(a));
	
	status= true;
	}
	else 
	{
		Customer b=CustomerParser.customerParser(a);
		String j = b.getCustomerID();
		for (int i=0; i<customerList.size();i++) 
		{
			String e =customerList.get(i).getCustomerID();
			if (e.equals(j)) 
			{
				status= false;
			}
		}
		if (status==true) 
		{
			customerList.add(CustomerParser.customerParser(a));
		}
	}
	counter++;
return status;	
}


boolean removeCustomer(String a)
{
	boolean status =false;
	if (counter==0)
	{
		status= false;
	}
	else 
	{
		String j = a;
		for (int i=0; i<customerList.size();i++) 
		{
			String e =customerList.get(i).getCustomerID();
			if (e.equals(j)) 
			{
				status= true;
				customerList.remove(i);
			}
		}
		
		}
counter++;
return status;
}


public void sortCustomers()
{
	Collections.sort(customerList);
}


public String listCustomers()
{
	String list = "";
	for (int i=0;i<customerList.size();i++) 
	{
		list = list+ customerList.get(i).toString();
	}
	return list;
}


public int computerExists(String brandName, String cpuType, int cpuSpeed, int memory)
{
	int r=10;
	String bn = brandName;
	String ct = cpuType;
	int cs = cpuSpeed;
	int mem = memory;
	for (int i=0; i<computerList.size();i++) 
	{
		String bn1 =computerList.get(i).getBrandName();
		String ct1=computerList.get(i).cpu.getType();
		int cs1=computerList.get(i).cpu.getSpeed();
		int mem1=computerList.get(i).getMemory();
		if (bn1.equals(bn)) 
			{
				if (ct1.equals(ct)) 
				{
					if (cs1==cs) 
					{
						if (mem1==mem) 
						{
							r=0;
						}
					}
				}
			}
	}
	if (r==10) 
	{
		r=-1;
	}
return r;	
}


public boolean addComputer(String a)	
{
	boolean status =true;
		if (counter1==0){
		computerList.add(ComputerParser.computerParser(a));
		
		status= true;
		}
		else 
		{
			Computer b = ComputerParser.computerParser(a);
			String j = b.getBrandName();
			for (int i=0; i<computerList.size();i++) 
			{
				String e =computerList.get(i).getBrandName();
				if (e.equals(j)) 
				{
					status= false;
				}
			}
			if (status==true) 
			{
				computerList.add(ComputerParser.computerParser(a));
			}
		}
		counter1++;
	return status;
}


public boolean removeComputer(String brandName, String cpuType, int cpuSpeed, int memory)
{
	boolean status=false;
	String bn = brandName;
	String ct = cpuType;
	int cs = cpuSpeed;
	int mem = memory;
	for (int i=0; i<computerList.size();i++) 
	{
		String bn1 =computerList.get(i).getBrandName();
		String ct1=computerList.get(i).cpu.getType();
		int cs1=computerList.get(i).cpu.getSpeed();
		int mem1=computerList.get(i).getMemory();
		if (bn1.equals(bn)) 
			{
				if (ct1.equals(ct)) 
				{
					if (cs1==cs) 
					{
						if (mem1==mem) 
						{
							status=true;
							computerList.remove(i);
						}
					}
				}
			}
	}
return status;
}


public void sortComputers()
{
	Collections.sort(computerList);
}


public String listComputers()
{
	String list = "";
	for (int i=0;i<computerList.size();i++) 
	{
		list = list+ computerList.get(i).toString();
	}
	return list;
}


//public void closeStore()
//{
//	
//}


}