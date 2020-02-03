package schepov.javatr.bank.bean;

import java.io.Serializable;

public class Account implements Serializable {
    private String id;
    private double income;
    private double expenses;

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account that = (Account) o;

        if (income != that.income) {
            return false;
        }
        if (expenses != that.expenses) {
            return false;
        }
        return (id == null ? that.id == null : id.equals(that.id));
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + Double.valueOf(income).hashCode();
        result = 31 * result + Double.valueOf(expenses).hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " :\n { id: " + id + ";\n income: " + income +
                ";\n expenses: " +  expenses + "}";
    }
}
