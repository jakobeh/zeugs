package pack;

import java.awt.Point;

public class Zustand {

	String name;
	boolean start, end;
	Point pos;
	
	public Zustand(String name, boolean start, boolean end, Point pos) {
		this.name = name;
		this.start = start;
		this.end = end;		
	}

	public boolean isEnd() {
		return end;
	}
	
	public Point getPos() {
		return pos;
	}
	
}
