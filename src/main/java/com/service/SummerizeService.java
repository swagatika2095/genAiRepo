package com.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service

public class SummerizeService {

    private ChatClient chatClient;

    private List<Message> history = new ArrayList<>();

    public Logger logger = Logger.getLogger(SummerizeService.class.getName());

    private final String SYSTEM_PROMPT = """
            You are a customer-support executive for our
                        Food ordering app named Tomato.
                       \s
                        Your job is to identify the customer's main
                        problem and urgency. Answer them related to there query.
                       \s
                        Use professional language. If user has an issue,
                        use words like I understand your frustration,
                        I am really sorry for your trouble etc.
                       \s
                        Do not answer any other question which is not
                        related to Ordering Food query, refund query,
                        order tracking status query or company policy query.""";

    public SummerizeService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String summerize(String ticket){
        String output = chatClient.prompt().user("Summerize the support ticket in 1 line:\n\n "+ ticket)
                .call().content();
        return output;
    }

    public String chat(String message) {

        logger.info(message);
        history.add(new UserMessage(message));
        String output = chatClient.prompt().system(SYSTEM_PROMPT).messages(history)
                .call().content();
        logger.info(output);
        history.add(new AssistantMessage(message));
        return output;
    }
}
