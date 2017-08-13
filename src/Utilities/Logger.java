/**
 * Class for logging info and error messages to a log file.
 * 
 * @author David Strömner
 * @versopn 2017-05-26
 */

package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class Logger {
	private static Logger logger = null;
	private static PrintWriter writer;
	private static String fileName = "Logger.txt";
	private static Date date;
	
	private Logger(){
		try {
			writer = new PrintWriter(new File(GlobalPaths.SYSTEMPATH + fileName), "UTF-8");
			// TODO fix date, only displays the time for when the class was created
			date = new Date();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param information to be printed to the logger.
	 */
	public static void infoLogger(String information){
		// Create the logger if it doesn't exist already
		if(logger == null){
			logger = new Logger();
		}
		output("INFO", information);
	}
	
	/**
	 * @param error to be printed to the logger.
	 */
	public static void errorLogger(String error){
		// Create the logger if it doesn't exist already
		if(logger == null){
			logger = new Logger();
		}
		output("ERROR", error);
		// TODO write stacktrace to file
	}
	
	/**
	 * Writes the information to the output sources.
	 * @param type of data that should be printed.
	 * @param string data string to be printed.
	 */
	private static void output(String type, String string){
		System.out.println(type + "(" + date.getTime() + ") " + string);
		writer.println(type + "(" + date.getTime() + ") " + string);
		writer.flush();
	}
}
