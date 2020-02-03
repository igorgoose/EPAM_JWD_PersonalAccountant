package schepov.javatr.bank.controller.exception;

public class DeleteUserControllerException extends Exception{
    public DeleteUserControllerException() {
        super();
    }

    public DeleteUserControllerException(Throwable cause) {
        super(cause);
    }

    public DeleteUserControllerException(String message){
        super(message);
    }

    public DeleteUserControllerException(String message, Throwable cause){
        super(message, cause);
    }
}
