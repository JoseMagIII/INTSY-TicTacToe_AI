import java.util.ArrayList;

public class Level2
{
	
	public static int Move(char AIChar, int[] remMoves, String[][] gameGrid)
	{
		char PlayerChar;
		
		
		if(AIChar == 'O')
			PlayerChar = 'X';
		
		else
			PlayerChar = 'O';
		
		
		
		//Get remaining moves
		ArrayList<Integer> remainingMoves = new ArrayList<Integer>();
		for(int ctr = 0; ctr < 9; ctr++)
			if(remMoves[ctr] != 0)
				remainingMoves.add(remMoves[ctr]);
		
		
		//Create grids for the remaining moves
		String [][][] moveGrids = new String[remainingMoves.size()][3][3];
		for(int ctr = 0; ctr < remainingMoves.size(); ctr++)
		{
			moveGrids[ctr][0][0] = gameGrid[0][0];
			moveGrids[ctr][0][1] = gameGrid[0][1];
			moveGrids[ctr][0][2] = gameGrid[0][2];
			moveGrids[ctr][1][0] = gameGrid[1][0];
			moveGrids[ctr][1][1] = gameGrid[1][1];
			moveGrids[ctr][1][2] = gameGrid[1][2];
			moveGrids[ctr][2][0] = gameGrid[2][0];
			moveGrids[ctr][2][1] = gameGrid[2][1];
			moveGrids[ctr][2][2] = gameGrid[2][2];
		}
		
		for(int ctr = 0; ctr < remainingMoves.size(); ctr++)
			moveGrids[ctr] = move(remainingMoves.get(ctr), moveGrids[ctr], AIChar);
		
		
		
		
		
		int[] scores = new int[remainingMoves.size()];
		
		//Get scores of moves
		for(int ctr = 0; ctr < remainingMoves.size(); ctr++)
			scores[ctr] = getPoints(moveGrids[ctr], AIChar) - getPoints(moveGrids[ctr], PlayerChar);
		
		
		
		
		//Get highest score
		int index = 0;
		int highScore = scores[0];
		
		for(int ctr = 0; ctr < remainingMoves.size(); ctr++)
		{
			if(scores[ctr] > highScore)
			{
				index = ctr;
				highScore = scores[ctr];
			}
			
			if(scores[ctr] == highScore)
			{
				int points1 = getPoints(moveGrids[index], PlayerChar);
				int points2 = getPoints(moveGrids[ctr], PlayerChar);
				
				if(points2 < points1)
				{
					index = ctr;
					highScore = scores[ctr];
				}
			}
		}
		
		return remainingMoves.get(index);
	}
	
	
	public static int getPoints(String gameGrid[][], char playerChar)
	{
		int totPoints = 0;
		
		String playerString = ""+playerChar;
		
		
		String OnePointOne = playerString +"  ";
		String OnePointTwo = " " + playerString + " ";
		String OnePointThree = "  " + playerString;
		
		String TwoPointOne = playerString + playerString + " ";
		String TwoPointTwo = " " + playerString + playerString;
		String TwoPointThree = playerString + " " + playerString;
		
		String FiftyPoints = playerString + playerString + playerString;
		
		
		//Check horizontal lines
		String hor1 = gameGrid[0][0] + gameGrid[0][1] + gameGrid[0][2];
		String hor2 = gameGrid[1][0] + gameGrid[1][1] + gameGrid[1][2];
		String hor3 = gameGrid[2][0] + gameGrid[2][1] + gameGrid[2][2];
		
		if(hor1.equalsIgnoreCase(OnePointOne) || hor1.equalsIgnoreCase(OnePointTwo) || hor1.equalsIgnoreCase(OnePointThree))
			totPoints = totPoints + 1;
		
		if(hor2.equalsIgnoreCase(OnePointOne) || hor2.equalsIgnoreCase(OnePointTwo) || hor2.equalsIgnoreCase(OnePointThree))
			totPoints = totPoints + 1;
		
		if(hor3.equalsIgnoreCase(OnePointOne) || hor3.equalsIgnoreCase(OnePointTwo) || hor3.equalsIgnoreCase(OnePointThree))
			totPoints = totPoints + 1;
		
		
		if(hor1.equalsIgnoreCase(TwoPointOne) || hor1.equalsIgnoreCase(TwoPointTwo) || hor1.equalsIgnoreCase(TwoPointThree))
			totPoints = totPoints + 4;
		
		if(hor2.equalsIgnoreCase(TwoPointOne) || hor2.equalsIgnoreCase(TwoPointTwo) || hor2.equalsIgnoreCase(TwoPointThree))
			totPoints = totPoints + 4;
		
		if(hor3.equalsIgnoreCase(TwoPointOne) || hor3.equalsIgnoreCase(TwoPointTwo) || hor3.equalsIgnoreCase(TwoPointThree))
			totPoints = totPoints + 4;
		
		
		if(hor1.equalsIgnoreCase(FiftyPoints))
			totPoints = totPoints + 50;
		
		if(hor2.equalsIgnoreCase(FiftyPoints))
			totPoints = totPoints + 50;
		
		if(hor3.equalsIgnoreCase(FiftyPoints))
			totPoints = totPoints + 50;
		
		
		//Check vertical lines
		String ver1 = gameGrid[0][0] + gameGrid[1][0] + gameGrid[2][0];
		String ver2 = gameGrid[0][1] + gameGrid[1][1] + gameGrid[2][1];
		String ver3 = gameGrid[0][2] + gameGrid[1][2] + gameGrid[2][2];
		
		if(ver1.equalsIgnoreCase(OnePointOne) || ver1.equalsIgnoreCase(OnePointTwo) || ver1.equalsIgnoreCase(OnePointThree))
			totPoints = totPoints + 1;
		
		if(ver2.equalsIgnoreCase(OnePointOne) || ver2.equalsIgnoreCase(OnePointTwo) || ver2.equalsIgnoreCase(OnePointThree))
			totPoints = totPoints + 1;
		
		if(ver3.equalsIgnoreCase(OnePointOne) || ver3.equalsIgnoreCase(OnePointTwo) || ver3.equalsIgnoreCase(OnePointThree))
			totPoints = totPoints + 1;
		
		
		if(ver1.equalsIgnoreCase(TwoPointOne) || ver1.equalsIgnoreCase(TwoPointTwo) || ver1.equalsIgnoreCase(TwoPointThree))
			totPoints = totPoints + 4;
		
		if(ver2.equalsIgnoreCase(TwoPointOne) || ver2.equalsIgnoreCase(TwoPointTwo) || ver2.equalsIgnoreCase(TwoPointThree))
			totPoints = totPoints + 4;
		
		if(ver3.equalsIgnoreCase(TwoPointOne) || ver3.equalsIgnoreCase(TwoPointTwo) || ver3.equalsIgnoreCase(TwoPointThree))
			totPoints = totPoints + 4;
		
		
		if(ver1.equalsIgnoreCase(FiftyPoints))
			totPoints = totPoints + 50;
		
		if(ver2.equalsIgnoreCase(FiftyPoints))
			totPoints = totPoints + 50;
		
		if(ver3.equalsIgnoreCase(FiftyPoints))
			totPoints = totPoints + 50;
		
		
		//check diagonals
		String diag1 = gameGrid[0][0] + gameGrid[1][1] + gameGrid[2][2];
		String diag2 = gameGrid[0][2] + gameGrid[1][1] + gameGrid[2][0];
		
		if(diag1.equalsIgnoreCase(OnePointOne) || diag1.equalsIgnoreCase(OnePointTwo) || diag1.equalsIgnoreCase(OnePointThree))
			totPoints = totPoints + 1;
		
		if(diag2.equalsIgnoreCase(OnePointOne) || diag2.equalsIgnoreCase(OnePointTwo) || diag2.equalsIgnoreCase(OnePointThree))
			totPoints = totPoints + 1;
		
		
		if(diag1.equalsIgnoreCase(TwoPointOne) || diag1.equalsIgnoreCase(TwoPointTwo) || diag1.equalsIgnoreCase(TwoPointThree))
			totPoints = totPoints + 4;
		
		if(diag2.equalsIgnoreCase(TwoPointOne) || diag2.equalsIgnoreCase(TwoPointTwo) || diag2.equalsIgnoreCase(TwoPointThree))
			totPoints = totPoints + 4;
		
		
		if(diag1.equalsIgnoreCase(FiftyPoints))
			totPoints = totPoints + 50;
		
		if(diag2.equalsIgnoreCase(FiftyPoints))
			totPoints = totPoints + 50;
		
		return totPoints;
	}
	
	
	public static String[][] move(int index, String gameGrid[][], char playerChar)
	{
		String add = ""+playerChar;
		
		switch(index)
		{
		case 1: gameGrid[0][0] = add;
		break;
		case 2: gameGrid[0][1] = add;
		break;
		case 3: gameGrid[0][2] = add;
		break;
		case 4: gameGrid[1][0] = add;
		break;
		case 5: gameGrid[1][1] = add;
		break;
		case 6: gameGrid[1][2] = add;
		break;
		case 7: gameGrid[2][0] = add;
		break;
		case 8: gameGrid[2][1] = add;
		break;
		case 9: gameGrid[2][2] = add;
		break;
		}
		
		return gameGrid;
	}
}