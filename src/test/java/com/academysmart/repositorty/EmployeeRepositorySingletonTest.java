package com.academysmart.repositorty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.academysmart.exception.ServletException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.academysmart.exception.IncorrectEmailException;
import com.academysmart.repository.EmployeeRepositorySingleton;

public class EmployeeRepositorySingletonTest {
 private static EmployeeRepositorySingleton ers1;
 private static EmployeeRepositorySingleton ers2;
	@BeforeClass
	public static void beforeClass()throws Exception {
		EmployeeRepositorySingleton.getRepository().addEmployee("Vasya",
			"Ivanov", "ivanov@mail.ru");
	}

	@Test
	public void testGetRepositoryReturnOneInstance() throws ServletException {
        ers1=EmployeeRepositorySingleton.getRepository();
        ers1.addEmployee("Vasya", "Ivanov", "ivanov@gmail.com");
        ers2=EmployeeRepositorySingleton.getRepository();
		    assertEquals("Test is not implemented", ers2, ers1);
	}
	
	
	@Test
            (expected=IncorrectEmailException.class)
	public void testAddEmployeeWithIncorrectEmail() throws ServletException  {
        EmployeeRepositorySingleton.getRepository().addEmployee("Ilya","Ivanov", "ivanov@mail.ru");
        Assert.fail("Test is not implemented");
	}

}
