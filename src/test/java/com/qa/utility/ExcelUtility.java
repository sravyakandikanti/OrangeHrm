package com.qa.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	
	public ExcelUtility(String excelPath,String sheetName)
	{
		try
		{
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public  int getRowCount() throws IOException
	{
			int x=sheet.getPhysicalNumberOfRows();
			return x;
	}
	
	public  int getColCount() throws IOException
	{
	int x=sheet.getRow(0).getPhysicalNumberOfCells();
		return x;
    }
	
	public String getCellDataString(int rownum,int colnum) throws IOException
	{

		String xx= sheet.getRow(rownum).getCell(colnum).getStringCellValue();

		return xx;

	}
	public double getCellNumericString(int rownum,int colnum) throws IOException
	{

		double xx= sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
        //System.out.println(xx);
		return xx;
	}

	public boolean getCellType(int rownum,int colnum) throws IOException
	{

			if(sheet.getRow(rownum).getCell(colnum).getCellType().toString().equals("STRING"))
			{
				
				return true;
			}
			else
			{
				return false;
			}

	}
	
}
