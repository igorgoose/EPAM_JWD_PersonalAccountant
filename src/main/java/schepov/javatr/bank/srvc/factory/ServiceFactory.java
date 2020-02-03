package schepov.javatr.bank.srvc.factory;


import schepov.javatr.bank.srvc.AccountService;
import schepov.javatr.bank.srvc.ClientService;
import schepov.javatr.bank.srvc.impl.AccountServiceImpl;
import schepov.javatr.bank.srvc.impl.ClientServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final AccountService accountService = new AccountServiceImpl();
    private final ClientService clientService = new ClientServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public AccountService getAccountService(){
        return accountService;
    }

    public ClientService getClientService() {
        return clientService;
    }
}
