package util;

import entity.Entity;

import java.util.List;

public interface EntityBuilder<T extends Entity> {
    List<T> build(String filepath);
}
