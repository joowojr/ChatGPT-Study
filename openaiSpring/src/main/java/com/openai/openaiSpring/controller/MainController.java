package com.openai.openaiSpring.controller;

import com.openai.openaiSpring.Model.ChatCompletionRequest;
import com.openai.openaiSpring.Model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Value("${openai.model}")
    public String openaiModel;

    @Value("${openai.url}")
    String openaiUrl;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/hitOpenAiApi")
    public String getOpenaiResponse(@RequestBody String prompt){
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest(openaiModel,prompt);
        ChatCompletionResponse response = restTemplate.postForObject(openaiUrl,chatCompletionRequest,
                ChatCompletionResponse.class);
        return response.getChoices().get(0).getMessage().getContent();
    }
}
