package esprit.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayApplication.class, args);
	}
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route(
				"candidat",
				r->r.path("/candidats/**")
						.uri("lb://CandidatMS4TWIN1")

		).route(
						"job",
						r->r.path("/jobs/**")
								.uri("lb://JobMS4TWIN1")

				)
				.build();
	}
}
