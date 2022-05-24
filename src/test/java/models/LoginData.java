package models;

import lombok.Data;

@Data
public class LoginData {
    private String identifier;
    private String password;
    private String firstName;
    private String lastName;

}
