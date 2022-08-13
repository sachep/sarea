import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class pderby {
    public static void main(String args[]){
        final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
        final String CONNECTION="jdbc:derby:AccountDatabase;create=true";
        /*
        try{
            Class.forName(DRIVER) .newInstance();
        }
        catch (InstantiationException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        */
        try{
            Connection connection=DriverManager.getConnection(CONNECTION);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
