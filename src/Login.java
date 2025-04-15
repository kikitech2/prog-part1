import java.util.Scanner;
import java.util.regex.Pattern;

public class login{}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String Firstname;
        String Lastname;
        String Username;
        String Password;
        String CellNumber;

//Allows a user to enter their first name and last name for registration.//
        System.out.print("Enter your first name");
        Firstname = scanner.nextLine();
        System.out.print("Enter your last name");
        Lastname = scanner.nextLine();

        // This method is to ensure the user logs in correctly.//
        boolean isValidUserName;
        do {
            System.out.println("Enter your Username. Please ensure that your username contains an underscore and is no more than 5 characters in length.):");
            Username = scanner.nextLine();
            isValidUserName = AccountCreation.checkUsername (Username);
            System.out.println("Username valid: " + isValidUserName);
        } while (!isValidUserName);
        System.out.println("Username successfully captured: " + Username);

        // Password input verify logins.//
        boolean isPasswordValid;
        do {
            System.out.println("Enter your Password. It must contain at least 8 characters, capital letter, number, special character):");
            Password = scanner.nextLine();
            isPasswordValid = AccountCreation.checkPasswordComplexity(Password);
            System.out.println("Password valid: " + isPasswordValid);
        } while (!isPasswordValid);
        System.out.println("Password successfully captured: " + Password);

        boolean isCellNumberValid;
        do {
            System.out.println("Enter your South African cellphone number. Please ensure that it starts with +27 and is followed by 9 digits.):");
            CellNumber = scanner.nextLine();
            isCellNumberValid = AccountCreation.checkCellPhoneNumber(CellNumber);
            System.out.println("Cellphone number valid: " + isCellNumberValid);
        } while (!isCellNumberValid);


    }
public static class AccountCreation {

    // Check if username contains underscore and is no more than 5 characters
    private static boolean checkUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username captured successfully.");
            return true;
        } else {
            System.out.println("Username is incorrect formatted. Please ensure Username contains an underscore and no more than 5 characters");
            return false;
        }
    }

    // Check password complexity: at least 8 characters, 1 uppercase letter, and 1 digit
    public static boolean checkPasswordComplexity(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        if (Pattern.matches(passwordRegex, password)) {
            System.out.println("Password captured successfully.");
            return true;
        } else {
            System.out.println("Password is not correctly formatted. Please ensure that it contains at least 8 characters, capital letter, number, special character):");
            return false;
        }
    }

    // Check if cellphone number starts with +27 and is 12 digits long
    private static boolean checkCellPhoneNumber(String cellNumber) {
        String cellphoneRegex = "^\\+27\\d{9}$";
        if (Pattern.matches(cellphoneRegex, cellNumber)) {
            System.out.println("Cellphone number successfully added.");
            return true;
        } else {
            System.out.println("Cellphone number is incorrectly formatted or does not contain an international code.");
            return false;
        }
    }
}




