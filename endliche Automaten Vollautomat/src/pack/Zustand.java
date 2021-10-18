package pack;

import java.awt.Point;
import java.awt.Rectangle;

public class Zustand {

	String name;
	boolean start, end;
	Point pos;
	Rectangle hitbox;
	
	public Zustand(String name, boolean start, boolean end, Point pos) {
		this.name = name;
		this.start = start;
		this.end = end;
		this.pos = pos;
		hitbox = new Rectangle((int) pos.getX(), (int) pos.getY(), 130, 80);
	}

	public boolean isEnd() {
		return end;
	}
	
	public boolean isStart() {
		return start;
	}
	
	public Point getPos() {
		return pos;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public void setEnd(boolean b) {
		end = b;
	}
	
	public void setStart(boolean b) {
		start = b;
	}
	
	public void switchEnd() {
		end = !end;
	}
	
	public void switchStart() {
		start = !start;
	}
	
	public String getName() {
		return name;
	}
	
}
