import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TicTacToeGUI 
{
	private JFrame frame;
	private JLabel Label = new JLabel("1");
	private JLabel Label_1 = new JLabel("2");
	private JLabel Label_2 = new JLabel("3");
	private JLabel Label_3 = new JLabel("4");
	private JLabel Label_4 = new JLabel("5");
	private JLabel Label_5 = new JLabel("6");
	private JLabel Label_6 = new JLabel("7");
	private JLabel Label_7 = new JLabel("8");
	private JLabel Label_8 = new JLabel("9");
	
	public TicTacToeGUI()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 474, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		
		
		Label.setFont(new Font("Arial Black", Font.BOLD, 47));
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Label);
		Label.setBorder(border);
		
		
		Label_1.setHorizontalAlignment(SwingConstants.CENTER);
		Label_1.setFont(new Font("Arial Black", Font.BOLD, 47));
		frame.getContentPane().add(Label_1);
		Label_1.setBorder(border);
		
		
		Label_2.setHorizontalAlignment(SwingConstants.CENTER);
		Label_2.setFont(new Font("Arial Black", Font.BOLD, 47));
		frame.getContentPane().add(Label_2);
		Label_2.setBorder(border);
		
		
		Label_3.setHorizontalAlignment(SwingConstants.CENTER);
		Label_3.setFont(new Font("Arial Black", Font.BOLD, 47));
		frame.getContentPane().add(Label_3);
		Label_3.setBorder(border);
		
		
		Label_4.setHorizontalAlignment(SwingConstants.CENTER);
		Label_4.setFont(new Font("Arial Black", Font.BOLD, 47));
		frame.getContentPane().add(Label_4);
		Label_4.setBorder(border);
		
		
		Label_5.setHorizontalAlignment(SwingConstants.CENTER);
		Label_5.setFont(new Font("Arial Black", Font.BOLD, 47));
		frame.getContentPane().add(Label_5);
		Label_5.setBorder(border);
		
		
		Label_6.setHorizontalAlignment(SwingConstants.CENTER);
		Label_6.setFont(new Font("Arial Black", Font.BOLD, 47));
		frame.getContentPane().add(Label_6);
		Label_6.setBorder(border);
		
		
		Label_7.setHorizontalAlignment(SwingConstants.CENTER);
		Label_7.setFont(new Font("Arial Black", Font.BOLD, 47));
		frame.getContentPane().add(Label_7);
		Label_7.setBorder(border);
		
		
		Label_8.setHorizontalAlignment(SwingConstants.CENTER);
		Label_8.setFont(new Font("Arial Black", Font.BOLD, 47));
		frame.getContentPane().add(Label_8);
		Label_8.setBorder(border);
	}
	
	public void updateGrid(String[][] gameGrid)
	{
		Label.setText(gameGrid[0][0]);
		Label_1.setText(gameGrid[0][1]);
		Label_2.setText(gameGrid[0][2]);
		Label_3.setText(gameGrid[1][0]);
		Label_4.setText(gameGrid[1][1]);
		Label_5.setText(gameGrid[1][2]);
		Label_6.setText(gameGrid[2][0]);
		Label_7.setText(gameGrid[2][1]);
		Label_8.setText(gameGrid[2][2]);
		
	}
	
	public void showDraw()
	{
		JOptionPane.showMessageDialog(frame, "DRAW!");
	}
	
	public void showWinner(char Winner)
	{
		JOptionPane.showMessageDialog(frame, "Player " + Winner + " Won!");
	}
	
	public void close()
	{
		frame.dispose();
	}
}
