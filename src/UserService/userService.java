package UserService;

import java.util.List;  
import UserModel.User;  

public interface userService {
    
    public void addUser(User user);
    
    public void updateUser(User user);
    
    public User getUserById(Integer id);
    
    public List<User> listUser();
    
    public void deleteUser(Integer id);
 
}
