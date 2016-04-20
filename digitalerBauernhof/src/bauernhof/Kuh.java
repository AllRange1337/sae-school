package bauernhof;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Kuh {
	private String name;
	private int gewicht;
	private int geburtsjahr;
	private int gefressenHeu;
	private double wasser;
	private double milch;
	private static double milchPreis = 0.3;
	private Kalb kalb;
	
	public Kuh() {
		name = "unbekannt";
		gewicht = 35;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy"); 
        Date currentTime = new Date(); 
		geburtsjahr = Integer.parseInt(formatter.format(currentTime));
	}

	public Kuh(String name, int gewicht, int geburtsjahr) {
		this.name = name;
		this.gewicht = gewicht;
		this.geburtsjahr = geburtsjahr;
	}

	public void setGeburtsjahr(int geburtsjahr) {
		if (geburtsjahr <= 2011)
			this.geburtsjahr = geburtsjahr;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public void setGewicht(int gewicht) {
		if (gewicht > 35 && gewicht <= 1000) {
			this.gewicht = gewicht;
		}
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static double getMilchPreis() {
		return milchPreis;
	}

	public static void setMilchPreis(double milchPreis) {
		Kuh.milchPreis = milchPreis;
	}

	public Kalb getKalb() {
		return kalb;
	}

	public void setKalb(Kalb kalb) {
		this.kalb = kalb;
	}

	public void status() {
		StringBuilder result = new StringBuilder();
		result.append("Status der Kuh ");
		result.append(getName() + ":\n");
		result.append("Gewicht : " + getGewicht() + "\n");
		result.append("Geb.jahr: " + getGeburtsjahr());
		System.out.println(result.toString());
	}

	public void fresseHeu(int menge) {
		if (menge > 0) {
			gefressenHeu += menge;
		}
	}

	public void gibWasser(double menge) {
		if (menge > 0)
			wasser += menge;
	}

	public double melken() {
		int calcHeu = (gefressenHeu / 5);
		int calcWasser = (int) (wasser / 7.5);

		if (calcHeu > 0 && calcWasser > 0) {
			int mult = calcHeu > calcWasser ? calcWasser : calcHeu;
			milch = 0.5 * mult;
			wasser -= calcWasser * 7.5;
			gefressenHeu -= calcHeu * 5;
			return 0.5 * mult;
		}
		return 0;
	}

	public double getMilch() {
		return milch;
	}
	
	public void kalben(String name, char geschlecht) {
		this.kalb = new Kalb(name, geschlecht, this);
	}
	
	public class Kalb extends Kuh {
		private String name;
		private char geschlecht;
		private Kuh mutter;
		
		public Kalb(String name, char geschlecht, Kuh mutter) {
			this.name = name;
			this.geschlecht = geschlecht;
			this.mutter = mutter;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public char getGeschlecht() {
			return geschlecht;
		}
		public void setGeschlecht(char geschlecht) {
			this.geschlecht = geschlecht;
		}
		public Kuh getMutter() {
			return mutter;
		}
	}
}
