package automation.config

import lombok.Data
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

private const val PAGE_NAVIGATOR_CONFIG_PREFIX: String = "page-navigator-config"

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = PAGE_NAVIGATOR_CONFIG_PREFIX)
open class PageNavigatorConfig {

    lateinit var baseUrl: String
    lateinit var homePage: String
}