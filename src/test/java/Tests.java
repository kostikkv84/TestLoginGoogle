import Pages.MainLoginPage;
import org.junit.Assert;
import org.junit.Test;

public class Tests extends BaseClass {
    private final static String URL = "https://goo.su/DXLBzz";
    private final static String EMAIL = "верный Email"; // введите свой верный email
    private final static String ERROR_EMAIL = "124@ya.ru";
    private final static String PASSWORD = "верный пароль"; // введите свой верный пароль
    private final static String ERROR_PASSWORD = "invPass";
    private final String errorPasswordMsg = "Неверный пароль.";
    private final String errorEmailMsg = "Забыли адрес электронной почты?";

    /**
     * Проверяем на верный логин и пароль
     */
    @Test
    public void testLoginSuccess() {
        // Верно если:
        Assert.assertTrue(new MainLoginPage(URL)
                .mailInputClick(EMAIL) // ввели верный логин
                .passwordInputSuccess(PASSWORD) // ввели верный пароль
                .getAccountLogo()); // получили страницу с логотипом аккаунта - что говорит о успешной авторизации
    }

    /**
     * Проверяем если введен верный логин и НЕ ВЕРНЫЙ пароль
     */
    @Test
    public void testLoginError() {
        // истина если ошибка найдена.
        Assert.assertTrue(new MainLoginPage(URL)
                .mailInputClick(EMAIL) // вводим email и нажимаем далее
                .passwordInputError(ERROR_PASSWORD) //вводим не верный пароль и нажимаем далее
                .errorMsg() // получаем ошибку
                .contains(errorPasswordMsg)); // ищем в тексте ошибки значение переменной errorMsg
    }

    /**
     * Проврка на ошибку в Email при авторизации
     */
    @Test
    public void loginError() {
        Assert.assertTrue(new MainLoginPage(URL)
                .errorMailInputClick(ERROR_EMAIL) // вводим не верный логин
                .getErrorMail() // получаем страницу с ошибкой
                .contains(errorEmailMsg)); // проверяем что на странице с ошибкой есть ошибка
    }
}
