package UtilityPackages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propartiesClass {

	public String inputData(String key) throws Exception
	{
		Properties pro=new Properties();
		pro.load(new FileInputStream("./src/test/resources/Grocela.proparties"));
		return pro.getProperty(key); 
	}

}
