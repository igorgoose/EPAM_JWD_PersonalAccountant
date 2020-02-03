package schepov.javatr.bank.view.scanner;

import schepov.javatr.bank.view.scanner.exception.NoInputInLineException;
import schepov.javatr.bank.view.scanner.exception.NoNumberInLineException;

import java.io.InputStream;
import java.util.Scanner;

public class MenuScanner {

    private static final MenuScanner instance = new MenuScanner();

    private MenuScanner(){}

    public int scanInt(InputStream source) throws NoNumberInLineException {
        Scanner sc = new Scanner(source);
        int scannedValue = 0;
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                scannedValue = sc.nextInt();
                return scannedValue;
            }
            sc.next();
        }
        throw new NoNumberInLineException();
    }

    public double scanDouble(InputStream source) throws NoNumberInLineException {
        Scanner sc = new Scanner(source);
        double scannedValue = 0;
        while(sc.hasNext()){
            if(sc.hasNextDouble()){
                scannedValue = sc.nextDouble();
                return scannedValue;
            }
            sc.next();
        }
        throw new NoNumberInLineException();
    }

    public String scanLine(InputStream source) throws NoInputInLineException {
        Scanner sc = new Scanner(source);
        if(sc.hasNext()){
            return sc.nextLine();
        }
        throw new NoInputInLineException();
    }

    public static MenuScanner getInstance(){
        return instance;
    }
}
