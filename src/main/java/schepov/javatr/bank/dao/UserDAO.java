package schepov.javatr.bank.dao;

import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.dao.exception.DAOException;

public interface UserDAO {
    void signUp(String id, String password) throws DAOException;
    User logIn(String id, String password) throws DAOException;
    void deleteUser(String id) throws DAOException;
}
