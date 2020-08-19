import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        Stack<Integer> hstack = new Stack<Integer>();
        Stack<Integer> pstack = new Stack<Integer>();
        int max= 0;
        int height=0;
        int position=0;
        int i =0;
        for(i =0 ; i<h.length ;i++){

            if(hstack.isEmpty()|| h[i]>hstack.peek()){
                hstack.push(h[i]);
                pstack.push(i);
            }
            else if(h[i]< hstack.peek()){
                while(!hstack.isEmpty() && h[i]<hstack.peek()){
                    height = hstack.pop();
                    position = pstack.pop();

                    int area = height *(i - position);

                    max = Math.max(max, area);

                }

                
                    pstack.push(position);
                    hstack.push(h[i]);
                
            }
        }

        while(!hstack.isEmpty()){
            height = hstack.pop();
            position = pstack.pop();
            int area = height *(i - position);
            max = Math.max(max, area);
        }
        return max;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
