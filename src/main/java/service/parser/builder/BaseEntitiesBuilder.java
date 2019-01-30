package service.parser.builder;

import entity.Entity;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseEntitiesBuilder<T extends Entity>  {
    protected Set<T> entities;
    public BaseEntitiesBuilder() {
        entities = new HashSet<>();
    }
    public BaseEntitiesBuilder(Set<T> entities) {
        this.entities = entities;
    }
    public Set<T> getEntities() {
        return entities;
    }
    abstract public void buildSetEntities(String fileName) throws BuilderException;
}
