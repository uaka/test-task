import com.codeborne.selenide.Configuration;
import helper.OSValidator;
import org.testng.annotations.BeforeTest;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeTest
    public void setup() throws URISyntaxException {
        URL resource = null;
        if(OSValidator.isWindows())
            resource = SearchTest.class.getResource("/chromedriver.exe");
        else if(OSValidator.isMac())
            resource = SearchTest.class.getResource("/chromedriver_MAC");
        else if(OSValidator.isUnix())
            resource = SearchTest.class.getResource("/chromedriver_linux");
        
        String chromedriverPath = Paths.get(resource.toURI()).toFile().getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        System.setProperty("selenide.browser", "Chrome");
        Configuration.browser = "chrome";
        open("https://www.amazon.de/");
    }
}
