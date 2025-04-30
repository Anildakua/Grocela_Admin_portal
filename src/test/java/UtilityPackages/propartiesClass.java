package UtilityPackages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propartiesClass {

	public String inputData(String key) throws Exception
	{
		FileInputStream file=new FileInputStream("./src/test/resources/Grocela.proparties");
		Properties pro=new Properties();
		pro.load(file);
		
		return pro.getProperty(key); 
	}

}
