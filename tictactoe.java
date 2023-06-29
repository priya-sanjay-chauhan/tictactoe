import java.util.*;


public class tictactoe {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        char[][] board=new char[3][3];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
               board[row][col]=' ';
            }
        }

        char player='X';
        boolean isGameOver=false;

        while(!isGameOver){
             printBoard(board);
            System.out.print("Player "+player+ " enter: ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            
            if(board[row][col]==' '){

                board[row][col]=player;
                isGameOver=haveWon(board,player);

                if(isGameOver){
                    System.out.println("Player "+player+ " has won: ");
                }else{

                    if(player=='X'){
                        player='O';
                    }else{
                        player='X';
                    }
                    
                }
            }else{
                System.out.println("Invalid Move.");
            }

        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player){
       //  for rows
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }

        //  for cols
        for(int col=0;col<board[0].length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }

        //  for diagonals
        for(int row=0;row<board.length;row++){
            if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
                return true;
            }

            if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
                return true;
            }
        }
     return false;
    }


    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for(int row=0;row<board.length;row++){
            System.out.print("| ");
            for(int col=0;col<board[0].length;col++){
               System.out.print(board[row][col]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
