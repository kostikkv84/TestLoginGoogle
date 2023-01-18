package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessLoginPage {
    private final SelenideElement accountLogo = $x("//img[contains(@src,\"googleusercontent\")]");

    public Boolean getAccountLogo(){
      return accountLogo.exists();
    }
}
