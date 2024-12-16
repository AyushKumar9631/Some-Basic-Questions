import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Choose either X or O");
        char[][] matrix = new char[3][3];
        int row;
        int column;
        boolean victory= false;

        char ch1= in.next().charAt(0);
        char ch2='$';
        if(ch1=='X'){
            ch2='O';
        }
        else if(ch1=='O'){
            ch2='X';
        }
        else {
            System.out.println("Wrong Input");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            System.out.println("Enter row and column");
            row = in.nextInt();
            column = in.nextInt();
            if( row>2 || row<0 || column>2 || column<0){
                System.out.println("invalid space selected");
                i--;
                System.out.println("Please select appropriate space place");
                continue;
            }
            if(matrix[row][column]=='X' || matrix[row][column]=='O' ){
                System.out.println("place already taken");
                i--;
                display(matrix);
                System.out.println("Please select another place");
                continue;
            }
            if (i % 2 == 1) matrix[row][column] = ch1;
            else matrix[row][column] = ch2;
            display(matrix);
            if (i >= 5) victory = check(matrix);
            if(victory) break;
        }
        if(!victory) System.out.println("Draw");


    }

    public static boolean check (char[][] matrix){
        for(int i=0; i<3; i++){
            if(matrix[i][0]=='X' && matrix[i][1]=='X' && matrix[i][2]=='X'){
                System.out.println("X won");
                return true;
            }
            if(matrix[0][i]=='X' && matrix[1][i]=='X' && matrix[2][i]=='X'){
                System.out.println("X won");
                return true;
            }
            if(matrix[i][0]=='O' && matrix[i][1]=='O' && matrix[i][2]=='O'){
                System.out.println("O won");
                return true;
            }
            if(matrix[0][i]=='O' && matrix[1][i]=='O' && matrix[2][i]=='O'){
                System.out.println("O won");
                return true;
            }
        }
        if(matrix[0][0]=='X' && matrix[1][1]=='X' && matrix[2][2]=='X'){
            System.out.println("X won");
            return true;
        }
        if(matrix[0][2]=='X' && matrix[1][1]=='X' && matrix[2][0]=='X'){
            System.out.println("X won");
            return true;
        }
        if(matrix[0][0]=='O' && matrix[1][1]=='O' && matrix[2][2]=='O'){
            System.out.println("O won");
            return true;
        }
        if(matrix[0][2]=='O' && matrix[1][1]=='O' && matrix[2][0]=='O'){
            System.out.println("O won");
            return true;
        }
        return false;
    }

    public static void display(char[][] matrix){
        for (char[] chars : matrix) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
