package PACKAGE;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import Baza.KluczRSA;
import Baza.User;

public class GeneratorKluczy 
{
	public static String Metoda, LewaGranica, PrawaGranica;
	public static int ostatnia;
	public static boolean blad = false;
	
	//-----------------------------------------------------------------------------------------
	
	private static final int powerOf2[] =
		{ 1<<0,  1<<1,  1<<2,  1<<3,  1<<4,  1<<5,  1<<6,
		1<<7,  1<<8,  1<<9,  1<<10, 1<<11, 1<<12, 1<<13,
		1<<14, 1<<15, 1<<16, 1<<17, 1<<18, 1<<19, 1<<20,
		1<<21, 1<<22, 1<<23, 1<<24, 1<<25, 1<<26, 1<<27,
		1<<28, 1<<29, 1<<30 };
	
	private static BigInteger power_modulo_fast2(BigInteger a, BigInteger b, BigInteger n)
	{
		BigInteger result = BigInteger.valueOf(1);
		
		BigInteger i = BigInteger.valueOf(0);
		
		BigInteger x = n.mod(a);
		
		int res = b.compareTo(i);
		for (i=BigInteger.valueOf(1); res == 1 || res == 0; i = i.multiply(BigInteger.valueOf(2)))
		{
			res = i.compareTo(BigInteger.valueOf(0)); 
			x = x.mod(n);
			res = b.and(i).compareTo(BigInteger.valueOf(0));
			if (res != 0)
			{
				result = result.multiply(x);
				result = result.mod(n);
			}
			x = x.multiply(x);
			res = b.compareTo(i);
		}
		return result;
	}
	
	public static int[] sitoEratotenesa(int n)
	{
		int i,w;
		int[] tablicaLiczbPierwszych = new int[n+1];
		boolean[] Tbarray = new boolean[n+1];
			  
		for (i = 2; i<= n; i++)
			Tbarray[i] = true;
		for (i = 2; i<= Math.round(Math.sqrt(n)); i++)
		{
		    if (Tbarray[i] )
		    {
		      w = i * i;
		      while (w <= n)
		      {
		    	  Tbarray[w] = false;
		    	  w=w+i;
		      }
		    }
		}
		int j = 0;
	    for (i = 2; i<= n; i++)
	   	{
	   		if (Tbarray[i])
	   		{
	   			tablicaLiczbPierwszych[j]=i;
	   			j++;
	   		}
	    }
	    ostatnia = j;
	    return(tablicaLiczbPierwszych);
	  }
	
	public static ArrayList<BigInteger> sprawdzaniePodzielnoœci(BigInteger prawaGranica)
	{
		int i/*u¿ywane przy numeracji podzielników*/,
		lp=0/*Bierz¹ca liczba*/;
		BigInteger n;
		
	    boolean t/*Liczba nadaje sie*/;
	    ArrayList<BigInteger> tlp = new ArrayList<BigInteger>(); /*tablica liczb pierwszych*/;
	BigInteger p=BigInteger.valueOf(2)/*Kolejno testowane liczby ierwsze*/,k=BigInteger.valueOf(1)/*u¿ywane do generacji liczb*/, d=BigInteger.valueOf(1)/*u¿ywane do generacji liczb*/;
	    double g/*Zawiera pierwiastek calkowity*/;
	    int res;
	    n = BigInteger.valueOf(1);
	    while (true)//res2 == 1)
	    {
	    	t = true;
	    	if (lp < 3)
	    	{
	    		p = p.add(BigInteger.valueOf(lp));
	    	}
	    	else
	    	{
	    		p = BigInteger.valueOf(6).multiply(k/*kolejne liczby pierwsze*/).add(d)/*stale zwiekszany licznik*/; //Pozbywanie siê wielokrotnoœci liczb 2,3,4...
	    		res = d.compareTo(BigInteger.valueOf(1));
	    	    if (res == 0)
	    	    {
	    	       d = BigInteger.valueOf(-1);
	    	       k = k.add(BigInteger.valueOf(1));
	    	    }
	    	    else
	    	    {
	    	    	d = BigInteger.valueOf(1);
	    	    }
	    	    g = Math.round(Math.sqrt(p.doubleValue()));
	    	    BigInteger kk = BigInteger.valueOf(1);
	    	    int res4 = tlp.get(2).compareTo(BigInteger.valueOf((long) g)); //Jezeli pierwsza wartosc jest wieksza od drugiej to wartosc res = 1 jezeli sa rowne to wartosc res = 0 a jezeli druga wartosc jest wieksza niz pierwsza to wartosc res = -1
	    	    for(i = 2; res4 == 0 || res4 == -1; i++)
	    	    {
	    	    	try
	    	        {
	    	    		kk = p.mod(tlp.get(i));
	    	    		res4 = tlp.get(i).compareTo(BigInteger.valueOf((long) g));
	    	        }
	    	        catch(Exception e)
	    	        {
	    	        	break;
	    	        }
	    	        if(kk.intValue() == 0)
	    	        {
	    	          t = false;
	    	          break;
	    	        }
	    	    }
	    	}
    	    if (t == true) 
    	    {
    			if(p.bitLength() == prawaGranica.intValue()+2)
    			{
    				break;
    			}
		    	tlp.add(p);
    			lp++;
    	    }
	    }
	    for(;;)
	    {
			if(tlp.get(0).bitLength() != prawaGranica.intValue())
			{
				tlp.remove(0);
		    }
			else
			{
				break;
			}
	    }
		return(tlp);
    }
	
