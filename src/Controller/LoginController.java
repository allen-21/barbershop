/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author anibal
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void entrarNoSistema() {
        //Pegar o usuario da view
        Usuario usuario = helper.obterModelo();

        //Pesquisar o usuario no banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
  //Se o usaurio da view estiver no banco redciona para o menu
        //senao mostrar uma mensagem ao usuario "usuario ou senha invalidos"
        if (usuarioAutenticado != null) {
            //navegar para o menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else {
            view.exibeMensagem("Usuario ou senha invalido");
        }
      

    }

    public void FizTarefa() {
        System.out.println("Busquei algo do banco de dados");

        this.view.exibeMensagem("Executei o fiz tarefa");
    }

}
