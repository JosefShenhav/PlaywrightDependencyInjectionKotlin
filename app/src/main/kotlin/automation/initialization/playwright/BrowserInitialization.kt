package automation.initialization.playwright

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Playwright
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class BrowserInitialization(
    private val playwrightConfig: BrowserType.LaunchOptions,
    private val playwright: Playwright
) {

    @Bean
    open fun getBrowser(): Browser {
        playwright.chromium()
        return playwright.chromium().launch(playwrightConfig)
    }
}