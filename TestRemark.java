package com.sw.assessment4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;


class TestRemark {
	
    Prescription prescription = new Prescription();
    
    // Test #1: Check function when remark is exactly 6 words in length
    @Test
    public void testRemarkWithSixWords() {
        
        // Test data #1
        assertTrue(prescription.addRemark("Glasses fit perfectly and very comfortable.", "Client"));
        
        // Test data #2
        assertTrue(prescription.addRemark("Glasses fit perfectly and very comfortable.", "Optometrist"));
    }

    // Test #2: Check function when remark is exactly 20 words in length
    @Test
    public void testRemarkWithTwentyWords() {
        
        String remark = "I am really happy with the new glasses. The frame is lightweight, and the prescription is spot-on. Highly recommended!";
        // Test data #1
        assertTrue(prescription.addRemark(remark, "client"));
        // Test data #2
        assertTrue(prescription.addRemark(remark, "optometrist"));
    }
    
    // Test #3: Check function to test categories based on case insensitivity
    @Test
    public void testCaseInsensitiveCategory() {
        
    	// Test data #1
        assertTrue(prescription.addRemark("Glasses fit perfectly and very comfortable.", "client"));
        // Test data #2
        assertTrue(prescription.addRemark("Best place to get glasses for good rate", "OptOmetRiSt"));
    }
    
    // Test #4:
    @Test
    public void testInvalidCategories() {
        
    	// Test data #1
        assertFalse(prescription.addRemark("Glasses fit perfectly and very comfortable.", "Doctor"));
        // Test data #2
        assertFalse(prescription.addRemark("Best place to get glasses for good rate", "Receptionist"));
    }

    // Test #5:
    @Test
    public void testEmptyRemarks() {
        
    	// Test data #1
        assertFalse(prescription.addRemark("", "client"));
        // Test data #2
        assertFalse(prescription.addRemark("", "optometrist"));
    }

    // Test #6:
    @Test
    public void testLowercaseFirstWord() {
        
    	// Test data #1
        assertFalse(prescription.addRemark("glasses fit perfectly and very comfortable.", "client"));
        // Test data #2
        assertFalse(prescription.addRemark("best place to get glasses for good rate", "optometrist"));
    }
}
