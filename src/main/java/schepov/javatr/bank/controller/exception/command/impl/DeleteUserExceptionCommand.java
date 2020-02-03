package schepov.javatr.bank.controller.exception.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteUserExceptionCommand implements ExceptionCommand{

    private static final DeleteUserExceptionCommand instance = new DeleteUserExceptionCommand();

    private DeleteUserExceptionCommand(){

    }

    public static DeleteUserExceptionCommand getInstance(){
        return instance;
    }

    @Override
    public String execute(Exception e, Logger logger) {
        logger.log(Level.WARNING, StringLiterals.RESPONSE_DELETE_USER_FAIL, e);
        return StringLiterals.RESPONSE_DELETE_USER_FAIL;
    }
}
