package com.sw.assessment4;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;



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
    private ArrayList<String> postRemarks = new ArrayList<>();
    
    // Getters and Setters methods
    
    public int getPrescID() {
        return prescID;
    }

    public void setPrescID(int prescID) {
        this.prescID = prescID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSphere() {
        return sphere;
    }

    public void setSphere(float sphere) {
        this.sphere = sphere;
    }

    public float getAxis() {
        return axis;
    }

    public void setAxis(float axis) {
        this.axis = axis;
    }

    public float getCylinder() {
        return cylinder;
    }

    public void setCylinder(float cylinder) {
        this.cylinder = cylinder;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

    public String getOptometrist() {
        return optometrist;
    }

    public void setOptometrist(String optometrist) {
        this.optometrist = optometrist;
    }

    public boolean addPrescription() {
        // TODO Add the prescription's information to a TXT file
        // If the prescription meets the given conditions,
        // the information should be added to a TXT file (e.g., presc.txt), and the function should return true.
        // If the prescription's information does not meet the given conditions,
        // the information should not be added to the TXT file, and the function should return false.
    	
    	// Condition to check first name and last name length is between 4 to 15 characters
        if (firstName.length() < 4 || firstName.length() > 15 || 
            lastName.length() < 4 || lastName.length() > 15) {
            return false;
        }

        // Condition to check if address length has minimum 20 characters
        if (address.length() < 20) {
            return false;
        }

        // Check if sphere, cylinder and axis values are between (-20.00 to +20.00), (-4.00 to +4.00), (0 to 180) respectively
        if (sphere < -20.00 || sphere > 20.00 || 
            cylinder < -4.00 || cylinder > 4.00 || 
            axis < 0 || axis > 180) {
            return false;
        }

        // Condition to convert examination date format to DD/MM/YY 
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String formattedDate = dateFormat.format(examinationDate);

        // Condition to check if name of optometrist is between 8 and 25 characters
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            return false;
        }
        
        // If all conditions are true then write the prescription details to the file
        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            writer.write("Prescription ID: " + prescID + "\n");
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Sphere: " + sphere + "\n");
            writer.write("Cylinder: " + cylinder + "\n");
            writer.write("Axis: " + axis + "\n");
            writer.write("Eye Exam Date: " + formattedDate + "\n");
            writer.write("Optometrist: " + optometrist + "\n");
            writer.write("------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    	
        return true;
    }

    public boolean addRemark(String remarkText, String category) {
        // Condition to validate number of words in remark are between 6 to 20 characters and starts with a capital character
        String[] words = remarkText.trim().split("\\s+");
        if (words.length < 6 || words.length > 20 || !Character.isUpperCase(words[0].charAt(0))) {
            return false;
        }

        // Condition to check if remark belongs to either "client" or "optometrist" and have a maximum of 2 remarks
        if ((!category.equalsIgnoreCase("client") && !category.equalsIgnoreCase("optometrist")) || postRemarks.size() >= 2) {
            return false;
        }

        // Add the remark and category if all conditions are met
        postRemarks.add(remarkText);

        // If all conditions are true then write the remark details to the file
        try (FileWriter writer = new FileWriter("review.txt", true)) {
            writer.write("Prescription ID: " + prescID + "\n");
            writer.write("Remark: " + remarkText + "\n");
            writer.write("Category: " + category + "\n");
            writer.write("------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