	public static int AlgorytmEuklidesa(int a, int b)
	{
		if(a == 0)
		{
			return(b);
		}
		else if(b == 0)
		{
			return(a);
		}
		
		while(a!=b)
		{
			if(a == 1 || b == 1)
			{
				return(1);
			}
			if (a>b)
			{
				a = a-b;
			}
			else
			{
				b = b - a;
			}
		}	
		return(b);
	}
	
	public static BigInteger odwr_mod2(BigInteger e, BigInteger n)
	{
		BigInteger a0,n0,p0,p1,q,r,t, res2;
		int res3=1;
		do
		{
			boolean OK = false;
			
			p0 = BigInteger.valueOf(0); p1 = BigInteger.valueOf(1); a0 = e; n0 = n;
			q  = n0.divide(a0);
			r  = n0.mod(a0);
			int res = r.compareTo(BigInteger.valueOf(0));
			while(res > 0 && OK == false)
			{
			    t = p0.subtract(q.multiply(p1));
			    res = t.compareTo(BigInteger.valueOf(0));
			    if(res >= 0)
			    	t = t.mod(n);
			    else
			    {
			    	t = n.subtract(t.negate().mod(n));
			    }
		    p0 = p1; p1 = t;
		    n0 = a0; a0 = r;
		    q  = n0.divide(a0);
		    r  = n0.mod(a0);
		    res = r.compareTo(BigInteger.valueOf(0));
		    res2 = p1;
		    if(res2.multiply(e).mod(n) == BigInteger.valueOf(1))
		    {
		    	OK=true;
		    }
		    else
		    {
		    	OK = false;
		    }
		  }
		res = p1.compareTo(BigInteger.valueOf(1));
		}while(res3 == 0);
	  return p1;
	}
	
