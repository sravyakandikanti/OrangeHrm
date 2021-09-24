package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddMyInfoPage {
	WebDriver driver;
	
	@FindBy(id="txtUsername")	
	WebElement userName;
	public WebElement userName()
	{
	 return userName;
	 
	}
	
	@FindBy(id="txtPassword")
    WebElement password;
	
	public WebElement password()
	{
	 return password;
	 
	}
	
	@FindBy(id="btnLogin")
	WebElement login;
	public WebElement login()
	{
	 return login;
	 
	}
	@FindBy(linkText="PIM")
	WebElement PIM;
	
	public WebElement getPIM() {
		return PIM;
	}
	
	
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement EmployeeList;
	public WebElement getEmployeeList() {
		return EmployeeList;
	}
	@FindBy(id="empsearch_employee_name_empName")
	WebElement EmployeeName;
	public WebElement getEmployeeName() {
		return EmployeeName;
	}
	
	@FindBy(id="searchBtn")
	WebElement Search;
	public WebElement getSearch() {
		return Search;
	}
	@FindBy(linkText="Kim")
	WebElement Kimsid;
	public WebElement getKimsid() {
		return Kimsid;
	}
	
	@FindBy(id="btnSave")
	WebElement EditInfo;
	public WebElement getEditInfo() {
		return EditInfo;
	}
	@FindBy(id="personal_DOB")
	WebElement addDOB;
	public WebElement getaddDOB() {
		return addDOB;
	}
	@FindBy(xpath="//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[2]")
    WebElement year;
	
	public Select getYear() {
		Select Year= new Select(year);
		return Year;
	}
	
	@FindBy(xpath="//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")
	WebElement Month;
	public Select getMonth() {
		Select month=new Select(Month);
		return month;
	}
	
	@FindBy(linkText="5")
	WebElement Date;
	public WebElement getDate() {
		return Date;
	}
	@FindBy(id="personal_optGender_1")
	WebElement SelectGender;
	public WebElement getSelectGender() {
		return SelectGender;
	}
	@FindBy(id="personal_cmbNation")
	WebElement SelectNationality;
	public Select getSelectNationality() {
		Select Nationality = new Select(SelectNationality);
		return Nationality;
	}
	
	@FindBy(id="btnSave")
	WebElement Savebtn;
	public WebElement getSavebtn() {
		return Savebtn;
	}
   
	@FindBy(xpath="//*[@id=\"ohrmList_chkSelectRecord_68\"]")
	WebElement checkBox;
	public WebElement getCheckBox()
	{
		return checkBox;
	}
	
	@FindBy(id="btnDelete")
	WebElement deleteEmpRecord;
	public WebElement getdeleteEmpRecord()
	{
		return deleteEmpRecord;
	}
	
	@FindBy(xpath="//*[@id=\"deleteConfModal\"]/div[2]/p")
	WebElement confirmationPopup;
	public WebElement getConfirmationPopup()
	{
		return confirmationPopup;
	}
	
	@FindBy(xpath="//*[@id=\"dialogDeleteBtn\"]")
	WebElement okBtn;
	public WebElement getOkBtn()
	{
		return okBtn;
	}
	
	
	public AddMyInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}

