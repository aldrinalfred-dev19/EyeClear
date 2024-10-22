package com.sw.assessment4;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String args[]) {
		Prescription prescription = new Prescription();
		
		prescription.setPrescID(1000);
        prescription.setFirstName("Mohammed");
        prescription.setLastName("Salah");
        prescription.setAddress("64 Princess St, Watsonia, 3087, Australia");
        prescription.setSphere(-2.50f);
        prescription.setCylinder(-1.25f);
        prescription.setAxis(90);
        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            prescription.setExaminationDate(dateFormat.parse("15/10/24")); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        prescription.setOptometrist("Dr. Sandra Hopkins"); 

        // Call the addPrescription method and check the result
        boolean result = prescription.addPrescription();

        // Print whether the prescription was successfully added
        if (result) {
            System.out.println("Prescription added successfully!");
        } else {
            System.out.println("Failed to add prescription");
        }
        
        // Remark #1 success scenario
        boolean remarkResult = prescription.addRemark("Dr Sandra provided me all details with clarity.", "client");
        if (remarkResult) {
            System.out.println("First remark added successfully!");
        } else {
            System.out.println("Failed to add the first remark.");
        }

        // Remark #2 success scenario
        remarkResult = prescription.addRemark("The place was clean and tidy.", "optometrist");
        if (remarkResult) {
            System.out.println("Second remark added successfully!");
        } else {
            System.out.println("Failed to add the second remark.");
        }

        // Remark #2 scenario fails as limit reached
        remarkResult = prescription.addRemark("his is an additional client remark.", "client");
        if (remarkResult) {
            System.out.println("Third remark added successfully!");
        } else {
            System.out.println("Third remark added failed as only 2 remarks can be added in total");
        }
    }
        
}
