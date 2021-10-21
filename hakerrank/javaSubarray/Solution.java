import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
            Scanner sc = new Scanner(br.readLine());
            
            int N = sc.nextInt();
            
            sc = new Scanner(br.readLine());
            
            int[] arr = new int[N]; 
            
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i; j < N; j++) {
                    int sum = 0;
                    for(int k = i; k <= j; k++) {
                        sum += arr[k];
                        
                    }
                    if (sum < 0) {
                        count ++;
                    }
                    
                                       
                }
                
            }        
            System.out.println(count);
            
        } catch(IOException e) {
            e.printStackTrace();
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
        
    }
}