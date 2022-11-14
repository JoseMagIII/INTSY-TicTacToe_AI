import java.util.Scanner;

public class MCO2 
{
	
	
	public static void main(String[] args) {
		
		TicTacToe game = new TicTacToe();
		TicTacToeGUI GUI = new TicTacToeGUI();
		
		
		char turn;
		char initTurn = 'X';
		char playerChar = 'X', aiChar = 'O';
		Scanner kb = new Scanner(System.in);
		int restart;
		
		
		int AI;
		
		System.out.println("Choose AI:");
		System.out.println("#1: Level 0 Random AI");
		System.out.println("#2: Level 1 Hard Coded AI");
		System.out.println("#3: Level 2 Greedy Best First Search AI");
		System.out.println("Input AI#: ");
		AI = kb.nextInt();
		
		
		do
		{
		turn = initTurn;
		
		System.out.println("Player's Character is " + playerChar);
		System.out.println("AI's Character is " + aiChar);
		System.out.println();
		System.out.println();
		
		//For testing
		while(game.gameState() == 0)
		{
			int move = 0;
			
			game.showMoves();
			
			
			if(playerChar == 'X')
			switch(turn)
			{
			case 'X':
					do
					{
					System.out.println("Input Move: ");
					move = kb.nextInt();
					}while(!game.isMoveValid(move));
					
					game.moveX(move);
					turn = 'O';
					break;
					
			case 'O':
					do
					{
						switch(AI)
						{
						case 1: move = Level0.Move(aiChar, game.getMoves());
							 	break;
							 	
						case 2: move = Level1.Move('X', 'O', game.getGrid());
								break;
							
						case 3: move = Level2.Move(aiChar, game.getMoves(), game.getGrid());
								break;
						}	
					
					}while(!game.isMoveValid(move));
					
					game.moveO(move);
					turn = 'X';
					break;
			}
			
			
			else
			switch(turn)
			{
			case 'X':
					do
					{
						switch(AI)
						{
						case 1: move = Level0.Move(aiChar, game.getMoves());
							 	break;
							 	
						case 2: move = Level1.Move('O', 'X', game.getGrid());
								break;
							
						case 3: move = Level2.Move(aiChar, game.getMoves(), game.getGrid());
								break;
						}	
						
					}while(!game.isMoveValid(move));
					
					game.moveX(move);
					turn = 'O';
					break;
					
					
			case 'O':
					do
					{
					System.out.println("Input Move: ");
					move = kb.nextInt();
					}while(!game.isMoveValid(move));
					
					game.moveO(move);
					turn = 'X';
					break;
			}	
			
			GUI.updateGrid(game.getGrid());	
		}
		
		
		
		
		System.out.println("Restart Game?");
		System.out.println("#1: Yes");
		System.out.println("#2: No");
		restart = kb.nextInt();
		
		if(restart == 1)
		{
			if(initTurn == 'X')
				initTurn = 'O';
			
			else
			if(initTurn == 'O')
				initTurn = 'X';
			
			GUI.close();
			
			game = new TicTacToe();
			GUI = new TicTacToeGUI();
			

		}
		
		System.out.println();
		System.out.println();
		
		}while(restart == 1);
		
		GUI.close();
	}
		
}
