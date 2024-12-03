package org.wotsoc.tamilthoundu.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.wotsoc.tamilthoundu.dto.UserForm;
import org.wotsoc.tamilthoundu.service.UserService;

import com.google.gson.Gson;

@RestController
@RequestMapping("/user")
public class UserRESTController {
	
	@RequestMapping(value = "/signup",
            method = RequestMethod.POST) 
    @ResponseBody
    public UserForm createUser(@RequestBody UserForm userForm) throws Exception {
		UserService us = new UserService();
		return us.createUser(userForm);
	}

	@RequestMapping(value = "/reset",
            method = RequestMethod.POST) 
    @ResponseBody
    public UserForm resetUser(@RequestBody UserForm userForm) throws Exception {
		UserService us = new UserService();
		return us.resetUser(userForm);
	}
	
	@RequestMapping(value = "/login",
            method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String login(@RequestParam("emailId") String emailId,@RequestParam("password") String password) {
		UserService us = new UserService();
		return new Gson().toJson(us.login(emailId,password));
	}

}