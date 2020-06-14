package leandromangieri.java8exercises3.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fruit {
    private String name;
    private Integer size;
}
