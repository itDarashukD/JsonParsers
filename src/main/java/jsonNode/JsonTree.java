package jsonNode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;


public class JsonTree {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {

        try {
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/Node.json")); //коневой узел (весь json)

            // получить поле id по имени
            long id = rootNode.path("id").asLong();
            System.out.println("id = " + id);

            // получить узел по имени
            JsonNode nameNode = rootNode.path("name"); //т.к. name это объект и сответственно Node
            System.out.println(nameNode);
            if (!nameNode.isMissingNode()) {                //if name is exist
                String s = nameNode.path("first").asText();
                String s1 = nameNode.path("last").asText();
                System.out.println(s + "\n" + s1);
            }

            JsonNode contact = rootNode.path("contact");
            if (contact.isArray()) {                        //check if contact is array
                for (JsonNode element : contact
                ) {
                    String s = element.path("type").asText();
                    String s1 = element.path("ref").asText();
                    System.out.println("type" + s + "\n" + "ref" + s1);
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
