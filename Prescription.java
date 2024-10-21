package com.sw.assessment4;

import java.util.ArrayList;
import java.util.Date;
import org.junit.*;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    private String[] remarkTypes = {"Client", "Optometrist"};
    private ArrayList<String> postRemarks = new ArrayList<>();

    public boolean addPrescription() {
        // TODO Add the prescription's information to a TXT file
        // If the prescription meets the given conditions,
        // the information should be added to a TXT file (e.g., presc.txt), and the function should return true.
        // If the prescription's information does not meet the given conditions,
        // the information should not be added to the TXT file, and the function should return false.
    	
    	
        return true;
    }

    public boolean addRemark() {
        // TODO Add the prescription's remark to a TXT file
        // If the remark meets the given conditions,
        // the information should be added to a TXT file (e.g., remark.txt), and the function should return true.
        // If the remark does not meet the given conditions,
        // the information should not be added to the TXT file, and the function should return false.
        return true;
    }
}
