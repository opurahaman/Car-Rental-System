import java.util.*;
import java.io.*;

public class Transaction {
	//Let's assume that one month is equal to 30 days in this program And in one year there is 12 months
	final static int MONTHS_DAYS = 30;
	final static int MONTHS = 12;
	
	//Here we create a Customer class instance to print customer details for car rental payment 
	private Customer carRentalCustomer; 
	
	//Here we create a Car class instance to calculate the payment's of a specific car
	private Car hiredRentalCar; 
	private int month = 0;
	private int days = 0; 
	
	//Current date, for using User age, is he valid to rent a car or not
	private String currentMonth;
	private int currentDate;
	private int currentYear;
	
	//Rental date, for using User to calculate bill
	private String pickMonth;
	private int PickDate;
	private int pickYear;
	
	//Return date, for using User to calculate bill
	private String returnMonth;
	private int returnDate;
	private int returnYear;
	
	//Calculate user validity to hire car
	private String birthMonth;
	private int birthDate;
	private int birthYear = 0;	
	private int age = 0;
	
	public Transaction() { 
		carRentalCustomer = new Customer();
		hiredRentalCar = new Car();
		
		currentMonth = "";
		currentDate = 0;
		currentYear = 0;
		
		pickMonth = "";
		PickDate = 0;
		pickYear = 0;
		
		returnMonth = "";
		returnDate = 0;
		returnYear = 0;
		
		birthMonth = "";
		birthDate = 0;
		birthYear = 0;
 	}
	
	public void setTransaction(Customer newCarRentalCustomer, 
							   Car newHiredRentalCar, 
		
							   String newCurrentMonth, int newCurrentDate, int newCurrentYear, 
							   String newPickMonth, int newPickDate, int newPickYear, 
							   String newReturnMonth, int newReturnDate, int newReturnYear, 
							   String newBirthMonth, int newBirthDate, int newBirthYear) { 
		
		carRentalCustomer = newCarRentalCustomer;
		hiredRentalCar = newHiredRentalCar;
		
		currentMonth = newCurrentMonth;
		currentDate = newCurrentDate;
		currentYear = newCurrentYear;
		
		pickMonth = newPickMonth;
		PickDate = newPickDate;
		pickYear = newPickYear;
		
		returnMonth = newReturnMonth;
		returnDate = newReturnDate;
		returnYear = newReturnYear;
		
		birthMonth = newBirthMonth;
		birthDate = newBirthDate;
		birthYear = newBirthYear;
	}
	
	public String getCurrentMonth() { 
		return currentMonth;
	}
	
	public int getCurrentDate() { 
		return currentDate;
	}
	
	public int getCurrentYear() { 
		return currentYear;
	}
    
	//Get the value of Current month
	public int getCurrentMonthValue() {
		if(getCurrentMonth().equals("Jan"))
			month = 1;
		
		else if(getCurrentMonth().equals("Feb"))
			month = 2;
		
		else if(getCurrentMonth().equals("Mar"))
			month = 3;
		
		else if(getCurrentMonth().equals("Apr"))
			month = 4;
		
		else if(getCurrentMonth().equals("May"))
			month = 5;
		
		else if(getCurrentMonth().equals("Jun"))
			month = 6;
		
		else if(getCurrentMonth().equals("Jul"))
			month = 7;
		
		else if(getCurrentMonth().equals("Aug"))
			month = 8;		
		
		else if(getCurrentMonth().equals("Sep"))
			month = 9;
			
		else if(getCurrentMonth().equals("Oct"))
			month = 10;
			
		else if(getCurrentMonth().equals("Nov"))
			month = 11;
			
		else if(getCurrentMonth().equals("Dec"))
			month = 12;
		
		return month;
	}
	
	public String getPickMonth() { 
		return pickMonth;
	}
	
	public int  getPickDate() {
		return PickDate;
	}
	
	public int getPickYear() {
		return pickYear;
	}
	

	//Get the value of Pick Up month
	public int getPickMonthValue() {
		if(getPickMonth().equals("Jan"))
			month = 1;
		
		else if(getPickMonth().equals("Feb"))
			month = 2;
		
		else if(getPickMonth().equals("Mar"))
			month = 3;
		
		else if(getPickMonth().equals("Apr"))
			month = 4;
		
		else if(getPickMonth().equals("May"))
			month = 5;
		
		else if(getPickMonth().equals("Jun"))
			month = 6;
		
		else if(getPickMonth().equals("Jul"))
			month = 7;
		
		else if(getPickMonth().equals("Aug"))
			month = 8;		
		
		else if(getPickMonth().equals("Sep"))
			month = 9;
			
		else if(getPickMonth().equals("Oct"))
			month = 10;
			
		else if(getPickMonth().equals("Nov"))
			month = 11;
			
		else if(getPickMonth().equals("Dec"))
			month = 12;
		
		return month;
	}
	
