package schepov.javatr.bank.dao.exception;

public class DAOException extends Exception {

    public DAOException() {
        super();
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(String message, Throwable cause){
        super(message, cause);
    }
}
