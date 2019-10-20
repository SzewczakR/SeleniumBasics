import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SlideTest extends TestBase{

    public void moveSlider(int number, Keys key){
        for (int i=0; i<number;i++) {
            driver.findElement(By.id("custom-handle")).sendKeys(key);
        }
    }


    public void moveTo(int number){
        int actualSliderValue = Integer.parseInt(driver.findElement(By.id("custom-handle")).getText());

        if(actualSliderValue>number){
            moveSlider(actualSliderValue-number, Keys.ARROW_LEFT);
        } else if(actualSliderValue<number){
            moveSlider(number-actualSliderValue, Keys.ARROW_RIGHT);
        }
    }

    @Test
    public void Test() {

        driver.get("http://seleniumui.tc-sii.com/slider.php");

        WebElement pasek = driver.findElement(By.id("custom-handle"));
        moveTo(50);
        moveTo(20);
        moveTo(20);
        moveTo(75);


    }
}
