# Assignment-
Coditation



import java.util.Scanner;
import java.io.*;
class Main 
{
   static int s, g;
   static int[][] cells;
   public static void main(String[] args){
       try{
           Scanner sc = new Scanner(System.in);
           /*
           * size of matrix
           */
           s = sc.nextInt();
          
           /*
           * total generations to be displayed
           */
           g = sc.nextInt();
          
           /*
           * s*s matrix stores status of cells
           */
           cells = new int[s][s];
          
           /*
           * Getting cells input
           * as a matrix of S*S
           *           
           * S is the max size
           */
           for(int i = 0; i < s; i++){
               for(int j = 0; j < s; j++){
                   cells[i][j] = sc.nextInt();
               }
           }
          
           sc.close();
          
           /*
           * Matrix to calculate next generation of cells
           */
           int[][] nextGenCells = new int[s][s];
          
           /*
           *Iterating to get g numbers of next generations
           *
           */
           for(int i = 0; i < g; i++){
               for(int j = 0; j < s; j++){
                   for(int k = 0; k < s; k++){
                       if(cells[j][k] == 0){
                           /*
                           * Checking rule 4
                           */
                           if(getLiveNeighboursCount(j, k) == 3){
                               nextGenCells[j][k] = 1;
                           }
                           else{
                               nextGenCells[j][k] = 0;
                           }
                       }
                       else{
                           /*
                           * checking rule 1
                           */
                           if(getLiveNeighboursCount(j, k) < 2){
                               nextGenCells[j][k] = 0;
                           }
                           /*
                           * Checking rule 3
                           */
                           else if(getLiveNeighboursCount(j, k) > 3){
                               nextGenCells[j][k] = 0;
                           }
                           else{
                               /*
                               * Rule 2
                               */
                               nextGenCells[j][k] = 1;
                           }
                       }
                   }
               }
              
               /*
               * Display next generation cells
               *
               */
               System.out.println("Generation +" + (i + 1));
               for(int j = 0; j < s; j++){
                   for(int k = 0; k < s; k++){
                       System.out.print(cells[j][k] = nextGenCells[j][k]);
                       if(k + 1 < s){
                           System.out.print("\t");
                       }
                   }
                   System.out.println();
               }
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
   }
  
   /*
   * function to find count of neighboring live cells
   *
   */
   public static int getLiveNeighboursCount(int r, int c){
       int cnt = 0;
       if(r + 1 < s && cells[r + 1][c] == 1)
           cnt++;
       if(r - 1 > 0 && cells[r - 1][c] == 1)
           cnt++;
       if(c + 1 < s && cells[r][c + 1] == 1)
           cnt++;
       if(c - 1 > 0 && cells[r][c - 1] == 1)
           cnt++;
      
       if(r + 1 < s && c + 1 < s && cells[r + 1][c + 1] == 1)
           cnt++;
       if(r - 1 > 0 && c + 1 < s && cells[r - 1][c + 1] == 1)
           cnt++;
       if(c - 1 > 0 && r + 1 < s && cells[r + 1][c - 1] == 1)
           cnt++;
       if(c - 1 > 0 && r - 1 > 0 && cells[r - 1][c - 1] == 1)
           cnt++;
      
       return cnt;
   }
  
   /*
   *
   * Function to find the count of neighboring dead cells
   */
   public static int getDeadNeighboursCount(int r, int c){
       int cnt = 0;
       if(r + 1 < s && cells[r + 1][c] == 0)
           cnt++;
       if(r - 1 > 0 && cells[r - 1][c] == 0)
           cnt++;
       if(c + 1 < s && cells[r][c + 1] == 0)
           cnt++;
       if(c - 1 > 0 && cells[r][c - 1] == 0)
           cnt++;
      
       if(r + 1 < s && c + 1 < s && cells[r + 1][c + 1] == 0)
           cnt++;
       if(r - 1 > 0 && c + 1 < s && cells[r - 1][c + 1] == 0)
           cnt++;
       if(c - 1 > 0 && r + 1 < s && cells[r + 1][c - 1] == 0)
           cnt++;
       if(c - 1 > 0 && r - 1 > 0 && cells[r - 1][c - 1] == 0)
           cnt++;
      
       return cnt;
   }
}
