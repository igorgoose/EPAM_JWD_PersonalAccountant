package schepov.javatr.bank.srvc.exception;

public class AccountServiceException extends Exception {
    public AccountServiceException() {
        super();
    }

    public AccountServiceException(Throwable cause) {
        super(cause);
    }

    public AccountServiceException(String message){
        super(message);
    }

    public AccountServiceException(String message, Throwable cause){
        super(message, cause);
    }
}
