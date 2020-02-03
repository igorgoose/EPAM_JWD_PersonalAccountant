package schepov.javatr.bank.controller.exception.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ResetStatsExceptionCommand implements ExceptionCommand {

    private static final ResetStatsExceptionCommand instance = new ResetStatsExceptionCommand();

    private ResetStatsExceptionCommand(){

    }

    public static ResetStatsExceptionCommand getInstance(){
        return instance;
    }

    @Override
    public String execute(Exception e, Logger logger) {
        logger.log(Level.WARNING, StringLiterals.RESPONSE_RESET_STATS_FAIL, e);
        return StringLiterals.RESPONSE_RESET_STATS_FAIL;
    }
}
