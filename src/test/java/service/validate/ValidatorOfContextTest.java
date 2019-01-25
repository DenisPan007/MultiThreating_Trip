package service.validate;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorOfContextTest {

    @Test
    public void validate() {
        String validString = "323523123";
        String pattern = "\\d+";
        Validator validator = new ValidatorOfContext(pattern);
        assertTrue(validator.validate(validString));
    }
}