package schepov.javatr.bank.controller.exception.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInExceptionCommand implements ExceptionCommand {

    private static final LogInExceptionCommand instance = new LogInExceptionCommand();

    private LogInExceptionCommand(){

    }

    public static LogInExceptionCommand getInstance(){
        return instance;
    }


    @Override
    public String execute(Exception e, Logger logger) {
        logger.log(Level.WARNING, StringLiterals.RESPONSE_LOG_IN_FAIL, e);
        return StringLiterals.RESPONSE_LOG_IN_FAIL;
    }
}
