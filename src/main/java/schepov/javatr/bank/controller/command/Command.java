package schepov.javatr.bank.controller.command;

public interface Command {
    String execute(String request) throws Exception;
}
