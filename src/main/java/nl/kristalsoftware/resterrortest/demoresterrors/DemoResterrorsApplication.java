package nl.kristalsoftware.resterrortest.demoresterrors;

import nl.kristalsoftware.resterrortest.demoresterrors.customer.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@SpringBootApplication
public class DemoResterrorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoResterrorsApplication.class, args);
	}

	@Bean
	ResourceProcessor<Resource<Customer>> customerResourceProcessor() {
		return new ResourceProcessor<Resource<Customer>>() {
			@Override
			public Resource<Customer> process(Resource<Customer> customerResource) {
				UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentContextPath().build();
				String uri = uriComponents.toUriString();
				customerResource.add(new Link(uri, "self"));
				return customerResource;
			}
		};
	}

}
