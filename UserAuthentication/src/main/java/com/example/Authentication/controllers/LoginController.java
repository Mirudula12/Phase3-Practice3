package com.example.Authentication.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;


@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;
	

	@GetMapping(value="/")
    public String showIndexPage(ModelMap model){   
		 return "<html>\n"
		 		+ "<head>\n"
		 		+ "</head>\n"
		 		+ "<body>\n"
		 		+ "	<div>\n"
		 		+ "		<h2>User Login Page</h2>\n"
		 		+ "		\n"
		 		+ "		<a href=\"/allusers\">View all users</a>\n"
		 		+ "		<br><br>\n"
				+ "     <form method=\"get\" action=\"login\">\n"
				+ "			<br><h3>Enter Login Details</h3>\n"
				+ "			Name : <input type=\"text\" id=\"name\" name=\"name\"><br>"
				+ "			Email : <input type=\"text\" id=\"email\" name=\"email\"><br>"
				+ "			Password : <input type=\"password\" id=\"password\" name=\"password\"><br>"
				+ "			<input type=\"submit\" value=\"Submit\" />\n"
				+ "		</form>"
		 		+ "	</div>\n"
		 		+ "</body>\n"
		 		+ "</html>";
    }


    @GetMapping("/login")
    public String showLogin(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, ModelMap map) {
        User u = new User(name,email,password);
        userRepository.save(u); 
        
        return "<html>\n"
 		+ "<head>\n"
 		+ "</head>\n"
 		+ "<body>\n"
 		+ "	<div class=\"center\">\n"
 		+ "		<h2>Logged In Successfully</h2>\n"
 		+ "		\n"
 		+ "		<h3 class=\"hello-title\">Added Your Information</h3>\n"
 		+ "	</div>\n"
 		+ "</body>\n"
 		+ "</html>";
    }

    @GetMapping("/allusers")
	public @ResponseBody String getAllFeedbacks() {
        Iterable<User> allUser = userRepository.findAll();
		return "<html>\n"
		 		+ "<head>\n"
		 		+ "	<style>\n"
		 		+ "		.center {\n"
		 		+ "	  		text-align: center;\n"
		 		+ "	  	}\n"
		 		+ "	  	\n"
		 		+ "	</style>\n"
		 		+ "</head>\n"
		 		+ "<body>\n"
		 		+ "	<div class=\"center\">\n"
		 		+ "<h2>User Information</h2>\n"
        		+ allUser.toString()
		        + "	</div>\n"
		 		+ "</body>\n"
		 		+ "</html>";
    }
    
    @PostMapping("/login")
    public String submitLogin(@RequestParam String username, @RequestParam String password){

        //TODO:

        return "Success";



    }
}
