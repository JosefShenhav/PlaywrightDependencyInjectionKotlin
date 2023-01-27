package automation.initialization.spring

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.core.io.ClassPathResource
import java.util.*

const val AUTOMATION_BASE_PACKAGE: String = "automation"
private const val DEFAULT_APPLICATION_YAML_FILE_PATH = "application.yml"
private val userApplicationYaml: String = System.getenv("USER_APPLICATION_YAML") ?: "application-development.yml"

@Configuration
open class SpringPropertiesInitialization {

    @Bean
    open fun loadApplicationYamlFiles(): PropertySourcesPlaceholderConfigurer {
        val propertySources: PropertySourcesPlaceholderConfigurer = PropertySourcesPlaceholderConfigurer()
        val yamlPropertiesFactoryBean: YamlPropertiesFactoryBean = YamlPropertiesFactoryBean()
        val defaultApplicationYamlResource: ClassPathResource = ClassPathResource(DEFAULT_APPLICATION_YAML_FILE_PATH)
        val userApplicationYamlResource: ClassPathResource = ClassPathResource(userApplicationYaml)

        yamlPropertiesFactoryBean.setResources(defaultApplicationYamlResource, userApplicationYamlResource)
        propertySources.setProperties(yamlPropertiesFactoryBean.`object` as Properties)

        return propertySources
    }
}