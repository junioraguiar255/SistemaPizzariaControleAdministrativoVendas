package br.pizza.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
//Classe para efetuar conexão com o banco, (SQL SERVER)
	
	public static Connection conector() {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=Nomedobanco";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
					
					Connection conn = DriverManager.getConnection(connectionUrl,"Usuario","Senha");
					return conn;
		}catch(SQLException ex){
			/*JOptionPane.showMessageDialog(null, ex.getMessage());
			System.out.println(ex.getMessage());
			System.out.println(ex.getSQLState());
			System.out.println(ex.getErrorCode());*/
		}catch(Exception e) {
			/*JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println("Não conectou" + e);*/
		}
		return null;
		
	}
	
	
}
