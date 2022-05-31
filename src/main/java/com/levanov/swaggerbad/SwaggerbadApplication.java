package com.levanov.swaggerbad;

import com.levanov.swaggerbad.entity.Book;
import com.levanov.swaggerbad.repository.BookRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class SwaggerbadApplication implements CommandLineRunner {


    private final BookRepository bookRepository;

    public SwaggerbadApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SwaggerbadApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("Skazki", "Pushkin");
        Book book2 = new Book("Basni", "Krylov");

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
    //  http://localhost:8090/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
    @Configuration
    public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(
                            new Info()
                                    .title("Car-service Api")
                                    .version("1.0.0")
                    );
        }

    }

}
