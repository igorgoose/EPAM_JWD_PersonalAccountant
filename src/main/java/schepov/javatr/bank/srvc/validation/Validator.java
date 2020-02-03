package schepov.javatr.bank.srvc.validation;

import schepov.javatr.bank.bean.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final Validator instance = new Validator();

    private static final String LOGIN_AND_PASSWORD_PATTERN = "\\w*\\w{6}";

    private Validator(){

    }

    public static Validator getInstance() {
        return instance;
    }

    public boolean isValidLoginOrPassword(String loginOrPassword){
        if(loginOrPassword == null){
            return false;
        }
        Pattern pattern = Pattern.compile(LOGIN_AND_PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(loginOrPassword);
        return matcher.matches();
    }

    public boolean dataMatches(User user, String id, String password){
        if(user == null || id == null || password == null){
            return false;
        }
        return user.getId().equals(id) && user.getPassword().equals(password);
    }

    public boolean isValidAmount(double amount){
        return amount > 0;
    }

}
