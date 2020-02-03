package schepov.javatr.bank.view.scanner.exception;

public class NoInputInLineException extends Exception {
    public NoInputInLineException(){
        super();
    }

    public NoInputInLineException(String message){
        super(message);
    }

    public NoInputInLineException(Throwable cause){
        super(cause);
    }

    public NoInputInLineException(String message, Throwable cause){
        super(message, cause);
    }
}
