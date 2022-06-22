package jsonParser.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonParser.entity.National_menu;

import java.io.File;
import java.io.IOException;

public class Parser {

    public static National_menu jsonParsing() throws IOException {
        File json = new File("src/main/resources/National_Menu.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, National_menu.class);
    }
}
