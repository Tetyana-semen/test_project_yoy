package io.yoy.selenide.pages;

import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class CommunityPage {

    public final SelenideElement createEventBtn = $(byTestId("community-create-event-link"));
    public final SelenideElement adminBtn = $(byTestId("community-admin-link"));
    public final SelenideElement communityDeleteBtn = $(byTestId("community-delete-button"));
    public final SelenideElement communityDeleteConfirmBtn = $(byTestId("community-delete-confirm"));
    public final SelenideElement editBtn = $("a[href$='/admin/settings']");

    public MainEventPage clickCreateEventBtn() {
        createEventBtn.click();
        return new MainEventPage();
    }

    public CommunityPage clickAdminBtn() {
        adminBtn.click();
        return this;
    }

    public CommunityPage clickEditBtn() {
        editBtn.click();
        return this;
    }

    public CommunityPage clickCommunityDeleteBtn() {
        communityDeleteBtn.click();
        return this;
    }

    public CommunityPage clickCommunityDeleteConfirmBtn() {
        communityDeleteConfirmBtn.click();
        return this;
    }




}
