import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class selenium {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        driver.manage().window().maximize();


        Thread.sleep(3300);

        WebElement mainData = driver.findElement(By.cssSelector("a[href=\"https://portal.aac.ac.il\"]"));
        mainData.click();
        Thread.sleep(300);

        System.out.println("enter pasword and name");

        String name = s.next();

        String pas = s.next();

        WebElement id = driver.findElement(By.id("Ecom_User_ID"));    id.sendKeys(name);


        WebElement password = driver.findElement(By.id("Ecom_Password"));
        password.sendKeys(pas);
        WebElement Enter = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/form/p[2]/input"));
        Enter.click();
        WebElement moodle = driver.findElement(By.cssSelector("a[href=\"https://moodle.aac.ac.il/login/index.php\"]"));
        moodle.click();
        Thread.sleep(4500);

        List<WebElement> elements = driver.findElements(new By.ByTagName("h6"));
        int counter = 0;
        for (int i = 0; i < elements.size() - 1; i++) {
            String Text = elements.get(i).getText();
            System.out.println(Text);
            counter = i;

        }
        System.out.println("enter the class number 1 - " + counter);   int course = s.nextInt();

        while (course > elements.size() || course < 1) {
            System.out.println("try again please");
            course = s.nextInt();}
        Thread.sleep(1000);

        WebElement pickedSubject = elements.get(course - 1);
        pickedSubject.click();
Thread.sleep(1000);
        System.out.println("To logout the moodle put number -1");
        int logoutMoodle = s.nextInt();
        while (logoutMoodle != -1) {
            System.out.println("To logout the moodle put number -1");
            logoutMoodle = s.nextInt();}

                    WebElement userMenu = driver.findElement(By.className("usermenu"));
                    userMenu.click();

                    Thread.sleep(200);
                    WebElement exit = driver.findElement(By.id("actionmenuaction-6"));
                    exit.click();

                    Thread.sleep(1000);
                    WebElement finalExit = driver.findElement(By.xpath("//*[@id=\"menu-top-header\"]/li[2]/a"));
                    finalExit.click();}}
