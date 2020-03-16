package pachet;

public class Agenda 
{
	private String nume;
	private String prenume;
	private int numarfix;
	private int numarmobil;
	private String email;
	public String getNume()
	{
		return nume;
	}
	public String getNume(String nume)
	{
		return nume;
	}
	public void setNume(String nume)
	{
		this.nume = nume;
	}
	public String getPrenume()
	{
		return prenume;
	}
	public String getPrenume(String prenume)
	{
		return prenume;
	}
	public void setPrenume(String prenume) 
	{
		this.prenume = prenume;
	}
	
	public int getNumarfix() 
	{
		return numarfix;
	}
	public void setNumarfix(int numarfix) 
	{
		this.numarfix = numarfix;
	}
	public int getNumarmobil() 
	{
		return numarmobil;
	}
	public void setNumarmobil(int numarmobil)
	{
		this.numarmobil = numarmobil;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Agenda [nume=");
		builder.append(nume);
		builder.append(", prenume=");
		builder.append(prenume);
		builder.append(",numarfix=");
		builder.append(numarfix);
		builder.append(",numarmobil=");
		builder.append(numarmobil);
		builder.append(",email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	

}
