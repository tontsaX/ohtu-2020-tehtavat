package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
    	
    	username = username.replaceAll("\\s*", "");
    	password = password.replaceAll("\\s*", "");
    	
    	if(invalidLength(username, password)) {
    		return true;
    	}
    	
    	if(invalidCharacters(username, password)) {
    		return true;
    	}

        return false;
    }
    
    private boolean invalidLength(String username, String password) {
    	if(username.length() < 3 || password.length() < 8) {
    		return true;
    	}
    	
    	return false;
    }
    
    private boolean invalidCharacters(String username, String password) {
    	
    	if(!Pattern.matches("[a-z]+", username)) {
    		return true;
    	}
    	
    	int charCount = 0;
    	
    	for(char c: password.toCharArray()) {
    		if(!Character.isLetter(c)) {
    			charCount++;
    		}
    	}
    	
    	if(charCount == 0) {
    		return true;
    	}
    	
    	return false;
    }
}
