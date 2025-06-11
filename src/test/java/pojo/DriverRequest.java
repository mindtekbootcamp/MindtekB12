package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DriverRequest {

    private String full_name;
    private String logbook_email;
    private String logbook_password;
    private Boolean is_staff;
    private Boolean is_local;
    private Boolean twic;
    private String driving_license_exp;
    private String medical_certification_exp;
    private List<Contact> contacts_phone;
    private List<Contact> contacts_email;
    private List<Contact> contacts_skype;
    private List<Contact> contacts_viber;
    private List<Contact> contacts_other;

}
