package jsonParser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private String menuId;
    private String menuName;
    private String rootCategoryId;
    private String createdAt;
    private String updatedAt;
}
