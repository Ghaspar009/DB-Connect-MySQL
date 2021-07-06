package DatabasesProjects.First;

import java.io.Console;
import java.sql.*;

public class DBConnectConsolVersion {
    public static void main(String[] args) {
        try{

            String username, password;
            Console console = System.console();

            username = console.readLine("Username: ");
            char[] pass = console.readPassword("Password: ");
            password = new String(pass);

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:**********", username, password);
            Statement statement = connection.createStatement();

            String order;
            order = console.readLine();

            ResultSet resultSet = statement.executeQuery(order);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnNumber =  resultSetMetaData.getColumnCount();
            while(resultSet.next()) {
                String line = "";
                for (int i = 1; i <= columnNumber; i++) {
                    line += resultSet.getString(i) + " ";
                }
                System.out.println(line);
            }

            connection.close();

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
