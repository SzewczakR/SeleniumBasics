import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;



public class FormTest extends TestBase{


    public WebElement getRandomElement(List<WebElement> elements){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size() - 1);
        return elements.get(randomNumber);
    }

    @Test
    public void Test() {

        driver.get("http://seleniumui.tc-sii.com/form.php");
        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");
        WebElement lastName = driver.findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");
        WebElement email = driver.findElement((By.id("inputEmail3")));
        email.sendKeys("jan.kowalski@wp.pl");
        WebElement sex = driver.findElement(By.id("gridRadiosOther"));
        sex.click();
        WebElement wiek = driver.findElement(By.id("inputAge3"));
        wiek.sendKeys("32");

        List<WebElement> listaDoswiadczenia = driver.findElements(By.name("gridRadiosExperience"));
        WebElement doswiadczenie = getRandomElement(listaDoswiadczenia);
        doswiadczenie.click();

        WebElement profession = driver.findElement(By.id("gridCheckAutomationTester"));
        profession.click();


        WebElement continents = driver.findElement(By.id("selectContinents"));
        Select continentsSelect = new Select(continents);
        List<WebElement> allOptions = continentsSelect.getOptions();
        WebElement randomOption = getRandomElement(allOptions);
        continentsSelect.selectByVisibleText(randomOption.getText());


        WebElement commands = driver.findElement(By.id("selectSeleniumCommands"));
        Select command = new Select(commands);
        command.selectByValue("wait-commands");

        WebElement path = driver.findElement(By.id("chooseFile"));
        File file = new File("src\\main\\resources\\emptyFile.txt");
        path.sendKeys(file.getAbsolutePath());

        WebElement additionalField = driver.findElement(By.id("additionalInformations"));
        additionalField.sendKeys("afgafgafg");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement walidacja = driver.findElement(By.id("validator-message"));
        Assert.assertEquals(walidacja.getText(),"Form send with success");

    }

    //@AfterMethod
    //public void Clean(){        driver.close();    }
}
