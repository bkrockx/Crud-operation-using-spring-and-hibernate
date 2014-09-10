package UserDao;

import java.util.*;

import UserModel.User;

public interface userDao {  
	   
	 public void addUser(User user);
	 
	 public void updateUser(User user);
	 
	 public List<User> listUser();
	 
	 public User getUserById(Integer id);
	 
	 public void deleteUser(Integer id);
}  