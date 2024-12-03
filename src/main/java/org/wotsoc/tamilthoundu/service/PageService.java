/**
 * @author Rajamani David
 * @since	Mar 21, 2018
 *
 */
package org.wotsoc.tamilthoundu.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.wotsoc.tamilthoundu.dao.PageControlDao;
import org.wotsoc.tamilthoundu.dao.ProjectDao;
import org.wotsoc.tamilthoundu.dao.ProjectProfileMapDao;
import org.wotsoc.tamilthoundu.dao.SystemDataCollectionDao;
import org.wotsoc.tamilthoundu.dao.UserDao;
import org.wotsoc.tamilthoundu.dao.UserDataCollectionDao;
import org.wotsoc.tamilthoundu.dao.UserProfileMapDao;
import org.wotsoc.tamilthoundu.domain.Project;
import org.wotsoc.tamilthoundu.domain.ProjectProfileMap;
import org.wotsoc.tamilthoundu.domain.User;
import org.wotsoc.tamilthoundu.domain.UserProfileMap;

import com.google.gson.Gson;

/**
 * @author rdavid
 *
 */

@Path("/page")
public class PageService 
{
	// Allows to insert contextual objects into the class
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

	public PageService() 
	{
		// TODO Auto-generated constructor stub
	}
	
    // Return the list of orders for applications with json or xml formats
//	  @Path("/login")
//    @POST
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    //public boolean login(@QueryParam("name") String name[],@QueryParam("value") String value[]) throws Exception
//	  //public UserSession login(@QueryParam("name")  String name, @QueryParam("value") String value, @QueryParam("ip") String ip) throws Exception
//	  //public UserSession login(@FormParam("name")  String name, @FormParam("value") String value, @FormParam("ip") String ip) throws Exception
//    { 

    // Return the list of orders for applications with json or xml formats
	@Path("/controls")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	public String controls(@QueryParam("userName") String userName,@QueryParam("projectId") String projectId, @QueryParam("deviceId") String deviceId) throws Exception
    { 
		ProjectDao pcd = new ProjectDao();
		List<Project> pList=pcd.getProjectsByUserName(userName,projectId);
		List<Integer> pIdList= new ArrayList<Integer>();
		for(Project p:pList)
			pIdList.add(p.getProjectId());
    	PageControlDao pageControlDao = new PageControlDao();
    	return new Gson().toJson(pageControlDao.getPageControls(pIdList));
    }

	@Path("/userdata")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	public String getUserDataCollection(@QueryParam("userName") String userName, @QueryParam("deviceId") String deviceId) throws Exception
    { 
    	UserDataCollectionDao userControlDao = new UserDataCollectionDao();
    	return new Gson().toJson(userControlDao.getUserControlsByUser(userName));
    }
	
	@Path("/sysdata")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	public String getSystemDataCollection(@QueryParam("userName") String userName, @QueryParam("deviceId") String deviceId) throws Exception
    { 
		SystemDataCollectionDao sysControlDao = new SystemDataCollectionDao();
    	return new Gson().toJson(sysControlDao.getSystemControlsByUser(userName));
    }

	
	@Path("/projects")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	public String getProjects(@QueryParam("userName") String userName, @QueryParam("projectId") String projectId) throws Exception
	{
		ProjectDao pcd = new ProjectDao();
		return new Gson().toJson(pcd.getProjectsByUserName(userName,projectId));
	}
	
	public void getUserProjects(String userName) throws Exception
	{
		UserDao userDao =new UserDao();
		User user=userDao.getUser(null, userName);
		UserProfileMapDao upmDao= new UserProfileMapDao();
		List<UserProfileMap> upmList= upmDao.getUserProfileMaps(user.getUserId());
		List<Integer> profileIds =new ArrayList<Integer>();
		for(UserProfileMap upm:upmList)
		{
			profileIds.add(upm.getProfileId());
		}
		ProjectProfileMapDao ppmDao = new ProjectProfileMapDao();
		List<ProjectProfileMap> ppmList= ppmDao.getProjectProfileMapsByProfileIds(profileIds);
		List<Integer> projectIds =new ArrayList<Integer>();
		for(ProjectProfileMap ppm:ppmList)
		{
			projectIds.add(ppm.getProjectId());
		}
		ProjectDao pDao =new ProjectDao();
		System.out.println(pDao.getProjects(projectIds));
		
	} 
	
	public static void main(String args[]) throws Exception
	{
		PageService ps = new PageService();
		ps.getUserProjects("raj");
	}

}
