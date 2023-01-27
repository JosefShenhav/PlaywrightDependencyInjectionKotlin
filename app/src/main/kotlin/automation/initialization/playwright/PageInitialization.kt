package automation.initialization.playwright

import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.Page
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class PageInitialization(
    private val browserContext: BrowserContext
) {

    @Bean
    open fun getPage(): Page {
        return browserContext.newPage()
    }
}