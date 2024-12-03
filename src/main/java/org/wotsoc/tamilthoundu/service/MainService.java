/**
 * @author Rajamani David
 * @since	Nov 17, 2015
 *
 */
package org.wotsoc.tamilthoundu.service;

/**
 * @author rdavid
 *
 */
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.wotsoc.tamilthoundu.dao.ConstantsDao;
import org.wotsoc.tamilthoundu.domain.Constants;

import com.google.gson.Gson;

//maps this resource to the URL orders
@Path("/main")
public class MainService 
{
        // Allows to insert contextual objects into the class
        @Context
        UriInfo uriInfo;
        @Context
        Request request;
       
        // Return the list of orders for applications with json or xml formats
        
        @Path("/appUrl")
        @GET
        @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
        public String getAppUrl() 
        {
          List<Constants> consts = new ArrayList<Constants>();
          try {
			consts.addAll(ConstantsDao.instance.getAllConstants("main_app_url","movie",null));
		} catch (Exception e) {
			e.printStackTrace();
		}
          return new Gson().toJson(consts);
        }
}