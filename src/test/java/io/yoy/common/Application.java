package io.yoy.common;

import pages.AdminEventPage;
import pages.CommunityPage;
import pages.CreateCommunityPage;
import pages.EventPage;
import pages.EventsMePage;
import pages.IFramePage;
import pages.InteractionsEventPage;
import pages.MainEventPage;
import pages.MainPage;
import pages.PublicationEventPage;
import pages.RegistrationFormEventPage;
import pages.SignInPage;
import pages.TicketsEventPage;

public class Application {

    public final SignInPage signInPage = new SignInPage();
    public final MainPage mainPage = new MainPage();
    public final EventsMePage eventsMePage = new EventsMePage();
    public final CreateCommunityPage createCommunityPage = new CreateCommunityPage();
    public final CommunityPage communityPage = new CommunityPage();
    public final MainEventPage mainEventPage = new MainEventPage();
    public final TicketsEventPage ticketsEventPage = new TicketsEventPage();
    public final InteractionsEventPage interactionsEventPage = new InteractionsEventPage();
    public final RegistrationFormEventPage registrationFormEventPage = new RegistrationFormEventPage();
    public final PublicationEventPage publicationEventPage = new PublicationEventPage();
    public final EventPage eventPage = new EventPage();
    public final AdminEventPage adminEventPage = new AdminEventPage();
    public final IFramePage iFramePage = new IFramePage();

}
