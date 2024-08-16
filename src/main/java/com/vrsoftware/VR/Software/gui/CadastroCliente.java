package com.vrsoftware.VR.Software.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.vrsoftware.VR.Software.dto.ClienteDTO;
import com.vrsoftware.VR.Software.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroCliente extends JFrame {

    @Autowired
    private ClienteService clienteService;

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    private JTextField codigoField;
    private JTextField nomeField;
    private JTextField limiteCompraField;
    private JTextField fechamentoFaturaField;
    private JButton saveButton;

    public CadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel codigoLabel = new JLabel("Código:");
        codigoField = new JTextField();

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();

        JLabel limiteCompraLabel = new JLabel("Limite de Compra:");
        limiteCompraField = new JTextField();

        JLabel fechamentoFaturaLabel = new JLabel("Dia de Fechamento:");
        fechamentoFaturaField = new JTextField();

        saveButton = new JButton("Salvar");
        saveButton.addActionListener(new SaveButtonListener());

        panel.add(codigoLabel);
        panel.add(codigoField);
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(limiteCompraLabel);
        panel.add(limiteCompraField);
        panel.add(fechamentoFaturaLabel);
        panel.add(fechamentoFaturaField);
        panel.add(new JLabel());
        panel.add(saveButton);

        add(panel);
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Validar campos
            String codigo = codigoField.getText().trim();
            String nome = nomeField.getText().trim();
            String limiteCompraText = limiteCompraField.getText().trim();
            String fechamentoFaturaText = fechamentoFaturaField.getText().trim();

            if (codigo.isEmpty() || nome.isEmpty() || limiteCompraText.isEmpty() || fechamentoFaturaText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                return;
            }

            Double limiteCompra;
            Integer fechamentoFatura;

            try {
                limiteCompra = Double.parseDouble(limiteCompraText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O campo 'Limite de Compra' deve ser um número válido.");
                return;
            }

            try {
                fechamentoFatura = Integer.parseInt(fechamentoFaturaText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O campo 'Dia de Fechamento' deve ser um número válido.");
                return;
            }

            ClienteDTO cliente = new ClienteDTO();
            cliente.setCodigo(codigo);
            cliente.setNome(nome);
            cliente.setLimiteCompra(limiteCompra);
            cliente.setFechamentoFatura(fechamentoFatura);

            try {
                clienteService.insert(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + ex.getMessage());
            }
        }
    }
}
