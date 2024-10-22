package com.sw.assessment4;


import static org.junit.Assert.assertFalse;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestPrescription {
	
    Prescription prescription = new Prescription();

    // Test #1: Check function with short first name
	@Test
	public void testFirstNameFunction() {
		
		// Test data #1		
    	prescription.setFirstName("Moh");
        prescription.setLastName("Salah");
        prescription.setAddress("64 Princess St, Victoria");
        prescription.setSphere(-2.7f);
        prescription.setCylinder(-1.28f);
        prescription.setAxis(90);
        prescription.setOptometrist("Dr. Helen");

        assertFalse(prescription.addPrescription());  
        
        // Test data #2
        prescription.setFirstName("Tom");
        prescription.setLastName("Cruise");
        prescription.setAddress("64 Princess St, Victoria");
        prescription.setSphere(-2.7f);
        prescription.setCylinder(-1.28f);
        prescription.setAxis(90);
        prescription.setOptometrist("Dr. Sandra");

        assertFalse(prescription.addPrescription());  
	}
	
	// Test #2: Check function with invalid sphere value and valid cylinder value
	@Test
    public void testInvalidSphereFunction() {
        Prescription prescription = new Prescription();

        // Test data #1
        prescription.setFirstName("Mohammed");
        prescription.setLastName("Salah");
        prescription.setAddress("64 Princess St, Victoria");
        prescription.setSphere(-20.01f);  
        prescription.setCylinder(-1.28f);  
        prescription.setAxis(90);
        prescription.setOptometrist("Dr. Helen");

        assertFalse(prescription.addPrescription());  

        // Test data #2
        prescription.setFirstName("Tom");
        prescription.setLastName("Cruise");
        prescription.setAddress("64 Princess St, Victoria");
        prescription.setSphere(20.01f);  
        prescription.setCylinder(-1.28f);  
        prescription.setAxis(90);
        prescription.setOptometrist("Dr. Sandra");

        assertFalse(prescription.addPrescription());  
    }
	
	// Test Case #3: Check function with short addresses
    @Test
    public void testShortAddressesFunction() {
        Prescription prescription = new Prescription();

        // Test data #1        
        prescription.setFirstName("Mohammed");
        prescription.setLastName("Salah");
        prescription.setAddress("64 Princes St, VIC");  
        prescription.setSphere(-2.7f);
        prescription.setCylinder(-1.28f);
        prescription.setAxis(90);
        prescription.setOptometrist("Dr. Helen");

        assertFalse(prescription.addPrescription()); 

        // Test data #2
        prescription.setFirstName("Mohammed");
        prescription.setLastName("Salah");
        prescription.setAddress("27 Hill St, AUS");  
        prescription.setSphere(-2.7f);
        prescription.setCylinder(-1.28f);
        prescription.setAxis(90);
        prescription.setOptometrist("Dr. Helen");

        assertFalse(prescription.addPrescription());  
    }

    // Test Case #4: Check function with first name or last name containing special characters
    @Test
    public void testNamesWithSpecialCharacters() {
        Prescription prescription = new Prescription();
        
        //Test data #1
        prescription.setFirstName("Moh@mmed");
        prescription.setLastName("S@l@h");
        prescription.setAddress("64 Princess St, VIC");
        prescription.setSphere(-2.7f);
        prescription.setCylinder(-1.28f);
        prescription.setAxis(90);
        prescription.setOptometrist("Dr. Helen");

        assertFalse(prescription.addPrescription());  
        
        //Test data #2
        prescription.setFirstName("#@rry");
        prescription.setLastName("Magulre");
        prescription.setAddress("27 Hill St, AUS");
        prescription.setSphere(-2.7f);
        prescription.setCylinder(-1.28f);
        prescription.setAxis(90);
        prescription.setOptometrist("Dr. Helen");

        assertFalse(prescription.addPrescription());  
    }
    
    @Test
    public void testOptometristNameNotProvided() {
        Prescription prescription = new Prescription();

        //Test data #1
        prescription.setFirstName("Mohammed");
        prescription.setLastName("Salah");
        prescription.setAddress("64 Princess St, Watsonia, 3087, Australia");
        prescription.setSphere(-2.7f);
        prescription.setCylinder(-1.28f);
        prescription.setAxis(90);
        prescription.setOptometrist("");  
        
        // Set examinationDate for test data #1
        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            prescription.setExaminationDate(dateFormat.parse("15/10/24"));  
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertFalse(prescription.addPrescription());  

        //Test data #2
        prescription.setFirstName("Harry");
        prescription.setLastName("Maguire");
        prescription.setAddress("64 Princess St, Watsonia, 3087, Australia");
        prescription.setSphere(-2.7f);
        prescription.setCylinder(-1.28f);
        prescription.setAxis(90);
        prescription.setOptometrist("");  
        
        // Set examinationDate for test data #2
        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            prescription.setExaminationDate(dateFormat.parse("15/10/24"));  // Example date
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertFalse(prescription.addPrescription());  
    }

}
