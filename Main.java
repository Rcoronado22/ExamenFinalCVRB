import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("Probando");
		Conector instancia = Conector.getInstancia();
		try {
			ArrayList<String> listaOrders = instancia.getOrder();
			ArrayList<String> listanames = instancia.getNombre();
			ArrayList<String> listamenu = instancia.getMenu();
			System.out.println( "Orders: Id ");
			System.out.println("----------------");
			
			for(String company:listaOrders) {
				System.out.println(company);
			}	
			
			
			System.out.println("----------------");
			System.out.println();
				System.out.println(" Nombre     y          Nro tarjeta");
				System.out.println("----------------");
				
				int count=0;
				for(String nombredelclienteynumerodetarjeta: listanames) {
				  System.out.print(nombredelclienteynumerodetarjeta + " ");
					count++;
	        
					if(count==3) {
						System.out.println();
						count=0;
					}
				}
				
				System.out.println("----------------");
				System.out.println();
				System.out.println();
					System.out.println(" Nombremenu      y          precio");
					System.out.println("----------------");
				
					int count2=0;
					for(String nombremenuyprecio: listamenu) {
					  System.out.print(nombremenuyprecio + " ");
						count2++;
		        
						if(count2==1) {
							System.out.println();
							count2=0;
						}
					
					}
				
			}
	
			catch(SQLException e){
			e.printStackTrace();
		}
	}

}
