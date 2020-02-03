package schepov.javatr.bank.dao.impl;


import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.Account;
import schepov.javatr.bank.dao.AccountDAO;
import schepov.javatr.bank.dao.exception.DAOException;
import schepov.javatr.bank.dao.validation.Validator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TextFileAccountDAO implements AccountDAO {

    private File file;
    private static final int NUMBER_OF_TOKENS_IN_LINE = 3;

    public TextFileAccountDAO(){
        file = new File(StringLiterals.ACCOUNT_FILE_NAME);
    }

    @Override
    public Account getAccount(String id) throws DAOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] fields;
            while ((line = reader.readLine()) != null) {

                fields = line.split(StringLiterals.SPACE_DELIMITER);
                if(!Validator.getInstance().isValidLine(fields, NUMBER_OF_TOKENS_IN_LINE)){
                    throw new DAOException(StringLiterals.READING_ERROR);
                }

                if (fields[0].equals(id)) {
                    Account account = new Account();
                    account.setId(fields[0]);
                    account.setIncome(Double.parseDouble(fields[1]));
                    account.setExpenses(Double.parseDouble(fields[2]));
                    return account;
                }
            }
            throw new DAOException(StringLiterals.ID_NOT_FOUND);
        } catch (FileNotFoundException e) {
            throw new DAOException(StringLiterals.FILE_NOT_FOUND, e);
        } catch (IOException e) {
            throw new DAOException(StringLiterals.READING_ERROR, e);
        } catch (NumberFormatException e) {
            throw new DAOException(StringLiterals.INVALID_BALANCE, e);
        }
    }

    @Override
    public void updateAccount(Account account) throws DAOException {
        File newFile = new File(StringLiterals.NEW_FILE_DEFAULT_NAME);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))
        ) {
            String line;
            String[] fields;

            while ((line = reader.readLine()) != null) {
                fields = line.split(StringLiterals.SPACE_DELIMITER);
                if(!Validator.getInstance().isValidLine(fields, NUMBER_OF_TOKENS_IN_LINE)){
                    throw new DAOException(StringLiterals.READING_ERROR);
                }

                if (fields[0].equals(account.getId())) {
                    line = fields[0] + " " + account.getIncome() +
                            " " + account.getExpenses();
                }
                writer.write(line + '\n');
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(StringLiterals.FILE_NOT_FOUND, e);
        } catch (IOException e) {
            throw new DAOException(StringLiterals.READING_ERROR, e);
        } catch (NumberFormatException e) {
            throw new DAOException(StringLiterals.INVALID_BALANCE, e);
        }
        try {
            Files.copy(newFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new DAOException(StringLiterals.READING_ERROR, e);
        }
    }

    @Override
    public void addAccount(Account account) throws DAOException {
        try{
            getAccount(account.getId());
            throw new DAOException(StringLiterals.ACCOUNT_ALREADY_EXISTS);
        } catch (DAOException e){

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
                writer.write(account.getId() + " " + account.getIncome() +
                        " " + account.getExpenses() + "\n");
            } catch (IOException ex) {
                throw new DAOException(StringLiterals.WRITING_ERROR, ex);
            }
        }
    }

    @Override
    public void deleteAccount(String id) throws DAOException {
        File newFile = new File(StringLiterals.NEW_FILE_DEFAULT_NAME);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))
        ) {
            String line;
            String[] fields;

            while ((line = reader.readLine()) != null) {
                fields = line.split(StringLiterals.SPACE_DELIMITER);
                if(!Validator.getInstance().isValidLine(fields, NUMBER_OF_TOKENS_IN_LINE)){
                    throw new DAOException(StringLiterals.READING_ERROR);
                }

                if (fields[0].equals(id)) {
                    continue;
                }
                writer.write(line + '\n');
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(StringLiterals.FILE_NOT_FOUND, e);
        } catch (IOException e) {
            throw new DAOException(StringLiterals.READING_ERROR, e);
        } catch (NumberFormatException e) {
            throw new DAOException(StringLiterals.INVALID_BALANCE, e);
        }
        try {
            Files.copy(newFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new DAOException(StringLiterals.READING_ERROR, e);
        }
    }

}
