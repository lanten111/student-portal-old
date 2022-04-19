package co.za.dto;

import co.za.enums.DEPARTMENT;
import co.za.enums.GENDER;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class LecturerDto implements Serializable {
    private String idNumber;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private LocalDateTime dateCreated;
    private boolean deleted = false;
    private LocalDateTime dateUpdated;
    private String password;
    private GENDER gender;
    private LocalDateTime birthday;
    private AddressDto address;
    private Long id;
    private DEPARTMENT department;

}
