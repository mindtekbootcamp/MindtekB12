package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingPartialUpdateRequest {
    private String firstname;
    private String lastname;
    private String additionalneeds;
}
