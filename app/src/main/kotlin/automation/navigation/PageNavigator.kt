package automation.navigation

import automation.config.PageNavigatorConfig
import automation.pages.BasePage
import com.microsoft.playwright.Page
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import kotlin.reflect.full.memberProperties

private const val SHOULD_IGNORE_CASE = true

@Component
class PageNavigator(
    private val pageNavigatorConfig: PageNavigatorConfig,
    private val page: Page,
    private val pages: List<BasePage>
) {

    internal inline fun <reified T : BasePage> navigateToPage(): T {
        val pageRoute: String = extractPageRouteFromPageType<T>()
        return generatePage(pageRoute)
    }

    private inline fun <reified T : BasePage> extractPageRouteFromPageType() =
        pageNavigatorConfig::class.memberProperties.first {
            it.name.contains(T::class.simpleName!!, SHOULD_IGNORE_CASE)
        }.getter.call(pageNavigatorConfig) as String

    private inline fun <reified T : BasePage> generatePage(pageRoute: String): T {
        page.navigate("${pageNavigatorConfig.baseUrl}${pageRoute}")
        return pages.filterIsInstance<T>().first()
    }
}