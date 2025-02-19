/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PEDROHENRIQUECAUSSIP
 */
public class InserirUsuario {
    public static boolean inserirUsuario(Connection conexao,String nome,String senha){
        String sqlCheck = "SELECT * FROM usuarios WHERE nome = ?";
        String sqlInsert = "INSERT INTO usuarios (nome,senha) VALUES(?,?)";
        
        try (PreparedStatement checkStmt = conexao.prepareStatement(sqlCheck)){
            checkStmt.setString(1,nome);
            ResultSet rs =checkStmt.executeQuery();
            
            if(rs.next()){
                System.out.println("Usuario Ja Existe");
                return false;
            }
            try(PreparedStatement insertStmt = conexao.prepareStatement(sqlInsert)){
            insertStmt.setString(1,nome);
            insertStmt.setString(2,senha);
            return true;
        } 
    } catch (Exception e) {
       System.out.println("Erro:" + e.getMessage());
    }
        return false;
    }
    
}

