package schepov.javatr.bank.controller.command;

import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.command.CommandName;
import schepov.javatr.bank.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SIGN_UP, new SignUp());
        repository.put(CommandName.LOG_IN, new LogIn());
        repository.put(CommandName.DELETE_USER, new DeleteUser());
        repository.put(CommandName.GET_STATS, new GetStats());
        repository.put(CommandName.CHANGE_INCOME, new ChangeIncome());
        repository.put(CommandName.CHANGE_EXPENSES, new ChangeExpenses());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.RESET_STATS, new ResetStats());

    }

    public Command getCommand(String name) {
        CommandName commandName;
        Command command;
        commandName = CommandName.valueOf(name.toUpperCase());
        if (repository.containsKey(commandName)) {
            command = repository.get(commandName);
            return command;
        }
        command = repository.get(CommandName.WRONG_REQUEST);
        return command;
    }
}
