package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class Tiles extends JPanel {
	
	private int x_cor;
	private int y_cor;
	
	private Color color;
	
	Tiles(int x, int y, Color color){
		this.x_cor = x;
		this.y_cor = y;				
		
		this.color = color;
		this.setBackground(this.color);
		
		Border tile_border = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.setBorder(tile_border);
		
		this.setBounds(this.x_cor, this.y_cor, 250, 50);
	}
	
	void setColor(Color color) {
		this.color = color;
		this.setBackground(this.color);
	}
}


class MyLabel extends JLabel {
	MyLabel() {
		this.setForeground(Color.WHITE);
		this.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 18));
	}
}

class QuestionPanel extends JPanel {

	JPanel question;
	JButton ansA;
	JButton ansB; 
	JButton ansC;
	
	
	private JLabel Qlabel = new MyLabel();
	private JLabel ansAlabel = new MyLabel();
	private JLabel ansBlabel = new MyLabel();
	private JLabel ansClabel = new MyLabel();
	
	private ArrayList<String>  Questions;
	private ArrayList<ArrayList<String>> Answers;
	
	private Random rand = new Random();
	private int index;
	
	void setLists() {
		this.Questions = new ArrayList<String>(Arrays.asList(
				"<html>Ερώτηση 1</html>", 
				"<html>Ερώτηση 2</html>", 
				"<html>Ερώτηση 3</html>"));
		
		this.Answers = new ArrayList<ArrayList<String>>(Arrays.asList());
		this.Answers.add(new ArrayList<String>(Arrays.asList(" a", " b", " c")));
		this.Answers.add(new ArrayList<String>(Arrays.asList(" a", " b", " c")));
		this.Answers.add(new ArrayList<String>(Arrays.asList(" a", " b", " c")));
		
	}
	
	QuestionPanel(){
		this.setBackground(Color.BLUE);
		this.setBounds(50, 500, 600, 150);
		this.setLayout(null);
		
		Border Qborder = BorderFactory.createLineBorder(Color.BLACK, 2);
		
		this.question = new JPanel();
		this.question.setBounds(0,0, 600, 100);
		this.question.setBackground(Color.BLUE);
		this.question.setBorder(Qborder);
		
		this.ansA = new JButton();
		this.ansA.setBounds(0,100,200,50);
		this.ansA.setBackground(new Color(0, 100, 255));
		this.ansA.setBorder(Qborder);
				
		this.ansB = new JButton();
		this.ansB.setBounds(200,100,200,50);
		this.ansB.setBackground(new Color(0, 100, 255));
		this.ansB.setBorder(Qborder);

		this.ansC = new JButton();
		this.ansC.setBounds(400,100,200,50);
		this.ansC.setBackground(new Color(0, 100, 255));
		this.ansC.setBorder(Qborder);
		
		this.add(this.question);
		this.add(this.ansA);
		this.add(this.ansB);
		this.add(this.ansC);
		
		setLists();
	}
	
	
	int getRand() {
		return rand.nextInt(this.Questions.size());
	}
	
	
	void setQuestion() {
		this.index = getRand();
		
		Qlabel.setText(Questions.get(this.index));
		ansAlabel.setText(this.Answers.get(this.index).get(0));
		ansBlabel.setText(this.Answers.get(this.index).get(1));
		ansClabel.setText(this.Answers.get(this.index).get(2));
		
		this.question.add(Qlabel);
		this.ansA.add(ansAlabel);
		this.ansB.add(ansBlabel);
		this.ansC.add(ansClabel);
	
		this.Questions.remove(this.index);
		this.Answers.remove(this.index);
	}
}


class MainGame extends JFrame implements ActionListener{
	
	QuestionPanel Qpanel;
	Chaser chaser;
	
	MainGame(Chaser chaser){
		this.chaser = chaser;
		
		this.setSize(700, 700);
		this.setTitle("The Chase!");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		
		Tiles tile1 = new Tiles(225, 25, Color.RED);		
		this.add(tile1);
		
		Tiles tile2 = new Tiles(225, 75, Color.BLUE);
		this.add(tile2);
		
		Tiles tile3 = new Tiles(225, 125, Color.GREEN);		
		this.add(tile3);
		
		Tiles tile4 = new Tiles(225, 175, Color.BLUE);
		this.add(tile4);
		
		Tiles tile5 = new Tiles(225, 225, Color.BLUE);		
		this.add(tile5);
		
		Tiles tile6 = new Tiles(225, 275, Color.BLUE);
		this.add(tile6);
		
		Tiles tile7 = new Tiles(225, 325, Color.BLUE);		
		this.add(tile7);
		
		Tiles tile8 = new Tiles(225, 375, Color.BLUE);
		this.add(tile8);
		
		Tiles bank = new Tiles(225, 425, Color.YELLOW);
		this.add(bank);

		
		this.Qpanel = new QuestionPanel();
		this.add(this.Qpanel);
		
		this.Qpanel.ansA.addActionListener(this);
		this.Qpanel.ansB.addActionListener(this);
		this.Qpanel.ansC.addActionListener(this);

		this.Qpanel.setQuestion();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.Qpanel.setQuestion();
	}

}
