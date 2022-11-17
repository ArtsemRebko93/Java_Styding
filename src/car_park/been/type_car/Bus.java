package car_park.been.type_car;

import car_park.been.enums.Brand;
import car_park.been.PassengerTransport;
import car_park.been.enums.TypeOfFuel;

public class Bus extends PassengerTransport {
    public Bus(int yearOfManufacture, Brand brand,
               String model, TypeOfFuel typeOfFuel,
               double consumption, boolean isWork,
               double fuelTankVolume, int passengerCapacity,
               boolean isClean) {
        super(yearOfManufacture, brand, model, typeOfFuel, consumption, isWork, fuelTankVolume, passengerCapacity, isClean);
    }
}
