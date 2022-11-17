package car_park.been;

import car_park.been.enums.TypeOfCargo;

import java.util.Random;

public class Order {
    private String startPoint;
    private String endPoint;
    private String numberOfOrder;
    private int passengerCapacity;
    private TypeOfCargo typeOfCargo;
    private double volume;
    private double weight;

    public Order() {
    }

    public Order(String startPoint, String endPoint, int passengerCapacity) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        numberOfOrder = generateNumberOfOrder();
        this.passengerCapacity = passengerCapacity;
    }

    public Order(String startPoint, String endPoint, TypeOfCargo typeOfCargo, double volume, double weight) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.typeOfCargo = typeOfCargo;
        this.volume = volume;
        this.weight = weight;
        numberOfOrder = generateNumberOfOrder();
    }

    public TypeOfCargo getTypeOfCargo() {
        return typeOfCargo;
    }

    public void setTypeOfCargo(TypeOfCargo typeOfCargo) {
        this.typeOfCargo = typeOfCargo;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    private String generateNumberOfOrder() {
        String[] array = {"AAA", "BBB", "CCC", "DDD"};
        StringBuilder builder = new StringBuilder();
        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            builder.append("%-3d %s\n").append(r.nextInt(100)).append(array[i]);
        }
        return builder.toString();
    }
    public String getNumberOfOrder() {
        return numberOfOrder;
    }

    @Override
    public String toString() {
        return "Order: " + numberOfOrder;
    }
}
