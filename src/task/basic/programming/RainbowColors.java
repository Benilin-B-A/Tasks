package task.basic.programming;

public enum RainbowColors{
	
	VIOLET(1),
	INDIGO(2),
	BLUE(3),
	GREEN(4),
	YELLOW(5),
	ORANGE(6),
	RED(7);
	
	private int colorCode;
	
	RainbowColors(int code){
		colorCode=code;
	}
	
	public int getCode(){
		return this.colorCode;
	}
}
