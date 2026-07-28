package pages;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class MainPage {

    public final SelenideElement mePageBtn = $(by("href", "/me"));

    public void openMePage() {
        mePageBtn.click();
    }

}
