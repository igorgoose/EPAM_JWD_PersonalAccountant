package schepov.javatr.bank.controller.command.impl;


import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.Account;
import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.exception.SignUpControllerException;
import schepov.javatr.bank.srvc.AccountService;
import schepov.javatr.bank.srvc.ClientService;
import schepov.javatr.bank.srvc.exception.AccountServiceException;
import schepov.javatr.bank.srvc.exception.ClientServiceException;
import schepov.javatr.bank.srvc.factory.ServiceFactory;

public class SignUp implements Command {

    @Override
    public String execute(String request) throws Exception{
        String id;
        String password;
        Account newAccount;

        String[] params = request.split(StringLiterals.SPACE_DELIMITER);
        if(params.length < 3){
            throw new SignUpControllerException("Invalid request!");
        }

        id = params[1];
        password = params[2];

        ServiceFactory factory = ServiceFactory.getInstance();
        ClientService clientService = factory.getClientService();
        AccountService accountService = factory.getAccountService();

        try {
            clientService.signUp(id, password);
            newAccount = new Account();
            newAccount.setId(id);
            newAccount.setIncome(0);
            newAccount.setExpenses(0);
            accountService.addAccount(newAccount);
        } catch (ClientServiceException | AccountServiceException e) {
            throw new SignUpControllerException(StringLiterals.RESPONSE_SIGN_UP_FAIL, e);
        }
        return StringLiterals.RESPONSE_SIGN_UP_SUCCESS;
    }
}
