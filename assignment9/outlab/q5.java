import processing.core.PApplet;

public class q5 extends PApplet{
    
    int i=1;

    public void setting(){
        size(640, 320);
    }

    public void setup() {
        background(250,155,70);
    }

    public void draw() {

        if(mousePressed)
            if (mouseButton == RIGHT) {
            stroke(0);
            line(mouseX, mouseY, pmouseX, pmouseY);
            }
            else {
            stroke(250,155,70);
            line(mouseX, mouseY, pmouseX, pmouseY);
            }
        
        if(keyPressed)
            if (key == '+') {
                i+=1;
                strokeWeight(i);
            } else if (key == '-') {
                if(i>1)
                    i-=1;
                strokeWeight(i);
            }        
    }

	public static void main(String[] args){
		String[] processingArgs = {"q5"};
		PApplet.runSketch(processingArgs, new q5());
	}
}