package schepov.javatr.bank.srvc.exception;

public class ClientServiceException extends Exception {
    public ClientServiceException() {
        super();
    }

    public ClientServiceException(Throwable cause) {
        super(cause);
    }

    public ClientServiceException(String message){
        super(message);
    }

    public ClientServiceException(String message, Throwable cause){
        super(message, cause);
    }
}

