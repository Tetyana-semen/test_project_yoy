package pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

public class EventsPage {

    public final ElementsCollection eventCards = $$("#events-panel-upcoming [data-event-card]");

    public ElementsCollection getEventCards() {
        return eventCards;
    }

}
