import car_park.been.*;
import car_park.been.enums.Brand;
import car_park.been.enums.TypeOfFuel;


public class test {
    public static void main(String[] args) {
        CarPark park = new CarPark();
        Transport vwBus = new PassengerTransport(2020, Brand.Volkswagen,"Caravella", TypeOfFuel.DIESEL,8.0,true,75,20,true);
        Order order = new Order("Moscow","Minsk",10);
        park.addOrder(order);
        park.addCar(vwBus);
        park.getInfoAboutCarByNumberOfOrder(order.getNumberOfOrder());
        }
    }