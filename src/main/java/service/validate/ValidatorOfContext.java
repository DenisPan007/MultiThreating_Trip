package service.validate;

public class ValidatorOfContext implements Validator {
    private String regex;

    public ValidatorOfContext(String regex) {
        this.regex = regex;
    }

    public boolean validate(String string) {
        return false;
    }
}
