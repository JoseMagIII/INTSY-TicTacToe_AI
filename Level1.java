import java.util.*;

public class Level1 
{	
	public static int Move(char playerChar, char AIChar, String[][] grid)
	{	
		int move;
		
		move = finish(AIChar, grid);
		//System.out.println("MOVE = " + move);
		
		if(move != -1)
			return move;
		
		move = finish(playerChar, grid);
		//System.out.println("MOVE = " + move);
		
		if(move != -1)
			return move;
		
		move = simpleMove(AIChar, grid);
		//System.out.println("MOVE = " + move);
		
		
		if(move != -1)
			return move;
		
		move = -1;
		
		do
		{
			move++;
		}while(grid[move / 3][move % 3] != " ");
		
		return move + 1;
	}
	
	public static int simpleMove(char cpiece, String[][] grid)
	{
		String piece = Character.toString(cpiece);
		
		for(int i = 0; i < 3; i++)
		{
			
			if(grid[i][0].equals(" ") && grid[i][1].equals(" ") && grid[i][2].equals(piece))
				return ((3 * i) + 0 + 1);
			
			if(grid[i][0].equals(piece) && grid[i][1].equals(" ") && grid[i][2].equals(" "))
				return ((3 * i) + 1 + 1);
			
			if(grid[i][0].equals(" ") && grid[i][1].equals(piece) && grid[i][2].equals(" "))
				return ((3 * i) + 0 + 1);
		}
		
		
		for(int i = 0; i < 3; i++)
		{
			
			if(grid[0][i].equals(" ") && grid[1][i].equals(" ") && grid[2][i].equals(piece))
				return (i + 1);
			
			if(grid[0][i].equals(piece) && grid[1][i].equals(" ") && grid[2][i].equals(" "))
				return (3 + i + 1);
			
			if(grid[0][i].equals(" ") && grid[1][i].equals(piece) && grid[2][i].equals(" "))
				return (i + 1);
		}
		
		
		
		if(grid[0][0].equals(" ") && grid[1][1].equals(" ") && grid[2][2].equals(piece))
			return 1;
		
		if(grid[0][0].equals(piece) && grid[1][1].equals(" ") && grid[2][2].equals(" "))
			return 4;
			
		if(grid[0][0].equals(" ") && grid[1][1].equals(piece) && grid[2][2].equals(" "))
			return 1;
		
		
		if(grid[0][2].equals(" ") && grid[1][1].equals(" ") && grid[2][0].equals(piece))
			return 3; 
		
		if(grid[0][2].equals(piece) && grid[1][1].equals(" ") && grid[2][0].equals(" "))
			return 5;
		
		if(grid[0][2].equals(" ") && grid[1][1].equals(piece) && grid[2][0].equals(" "))
			return 3;
		
		return -1;
	}
	
	
	public static int finish(char cpiece, String[][] grid)
	{
		String piece = Character.toString(cpiece);
		
		for(int i = 0; i < 3; i++)
		{
			
			if(grid[i][0].equals(" ") && grid[i][1].equals(piece) && grid[i][2].equals(piece))
				return ((3 * i) + 0 + 1);
			
			if(grid[i][0].equals(piece) && grid[i][1].equals(" ") && grid[i][2].equals(piece))
				return ((3 * i) + 1 + 1);
			
			if(grid[i][0].equals(piece) && grid[i][1].equals(piece) && grid[i][2].equals(" "))
				return ((3 * i) + 2 + 1);
		}
		
		
		for(int i = 0; i < 3; i++)
		{
			
			if(grid[0][i].equals(" ") && grid[1][i].equals(piece) && grid[2][i].equals(piece))
				return (i + 1);
			
			if(grid[0][i].equals(piece) && grid[1][i].equals(" ") && grid[2][i].equals(piece))
				return (3 + i + 1); 
			
			if(grid[0][i].equals(piece) && grid[1][i].equals(piece) && grid[2][i].equals(" "))
				return (6 + i + 1); 
			
		}
		
			
		if(grid[0][0].equals(piece) && grid[1][1].equals(piece) && grid[2][2].equals(" "))
			return 9; 
		
		if(grid[0][0].equals(piece) && grid[1][1].equals(" ") && grid[2][2].equals(piece))
			return 5;	
		
		if(grid[0][0].equals(" ") && grid[1][1].equals(piece) && grid[2][2].equals(piece))
			return 1;
		
		
		
		if(grid[0][2].equals(piece) && grid[1][1].equals(piece) && grid[2][0].equals(" "))
			return 7; 
	
		if(grid[0][2].equals(piece) && grid[1][1].equals(" ") && grid[2][0].equals(piece))
			return 5;
		
		if(grid[0][2].equals(" ") && grid[1][1].equals(piece) && grid[2][0].equals(piece))
			return 3;
		
		return -1;
	}
}