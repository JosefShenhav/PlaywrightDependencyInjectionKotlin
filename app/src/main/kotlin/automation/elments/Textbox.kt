package automation.elments

import com.microsoft.playwright.Page

class Textbox(page: Page, selector: String) : BaseElement(page, selector) {

    fun fill(text: String) {
        locator.fill(text)
    }
}