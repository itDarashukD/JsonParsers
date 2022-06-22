package jsonNode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class AddToJson {

    /* создавать, обновлять и удалять узлы JSON,
    чтобы изменить узел JSON, нам нужно преобразовать его в ObjectNode  line 23*/

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {

        try {
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/AddValueToJson.json"));
            System.out.println(rootNode);

            ObjectNode objectNode = (ObjectNode) rootNode;

            String resultOriginal = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);

            // 1. Обновляем id до 1000
            objectNode.put("id", 1000l);
            System.out.println(rootNode);

            // 2. Если отчество пусто, обновить до SomeOne
            JsonNode nameNode = rootNode.path("name");
            ObjectNode objectNameNode = (ObjectNode) nameNode;
            if ("".equals(objectNameNode.path("middleName").asText())) {
                objectNameNode.put("middleName", "SomeOne");
            }
            System.out.println(rootNode);

            // 3. Создать новое поле в nameNode
            ((ObjectNode) nameNode).put("newField", "someNewField");
            System.out.println(rootNode);

            // 5. Создаем новый ObjectNode и добавляем в root
            ObjectNode additionNode = objectMapper.createObjectNode();
            additionNode.put("name", "dzmitry");
            additionNode.put("year", "36");
            ((ObjectNode) rootNode).set("newAddedNode", additionNode);   //добавляем в root

            System.out.println(rootNode);

            // 6. Создаем новый ArrayNode и добавляем в root
            ArrayNode arrayNode = objectMapper.createArrayNode();

            ObjectNode objectNodeToArrayNode1 = objectMapper.createObjectNode();
            objectNodeToArrayNode1.put("name", "newArrayName");
            objectNodeToArrayNode1.put("age", 37);

            ObjectNode objectNodeToArrayNode2 = objectMapper.createObjectNode();
            objectNodeToArrayNode2.put("name2", "newArrayName2");
            objectNodeToArrayNode2.put("age2", 37);

            arrayNode.add(objectNodeToArrayNode1);
            arrayNode.add(objectNodeToArrayNode2);
            ((ObjectNode) rootNode).set("neaArrayNode", arrayNode);

            System.out.println(rootNode);

            // 7. Добавляем новый узел в ArrayNode
            ObjectNode emailNode = objectMapper.createObjectNode();

            emailNode.put("type", "email");
            emailNode.put("ref", "abc@mail.com");

            JsonNode contact = rootNode.path("contact");
            ((ArrayNode) contact).add(emailNode);

            System.out.println(rootNode);

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }


    }


}
