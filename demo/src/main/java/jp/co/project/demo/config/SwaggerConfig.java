/**
 *
 */
package jp.co.project.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import jp.co.project.demo.emuns.ApiVersionEnum;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket generateDocketVeresion1() {
		return generateDocket(ApiVersionEnum.V1);
	}

	@Bean
	public Docket generateDocketVeresion2() {
		return generateDocket(ApiVersionEnum.V2);
	}

	private Docket generateDocket(ApiVersionEnum apiVersion) {
		// org.springframework.boot.actuate
		return new Docket(DocumentationType.SWAGGER_2) //
				.groupName(apiVersion.getVersion()) //
				.select() //
				.apis(generateSelector(apiVersion)) //
				.paths(PathSelectors.any()) //
				.build().apiInfo(apiInfo(apiVersion) //
				);
	}

	private Predicate<RequestHandler> generateSelector(ApiVersionEnum apiVersion) {
		return Predicates.or( //
				RequestHandlerSelectors.basePackage("org.springframework.boot.actuate"), //
				RequestHandlerSelectors.basePackage("jp.co.project.demo.web.external.api." + apiVersion.getVersion()) //
		);
	}

	private ApiInfo apiInfo(ApiVersionEnum apiVersion) {
		return new ApiInfoBuilder().title("Pluto API").version(apiVersion.getVersion()).build();
	}
}
