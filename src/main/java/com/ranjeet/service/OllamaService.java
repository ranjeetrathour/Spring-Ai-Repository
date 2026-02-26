package com.ranjeet.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {

    private final ChatModel chatModel;

    public OllamaService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    /**
     * Sends a message to Ollama and returns the generated response text.
     */
    public String ask(String message) {

        // Build the prompt
        Prompt prompt = new Prompt(
                message,
                OllamaChatOptions.builder()
                        .model(OllamaModel.LLAMA3) // Make sure model exists
                        .temperature(0.4)
                        .build()
        );

        // Call the model
        ChatResponse response = chatModel.call(prompt);

        // Get the first generated text from the response
        return response.getResults().stream().findAny().orElse(null).toString();
    }
}