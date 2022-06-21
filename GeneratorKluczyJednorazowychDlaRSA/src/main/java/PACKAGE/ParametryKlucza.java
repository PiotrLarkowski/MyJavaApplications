package PACKAGE;
public class ParametryKlucza 
{
	public String Metoda,lewaGranica, prawaGranica;
	
	public String getMetoda() {
		return Metoda;
	}

	public void setMetoda(String metoda) {
		Metoda = metoda;
	}

	public String getLewaGranica() {
		return lewaGranica;
	}

	public void setLewaGranica(String lewaGranica) {
		this.lewaGranica = lewaGranica;
	}

	public String getPrawaGranica() {
		return prawaGranica;
	}

	public void setPrawaGranica(String prawaGranica) {
		this.prawaGranica = prawaGranica;
	}

	public ParametryKlucza(String Metoda, String lewaGranica2, String prawaGranica2)
	{
		this.lewaGranica = lewaGranica2;
		this.prawaGranica = prawaGranica2;
		this.Metoda = Metoda;
	}
//	public static void main(String[] args)
//	{
//		ParametryKlucza param = new ParametryKlucza("Losowa", "0", "10");
//		System.out.println(param.getMetoda());

}
//	}
