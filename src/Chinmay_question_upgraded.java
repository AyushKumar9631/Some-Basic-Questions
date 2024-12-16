/* Added improved version of chinmay question with now taking a sentence instead of word as input
   and has a dynamic output box size
   eg: Input: An apple a day keeps doctor away.
   output:
             *
             *   *
             *   *
             *   *   *       *
             *   *   *       *   *   *           *
     *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
     A   n       a   p   l   e   d   y   k   s   o   c   t   r   w   .
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Chinmay_question_upgraded {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter a word");
        String word= in.nextLine();
        ArrayList<Character> ch= new ArrayList<>();
        ArrayList<Integer> f= new ArrayList<>();
        modifier(word,ch,f);
        int column= ch.size();
        int row= row_finder(f)+1;
        char[][] result= finalizer(ch,f,row,column);

        for(int i=0; i<row; i++){
            for(int j=0; j<column-1; j++){
                System.out.print(result[i][j] + "   ");
            }
            System.out.println();
        }

    }

    static void modifier(String word, ArrayList<Character> ch, ArrayList<Integer> f){
        ch.add('$');
        f.add(0);
        int l= word.length();
        for(int i=0; i<l; i++){
            char cha= word.charAt(i);
            int c=0;
            int fr=0;
            for (Character character : ch) {
                if (cha == character) {
                    c = 1;
                    break;
                }
            }
            if(c==0){
                ch.add(cha);
                for(int j=0; j<l; j++){
                    if(cha==word.charAt(j)){
                        fr++;
                    }
                }
                f.add(fr);
            }
        }

    }

    static int row_finder(ArrayList<Integer> f){
        int max=f.getFirst();
        for(int i=1; i<f.size();i++){
            if(f.get(i)>max){
                max= f.get(i);
            }
        }
        return max;
    }

    static char[][] finalizer(ArrayList<Character> ch, ArrayList<Integer> f, int row, int column){
        char[][] result= new char[row][column];
        for(int i=1; i<column; i++){
            result[row-1][i-1]= ch.get(i);
            int ftemp= f.get(i);
            while(ftemp>0){
                result[row-1-ftemp][i-1]= '*';
                ftemp--;
            }
        }
        return result;

    }
}

