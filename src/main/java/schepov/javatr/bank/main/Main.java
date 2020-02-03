package schepov.javatr.bank.main;


import schepov.javatr.bank.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream(new File("logging.properties")));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
	    View view = new View();
	    view.run();
    }
}
