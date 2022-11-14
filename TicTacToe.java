
public class TicTacToe 
{
	private String[][] gameGrid = new String[3][3];
	private int[] remainingMoves = new int[9];
	
	
	public TicTacToe()
	{
		//Initialize gameGrid to empty characters
		for(int ctr = 0; ctr < 3; ctr++)
			for(int ctr2 = 0; ctr2 < 3; ctr2++)
				gameGrid[ctr][ctr2] = " ";
		
		for(int ctr = 0; ctr < 9; ctr++)
		{
			remainingMoves[ctr] = ctr+1;
		}
	}
	
	//Returns gameGrid
	public String[][] getGrid()
	{
		return gameGrid;
	}
	
	public void moveX(int index)
	{
		if(isMoveValid(index))
		switch(index)
		{
		case 1: gameGrid[0][0] = "X";
		break;
		case 2: gameGrid[0][1] = "X";
		break;
		case 3: gameGrid[0][2] = "X";
		break;
		case 4: gameGrid[1][0] = "X";
		break;
		case 5: gameGrid[1][1] = "X";
		break;
		case 6: gameGrid[1][2] = "X";
		break;
		case 7: gameGrid[2][0] = "X";
		break;
		case 8: gameGrid[2][1] = "X";
		break;
		case 9: gameGrid[2][2] = "X";
		break;
		}
		
		else
			System.out.println("Invalid Move!");
		
		remainingMoves[index-1] = 0;
	}
	
	public void moveO(int index)
	{
		if(isMoveValid(index))
		switch(index)
		{
		case 1: gameGrid[0][0] = "O";
		break;
		case 2: gameGrid[0][1] = "O";
		break;
		case 3: gameGrid[0][2] = "O";
		break;
		case 4: gameGrid[1][0] = "O";
		break;
		case 5: gameGrid[1][1] = "O";
		break;
		case 6: gameGrid[1][2] = "O";
		break;
		case 7: gameGrid[2][0] = "O";
		break;
		case 8: gameGrid[2][1] = "O";
		break;
		case 9: gameGrid[2][2] = "O";
		break;
		}
		
		else
		System.out.println("Invalid Move!");
		
		remainingMoves[index-1] = 0;
	}
	
	public int gameState()
	{
		for(int ctr = 0; ctr < 3; ctr++)
		{
			if(gameGrid[ctr][0] == gameGrid[ctr][1] && gameGrid[ctr][0] == gameGrid[ctr][2] && gameGrid[ctr][0] != " ")
			{
				System.out.println("PLAYER " + gameGrid[ctr][0] + " WINS!");
				return 1;
			}
		}
		
		for(int ctr = 0; ctr < 3; ctr++)
		{
			if(gameGrid[0][ctr] == gameGrid[1][ctr] && gameGrid[0][ctr] == gameGrid[2][ctr] && gameGrid[0][ctr] != " ")
			{
				System.out.println("PLAYER " + gameGrid[0][ctr] + " WINS!");
				return 1;
			}
		}
		
		if(gameGrid[0][0] == gameGrid[1][1] && gameGrid[0][0] == gameGrid[2][2] && gameGrid[0][0] != " ")
		{
			System.out.println("PLAYER " + gameGrid[0][0] + " WINS!");
			return 1;
		}
		
		if(gameGrid[0][2] == gameGrid[1][1] && gameGrid[0][2] == gameGrid[2][0] && gameGrid[0][2] != " ")
		{
			System.out.println("PLAYER " + gameGrid[0][2] + " WINS!");
			return 1;
		}
		
		boolean filled = true;
		for(int ctr = 0; ctr < 3; ctr++)
		{
			if(gameGrid[ctr][0] == " ")
				filled = false;
			
			if(gameGrid[ctr][1] == " ")
				filled = false;
			
			if(gameGrid[ctr][2] == " ")
				filled = false;
		}
		
		if(filled)
		{
			System.out.println("DRAW");
			return 2;
		}
		return 0;	
	}
	
	public void showMoves()
	{
		System.out.println("Available Moves: ");
		for(int ctr = 0; ctr < 9; ctr++)
			if(remainingMoves[ctr] != 0)
		System.out.print(remainingMoves[ctr] + " ");
		System.out.println();
		System.out.println();
	}
	
	public boolean isMoveValid(int move)
	{
		if(move < 1 || move > 9)
		{
			System.out.println("Invalid Move!");
			return false;
			
		}
		for(int ctr = 0; ctr < 9; ctr++)
		{
			if(move == remainingMoves[ctr])
				return true;
		}
		
		System.out.println("Invalid Move!");
		return false;
	}
	
	public int[] getMoves()
	{
		return remainingMoves;
	}
	
}
