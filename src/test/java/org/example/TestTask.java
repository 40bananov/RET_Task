package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestTask {
	public static YandexPage yandexPage;
	public static SearchResultPage searchResultPage;
	public static RoseltorgPage roseltorgPage;
	public static RoseltorgAboutPage roseltorgAboutPage;
	public static WebDriver driver;

	/**
	 * осуществление первоначальной настройки
	 */
	@BeforeClass
	public static void setup() {
		// определение пути до драйвера и его настройка
		System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
		// создание экземпляра драйвера
		driver = new ChromeDriver();
		yandexPage = new YandexPage(driver);
		searchResultPage = new SearchResultPage(driver);
		roseltorgPage = new RoseltorgPage(driver);
		roseltorgAboutPage = new RoseltorgAboutPage(driver);
		// окно разворачивается на полный экран
		driver.manage().window().maximize();
		// задержка на выполнение теста = 10 сек.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// получение ссылки на страницу входа из файла настроек
		driver.get(ConfProperties.getProperty("yandexPage"));
	}

	/**
	 * тестовый метод для осуществления аутентификации
	 */
	@Test
	public void loginTest() {
		// вводим строку поиска
		yandexPage.inputSearchString(ConfProperties.getProperty("searchString"));
		// нажимаем кнопку поиска
		yandexPage.clickSearchBtn();
		// нажимаем на первую ссылку
		searchResultPage.clickFirstResult();
		// переходим по ссылке в меню
		roseltorgPage.entryMenu();
		// и сравниваем его с датой из файла настроек
		String foundationDate = roseltorgAboutPage.getFoundationDate();
		Assert.assertEquals(ConfProperties.getProperty("date"), foundationDate);
	}

	/**
	 * закрытие окна браузера
	 */
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}