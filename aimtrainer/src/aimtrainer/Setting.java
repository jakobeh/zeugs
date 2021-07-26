package aimtrainer;

public class Setting {
	String right = "X", wrong = "O", name = "EASY";
	int start = 1, end = 10;
	String code = right + trainer.splitter[0] + wrong + trainer.splitter[0] + start + trainer.splitter[0] + end + trainer.splitter[0] + name;

	public Setting(String r, String w, int s, int e, String n) {
		right = r;
		wrong = w;
		start = s;
		end = e;
		name = n;
		code = r + trainer.splitter[0] + w + trainer.splitter[0] + s + trainer.splitter[0] + e + trainer.splitter[0] + n;
	}

	public Setting(String c) {
		code = c;
		String[] a = c.split(trainer.splitter[0]);
		right = a[0];
		wrong = a[1];
		name = a[4];
		try {
			start = Integer.parseInt(a[2]);
			end = Integer.parseInt(a[3]);
		} catch (Exception x) {

		}
	}
}
