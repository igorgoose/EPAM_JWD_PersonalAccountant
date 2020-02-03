package schepov.javatr.bank.controller.exception.command;

import java.util.logging.Logger;

public interface ExceptionCommand {
    String execute(Exception e, Logger logger);
}
