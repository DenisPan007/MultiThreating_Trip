package service.parser;

import entity.Entity;
import service.parser.builder.AbstractEntitiesBuilder;
import service.parser.builder.BuilderException;
import service.validate.ValidatorException;
import service.validate.ValidatorSaxXsd;

import java.util.Set;

public class EntityParser<T extends Entity> {
    private ValidatorSaxXsd validator = new ValidatorSaxXsd();
    private AbstractEntitiesBuilder<T> builder;

    public EntityParser(AbstractEntitiesBuilder<T> builder) {
        this.builder = builder;
    }

    public Set<T> parse(String filePath, String schemaPath) throws XmlParserException {
        try {
            validator.validate(filePath, schemaPath);
            builder.buildSetEntities(filePath);
            return builder.getEntities();
        } catch (ValidatorException | BuilderException e) {
            throw new XmlParserException(e);
        }
    }
}
