import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DelfiArticleTest {
    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-md-30')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'text-size-md-28')]");

    @Test //анотация
    public void titleAndCommentsTest() {

        //Open Browser
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Delfi Home Page
        driver.get("http://rus.delfi.lv");

        //Find 1st Article Title
        WebElement homePageTitle = driver.findElement(HOME_PAGE_TITLE);

        //Save to String
        String titleToCompare = homePageTitle.getText();

        //Find Comments count
        WebElement homePageComments = driver.findElement(HOME_PAGE_COMMENTS);

        //Save to Integer
        String commentToParse = homePageComments.getText(); //(1)
        commentToParse = commentToParse.substring(1, commentToParse.length()-1); // вытаскивает (1) и отбрасывает певрый символ, считает длину и отбрасывает последний символ.
        Integer commentsToComapare = Integer.valueOf(commentToParse); // переделывает из Sting в Integer и записывает результат в commentsToCompare

        //Open Article page
        homePageTitle.click();

        //Find  Title
        //Save to String
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        //Check title
        Assertions.assertEquals(titleToCompare, articlePageTitle,"Wrong title to Article Page!");

        //Find Comments count
        Integer articlePageComments = Integer.valueOf(driver.findElement(ARTICLE_PAGE_COMMENTS).getText().substring(1,driver.findElement(ARTICLE_PAGE_COMMENTS).getText().length()-1));
        //вот так делать не надо!! Надо делать как выше в 3 строки.

        //Check Comments count
        Assertions.assertEquals(commentsToComapare, articlePageComments,"Comments Count is not the same on Article Page!");
        //Open Comments Page
        //Find title
        //Check Title
        //Get Comments count
        //Check Comments count
        //Close Browser

    }
}
