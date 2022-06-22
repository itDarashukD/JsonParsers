package jsonNode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonIsArray {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        try {

            JsonNode arrayRootNode = objectMapper.readTree(new File("src/main/resources/NodeArray.json"));
            System.out.println(arrayRootNode);

            //if Json File is array, then i have to iterate through it.
            // and in the loop simply get each field

            for (JsonNode element : arrayRootNode
            ) {

                // получить поле id по имени
                long id = element.path("id").asLong();
                System.out.println("id = " + id);

                // получить узел по имени
                JsonNode nameNode = element.path("name"); //т.к. name это объект и сответственно Node
                System.out.println(nameNode);
                if (!nameNode.isMissingNode()) {                //if name is exist
                    String s = nameNode.path("first").asText();
                    String s1 = nameNode.path("last").asText();
                    System.out.println(s + "\n" + s1);
                }

                JsonNode contact = element.path("contact");
                if (contact.isArray()) {                        //check if contact is array
                    for (JsonNode contactElement : contact
                    ) {
                        String s = contactElement.path("type").asText();
                        String s1 = contactElement.path("ref").asText();
                        System.out.println("type" + s + "\n" + "ref" + s1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
