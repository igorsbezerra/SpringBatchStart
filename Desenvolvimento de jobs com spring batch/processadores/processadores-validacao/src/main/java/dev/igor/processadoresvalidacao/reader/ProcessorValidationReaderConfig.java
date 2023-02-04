package dev.igor.processadoresvalidacao.reader;

import dev.igor.processadoresvalidacao.domain.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ProcessorValidationReaderConfig {
    @StepScope
    @Bean
    public FlatFileItemReader<Client> processorValidationReader(
            @Value("#{jobParameters['file']}") Resource file
            ) {
        return new FlatFileItemReaderBuilder<Client>()
                .name("processorValidationReader")
                .resource(file)
                .delimited()
                .names("name", "age", "email")
                .targetType(Client.class)
                .build();
    }
}
