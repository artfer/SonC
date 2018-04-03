package sonc.quad;

class Quad {
	int x,y,width,height;
	Quad() {
		this.x=0;
		this.y=0;
		this.width=1000;
		this.height=1000;
	}
	
	Quad(int x,int y,int width,int height){
		this.x=y;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	int getWidth() {
		return width-x;
	}
	
	int getHeight() {
		return height-y;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
}
