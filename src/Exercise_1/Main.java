package Exercise_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int month, day, year;
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Month: ");
            month = Integer.parseInt(br.readLine());
            
            System.out.print("Day: ");
            day = Integer.parseInt(br.readLine());
            
            System.out.print("Year: ");
            year = Integer.parseInt(br.readLine());
            
            Date date = new Date(month, day, year);
            
            System.out.println("Next date: " + date.nextDate().toString());
            
        } catch (IOException | InvalidDateException | ArgumentException ex) {
            System.out.println("An exception occurted: ");
            System.out.println(ex.getMessage());
        }
    }
}