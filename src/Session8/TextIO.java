package Session8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class TextIO {
    public static void main(String[] args) {
        int ranking;boolean flag=false;
        Scanner in=new Scanner(System.in);
        
        System.out.println("Welcome to baby ranking file base\n");
       
        System.out.println("Please enter a year between 2001 and 2010 to search in:");
        int year=in.nextInt();
        
        while (year<2001 || year>2010) {            
                System.out.println("Please enter a year between 2001 and 2010 to search in:");
                year=in.nextInt();   
        }
        
        
        System.out.println("Enter The gender: M:Male,F:Female: ");
        String Gender=in.next();
        while (!((Gender.equalsIgnoreCase("M") || Gender.equalsIgnoreCase("F")))) {            
               System.out.println("Enter The gender: M:Male,F:Female: ");
               Gender=in.next(); 
        }
        
        System.out.println("Enter The name: ");
        String Name=in.next();
        in.close();
        
        
        File file=new File("files/Babynamesranking" + year + ".txt");
        try {
               Scanner File_in=new Scanner(file);
               while (File_in.hasNext()) {                
                ranking=File_in.nextInt();
                if(Gender.equalsIgnoreCase("M")){
                    if(File_in.next().equalsIgnoreCase(Name)){
                         System.out.println(Name + " is ranked in year " + year + " " + File_in.nextInt() + " Name");
                         break;}
                    }
                //Checking Female
                else{
                    File_in.next();File_in.next();
                    if(File_in.next().equalsIgnoreCase(Name)){
                         System.out.println(Name + " is ranked in year " + year + " " + File_in.nextInt() + " Name");
                         break;}
                }
                 File_in.nextLine();
                 flag=true;
            }
               if(flag==true)
                     System.out.println("The name " +Name + " is not ranked in the given year ");   
        File_in.close();
        
        } catch (FileNotFoundException e) {
              System.out.println(Logger.getLogger(TextIO.class.getName()));
              System.out.println(e);
        }
    }
    
}
