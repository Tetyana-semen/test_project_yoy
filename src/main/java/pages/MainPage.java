package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class MainPage {

    public final SelenideElement mePageBtn = $("[data-testid='bottom-nav'] div > a:nth-child(5)");

    public void openMePage() {
        mePageBtn.click();
    }

}
