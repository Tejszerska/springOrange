package pl.sda.springrestapp1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc // pozwala korzystac z biblioteki zewnetrznej -tu swagger (w dependencies)
@SpringBootApplication
public class SpringRestApp1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApp1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
