package pachet;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main 
{
	static Scanner tast=new Scanner(System.in);
	public static void main(String[] args)
	{
		Validare();
	}
	public static String CitireNume()
	{
		String nume=tast.next();
		return nume;
	}
	public static int CitireNumar()
	{
		int nr=tast.nextInt();
		return nr;
	}
	public static void Cautare()
	{
		Agenda contact=new Agenda();
		System.out.println("1-Cautare dupa text introdus:");
		System.out.println("2-Cautare dupa numar introdsu:");
		int optiune=CitireNumar();
		switch(optiune)
		{
		case 1:
			System.out.println("Introduceti text de cautare:");
			String text=CitireNume();
			System.out.println(AgendaDao.findBy(contact, text));
			break;
		case 2:
			System.out.println("Introduceti numarul pt cautare:");
			int nr=CitireNumar();
			System.out.println(AgendaDao.findBy2(contact, nr));
			break;
		default:
			break;
		}
	}
	public static void Inserare()
	{
		Agenda contact=new Agenda();
		System.out.println("Introduceti nume:");
		contact.setNume(CitireNume());
		System.out.println("Introduceti prenume:");
		contact.setPrenume(CitireNume());
		System.out.println("Introduceti numar fix:");
		contact.setNumarfix(CitireNumar());
		System.out.println("Introduceti numar mobil:");
		contact.setNumarmobil(CitireNumar());
		System.out.println("Introduceti email:");
		contact.setEmail(CitireNume());
		AgendaDao.insert(contact);
		List<Agenda> lista = AgendaDao.cautareToti();
		System.out.println(lista);
	}

	public static void Stergere()
	{
		Agenda contact=new Agenda();
		System.out.println("Introduceti numele persoanei pe care vreti sa o stergeti impreuna cu prenumele ei:");
		String nume=tast.next();
		String prenume=tast.next();
		AgendaDao.stergere(contact, nume, prenume);
		List<Agenda> lista = AgendaDao.cautareToti();	
		System.out.println(lista);
	}
	public static void Meniu()
	{
		System.out.println(LocalDateTime.now());
		System.out.println("========================================");
		System.out.println("1-Inserati contact in agenda");
		System.out.println("2-Stergeti contact din agenda");
		System.out.println("3-Modificati contact");
		System.out.println("4-Cautare contact");
		System.out.println("5-Iesire");
	}
	public static void Validare()
	{
		int ok=0;
		while(ok==0)
		{
			Meniu();
			int optiune=CitireNumar();
			switch(optiune)
			{
			case 1:
				Inserare();
				break;
			case 2:
				Stergere();
				break;
			case 3:
				Modificare();
				break;
			case 4:
				Cautare();
				break;
			case 5:
				ok=1;
				break;
			default:
				break;
			}
		}
	}
	public static void Modificare()
	{
		Agenda contact=new Agenda();
		System.out.println("Introduceti nume,prenume la cine vreti sa modificati");
		String nume=tast.next();
		String prenume=tast.next();
		System.out.println("Introduceti numar fix nou:");
		contact.setNumarfix(CitireNumar());
		System.out.println("Introduceti numar mobil nou:");
		contact.setNumarmobil(CitireNumar());
		System.out.println("Introduceti email nou:");
		contact.setEmail(CitireNume());
		AgendaDao.modifcare(contact, nume, prenume);
		List<Agenda> lista = AgendaDao.cautareToti();	
		System.out.println(lista);
	}
}
