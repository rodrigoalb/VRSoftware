package com.vrsoftware.VR.Software.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.vrsoftware.VR.Software.services.ClienteService;
import com.vrsoftware.VR.Software.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelaInicial extends JFrame {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    public TelaInicial() {
        setTitle("Tela Inicial");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton produtoButton = new JButton("Cadastro de Produto");
        JButton clienteButton = new JButton("Cadastro de Cliente");

        produtoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroProduto cadastroProduto = new CadastroProduto();
                cadastroProduto.setProdutoService(produtoService);
                cadastroProduto.setVisible(true);
            }
        });

        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroCliente cadastroCliente = new CadastroCliente();
                cadastroCliente.setClienteService(clienteService);
                cadastroCliente.setVisible(true);
            }
        });

        panel.add(clienteButton);
        panel.add(produtoButton);

        add(panel);
    }

}