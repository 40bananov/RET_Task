package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class SearchResultPage {
	/**
	 * конструктор класса, занимающийся инициализацией полей класса
	 */
	public WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	/**
	 * определение локатора первой строки результатов поиска
	 */
	@FindBy(xpath = "//*[@id='search-result']/li[1]/div/h2/a")
	private WebElement firstResult;

	/**
	 * метод для нажатия на первую строку поиска
	 */
	@Step("Нажатие на первую ссылку в результатах поиска")
	public void clickFirstResult() {
		firstResult.click();
	}
}
