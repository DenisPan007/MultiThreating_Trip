package service.validate;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorSaxXsdTest {

    @Test
    public void validate() throws ValidatorException {
        String filePath = "src/test/resources/Buses.xml";
        String schemaPath = "src/test/resources/BusesXsd.xsd";
        ValidatorSaxXsd validator = new ValidatorSaxXsd();
        validator.validate(filePath,schemaPath);
    }
}
