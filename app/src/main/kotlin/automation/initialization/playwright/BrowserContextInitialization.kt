package automation.initialization.playwright

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class BrowserContextInitialization(
    private val browserContextConfig: Browser.NewContextOptions,
    private val browser: Browser
) {

    @Bean
    open fun getBrowserContext(): BrowserContext {
        return browser.newContext(browserContextConfig)
    }
}