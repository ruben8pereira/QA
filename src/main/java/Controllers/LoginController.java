package Controllers;

import Domain.User;
import Model.UsersRepository;
import Tools.FileManager;

import java.io.FileNotFoundException;

public class LoginController {
    private UsersRepository userRepository;

    public LoginController() throws FileNotFoundException {
        this.userRepository = new UsersRepository(FileManager.CESAELAND_LOGINS);
    }

    /**
     * Verifies user credentials and returns the access type
     *
     * @param usernameInput Username entered
     * @param passwordInput Password entered
     * @return String with the access type ("ADMIN", "ENG", or "ERROR")
     */
    public String accessType(String usernameInput, String passwordInput) {
        String accessType = "ERROR";

        for (User currentUser : this.userRepository.getUsersList()) {
            if (currentUser.getUsername().equals(usernameInput) && currentUser.getPassword().equals(passwordInput)) {
                // Valid Access
                accessType = currentUser.getUserType();
            }
        }

        return accessType;
    }
}
