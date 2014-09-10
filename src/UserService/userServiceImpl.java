package UserService;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Propagation;  
import org.springframework.transaction.annotation.Transactional;  
  
import UserDao.*;  
import UserModel.User; 

@Service
public class userServiceImpl implements userService {
 
    @Autowired
    private userDao userDao;
    
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }
 
    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
 
    @Transactional
    public List<User> listUser() {
        return userDao.listUser();
    }
 
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
 
    @Transactional
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

	public userDao getUserDao() {
		return userDao;
	}

	public void setUserDao(userDao userDao) {
		this.userDao = userDao;
	}
    
 
}