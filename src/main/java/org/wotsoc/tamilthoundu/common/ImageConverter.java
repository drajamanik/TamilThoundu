/**
 * @author Rajamani David
 * @since	Apr 28, 2018
 *
 */
package org.wotsoc.tamilthoundu.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

/**
 * @author rdavid
 *
 */
public class ImageConverter 
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
	}

	public Object[] convertToStream(String fileName) 
	{
		File file = new File(fileName);
		try 
		{
			/*
			 * Reading a Image file from file system
			 */
			FileInputStream imageInFile = new FileInputStream(file);
			byte imageData[] = new byte[(int)file.length()];
			imageInFile.read(imageData);
			return new Object[]{imageInFile,fileName,file.length()};
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the file " + ioe);
		}
		return null;
	}

 	public String convertToString(String fileName) 
	{
		File file = new File(fileName);
		try 
		{
			/*
			 * Reading a Image file from file system
			 */
			FileInputStream imageInFile = new FileInputStream(file);
			byte imageData[] = new byte[(int)file.length()];
			imageInFile.read(imageData);
			/*
			 * Converting Image byte array into Base64 String 
			 */
			String imageDataString = encodeImage(imageData);
 			imageInFile.close();
			return imageDataString;
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the file " + ioe);
		}
		return null;
	}
	
	public static void mainTest(String[] args) {
		File file = new File("C:\\tamil\\Sandilyan\\Aalai Arasi\\page1.jpg");
		
		try {
			/*
			 * Reading a Image file from file system
			 */
			FileInputStream imageInFile = new FileInputStream(file);
			byte imageData[] = new byte[(int)file.length()];
			imageInFile.read(imageData);
			
			/*
			 * Converting Image byte array into Base64 String 
			 */
			String imageDataString = encodeImage(imageData);
			
			/*
			 * Converting a Base64 String into Image byte array 
			 */
			byte[] imageByteArray = decodeImage(imageDataString);
			
			/*
			 * Write a image byte array into file system  
			 */
			FileOutputStream imageOutFile = new FileOutputStream("C:\\tamil\\Sandilyan\\Aalai Arasi\\convert1.jpg");
			imageOutFile.write(imageByteArray);
			
			imageInFile.close();
			imageOutFile.close();
			
			System.out.println("Image Successfully Manipulated!");
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}

	}

	
	/**
	 * Encodes the byte array into base64 string
	 * @param imageByteArray - byte array
	 * @return String a {@link java.lang.String}
	 */
	public static String encodeImage(byte[] imageByteArray)
	{		
		return Base64.encodeBase64URLSafeString(imageByteArray);		
	}
	
	/**
	 * Decodes the base64 string into byte array
	 * @param imageDataString - a {@link java.lang.String} 
	 * @return byte array
	 */
	public static byte[] decodeImage(String imageDataString) 
	{		
		return Base64.decodeBase64(imageDataString);
	}

}
