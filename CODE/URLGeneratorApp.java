/* URLGeneratorApp
 * @author Alberto Asensio
 * 05/01/2024
 * studentID: x23171782
 * Approach ID: MCNA1
 */


import javax.swing.JOptionPane;

public class URLGeneratorApp {
    public static void main(String[] args) {

        //Declare variables
        String companyName;
        int numURLs;

        // Ask the user how many URLs they want to generate
        numURLs = Integer.parseInt(JOptionPane.showInputDialog(null, "How many URLs do you want to generate?"));

        // Create an array to store generated URLs. The capacity of the array will be the input of the user
        String[] generatedURLs = new String[numURLs];

        

        // Ask for company namepas and generate URLs
        for (int i = 0; i < numURLs; i++) {
            companyName = JOptionPane.showInputDialog(null, "Enter company name for URL " + (i + 1) + ":");

            //Create the object. This allow to use the methods of the instantiable class
            URLGenerator urlGen = new URLGenerator();

            //Using the setter to pass the information to the instantiable class
            urlGen.setCompanyName(companyName);

            //Using the "compute" method to do the calculations. This is better explained in the instantiable class
            urlGen.compute();

            //Store the generated URL into the array
            generatedURLs[i] = urlGen.getURL();
        }

        // Display generated URLs using JOptionPane
        StringBuilder urlsMessage = new StringBuilder("Generated URLs:\n");
        for (int i = 0; i < numURLs; i++) {
            urlsMessage.append("URL ").append(i + 1).append(": ").append(generatedURLs[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, urlsMessage.toString());


        /************************QUESTION 2**********************/

        //Declare new variables
        int urlValidationNums;
        String urlToValidate;
        String status;

        //INPUT: Ask the user how many URLs they want to validate
        urlValidationNums = Integer.parseInt(JOptionPane.showInputDialog(null, "How many URLs do you want to validate?"));

        //OBJECT: I can create a new object to use separately in this question 2
        URLGenerator urlValidation = new URLGenerator();

        //SETTER the num so the APP will ask that amount of validations to the user
        urlValidation.setURLValidationNums(urlValidationNums);

        //Initialize the Array to store the computed results in this class
        boolean[] urlBooleanResults = new boolean[urlValidationNums];

        // Prompt the user X times for the URLs to validate and store them in the URLGenerator object
        for (int i = 0; i < urlValidationNums; i++) {
            urlToValidate = JOptionPane.showInputDialog(null, "Enter URL " + (i + 1) + " to validate:");
            urlValidation.setURLValidation(i, urlToValidate);
        }

        //COMPUTE the validations
        urlValidation.computeValidation();

        // Store the results of validation
        for (int i = 0; i < urlValidationNums; i++) {
            urlBooleanResults[i] = urlValidation.getURLBoolean()[i];
        }

            
        
    
        // Create a StringBuffer to store the results
        StringBuffer message = new StringBuffer("URLs Validation:\n");

        // Check each URL and append a message to the StringBuffer
        for (int j = 0; j < urlBooleanResults.length; j++) {
            int urlIndex = j + 1;
            if (urlBooleanResults[j]) {
                status = "correct";
            }else{
                status = "incorrect";
            }
            message.append("URL ").append(urlIndex).append(": ").append(status).append("\n");
        }

        // Show the message by converting the StringBuffer to String using JOptionPane
        JOptionPane.showMessageDialog(null, message.toString());

        
        
    }
}
