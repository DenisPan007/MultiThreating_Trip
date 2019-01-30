package entity;

import service.dispatcher.BusStopDispatcher;

import java.util.List;

public class Route extends  Entity {
    private int number;
    private List<BusStopDispatcher> list;

    public Route() {
    }

    public Route(int number, List<BusStopDispatcher> listOfBusStops) {
        this.number = number;
        this.list = listOfBusStops;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<BusStopDispatcher> getListOfBusStopDispatcher() {
        return list;
    }

    public void setListOfBusStopDispatcher(List<BusStopDispatcher> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;

        Route route = (Route) o;

        if (getNumber() != route.getNumber()) return false;
        return list != null ? list.equals(route.list) : route.list == null;
    }

    @Override
    public int hashCode() {
        int result = getNumber();
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Route{");
        sb.append("number=").append(number);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }

}
