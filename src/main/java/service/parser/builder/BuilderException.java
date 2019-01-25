package service.parser.builder;

public class BuilderException extends Exception {
    public BuilderException() {
    }

    public BuilderException(String message) {
        super(message);
    }

    public BuilderException(Throwable cause) {
        super(cause);
    }

    public BuilderException(String message, Throwable cause) {
        super(message, cause);
    }
}
