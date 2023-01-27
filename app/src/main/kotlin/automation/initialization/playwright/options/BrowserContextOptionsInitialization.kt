package automation.initialization.playwright.options

import com.microsoft.playwright.Browser
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private const val BROWSER_CONTEXT_CONFIG_PREFIX = "browser-context-options"

@Configuration
open class BrowserContextOptionsInitialization {

    @Bean
    @ConfigurationProperties(prefix = BROWSER_CONTEXT_CONFIG_PREFIX)
    open fun getBrowserContextOptions(): Browser.NewContextOptions {
        return Browser.NewContextOptions()
    }
}