package car_park.been;

import car_park.been.enums.Brand;
import car_park.been.enums.TypeOfBody;
import car_park.been.enums.TypeOfFuel;
import car_park.been.interfaces.CarryingCargo;
import car_park.been.interfaces.CarryingPassengers;
import car_park.been.interfaces.Serviced;

public class CargoPassengerTransport extends Transport implements CarryingPassengers, CarryingCargo, Serviced {
    private Order order;
    private boolean isFree;
    private double bodyVolume; //обьем кузова
    private double loadCapacity; //грузоподьемность
    private TypeOfBody typeOfBody;
    private int passengerCapacity;
    private boolean isClean;
    private boolean isSeal;

//    public CargoPassengerTransport(double currentAmountOfFuel, Order order, boolean isFree, double bodyVolume, double loadCapacity, TypeOfBody typeOfBody, int passengerCapacity, boolean isClean, boolean isSeal) {
//        super(currentAmountOfFuel);
//        this.order = order;
//        this.isFree = isFree;
//        this.bodyVolume = bodyVolume;
//        this.loadCapacity = loadCapacity;
//        this.typeOfBody = typeOfBody;
//        this.passengerCapacity = passengerCapacity;
//        this.isClean = isClean;
//        this.isSeal = isSeal;
//    }

    public CargoPassengerTransport(int yearOfManufacture, Brand brand, String model, TypeOfFuel typeOfFuel, double consumption, boolean isWork, double fuelTankVolume, boolean isFree, double bodyVolume, double loadCapacity, TypeOfBody typeOfBody, int passengerCapacity, boolean isClean, boolean isSeal) {
        super(yearOfManufacture, brand, model, typeOfFuel, consumption, isWork, fuelTankVolume);
        this.isFree = isFree;
        this.bodyVolume = bodyVolume;
        this.loadCapacity = loadCapacity;
        this.typeOfBody = typeOfBody;
        this.passengerCapacity = passengerCapacity;
        this.isClean = isClean;
        this.isSeal = isSeal;
    }

    public double getBodyVolume() {
        return bodyVolume;
    }

    public void setBodyVolume(double bodyVolume) {
        this.bodyVolume = bodyVolume;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
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

    public boolean isSeal() {
        return isSeal;
    }

    public void setSeal(boolean seal) {
        isSeal = seal;
    }

    @Override
    public void sealTheBody() {
        isSeal = true;
    }

    @Override
    public void cleanTheSalon() {
        isClean = true;
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

    @Override
    public String toString() {
        return "CargoPassengerTransport{" +
                "bodyVolume=" + bodyVolume +
                ", loadCapacity=" + loadCapacity +
                ", typeOfBody=" + typeOfBody +
                ", passengerCapacity=" + passengerCapacity +
                ", isClean=" + isClean +
                ", isSeal=" + isSeal +
                ", yearOfManufacture=" + yearOfManufacture +
                ", brand=" + brand +
                ", model='" + model + '\'' +
                ", typeOfFuel=" + typeOfFuel +
                ", consumption=" + consumption +
                ", isWork=" + isWork +
                ", fuelTankVolume=" + fuelTankVolume +
                '}';
    }
}
