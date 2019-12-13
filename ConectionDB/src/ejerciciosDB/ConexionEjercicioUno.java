package ejerciciosDB;
import java.sql.*;
public class ConexionEjercicioUno {

	public static void main(String[] args) {
		
	//url de la base de datos
	String url="jdbc:mysql://localhost:3306/informatica";
	
	try {
		//referencia al jdbc driver que utilizamos
		Class.forName("com.mysql.cj.jdbc.Driver");
		//creamos coneccion 
		Connection conexion=(Connection)DriverManager.getConnection(url, "root", "Noe420472");
		//creamos un statement
		Statement instruccion=conexion.createStatement();
		
		//sentencia sql
		
		String sql="select * from articulos";
		
		//creamos un objeto resultado para usar el metodo executequery o executeupdate
		
		ResultSet result=instruccion.executeQuery(sql);
		
		//recorremos la base de datos y la mostramos
		while(result.next()) {
			
			int codigo=result.getInt(1);
			String nombre=result.getString(2);
			Double precio=result.getDouble(3);
			int fabricante=result.getInt(4);
			
			
			/*System.out.println("codigo: " +result.getInt(1));
			System.out.println("nombre: " +result.getString(2));
			System.out.println("Precio: "+result.getDouble(3));
			System.out.println("Fabricante: "+result.getInt(4));*/
			
			System.out.println(" codigo: "+codigo+"\n nombre: "+nombre+"\n precio: "+precio+"\n fabricante: "+fabricante);
			
		}
		//cerramos muestra intrucion statement yconeccion
		result.close();
		instruccion.close();
		conexion.close();
	}
	catch(ClassNotFoundException | SQLException e ) {
		e.printStackTrace();
	}
}}
