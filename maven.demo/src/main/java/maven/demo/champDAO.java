package maven.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class champDAO 
{
	private Connection conexao;
	
	public champDAO()
	{
		conexao = null;
	}
	
	public boolean conectar()
	{
		String driverName = "org.postgresql.Driver";
		String serverName = "localhost";
		String mydatabase = "league_champs";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
		String username = "xdgg";
		String password = "123";
		boolean status = false;
		
		try
		{
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexao efetuada com postgres!");
		}
		catch(ClassNotFoundException e) 
		{
			System.err.println("Conexao NAO efetuada com postgres -- Driver nao encontrado -- "+ e.getMessage());
		}
		catch(SQLException e)
		{
			System.err.println("Conexao NAO efetuada com postgres -- " + e.getMessage());
		}
		
		return status;
	}
	
	public boolean close()
	{
		boolean status = false;
		
		try
		{
			conexao.close();
			status = true;
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirChamp (Champ champ)
	{
		boolean status = false;
		
		try
		{
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO champs (id, name, classe, price) "
					+ "VALUES ("+champ.getId() + ", '" + champ.getName() + "', '"
					+ champ.getClasse() + "', '" + champ.getPrice() + " ');");
			
			st.close();
			status = true;
		}
		catch(SQLException u)
		{
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirChamp (int id)
	{
		boolean status = false;
		
		try
		{
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM champs WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		}
		catch(SQLException u)
		{
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean updateChamp (Champ champ)
	{
		boolean status = false;
		try
		{  
			Statement st = conexao.createStatement();
			String sql = "UPDATE champs SET name = '" + champ.getName() + "', classe = '"  
				       + champ.getClasse() + "', price = '" + champ.getPrice() + "'"
					   + " WHERE id = " + champ.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		}
		catch (SQLException u)
		{  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public List<Champ> get(String orderBy)
	{	
		
	    List<Champ> champs = new ArrayList<Champ>();

	    try 
	    {
	        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        String sql = "SELECT * FROM champs" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
	        System.out.println(sql);
	        ResultSet rs = st.executeQuery(sql);
	        
	        while (rs.next()) {
	            Champ champ = new Champ(rs.getInt("id"), rs.getString("name"), rs.getString("classe"), rs.getString("price"));
	            champs.add(champ);
	        }
	        rs.close();
	        st.close();
	    }
	    catch (Exception e)
	    {
	        System.err.println(e.getMessage());
	    }

	    return champs;
	}
	
}
