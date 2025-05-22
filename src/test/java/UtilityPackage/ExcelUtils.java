package UtilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	public String inputData(String Sheet , int row ,int cell) throws Exception 
	{ 
		return WorkbookFactory.create(new FileInputStream("./src/test/resources/grocela_Admin_Portal.xlsx")).getSheet(Sheet).getRow(row).getCell(cell).toString();

	}
}
