package schepov.javatr.bank.controller.exception.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WrongRequestExceptionCommand implements ExceptionCommand {

    private static final WrongRequestExceptionCommand instance = new WrongRequestExceptionCommand();

    private WrongRequestExceptionCommand(){

    }

    public static WrongRequestExceptionCommand getInstance(){
        return instance;
    }

    @Override
    public String execute(Exception e, Logger logger) {
        logger.log(Level.WARNING, StringLiterals.RESPONSE_WRONG_REQUEST, e);
        return StringLiterals.RESPONSE_WRONG_REQUEST;
    }
}
