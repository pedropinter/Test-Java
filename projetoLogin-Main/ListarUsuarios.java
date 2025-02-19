/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PEDROHENRIQUECAUSSIP
 */
public class ListarUsuarios {
    public static String listarUsuarios(Connection conexao){
        String textoUsuarios = "";
        String sql = "SELECT * FROM usuarios";
        
        try(Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            textoUsuarios += "ID | NOME | EMAIL\n";
            textoUsuarios += "-----------------------\n";
            
            while(rs.next()){
              int id = rs.getInt("id");
              String nome = rs.getString("nome");
              String email = rs.getString("senha");
                
              textoUsuarios += id + "|"+nome+"|"+email+"\n";
            }
        }catch (Exception e){
            textoUsuarios += "Erro ao listar Usuarios"+ e.getMessage();
        }
        return textoUsuarios;
    }
}

