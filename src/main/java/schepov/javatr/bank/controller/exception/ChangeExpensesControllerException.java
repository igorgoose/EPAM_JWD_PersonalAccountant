package schepov.javatr.bank.controller.exception;

public class ChangeExpensesControllerException extends Exception{

    public ChangeExpensesControllerException() {
        super();
    }

    public ChangeExpensesControllerException(Throwable cause) {
        super(cause);
    }

    public ChangeExpensesControllerException(String message){
        super(message);
    }

    public ChangeExpensesControllerException(String message, Throwable cause){
        super(message, cause);
    }
}
