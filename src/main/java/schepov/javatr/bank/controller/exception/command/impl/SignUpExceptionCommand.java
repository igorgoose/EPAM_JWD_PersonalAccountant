package schepov.javatr.bank.controller.exception.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpExceptionCommand implements ExceptionCommand {

    private static final SignUpExceptionCommand instance = new SignUpExceptionCommand();

    private SignUpExceptionCommand(){

    }

    public static SignUpExceptionCommand getInstance(){
        return instance;
    }

    @Override
    public String execute(Exception e, Logger logger) {
        logger.log(Level.WARNING, StringLiterals.RESPONSE_SIGN_UP_FAIL, e);
        return StringLiterals.RESPONSE_SIGN_UP_FAIL;
    }
}
