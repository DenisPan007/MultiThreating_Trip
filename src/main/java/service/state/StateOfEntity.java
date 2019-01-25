package service.state;

public interface StateOfEntity {
    StateOfEntity next();
    StateOfEntity previous();
}
