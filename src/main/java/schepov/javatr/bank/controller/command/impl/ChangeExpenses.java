package schepov.javatr.bank.controller.command.impl;


import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.exception.ChangeExpensesControllerException;
import schepov.javatr.bank.srvc.AccountService;
import schepov.javatr.bank.srvc.exception.AccountServiceException;
import schepov.javatr.bank.srvc.factory.ServiceFactory;

public class ChangeExpenses implements Command {

    @Override
    public String execute(String request) throws ChangeExpensesControllerException {
        String id;
        String password;
        String newExpenses;

        String[] params = request.split(StringLiterals.SPACE_DELIMITER);
        if(params.length < 4){
            throw new ChangeExpensesControllerException("Invalid request!");
        }

        id = params[1];
        password = params[2];
        newExpenses = params[3];

        ServiceFactory factory = ServiceFactory.getInstance();
        AccountService accountService = factory.getAccountService();

        User user = new User();
        user.setId(id);
        user.setPassword(password);

        try {
            accountService.changeExpenses(user, newExpenses);
            return StringLiterals.RESPONSE_CHANGE_EXPENSES_SUCCESS;
        } catch (AccountServiceException e) {
            throw new ChangeExpensesControllerException(StringLiterals.RESPONSE_CHANGE_EXPENSE_FAIL, e);
        }

    }
}
