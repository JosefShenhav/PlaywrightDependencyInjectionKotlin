import automation.pages.HomePage
import org.junit.jupiter.api.Test

class GoogleTest : BaseTest() {

    @Test
    fun searchInGoogle() {
        val homePage: HomePage = pageNavigator.navigateToPage()
        homePage.fillSearchTextbox("Change it !!!")
    }
}