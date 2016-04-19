package bauernhof;
public class Kuh
{
	private String name;
	private int gewicht;
	private int geburtsjahr;
	private int gefressenHeu;
	private double wasser;
	private double milch;

	public Kuh(String name, int gewicht, int geburtsjahr)
	{
		this.name = name;
		this.gewicht = gewicht;
		this.geburtsjahr = geburtsjahr;
	}

	public void setGeburtsjahr(int geburtsjahr)
	{
		if (geburtsjahr <= 2011)
			this.geburtsjahr = geburtsjahr;
	}

	public int getGeburtsjahr()
	{
		return geburtsjahr;
	}

	public void setGewicht(int gewicht)
	{
		if (gewicht > 35 && gewicht <= 1000)
		{
			this.gewicht = gewicht;
		}
	}

	public int getGewicht()
	{
		return gewicht;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void status()
	{
		StringBuilder result = new StringBuilder();
		result.append("Status der Kuh ");
		result.append(getName() + ":\n");
		result.append("Gewicht : " + getGewicht() + "\n");
		result.append("Geb.jahr: " + getGeburtsjahr());
		System.out.println(result.toString());
	}

	public void fresseHeu(int menge)
	{
		if (menge > 0)
		{
			gefressenHeu += menge;
		}
	}
	
	public void gibWasser(double menge) {
		if (menge > 0) wasser += menge;
	}
	public void melken()
	{
		int calcHeu = (gefressenHeu / 5);
		int calcWasser = (int) (wasser / 7.5);

		if (calcHeu > 0 && calcWasser > 0) {
			int mult = calcHeu > calcWasser ? calcWasser : calcHeu;
			milch = 0.5 * mult;
			wasser -= calcWasser * 7.5;
			gefressenHeu -= calcHeu * 5;
		}
	}

	public double getMilch() {
		return milch;
	}
}
