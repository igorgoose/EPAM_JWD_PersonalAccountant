package schepov.javatr.bank.controller.exception.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DifferentExceptionCommand implements ExceptionCommand {

    private static final DifferentExceptionCommand instance = new DifferentExceptionCommand();

    private DifferentExceptionCommand(){

    }

    public static DifferentExceptionCommand getInstance(){
        return instance;
    }

    @Override
    public String execute(Exception e, Logger logger) {
        logger.log(Level.WARNING, StringLiterals.RESPONSE_OPERATION_FAIL, e);
        return StringLiterals.RESPONSE_OPERATION_FAIL;
    }
}
