package car_park.been;

import car_park.been.enums.Brand;
import car_park.been.enums.TypeOfFuel;
import car_park.been.interfaces.CarryingPassengers;
import car_park.been.interfaces.Serviced;

public class PassengerTransport extends Transport implements Serviced, CarryingPassengers {

    private int passengerCapacity;
    private Order order;
    private boolean isFree;
    private boolean isClean;

    public PassengerTransport(int yearOfManufacture, Brand brand,
                              String model, TypeOfFuel typeOfFuel, double consumption,
                              boolean isWork, double fuelTankVolume, int passengerCapacity,
                              boolean isClean) {
        super(yearOfManufacture, brand, model, typeOfFuel, consumption,isWork,fuelTankVolume);
        this.passengerCapacity = passengerCapacity;
        this.isClean = isClean;
        isFree = true;
    }

    @Override
    public void cleanTheSalon() {
        isClean = true;
        System.out.println("Salon has been cleaned.");
    }

    public boolean getStatus (Order order) {
        this.order = order;
        if (getFreeCapacity() > 0) {
            return isFree = true;
        } else return isFree = false;
    }

    @Override
    public void refuel(double fuelQuantity) {
        if (fuelQuantity > fuelTankVolume || fuelQuantity > fuelTankVolume - currentAmountOfFuel) {
            System.out.println("Operation canceled. Too much fuel in Tank volume. Plz, try again with a lower amount of fuel.");
        } else {
            currentAmountOfFuel += fuelQuantity;
        }
    }

    @Override
    public void repair() {
        isWork = true;
        System.out.println("Car has been repaired.");
    }



    public int getFreeCapacity () {
        return passengerCapacity - order.getPassengerCapacity();
    }

    @Override
    public String toString() {
        return "PassengerTransport{" +
                "passengerCapacity=" + passengerCapacity +
                ", brand=" + brand +
                ", model='" + model + '\'' +
                '}';
    }


    public void setOrder(Order order) {
        this.order = order;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }


}
