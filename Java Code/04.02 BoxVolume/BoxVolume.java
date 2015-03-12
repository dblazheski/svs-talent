
public class BoxVolume {
	public int height,weight,depth;
	
	public BoxVolume(int height,int weight,int depth) {
		this.height=height;
		this.weight=weight;
		this.depth=depth;
	}
	public int calculateVolume(){
	return height*weight*depth;
	}
	
	public void print(){
		System.out.println("Height is: "+height+"\nWeight is: "+weight+"\nDepth is: "+depth);
	}

}
