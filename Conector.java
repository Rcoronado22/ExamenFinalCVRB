import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector {
 // Atributos de la clase
	private static Connection con;
	private static Conector INSTANCE = null;
	
	private Conector() {
		
	}
	// Crear Instancia
	private synchronized static void  crearInstancia() {
		if(INSTANCE == null) {
			INSTANCE =new Conector();
			crearConexion();
		}
	}
	
	// Obtener Instancia
	
	public static Conector getInstancia() {
		if(INSTANCE == null) {
			crearInstancia();
		}
		return INSTANCE;
	}
	// Crear Conexion
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "root";
		String password = "Judokas2205"; // Poner su contraseña
		String dataBase = "foody";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlConexion = "jdbc:mysql://"+host+"/"+dataBase+"?user="+user+"&password="+password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Lo lograste :') ");
		}catch (Exception e) {
			System.out.println("Error al conectar a la base de datos");
			System.out.println(e);
		}
		
	}
	public ArrayList<String> getOrder() throws SQLException  {
		ArrayList<String> listaorders = new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement("select order_id\r\n" + 
				"from customer\r\n" + 
				"inner join orders\r\n" + 
				"on customer.customer_id=orders.customer_id\r\n" + 
				"where  customer.email_id like '%12%'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaorders.add(rs.getString("order_id"));
			
		}
		rs.close();
		return listaorders;
	}
	public ArrayList<String> getNombre() throws SQLException  {
		ArrayList<String> listanombre = new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement("select distinct first_name,last_name,card_number\r\n" + 
				"from customer\r\n" + 
				"inner join payment_details\r\n" + 
				"on customer.customer_id=payment_details.customer_id\r\n" + 
				"where  payment_details.exp_year = '22'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listanombre.add(rs.getString("first_name"));
			listanombre.add(rs.getString("last_name"));
			listanombre.add(rs.getString("card_number"));
		}
		rs.close();
		return listanombre;
	}
	public ArrayList<String> getMenu() throws SQLException  {
		ArrayList<String> listamenu = new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement("select distinct menu_name,price\r\n" + 
				"from menu\r\n" + 
				"inner join orders on orders.menu_id=menu.menu_id\r\n" + 
				"left join payment on payment.order_id= orders.order_id\r\n" + 
				"where payment.payment_type = 'CASH_ON_DELIVERY'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listamenu.add(rs.getString("menu_name"));
			listamenu.add(rs.getString("price"));
		
		}
		rs.close();
		return listamenu;
	}
	
		
	
	
		
	
	
}
