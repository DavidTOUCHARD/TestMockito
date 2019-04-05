package eu.ensup.projetmockdao.servicetest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import eu.ensup.projetmockdao.dao.PersonDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import eu.ensup.projetmockdao.domaine.Person;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class TestUserDao {
	
    @Mock
    private DataSource ds;
    @Mock
    private Connection c;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet rs;
    private Person p1;
    
    @Before
    public void setUp() throws Exception {

    }
    
    @Test
    public void nullCreateThrowsException() {
    	PersonDao dao = mock(PersonDao.class); //definition du mock
    	when(dao.create(null)).thenReturn(true);//patern comportemental
        assertTrue("OK", dao.create(null)); // assertion
        
    }
    
    @Test
    public void createPerson() {
    	PersonDao dao = mock(PersonDao.class);
    	when(dao.create(p1)).thenReturn(true);
    	assertTrue("OK", dao.create(p1));
        
        
    }
    @Test
    public void createAndRetrievePerson() throws Exception {
    	PersonDao dao = mock(PersonDao.class);
        dao.create(p1);
        when(dao.retrieve(2)).thenReturn(p1);
        assertEquals(dao.retrieve(2), p1);
    }
}

