import Views.LoginView;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LoginView loginView = new LoginView();
        loginView.entryView();
    }
}