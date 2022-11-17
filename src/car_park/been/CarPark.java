package car_park.been;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CarPark {

    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Transport> carPark = new ArrayList<>();
    private ArrayList <Order> orderForCargoTransports = new ArrayList<>();
    private ArrayList <Order> orderForPassengerTransports = new ArrayList<>();

    public ArrayList<Order> getOrderForPassengerTransports() {
        return orderForPassengerTransports;
    }

    public ArrayList<? extends Transport> getTransportsForPassangers() {
        return transportsForPassangers;
    }

    private ArrayList <? extends Transport> transportsForPassangers = new ArrayList<>();
    private ArrayList <? extends Transport> transportsForCargo = new ArrayList<>();

    private HashMap<String, Transport> orderAndTransport = new HashMap<>();

    public CarPark() {
    }

    private Transport matchFreeCargoTransport (Order order) {
        if (transportsForPassangers.size() == 0) {
            return null;
        }
        int matchCar = 0;
        for (int i = 0; i < transportsForCargo.size(); i++) {
            if (transportsForCargo.get(i).getStatus(order)) {
                matchCar = i;
                break;
            }
        }
        transportsForCargo.get(matchCar).isFree = false;
        return transportsForCargo.get(matchCar);
    }

    private Transport matchFreePassengerTransport (Order order) {
        if (transportsForPassangers.size() == 0) {
            return null;
        }
        int matchCar = 0;
        for (int i = 0; i < transportsForPassangers.size(); i++) {
            if (transportsForPassangers.get(i).getStatus(order)) {
                matchCar = i;
                break;
            }
        }
        transportsForPassangers.get(matchCar).isFree = false;
        return transportsForPassangers.get(matchCar);
    }



    private void sortOrders() {
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getPassengerCapacity() != 0) {
                orderForPassengerTransports.add(orders.get(i));
                orders.remove(orders.get(i));
            } else {
                orderForCargoTransports.add(orders.get(i));
                orders.remove(orders.get(i));
            }
        }
    }
    public void assignCarToCargoOrder() {
        for (Order orderForCargoTransport : orderForCargoTransports) {
            orderAndTransport.put(orderForCargoTransport.getNumberOfOrder(), matchFreeCargoTransport(orderForCargoTransport));
        }
    }


    public void assignCarToPassengerOrder() {
        for (Order orderForPassengerTransport : orderForPassengerTransports) {
            orderAndTransport.put(orderForPassengerTransport.getNumberOfOrder(), matchFreePassengerTransport(orderForPassengerTransport));
        }
    }

    public void getInfoAboutCarByNumberOfOrder(String numberOfOrder) {
        System.out.println(orderAndTransport.get(numberOfOrder).toString());
    }



    public ArrayList<Transport> getCarPark() {
        return carPark;
    }

    public void addCar (Transport transport) {
        carPark.add(transport);
    }

    public void addOrder (Order order) {
        orders.add(order);
        sortOrders();
        assignCarToCargoOrder();
        assignCarToPassengerOrder();
    }
}
