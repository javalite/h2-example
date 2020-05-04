package activejdbc.examples.simple;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.connection_config.DBConfiguration;

public class Main {

    public static void main(String[] args) {

        Base.open("org.h2.Driver", "jdbc:h2:./test", "sa", "");

        Base.exec("DROP TABLE IF EXISTS users;");
        Base.exec("CREATE TABLE USERS( id  int(11) NOT NULL auto_increment PRIMARY KEY,     username varchar(255) NOT NULL, password varchar(255));");

        User e = User.create("username", "John", "password", "Doe");
        e.saveIt();


        User.findAll().dump();
        Base.close();
    }
}
