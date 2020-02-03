package schepov.javatr.bank.util;

import schepov.javatr.bank.bean.Account;

public class StatsCalculator {

    private static final StatsCalculator instance = new StatsCalculator();

    private StatsCalculator(){

    }

    public static StatsCalculator getInstance() {
        return instance;
    }

    public double getBalance(Account account){
        return account.getIncome() - account.getExpenses();
    }

    public double getRelation(Account account){
        if(account.getExpenses() != 0){
            return account.getIncome() / account.getExpenses();
        }
        return -1;
    }
}
