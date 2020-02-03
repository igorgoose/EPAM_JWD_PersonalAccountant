package schepov.javatr.bank.controller.command.impl;


import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.controller.command.Command;
import schepov.javatr.bank.controller.exception.GetStatsControllerException;
import schepov.javatr.bank.controller.exception.SignUpControllerException;
import schepov.javatr.bank.srvc.AccountService;
import schepov.javatr.bank.srvc.exception.AccountServiceException;
import schepov.javatr.bank.srvc.factory.ServiceFactory;

public class GetStats implements Command {

    @Override
    public String execute(String request) throws Exception{
        String id;
        String password;
        String stats;

        String[] params = request.split(StringLiterals.SPACE_DELIMITER);
        if(params.length < 3){
            throw new GetStatsControllerException("Invalid request!");
        }

        id = params[1];
        password = params[2];

        ServiceFactory factory = ServiceFactory.getInstance();
        AccountService accountService = factory.getAccountService();

        User user = new User();
        user.setId(id);
        user.setPassword(password);

        try {
           stats = accountService.getStats(user);
            return stats;
        } catch (AccountServiceException e) {
            throw new SignUpControllerException(StringLiterals.RESPONSE_GET_STATS_FAIL, e);
        }

    }
}
