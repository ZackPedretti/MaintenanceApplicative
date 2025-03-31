package user;

public class AuthManager {
    User signedInUser;

    public AuthManager() {

    }

    public void signIn(UserName userName, UserPassword userPassword){
        signedInUser = UserList.getUsers().stream().filter(u -> u.hasName(userName) && u.checkPassword(userPassword)).findFirst().orElse(null);
    }

    public void signUp(UserName userName, UserPassword userPassword){
        signedInUser = new User(userName, userPassword);
        UserList.getUsers().add(signedInUser);
    }

    public User getSignedInUser() {
        return signedInUser;
    }

    public boolean isSignedIn() {
        return signedInUser != null;
    }
}
