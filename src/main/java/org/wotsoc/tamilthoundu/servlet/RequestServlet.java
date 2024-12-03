package org.wotsoc.tamilthoundu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class UpdateUsername
 */
@WebServlet("/searchAllName")
public class RequestServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private static Connection conn = null;
    List<String>  movieList =new ArrayList<String>();
	public void getConnection() 
	{
		try	
		{
			Class.forName("com.mysql.jdbc.Driver"); 
	        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movvies","root","rajamani");
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}

	}
	
	public List<String> getMovieTiles() 
	{
		try
		{
			Statement st=conn.createStatement(); 
			ResultSet rs = st.executeQuery("select * from movie");
			while(rs.next()) 
			{ 			    
				movieList.add(rs.getString(2));
			}
			rs.close(); 
	 		st.close(); 
		}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		return movieList;
	}
	
	public void getMovieTitles(String query,HttpServletResponse response) throws IOException,Exception
	{
		ServletOutputStream out = response.getOutputStream();
//		SearchService ss =new SearchService();
//		out.print(ss.getSearchAll("",query));
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() 
    {
        super();
//        getConnection();
//        getMovieTiles();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String query=request.getParameter("q");
		  String callBack = request.getParameter("callback");
		  try {
			//getMovieTitles(query, response);
			
//			SearchService ss =new SearchService();
//			String value=ss.getSearchAll(callBack,query);

			//writeJSONResonse(response, value);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		  //response.sendRedirect("./index.jsp");
	}

	public void getByUserName(String userName,HttpServletResponse response) throws IOException
	{
		 Map<String,Object> map = new HashMap<String,Object>();
		 boolean isValid=false;
		 if(userName!=null && userName.trim().length()!=0)
		 {
			 isValid=true;
			 map.put("userName",userName);
			 
		 }
		 map.put("isValid",isValid);
		 writeJSONResonse(response,map);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  String query=request.getParameter("search");
		  try {
			getMovieTitles(query, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param response
	 * @param map
	 * @throws IOException 
	 */
	private void writeJSONResonse(HttpServletResponse response,
			Map<String, Object> map) throws IOException 
	{
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(new Gson().toJson(map));
	}
	private void writeJSONResonse(HttpServletResponse response,
			String value) throws IOException 
	{
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 //response.getWriter().write(new Gson().toJson(value));
		 response.getWriter().write(value);
	}
}
