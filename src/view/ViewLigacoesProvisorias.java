/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAgrupamento;
import controller.ControllerCidade;
import controller.ControllerEntrada;
import controller.ControllerLigacao;
import controller.ControllerLigacoesProvisorias;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelAgrupamento;
import model.ModelCidade;
import model.ModelEntrada;
import model.ModelLigacao;
import model.ModelLigacaoProvisoria;

/**
 *
 * @author Nielson Soares
 */
public class ViewLigacoesProvisorias extends javax.swing.JFrame {

    private ControllerLigacoesProvisorias clp;
    private DefaultTableModel model = new DefaultTableModel();
    private int codLigacaoProvisoria;
    private String novoOuAlterar;
    
    
    /**
     * Creates new form ViewLigacoesProvisorias
     */
    public ViewLigacoesProvisorias() {
        initComponents();
        
        clp = new ControllerLigacoesProvisorias();
        model = (DefaultTableModel) tblLigProvisoria.getModel();
        
        //Maximiza a JFrame
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Desabilita os campos do formulário.
        habilitarCamposFormulario(false);
        
        //Carregar
        carregarComboBoxes();
        
        //Carrega a tabela com os dados.
        carregarTabela();
    }
    
    // Função para carregar todos o ComboBoxes
    private void carregarComboBoxes(){
        preencherComboEntrada();
        preencherComboAgrupamento();
        preencherComboLocalidade();
        preencherComboLigacaoTrafo();
        preencherComboPrecisaTrafo();
    }
    
    // Preenche o ComboBox com uma lista de tipo de entradas.
    private void preencherComboEntrada(){
        new Thread(){
            @Override
            public void run() {
                ArrayList<ModelEntrada> listEntradas = new ControllerEntrada().retornarListaEntradaController();
                jCBEntrada.removeAllItems();
                jCBEntrada.addItem("ESCOLHA");
                listEntradas.forEach((e) -> {
                    jCBEntrada.addItem(e);
                });
            }
            
        }.start();
    }
    
    // Preenche o ComboBox com uma lista dos Agrupamentos de 'PM'.
    private void preencherComboAgrupamento(){
        new Thread(){
            @Override
            public void run() {
                ArrayList<ModelAgrupamento> listAgrupamentos = new ControllerAgrupamento().retonarListaAgrupamentoController();
                jCBAgrupamento.removeAllItems();
                jCBAgrupamento.addItem("ESCOLHA");
                listAgrupamentos.forEach((a) -> {
                    jCBAgrupamento.addItem(a);
                });
            }
            
        }.start();
    }
    
    // Preenche o ComboBox com uma lista das Localidades.
    private void preencherComboLocalidade(){
        new Thread(){
            @Override
            public void run() {
                ArrayList<ModelCidade> listLocalidades = new ControllerCidade().retornarListaCidadeController();
                jCBLocalidade.removeAllItems();
                jCBLocalidade.addItem("ESCOLHA");
                listLocalidades.forEach((l) -> {
                    jCBLocalidade.addItem(l);
                });
            }
            
        }.start();
    }
    
    // Preenche o ComboBox com uma lista dos tipos de Ligações.
    private void preencherComboLigacaoTrafo(){
        new Thread(){
            @Override
            public void run() {
                ArrayList<ModelLigacao> listLigacoes = new ControllerLigacao().retornarListaLigacaoController();
                jCBTipoLigacao.removeAllItems();
                jCBTipoLigacao.addItem("ESCOLHA");
                listLigacoes.forEach((l) -> {
                    jCBTipoLigacao.addItem(l);
                });
            }
            
        }.start();
    }
    
    // Preenche o ComboBox com opçoes para o Trafo.
    private void preencherComboPrecisaTrafo(){
        new Thread(){
            @Override
            public void run() {
                jCBTrafo.removeAllItems();
                jCBTrafo.addItem("ESCOLHA");
                jCBTrafo.addItem("SIM");
                jCBTrafo.addItem("NÃO");
            }
            
        }.start();
    }
    
