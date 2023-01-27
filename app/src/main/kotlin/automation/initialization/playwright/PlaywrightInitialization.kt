package automation.initialization.playwright

import com.microsoft.playwright.Playwright
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class PlaywrightInitialization {

    @Bean
    open fun getPlaywright(): Playwright {
        return Playwright.create()
    }
}