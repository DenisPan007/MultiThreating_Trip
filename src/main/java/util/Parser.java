package util;

import entity.Entity;

import java.util.List;

public interface Parser<T extends Entity> {
   List<T> parse(String filePath);
}
