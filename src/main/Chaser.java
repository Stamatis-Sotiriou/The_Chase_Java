package main;

import java.util.Random;

class Chaser{
	
	private int type;
	
	Chaser(int type){
		this.type = type;
	}
	int getType(){
		return this.type;
	}
	int chaserAns(int solution) {
		Random rand = new Random();
		int ans = rand.nextInt(100);
		if(ans > 5) {
			ans = solution;
		}
		
		return ans;
	}
	
}
}
