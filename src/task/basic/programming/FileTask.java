package task.basic.programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import utils.InvalidInputException;
import utils.UtilityActions;

public class FileTask {
	
	
	
	public String getCurrentDir() {
		return System.getProperty("user.dir");
	}
	
	private FileWriter getWriter(File file) 
			throws IOException, InvalidInputException {
		UtilityActions.checkNull(file);
		return new FileWriter(file);
	}
	
	private FileReader getFileReader(File file)
			throws FileNotFoundException, InvalidInputException {
		UtilityActions.checkNull(file);
		return new FileReader(file);
	}
	
	public void writeLines(String[] strArr, File file,String delim)
			throws IOException, InvalidInputException {
		UtilityActions.checkNull(strArr);
		int len=strArr.length;
		try (FileWriter fWriter=getWriter(file)){
			for(int i=0;i<len;i++){
				fWriter.write(strArr[i]+delim);
			}
		}
	}
	
	public void readProp(File file, Properties prop)
			throws FileNotFoundException, IOException, InvalidInputException {
		UtilityActions.checkNull(prop);
		try(FileReader reader = getFileReader(file)){
			prop.load(reader);
		}
	}
	
	public File getFile(String parent,String child) 
			throws IOException, InvalidInputException{
		UtilityActions.checkNull(parent);
		return new File(parent,child);
	}
	
	public Properties getProp() {
		return new Properties();
	}
	
	public void insertEntry(Properties prop,String key,String val) 
			throws InvalidInputException {
		UtilityActions.checkNull(prop);
		UtilityActions.checkNull(key);
		UtilityActions.checkNull(val);
		prop.setProperty(key,val);
	}
	
	public void storeProp(Properties prop,File file,String str)
			throws InvalidInputException, IOException {
		UtilityActions.checkNull(prop);
		try(FileWriter fileWriter = getWriter(file)){
			prop.store(fileWriter,str);
		}
		
	}

	public boolean createDir(String dirPath) 
			throws InvalidInputException {
		UtilityActions.checkNull(dirPath);
		return new File(dirPath).mkdirs();
	}
	
}
