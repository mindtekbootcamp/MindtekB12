package pojo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverResponse {

    private String uuid;
    private Integer id;
    private List<Object> schedule;
    private String full_name;
    private Boolean is_staff;
    private String status;
    private String created_at;
    private String updated_at;
    private String driver_local_identifier;
    private List<ContactResponse> contacts_phone;
    private List<ContactResponse> contacts_email;
    private List<ContactResponse> contacts_skype;
    private List<ContactResponse> contacts_viber;
    private List<ContactResponse> contacts_other;

}
