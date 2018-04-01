package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicrosericeGetwapZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrosericeGetwapZuulApplication.class, args);
	}
}
