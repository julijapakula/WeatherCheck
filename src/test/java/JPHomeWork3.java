import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class JPHomeWork3 {
    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'text-size-md-28')]");
    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");
    private final By ARTICLE = By.xpath(".//span[@class = 'text-size-22 d-block']");
    private final By COMMENTS_COMMENTS = By.xpath(".//span[@class = 'type-cnt']");
    @Test
    public void titleAndCommentsTest() {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");

        WebElement article = driver.findElements(ARTICLE).get(1);
        WebElement homePageTitle = article.findElement(HOME_PAGE_TITLE);
        String titleToCompare = homePageTitle.getText().trim();

        Integer commentsToComapare = 0;
        if (!article.findElements(HOME_PAGE_COMMENTS).isEmpty() ) {
            WebElement homePageComments = article.findElement(HOME_PAGE_COMMENTS);
            String commentToParse = homePageComments.getText();
            commentToParse = commentToParse.substring(1, commentToParse.length() - 1);
            commentsToComapare = Integer.valueOf(commentToParse);
        }

        homePageTitle.click();
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText().trim();
        Assertions.assertEquals(titleToCompare, articlePageTitle, "Wrong title to Article Page!");

        Integer articlePageComToCompare = 0;
        if (!driver.findElements(ARTICLE_PAGE_COMMENTS).isEmpty() ) {
            WebElement articlePageCom = driver.findElement(ARTICLE_PAGE_COMMENTS);
            String articlePageComToParse = articlePageCom.getText();
            articlePageComToParse = articlePageComToParse.substring(1, articlePageComToParse.length() - 1);
            articlePageComToCompare = Integer.valueOf(articlePageComToParse);
        }
        Assertions.assertEquals(commentsToComapare, articlePageComToCompare, "Comments Count is not the same on Article Page!");

        WebElement commentsOnArticlePage = driver.findElement(ARTICLE_PAGE_COMMENTS);
        commentsOnArticlePage.click();
        String commentPageTitleToCompare = driver.findElement(COMMENTS_PAGE_TITLE).getText().trim();
        Assertions.assertEquals(titleToCompare, commentPageTitleToCompare, "Comments page title are not equal to Home page title!");

        List <WebElement> comComments = driver.findElements(COMMENTS_COMMENTS);
        for (int i=0; i< comComments.size(); i ++) {
            String anonimCommentToParse = comComments.get(0).getText();
            anonimCommentToParse = anonimCommentToParse.substring(1, anonimCommentToParse.length() - 1);
            Integer anonimComToComapare = Integer.valueOf(anonimCommentToParse);
            String regCommentToParse = comComments.get(1).getText();
            regCommentToParse = regCommentToParse.substring(1, regCommentToParse.length() - 1);
            Integer regComToComapare = Integer.valueOf(regCommentToParse);
            Integer comComToCompare = Integer.sum(anonimComToComapare, regComToComapare);
            Assertions.assertEquals(commentsToComapare, comComToCompare,"Comments Count is not the same on Comment Page!");
        }
        driver.quit();
    }
}
