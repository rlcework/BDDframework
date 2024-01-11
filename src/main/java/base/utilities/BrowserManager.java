package base.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserManager {

    private WebDriver driver = new ChromeDriver();
    public WebDriver getDriver(){
        return driver;
    }
    public void close() {
        this.driver.close();
    }
}
