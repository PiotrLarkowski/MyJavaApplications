package PACKAGE;

import java.math.BigInteger;

import Baza.KluczRSA;
import Baza.User;


public class SzyfrowanieKluczem 
{
	private static BigInteger wynik, suma = BigInteger.valueOf(1);
	private static int licznik;
	private static String tekstTajny, tekstJawny;
	private static int ILP, IILP, ILOCZYN;
	private static BigInteger Iloczyn;
	
	public static BigInteger power_modulo_fast(BigInteger podstawa/*12*/, BigInteger potega/*53*/, BigInteger modulo/*7*/)
	{
		int licznik = 0;
		BigInteger i = BigInteger.valueOf(1);
		BigInteger result = BigInteger.valueOf(1);
		BigInteger x = podstawa.mod(modulo);
		int res = potega.compareTo(i), res2, res3; 
		
		do
		{
			licznik++;
			x = x.mod(modulo);
			res2 = potega.and(i).intValue();
			if (res2 != 0) 
			{
				result = result.multiply(x);
				result = result.mod(modulo);
			}
			i = i.multiply(BigInteger.valueOf(2));
			res = potega.compareTo(i);
			if(res == 1 && licznik == 33)
			{
				result = result.multiply(x);
				result = result.mod(modulo);
			}
			x = x.multiply(x);
			
		}
		while(res == 1);
		return result;
	}  
	
	public static BigInteger getIloczyn()
	{
		return(Iloczyn);
	}
	
	public static void setIloczyn(BigInteger a)
	{
		Iloczyn = a; 
	}
	
	public static String Deszyfrowanie(String TekstTajny, User person)
	{
//long czas1 = System.currentTimeMillis();	
		String LP = "", TekstTajny2 = "";
		int i, p =0, l;
		char znak;
		for (int j =0; j<TekstTajny.length(); j++)
		{
			if(TekstTajny.charAt(j) == 'l')
			{
				for(i = 0; i<j; i++)
				{
					LP = LP + TekstTajny.charAt(i);
				}
				for(int ii = i; ii<TekstTajny.length()-1; ii++)
				{
					znak = TekstTajny.charAt(ii+1);
					TekstTajny2 = TekstTajny2 + znak;
					p++;
				}
				break;
			}
		}
		TekstTajny = "";
		TekstTajny = TekstTajny2;
		
		BigInteger LiczbaPierwsza = new BigInteger(LP);  
		LP = "";
		TekstTajny2 = "";
		
		for (int j =TekstTajny.length()-1; j>0; j--)
		{
			if(TekstTajny.charAt(j) == 'l')
			{
				for(i = j+1; i<TekstTajny.length()-1; i++)
				{
					LP = LP + TekstTajny.charAt(i);
				}
				for(int ii = 0; ii<j; ii++)
				{
					znak = TekstTajny.charAt(ii);
					TekstTajny2 = TekstTajny2 + znak;
					p++;
				}
				break;
			}
		}
		TekstTajny = "";
		TekstTajny = TekstTajny2;
		BigInteger Roznica = new BigInteger(LP); 
//		BigInteger ILOCZYN = new BigInteger(person.getILOCZYN()).add(Roznica);
		BigInteger ILOCZYN = new BigInteger(String.valueOf(BigInteger.valueOf(0))).add(Roznica);

		BigInteger IILP = ILOCZYN.divide(LiczbaPierwsza);
		BigInteger LICZBAD = GeneratorKluczy.obliczamD(7, ((LiczbaPierwsza.subtract(BigInteger.valueOf(1))).multiply(IILP.subtract(BigInteger.valueOf(1)))));
//		System.out.println("U¿yto wartoœci do deszyfrowania: ILP: " + LiczbaPierwsza + " IILP: " + IILP + " Iloczyn: " + ILOCZYN + " LiczbaD: " + LICZBAD);
		
		tekstJawny = "";
		String blokInformacji;
		BigInteger odkodowanyZnak;
		for(int j =0; j<=TekstTajny.length()-String.valueOf(ILOCZYN).length(); j=j+String.valueOf(ILOCZYN).length())
		{
			
			blokInformacji = TekstTajny.substring(j,j+String.valueOf(ILOCZYN).length());
			odkodowanyZnak = BigInteger.valueOf(Long.valueOf(blokInformacji)).modPow(LICZBAD, ILOCZYN);
			tekstJawny = tekstJawny + (char)odkodowanyZnak.intValue();
		}
//long czas2 = System.currentTimeMillis();		
//long czas3 = czas2 - czas1;
//System.out.println("Czas deszyrowania wiadomoœci: " + czas3);
	return (tekstJawny);
}
	
	
	public static String Szyfrowanie(String TekstJawny, KluczRSA klucz)
	{
//		System.out.println("U¿yto klucza do szyfrowania: " + klucz.toString(klucz));
//long czas1 = System.currentTimeMillis();
		tekstTajny = klucz.getILiczbaPierwsza() + "l";
		for(int i =0; i<TekstJawny.length(); i++)
		{
			String a ="";
			boolean flaga = false;
			BigInteger x = power_modulo_fast(BigInteger.valueOf(TekstJawny.charAt(i)), BigInteger.valueOf(klucz.getE()), klucz.getIloczyn());	
			x = BigInteger.valueOf(TekstJawny.charAt(i)).pow(klucz.getE()).mod(klucz.getIloczyn());	
			a = x.toString();
			do
			{
				if(a.length()<String.valueOf(klucz.getIloczyn()).length())
				{
					a = "0" + a;
					flaga = true;
				}
			}while(a.length()!=String.valueOf(klucz.getIloczyn()).length());
			if(tekstTajny==null)
			{
				tekstTajny = tekstTajny + x.toString();;
			}
			else if (flaga == true)
			{
				tekstTajny = tekstTajny + a;
				flaga = true;
			}
			else 
			{
				tekstTajny = tekstTajny + x;
			}
		}
//long czas2 = System.currentTimeMillis();		
//long czas3 = czas2 - czas1;
//System.out.println("Czas szyrowania wiadomoœci: " + czas3);
		return(tekstTajny + "l" + klucz.getIloczyn2());
	}

}
