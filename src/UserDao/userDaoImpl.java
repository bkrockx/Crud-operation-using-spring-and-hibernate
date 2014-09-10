package UserDao;

import java.util.List;  

import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  
  


import UserModel.User; 

@Repository
public class userDaoImpl implements userDao {
 
	@Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
 
    @Override
    public void deleteUser(Integer id) {
        User user = (User)sessionFactory.getCurrentSession().load(User.class,id);
        if(null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
 
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
 
    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public User getUserById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User u where u.id = :id").setParameter("id",id).list();
        return list.size() > 0 ?(User)list.get(0): null;
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
}