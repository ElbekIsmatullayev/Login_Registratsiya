package Auth;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

public class Baza {
    String url="jdbc:postgresql://localhost:5432/Dibi_Conaction";
    String username="postgres";
    String password="1234";

    public  boolean Register_funk(User user) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url,username,password);
        String query="insert into malumot(ism,familya,email,password,tel_raqam) values(?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,user.getIsm());
        preparedStatement.setString(2,user.getFamilya());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getPassword());
        preparedStatement.setString(5,user.getTel_raqam());
        preparedStatement.executeUpdate();
        return true;
    }
public  boolean login(User user) throws SQLException, ClassNotFoundException {
    Class.forName("org.postgresql.Driver");
    Connection connection= DriverManager.getConnection(url,username,password);
    Statement statement=connection.createStatement();
    String query="SELECT * from malumot where password='"+ user.getPassword()+"'  and email='"+user.getEmail()+"'";
    ResultSet resultSet=statement.executeQuery(query);
    if(resultSet.next()){
        return  true;
    }
    return  false;
}

}
