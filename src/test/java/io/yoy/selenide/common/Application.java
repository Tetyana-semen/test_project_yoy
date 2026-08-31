package io.yoy.selenide.common;

import io.yoy.selenide.pages.AdminEventPage;
import io.yoy.selenide.pages.CommunityPage;
import io.yoy.selenide.pages.CreateCommunityPage;
import io.yoy.selenide.pages.EventPage;
import io.yoy.selenide.pages.EventsPage;
import io.yoy.selenide.pages.MePage;
import io.yoy.selenide.pages.IFramePage;
import io.yoy.selenide.pages.InteractionsEventPage;
import io.yoy.selenide.pages.MainEventPage;
import io.yoy.selenide.pages.MainPage;
import io.yoy.selenide.pages.PublicationEventPage;
import io.yoy.selenide.pages.RegistrationFormEventPage;
import io.yoy.selenide.pages.SignInPage;
import io.yoy.selenide.pages.TicketsEventPage;
import io.yoy.selenide.utils.storage.TestDataContext;

public class Application {

    public final SignInPage signInPage = new SignInPage();
    public final MainPage mainPage = new MainPage();
    public final MePage mePage = new MePage();
    public final CreateCommunityPage createCommunityPage = new CreateCommunityPage();
    public final CommunityPage communityPage = new CommunityPage();
    public final MainEventPage mainEventPage = new MainEventPage();
    public final TicketsEventPage ticketsEventPage = new TicketsEventPage();
    public final InteractionsEventPage interactionsEventPage = new InteractionsEventPage();
    public final RegistrationFormEventPage registrationFormEventPage = new RegistrationFormEventPage();
    public final PublicationEventPage publicationEventPage = new PublicationEventPage();
    public final EventPage eventPage = new EventPage();
    public final EventsPage eventsPage = new EventsPage();
    public final AdminEventPage adminEventPage = new AdminEventPage();
    public final IFramePage iFramePage = new IFramePage();
    public final TestDataContext context = new TestDataContext();


}
