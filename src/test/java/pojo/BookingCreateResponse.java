package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingCreateResponse {

    private Integer bookingid;
    private BookingRequest booking;

}
