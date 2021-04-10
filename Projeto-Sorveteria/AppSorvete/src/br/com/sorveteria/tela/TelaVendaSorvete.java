package br.com.sorveteria.tela;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import br.com.sorveteria.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaVendaSorvete extends javax.swing.JInternalFrame {

    /*Criando variaveis especiais para conexão com o banco de dados
      PreparedStatement e ResultSet são frameworks do pacote java.sql
      e serve para preparar e executar as instruções sql
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaVendaSorvete() {
        initComponents();
        // fazendo a coneão com o banco de dados
        conexao = ModuloConexao.conector();
    }

    //método para pesquisar clientes pelo nome com filtro
    private void pesquisar_cliente() {
        String sql = "SELECT codigo_cliente as Código, nome_cliente as Nome, setor as Setor FROM tb_clientes where nome_cliente like ?";
        try {
            pst = conexao.prepareStatement(sql);
            //Passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao % -  continuação da String sql
            pst.setString(1, txtPesqCliente.getText() + "%");
            rs = pst.executeQuery();
            // A linha abaixo usa a rs2xml.jar para preencher a tabela
            tblCliente.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //método para pesquisar sorvetes pelo nome com filtro
    private void pesquisar_sorvete() {
        String sql = "SELECT codigo_sorvete as Código, descricao as Descrição, preco as Preço FROM tb_sorvetes WHERE descricao like ?";
        try {
            pst = conexao.prepareStatement(sql);
            //Passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao % -  continuação da String sql
            pst.setString(1, txtPesqSorvete.getText() + "%");
            rs = pst.executeQuery();
            // A linha abaixo usa a rs2xml.jar para preencher a tabela
            tblSorvete.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void setar_campo_id_cliente() {
        int setar = tblCliente.getSelectedRow();
        txtIdCliente.setText(tblCliente.getModel().getValueAt(setar, 0).toString());
    }
    private void setar_campo_id_sorvete() {
        int setar = tblSorvete.getSelectedRow();
        txtIdSorvete.setText(tblSorvete.getModel().getValueAt(setar, 0).toString());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblOS = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtOS = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        rbVendaSorvete = new javax.swing.JRadioButton();
        jPanelSorvete = new javax.swing.JPanel();
        txtPesqSorvete = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSorvete = new javax.swing.JTable();
        txtIdSorvete = new javax.swing.JTextField();
        lblSituacao = new javax.swing.JLabel();
        cboSituacao = new javax.swing.JComboBox<>();
        jPanelCliente = new javax.swing.JPanel();
        txtPesqCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblcodigo2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        txtIdCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnVendaAdicionar = new javax.swing.JButton();
        btnVendaPesquisar = new javax.swing.JButton();
        btnVendaAlterar = new javax.swing.JButton();
        btnVendaRemover = new javax.swing.JButton();
        btnVendaImprimir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtValTotal = new javax.swing.JFormattedTextField();
        txtQtdSorvetes = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Venda de Sorvetes");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblOS.setText("N° OS");

        lblData.setText("Data");

        txtOS.setEnabled(false);

        txtData.setEnabled(false);

        buttonGroup1.add(rbVendaSorvete);
        rbVendaSorvete.setText("Venda de Sorvete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbVendaSorvete, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOS)
                            .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblData)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOS)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rbVendaSorvete)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanelSorvete.setBorder(javax.swing.BorderFactory.createTitledBorder("Sorvetes"));

        txtPesqSorvete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesqSorveteKeyPressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/zoom.png"))); // NOI18N

        lblcodigo.setText("*Código");

        tblSorvete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Matricula"
            }
        ));
        tblSorvete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSorveteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSorvete);

        javax.swing.GroupLayout jPanelSorveteLayout = new javax.swing.GroupLayout(jPanelSorvete);
        jPanelSorvete.setLayout(jPanelSorveteLayout);
        jPanelSorveteLayout.setHorizontalGroup(
            jPanelSorveteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSorveteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSorveteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSorveteLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelSorveteLayout.createSequentialGroup()
                        .addComponent(txtPesqSorvete, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdSorvete, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(16, 16, 16))))
        );
        jPanelSorveteLayout.setVerticalGroup(
            jPanelSorveteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSorveteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSorveteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPesqSorvete)
                    .addGroup(jPanelSorveteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblcodigo)
                        .addComponent(txtIdSorvete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblSituacao.setText("Situação:");

        cboSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Pago" }));

        jPanelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        txtPesqCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqClienteKeyReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/zoom.png"))); // NOI18N

        lblcodigo2.setText("*Código");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Matricula"
            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCliente);

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(txtPesqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcodigo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addGap(16, 16, 16))))
        );
        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPesqCliente)
                    .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblcodigo2)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setText("*Quantidade de Sorvetes");

        btnVendaAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/insert.png"))); // NOI18N
        btnVendaAdicionar.setToolTipText("Adicionar usuário");
        btnVendaAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVendaAdicionar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnVendaAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaAdicionarActionPerformed(evt);
            }
        });

        btnVendaPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/read.png"))); // NOI18N
        btnVendaPesquisar.setToolTipText("Procurar usuário");
        btnVendaPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVendaPesquisar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnVendaPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaPesquisarActionPerformed(evt);
            }
        });

        btnVendaAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/update.png"))); // NOI18N
        btnVendaAlterar.setToolTipText("Alterar Usuário");
        btnVendaAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVendaAlterar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnVendaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaAlterarActionPerformed(evt);
            }
        });

        btnVendaRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/delete.png"))); // NOI18N
        btnVendaRemover.setToolTipText("Remover usuário");
        btnVendaRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVendaRemover.setPreferredSize(new java.awt.Dimension(70, 70));
        btnVendaRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaRemoverActionPerformed(evt);
            }
        });

        btnVendaImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/iconfinder_icon-printer_211880_1.png"))); // NOI18N
        btnVendaImprimir.setPreferredSize(new java.awt.Dimension(70, 70));

        jLabel2.setText("*Valor Total");

        try {
            txtValTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSituacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtQtdSorvetes, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtValTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelSorvete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVendaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnVendaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnVendaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnVendaRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnVendaImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSituacao)
                            .addComponent(cboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdSorvetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelSorvete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVendaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVendaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVendaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVendaRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVendaImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 610, 495);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVendaRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaRemoverActionPerformed
        //Método para excluir usuário
        //remover();
    }//GEN-LAST:event_btnVendaRemoverActionPerformed

    private void btnVendaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaAlterarActionPerformed
        // método para alterar dados do usuário
        //alterar();
    }//GEN-LAST:event_btnVendaAlterarActionPerformed

    private void btnVendaPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaPesquisarActionPerformed
        //consultar
    }//GEN-LAST:event_btnVendaPesquisarActionPerformed

    private void btnVendaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaAdicionarActionPerformed
        //Método para adicionar usuário
        //adicionar();
    }//GEN-LAST:event_btnVendaAdicionarActionPerformed

    private void txtPesqClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqClienteKeyReleased
        // Método para pesquisar mostrar na tabela os resultados digitados
        pesquisar_cliente();
    }//GEN-LAST:event_txtPesqClienteKeyReleased

    private void txtPesqSorveteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqSorveteKeyPressed
        // TODO add your handling code here:
        pesquisar_sorvete();
    }//GEN-LAST:event_txtPesqSorveteKeyPressed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        setar_campo_id_cliente();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void tblSorveteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSorveteMouseClicked
        setar_campo_id_sorvete();
    }//GEN-LAST:event_tblSorveteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVendaAdicionar;
    private javax.swing.JButton btnVendaAlterar;
    private javax.swing.JButton btnVendaImprimir;
    private javax.swing.JButton btnVendaPesquisar;
    private javax.swing.JButton btnVendaRemover;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelSorvete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblOS;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblcodigo2;
    private javax.swing.JRadioButton rbVendaSorvete;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblSorvete;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdSorvete;
    private javax.swing.JTextField txtOS;
    private javax.swing.JTextField txtPesqCliente;
    private javax.swing.JTextField txtPesqSorvete;
    private javax.swing.JTextField txtQtdSorvetes;
    private javax.swing.JFormattedTextField txtValTotal;
    // End of variables declaration//GEN-END:variables
}
