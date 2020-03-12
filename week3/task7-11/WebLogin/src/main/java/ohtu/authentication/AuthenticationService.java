package ohtu.authentication;

import java.util.regex.Pattern;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

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

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
                
        checkUsername(username, status);
           
        checkPassword(password, status);
        
        // confirm password
        if(!password.equals(passwordConfirmation)) {
        	status.addError("password and password confirmation do not match");
        }

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }
    
    private void checkUsername(String username, CreationStatus status) {
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length() < 3) {
            status.addError("username should have at least 3 characters");
        }
        
        if(!Pattern.matches("[a-z]+", username)) {
    		status.addError("username should contain only letters between a-z");
    	}
        
    }

    private void checkPassword(String password, CreationStatus status) {
        if(password.length() < 8) {
        	status.addError("password should have at least 8 characters");
        }
        
        int charCount = 0;
    	
    	for(char c: password.toCharArray()) {
    		if(!Character.isLetter(c)) {
    			charCount++;
    		}
    	}
    	
    	if(charCount == 0) {
    		status.addError("password should contain at least one character other than a letter");
    	}
    }
    
}
