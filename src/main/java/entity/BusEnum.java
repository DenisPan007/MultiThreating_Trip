package entity;

public enum BusEnum {
    ID("id"),
    CAPACITY("capacity"),
    BUSES("buses"),
    BUS("bus");
    private String value;
    BusEnum(String value) {
            this.value = value;
    }
    public String getValue() {
        return value;
    }
    }
