package entity;

public enum PassengerEnum {
    NAME("name"),
    DESTINATION("destination"),
    PASSENGERS("pasengers"),
    PASSENGER("passenger");
    private String value;
    PassengerEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
