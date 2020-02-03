package schepov.javatr.bank.controller.exception;

public class ChangeIncomeControllerException extends Exception{
    public ChangeIncomeControllerException() {
        super();
    }

    public ChangeIncomeControllerException(Throwable cause) {
        super(cause);
    }

    public ChangeIncomeControllerException(String message){
        super(message);
    }

    public ChangeIncomeControllerException(String message, Throwable cause){
        super(message, cause);
    }
}
