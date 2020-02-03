package schepov.javatr.bank.controller.exception.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeIncomeExceptionCommand implements ExceptionCommand {

    private static final ChangeIncomeExceptionCommand instance = new ChangeIncomeExceptionCommand();

    private ChangeIncomeExceptionCommand(){

    }

    public static ChangeIncomeExceptionCommand getInstance(){
        return instance;
    }

    @Override
    public String execute(Exception e, Logger logger) {
        logger.log(Level.WARNING, StringLiterals.RESPONSE_CHANGE_INCOME_FAIL, e);
        return StringLiterals.RESPONSE_CHANGE_INCOME_FAIL;
    }
}
