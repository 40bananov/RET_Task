package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class RoseltorgAboutPage {
	/**
	 * конструктор класса, занимающийся инициализацией полей класса
	 */
	public WebDriver driver;

	public RoseltorgAboutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/**
	 * определение локатора абзаца с датой
	 */
	@FindBy(xpath = "//p[4]/b")

	// /article/div/div[1]/div/p[4]/b
	private WebElement foundationDate;

	/**
	 * метод для возврата значения даты открытия
	 */
	@Step("Сравниваем даты")
	public String getFoundationDate() {
		return foundationDate.getText();
	}

}
