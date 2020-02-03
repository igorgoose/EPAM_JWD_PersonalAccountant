package schepov.javatr.bank.srvc;


import schepov.javatr.bank.bean.Account;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.srvc.exception.AccountServiceException;

public interface AccountService {
    //void transferMoney(User user, String recipientID, double amount) throws AccountServiceException;
    String getStats(User user) throws AccountServiceException;
    void changeIncome(User user, String newIncome) throws AccountServiceException;
    void changeExpenses(User user, String newExpenses) throws AccountServiceException;
    void addAccount(Account account) throws AccountServiceException;
    void deleteAccount(String id) throws AccountServiceException;
}
