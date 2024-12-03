/**
 * @author Rajamani David
 * @since	Nov 24, 2015
 *
 */
package org.wotsoc.tamilthoundu.service;

import org.wotsoc.tamilthoundu.dao.UserDao;
import org.wotsoc.tamilthoundu.dao.UserProfileMapDao;
import org.wotsoc.tamilthoundu.domain.User;
import org.wotsoc.tamilthoundu.domain.UserProfileMap;
import org.wotsoc.tamilthoundu.dto.UserForm;
import org.wotsoc.tamilthoundu.service.helpers.UserUtil;

public class UserService 
{
	public UserService() 
	{
		System.out.println("UserService Constructor.");
	}
	
	public UserForm createUser(UserForm userForm) {
		try
		{
			User user = UserUtil.createUser(userForm);
			UserDao userDao = new UserDao();
			user = userDao.signUp(user);
			UserProfileMap userProfileMap = UserUtil.createUserProfile(user,userForm);
			UserProfileMapDao upmDao = new UserProfileMapDao();
			upmDao.createUserProfileMap(userProfileMap);
			userForm.setMessage("User Created Successfully.");
			return userForm;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public UserForm login(String emailId, String password) {
		UserDao userDao = new UserDao();
		UserForm userForm = new UserForm();
		try
		{
			System.out.println("UserService:emailId:"+emailId);
			if(emailId!=null) {
				userForm.setEmailId(emailId);
				userForm.setPassword(password);
				User user = UserUtil.createUser(userForm);
				userForm.setMessage("User Logged in Successfully.");
				user = userDao.login(user);
					if(user==null)
						userForm.setMessage("User Not Found.");
			}
			return userForm;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		UserService us = new UserService();
		UserForm userForm = new UserForm();
		userForm.setUserName("sheela");
		userForm.setPassword("kuppachi123");
		userForm.setProfileName("Not a Native Speaker");
		userForm.setPlaceName("Osmania Univiersity");
		userForm.setCountry("USA");
		userForm.setEmailId("sheelaraj9@gmail.com");
		userForm.setOldPassword("kuppachi");
		//us.createUser(userForm);
		us.resetUser(userForm);
	}

	public UserForm resetUser(UserForm userForm) throws Exception
	{
		User user = new User();
		user.setEmailId(userForm.getEmailId());
		user.setPassword(userForm.getPassword());
		user.setOldPassword(userForm.getOldPassword());
		UserDao userDao = new UserDao();
		userDao.reset(user);
		return null;
	}
 }
