package Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {

    private  String Ism;
    private String Familya;
    private  String Email;
    private String Password;
    private String Tel_raqam;

    public User(String email, String password) {
        Email = email;
        Password = password;
    }

}
