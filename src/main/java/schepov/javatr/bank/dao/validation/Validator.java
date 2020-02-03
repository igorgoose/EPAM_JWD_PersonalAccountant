package schepov.javatr.bank.dao.validation;

public class Validator {

    private static Validator instance = new Validator();

    private Validator(){

    }

    public static Validator getInstance() {
        return instance;
    }

    public boolean isValidLine(String[] tokens, int tokensExpected){
        return tokens.length >= tokensExpected;
    }
}
