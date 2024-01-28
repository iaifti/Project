import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class consVowlCount {
    public static void main(String[] args) {

        try{
        File myFile  = new File("test.txt");
        Scanner myText  = new Scanner(myFile);
            int vowelCount = 0;
            int consCount  = 0;

        while(myText.hasNextLine() ){
            String info = myText.nextLine();
            vowelCount += countVowel(info);
            consCount += countCons(info);
            }
        
            System.out.println("Consonants: " +consCount);
            System.out.println("Vowels: " +vowelCount);
        myText.close();
       }
       catch (FileNotFoundException e) {
        System.out.println("ErrORRR!!!!!!!!");
        e.printStackTrace();
       }
    }
       private static int countCons(String info ){
        int cCount = 0;
        for(char c: info.toCharArray()){
            if(Character.isLetter(c) && !isVowel(Character.toLowerCase(c))){
                cCount++;
            }
        }
        return cCount;
       }

       private static int countVowel(String info ){
        int vCount = 0;
        for(char c: info.toCharArray()){
            if(Character.isLetter(c) && isVowel(Character.toLowerCase(c))){
                vCount++;
            }
        }
        return vCount;
       }

       private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
       }
    
    }

