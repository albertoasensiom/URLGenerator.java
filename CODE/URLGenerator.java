/* URLGenerator
 * @author Alberto Asensio
 * 05/01/2024
 * studentID: x23171782
 * URL Rules ID: UR2
 */

 public class URLGenerator {
    private String companyName;
    private StringBuffer finalURLBuffer;
    private String finalURLString;

    // Other variables used for computation
    private String protocol;
    private String companyNameLowerCase; //To check the number of consonants, vowels and also the Hostname part 1
    private int consonantsCount;
    private int vowelPairsCount;
    private StringBuffer hostnameBuffer;
    private String hostnameString;
    private String domain;
    private String path;

    


    public URLGenerator() {
        this.companyName = "";
        this.finalURLBuffer = new StringBuffer();
        // Initializing other variables
        this.companyNameLowerCase = "";
        this.protocol = "";
        this.hostnameBuffer = new StringBuffer();
        this.hostnameString = "";
        this.vowelPairsCount = 0;
        this.consonantsCount = 0;
        this.domain = "";
        this.path = "";
        this.finalURLString = "";
    }


    // Setter method intruduced in URLGeneratorApp
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public void compute() {
        
        companyNameLowerCase = companyName.toLowerCase(); //To check the number of consonants, vowels and also the Hostname part 1

        //Setting the PROTOCOL
        if (companyName.toLowerCase().contains("meta")) { //Here we use 2 methods: .toLowerCase and .contains
            protocol = "coap";
        } else {
            protocol = "ftp";
        }
    
        //CONSONANTS COUNTER (before the name of the company changes to the shortcuts Inc, Ltd or LLC)
        for(int f = 0; f < companyNameLowerCase.length(); f++){ //Here we use the companyNameLowerCase variable to check the consonants

            // Veryfying the consonants to set the counter
            if (companyNameLowerCase.charAt(f) == 'b' || companyNameLowerCase.charAt(f) == 'c' || companyNameLowerCase.charAt(f) == 'd' || companyNameLowerCase.charAt(f) == 'f' || companyNameLowerCase.charAt(f) == 'g' ||
            companyNameLowerCase.charAt(f) == 'h' || companyNameLowerCase.charAt(f) == 'j' || companyNameLowerCase.charAt(f) == 'k' || companyNameLowerCase.charAt(f) == 'l' || companyNameLowerCase.charAt(f) == 'm' ||
            companyNameLowerCase.charAt(f) == 'n' || companyNameLowerCase.charAt(f) == 'p' || companyNameLowerCase.charAt(f) == 'q' || companyNameLowerCase.charAt(f) == 'r' || companyNameLowerCase.charAt(f) == 's' ||
            companyNameLowerCase.charAt(f) == 't' || companyNameLowerCase.charAt(f) == 'v' || companyNameLowerCase.charAt(f) == 'w' || companyNameLowerCase.charAt(f) == 'x' || companyNameLowerCase.charAt(f) == 'y' ||
            companyNameLowerCase.charAt(f) == 'z') {
            consonantsCount = consonantsCount + 1; //Counter
             }
         }

        //VOWEL COUNTER (before the name of the company changes to the shortcuts Inc, Ltd or LLC)
        for (int g = 0; g < companyNameLowerCase.length() - 1; g++) {
            if ((companyNameLowerCase.charAt(g) == 'a' ||
                 companyNameLowerCase.charAt(g) == 'e' ||
                 companyNameLowerCase.charAt(g) == 'i' ||
                 companyNameLowerCase.charAt(g) == 'o' ||
                 companyNameLowerCase.charAt(g) == 'u') &&
                (companyNameLowerCase.charAt(g + 1) == 'a' ||
                 companyNameLowerCase.charAt(g + 1) == 'e' ||
                 companyNameLowerCase.charAt(g + 1) == 'i' ||
                 companyNameLowerCase.charAt(g + 1) == 'o' ||
                 companyNameLowerCase.charAt(g + 1) == 'u')) {
                
                vowelPairsCount++;
                
                // If a pair is found, the g increases automatically 1 more to avoid counting 3 letters together as an extra pair
                //Hard to understand, but it works
                g++;
                 
            }
        }
        
        // HOSTNAME part 1: Replacing 3 words with shortcuts
        if (companyNameLowerCase.contains("incorporated")) {
            companyName = companyNameLowerCase.replace("incorporated", "Inc");
        } 
        else if (companyNameLowerCase.contains("limited liability company")) {
            companyName = companyNameLowerCase.replace("limited liability company", "LLC");
        }
        else if (companyNameLowerCase.contains("limited")) {
            companyName = companyNameLowerCase.replace("limited", "Ltd");
        } 

        // HOSTNAME part 2: Replacing spaces for "_"
        for (int i = 0; i < companyName.length(); i++) {
            if (companyName.charAt(i) != ' ') {
                hostnameBuffer.append(companyName.charAt(i));
            } else {
                hostnameBuffer.append('_');
            }
        } 

        //Creating the String for the hostname (so we have a String instead of a StringBuffer)
        hostnameString = hostnameBuffer.toString();

        //HOSTNAME Part 3: Using the consonantCounter to find out the domain (.org or .edu)
        if (consonantsCount % 2 == 1){
            domain = ".org";
        }else{
            domain = ".edu";
        }

        //HOSTNAME Part 4: Using the vowerPairsCount to define the path
        if (vowelPairsCount == 0){
            path = "bio";
        }
        else if(vowelPairsCount == 1 || vowelPairsCount == 2 || vowelPairsCount == 3){
            path = "FAQ";
        }
        else{
            path = "Glossary";
        }

        //Appending all parts of the whole URL
        finalURLBuffer.append(protocol);
        finalURLBuffer.append("://");
        finalURLBuffer.append(hostnameString);
        finalURLBuffer.append(domain);
        finalURLBuffer.append("/");
        finalURLBuffer.append(path);

        //Creating the FINAL URL
        finalURLString = finalURLBuffer.toString();

    }

    // Getter method to return the generated URL
    public String getURL() {
        return finalURLString;    
    }


    /***********************QUESTION 2**************************************/

    //Declaring variables QUESTION 2
    int urlValidationNums;
    String[] urlValidation;
    boolean[] urlBoolean;
    
    //SETTER and INITIALIZE the arrays witht he given number
    public void setURLValidationNums(int urlValidationNums) {
            this.urlValidationNums = urlValidationNums;
            this.urlValidation = new String[urlValidationNums]; // Initialize the array with the given size
            this.urlBoolean = new boolean[urlValidationNums]; // Initialize the boolean array with the given size
            }

    //Setting the URLs inserted by the user into the String array
    public void setURLValidation(int index, String urlToValidate) {
        urlValidation[index] = urlToValidate; // Set individual URLs in the array
    }

    public void computeValidation() {
        // Validating each URL in the urlValidation array
        for (int i = 0; i < urlValidation.length; i++) {
            // Convert URL to lowercase for the comparison
            String currentURL = urlValidation[i].toLowerCase();
            // Check conditions for a valid Amazon URL
            boolean containsAmazon = currentURL.contains("amazon");
            boolean containsAWS = currentURL.contains("aws");
            boolean lengthInRange = currentURL.length() >= 5 && currentURL.length() <= 16;
            boolean containsValidCharacters = currentURL.matches("[a-z0-9_/\\.]+");
    
            // Validate the URL based on conditions and update urlBoolean array
            urlBoolean[i] = (containsAmazon || containsAWS) && lengthInRange && containsValidCharacters;
        }
    }
    

    public boolean[] getURLBoolean() {
        return urlBoolean;
    }


}   
