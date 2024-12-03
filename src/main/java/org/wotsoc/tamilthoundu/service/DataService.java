/**
 * @author Rajamani David
 * @since	Mar 21, 2018
 *
 */
package org.wotsoc.tamilthoundu.service;

import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.wotsoc.tamilthoundu.common.CommonUtil;
import org.wotsoc.tamilthoundu.common.Constants;
import org.wotsoc.tamilthoundu.dao.UserDao;
import org.wotsoc.tamilthoundu.domain.UserSession;
import org.wotsoc.tamilthoundu.dto.Login;

/**
 * @author rdavid
 *
 */

@Path("/data")
public class DataService 
{
	// Allows to insert contextual objects into the class
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

	public DataService() 
	{
		// TODO Auto-generated constructor stub
	}
	
    // Return the list of orders for applications with json or xml formats
	@Path("/user")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserSession login(@FormParam("name")  String name, @FormParam("value") String value, @FormParam("ip") String ip) throws Exception
    { 
		Map<String,Object> map = CommonUtil.getParams(new String[]{name, value,ip});
    	UserDao userDao = new UserDao();
    	Login userLogin= new Login();
    	userLogin.setUserName((String)map.get(Constants.USER_NAME));
    	userLogin.setPassword((String)map.get(Constants.PASSWORD));
    	userLogin.setIp((String)map.get(Constants.IP_LOCATION));
    	return userDao.login(userLogin);
    }
	
    // Return the list of orders for applications with json or xml formats
	@Path("/pageControl")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserSession pageControl(@FormParam("name")  String name, @FormParam("value") String value, @FormParam("ip") String ip) throws Exception
    { 
		Map<String,Object> map = CommonUtil.getParams(new String[]{name, value,ip});
    	UserDao userDao = new UserDao();
    	Login userLogin= new Login();
    	userLogin.setUserName((String)map.get(Constants.USER_NAME));
    	userLogin.setPassword((String)map.get(Constants.PASSWORD));
    	userLogin.setIp((String)map.get(Constants.IP_LOCATION));
    	return userDao.login(userLogin);
    }

}
