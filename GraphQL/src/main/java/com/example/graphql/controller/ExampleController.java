package com.example.graphql.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class ExampleController {

    @QueryMapping
    public Mono<Example> example() {
        return Mono.just(Example.builder()
                .id("exampleId")
                .description("exampleDescription")
                .exampleMessage("exampleMessage")
                .build());
    }
}
