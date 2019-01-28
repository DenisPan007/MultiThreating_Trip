package entity;

public class Passenger extends Entity{
   private String name;
   private BusStop destinationBusStop;

    public Passenger(String name, BusStop destinationBusStop) {
        this.name = name;
        this.destinationBusStop = destinationBusStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BusStop getDestinationBusStop() {
        return destinationBusStop;
    }

    public void setDestinationBusStop(BusStop destinationBusStop) {
        this.destinationBusStop = destinationBusStop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;

        Passenger passenger = (Passenger) o;

        if (getName() != null ? !getName().equals(passenger.getName()) : passenger.getName() != null) return false;
        return getDestinationBusStop() != null ? getDestinationBusStop().equals(passenger.getDestinationBusStop()) : passenger.getDestinationBusStop() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getDestinationBusStop() != null ? getDestinationBusStop().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Passenger{");
        sb.append("name='").append(name).append('\'');
        sb.append(", destinationBudStop=").append(destinationBusStop);
        sb.append('}');
        return sb.toString();
    }

}
