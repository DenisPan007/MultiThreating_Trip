package entity;

public class Bus extends  Entity {
    private long id;
    private final int capacity;


    public Bus(long id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;

        Bus bus = (Bus) o;

        if (getId() != bus.getId()) return false;
        return getCapacity() == bus.getCapacity();
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getCapacity();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bus{");
        sb.append("id=").append(id);
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }

}
