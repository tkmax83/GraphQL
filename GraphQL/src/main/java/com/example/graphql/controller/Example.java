package com.example.graphql.controller;

import lombok.Builder;

public record Example(
        String id,
        String description,
        String exampleMessage
) {
    @Builder
    public Example {}
}
