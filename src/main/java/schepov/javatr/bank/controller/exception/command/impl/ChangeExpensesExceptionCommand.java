package schepov.javatr.bank.controller.exception.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.command.impl.ChangeExpenses;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeExpensesExceptionCommand implements ExceptionCommand {

    private static final ChangeExpensesExceptionCommand instance = new ChangeExpensesExceptionCommand();

    private ChangeExpensesExceptionCommand(){

    }

    public static ChangeExpensesExceptionCommand getInstance(){
        return instance;
    }

    @Override
    public String execute(Exception e, Logger logger) {
        logger.log(Level.WARNING, StringLiterals.RESPONSE_CHANGE_EXPENSE_FAIL, e);
        return StringLiterals.RESPONSE_CHANGE_EXPENSE_FAIL;
    }
}
