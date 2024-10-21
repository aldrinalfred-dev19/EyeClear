package com.sw.assessment4;

public class Main {
	public static void main(String args[]) {
		Prescription p1 = new Prescription();
		
        boolean isPrescriptionAdded = p1.addPrescription();
        System.out.println("Prescription added: " + isPrescriptionAdded);
        
        boolean isRemarkAdded = p1.addRemark();
        System.out.println("Remark added: " + isRemarkAdded);
		
	}
}
