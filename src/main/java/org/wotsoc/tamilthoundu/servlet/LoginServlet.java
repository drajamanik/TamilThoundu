/**
 * @author Rajamani David
 * @since	Mar 22, 2016
 *
 */
package org.wotsoc.tamilthoundu.servlet;

/**
 * @author rdavid
 *
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wotsoc.tamilthoundu.dao.UserDao;
import org.wotsoc.tamilthoundu.dto.Login;
import org.wotsoc.tamilthoundu.util.IpUtils;
 
/**
 * Route all login throws this page.
 */
@WebServlet("/loginService")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 5328054088510297232L;
  
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        String encodedURL = response.encodeRedirectURL("/movies/main");
        response.sendRedirect(encodedURL); 
        return;
    }
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        // get request parameters for userID and password
        String emailId = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserDao userDao = new UserDao();
    	Login userLogin= new Login();
    	userLogin.setUserName(emailId);
    	userLogin.setPassword(password);
    	
		String ip = IpUtils.getIpFromRequest(request);
    	userLogin.setIp(ip);
    	try 
    	{
    			boolean hasActiveSession=userDao.isUserHasActiveSession(emailId);
    			System.out.println("hasActiveSession:"+hasActiveSession);
//    			UserSession userSession= userDao.login(userLogin);
//    			if(userSession==null || userSession.getUserName()==null)
//    			{
//    				error(getServletContext(),request,response);
//    			}
	            if (!response.isCommitted())
	            response.sendRedirect("/movies/allmovie.html");
	            return;
//	            HttpSession session = request.getSession();
//	            session.setAttribute("user", userSession);
//	            //setting session to expiry in 30 mins
//	            session.setMaxInactiveInterval(30*60);
//	            Cookie userName = new Cookie("user", emailId);
//	            response.addCookie(userName);
//	            //Get the encoded URL string
//
//	            String page="";
//	            String paid= userSession.getIsPaid();
//	            if(paid!=null && paid.equalsIgnoreCase("Y"))
//	            	page="/main";
//	            else
//	            	page="/payment";
//	            	
//	            RequestDispatcher rd = request.getRequestDispatcher(page);
//	            if(rd==null)
//	            	rd = request.getRequestDispatcher("/error");
// 				rd.forward(request, response);
    	} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			error(getServletContext(),request,response);
		}
    }
    
    public void error(ServletContext context, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		RequestDispatcher rd = context.getRequestDispatcher("/login");
        response.addHeader("FAILURE", "Login Failed");
        response.addHeader("ERROR", "Either user name or password is wrong");
        rd.forward(request, response);
	}
}