	public String getReturnMonth() {
		return returnMonth;
	}
	
	public int getReturnDate() { 
		return returnDate;
	}
	
	public int getReturnYear() { 
		return returnYear;
	}
	
    //Get the value of Return month
	public int getReturnMonthValue() {
		if(getReturnMonth().equals("Jan"))
			month = 1;
		
		else if(getReturnMonth().equals("Feb"))
			month = 2;
		
		else if(getReturnMonth().equals("Mar"))
			month = 3;
		
		else if(getReturnMonth().equals("Apr"))
			month = 4;
		
		else if(getReturnMonth().equals("May"))
			month = 5;
		
		else if(getReturnMonth().equals("Jun"))
			month = 6;
		
		else if(getReturnMonth().equals("Jul"))
			month = 7;
		
		else if(getReturnMonth().equals("Aug"))
			month = 8;		
		
		else if(getReturnMonth().equals("Sep"))
			month = 9;
			
		else if(getReturnMonth().equals("Oct"))
			month = 10;
			
		else if(getReturnMonth().equals("Nov"))
			month = 11;
			
		else if(getReturnMonth().equals("Dec"))
			month = 12;
		
		return month;
	}
	
	public String getBirthMonth() { 
		return birthMonth;
	}
	
	public int getBirthDate() { 
		return birthDate;
	}
	
	public int getBirthYear() { 
		return birthYear;
	}

    //Get the value of Birth month
	public int getBirthMonthValue() { 
		if(getBirthMonth().equals("Jan"))
			month = 1;
		
		else if(getBirthMonth().equals("Feb"))
			month = 2;
		
		else if(getBirthMonth().equals("Mar"))
			month = 3;
		
		else if(getBirthMonth().equals("Apr"))
			month = 4;
		
		else if(getBirthMonth().equals("May"))
			month = 5;
		
		else if(getBirthMonth().equals("Jun"))
			month = 6;
		
		else if(getBirthMonth().equals("Jul"))
			month = 7;
		
		else if(getBirthMonth().equals("Aug"))
			month = 8;		
		
		else if(getBirthMonth().equals("Sep"))
			month = 9;
			
		else if(getBirthMonth().equals("Oct"))
			month = 10;
			
		else if(getBirthMonth().equals("Nov"))
			month = 11;
			
		else if(getBirthMonth().equals("Dec"))
			month = 12;
		
		return month;
	}

    //Get customer age to check validity of hiring a car
	public int getCustomerAge(){ 
		int age = 0;
		if((getCurrentYear() > getBirthYear()) && (getCurrentMonthValue() == getBirthMonthValue())) {
            if(getCurrentDate() == getBirthDate())
				age = getCurrentYear() - getBirthYear();
			
            else if(getCurrentDate() < getBirthDate())
				age = getCurrentYear() - getBirthYear();
			
            else if(getCurrentDate() > getBirthDate())
				age = (getCurrentYear() - 1) - getBirthYear();
        }
		
		else if((getCurrentYear() > getBirthYear()) && (getCurrentMonthValue() > getBirthMonthValue()))
            age = getCurrentYear() - getBirthYear();
		
		else if((getCurrentYear() > getBirthYear())&&(getCurrentMonthValue() < getBirthMonthValue()))
			age = (getCurrentYear() - 1) - getBirthYear();
			
		return age;
	}

    //Get how many days the car has been rented
	public int getRentedDays(){
		int totalMonth = 0, totalYear = 0;
		
		if((getPickYear() == getReturnYear()) && (getPickMonthValue() == getReturnMonthValue())) {
			if(getPickDate() == getReturnDate())
				days = 0;
			else if(getPickDate() < getReturnDate())
				days = getReturnDate() - getPickDate();
		}
		
		else if((getPickYear() == getReturnYear()) && (getPickMonthValue() < getReturnMonthValue())) {
			if(getPickDate() == getReturnDate()) {
				totalMonth = getReturnMonthValue() - getPickMonthValue();
				days = totalMonth * MONTHS_DAYS;
			}
			else if(getPickDate() < getReturnDate()) {
				totalMonth = getReturnMonthValue() - getPickMonthValue();
				days = (totalMonth * MONTHS_DAYS) + (getReturnDate() - getPickDate());
			}
		}
		
		else if(getPickYear() < getReturnYear()) {
			if(getPickMonthValue() == getReturnMonthValue()) {
				totalYear = getReturnYear() - getPickYear();
				days = ((totalYear * MONTHS) * MONTHS_DAYS) + (getReturnDate() - getPickDate());
			}
			
			else if(getPickMonthValue() < getReturnMonthValue()) {
				totalMonth = getReturnMonthValue() - getPickMonthValue(); 
				days = ((totalMonth + MONTHS) * MONTHS_DAYS) + (getReturnDate() - getPickDate());
			}
			
			else if(getPickMonthValue() > getReturnMonthValue()) {
				totalMonth = MONTHS - (getPickMonthValue() - getReturnMonthValue());
				days = (totalMonth * 30) + (getReturnDate() - getPickDate());
			}
		}
		
		return days;
	}
	
