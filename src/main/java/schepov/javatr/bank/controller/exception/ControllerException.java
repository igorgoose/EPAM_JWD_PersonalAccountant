package schepov.javatr.bank.controller.exception;

public class ControllerException extends Exception {
    public ControllerException() {
        super();
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }

    public ControllerException(String message){
        super(message);
    }

    public ControllerException(String message, Throwable cause){
        super(message, cause);
    }
}
