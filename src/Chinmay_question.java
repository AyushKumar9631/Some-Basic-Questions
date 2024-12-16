// A question on pattern formation by my friend Mr. Chinmay Chandra
/* take a word. Count the number of characters and show in a particular format
    eg Input: Apple
    Output:[ , *,  ,  ,]
           [*, *, *, *,]
           [A, p, l, e,]
 */

import java.util.Arrays;
import java.util.Scanner;

public class Chinmay_question {
    public static void main(String[] args) {
        System.out.println("Enter a word");
        Scanner in= new Scanner(System.in);
        char[][] result = new char[10][10];
        String word= in.next();
        int l= word.length();
        int c1= 0;
        for( int i=0; i<l; i++){
            int c= 0;
            int c2= 0;
            char ch = word.charAt(i);

            // getting value check c
            for(int j=0; j<10; j++){
                if (ch == result[9][j]) c++;
            }

            if(c==0){

                result[9][c1]= ch;

                // getting number of characters c2
                for(int m=0; m<l; m++){
                    if(ch == word.charAt(m))
                        c2++;
                }

                while(c2>0){
                    result[9-c2][c1] = '*';
                    c2--;
                }
                c1++;
            }
        }
        for(int i=0; i<10; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}