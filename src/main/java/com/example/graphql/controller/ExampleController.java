package com.example.graphql.controller;

import graphql.GraphQLContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Controller
public class ExampleController {

    @QueryMapping
    public Mono<Example> example(GraphQLContext graphQLContext) {
        log.info("example testing traceId and spanId");
        return Mono.just(Example.builder()
                .id("exampleId")
                .description("exampleDescription")
                .exampleMessage("exampleMessage")
                .build());
    }

    @SchemaMapping(typeName = "Example", field="schemaExample")
    public Mono<SchemaExample> schemaExample(Example example) {
        log.info("schemaExample testing traceId and spanId");
        return Mono.just(SchemaExample.builder()
                .id("schemaExampleId")
                .description("schemaExampleDescription")
                .build());
    }

    @SchemaMapping(typeName = "Example", field="layeredExample")
    public Mono<LayeredExample> layeredExample(Example example) {
        log.info("layeredExample testing traceId and spanId");
        return Mono.just(LayeredExample.builder()
                .id("layeredExampleId")
                .description("layeredExampleDescription")
                .build());
    }

    @SchemaMapping(typeName = "LayeredExample", field="schemaExample")
    public Mono<SchemaExample> nestedSchemaExample(LayeredExample layeredExample) {
        log.info("nestedSchemaExample testing traceId and spanId");
        return Mono.just(SchemaExample.builder()
                .id("nestedSchemaExampleId")
                .description("nestedSchemaExampleDescription")
                .build());
    }

    @BatchMapping(typeName = "Example", field="batchExample")
    public Flux<SchemaExample> batchExample(List<Example> exampleList) {
        log.info("batchExample testing traceId and spanId");
        return Flux.just(
                SchemaExample.builder()
                        .id("batchSchemaExampleId")
                        .description("batchSchemaExampleDescription")
                        .build()
        );
    }
}
