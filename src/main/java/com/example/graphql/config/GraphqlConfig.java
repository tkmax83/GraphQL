package com.example.graphql.config;

import io.micrometer.tracing.propagation.Propagator;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.observation.PropagationWebGraphQlInterceptor;

@Configuration
public class GraphqlConfig {

    @Bean
    public OpenTelemetry openTelemetry(){
        return AutoConfiguredOpenTelemetrySdk.builder().build().getOpenTelemetrySdk();
    }

    @Bean
    public PropagationWebGraphQlInterceptor propagationWebGraphQlInterceptor(Propagator propagator) {
        return new PropagationWebGraphQlInterceptor(propagator);
    }
}
