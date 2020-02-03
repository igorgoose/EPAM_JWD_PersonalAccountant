package schepov.javatr.bank.view.scanner.exception;

public class NoNumberInLineException extends Exception {
    public NoNumberInLineException(){
        super();
    }

    public NoNumberInLineException(String message){
        super(message);
    }

    public NoNumberInLineException(Throwable cause){
        super(cause);
    }

    public NoNumberInLineException(String message, Throwable cause){
        super(message, cause);
    }
}
