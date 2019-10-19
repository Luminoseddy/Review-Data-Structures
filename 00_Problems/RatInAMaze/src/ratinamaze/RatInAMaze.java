package ratinamaze;

/* Java program to solve Rat in a Maze problem using backtracking */

public class RatInAMaze { 

	/* Size of the maze */
	static int N; 

	/* A utility function to print solution matrix sol[N][N] */
	void printSolution(int sol[][]) {
            for (int i = 0; i < N; i++) { 
                for (int j = 0; j < N; j++)                 
                    System.out.print(" " + sol[i][j] + " "); /* sol holds the path traversed so far by the rat. */      
                System.out.println(""); 
            } 
	} 
        int i =1;
	/** BASE CASE: A utility function to check if x, y is valid index for N*N maze
         * if (x, y outside maze) return false 
         *
         * Rec 1: (4, 0, 0) -> true 
         * Rec 2: (4, 1, 0) -> true */
	boolean isSafe(int maze[][], int x, int y) {
            
            boolean check = (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
            
            System.out.println("SAFE?: " + (i) +" "+ check+ " index exist.");
            i++;
            return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1); 
	} 
        
	/** This function solves the Maze problem using Backtracking. It mainly uses solveMazeUtil() 
	 * to solve the problem. It returns false if no path is possible, otherwise return true and 
	 * prints the path in the form of 1s. Please note that there may be more than one solutions, this 
	 * function prints one of the feasible solutions. 
         *
         * Passing in a 4x4 array
         */
	boolean solveMaze(int maze[][]) {
            
            int sol[][] = new int[N][N]; 
            
            /* Passing in ([][], 0, 0, [][] */
            if (solveMazeUtil(maze, 0, 0, sol) == false) {    
                System.out.println("Solution doesn't exist"); 
                return false; 
            } 
            //printSolution(sol); 
            return true; 
	} 
	
        /** A recursive utility function to solve Maze problem 
         * Maze represents the blocked and unblocked, x, y represent the rows/columns of the maze. 
         *
         * Begin (maze[4][4], 0, 0, sol[4][4]);
         * 
         * (maze[4][4], 1, 0, sol[4][4]);
         * (maze[4][4], 0, 1, sol[4][4]);
         * (maze[4][4], 1, 1, sol[4][4]);
         * (maze[4][4], 2, 1, sol[4][4]);
         * (maze[4][4], 1, 2, sol[4][4]);
         * (maze[4][4], 1, 3, sol[4][4]);
         * (maze[4][4], 2, 3, sol[4][4]);
         * (maze[4][4], 3, 3, sol[4][4]);
         * 
         * 
         */
        
	boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {					
            // is 0 == 4-1 && 0 == 4-1)? False.
            // is 1 == 4-1 && 0 == 4-1)? False.
            // is 0 == 4-1 && 1 == 4-1)? False.
            // is 1 == 4-1 && 1 == 4-1)? False.
            // is 2 == 4-1 && 1 == 4-1)? False.
            // is 1 == 4-1 && 2 == 4-1)? False.
            // is 1 == 4-1 && 3 == 4-1)? False.
            // is 2 == 4-1 && 3 == 4-1)? False.
            // is 3 == 4-1 && 3 == 4-1)? TRUE. so backtrack to its previous if statements. 
            if (x == N - 1 && y == N - 1) {   
                sol[x][y] = 1;     
                return true; 
            } 
           
            // (0,0) safe spot? Yes, mark 1. 
            // (1,0) safe spot? No? So go back to previous iteration (w/ previpous values) and now ([][], 0, 0+1, [][]) -> (0,1)
            // (0,1) Safe spot? Yes, mark 1. 
            // (1,1) Safe spot? Yes, mark 1.
            // (2,1) Safe spot? No? So go back to previous iteration (w/ previpous values) and now ([][], 1, 1+1, [][]) -> (1,2)
            // (1,2) Safe spot? Yes, mark 1
            // (2,2) Safe spot? No? So go back to previous iteration (w/ previpous values) and now ([][], 1, 2+1, [][]) -> (1,3)
            // (1,3) Safe spot? Yes, mark 1
            // (2,3) Safe spot? Yes, mark 1.
            if (isSafe(maze, x, y) == true) { 
   
                sol[x][y] = 1;

                // ([][], 0+1, 0, [][]) RECURSIVELY RETURN ([][], 1, 0, [][]) false
                // ([][], 0+1, 1, [][]) RECURSIVELY RETURN ([][], 1, 1, [][])
                // ([][], 1+1, 1, [][]) RECURSIVELY RETURN ([][], 2, 1, [][]) false
                // ([][], 1+1, 2, [][]) RECURSIVELY RETURN ([][], 2, 2, [][]) false
                // ([][], 1+1, 3, [][]) RECURSIVELY RETURN ([][], 2, 3, [][])
                // ([][], 2+1, 3, [][]) RECURSIVELY RETURN ([][], 3, 3, [][])
                if (solveMazeUtil(maze, x + 1, y, sol)) { return true; }
                    
                // ([][], 0, 0+1, [][]) RECURSIVELY RETURN ([][], 0, 1, [][])
                // ([][], 1, 1+1, [][]) RECURSIVELY RETURN ([][], 1, 2, [][])
                // ([][], 1, 3+1, [][]) RECURSIVELY RETURN ([][], 1, 4, [][]) false
                
                if (solveMazeUtil(maze, x, y + 1, sol)) { return true; }
                    
                /* IF no path is found, return false and back track.  */
                sol[x][y] = 0; 
                return false; 		
            } 
            /* If location is out of maze, return false, and backtrack. */
            return false; 
	} 

	public static void main(String args[]) {
            RatInAMaze rat = new RatInAMaze(); 

            /* Represents block and unblocked positions. */
            int maze[][] = { { 1, 0, 0, 0 }, 
                             { 1, 1, 0, 0 }, 
                             { 0, 1, 0, 0 }, 
                             { 0, 1, 1, 1 } }; 

            N = maze.length; 
            rat.solveMaze(maze); 
	} 
} 
// This code is contributed by Abhishek Shankhadhar 

