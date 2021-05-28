package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class YandexPage {
	/**
	 * конструктор класса, занимающийся инициализацией полей класса
	 */
	public WebDriver driver;

	public YandexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/**
	 * определение локатора поля ввода строки поиска
	 */
	@FindBy(xpath = "//*[@id='text']")
	private WebElement inputField;
	/**
	 * определение локатора кнопки найти
	 */
//    @FindBy(xpath = "//div[@class = 'search2__button']/button")
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBtn;

	/**
	 * метод для ввода строки поиска
	 */
	@Step("Отправка в строку поиска {searchString}")
	public void inputSearchString(String searchString) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(inputField));
		inputField.sendKeys(searchString);
	}

	/**
	 * метод для нажатия кнопки поиска
	 */
	@Step("Нажатие на кнопку поиска")
	public void clickSearchBtn() {
		searchBtn.click();
	}
}
