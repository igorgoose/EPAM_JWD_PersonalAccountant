package schepov.javatr.bank.controller.exception;

public class WrongRequestControllerException extends Exception {
    public WrongRequestControllerException() {
        super();
    }

    public WrongRequestControllerException(Throwable cause) {
        super(cause);
    }

    public WrongRequestControllerException(String message){
        super(message);
    }

    public WrongRequestControllerException(String message, Throwable cause){
        super(message, cause);
    }
}
