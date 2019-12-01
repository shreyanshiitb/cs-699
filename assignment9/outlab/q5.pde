int i=1;
void setup() {
    size(640, 320);
    background(250,155,70);
}

void draw() {

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
