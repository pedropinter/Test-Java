/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PEDROHENRIQUECAUSSIP
 */
public class Login {
    public static boolean validarLogin(String usuario, String senha){
        String sql = "SELECT senha FROM usuarios WHERE nome = ?";
        
        try(Connection conn = new ConexaoSQLite().conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,usuario);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                String senhaArmazenada = rs.getString("senha");
                
                if(senha.equals(senhaArmazenada)){
                    System.out.println("Usuario encontrado. Login realizado com sucesso");
                    return true;
            } else{
                    System.out.println("Senha Incorreta");
                }
        }else{
                System.out.println("Usuario nao encontrado");
            }
    } catch(SQLException e){
        System.out.println("Erro ao Validar login"+e.getMessage());
    }
        return false;
}
    
}