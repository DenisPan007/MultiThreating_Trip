package service.dispatcher;

import entity.Bus;
import entity.Passenger;
import entity.Route;

import java.util.LinkedList;
import java.util.List;

public class BusDispatcher {
    private Bus bus;
    private Route route;
    private List<Passenger> listOfPassengers = new LinkedList<>();

    public BusDispatcher(Bus bus, Route route) {
        this.bus = bus;
        this.route = route;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public List<Passenger> getListOfPassengers() {
        return listOfPassengers;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

}
