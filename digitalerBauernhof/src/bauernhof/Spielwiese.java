package bauernhof;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Spielwiese {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {

		HashMap<Integer, Kuh> herde = createDefaultHerde();
		workMenu(herde);

	}

	private static void workMenu(HashMap<Integer, Kuh> herde) {
		System.out.println("Was willst du tun ?");
		System.out.println("Heu füttern (1)");
		System.out.println("Kuh Wasser geben (2)");
		System.out.println("Kuh melken (3)");
		System.out.println("Herde melken (4)");
		System.out.println("Aktuellen Milchpreis anzeigen/bearbeiten (5)");
		doWithCow(scanner.nextInt(), herde);
		scanner.reset();
	}

	private static void doWithCow(int value, HashMap<Integer, Kuh> herde) {
		Kuh kuh;
		switch (value) {
		case 1:
			System.out.println("Welche Kuh soll gefüttert werden?");
			kuh = selectKuh(herde);
			System.out.println("Wieviel soll verfüttert werden ?");
			kuh.fresseHeu(scanner.nextInt());
			scanner.reset();
			break;
		case 2:
			System.out.println("Welche Kuh soll ertränkt werden?");
			kuh = selectKuh(herde);
			System.out.println("Wieviel Wasser ist nötig ?");
			kuh.gibWasser(scanner.nextDouble());
			scanner.reset();
			break;
		case 3:
			System.out.println("Welche Kuh soll gemolken werden?");
			kuh = selectKuh(herde);
			System.out.println(kuh.getName() + " gab " + kuh.melken() + " Liter Milch!");
			break;
		case 4:
			System.out.println("Gesamte Herde wird gemolken (Stell sicher, dass kein Stier darunter ist)!");
			double milchGesamt = 0;
			for (Entry<Integer, Kuh> entry : herde.entrySet()) {
				entry.getValue().melken();
				milchGesamt = entry.getValue().getMilch();
			}
			System.out.println("Es wurden " + milchGesamt + " Liter von der Herde gemolken");
			break;
		case 5:
			System.out.println("Aktueller Milchpreis betraegt: " + Kuh.getMilchPreis() + "€/Liter");
			System.out.println("Bitte neuen Milchpreis angeben: (leere Eingabe zum Ueberspringen)");
			String next = scanner.next();
			try {
				next = next.replace(',', '.');
				Kuh.setMilchPreis(Double.parseDouble(next));
				System.out.println("Neuer Milchpreis betraegt: " + Kuh.getMilchPreis());
			} catch (Throwable e) {
				System.out.println("Milchpreis wurde nicht geaendert!");
			}
			break;
		}
		System.out.println("Neuen Auftrag ausführen? (ja nein)");
		String input = scanner.next();
		if (input != null && input.equals("ja")) {
			workMenu(herde);
			scanner.reset();
		}
		System.exit(1);
	}

	private static Kuh selectKuh(HashMap<Integer, Kuh> herde) {
		for (Entry<Integer, Kuh> entry : herde.entrySet()) {
			System.out.println(entry.getValue().getName() + " (" + entry.getKey() + ")");
		}
		Kuh kuh = herde.get(scanner.nextInt());
		scanner.reset();
		return kuh;
	}

	private static HashMap<Integer, Kuh> createDefaultHerde() {
		Kuh elsa = new Kuh("Elsa", 750, 2010);
		Kuh elfriede = new Kuh("Elfriede", 650, 2011);
		Kuh lisl = new Kuh("Lisl", 850, 2009);
		Kuh horst = new Kuh("Horst", 1050, 2008);
		Kuh muh = new Kuh("Muh", 900, 2010);
		Kuh unbekannt = new Kuh();

		HashMap<Integer, Kuh> herde = new HashMap<Integer, Kuh>(5);
		herde.put(1, elsa);
		herde.put(2, elfriede);
		herde.put(3, lisl);
		herde.put(4, horst);
		herde.put(5, muh);
		herde.put(6, unbekannt);
		return herde;
	}
}