    //Calculate total bill for rental car
	public double calculateCarRentalBill() {
		return getRentedDays() * hiredRentalCar.getCarRentalPrice();
	}
	
    //Change to String for checking the date
	public String toStringDateChecker() {
		String outpot = "";
		
		if((getPickMonthValue() > getReturnMonthValue()) && (getPickYear() == getReturnYear())) 
			outpot += String.format("FALSE");
		
		if((getPickMonthValue() == getReturnMonthValue()) && (getPickDate() > getReturnDate()) && (getPickYear() == getReturnYear()))
			outpot += String.format("FALSE");
		
		if(getPickYear() > getReturnYear())
			outpot += String.format("FALSE");
		
		else
			outpot += String.format("TRUE");

		return outpot;
	}
	
    //Change to String for checking the age of customer
	public String toStringAgeChecker() {
		String outfut = "";
		
		if(getCustomerAge() >= 20)
			outfut += String.format("TRUE");
			
		else if(getCustomerAge() < 20)
			outfut += String.format("FALSE");
			
		return outfut;
	}

	
	//Convert integer Age into String Age to print the user Age in GUI
	public String toStringAge() {
		String ageStringFormat = "";
		ageStringFormat += String.format("%d", getCustomerAge()); 
		return ageStringFormat;
	}
	
    //Checking whether customer is married or not to Addressing the customer "Mr/Mrs"
	public String toStringMrMrs() {
		String addressingCustomer = "";
		
		if(carRentalCustomer.getGender().equals("M") || carRentalCustomer.getGender().equals("m"))
			addressingCustomer += String.format("Mr.");
		
		else if((carRentalCustomer.getStatus().equals("S") || carRentalCustomer.getStatus().equals("s")) && carRentalCustomer.getGender().equals("F") || carRentalCustomer.getGender().equals("f"))
			addressingCustomer += String.format("Ms.");
	
		else if((carRentalCustomer.getStatus().equals("Ma") || carRentalCustomer.getStatus().equals("ma")) && carRentalCustomer.getGender().equals("F") || carRentalCustomer.getGender().equals("f"))
			addressingCustomer += String.format("Mrs.");
			
		return addressingCustomer;
	}
	
	
    //Customer details as money receipt 
	public String toStringReceipt() {
		
		
		
		
		String printingReceipt = "";
		
		//outMe += String.format(toStringMrMrs() + aCustomer.getFullName()); 
		printingReceipt += String.format("               	           	   NSU Car Rental\n");
		printingReceipt += String.format("                           	 Owned & Operated by \n");
		
		printingReceipt += String.format("                             Mostack & Opu & Raisa & Farjana\n");
		
		
		printingReceipt += String.format("                          \n\nRENTAL TRANSACTION\n");
		printingReceipt += String.format("-----------------------------------------------------------------------------------------------------\n");
		printingReceipt += String.format("Car Name                                              %s\n", hiredRentalCar.getCar());
		printingReceipt+= String.format("Rental Days                                                %d\n", getRentedDays());
		printingReceipt += String.format("Rental Price                                            %.2f\n", hiredRentalCar.getCarRentalPrice());
		printingReceipt += String.format("                                                       -----------------\n");
		printingReceipt+= String.format("Total Payment                                            %.2f\n", calculateCarRentalBill());
		printingReceipt += String.format("Client Name: " + toStringMrMrs() + carRentalCustomer.getFullName());
		printingReceipt += String.format("\n\n\n");
		return printingReceipt;
	}
	
////////////////////////////////////////////save all data to .txt file for the Owner//////////////////////////////
	public void saveToFile() throws IOException {
	
	PrintWriter outFile = new PrintWriter(new FileOutputStream(new File("Transactions_Inventory.txt"), true));
        outFile.println("Current Date: " + getCurrentMonth() + " " + getCurrentDate() + ", " + getCurrentYear());
		outFile.println(" ");
		outFile.println("Pick up Date: " + getPickMonth() + " " + getPickDate() + ", " + getPickYear());
		outFile.println("Return Date: " + getReturnMonth() + " " + getReturnDate() + ", " + getReturnYear()  + " = Days: " + getRentedDays());
		outFile.println("Full Name: " + carRentalCustomer.getFullName());
		outFile.println("Age: " + getCustomerAge());
		outFile.println("Location: " + carRentalCustomer.getLocation());
		outFile.println("Contact: " + carRentalCustomer.getContact());
		outFile.println("Car: " + hiredRentalCar.getCar());
		outFile.printf("Total Rent Price: %.2f", + calculateCarRentalBill());
		outFile.println("\n--------------------------------------------------");
		outFile.println("\n\n\n");
        outFile.close();
     }
}