package window.Processing;

import processing.core.PApplet;

public class Processing extends PApplet {
		public void settings(){
		  size(1000,600);
		}

		public void draw(){
			  if(mousePressed){
			    fill(0,255,0);
			  }
			  else{
			    fill(0,0,255);
			  }
			  ellipse(mouseX,mouseY,100,80);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Processing.class.getName());
	}

}
