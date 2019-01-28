package entity;

public class BusStop extends  Entity {
    private int number;

    public BusStop(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusStop)) return false;

        BusStop busStop = (BusStop) o;

        return getNumber() == busStop.getNumber();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + getNumber();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusStop{");
        sb.append(", number=").append(number);
        sb.append('}');
        return sb.toString();
    }

}

