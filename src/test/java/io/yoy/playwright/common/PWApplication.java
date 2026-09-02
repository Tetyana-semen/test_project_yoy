package io.yoy.playwright.common;

import com.microsoft.playwright.Page;
import io.yoy.playwright.pages.EventPagePW;
import io.yoy.playwright.pages.HomePage;
import io.yoy.playwright.pages.NewCommunityPagePW;
import io.yoy.playwright.pages.SignInPagePW;
import io.yoy.playwright.pages.TicketsPagePW;

public class PWApplication {

    private Page page;

    public SignInPagePW signInPagePW;
    public NewCommunityPagePW communityPagePW;
    public EventPagePW eventPagePW;
    public HomePage homePage;
    public TicketsPagePW ticketsPagePW;

    public PWApplication(Page page) {
        this.page = page;
        signInPagePW = new SignInPagePW(page);
        communityPagePW = new NewCommunityPagePW(page);
        eventPagePW = new EventPagePW(page);
        homePage = new HomePage(page);
        ticketsPagePW = new TicketsPagePW(page);
    }
}
