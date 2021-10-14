package pack;

import java.util.ArrayList;

public class EA {

	ArrayList<Zustand> zustand;
	int start = -1;
	char[][][] matrix;

	static final char anyChar = '#';
	ArrayList<Character> usedChars;

	public EA(ArrayList<Zustand> zustand, int start, char[][][] matrix, ArrayList<Character> usedChars) {
		this.zustand = zustand;
		this.start = start;
		this.matrix = matrix;
		this.usedChars = usedChars;
	}

	public EA() {
		zustand = new ArrayList<Zustand>();
		matrix = new char[0][0][];
		usedChars = new ArrayList<Character>();
	}

	public void addZustand(Zustand z, boolean start) {
		zustand.add(z);
		if (start) {
			this.start = zustand.size() - 1;
		}
		char[][][] newM = new char[matrix.length + 1][matrix.length + 1][];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				newM[i][j] = matrix[i][j];
			}
		}
		matrix = newM;
	}

	public void addPath(int from, int to, char[] chars) {
		if (from >= zustand.size() || from < 0 || to >= zustand.size() || to < 0) {
			return;
		}

		matrix[from][to] = chars;

		for (char c : chars) {
			if (!usedChars.contains(c)) {
				usedChars.add(c);
			}
		}
	}

	public boolean check(String word) {
		if (start < 0) {
			return false;
		}
		int currZ = start;
		char[] chars = word.toCharArray();
		for (char c : chars) {
			boolean breakFor = false;
			for (int i = 0; i < matrix.length; i++) {
				if (breakFor) {
					break;
				}
				boolean error = true;
				for (int j = 0; j < matrix[currZ][i].length; j++) {
					if ((matrix[currZ][i][j] == anyChar && !usedChars.contains(c)) || (matrix[currZ][i][j] == c)) {
						currZ = i;
						breakFor = true;
						error = false;
						break;
					}
				}
				if (error) {
					return false;
				}
			}
		}

		return zustand.get(currZ).isEnd();

	}

	public ArrayList<Zustand> getZustand() {
		return zustand;
	}

}
