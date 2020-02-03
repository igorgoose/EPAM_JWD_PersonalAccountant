package schepov.javatr.bank.controller.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.exception.LogInControllerException;
import schepov.javatr.bank.srvc.ClientService;
import schepov.javatr.bank.srvc.exception.ClientServiceException;
import schepov.javatr.bank.srvc.factory.ServiceFactory;

public class LogIn implements Command {

    @Override
    public String execute(String request) throws Exception{
        String id;
        String password;
        String userInfo;

        String[] params = request.split(StringLiterals.SPACE_DELIMITER);
        if(params.length < 3){
            throw new LogInControllerException("Invalid request!");
        }
        id = params[1];
        password = params[2];

        ServiceFactory factory = ServiceFactory.getInstance();
        ClientService clientService = factory.getClientService();

        try {
            User user = clientService.logIn(id, password);
            userInfo = user.getId() + " " + user.getPassword();
            return StringLiterals.RESPONSE_LOG_IN_SUCCESS + "\n"
                    + StringLiterals.RESPONSE_USER_INFO + "(" + userInfo + ")";
        } catch (ClientServiceException e) {
            throw new LogInControllerException(StringLiterals.RESPONSE_LOG_IN_FAIL, e);
        }
    }
}
