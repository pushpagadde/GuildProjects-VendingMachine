/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.controller;

import com.sg.superherosighting.dao.UserDao;
import com.sg.superherosighting.model.User;
import com.sg.superherosighting.service.HeroService;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PG
 */
@Controller
public class UserController {
    private HeroService service;    
    private PasswordEncoder encoder;

    @Inject
    public UserController(HeroService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    // This endpoint retrieves all users from the database and puts the List of users on the model
    @RequestMapping(value = "/displayUserPage", method = RequestMethod.GET)
    public String displayUserList(Map<String, Object> model) {
        List users = service.getAllUsers();
        model.put("users", users);
        return "user";
    }
    // This endpoint just displays the User details

    @RequestMapping(value = "/displayUserDetails", method = RequestMethod.GET)
    public String displayUserPage(HttpServletRequest request, Model model) {
        String userName = request.getParameter("username");
        User user = service.getUser(userName);        
        model.addAttribute("user", user);
        return "userEditPage";
    }
    // This endpoint processes the form data and creates a new User

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest req) {
        User user = new User();
        // This example uses a plain HTML form so we must get values from the request
        user.setUsername(req.getParameter("username"));
        String clearPw = req.getParameter("password");
        String hashPw = encoder.encode(clearPw);
        
        user.setPassword(hashPw);
        // All users have ROLE_USER, only add ROLE_ADMIN if the isAdmin  box is checked
        user.addAuthority("ROLE_USER");
        if (null != req.getParameter("userType")) {
            if (req.getParameter("userType").equalsIgnoreCase("Admin")){
                user.addAuthority("ROLE_ADMIN");
            } else if (req.getParameter("userType").equalsIgnoreCase("SideKick")) {
                user.addAuthority("ROLE_SIDEKICK");
            }
        }
        service.addUser(user);
        return "redirect:displayUserPage";
    }
    
    // #6 - This endpoint deletes the specified User    
    @RequestMapping(params = "saveUser", method = RequestMethod.POST)
    public String saveUser(HttpServletRequest request, @RequestParam(required=false , value = "cancel") String cancelFlag ) {
        String username = request.getParameter("username");
        System.out.println("username------:"+username);
        if(cancelFlag == null){
            String userstatus = request.getParameter("active");
            if (userstatus != null){
                if(userstatus.equalsIgnoreCase("yes")){
                    service.editUser(username, 1);
                }else if (userstatus.equalsIgnoreCase("no")){
                    service.editUser(username, 0);
                }                       
            }
        }        
        return "redirect:displayUserPage";
    }   
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {
        String userName = request.getParameter("username");
        service.deleteUser(userName);
        return "redirect:displayUserPage";
    }
    
    @RequestMapping(params= "userCancel", method = RequestMethod.POST)
    public String cancel() {
        return "redirect:displayUserPage";
    }   
}