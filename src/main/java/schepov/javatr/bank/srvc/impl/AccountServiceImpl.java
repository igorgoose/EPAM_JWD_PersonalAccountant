package schepov.javatr.bank.srvc.impl;

import schepov.javatr.bank.bean.Account;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.dao.AccountDAO;
import schepov.javatr.bank.dao.exception.DAOException;
import schepov.javatr.bank.dao.factory.DAOFactory;
import schepov.javatr.bank.srvc.AccountService;
import schepov.javatr.bank.srvc.exception.AccountServiceException;
import schepov.javatr.bank.util.StatsCalculator;

public class AccountServiceImpl implements AccountService {

    @Override
    public void addAccount(Account account) throws AccountServiceException {
        if(account == null){
            throw new AccountServiceException("Null account object passed!");
        }
        AccountDAO accountDAO = getAccountDAO();
        try {
            accountDAO.addAccount(account);
        } catch (DAOException e) {
            throw new AccountServiceException(e);
        }
    }

    private AccountDAO getAccountDAO(){
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getAccountDAO();
    }

    @Override
    public String getStats(User user) throws AccountServiceException {
        if(user == null){
            throw new AccountServiceException("Null user passed!");
        }
        AccountDAO accountDAO = getAccountDAO();
        try {
            Account account = accountDAO.getAccount(user.getId());
            StatsCalculator statsCalculator = StatsCalculator.getInstance();
            String result = "ID: " + account.getId() +
                    "\nIncome: " + account.getIncome() +
                    "\nExpenses: " + account.getExpenses() +
                    "\nBalance: " + statsCalculator.getBalance(account);
            if(account.getExpenses() != 0){
                result += "\nIncome/expenses: " + statsCalculator.getRelation(account);
            }
            return result;
        } catch (DAOException e) {
            throw new AccountServiceException(e);
        }
    }

    @Override
    public void changeIncome(User user, String newIncome) throws AccountServiceException {
        if(user == null){
            throw new AccountServiceException("Null user passed!");
        }
        double income;
        try{
            income = Double.parseDouble(newIncome);
        } catch(NumberFormatException e){
            throw new AccountServiceException("Invalid income value!", e);
        }
        if(income < 0){
            throw new AccountServiceException("Negative income value!");
        }
        AccountDAO accountDAO = getAccountDAO();
        try {
            Account account = accountDAO.getAccount(user.getId());
            account.setIncome(income);
            accountDAO.updateAccount(account);
        } catch (DAOException e) {
            throw new AccountServiceException(e);
        }
    }

    @Override
    public void changeExpenses(User user, String newExpenses) throws AccountServiceException {
        if(user == null){
            throw new AccountServiceException("Null user passed!");
        }
        double expenses;
        try{
            expenses = Double.parseDouble(newExpenses);
        } catch(NumberFormatException e){
            throw new AccountServiceException("Invalid expenses value!", e);
        }
        if(expenses < 0){
            throw new AccountServiceException("Negative expenses value!");
        }
        AccountDAO accountDAO = getAccountDAO();
        try {
            Account account = accountDAO.getAccount(user.getId());
            account.setExpenses(expenses);
            accountDAO.updateAccount(account);
        } catch (DAOException e) {
            throw new AccountServiceException(e);
        }
    }

    @Override
    public void deleteAccount(String id) throws AccountServiceException {
        if(id == null){
            throw new AccountServiceException("Null string passed!");
        }
        DAOFactory factory = DAOFactory.getInstance();
        AccountDAO accountDAO = factory.getAccountDAO();
        try {
            accountDAO.deleteAccount(id);
        } catch (DAOException e) {
            throw new AccountServiceException(e);
        }
    }
}
