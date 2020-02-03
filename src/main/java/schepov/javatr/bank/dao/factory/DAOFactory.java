package schepov.javatr.bank.dao.factory;


import schepov.javatr.bank.dao.AccountDAO;
import schepov.javatr.bank.dao.UserDAO;
import schepov.javatr.bank.dao.impl.TextFileAccountDAO;
import schepov.javatr.bank.dao.impl.TextFileUserDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final AccountDAO accountDAO = new TextFileAccountDAO();
    private final UserDAO userDAO = new TextFileUserDAO();

    private DAOFactory(){
    }

    public static DAOFactory getInstance(){
        return instance;
    }

    public AccountDAO getAccountDAO(){
        return accountDAO;
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }

}
