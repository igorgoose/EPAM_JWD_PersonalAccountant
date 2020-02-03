package schepov.javatr.bank.srvc;


import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.srvc.exception.ClientServiceException;

public interface ClientService {
    void signUp(String id, String password) throws ClientServiceException;
    User logIn(String id, String password) throws ClientServiceException;
    //void signOut(String id, String password) throws ClientServiceException;
    void deleteUser(User user, String id, String password) throws ClientServiceException;
}
