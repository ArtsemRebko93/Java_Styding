package car_park.been;

import car_park.been.enums.Brand;
import car_park.been.enums.TypeOfBody;
import car_park.been.enums.TypeOfCargo;
import car_park.been.enums.TypeOfFuel;
import car_park.been.interfaces.CarryingCargo;
import car_park.been.interfaces.Serviced;

public class CargoTransport extends Transport implements Serviced, CarryingCargo {
    private Order order;

    private boolean isFree;

    private double bodyVolume; //обьем кузова
    private TypeOfBody typeOfBody;
    private double loadCapacity; //грузоподьемность

    private boolean isSeal;

    private TypeOfCargo typeOfCargo;


    public CargoTransport(int yearOfManufacture, Brand brand, String model, TypeOfFuel typeOfFuel, double consumption, boolean isWork, double fuelTankVolume, boolean isFree, double bodyVolume, TypeOfBody typeOfBody, double loadCapacity, boolean isSeal, TypeOfCargo typeOfCargo) {
        super(yearOfManufacture, brand, model, typeOfFuel, consumption, isWork, fuelTankVolume);
        this.isFree = isFree;
        this.bodyVolume = bodyVolume;
        this.typeOfBody = typeOfBody;
        this.loadCapacity = loadCapacity;
        this.isSeal = isSeal;
        this.typeOfCargo = typeOfCargo;
    }

    public boolean getStatus(Order order) {
        this.order = order;
        if (bodyVolume > order.getVolume() && loadCapacity > order.getWeight()) {
            return isFree = true;
        } else return isFree = false;
    }

    private double getFreeBodyVolume() {
        return bodyVolume - order.getVolume();
    }

    private double gerFreeLoadCapacity() {
        return loadCapacity = order.getWeight();
    }

    @Override
    public void sealTheBody() {
        isSeal = true;
        System.out.println("Sealed.");
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
        return order.toString()
                +"\nFree load capacity: " + gerFreeLoadCapacity()
                +"\nFree body volume: " + getFreeBodyVolume();
    }



    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isFree() {
        return isFree;
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

    public TypeOfBody getTypeOfBody () {
        return typeOfBody;
    }

    public void setTypeOfBody (TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public boolean isSeal() {
        return isSeal;
    }

    public void setSeal(boolean seal) {
        isSeal = seal;
    }

    public TypeOfCargo getTypeOfCargo() {
        return typeOfCargo;
    }


}