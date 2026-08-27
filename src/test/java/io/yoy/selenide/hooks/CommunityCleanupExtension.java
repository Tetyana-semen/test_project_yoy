package io.yoy.selenide.hooks;

import static com.codeborne.selenide.Condition.visible;
import static io.yoy.selenide.utils.storage.ContextKey.COMMUNITY_NAME;

import io.yoy.selenide.tests.BaseTest;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CommunityCleanupExtension extends BaseTest implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        String name = app.context.getContextAsString(COMMUNITY_NAME);
        if (name != null) {
            deleteCommunity(name);
        }
    }

    public void deleteCommunity(String communityName) {
        app.mainPage.clickHomeLink();
        app.mainPage.openMePage();
        app.mePage.chooseCommunity(communityName);
        app.communityPage
            .clickAdminBtn()
            .clickEditBtn()
            .clickCommunityDeleteBtn()
            .clickCommunityDeleteConfirmBtn();
        app.mePage.communityLink(communityName).shouldNotBe(visible);
    }

}