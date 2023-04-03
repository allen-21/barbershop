/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author anibal
 */
public class Main {
    
    public static void main(String[] args){
        Servico barba = new Servico(1,"barba",30);
        
        
        System.out.println(barba.getDescricao()); 
        
        Cliente cliente = new Cliente(4, "allen", "geroge", "56455");
        System.out.println(cliente.getNome());
         
        Usuario usuario = new Usuario(1, "bla", "sasa");
        System.out.println(usuario.getNome());
        
        Agendamento agendamento = new Agendamento(40, cliente, barba, 40, "16/10/2023 09:15");
        System.out.println(agendamento.getCliente().getNome());
       
    }
    
}
