package com.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service

public class SummerizeService {

    private ChatClient chatClient;

    public SummerizeService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String summerize(String ticket){
        String output = chatClient.prompt().user("Summerize the support ticket in 1 line:\n\n "+ ticket)
                .call().content();
        return output;
    }
}
