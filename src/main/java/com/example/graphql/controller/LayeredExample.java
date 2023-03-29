package com.example.graphql.controller;

import lombok.Builder;

public record LayeredExample(
        String id,
        String description,
        SchemaExample schemaExample
) {
    @Builder
    public LayeredExample {}
}
