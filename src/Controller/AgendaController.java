/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;


import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author anibal
 */
public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper; 

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    
    public void atualizaTabela(){
        //Buscar Lista com Agendamento do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        // exibir esta  lista na view
         helper.preencherTabela(agendamentos);
        
    }
    
    // jCombobox
    public void atualizaCliente(){
        //Buscar clientes do banco de dados
      ClienteDAO clienteDAO = new ClienteDAO();
       ArrayList<Cliente> clientes = clienteDAO.selectAll();
       
        // exibir clientes no jCombobox cliente
        helper.preencherClemntes(clientes);
    }
    
    public void atualizaServico(){
        
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        
        helper.preencherServicos(servicos);
        
    }
    
    public void atualizaValor(){
        
       Servico servico = helper.obterServico();
       
       helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        //Buscar Objeto Agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        //Salva Objeto no Banco de dados
        new AgendamentoDAO().insert(agendamento);
        
       // Correio correio = new Correio();
        //correio.notifyEmail(agendamento);
        //Inserir elemento na tabela
        atualizaTabela();
        
       helper.limparTela();
    }
}
