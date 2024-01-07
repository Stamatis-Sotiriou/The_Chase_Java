package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Selection extends JFrame implements ActionListener{
	
	JButton btn_achaser = new JButton("Chaser A");
	JButton btn_bchaser = new JButton("Chaser B");
	JButton btn_cchaser = new JButton("Chaser C");
	
	JLabel label = new JLabel("Επέλεξε τον Chaser:");
	
	Chaser chaser;
	
	Selection(){
		this.setTitle("The Chase!");
		this.setSize(700, 700);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		label.setBounds(250,25,250,50);
		//label.setFont(new Font(null, Font.PLAIN, 20));
		this.add(label);
		
		btn_achaser.setBounds(200, 100, 300, 100);
		btn_achaser.setFocusable(false);
		btn_achaser.addActionListener(this);
		this.add(btn_achaser);
		
		
		btn_bchaser.setBounds(200, 300, 300, 100);
		btn_bchaser.setFocusable(false);
		btn_bchaser.addActionListener(this);
		this.add(btn_bchaser);
		
		
		btn_cchaser.setBounds(200, 500, 300, 100);
		btn_cchaser.setFocusable(false);
		btn_cchaser.addActionListener(this);
		this.add(btn_cchaser);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_achaser) {
			chaser = new Chaser(1);
		} 
		else if(e.getSource() == btn_bchaser) {
			chaser = new Chaser(2);
		} 
		else if(e.getSource() == btn_cchaser) {
			chaser = new Chaser(3);
		}
		this.dispose();
		new MainGame(chaser);
	}
}
