package org.example;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class RoseltorgPage {
	/**
	 * конструктор класса, занимающийся инициализацией полей класса
	 */
	public WebDriver driver;

	public RoseltorgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/**
	 * определение локаторов меню и пункта меню 
	 */
	@FindBy(xpath = "//header/div/nav/ul/li[4]")
	private WebElement headerMenuAbout;

	@FindBy(xpath = "//li[4]/ul/li[1]")
	private WebElement aboutCompany;

	/**
	 * метод для нажатия кнопки меню
	 */
	@Step("Нажимаем на пункт меню")
	public void entryMenu() {
		/**
		 * переключение на новую вкладку
		 */
		String oldTab = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		/**
		 * ожидаем появления меню, наводим курсор на 4-ый пункт, переводим его на 1-ую
		 * строку меню и кликаем
		 */
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(headerMenuAbout));
		Actions builder = new Actions(driver);
		builder.moveToElement(headerMenuAbout).build().perform();
		wait.until(ExpectedConditions.visibilityOf(aboutCompany));
		builder.moveToElement(aboutCompany).build().perform();
		aboutCompany.click();
	}
}
