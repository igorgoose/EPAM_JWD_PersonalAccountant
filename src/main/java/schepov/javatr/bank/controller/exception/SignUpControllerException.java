package schepov.javatr.bank.controller.exception;

public class SignUpControllerException extends Exception {
    public SignUpControllerException() {
        super();
    }

    public SignUpControllerException(Throwable cause) {
        super(cause);
    }

    public SignUpControllerException(String message){
        super(message);
    }

    public SignUpControllerException(String message, Throwable cause){
        super(message, cause);
    }
}
