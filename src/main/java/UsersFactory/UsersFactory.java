package UsersFactory;

import org.example.springMvcApp.models.Admin;
import org.example.springMvcApp.models.Moderator;
import org.example.springMvcApp.models.User;
import org.example.springMvcApp.models.UserType;

public class UsersFactory {
    public static User createUser(UserType userType) throws Exception {
        switch (userType) {
            case USER:
                return new User();

            case ADMIN:
                System.out.println("Asda admiiin");
                return new Admin();

            case MODERATOR:
                return new Moderator();

            default:
                throw new Exception();
        }

    }
}
