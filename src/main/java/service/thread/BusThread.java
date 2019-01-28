package service.thread;

import entity.BusStop;
import entity.Passenger;
import entity.Route;
import service.dispatcher.BusDispatcher;
import service.dispatcher.BusStopDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class BusThread implements Callable<String> {
    private BusDispatcher busDispatcher;
    private List<BusStopDispatcher> actualRouteList = new ArrayList<>();
    private BusStopDispatcher currentStopDispatcher;

    public BusThread(BusDispatcher busDispatcher) {
        this.busDispatcher = busDispatcher;
    }

    private boolean selectToDeparture(Passenger p) {
        BusStop destination = p.getDestinationBusStop();
        for (BusStopDispatcher bsd : actualRouteList) {
            BusStop busStop = bsd.getBusStop();
            if (busStop.equals(destination)) {
                return true;
            }
        }
        return false;
    }

    private boolean selectToArrive(Passenger p) {
        BusStop destination = p.getDestinationBusStop();
        BusStop currentStop = currentStopDispatcher.getBusStop();
        return destination.equals(currentStop);
    }

    public String call() {
        List<Passenger> busListOfPassengers = busDispatcher.getListOfPassengers();
        Route route = busDispatcher.getRoute();
        List<BusStopDispatcher> fullRouteList = route.getListOfBusStopDispatcher();
        int stopsAmount = fullRouteList.size();
        for (int i = 0; i < stopsAmount; i++) {
            currentStopDispatcher = fullRouteList.get(i);
            actualRouteList = fullRouteList.subList(i + 1, stopsAmount);
            try {
                List<Passenger> busStopListOfPassengers = currentStopDispatcher.getListOfPassengers();
                List<Passenger> removeList = new ArrayList<>();
                busListOfPassengers.stream()
                        .filter(this::selectToArrive)
                        .forEach((p) -> {
                            removeList.add(p);
                            busStopListOfPassengers.add(p);
                        });
                busListOfPassengers.removeAll(removeList);
                removeList.clear();
                busStopListOfPassengers.stream()
                        .filter(this::selectToDeparture)
                        .forEach((p) -> {
                            if(busListOfPassengers.size() < busDispatcher.getBus().getCapacity()) {
                                removeList.add(p);
                                busListOfPassengers.add(p);
                            }
                        });
                busStopListOfPassengers.removeAll(removeList);
                currentStopDispatcher
                        .getSemaphore()
                        .release();
            } catch (InterruptedException e) {
                return null;
            }
        }
        return "thread done";
    }
}
