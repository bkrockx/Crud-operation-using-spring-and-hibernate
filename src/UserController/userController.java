package UserController;
import java.util.*; 
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import UserDao.*;
import UserBean.*;  
import UserModel.*;  
import UserService.*; 

@Controller
public class userController {
    
    @Autowired
    private userService userService;

    @RequestMapping("/user")
    public String listUser(Map<String, Object> map) {
        map.put("user", new User());
        map.put("userList", userService.listUser());
        return "user";
    }
 	    
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")User user, BindingResult result)
    {
        if(null == user.getId()) {
            userService.addUser(user);    
        }
        else {
            userService.updateUser(user);
        }
        return "redirect:/user";
    }
 
    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId)
    {
        userService.deleteUser(userId);
        return "redirect:/user";
    }
 
    @RequestMapping("/edit/{userId}")
    public String edit(@PathVariable("userId")Integer userId,Map<String, Object> map)
    {
        map.put("user", userService.getUserById(userId));
        map.put("userList", userService.listUser());
        return "user";
    }
}