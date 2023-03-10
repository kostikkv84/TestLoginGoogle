import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import java.util.Random;

public class BaseClass {
    public void setUp() {
        WebDriverManager.edgedriver().setup(); // Установили настройки драйвера
        Configuration.browser = "edge";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Before
    public void init() { setUp();  }

    @After
    public void tearDown (){
        Selenide.closeWebDriver();
    }


}
