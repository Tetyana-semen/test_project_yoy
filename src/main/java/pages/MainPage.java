package pages;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class MainPage {

    public final SelenideElement mePageBtn = $(by("href", "/me"));
    public final SelenideElement homeLink = $("a[aria-label='йой! головна']");

    public MainPage openMePage() {
        mePageBtn.click();
        return this;
    }

    public MainPage clickHomeLink() {
        homeLink.click();
        return this;
    }


}
