package io.yoy.playwright.pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TicketsPagePW {

    private Page page;

    private final Locator ticketEventTitle = page.getByTestId("ticket-event-title");
    private final Locator ticketsTab = page.getByTestId("tickets-tab-notify-dot");

    public TicketsPagePW(Page page) {
        this.page = page;

    }

    public TicketsPagePW moveToTicketsTabAndVerifyTicketIsPresent(String eventTitle) {
        ticketsTab.click();
        assertThat(ticketEventTitle.filter(new Locator.FilterOptions().setHasText(eventTitle)))
            .isVisible();
        return this;
    }
}
