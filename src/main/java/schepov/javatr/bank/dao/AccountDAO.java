package schepov.javatr.bank.dao;

import schepov.javatr.bank.bean.Account;
import schepov.javatr.bank.dao.exception.DAOException;

public interface AccountDAO {
    Account getAccount(String id) throws DAOException;
    void updateAccount(Account account) throws DAOException;
    void addAccount(Account account) throws DAOException;
    void deleteAccount(String id) throws DAOException;
}
