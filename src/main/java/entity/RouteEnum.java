package entity;

public enum RouteEnum {
    NUMBER("number"),
    BUS_STOPS("busStops"),
    ROUTES("routes"),
    ROUTE("route"),
    STOP("stop");
    private String value;
    RouteEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
