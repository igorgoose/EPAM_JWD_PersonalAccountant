package schepov.javatr.bank.view;

import schepov.javatr.bank.StringLiterals;
import schepov.javatr.bank.controller.Controller;
import schepov.javatr.bank.view.scanner.MenuScanner;
import schepov.javatr.bank.view.scanner.exception.NoInputInLineException;
import schepov.javatr.bank.view.scanner.exception.NoNumberInLineException;


public class View {

    private final Controller controller = new Controller();
    private String userInfo = null;
    private boolean isRunning = true;

    private String authorize() {
        MenuScanner scanner = MenuScanner.getInstance();
        System.out.println(StringLiterals.MENU_SIGN_UP);
        System.out.println(StringLiterals.MENU_LOG_IN);
        System.out.println(StringLiterals.MENU_OUTER_EXIT);
        try {
            int answer = scanner.scanInt(System.in);
            switch (answer) {
                case 1: {
                    String request = StringLiterals.REQUEST_SIGN_UP + " " + formUserInfo();
                    return callController(request);
                }
                case 2: {
                    String request = StringLiterals.REQUEST_LOG_IN + " " + formUserInfo();
                    String response = callController(request);
                    if (response.contains(StringLiterals.RESPONSE_USER_INFO)) {
                        this.userInfo = response.substring(response.indexOf('(') + 1, response.indexOf(')'));
                        return response.substring(0, response.indexOf('\n'));
                    }
                    return response;
                }
                case 3:
                    isRunning = false;
                    return StringLiterals.MENU_FAREWELL;
                default:
                    return StringLiterals.MENU_INVALID_INPUT;
            }
        } catch (NoNumberInLineException | NoInputInLineException e) {
            return StringLiterals.MENU_INVALID_INPUT;
        }
    }

    private String callController(String request) {
        return controller.execute(request);
    }


    private String formUserInfo() throws NoInputInLineException {
        MenuScanner scanner = MenuScanner.getInstance();
        System.out.println(StringLiterals.MENU_ENTER_ID);
        String id = scanner.scanLine(System.in);
        System.out.println(StringLiterals.MENU_ENTER_PASSWORD);
        String password = scanner.scanLine(System.in);
        return id + " " + password;
    }

    private String workWithAccount() {
        MenuScanner scanner = MenuScanner.getInstance();
        while (true) {
            System.out.println(StringLiterals.MENU_GET_STATS);
            System.out.println(StringLiterals.MENU_CHANGE_INCOME);
            System.out.println(StringLiterals.MENU_CHANGE_EXPENSES);
            System.out.println(StringLiterals.MENU_RESET_STATS);
            System.out.println(StringLiterals.MENU_SIGN_OUT);
            System.out.println(StringLiterals.MENU_DELETE_ACCOUNT);
            System.out.println(StringLiterals.MENU_INNER_EXIT);
            try {
                int answer = scanner.scanInt(System.in);
                switch (answer) {
                    case 1: {
                        String request = StringLiterals.REQUEST_GET_STATS + " " + userInfo;
                        return callController(request);
                    }
                    case 2: {
                        System.out.println(StringLiterals.MENU_NEW_INCOME);
                        double newIncome = scanner.scanDouble(System.in);
                        String request = StringLiterals.REQUEST_CHANGE_INCOME + " " + userInfo + " " + newIncome;
                        return callController(request);
                    }
                    case 3: {
                        System.out.println(StringLiterals.MENU_NEW_EXPENSES);
                        double newExpenses = scanner.scanDouble(System.in);
                        String request = StringLiterals.REQUEST_CHANGE_EXPENSES + " " + userInfo + " " + newExpenses;
                        return callController(request);
                    }
                    case 4: {
                        String request = StringLiterals.REQUEST_RESET_STATS + " " + userInfo;
                        return callController(request);
                    }
                    case 5: {
                        userInfo = null;
                        return StringLiterals.RESPONSE_SIGN_OUT_SUCCESS;
                    }
                    case 6: {
                        String request = StringLiterals.REQUEST_DELETE_USER + " " + userInfo + " " + formUserInfo();
                        String response = callController(request);
                        int spaceIndex = response.indexOf(' ');
                        if (response.substring(0, spaceIndex).equals(StringLiterals.RESPONSE_OK)) {
                            userInfo = null;
                            return response.substring(spaceIndex + 1);
                        }
                        return response;
                    }
                    case 7:
                        isRunning = false;
                        return StringLiterals.MENU_FAREWELL;
                    default:
                        System.out.println(StringLiterals.MENU_INVALID_INPUT);
                        break;
                }
            } catch (NoNumberInLineException | NoInputInLineException e) {
                System.out.println(StringLiterals.MENU_INVALID_INPUT);
            }
        }

    }

    public void run() {
        while (isRunning) {
            System.out.println(authorize());
            while (userInfo != null && isRunning) {
                System.out.println(workWithAccount());
            }
        }
    }
}
