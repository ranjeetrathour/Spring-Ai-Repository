package com.ranjeet.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {

    private final ChatClient chatModel;

    public OllamaService(ChatClient.Builder chatModel) {
        this.chatModel = chatModel.build();
    }

    /**
     * Sends a message to Ollama and returns the generated response text.
     */
    public String ask(String message) {
        return chatModel.prompt(message).call().content();
//        return response.getResults().stream().findAny().orElse(null).toString();
    }
}