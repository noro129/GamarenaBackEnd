package com.gamarena.GameArenaBackend.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;


@Service
public class WorduessService {


    public String generate() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource words_file = new ClassPathResource("/static/words.json");
        List<String> wordsList = mapper.readValue(words_file.getInputStream(), new TypeReference<List<String>>(){});
        Random random = new Random();
        return wordsList.get(random.nextInt(wordsList.size()));
    }
}
