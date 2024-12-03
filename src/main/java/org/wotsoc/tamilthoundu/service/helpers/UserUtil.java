package org.wotsoc.tamilthoundu.service.helpers;

import java.sql.SQLException;
import java.util.Arrays;

import org.wotsoc.tamilthoundu.dao.UserProfileDao;
import org.wotsoc.tamilthoundu.domain.Address;
import org.wotsoc.tamilthoundu.domain.User;
import org.wotsoc.tamilthoundu.domain.UserProfile;
import org.wotsoc.tamilthoundu.domain.UserProfileMap;
import org.wotsoc.tamilthoundu.dto.UserForm;

public class UserUtil
{
	private UserUtil() {}
	
	public static UserProfileMap createUserProfile(User user, UserForm userForm) throws SQLException {
		UserProfileMap upm = new UserProfileMap();
		UserProfileDao upDao= new UserProfileDao();
		UserProfile up= upDao.getProfileByName(userForm.getProfileName());
		upm.setProfileId(up.getProfileId());
		upm.setUserId(user.getUserId());
		upm.setActive("Y");
		return upm;
	}
	
	public static User createUser(UserForm userForm) {
		User user = new User();
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setUserName(userForm.getUserName());
		user.setIsActive("Y");
		user.setEmailId(userForm.getEmailId());
		user.setPassword(userForm.getPassword());

		Address address = new Address();
		address.setPlaceName(userForm.getPlaceName()); 
		address.setAddress1(userForm.getAddress1());
		address.setAddress2(userForm.getAddress2());
		address.setCity(userForm.getCity());
		address.setCountry(userForm.getCountry());
		address.setZipCode(userForm.getZipCode());
		user.setAddressList(Arrays.asList(address));
		
		return user;
	}
	
	public static void main(String[] args) throws SQLException {
		UserProfileDao upDao= new UserProfileDao();
		UserProfile up= upDao.getProfileByName("Not a Native Speaker");
		System.out.println(up);
	}
}
