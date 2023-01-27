package automation.elments

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page

open class BaseElement(page: Page, selector: String) {
    protected val locator: Locator = page.locator(selector)
}