package pachet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class AgendaDao 
{

	public static void insert(Agenda agenda)
	{

		Connection con=null;
		try {
			con = DBConector.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO agenda( nume, prenume,numarfix,numarmobil,email) VALUES(?,?,?,?,?)");
			ps.setString(1,agenda.getNume());
			ps.setString(2, agenda.getPrenume());
			ps.setInt(3, agenda.getNumarfix());
			ps.setInt(4, agenda.getNumarmobil());
			ps.setString(5, agenda.getEmail());
			ps.executeUpdate();

			ps.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}

	}
	public static List<Agenda> cautareToti()
	{

		List<Agenda> lista = new ArrayList<>();

		Connection con=null;
		try {
			con = DBConector.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM agenda ORDER BY Nume, Prenume");

			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{

				Agenda s = new Agenda();
				s.setNume(rs.getString("Nume"));
				s.setPrenume(rs.getString("Prenume"));
				s.setNumarfix(rs.getInt("Numarfix"));
				s.setNumarmobil(rs.getInt("Numarmobil"));
				s.setEmail(rs.getString("Email"));
				lista.add(s);

			}

			rs.close();
			ps.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}	

		return lista;
	}
	public static void stergere(Agenda agenda,String nume,String prenume)
	{

		Connection con=null;

		try {
			con = DBConector.getConnection();

			PreparedStatement ps = con.prepareStatement("DELETE FROM agenda WHERE Nume =? and Prenume=?");
			ps.setString(1,agenda.getNume(nume));
			ps.setString(2,agenda.getPrenume(prenume));
			ps.executeUpdate(); 

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}
	public static void modifcare(Agenda agenda,String nume,String prenume)
	{

		Connection con=null;
		try {
			con = DBConector.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE agenda SET numarfix=?,numarmobil=?,email=? where nume=? and prenume=?");
			ps.setInt(1, agenda.getNumarfix());
			ps.setInt(2, agenda.getNumarmobil());
			ps.setString(3, agenda.getEmail());
			ps.setString(4,agenda.getNume(nume));
			ps.setString(5, agenda.getPrenume(prenume));
			ps.executeUpdate();
			ps.close();

		} catch (Exception e)
		{
			System.out.println("Exception: " + e);
		} finally 
		{
			try {
				con.close();
			} 
			catch (Exception e) 
			{

			}
		}

	}
	public static Agenda findBy(Agenda agenda,String caracter)
	{
		Agenda s = null;
		Connection con=null;
		try {
			con = DBConector.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM agenda WHERE nume=? OR prenume=? OR email=?");
			ps.setString(1,caracter);
			ps.setString(2, caracter);	
			ps.setString(3, caracter);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) 
			{
				s = new Agenda();
				s.setNume(rs.getString("nume"));
				s.setPrenume(rs.getString("prenume"));
				s.setNumarfix(rs.getInt("numarfix"));
				s.setNumarmobil(rs.getInt("numarmobil"));
				s.setEmail(rs.getString("email"));	
			}

			rs.close();
			ps.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				con.close();
			} catch (Exception e) 
			{
			}
		}	

		return s;

	}
	public static Agenda findBy2(Agenda agenda,int numar)
	{
		Agenda s = null;
		Connection con=null;
		try {
			con = DBConector.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM agenda WHERE numarfix=? OR numarmobil=?");
			ps.setInt(1,numar);
			ps.setInt(2, numar);	
			ResultSet rs = ps.executeQuery();
			if (rs.next()) 
			{
				s = new Agenda();
				s.setNume(rs.getString("nume"));
				s.setPrenume(rs.getString("prenume"));
				s.setNumarfix(rs.getInt("numarfix"));
				s.setNumarmobil(rs.getInt("numarmobil"));
				s.setEmail(rs.getString("email"));	
			}

			rs.close();
			ps.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				con.close();
			} catch (Exception e) 
			{
			}
		}	

		return s;

	}


}
