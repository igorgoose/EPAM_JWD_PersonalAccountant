package schepov.javatr.bank.controller;


import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.command.CommandProvider;
import schepov.javatr.bank.controller.exception.*;
import schepov.javatr.bank.controller.exception.WrongRequestControllerException;
import schepov.javatr.bank.controller.exception.command.ExceptionCommand;
import schepov.javatr.bank.controller.exception.command.ExceptionCommandProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private static Logger logger = Logger.getLogger(Controller.class.getName());
    private final CommandProvider provider = new CommandProvider();

    public String execute(String request){
        String response;
        Command command;
        String commandName;

        char paramDelimiter = ' ';
        commandName = request.substring(0, request.indexOf(paramDelimiter));
        command = provider.getCommand(commandName);
        try {
            response = command.execute(request);
        } catch (Exception e) {
            ExceptionCommandProvider provider = ExceptionCommandProvider.getInstance();
            ExceptionCommand exceptionCommand = provider.provideCommand(e);
            return exceptionCommand.execute(e, logger);
        }
        return response;
    }

}
