package scraper;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/*Only contains support for fetching links to all stock tracks at the moment*/

public class TmXLinkFetcher {

    public TmXLinkFetcher() {
    }

    //Fetches all urls for all TMNF stock tracks
    public URL[] fetchStockTrackLinks() {
        //Sets up the firefox webdriver used to get all links
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette",true);
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://tmnforever.tm-exchange.com/tracksearch/1001?mode=1");

        //Expand to show all results
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[6]/select/option[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl01_DoSearch\"]")).click();

        //This code gets all links
        URL[] urls = new URL[65]; //The amount of stock nadeo tracks tmnf
        int i = 2;
        while(true) {
            try {
                urls[i - 2] = new URL(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/table/tbody/tr[" + i + "]/td[1]/a[3]")).getAttribute("href"));
            }catch (Exception e){
                break;
            }
            i++;
        }
        return urls;
    }

}
