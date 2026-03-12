package com.ranjeet.controller;

import com.ranjeet.service.OllamaService;
import org.springframework.ai.chat.metadata.ChatResponseMetadata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final OllamaService aiService;

    public ChatController(OllamaService aiService) {

        this.aiService = aiService;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String message) {
        return aiService.ask(message);
    }
}