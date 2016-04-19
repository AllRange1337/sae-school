package bauernhof;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Spielwiese {

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
		doWithCow(new Scanner(System.in).nextInt(), herde);
	}

	private static void doWithCow(int value, HashMap<Integer, Kuh> herde) {
		Kuh kuh;
		switch (value) {
		case 1:
			System.out.println("Welche Kuh soll gefüttert werden?");
			kuh = selectKuh(herde);
			kuh.fresseHeu(Integer.parseInt(JOptionPane.showInputDialog("Wieviel soll verfüttert werden ?")));
			break;
		case 2:
			System.out.println("Welche Kuh soll ertränkt werden?");
			kuh = selectKuh(herde);
			kuh.gibWasser(Double.parseDouble(JOptionPane.showInputDialog("Wieviel Wasser ist nötig ?")));
			break;
		case 3:
			System.out.println("Welche Kuh soll gemolken werden?");
			kuh = selectKuh(herde);
			kuh.melken();
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
		default:
			System.out.println("Nix zu tun ?");
			if (JOptionPane.showInputDialog("Neuen Auftrag ausführen? (ja nein)").equals("ja")) {
				workMenu(herde);
			}
		}

	}

	private static Kuh selectKuh(HashMap<Integer, Kuh> herde) {
		for (Entry<Integer, Kuh> entry : herde.entrySet()) {
			System.out.println(entry.getValue().getName() + " (" + entry.getKey() + ")");
		}
		Kuh kuh = herde.get(new Scanner(System.in).nextInt());
		return kuh;
	}

	private static HashMap<Integer, Kuh> createDefaultHerde() {
		Kuh elsa = new Kuh("Elsa", 750, 2010);
		Kuh elfriede = new Kuh("Elfriede", 650, 2011);
		Kuh lisl = new Kuh("Lisl", 850, 2009);
		Kuh horst = new Kuh("Horst", 1050, 2008);
		Kuh muh = new Kuh("Muh", 900, 2010);

		HashMap<Integer, Kuh> herde = new HashMap<Integer, Kuh>(5);
		herde.put(1, elsa);
		herde.put(2, elfriede);
		herde.put(3, lisl);
		herde.put(4, horst);
		herde.put(5, muh);
		return herde;
	}
}
