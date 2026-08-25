package pages;

import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.NoSuchElementException;

public class AdminEventPage {

    public final SelenideElement tabVidzhet = $(byTestId("tab-vidzhet"));
    public final SelenideElement widgetSnippet = $(byTestId("widget-snippet"));

    public AdminEventPage clickTabVidzhetBtn() {
        tabVidzhet.click();
        return this;
    }

    public String getWidgetHtml() {
        return widgetSnippet.getAttribute("innerHTML");
    }

    public String getWidgetEventId() {
        String snippet = widgetSnippet.getText();
        Matcher matcher = Pattern.compile(
            "data-yoy-event=\"([0-9a-fA-F-]{36})\""
        ).matcher(snippet);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new NoSuchElementException("data-yoy-event not found in widget snippet");
    }


}
