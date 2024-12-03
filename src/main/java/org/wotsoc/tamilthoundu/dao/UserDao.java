/**
 * @author Rajamani David
 * @since	Nov 17, 2015
 *
 */
package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.wotsoc.tamilthoundu.domain.Constants;
import org.wotsoc.tamilthoundu.domain.User;
import org.wotsoc.tamilthoundu.domain.UserSession;
import org.wotsoc.tamilthoundu.dto.Login;
import org.wotsoc.tamilthoundu.jdbc.JDBCConnection;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;
import org.wotsoc.tamilthoundu.jdbc.PreparedStatementParameter;

public class UserDao 
{
	public UserDao() 
	{
	 
	}

	public void logOut(Login login) throws Exception
	{
		closeUserActiveSession(login.getUserName());
	}
	
	public User getUser(Integer userId,String userName) throws Exception
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.user where ");
		if(userId!=null)
			sb.append("user_Id = ").append(userId);
		else if(userName!=null)
			sb.append("user_name = '").append(userName).append("'");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		List<User> userList=getResultSet(ps.executeQuery());
		return userList!=null?userList.get(0):null;
	}
	
	public List<User> getResultSet(ResultSet rs) throws SQLException
	{
		List<User> uList = new ArrayList<User>();
		User  u=null;
		if(rs.next())
		{
			u = new User();
			u.setUserId(rs.getInt("user_Id"));
			u.setUserName(rs.getString("user_name"));
			u.setEmailId(rs.getString("email_id"));
			u.setPhone(rs.getString("phone_no"));
			uList.add(u);
		}
		return uList;
	}
	
	public User login(User user) throws Exception{
		StringBuilder buff=new StringBuilder();
		buff.append("select * from public.user where email_id=? and password=?");
		
		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		PreparedStatementParameter psp =new PreparedStatementParameter(user.getEmailId(),Types.VARCHAR);
		list.add(psp);
		psp =new PreparedStatementParameter(user.getPassword(),Types.VARCHAR);
		list.add(psp);
		ResultSet rs  = JDBCConnection .getInstance().executeSQL(buff.toString(),list);
		while(rs.next()) {
			return getUserFromResultSet(rs);
		}
		return null;
	}
	
	public UserSession login(Login login) throws Exception
	{
		LocalDateTime localDateTime = LocalDateTime.now();
		UserSession session= new UserSession();
		session.setMessage("UnAuthorized User");
		StringBuilder buff=new StringBuilder();
		buff.append("select * from user where email_id=? and password=?");
		
		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		PreparedStatementParameter psp =new PreparedStatementParameter(login.getUserName(),Types.VARCHAR);
		list.add(psp);
		psp =new PreparedStatementParameter(login.getPassword(),Types.VARCHAR);
		list.add(psp);
		ResultSet rs  = JDBCConnection .getInstance().executeSQL(buff.toString(),list);		
		while(rs.next())
		{
			session.setMessage("");
			User user=getUserFromResultSet(rs);
			session.setUserName(user.getEmailId());
			session.setIp(login.getIp());
			session.setActive("Y");
			Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			Date dateNow = Date.from(instant);
			session.setLastAccessTime(dateNow);
 			session.setIsPaid(user.getIsPaid());
			try
			{
			List<Constants> listConstants=ConstantsDao.instance.getAllConstants("session_time_out", "movie", null);
			if(listConstants.isEmpty())
			{
				LocalDateTime localDateTime2 =localDateTime.plusHours(Integer.parseInt(listConstants.get(0).getValue1()));
				localDateTime2=localDateTime2.plusMinutes(Integer.parseInt(listConstants.get(0).getValue2()));
				localDateTime2=localDateTime2.plusSeconds(Integer.parseInt(listConstants.get(0).getValue3()));
				instant = localDateTime2.atZone(ZoneId.systemDefault()).toInstant();
				Date sessionTimeOutDate = Date.from(instant);
				session.setSessionTimeOut(sessionTimeOutDate);
			}
			}catch(Exception exp)
			{
				exp.printStackTrace();
			}
			//session.setDeviceId(login.getDeviceId());
			closeUserActiveSession(login.getUserName());
			return createUserSession(session);
		}
		return session;
	}
	
	public boolean isUserNamePasswordExists(String userName,String password) throws Exception
	{
		StringBuilder buff=new StringBuilder();
		buff.append("select * from public.user where email_id=? ");
		List<PreparedStatementParameter> list =new ArrayList<>();
		list.add(new PreparedStatementParameter(userName,Types.VARCHAR));
		
		if(password!=null)
		{
			buff.append(" and password=?");	
			list.add(new PreparedStatementParameter(password,Types.VARCHAR));
		}
		ResultSet rs  = JDBCConnection .getInstance().executeSQL(buff.toString(),list);		
		return rs.next() ? Boolean.TRUE:Boolean.FALSE;
	}
	
	public boolean isUserNameExists(String userName) throws Exception
	{
		return isUserNamePasswordExists(userName,null);
 	}

	public boolean isUserHasActiveSession(String userName) throws Exception
	{
		StringBuilder buff=new StringBuilder();
		buff.append("select * from user_session where email_id=? and active='Y'");
		
		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		list.add(new PreparedStatementParameter(userName,Types.VARCHAR));
		 
		ResultSet rs  = JDBCConnection .getInstance().executeSQL(buff.toString(),list);		
		while(rs.next())
		{
			return true;
		}
		return false;
	}

	public boolean closeUserActiveSession(String userName) throws Exception
	{
		StringBuilder buff=new StringBuilder();
		buff.append("update user_session set active='N',last_access_time=sysdate() where email_id=? and active='Y'");
		
		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		list.add(new PreparedStatementParameter(userName,Types.VARCHAR));
		 
		int count=JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		return count >0? true:false;
	}

	/**
	 * Send a email to reset
	 * */
	public boolean reset(String userName)
	{
		return false;
	}

	/**
	 * Reset old password with new one
	 * @throws Exception 
	 * */
	public boolean reset(Login login) throws Exception
	{
		boolean exists=isUserNamePasswordExists(login.getUserName(), login.getOldPassword());
		if(exists)
		{	
			StringBuilder buff=new StringBuilder();
			buff.append("update user set password=? where email_id=?");
			List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
			PreparedStatementParameter psp =new PreparedStatementParameter(login.getPassword(),Types.VARCHAR);
			list.add(psp);
			psp =new PreparedStatementParameter(login.getUserName(),Types.VARCHAR);
			list.add(psp);
			int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
			if(count>0)
			{
				return true;
			}
		}
		else
		{
			throw new Exception("Wrong email id or password");
		}
		return false;
	}
	
	public boolean reset(User user) throws Exception
	{
		boolean exists= isUserNamePasswordExists(user.getEmailId(), user.getOldPassword());
		if(exists)
		{	
			StringBuilder buff=new StringBuilder();
			buff.append("update public.user set password=? where email_id=?");
			List<PreparedStatementParameter> list =new ArrayList<>();
			PreparedStatementParameter psp =new PreparedStatementParameter(user.getPassword(),Types.VARCHAR);
			list.add(psp);
			psp =new PreparedStatementParameter(user.getEmailId(),Types.VARCHAR);
			list.add(psp);
			int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
			if(count>0)
			{
				return true;
			}
		}
		else
		{
			throw new Exception("Wrong email id or password");
		}
		return false;
	}
	
	public User signUp(User user) throws Exception
	{
		boolean isExists=isUserNameExists(user.getEmailId());
		if(!isExists)
		{
			user=createUser(user);
		}
		else
		{
			throw new Exception("Email id already exists.");
		}
		return user;
	}
	
	private UserSession createUserSession(UserSession userSession) throws Exception
	{
		StringBuilder buff=new StringBuilder();
		buff.append("INSERT INTO user_session (email_id,movie_id,last_pointer,device_id,last_access_time,country,ip,active,session_timeout,zip_code,message) ");
		buff.append("VALUES (?,?,?,?,?,?,?,?,?,?,?) ");

		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		list.add(new PreparedStatementParameter(userSession.getUserName(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(userSession.getMovieId(),Types.BIGINT));
		list.add(new PreparedStatementParameter(userSession.getLastPointer(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(userSession.getDeviceId(),Types.VARCHAR));
		if(userSession.getLastAccessTime()!=null)
			list.add(new PreparedStatementParameter(new java.sql.Timestamp(userSession.getLastAccessTime().getTime()),Types.TIMESTAMP));
		else
			list.add(new PreparedStatementParameter(null,Types.TIMESTAMP));
		list.add(new PreparedStatementParameter(userSession.getCountry(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(userSession.getIp(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(userSession.getActive(),Types.CHAR));
		if(userSession.getSessionTimeOut()!=null)
			list.add(new PreparedStatementParameter(new java.sql.Timestamp(userSession.getSessionTimeOut().getTime()),Types.TIMESTAMP));
		else
			list.add(new PreparedStatementParameter(null,Types.TIMESTAMP));
		list.add(new PreparedStatementParameter(userSession.getZipCode(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(userSession.getMessage(),Types.VARCHAR));
		  
		JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		return userSession;	

	}
	
	public User createUser(User user) throws Exception
	{
		StringBuilder buff=new StringBuilder();
		buff.append("INSERT INTO public.user (user_name,password,active,email_id,phone_no)");
		buff.append(" VALUES (?,?, ?,?,?); ");

		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		//list.add(new PreparedStatementParameter(user.getUserId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(user.getUserName(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(user.getPassword(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(user.isActive(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(user.getEmailId(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(user.getPhone(),Types.VARCHAR));
		
		int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		if(count>0)
		{
			user = getUser(null,user.getUserName());
			return user;
		}
		return null;	
	}
	
	public User disableUser(User user) throws Exception
	{
		StringBuilder buff=new StringBuilder();
		buff.append("UPDATE public.user set active='N' WHERE USER_NAME=?");

		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		list.add(new PreparedStatementParameter(user.getUserName(),Types.VARCHAR));
 		  
		int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		if(count>0)
		{
			return user;
		}
		return null;	
		
	}
	
	public List<User> getAllUser() throws Exception
	{
		StringBuilder buff = new StringBuilder();
		buff .append(" select * from public.user ");
		buff .append(" order by first_name, last_name");
		ResultSet rs  = JDBCConnection .getInstance().executeSQL(buff.toString());
		List<User> userList =new ArrayList<>();
		User user=null;
		while(rs.next())
		{
			user=getUserFromResultSet(rs);
			userList.add(user);
		}
		return userList;
	}

	/**
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private User getUserFromResultSet(ResultSet rs) throws SQLException 
	{
		User user = new User();
		Object obj =null;
		
		user.setUserId((Integer)rs.getObject("user_id"));
//		obj=rs.getObject("first_name");
//		if(obj!=null)
//			user.setFirstName((String)obj);
//		obj=rs.getObject("last_name");
//		if(obj!=null)
//			user.setLastName((String)obj);

		obj = rs.getObject("email_id");
		if(obj!=null)
			user.setEmailId((String) obj);
		
		obj = rs.getObject("password");
		if(obj!=null)
			user.setPassword((String ) obj);
		
//		obj = rs.getObject("is_paid");
//		if(obj!=null)
//			user.setIsPaid((String)obj);
		
		return user;
	}
	
	public static User  createUser()
	{
		User user = new User();
		user.setFirstName("Sheela");
		user.setLastName("Jaya");
		user.setPhone("5105939981");
		user.setUserName("jsheela");
		user.setUserId(1);
		user.setEmailId("sheelaraj9@gmail.com");
		user.setPassword("kuppachi");
		return user ;
	}
	public static void main(String args[]) throws Exception
	{
		UserDao userDao = new UserDao();
		System.out.println(userDao.getUser(1,null));
//		Login login =new Login();
//		login.setUserName("sheelaraj9@gmail.com");
//		login.setPassword("rajamani1");
//		login.setOldPassword("kuppachi");
//		login.setIp("127.0.0.1");
//		
		//System.out.println(userDao.login(login));
		//System.out.println(userDao.reset(login));
		
		//userDao.signUp(createUser());
	}
}
