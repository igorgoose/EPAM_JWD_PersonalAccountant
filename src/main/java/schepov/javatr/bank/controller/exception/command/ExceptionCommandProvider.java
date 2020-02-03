package schepov.javatr.bank.controller.exception.command;

import schepov.javatr.bank.controller.command.impl.*;
import schepov.javatr.bank.controller.exception.*;
import schepov.javatr.bank.controller.exception.command.impl.*;

public class ExceptionCommandProvider {

    private static final ExceptionCommandProvider instance = new ExceptionCommandProvider();

    private ExceptionCommandProvider() {

    }

    public static ExceptionCommandProvider getInstance() {
        return instance;
    }

    public ExceptionCommand provideCommand(Exception e) {
        switch (e.getClass().getSimpleName()) {
            case "ChangeExpensesControllerException":
                return ChangeExpensesExceptionCommand.getInstance();
            case "ChangeIncomeControllerException":
                return ChangeIncomeExceptionCommand.getInstance();
            case "DeleteUserControllerException":
                return DeleteUserExceptionCommand.getInstance();
            case "GetStatsControllerException":
                return GetStatsExceptionCommand.getInstance();
            case "LogInControllerException":
                return LogInExceptionCommand.getInstance();
            case "ResetStatsControllerException":
                return ResetStatsExceptionCommand.getInstance();
            case "SignUpControllerException":
                return SignUpExceptionCommand.getInstance();
            case "WrongRequestControllerException":
                return WrongRequestExceptionCommand.getInstance();
            default:
                return DifferentExceptionCommand.getInstance();
        }
    }
}