    // Função que habilita/desabilita os campos do formulário.
    private void habilitarCamposFormulario(boolean habilitar) {
        jCBAgrupamento.setEnabled(habilitar);
        jCBEntrada.setEnabled(habilitar);
        jCBLocalidade.setEnabled(habilitar);
        jCBTipoLigacao.setEnabled(habilitar);
        jCBTrafo.setEnabled(habilitar);
        txtAmperagem.setEnabled(habilitar);
        txtDataInicio.setEnabled(habilitar);
        txtDataFim.setEnabled(habilitar);
        txtEvento.setEnabled(habilitar);
        txtEnderecoLigacao.setEnabled(habilitar);
        txtReferencia.setEnabled(habilitar);
        jbSalvar.setEnabled(habilitar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        txtDataSolicitacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBEntrada = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNumOficio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEvento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCBAgrupamento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCBLocalidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtDataInicio = new com.toedter.calendar.JDateChooser();
        txtDataFim = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jCBTipoLigacao = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtAmperagem = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jCBTrafo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtTrafoKva = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEnderecoLigacao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLigProvisoria = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ligações Provisórias");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        txtDataSolicitacao.setEnabled(false);

        jLabel1.setText("Data da Solicitação");

        jLabel2.setText("Forma de Entrada");

        jCBEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARREGANDO..." }));
        jCBEntrada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBEntradaItemStateChanged(evt);
            }
        });

        jLabel3.setText("Número do Ofício");

        txtNumOficio.setEnabled(false);

        jLabel4.setText("Evento");

        jLabel5.setText("Escolha o Agrupamento");

        jCBAgrupamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARREGANDO..." }));

        jLabel6.setText("Escolha a Localidade");

        jCBLocalidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARREGANDO..." }));

        jLabel7.setText("Data Início");

        jLabel8.setText("Data Final");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Características do Disjuntor"));

        jLabel9.setText("Tipo:");

        jCBTipoLigacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARREGANDO..." }));

        jLabel10.setText("Amperagem");

        txtAmperagem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jLabel11.setText("Para esa ligação será necessário instalação de Transformador?");

        jCBTrafo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARREGANDO..." }));
        jCBTrafo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBTrafoItemStateChanged(evt);
            }
        });

        jLabel12.setText("Qual a potência do Transformador em KVA?");

        txtTrafoKva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtTrafoKva.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jCBTipoLigacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAmperagem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBTrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrafoKva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTipoLigacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmperagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jCBTrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTrafoKva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel13.setText("Endereço da Ligação");

        jLabel14.setText("Referência");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDataSolicitacao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNumOficio, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBAgrupamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBLocalidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEnderecoLigacao, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(250, 250, 250)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumOficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBAgrupamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnderecoLigacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        tblLigProvisoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data Solicitação", "Entrada", "Num. Ofício", "Agrupamento", "Localidade", "Evento", "Data Início", "Data Fim", "Ligação", "Aperagem", "Trafo (KVA)", "Endereço Ligação", "Referência"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLigProvisoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLigProvisoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLigProvisoria);
        if (tblLigProvisoria.getColumnModel().getColumnCount() > 0) {
            tblLigProvisoria.getColumnModel().getColumn(0).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(1).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(2).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(3).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(4).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(5).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(6).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(7).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(8).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(9).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(10).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(11).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(12).setResizable(false);
            tblLigProvisoria.getColumnModel().getColumn(13).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/page.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });
        jPanel4.add(jbNovo);

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/disk.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalvarMouseClicked(evt);
            }
        });
        jPanel4.add(jbSalvar);

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/application_edit.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });
        jPanel4.add(jbAlterar);

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/cross.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        jPanel4.add(jbExcluir);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBTrafoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBTrafoItemStateChanged
        // TODO add your handling code here:
        if(jCBTrafo.getSelectedItem()!=null && jCBTrafo.isEnabled()){
            if(jCBTrafo.getSelectedItem().equals("SIM"))
                txtTrafoKva.setEnabled(true);
            else
                txtTrafoKva.setEnabled(false);
        }
    }//GEN-LAST:event_jCBTrafoItemStateChanged

    private void jCBEntradaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBEntradaItemStateChanged
        // TODO add your handling code here:
        ModelEntrada e;
        if(jCBEntrada.getSelectedItem()!=null && jCBEntrada.isEnabled()){
            if(!jCBEntrada.getSelectedItem().equals("ESCOLHA")){
                e = (ModelEntrada) jCBEntrada.getSelectedItem();
                if(e.getDescEntrada().equals("OFÍCIO"))
                    txtNumOficio.setEnabled(true);
                else
                    txtNumOficio.setEnabled(false);
            }else{
                txtNumOficio.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCBEntradaItemStateChanged

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        habilitarCamposFormulario(true);
        novoOuAlterar = "ADIÇÃO";
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        habilitarCamposFormulario(true);
        novoOuAlterar = "ALTERAÇÃO";
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Object[] opcoes = { "SIM", "NÃO" };
        
        int resposta = JOptionPane.showOptionDialog(this,
                "Você deseja remover a Ligação Provisória Nº" + codLigacaoProvisoria,
                "Atenção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
        
        if(resposta == 0){
            if(clp.removerLigacaoProvisoriaController(codLigacaoProvisoria)){
                    JOptionPane.showMessageDialog(this, "Ligação removida com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                    habilitarCamposFormulario(false);
                    carregarComboBoxes();
                    limparCamposFormulario();
                    carregarTabela();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao remover a Ligação!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvarMouseClicked
        // TODO add your handling code here:
        SimpleDateFormat dateSQLFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        boolean erroPreenchimento = false;
        String campos = "";
        
        if (jCBEntrada.getSelectedIndex() == 0){
            erroPreenchimento = true;
            campos += "\n Entrada;";
        }
        
        if (txtNumOficio.isEnabled() && txtNumOficio.getText().equals("")){
            erroPreenchimento = true;
            campos += "\n Num Ofício;";
        }
        
        if (jCBAgrupamento.getSelectedIndex() == 0){
            erroPreenchimento = true;
            campos += "\n Agrupamento;";
        }
        
        if (jCBLocalidade.getSelectedIndex() == 0){
            erroPreenchimento = true;
            campos += "\n Localidade;";
        }
        
        if (txtEvento.getText().equals("")){
            erroPreenchimento = true;
            campos += "\n Evento;";
        }
        
        if (txtDataInicio.getDate() == null){
            erroPreenchimento = true;
            campos += "\n Data de Início;";
        }
        
        if (txtDataFim.getDate() == null){
            erroPreenchimento = true;
            campos += "\n Data de Fim;";
        }
        
        if (txtEnderecoLigacao.getText().equals("")){
            erroPreenchimento = true;
            campos += "\n Endereço de Ligação;";
        }
        
        if (txtReferencia.getText().equals("")){
            erroPreenchimento = true;
            campos += "\n Referência;";
        }
        
        if (jCBTipoLigacao.getSelectedIndex() == 0){
            erroPreenchimento = true;
            campos += "\n Ligação do Disjuntor;";
        }
        
        if (txtAmperagem.getText().equals("")){
            erroPreenchimento = true;
            campos += "\n Amperagem;";
        }
        
        if (jCBTrafo.getSelectedIndex() == 0){
            erroPreenchimento = true;
            campos += "\n Se precisa de trafo;";
        }
        
        if (jCBTrafo.getSelectedItem().equals("SIM") && txtTrafoKva.getText().equals("")){
            erroPreenchimento = true;
            campos += "\n KVA do trafo;";
        }
        
        if (!erroPreenchimento){
            ModelLigacaoProvisoria mlp = new ModelLigacaoProvisoria();

            mlp.setCodEntrada(((ModelEntrada)jCBEntrada.getSelectedItem()).getCodEntrada());
            mlp.setNumOficio(txtNumOficio.getText());
            mlp.setCodAgrupamento(((ModelAgrupamento)jCBAgrupamento.getSelectedItem()).getCodAgrupamento());
            mlp.setCodCidade(((ModelCidade) jCBLocalidade.getSelectedItem()).getCodCidade());
            mlp.setEvento(txtEvento.getText());
            String dataIni = dateSQLFormat.format(txtDataInicio.getDate());
            mlp.setDataInicio(dataIni);
            String dataFim = dateSQLFormat.format(txtDataFim.getDate());
            mlp.setDataFim(dataFim);
            mlp.setEnderecoLigacao(txtEnderecoLigacao.getText());
            mlp.setReferencia(txtReferencia.getText());
            mlp.setTipoLigacao(((ModelLigacao) jCBTipoLigacao.getSelectedItem()).getCodLigacao());
            mlp.setAmperagem(Integer.valueOf(txtAmperagem.getText()));
            if(jCBTrafo.getSelectedItem().equals("SIM"))
                mlp.setTrafoKva(txtTrafoKva.getText());
            else if(jCBTrafo.getSelectedItem().equals("NÃO"))
                mlp.setTrafoKva("NÃO");
            if(novoOuAlterar.equals("ADIÇÃO")){
                if(clp.salvarLigacaoProvisoriaController(mlp) > 0) {
                    JOptionPane.showMessageDialog(this, "Ligação cadastrada com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    habilitarCamposFormulario(false);
                    carregarComboBoxes();
                    limparCamposFormulario();
                    carregarTabela();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar a ligação!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }else if (novoOuAlterar.equals("ALTERAÇÃO")){
                mlp.setCodSolicitacao(codLigacaoProvisoria);
                if(clp.alterarLigacaoProvisoriaController(mlp)){
                    JOptionPane.showMessageDialog(this, "Ligação alterada com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    habilitarCamposFormulario(false);
                    carregarComboBoxes();
                    limparCamposFormulario();
                    carregarTabela();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar a ligação!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this,
                    "Favor, preencher corretamente o(s) campo(s) abaixo:" + campos,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarMouseClicked

    private void tblLigProvisoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLigProvisoriaMouseClicked
        // TODO add your handling code here:
        jbExcluir.setEnabled(true);
        codLigacaoProvisoria = Integer.valueOf(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 0)));
        txtDataSolicitacao.setText(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 1)));
        jCBEntrada.getModel().setSelectedItem(model.getValueAt(tblLigProvisoria.getSelectedRow(), 2));
        txtNumOficio.setText(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 3)));
        jCBAgrupamento.getModel().setSelectedItem(model.getValueAt(tblLigProvisoria.getSelectedRow(), 4));
        jCBLocalidade.getModel().setSelectedItem(model.getValueAt(tblLigProvisoria.getSelectedRow(), 5));
        txtEvento.setText(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 6)));
        try {
            txtDataInicio.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 7))));
            txtDataFim.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 8))));
        } catch (ParseException ex) {
            Logger.getLogger(ViewLigacoesProvisorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        jCBTipoLigacao.getModel().setSelectedItem(model.getValueAt(tblLigProvisoria.getSelectedRow(), 9));
        txtAmperagem.setText(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 10)));
        boolean precisaTrafo = !(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 11))).equals("NÃO");
        if(precisaTrafo){
            txtTrafoKva.setText(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 11)));
            jCBTrafo.getModel().setSelectedItem("SIM");
        }else{
            jCBTrafo.getModel().setSelectedItem("NÃO");
        }
        txtEnderecoLigacao.setText(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 12)));
        txtReferencia.setText(String.valueOf(model.getValueAt(tblLigProvisoria.getSelectedRow(), 13)));
    }//GEN-LAST:event_tblLigProvisoriaMouseClicked

    // Função para limpar os campos do formulário.
    private void limparCamposFormulario(){
        txtDataSolicitacao.setText("");
        txtNumOficio.setText("");
        txtEvento.setText("");
        txtEnderecoLigacao.setText("");
        txtReferencia.setText("");
        txtAmperagem.setText("");
        txtTrafoKva.setText("");
        txtDataInicio.setCalendar(null);
        txtDataFim.setCalendar(null);
    }
    
    // Função para carregar os dados na tabela.
    private void carregarTabela() {
        new Thread(){
            @Override
            public void run() {
                ArrayList<ModelLigacaoProvisoria> lista = clp.listarLigacoesProvisoriasController();
              
                model.setNumRows(0);

                //insere as ligacoes na tabela
                lista.forEach((lp) -> {
                    model.addRow(new Object[]{
                        lp.getCodSolicitacao(),
                        lp.getDataSolicitacao(),
                        new ControllerEntrada().retornarEntradaPorCodController(lp.getCodEntrada()),
                        lp.getNumOficio(),
                        new ControllerAgrupamento().retornarAgrupamentoPorCodController(lp.getCodAgrupamento()),
                        new ControllerCidade().retornarCidadePorCodController(lp.getCodCidade()),
                        lp.getEvento(),
                        lp.getDataInicio(),
                        lp.getDataFim(),
                        new ControllerLigacao().retornarLigacaoPorCodController(lp.getTipoLigacao()),
                        lp.getAmperagem(),
                        lp.getTrafoKva(),
                        lp.getEnderecoLigacao(),
                        lp.getReferencia()
                    });
                });
            }
        }.start();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> jCBAgrupamento;
    private javax.swing.JComboBox<Object> jCBEntrada;
    private javax.swing.JComboBox<Object> jCBLocalidade;
    private javax.swing.JComboBox<Object> jCBTipoLigacao;
    private javax.swing.JComboBox<String> jCBTrafo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTable tblLigProvisoria;
    private javax.swing.JFormattedTextField txtAmperagem;
    private com.toedter.calendar.JDateChooser txtDataFim;
    private com.toedter.calendar.JDateChooser txtDataInicio;
    private javax.swing.JTextField txtDataSolicitacao;
    private javax.swing.JTextField txtEnderecoLigacao;
    private javax.swing.JTextField txtEvento;
    private javax.swing.JTextField txtNumOficio;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JFormattedTextField txtTrafoKva;
    // End of variables declaration//GEN-END:variables
}
