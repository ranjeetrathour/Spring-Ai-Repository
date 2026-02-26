package com.ranjeet.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfig {

    @Bean
    public Prompt prompt(String prompt){
        return new Prompt(prompt,
                OllamaChatOptions.builder()
                        .model(OllamaModel.LLAMA3)
                        .build());
    }
}
