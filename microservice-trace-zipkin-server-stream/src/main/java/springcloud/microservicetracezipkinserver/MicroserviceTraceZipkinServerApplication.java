package springcloud.microservicetracezipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class MicroserviceTraceZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTraceZipkinServerApplication.class, args);
	}
}
