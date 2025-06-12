package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactResponse {

    private Integer id;
    private String uuid;
    private String name;
    private String value;
    private String type;

}
