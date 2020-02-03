package schepov.javatr.bank.controller.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.exception.ChangeIncomeControllerException;
import schepov.javatr.bank.srvc.AccountService;
import schepov.javatr.bank.srvc.exception.AccountServiceException;
import schepov.javatr.bank.srvc.factory.ServiceFactory;

public class ChangeIncome implements Command {

    @Override
    public String execute(String request) throws ChangeIncomeControllerException {
        String id;
        String password;
        String newIncome;

        String[] params = request.split(StringLiterals.SPACE_DELIMITER);
        if(params.length < 4){
            throw new ChangeIncomeControllerException("Invalid request!");
        }

        id = params[1];
        password = params[2];
        newIncome = params[3];

        ServiceFactory factory = ServiceFactory.getInstance();
        AccountService accountService = factory.getAccountService();

        User user = new User();
        user.setId(id);
        user.setPassword(password);

        try {
            accountService.changeIncome(user, newIncome);
            return StringLiterals.RESPONSE_CHANGE_INCOME_SUCCESS;
        } catch (AccountServiceException e) {
            throw new ChangeIncomeControllerException(StringLiterals.RESPONSE_CHANGE_INCOME_FAIL, e);
        }

    }
}
