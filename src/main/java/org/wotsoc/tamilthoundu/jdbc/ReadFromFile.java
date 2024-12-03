/**
 * @author Rajamani David
 * @since	Apr 17, 2019
 *
 */
package org.wotsoc.tamilthoundu.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rajamani David
 * @since	17/April/2019
 * 	Different ways to read file.
 *
 */
public class ReadFromFile {

	public static String  readFileAsString(String fileName) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		FileReader fr = null;
		try 
		{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) 
			{
				sb.append(sCurrentLine);
			}
		} 
		catch (IOException e) 
		{

			e.printStackTrace();

		} finally {
			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			}
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public List<String> readFileAsList(String fileName) throws Exception
	{
	 	List<String> mainList =new ArrayList<String>();
		BufferedReader br = null;
		FileReader fr = null;
		try 
		{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) 
			{
				mainList.add(sCurrentLine);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} finally {
			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			}
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
		return mainList;
	 }
	
	public Map<String,String> readFileAsMap(String fileName) throws Exception
	{
		Map<String,String> mainMap = new HashMap<String,String>();
		BufferedReader br = null;
		FileReader fr = null;
		try 
		{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;
			String values[] = null; 
			while ((sCurrentLine = br.readLine()) != null) 
			{
				values = sCurrentLine.split(",");
				mainMap.put(values[0],values[1]);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}finally {
			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			}
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
		return mainMap;
	 }

}
