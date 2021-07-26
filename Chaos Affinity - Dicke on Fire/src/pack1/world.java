package pack1;

import java.util.Random;

public class world {
	// Zahlengenerator
	private Random r;
	// a: Zufallszahl, b: Speicherzahl zum Ringtausch, c: Zufallszahl zum Zuordnen
	// der Biome
	private int a, b, c;
	// Array, das Zahlen von 1 bis general.possibleLvls in aufsteigender Reihenfolge
	// beinhaltet
	private int[] posSeg;
	// Array, das die Segmente beinhaltet, aus den die Welt tatsächlich besteht
	public Segment[] segment;
	// gibt an, ob es Welt 1, oder Welt 2 ist
	public int number;

	public world(int n) {
		r = new Random();
		number = n;

		// Erstellen des Arrays und Zusweisung der Zahlen
		posSeg = new int[general.possibleLvls];
		for (int i = 0; i < general.possibleLvls; i++) {
			posSeg[i] = i + 1;
		}

		// Erstellen des Arrays und Erstellen der einzelnen Segmente,
		// um NullPointerExceptions zu vermeiden
		segment = new Segment[general.levelAnzahl];
		for (int i = 0; i < general.levelAnzahl; i++) {
			segment[i] = new Segment(i + 1, number);
		}
	}

	// Methode zur Zufälligen Generierung der Abfolge von Segmenten einer
	// world aus general.levelAnzahl Segmenten von general.possibleLvls
	public void generateBlueprints() {
		// Shufflen des gesamten Arrays posSeg[]
		for (int i = 0; i < general.possibleLvls; i++) {
			a = r.nextInt(general.possibleLvls);
			b = posSeg[i];
			posSeg[i] = posSeg[a];
			posSeg[a] = b;
		}
		// Zuweisung der ersten 10 Werte aus posSeg[] zu segments[]
		for (int i = 0; i < general.levelAnzahl; i++) {
			segment[i].blueprint = posSeg[i];
		}
		// Zuweisen von Biomen
		for (int i = 0; i < general.possibleBiomes; i++) {
			c = r.nextInt(general.possibleBiomes);
			switch (c) {
			case 0:
				segment[i].biom = "Himmel";
				break;
			case 1:
				segment[i].biom = "Höhle";
				break;
			case 2:
				segment[i].biom = "Meer";
				break;
			case 3:
				segment[i].biom = "Stadt";
				break;
			case 4:
				segment[i].biom = "Vulkan";
				break;
			case 5:
				segment[i].biom = "Wald";
				break;
			case 6:
				segment[i].biom = "Weltall";
				break;
			case 7:
				segment[i].biom = "Wüste";
				break;
			}

		}
	}

	// Methode zur Generierung einer zweiten Welt mit den gleichen Segmenten
	// die der ersten Welt
	public void shuffleWorld(world W) {
		// Übernehmen der ersten Welt
		for (int i = 0; i < general.levelAnzahl; i++) {
			segment[i].blueprint = W.segment[i].blueprint;
		}

		// segment = W.segment;
		// Shufflen der Segmente
		for (int i = 0; i < general.levelAnzahl; i++) {
			a = r.nextInt(general.levelAnzahl);
			b = segment[i].blueprint;
			segment[i].blueprint = segment[a].blueprint;
			segment[a].blueprint = b;
		}
	}

	// Methode zum Überprüfen der Welt
	// stellt Segmente einer Welt in einer Zeile dar
	public void printWorld() {
		for (int i = 0; i < general.levelAnzahl; i++) {
			System.out.print(segment[i].blueprint + " ");
			System.out.print(segment[i].biom + " ");
		}
		System.out.println();
	}

	// Methode zum Aufruf von processBlueprints für jedes Segment
	public void generateSegments() {
		for (int i = 0; i < general.levelAnzahl; i++) {
			segment[i].processBlueprint();
		}
	}
}
