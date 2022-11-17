package car_park.been;

import car_park.been.enums.Brand;
import car_park.been.enums.TypeOfCargo;
import car_park.been.enums.TypeOfFuel;
import car_park.been.interfaces.Serviced;

public abstract class Transport implements Serviced {

    public int yearOfManufacture;
    public Brand brand;       //марка
    public String model;
    public TypeOfFuel typeOfFuel;
    public double consumption; // расход топлива
    public boolean isWork;
    public TypeOfCargo typeOfCargo;

    public TypeOfCargo getTypeOfCargo() {
        return typeOfCargo;
    }

    public boolean getStatus(Order order){
        return false;
    };

    public boolean isFree;
    public double fuelTankVolume; //обьем бака

    public double currentAmountOfFuel;

    public Transport(double currentAmountOfFuel) {
        this.currentAmountOfFuel = currentAmountOfFuel;
    }

    public Transport(int yearOfManufacture, Brand brand, String model, TypeOfFuel typeOfFuel, double consumption, boolean isWork, double fuelTankVolume) {
        this.yearOfManufacture = yearOfManufacture;
        this.brand = brand;
        this.model = model;
        this.typeOfFuel = typeOfFuel;
        this.consumption = consumption;
        this.isWork = isWork;
        this.fuelTankVolume = fuelTankVolume;
    }
    public void refuel(double fuelQuantity) {
        if (fuelQuantity > fuelTankVolume || fuelQuantity > fuelTankVolume - currentAmountOfFuel) {
            System.out.println("Operation canceled. Too much fuel in Tank volume. Plz, try again with a lower amount of fuel.");
        } else {
            currentAmountOfFuel += fuelQuantity;
        }
    }

}
