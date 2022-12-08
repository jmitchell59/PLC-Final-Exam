import java.util.*;
import java.io.*;

public class Compiler{
public Compiler(){}

    public String convertFile(File file) throws Exception{
        // Declaring a string to store contents of the file and later return to the caller method.
        String content = "";

        // The object is created to scan the file.
        Scanner fileScanner = new Scanner(file);

        // Reading the file until fileScanner can scan something from the file.
        while(fileScanner.hasNext()){
            // Appending the next line from the file into the string (content) . 
            content = content + " " + fileScanner.nextLine() ;
        }
        // Closing the scanner object
        fileScanner.close();
        // returning the string
        return content;
    }
}

public class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        // Taking input of the file name from the user.
        System.out.print("Enter the name of file: ");
        String fileName = sc.next();
        // Creating a file object to be passed on the method of the class Compiler.
        File file = new File(fileName);

        // Instantiating the object of Compiler class.
        Compiler object = new Compiler();

        // Invoking the method of Compiler class.
        String input = object.convertFile(file);

        // Printing the file content using the string obtained.
        System.out.println("File Content is as follow: " + input);

        // Closing the scanner object. 
        sc.close();
    }
}