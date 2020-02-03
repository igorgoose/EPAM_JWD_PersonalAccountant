package schepov.javatr.bank.dao.impl;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.bean.User;
import schepov.javatr.bank.dao.UserDAO;
import schepov.javatr.bank.dao.exception.DAOException;
import schepov.javatr.bank.dao.validation.Validator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TextFileUserDAO implements UserDAO {

    private File file;
    private static final int NUMBER_OF_TOKENS_IN_LINE = 2;

    public TextFileUserDAO() {
        file = new File(StringLiterals.USER_FILE_NAME);
    }

    @Override
    public void signUp(String login, String password) throws DAOException {
        if (findUser(login) != null) {
            throw new DAOException(StringLiterals.USER_ALREADY_EXISTS);
        }
        addUser(login, password);
    }

    @Override
    public User logIn(String login, String password) throws DAOException {
        if(!isValidPassword(login, password)){
            throw new DAOException(StringLiterals.INVALID_LOGIN_OR_PASSWORD);
        }
        return findUser(login);
    }

    @Override
    public void deleteUser(String id) throws DAOException {
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

    private User findUser(String id) throws DAOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(StringLiterals.SPACE_DELIMITER);
                if(!Validator.getInstance().isValidLine(fields, NUMBER_OF_TOKENS_IN_LINE)){
                    throw new DAOException(StringLiterals.READING_ERROR);
                }

                if (id.equals(fields[0])) {
                    User user = new User();
                    user.setId(id);
                    user.setPassword(fields[1]);
                    return user;
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            throw new DAOException(StringLiterals.FILE_NOT_FOUND, e);
        } catch (IOException e) {
            throw new DAOException(StringLiterals.READING_ERROR, e);
        }
    }

    private void addUser(String id, String password) throws DAOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(id + " " + password + "\n");
        } catch (IOException e) {
            throw new DAOException(StringLiterals.WRITING_ERROR, e);
        }
    }

    private boolean isValidPassword(String login, String password) throws DAOException {
        User user = findUser(login);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
