package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainLoginPage {
    private final SelenideElement mailInput = $x("//input[@type=\"email\"]");
    private final SelenideElement errorMailInput = $x("//button[contains(text(),\"Забыли адрес\")]");


    public MainLoginPage(String url) {
        Selenide.open(url);
    }

    public MainPasswordPage mailInputClick(String email) {
        mailInput.sendKeys(email, Keys.ENTER);
        return new MainPasswordPage();
    }

    public MainLoginPage errorMailInputClick(String email) {
        mailInput.sendKeys(email, Keys.ENTER);
        return this;
    }

    public String getErrorMail() {
        return errorMailInput.getText();
    }

}
