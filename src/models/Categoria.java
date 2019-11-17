package src.models;
<<<<<<< HEAD
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import src.models.comun.DbObject;

public class Categoria extends DbObject { 

	private Integer id;
	private Date created;
	private String nombre;
	
	@Override
	public Integer getId() {
		return id;
	}
	private void setId(Integer id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	private void setCreated(Date created) {
		this.created = created;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
	@Override
	public String toString() {
		return this.getValues();
	}
	
	@Override
	public String getTable() {
		return "categorias";
	}
	@Override
	public String getCampos() {  
		return getCorrectCampos(null, "nombre", this.nombre);
	}
	@Override
	public String getValues() {
		return getCorrectValues(null, this.nombre);		
	} 
	
	@Override
	public DbObject getDbObject(ResultSet res) throws SQLException {
		Categoria item = new Categoria();
		item.setId( res.getInt("id") ); 
		
		int created = res.getInt("created");
		Date date = new Date(created);		
		item.setCreated( date );
		item.setNombre( res.getString("nombre") ); 
		
		return item;
	}
	
	@Override
	public boolean isNew() {
		return (this.id == null);
	}
=======

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Categoria {

	private Integer id;
	private Date created;
	private String nombre;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public static boolean saveDb(Connection con, String nombre) { 
		
		try {
			
			Statement statemnt = con.createStatement();
			
			String sql = "select * from categorias where nombre = '"+nombre+"'";
			ResultSet res = statemnt.executeQuery(sql);
			if (res.next()) {
				System.out.println("Categoria "+nombre+" Ya Existe");
				return false;
			}
			
			String insertar = "INSERT INTO 'categorias' ('nombre') VALUES ('"+nombre+"');";
			statemnt.execute(insertar);
		 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		System.out.println("Categoria "+nombre+" Insertada");
		return true;
	}
	
	
>>>>>>> branch 'master' of https://github.com/FoxAstur/DAM-PR01.git
	
}
