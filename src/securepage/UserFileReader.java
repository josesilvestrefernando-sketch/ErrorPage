package securepage;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserFileReader {


    public UserFileReader() {

    }



    public User authenticate(String username, String password) {
        if (username.equals("Juan") && password.equals("123")) {
            return new User("Juan","123");
        }



        return null;
    }


}