package schepov.javatr.bank.controller.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.exception.DeleteUserControllerException;
import schepov.javatr.bank.srvc.AccountService;
import schepov.javatr.bank.srvc.ClientService;
import schepov.javatr.bank.srvc.exception.AccountServiceException;
import schepov.javatr.bank.srvc.exception.ClientServiceException;
import schepov.javatr.bank.srvc.factory.ServiceFactory;

public class DeleteUser implements Command {

    @Override
    public String execute(String request) throws DeleteUserControllerException {
        String id;
        String password;
        String enteredID;
        String enteredPassword;

        String[] params = request.split(StringLiterals.SPACE_DELIMITER);
        if(params.length < 5){
            throw new DeleteUserControllerException("Invalid request!");
        }

        id = params[1];
        password = params[2];
        enteredID = params[3];
        enteredPassword = params[4];

        ServiceFactory factory = ServiceFactory.getInstance();
        ClientService clientService = factory.getClientService();
        AccountService accountService = factory.getAccountService();

        User user = new User();
        user.setId(id);
        user.setPassword(password);

        try {
            clientService.deleteUser(user, enteredID, enteredPassword);
            accountService.deleteAccount(user.getId());
            return StringLiterals.RESPONSE_OK + " " + StringLiterals.RESPONSE_DELETE_USER_SUCCESS;
        } catch (ClientServiceException | AccountServiceException e) {
            throw new DeleteUserControllerException(StringLiterals.RESPONSE_DELETE_USER_FAIL, e);
        }

    }
}
