package ru.stqa.pft.addressbook.tests;

import com.sun.corba.se.pept.transport.ContactInfo;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;


import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnection () {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=&serverTimezone=UTC");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id, lastname, firstname from addressbook");
            Contacts contacts= new Contacts();
            while (rs.next()) {
                contacts.add(new ContractInfo()
                        .withId(rs.getInt("id"))
                        .withFirstname(rs.getString("lastname"))
                        .withLastname(rs.getString("firstname")));
            }
            rs.close();
            st.close();
            conn.close();

            System.out.println(contacts);
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}