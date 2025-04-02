package model;

import domain.User;
import tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UsersRepository {
    private ArrayList<User> usersList;

    public UsersRepository(String filePath) throws FileNotFoundException {
        this.usersList = CSVReader.readUserFileToArray(filePath);
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }
}
