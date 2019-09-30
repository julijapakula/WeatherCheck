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
    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");
    private final By ARTICLE = By.xpath(".//span[@class = 'text-size-22 d-block']");

    @Test //анотация
    public void titleAndCommentsTest() {

        //Open Browser
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Delfi Home Page
        driver.get("http://rus.delfi.lv");

        // Find first article (can be any title)
        WebElement article = driver.findElements(ARTICLE).get(0);

        //Find 1st Article Title
        //WebElement homePageTitle = driver.findElement(HOME_PAGE_TITLE);
        WebElement homePageTitle = article.findElement(HOME_PAGE_TITLE); //driver поменяли на article и тогда он ищет не на всей странице,
        // а в рамках обозначенной ранее статьи.

        //Save to String
        String titleToCompare = homePageTitle.getText();

        //Find Comments count
        Integer commentsToComapare = 0;

        // Если нет комментариев, то мы принимаем, что их 0
    /*    if (article.findElements(HOME_PAGE_COMMENTS).isEmpty() ) {
           // commentsToComapare = 0; - убрали, потому что мы выше ее уже дефинировали.
        } else {
            //WebElement homePageComments = driver.findElement(HOME_PAGE_COMMENTS); // Ищем глобально на странице браузера
            WebElement homePageComments = article.findElement(HOME_PAGE_COMMENTS); // ищем локально в статье
            // еслии нет комментария, то возвращает ошибку.

            //Save to Integer
            String commentToParse = homePageComments.getText(); //(1)
            commentToParse = commentToParse.substring(1, commentToParse.length() - 1); // вытаскивает (1) и отбрасывает певрый символ, считает длину и отбрасывает последний символ.
            commentsToComapare = Integer.valueOf(commentToParse); // переделывает из Sting в Integer и записывает результат в commentsToCompare
        }
         */
    // Делаем красиво от обратного.
        if (!article.findElements(HOME_PAGE_COMMENTS).isEmpty() ) {
            WebElement homePageComments = article.findElement(HOME_PAGE_COMMENTS);
            //Save to Integer
            String commentToParse = homePageComments.getText();
            commentToParse = commentToParse.substring(1, commentToParse.length() - 1);
            commentsToComapare = Integer.valueOf(commentToParse);
        }

        //Open Article page
        homePageTitle.click();

        //Find  Title
        //Save to String
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        //Check title
        Assertions.assertEquals(titleToCompare, articlePageTitle, "Wrong title to Article Page!");

        //Find Comments count
        Integer articlePageComments = Integer.valueOf(driver.findElement(ARTICLE_PAGE_COMMENTS).getText().substring(1, driver.findElement(ARTICLE_PAGE_COMMENTS).getText().length() - 1));
        //вот так делать не надо!! Надо делать как выше в 3 строки.

        //Check Comments count
        Assertions.assertEquals(commentsToComapare, articlePageComments, "Comments Count is not the same on Article Page!");
        //Open Comments Page
        WebElement commentsOnArticlePage = driver.findElement(ARTICLE_PAGE_COMMENTS);
        commentsOnArticlePage.click();
        //Find title
        String commentPageTitleToCompare = driver.findElement(COMMENTS_PAGE_TITLE).getText();
        //Check Title
        Assertions.assertEquals(titleToCompare, commentPageTitleToCompare, "Comments page title are not equal to Home page title!");
        //Get Comments count

        //Check Comments count

        //Close Browser

    }
}
