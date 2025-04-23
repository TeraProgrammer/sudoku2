import java.util.*;
import java.io.*;

public class SudokuBoard {
   private int[][] board;
   
   public SudokuBoard(String filename) {
      board = new int[9][9];
      try {
         Scanner file = new Scanner(new File(filename));
         
         for(int r = 0; r < 9; r++) {
            String line = file.nextLine();
            for(int c = 0; c < 9; c++) {
               Scanner lineScan = new Scanner(line);
               char num = lineScan.next().charAt(c);
               if(num == '.') {
                  board[r][c] = 0;
               }else {
                  board[r][c] = num;
               }
            }
         }
         
      } catch(FileNotFoundException e) {
         System.out.println("Cannot load: " + filename);
      } catch(InputMismatchException e) {
         System.out.println(filename + " does not meet format expectations.");
      }
   }
   
   public boolean isValid() {
      Set<Integer> validValues = new HashSet();
      for (int i = 0; i < board.length + 1; i++) {
         validValues.add(i);
      }
      return (checkInvalidChar(validValues) && checkCol(validValues)) && (miniSquare(validValues) && checkRow(validValues));
   }
   
   private boolean checkInvalidChar(Set<Integer> valid) {
      for (int r = 0; r < board.length; r++) {
         for (int c = 0; c < board[r].length; c++) {
            if (!valid.contains(board[r][c])) {
               return false;
            }
         }
      }
      
      return true;
   }
   
   private boolean checkRow(Set<Integer> valid) {
      for (int r = 0; r < board.length; r++) {
         for (int c = 0; c < board[r].length; c++) {
            if (board[r][c] != 0 && ) {
               
            }
         }
      }
      
      return true;
   }
   
   private boolean checkCol(Set<Integer> valid) {
      
   }
   
   private boolean checkSquares(Set<Integer> valid) {
   
   }
   
   private int[][] miniSquare(int spot) {
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out (at least)
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }
   
   public String toString() {
      String build = " -----------------\n";
      for(int r = 0; r < board.length; r++) {
         build += "|\t";
         for(int c = 0; c < board[0].length; c++) {
            build += board[r][c] + "|\t";
         }
         build += "|\n";
      }
      build += " -----------------\n";
      return build;   
   }
}

/*
# PROGRAM OUTPUT

  ----jGRASP exec: java SudokuEngine
  -----------------
 |	50|	0|	0|	49|	0|	53|	0|	0|	51|	|
 |	0|	53|	52|	0|	0|	0|	55|	49|	0|	|
 |	0|	49|	0|	50|	0|	51|	0|	56|	0|	|
 |	54|	0|	50|	56|	0|	55|	51|	0|	52|	|
 |	0|	0|	0|	0|	0|	0|	0|	0|	0|	|
 |	49|	0|	53|	51|	0|	57|	56|	0|	54|	|
 |	0|	50|	0|	55|	0|	49|	0|	54|	0|	|
 |	0|	56|	49|	0|	0|	0|	50|	52|	0|	|
 |	55|	0|	0|	52|	0|	50|	0|	0|	49|	|
  -----------------
 
 
  ----jGRASP: Operation complete.

*/