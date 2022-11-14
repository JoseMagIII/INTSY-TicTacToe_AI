import java.util.Random;

public class Level0 
{
	
	public static int Move(char AIChar, int[] availMoves)
	{
		Random rand = new Random();
		int move = 0;
		
		do
		{
			move = availMoves[rand.nextInt(9)];
			
		}while(move == 0);
		
		
		return move;
		
	}
}
