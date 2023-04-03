/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anibal
 */
public class AgendaHelper implements IHelper{
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        
       DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
       tableModel.setNumRows(0);
       
       //percorrer a lista preenchendo o table model
        for (Agendamento agendamento : agendamentos) {
            
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
                
            });
            
        }

    }
 
    public void preencherClemntes(ArrayList<Cliente> clientes) {
        
      DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getJComboboxCliente().getModel();
      
        for (Cliente cliente : clientes) {
            
            comboBoxModel.addElement(cliente); 
            
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
        
          DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getJComboBoxServico().getModel();
          for (Servico servico : servicos) {
              comboBoxModel.addElement(servico);
            
        }
    }
    
     public Cliente obterCliente() {
        
        return (Cliente) view.getJComboboxCliente().getSelectedItem();
        
    }

    public Servico obterServico() {
        
        return (Servico) view.getJComboBoxServico().getSelectedItem();
        
    }

    public void setarValor(float valor) {
        
        view.getTextValor().setText(valor +"");

    }

    @Override
    public Agendamento obterModelo() {
        
        String idString = view.getTextId().getText();
        int id= Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getTextFormatedData().getText();
        String hora = view.getTextFormatedHora().getText();
        String dataHora = data + " " +hora;
        String observacao = view.getTextObservacao().getText();
        
       Agendamento agendamento = new Agendamento (id, cliente, servico, valor, dataHora, observacao);
       return agendamento;
       

    }

    @Override
    public void limparTela() {
        view.getTextId().setText("0");
        view.getTextFormatedData().setText("");
        view.getTextFormatedHora().setText("");
        view.getTextObservacao().setText("");
    }
    
    
    

}