	private static boolean MillerRabin2(BigInteger n, BigInteger k)
	{
		
		Random rand = new Random();
		int s = 0;
		BigInteger s2 = BigInteger.valueOf(1);
		int a, i = 0, r, prime;
		BigInteger d;
		
		int res = n.compareTo(BigInteger.valueOf(4));
		if (res == -1)
		{
			return true;
		}
		
		res = n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0));
		if (res == 0)
		{
			return false;
		}
		
		//calculate s and d
		res = s2.and(n.subtract(BigInteger.valueOf(1))).compareTo(BigInteger.valueOf(0));
		while (res == 0)
		{
			s  += 1;
			s2 = s2.multiply(BigInteger.valueOf(2));
			res = s2.and(n.subtract(BigInteger.valueOf(1))).compareTo(BigInteger.valueOf(0));
		}
		d = n.divide(s2);
		
		//try k times
		BigInteger Bres;
		res = k.compareTo(BigInteger.valueOf(i));
		for (i=0; res == 1; i++)
		{
			int g = n.subtract(BigInteger.valueOf(1)).mod(BigInteger.valueOf(2147483647)).intValue();
			a = rand.nextInt(g) + 1;
			if (power_modulo_fast2(BigInteger.valueOf(a), d, n).intValue() != 1)
			{
				prime = 0;
				for (r=0; r<=s-1; r++)
				{
					if(r>30)
						break;
					Bres = power_modulo_fast2(BigInteger.valueOf(a), BigInteger.valueOf(powerOf2[r]).multiply(d), n);
					res = Bres.compareTo((n.subtract(BigInteger.valueOf(1))));
					if (res == 0)
					{
						prime = 1;
						break;
					}
				}
				if (prime == 0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static BigInteger obliczamD(int LiczbaE, BigInteger wspó³czynnikEulera)
	{
		BigInteger LiczbaD;
		LiczbaD = odwr_mod2(BigInteger.valueOf(LiczbaE),wspó³czynnikEulera);
		return(LiczbaD);
	}
	
	public static KluczRSA main(int bit, int AKTUALNY_User)//ParametryKlucza param) 
	{
		BigInteger ILOCZYN;
		BigInteger PierwszaLiczbaPierwsza;
		BigInteger DrugaLiczbaPierwsza;
		BigInteger ILOCZYN2;
		BigInteger LiczbaD;
		BigInteger AKT_ILOCZYN;
		int LiczbaE;
		User person1 = null;
		do
		{
			blad = false;
			AKT_ILOCZYN = BigInteger.valueOf(0);

//			Configuration configuration = new Configuration();
//			configuration.configure().addAnnotatedClass(User.class);
//			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//			SessionFactory factory = configuration.buildSessionFactory(registry);
//			Session session = factory.openSession();
//			ArrayList<User> lista = (ArrayList<User>) session.createCriteria(User.class).list();
//
//			for (int i=0; i<lista.size();i++)
//			{
//				person1 = (User) lista.get(i);
//				if(person1.getId() == AKTUALNY_User)
//				{
//					AKT_ILOCZYN = new BigInteger(person1.getILOCZYN());
//					break;
//				}
//			}
			
			Random rand = new Random();
			
			//-----------------------------------------------------------------------------------------
			
			int Bres;
			String okreslenieBitowosci = "1";
//			System.out.println(BigInteger.valueOf(2).pow(31));
//			System.out.println(BigInteger.valueOf(2).pow(32).bitLength());
			
			BigInteger a, maximum = BigInteger.valueOf(2).pow((bit)).subtract(BigInteger.valueOf(1)), minimum = BigInteger.valueOf(2).pow((bit-1));
			
//			System.out.println("Pirwszy rekord w tablicy: " + sum);
//			System.out.println("Pirwszy rekord w tablicy wartosc bitowa: " + sum.bitLength());
			
			ArrayList<BigInteger> tablicaLiczbPierwszych = new ArrayList<BigInteger>();
			
			Random rnd = new Random();
			
			BigInteger sum = BigInteger.valueOf(2).pow(bit-1);
			ostatnia = 10000;
			BigInteger iloscIteracji = BigInteger.valueOf(sum.bitLength()).multiply(BigInteger.valueOf(1000));
			long czas1 = System.currentTimeMillis();	
			do
			{
				a = new BigInteger(maximum.subtract(minimum).bitLength(), rnd).add(minimum);
				if (MillerRabin2(a, iloscIteracji))
				{
					tablicaLiczbPierwszych.add(a);
				}
			}while(tablicaLiczbPierwszych.size() < 2);
			long czas2 = System.currentTimeMillis();
			System.out.println("Czas wyszukiwania liczb: " + (czas2 - czas1));
			
			//---------------------------------- Wyznaczanie liczb Pierwszych
			
			PierwszaLiczbaPierwsza = tablicaLiczbPierwszych.get(0);
			DrugaLiczbaPierwsza = tablicaLiczbPierwszych.get(1);
			
//			PierwszaLiczbaPierwsza = BigInteger.valueOf(11); //52051
//			DrugaLiczbaPierwsza = BigInteger.valueOf(13); //119657
	
			//---------------------------------- Wyznaczanie liczby e - Klucz Szyfruj¹cy. Wzglêdnie pierwsza z ( p - 1) * ( q - 1 )  
			BigInteger wspó³czynnikEulera = BigInteger.valueOf(0);
			LiczbaE = 7;

			wspó³czynnikEulera = (PierwszaLiczbaPierwsza.subtract(BigInteger.valueOf(1))).multiply(DrugaLiczbaPierwsza.subtract(BigInteger.valueOf(1)));
			
			czas1 = System.currentTimeMillis();	
			
			LiczbaD = obliczamD(LiczbaE, wspó³czynnikEulera);
			
			czas2 = System.currentTimeMillis();
//			System.out.println("Obliczanie wartoœci d: " + (czas2 - czas1));
			
			int res = LiczbaD.compareTo(BigInteger.valueOf(1));
			if(res == 0)
			{
				blad = true;
			}
		}while(blad == true);
		
		ILOCZYN = (PierwszaLiczbaPierwsza.multiply(DrugaLiczbaPierwsza));
		int res;
		res = ILOCZYN.compareTo(AKT_ILOCZYN);
		if (res == 1)
		{
			ILOCZYN2 = ILOCZYN.subtract(AKT_ILOCZYN);
		}
		else
		{
//			Configuration configuration = new Configuration();
//			configuration.configure().addAnnotatedClass(User.class);
//			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//			SessionFactory factory = configuration.buildSessionFactory(registry);
//			Session session = factory.openSession();
//			person1.setILOCZYN("1");
//			session.update(person1);
			ILOCZYN2 = ILOCZYN2 = ILOCZYN.subtract(AKT_ILOCZYN);
		}

		KluczRSA klucz = new KluczRSA(PierwszaLiczbaPierwsza, DrugaLiczbaPierwsza, ILOCZYN,LiczbaE,LiczbaD, ILOCZYN2);
		System.out.println(klucz.toString(klucz));
		return(klucz);
	}
}

