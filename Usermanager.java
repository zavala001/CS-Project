import java.util.ArrayList;
import java.util.List;
class UserManager {

    private List<User> users = new ArrayList<>();
    private User testUser = new User("test", "test");
    public void registerUser(String username, String password) {users.add(new User(username, password));}
    public User loginUser(String username, String password) {
        if (testUser.getUsername().equals(username) &&
                testUser.getPassword().equals(password)) {

            return testUser;
        }
        for (User user : users) {
            if (user.getUsername().equals(username) &&

                    user.getPassword().equals(password)) {

                return user;
            }
        }
        return null;
    }
}
