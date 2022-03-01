package com.kairosds.cursospb2.httpclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class HttpClientApplication {

    @Autowired
    private WebClient webClient;

    @Value("${http-client.take-my-books-uri}")
    private String takeMyBooksUri;

    public static void main(String[] args) {
        SpringApplication.run(HttpClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner execute() {

        return (args) -> {

            final var response = webClient.put()
                    .uri(uriBuilder -> uriBuilder
                            .path(this.takeMyBooksUri)
                            .queryParam("code", "BIBLIOTECA0001")
                            .build())
                    .exchangeToMono((clientResponse ->
                            clientResponse.bodyToMono(new ParameterizedTypeReference<TakeMyBooksClientResponse>() {
                            })))
                    .block();

            System.out.println(response);

        };

    }
}
