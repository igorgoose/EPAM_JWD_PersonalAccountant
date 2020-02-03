package schepov.javatr.bank.controller.command.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.exception.ChangeExpensesControllerException;
import schepov.javatr.bank.controller.exception.ResetStatsControllerException;
import schepov.javatr.bank.srvc.AccountService;
import schepov.javatr.bank.srvc.exception.AccountServiceException;
import schepov.javatr.bank.srvc.factory.ServiceFactory;

public class ResetStats implements Command {

    @Override
    public String execute(String request) throws Exception {
        String id;
        String password;

        String[] params = request.split(StringLiterals.SPACE_DELIMITER);
        if(params.length < 3){
            throw new ResetStatsControllerException("Invalid request!");
        }

        id = params[1];
        password = params[2];

        ServiceFactory factory = ServiceFactory.getInstance();
        AccountService accountService = factory.getAccountService();

        User user = new User();
        user.setId(id);
        user.setPassword(password);

        try {
            accountService.changeExpenses(user, "0");
            accountService.changeIncome(user, "0");
            return StringLiterals.RESPONSE_RESET_STATS_SUCCESS;
        } catch (AccountServiceException e) {
            throw new ChangeExpensesControllerException(StringLiterals.RESPONSE_RESET_STATS_FAIL, e);
        }

    }
}
