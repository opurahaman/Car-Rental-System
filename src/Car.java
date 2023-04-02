import java.util.*;
import java.io.*;

/////////////////////////////////////////////Car class/////////////////////////////////////
public class Car {

	private String carType;
	private String carModel;
	private double carRentalPrice;
	
	public Car() {
		carType = "";
		carModel = "";
		carRentalPrice = 0.0D;
	}
	
	public void setCar(String newCarType, String newCarModel, double newCarRntalPrice){
		
		carType = newCarType;
		carModel = newCarModel;
		carRentalPrice = newCarRntalPrice;	
	}
	
	public String getCarType() {
		return carType;
	}
	
	public String getCarModel() {
		return carModel;
	}
	
	public String getCar() {
		return getCarType() + "-" + getCarModel();
	}
		
	public double getCarRentalPrice() {
		return carRentalPrice;
	}

}