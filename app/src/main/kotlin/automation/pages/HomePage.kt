package automation.pages

import automation.elments.Textbox
import com.microsoft.playwright.Page
import org.springframework.stereotype.Component

private const val SEARCH_TEXTBOX_SELECTOR = "[name = 'q']"

@Component
class HomePage(page: Page) : BasePage() {

    private val searchTextbox: Textbox = Textbox(page, SEARCH_TEXTBOX_SELECTOR)

    fun fillSearchTextbox(text: String) {
        searchTextbox.fill(text)
    }
}