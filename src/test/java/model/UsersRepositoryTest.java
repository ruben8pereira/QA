package model;

import domain.User;
import tools.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryTest {

    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        usersRepository = new UsersRepository(FileManager.CESAELAND_LOGINS_TEST);
    }

    @Test
    void getUsersListTest() {
        ArrayList<User> users = usersRepository.getUsersList();

        assertNotNull(users);

        assertFalse(users.isEmpty());

        assertEquals(6, users.size());

        boolean hasAdminUser = false;
        boolean hasEngUser = false;

        for (User user : users) {
            String userType = user.getUserType();
            assertTrue(userType.equals("ADMIN") || userType.equals("ENG"),
                    "User type should be ADMIN or ENG, found: " + userType);

            if (userType.equals("ADMIN")) hasAdminUser = true;
            if (userType.equals("ENG")) hasEngUser = true;
        }

        assertTrue(hasAdminUser, "Should exist at least one ADMIN user");
        assertTrue(hasEngUser, "Should exist at least one ENG user");

        User rootUser = null;
        User pimentaUser = null;

        for (User user : users) {
            if (user.getUsername().equals("root")) rootUser = user;
            if (user.getUsername().equals("pimentaMachado")) pimentaUser = user;
        }

        assertNotNull(rootUser, "User 'root' should exist");
        assertEquals("ADMIN", rootUser.getUserType());
        assertEquals("root", rootUser.getPassword());

        assertNotNull(pimentaUser, "User 'pimentaMachado' should exist");
        assertEquals("ENG", pimentaUser.getUserType());
        assertEquals("domingo", pimentaUser.getPassword());
    }
}