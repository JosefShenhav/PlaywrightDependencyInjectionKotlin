import automation.initialization.spring.AUTOMATION_BASE_PACKAGE
import automation.navigation.PageNavigator
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.*
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@TestInstance(Lifecycle.PER_CLASS)
open class BaseTest {

    lateinit var pageNavigator: PageNavigator
    private lateinit var applicationContext: AnnotationConfigApplicationContext

    @BeforeEach
    fun initApplicationContext() {
        applicationContext = AnnotationConfigApplicationContext(AUTOMATION_BASE_PACKAGE)
        pageNavigator = applicationContext.getBean(PageNavigator::class.java)
    }

    @AfterEach
    fun closeApplicationContext() {
        applicationContext.close()
    }
}