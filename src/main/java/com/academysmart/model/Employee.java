package com.academysmart.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
	//TODO implement model for employee
private String fname;
private String lname;
private String email;
private int idEmployee;
 private static AtomicInteger count= new AtomicInteger(0);
public Employee (){
    count.decrementAndGet();
            this.idEmployee=count.get();
}

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdEmployee() {
        return idEmployee;
    }
}
