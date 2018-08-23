
package br.com.senac.agenda.dao;

import java.sql.*;

/* 3 passos

1- Carregar driver
2- Conectar com o banco
3- Devolver a coneção
*/

public class Conexao {
    
    //interface de login do banco referente
    private static final String URL = "jdbc:mysql://localhost:3306/agenda";
    private static final String USER = "root";    
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    
    public static Connection getConnection(){
        
        Connection connection = null;
        
        //3 passos
        
        try{
            //carregar driver
            Class.forName(DRIVER);
            
            //conectar com o banco
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println("Conectado");
            
        }catch (ClassNotFoundException ex){
            
            System.out.println("Não foi possível carregar o driver.");      
        
        }catch (SQLException ex){
           
            System.out.println("Não foi possível conectar ao banco.");       
            
        }
        
        //devolver conexao
        return connection;
    
    
    
}
    
    
    public static void main(String[] args){
               
        Conexao.getConnection();
    }
    
    
}

