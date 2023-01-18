package Pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.Keys;

import java.security.Key;

import static com.codeborne.selenide.Selenide.$x;

public class MainPasswordPage {
    private final SelenideElement passwordInput = $x("//input[@type=\"password\"]");
    private final SelenideElement passwordError = $x("//div[@aria-live=\"assertive\"]");


    public MainPasswordPage passwordInputError(String invalidPassword){
        passwordInput.sendKeys(invalidPassword,Keys.ENTER);
        return this;
    }

    public SuccessLoginPage passwordInputSuccess(String validPassword){
        passwordInput.sendKeys(validPassword, Keys.ENTER);
        return new SuccessLoginPage();
    }

    public String errorMsg (){
       return passwordError.getText();
    }



}
