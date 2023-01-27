package automation.initialization.playwright.options

import com.microsoft.playwright.BrowserType
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private const val BROWSER_CONFIG_PREFIX = "browser-config"

@Configuration
open class BrowserLaunchOptionsInitialization {

    @Bean
    @ConfigurationProperties(prefix = BROWSER_CONFIG_PREFIX)
    open fun getLaunchOptions(): BrowserType.LaunchOptions {
        return BrowserType.LaunchOptions()
    }
}