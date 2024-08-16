package com.vrsoftware.VR.Software.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.vrsoftware.VR.Software.services.ProdutoService;
import com.vrsoftware.VR.Software.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroProduto extends JFrame {

    @Autowired
    private ProdutoService produtoService;

    public void setProdutoService(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    private JTextField codigoField;
    private JTextField descricaoField;
    private JTextField precoField;
    private JButton saveButton;

    public CadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel codigoLabel = new JLabel("Código:");
        codigoField = new JTextField();

        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoField = new JTextField();

        JLabel precoLabel = new JLabel("Preço:");
        precoField = new JTextField();

        saveButton = new JButton("Salvar");
        saveButton.addActionListener(new SaveButtonListener());

        panel.add(codigoLabel);
        panel.add(codigoField);
        panel.add(descricaoLabel);
        panel.add(descricaoField);
        panel.add(precoLabel);
        panel.add(precoField);
        panel.add(new JLabel());
        panel.add(saveButton);

        add(panel);
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Validar campos
            String codigo = codigoField.getText().trim();
            String descricao = descricaoField.getText().trim();
            String precoText = precoField.getText().trim();

            if (codigo.isEmpty() || descricao.isEmpty() || precoText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                return;
            }

            Double preco;

            try {
                preco = Double.parseDouble(precoText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O campo 'Preço' deve ser um número válido.");
                return;
            }

            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setCodigo(codigo);
            produtoDTO.setDescricao(descricao);
            produtoDTO.setPreco(preco);

            try {
                produtoService.insert(produtoDTO);
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
            }
        }
    }

}
