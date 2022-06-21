package Baza;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class KluczRSA 
{
	
	public BigInteger ILiczbaPierwsza; 
	public BigInteger IILiczbaPierwsza;
	public BigInteger Iloczyn;
	public int e;
	public BigInteger d;
	public BigInteger Iloczyn2;

	public BigInteger getIloczyn() {
		return Iloczyn;
	}

	public void setIloczyn(BigInteger mno¿oneLiczby) {
		Iloczyn = mno¿oneLiczby;
	}

	public BigInteger getIloczyn2() {
		return Iloczyn2;
	}

	public void setIloczyn2(BigInteger iloczyn2) {
		Iloczyn2 = iloczyn2;
	}
	
	public BigInteger getILiczbaPierwsza() {
		return ILiczbaPierwsza;
	}

	public void setILiczbaPierwsza(BigInteger iLiczbaPierwsza) {
		ILiczbaPierwsza = iLiczbaPierwsza;
	}

	public BigInteger getIILiczbaPierwsza() {
		return IILiczbaPierwsza;
	}

	public void setIILiczbaPierwsza(BigInteger iILiczbaPierwsza) {
		IILiczbaPierwsza = iILiczbaPierwsza;
	}


	public int getE() {
		return e;
	}

	public void setE(int kluczDeszyfruj¹cy) {
		this.e = kluczDeszyfruj¹cy;
	}

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger losowaLiczba) {
		d = losowaLiczba;
	}
	
	public KluczRSA()
	{}
	
	public KluczRSA(BigInteger IliczbaPierwsza, BigInteger IIliczbaPierwsza, BigInteger Iloczyn, int e, BigInteger d, BigInteger iloczyn2)
	{
		this.ILiczbaPierwsza = IliczbaPierwsza;
		this.IILiczbaPierwsza = IIliczbaPierwsza;
		this.Iloczyn = Iloczyn;
		this.e = e;
		this.d = d;
		this.Iloczyn2 = iloczyn2;
	}
	
	public String toString(KluczRSA klucz)
	{
		return("LP1 = " + klucz.getILiczbaPierwsza() + " LP2 = " + klucz.getIILiczbaPierwsza() + " Iloczyn = " +  klucz.getIloczyn() + " Liczba E = " +  klucz.getE() +" Liczba D = " +  klucz.getD() +" Ró¿nica = " +  klucz.getIloczyn2());
	}
//	public KluczRSA(int IliczbaPierwsza, int IIliczbaPierwsza, int pomno¿one, int deszyfrator, int losowa)
//	{
//		this.ILiczbaPierwsza = IliczbaPierwsza;
//		this.IILiczbaPierwsza = IIliczbaPierwsza;
//		this.Mno¿oneLiczby = pomno¿one;
//		this.kluczDeszyfruj¹cy = deszyfrator;
//		this.LosowaLiczba = losowa;
//	}
}
