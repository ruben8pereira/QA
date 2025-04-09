package controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.FileManager;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    private LoginController loginController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        loginController = new LoginController(FileManager.CESAELAND_LOGINS_TEST);
    }

    @Test
    void accessTypeTest() {
        String adminAccess = loginController.accessType("root", "root");
        assertEquals("ADMIN", adminAccess);

        String engAccess = loginController.accessType("pimentaMachado", "domingo");
        assertEquals("ENG", engAccess);

        String invalidAccess = loginController.accessType("nonexistent", "anypassword");
        assertEquals("ERROR", invalidAccess);

        String invalidPasswordAccess = loginController.accessType("root", "wrongpassword");
        assertEquals("ERROR", invalidPasswordAccess);

        String caseSensitiveAccess = loginController.accessType("ROOT", "root");
        assertEquals("ERROR", caseSensitiveAccess);
    }
}