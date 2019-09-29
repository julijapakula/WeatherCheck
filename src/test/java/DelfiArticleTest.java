import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DelfiArticleTest {
    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");

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
        //Find  Title
        //Check title
        //Find Comments count
        //Check Comments count
        //Open Comments Page
        //Find title
        //Check Title
        //Get Comments count
        //Check Comments count
        //Close Browser

    }
}
