package schepov.javatr.bank.controller.command.impl;


import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.exception.WrongRequestControllerException;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) throws Exception {
        throw new WrongRequestControllerException("Invalid request!");
    }
}
