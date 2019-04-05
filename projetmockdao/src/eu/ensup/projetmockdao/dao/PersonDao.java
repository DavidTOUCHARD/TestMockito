package eu.ensup.projetmockdao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;


import eu.ensup.projetmockdao.domaine.Person;
public class PersonDao {
    private DataSource ds;
    public PersonDao(DataSource ds) {
        this.ds = ds;
    }
    public boolean create(Person person) {
    
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("INSERT INTO person (id, first_name, last_name) values (?, ?, ?)");
            stmt.setInt(1, person.getId());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getLastName());
            stmt.executeUpdate();
            c.close();
            return true;
        } catch (SQLException e) {
			e.printStackTrace();
        }
		return false;
    }
    public Person retrieve(int id) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("SELECT id, first_name, last_name FROM person WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.first()) {
                return null;
            }
            Person p = new Person();
            p.setId(rs.getInt(1));
            p.setFirstName(rs.getString(2));
            p.setLastName(rs.getString(3));
            c.close();
            return p;
        }catch (SQLException e) {
			e.printStackTrace();
			return null;
        }
    }
}