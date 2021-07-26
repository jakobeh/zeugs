package pack1;

import java.util.Timer;

public class general {
	static Timer game;
	static int rate = 15;

	static int HitboxTransparenz = 128;

	// LEvel in einer Welt
	static final int levelAnzahl = 10;

	// erstellte Level (rsc/lvls)
	// MUSS GEÄNDERT WERDEN, WENN LEVEL HINZUGEFÜGT WERDEN SOLLEN!
	static final int possibleLvls = 31;

	// Zahl der möglichen Biome
	static final int possibleBiomes = 8;
	/*
	 * 0: Himmel
	 * 1: Höhle
	 * 2: Meer
	 * 3: Stadt
	 * 4: Vulkan
	 * 5: Wald
	 * 6: Weltall
	 * 7: Wüste
	 */

	// Länge und Breite der Blueprints
	static final int blueprintSeite = 16;

	// Faktor, mit dem Position in Blueprint multipliziert werden muss,
	// um Position in Raum zu erhalten
	static final int faktorRaster = 50;

	static final int WandLW = 50, WandRW = 50, BodenH = 100;

	static int HitboxDif = 5;

	public general() {
	}

}
