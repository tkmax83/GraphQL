package com.example.graphql.controller;

import lombok.Builder;

public record SchemaExample(
        String id,
        String description
) {
    @Builder
    public SchemaExample {}
}
