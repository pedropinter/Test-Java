/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author PEDROHENRIQUECAUSSIP
 */
public class AtualizarUsuarios {
    public static void atualizarUsuarios(Connection conexao,int id,String novoNome,String novoEmail){
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
        try {
            try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
                pstmt.setString(1,novoNome);
                pstmt.setString(2,novoEmail);
                pstmt.setInt(3,id);
                
                int rowsUpdated = pstmt.executeUpdate();
                
                if(rowsUpdated>0){
                    System.out.println("Usuario Atualizado com sucesso");
                }else{
                    System.out.println("Nenhum Usuario encontrado com sucesso");
                }
            }catch (Exception e){
                System.out.println("Erro ao atualizar o usuario"+e.getMessage());
            }
        } catch (Exception e){
            System.out.println("Erro ao conectar ou executar SQL"+e.getMessage());
        }
    }
}
