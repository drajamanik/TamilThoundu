package org.wotsoc.tamilthoundu.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.wotsoc.tamilthoundu.domain.Address;
import org.wotsoc.tamilthoundu.jdbc.JDBCConnection;
import org.wotsoc.tamilthoundu.jdbc.PreparedStatementParameter;

public class AddressDAO
{

	public Address createAddress(Address address) throws Exception
	{
		StringBuffer buff=new StringBuffer();
		buff.append("INSERT INTO public.user_address (user_address_id,user_id,user_profile_id,place_name,street_name_1,street_name_2,city,country,code)");
		buff.append(" VALUES (?,?,?, ?,?,?, ?,?,?); ");

		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		list.add(new PreparedStatementParameter(address.getUserAddressId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(address.getUserId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(address.getUserProfileId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(address.getPlaceName(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(address.getAddress1(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(address.getAddress2(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(address.getCity(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(address.getCountry(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(address.getZipCode(),Types.VARCHAR));
		int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		if(count>0)
		{
			return address;
		}
		return null;	
	}
	
}
