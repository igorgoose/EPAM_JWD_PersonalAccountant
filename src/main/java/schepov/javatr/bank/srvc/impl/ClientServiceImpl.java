package schepov.javatr.bank.srvc.impl;

import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.dao.UserDAO;
import schepov.javatr.bank.dao.exception.DAOException;
import schepov.javatr.bank.dao.factory.DAOFactory;
import schepov.javatr.bank.srvc.ClientService;
import schepov.javatr.bank.srvc.exception.ClientServiceException;
import schepov.javatr.bank.srvc.validation.Validator;


public class ClientServiceImpl implements ClientService {

    @Override
    public void signUp(String id, String password) throws ClientServiceException {
        Validator validator = Validator.getInstance();
        if(!validator.isValidLoginOrPassword(id) || !validator.isValidLoginOrPassword(password)){
            throw new ClientServiceException("Invalid login or password!");
        }
        UserDAO userDAO = getUserDAO();
        try {
            userDAO.signUp(id, password);
        } catch (DAOException e) {
            throw new ClientServiceException(e);
        }
    }

    @Override
    public User logIn(String id, String password) throws ClientServiceException {
        Validator validator = Validator.getInstance();
        if(!validator.isValidLoginOrPassword(id) || !validator.isValidLoginOrPassword(password)){
            throw new ClientServiceException("Invalid login or password!");
        }
        UserDAO userDAO = getUserDAO();
        try {
            return userDAO.logIn(id, password);
        } catch (DAOException e) {
            throw new ClientServiceException("Error occurred while logging in!", e);
        }
    }

    @Override
    public void deleteUser(User user, String id, String password) throws ClientServiceException {
        if(user == null){
            throw new ClientServiceException("Null user passed!");
        }
        Validator validator = Validator.getInstance();
        if(!validator.isValidLoginOrPassword(id) || !validator.isValidLoginOrPassword(password)){
            throw new ClientServiceException("Invalid login or password!");
        }
        if(!validator.dataMatches(user, id, password)){
            throw new ClientServiceException("Incorrect login or password!");
        }
        UserDAO userDAO = getUserDAO();
        try {
            userDAO.deleteUser(id);
        } catch (DAOException e) {
            throw new ClientServiceException("Error occurred while deleting user!", e);
        }
    }

    private UserDAO getUserDAO(){
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getUserDAO();
    }
}
