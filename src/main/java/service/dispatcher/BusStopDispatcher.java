package service.dispatcher;

import entity.BusStop;
import entity.Passenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BusStopDispatcher {
    private BusStop busStop;
    private Semaphore semaphore;
    private List<Passenger> listOfPassengers;

    public BusStopDispatcher() {
        this.semaphore = new Semaphore(1);
        this.listOfPassengers = new ArrayList<>();
    }

    public BusStopDispatcher(BusStop busStop, Passenger... listOfPassengers) {
        this.busStop = busStop;
        this.listOfPassengers = new ArrayList<>(Arrays.asList(listOfPassengers));
        this.semaphore = new Semaphore(1);
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = busStop;
    }

    public void setListOfPassengers(List<Passenger> listOfPassengers) {
        this.listOfPassengers = listOfPassengers;
    }

    public BusStop getBusStop() {
        return busStop;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public List<Passenger> getListOfPassengers() throws InterruptedException {
        semaphore.acquire();
        return listOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusStopDispatcher)) return false;

        BusStopDispatcher that = (BusStopDispatcher) o;

        if (getBusStop() != null ? !getBusStop().equals(that.getBusStop()) : that.getBusStop() != null) return false;
        return listOfPassengers != null ? listOfPassengers.equals(that.listOfPassengers) : that.listOfPassengers == null;
    }

    @Override
    public int hashCode() {
        int result = getBusStop() != null ? getBusStop().hashCode() : 0;
        result = 31 * result + (listOfPassengers != null ? listOfPassengers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusStopDispatcher{");
        sb.append("busStop=").append(busStop);
        sb.append(", listOfPassengers=").append(listOfPassengers);
        sb.append('}');
        return sb.toString();
    }

}
