package com.academysmart.repositorty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.academysmart.database.Oracle;
import com.academysmart.exception.ServletException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.academysmart.exception.IncorrectEmailException;
import com.academysmart.repository.EmployeeRepositorySingleton;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeRepositorySingletonTest {
private static EmployeeRepositorySingleton ers1;
private static EmployeeRepositorySingleton ers2;
private static Connection err1;

	@BeforeClass
	public static void beforeClass()throws Exception {
		EmployeeRepositorySingleton.getRepository().addEmployee("Vasya","Ivanov", "ivanov@mail.ru");
	}

	@Test
	public void testGetRepositoryReturnOneInstance() throws ServletException, SQLException {
        ers1=EmployeeRepositorySingleton.getRepository();
        ers1.addEmployee("Vasya", "Ivanov", "ivanov@gmail.com");
        ers2=EmployeeRepositorySingleton.getRepository();
        ers2.addEmployee("Vasya", "Ivanov", "ivanov@gmail.com");
		    assertEquals("Test is not implemented", ers2, ers1);
	}
	
	
	@Test
         (expected=IncorrectEmailException.class)
public void testAddEmployeeWithIncorrectEmail() throws ServletException, SQLException {
    EmployeeRepositorySingleton.getRepository().addEmployee("Ilya","Ivanov", "ivanov@mail.ru");
    Assert.fail("Test is not implemented");
}
   @Test
    public void getNotNullDBConnection() {

        err1=Oracle.getDBConnection();

        assertNotNull("Test is not implemented", err1 );
    }
}
