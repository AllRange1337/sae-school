package bauernhof;

import java.util.HashMap;
import java.util.Map;

public class Herde extends Kuh {

	private String herdenName;
	private Map<Integer, Kuh> herde;
	private int mitgliederAnzahl = herde.size();

	public Herde() {
		this("<NEUE_HERDE>");
	}

	public Herde(String name) {
		herdenName = name;
		herde = new HashMap<Integer, Kuh>();
	}

	public void kuhHinzufuegen(Kuh kuh) {
		herde.put(mitgliederAnzahl, kuh);
	}

	public String getHerdenName() {
		return herdenName;
	}

	public int getMitgliederAnzahl() {
		return mitgliederAnzahl;
	}

	public void setMitgliederAnzahl(int mitgliederAnzahl) {
		this.mitgliederAnzahl = mitgliederAnzahl;
	}

	public Map<Integer, Kuh> getHerde() {
		return herde;
	}

	public void setHerdenName(String herdenName) {
		this.herdenName = herdenName;
	}

	public void herdeFuettern(int menge) {
		for (Map.Entry<Integer, Kuh> kuh : herde.entrySet()) {
			((Kuh) kuh).fresseHeu(menge / mitgliederAnzahl);
		}
	}

	public void herdeWaessern(double menge) {
		for (Map.Entry<Integer, Kuh> kuh : herde.entrySet()) {
			((Kuh) kuh).gibWasser(menge / mitgliederAnzahl);
		}
	}

	public void herdeMelken() {
		for (Map.Entry<Integer, Kuh> kuh : herde.entrySet()) {
			((Kuh) kuh).melken();
		}
	}

	public Kuh getKuhByName(String name) {
		for (Map.Entry<Integer, Kuh> kuh : herde.entrySet()) {
			if (name.equals(((Kuh) kuh).getName())) {
				return (Kuh) kuh;
			}
		}
		return null;
	}
}
