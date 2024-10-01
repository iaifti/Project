// Tashnim Khan Ishika

import java.util.Scanner;

public class StrHashFunc {
    
    public static int hashCodeForString(String s) {
        int hash = 0;
        int num = s.length();
        final int base = 31;


        for (int i = 0; i < num; i++) {
            hash += s.charAt(i) * Math.pow(base, num - i - 1);
        }
        
        return hash;
    }
    
    public static void testMain() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[5];
        
        
        System.out.println("Enter 5 strings:");
        for (int i = 0; i < 5; i++) {
            strings[i] = scanner.nextLine();
        }
        
        System.out.println("Hash codes for the input strings:");
        for (String str : strings) {
            int hashCode = hashCodeForString(str);
            System.out.println(str + ": " + hashCode);
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        testMain();
    }
}
