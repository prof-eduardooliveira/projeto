/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerCliente;
import controller.ControllerGrupoSolicitacao;
import controller.ControllerServico;
import controller.ControllerSituacao;
import controller.ControllerSolicitacaoGC;
import controller.ControllerUsuario;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ModelCliente;
import model.ModelGrupoSolicitacao;
import model.ModelServico;
import model.ModelSituacao;
import model.ModelSolicitacaoGC;
import model.ModelUsuario;
//import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author edube
 */
public class ViewSolicitacaoGC extends javax.swing.JFrame {

    String altcboCliente = "Listar", altcboUsuario = "Listar", altcboServico = "Listar", altcboGrupoSol = "Listar";
    String altcboSituacao = "Listar", altcboPrioridade = "Listar";
    String perfil;

    ControllerSolicitacaoGC controllerSolicitacaoGC = new ControllerSolicitacaoGC();
    ModelSolicitacaoGC modelSolicitacaoGC = new ModelSolicitacaoGC();
    ArrayList<ModelSolicitacaoGC> listaModelSolicitacaoGC = new ArrayList<>();

    ControllerCliente controllerClientes = new ControllerCliente();
    ModelCliente modelCliente = new ModelCliente();
    ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();

    ControllerUsuario controllerUsuario = new ControllerUsuario();
    ModelUsuario modelUsuario = new ModelUsuario();
    ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();

    ControllerServico controllerServico = new ControllerServico();
    ModelServico modelServico = new ModelServico();
    ArrayList<ModelServico> listaModelServicos = new ArrayList<>();

    ControllerGrupoSolicitacao controllerGrupoSolicitacao = new ControllerGrupoSolicitacao();
    ModelGrupoSolicitacao modelGrupoSolicitacao = new ModelGrupoSolicitacao();
    ArrayList<ModelGrupoSolicitacao> listaModelGrupoSolicitacoes = new ArrayList<>();

    ControllerSituacao controllerSituacao = new ControllerSituacao();
    ModelSituacao modelSituacao = new ModelSituacao();
    ArrayList<ModelSituacao> listaModelSituacoes = new ArrayList<>();

    private int codEnergisa;
    private int codigoCliente;
    private int codigoGrupoSolicitacao;
    private int codigoResponsavel;
    private int codigoSituacao;
    private int codServico;
    /* private int demAntP;
    private int demAntFP;
    private int demSolP;
    private int demSolFP;
    private String Situacao;
    private String dataSolicitacao;
    private String dataResposta;
    private String dataEncaminhamento;
    private String dataLimite;
    private String prioridade;*/

    private String datadoDia;

    String alterarSalvar;

    /**
     * Creates new form ViewSolicitacaoGC
     */
    public ViewSolicitacaoGC() {
        initComponents();
        listarClientes(altcboCliente);
        listarUsuarios(altcboUsuario);
        listarServicos(altcboServico);
        listarGruposSolicitacao(altcboGrupoSol);
        listarSituacoes(altcboSituacao);
        this.setLocationRelativeTo(null);
        habilitarDesabilitarCampos(false);
        habilitarDemanda(false);
        carregarSolicGC();
        datadoDia = getDataAtual();
    }

    // Preenche o combobox de Clientes
    private void listarClientes(String tipo) {
        if (tipo.equals("Listar")) {
            listaModelClientes = controllerClientes.retornarListaClienteController();
            jcboCliente.removeAllItems();
            jcboCliente.addItem("ESCOLHA");
            for (int i = 0; i < listaModelClientes.size(); i++) {
                jcboCliente.addItem(listaModelClientes.get(i).getNomecsd());
            }
        } else {
            listaModelClientes = controllerClientes.retornarListaClienteController();
            jcboCliente.removeAllItems();
            //jCBPerfil.addItem(perfil);
            for (int i = 0; i < listaModelClientes.size(); i++) {
                jcboCliente.addItem(listaModelClientes.get(i).getNomecsd());
            }
        }
    }

    // Preenche o combobox de Serviços
    private void listarServicos(String tipo) {
        if (tipo.equals("Listar")) {
            listaModelServicos = controllerServico.getListaServicoController();
            jcboSolicitacao.removeAllItems();
            jcboSolicitacao.addItem("ESCOLHA");
            for (int i = 0; i < listaModelServicos.size(); i++) {
                jcboSolicitacao.addItem(listaModelServicos.get(i).getDescricao());
            }
        } else {
            listaModelServicos = controllerServico.getListaServicoController();
            jcboSolicitacao.removeAllItems();
            //jCBPerfil.addItem(perfil);
            for (int i = 0; i < listaModelServicos.size(); i++) {
                jcboSolicitacao.addItem(listaModelServicos.get(i).getDescricao());
            }
        }
    }

    // Preenche o combobox de Prioridades
    public void listarGruposSolicitacao(String tipo) {
        if (tipo.equals("Listar")) {
            listaModelGrupoSolicitacoes = controllerGrupoSolicitacao.getListaGrupoSolicitacaoController();
            jcboGrupoSol.removeAllItems();
            jcboGrupoSol.addItem("ESCOLHA");
            for (int i = 0; i < listaModelGrupoSolicitacoes.size(); i++) {
                jcboGrupoSol.addItem(listaModelGrupoSolicitacoes.get(i).getDescricao());
            }
        } else {
            listaModelGrupoSolicitacoes = controllerGrupoSolicitacao.getListaGrupoSolicitacaoController();
            jcboGrupoSol.removeAllItems();
            //jCBPerfil.addItem(perfil);
            for (int i = 0; i < listaModelGrupoSolicitacoes.size(); i++) {
                jcboGrupoSol.addItem(listaModelGrupoSolicitacoes.get(i).getDescricao());
            }
        }
    }

    // Preenche o combobox de Usuários
    private void listarUsuarios(String tipo) {
        if (tipo.equals("Listar")) {
            listaModelUsuarios = controllerUsuario.getListaUsuarioController();
            jcboResponsavel.removeAllItems();
            jcboResponsavel.addItem("ESCOLHA");
            for (int i = 0; i < listaModelUsuarios.size(); i++) {
                jcboResponsavel.addItem(listaModelUsuarios.get(i).getNome());
            }
        } else {
            listaModelUsuarios = controllerUsuario.getListaUsuarioController();
            jcboResponsavel.removeAllItems();
            //jCBPerfil.addItem(perfil);
            for (int i = 0; i < listaModelUsuarios.size(); i++) {
                jcboResponsavel.addItem(listaModelUsuarios.get(i).getNome());
            }
        }
    }

    // Preenche o combobox de Situações (Status)
    private void listarSituacoes(String tipo) {
        if (tipo.equals("Listar")) {
            listaModelSituacoes = controllerSituacao.getListaSituacaoController();
            jcboSituacao.removeAllItems();
            jcboSituacao.addItem("ESCOLHA");
            for (int i = 0; i < listaModelSituacoes.size(); i++) {
                jcboSituacao.addItem(listaModelSituacoes.get(i).getDescricao());
            }
        } else {
            listaModelSituacoes = controllerSituacao.getListaSituacaoController();
            jcboSituacao.removeAllItems();
            //jCBPerfil.addItem(perfil);
            for (int i = 0; i < listaModelSituacoes.size(); i++) {
                jcboSituacao.addItem(listaModelSituacoes.get(i).getDescricao());
            }
        }
    }

    public String getDataAtual() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = simpleDateFormat.format(calendar.getTime());
        return data;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcboSolicitacao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtxtDataSolicitacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtPesquisa = new javax.swing.JTextField();
        jbLimpar = new javax.swing.JButton();
        jbBusca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTSolicitacaoTabela = new javax.swing.JTable();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtxtCDC = new javax.swing.JTextField();
        jcboCliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jcboGrupoSol = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcboResponsavel = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtxtDataResposta = new com.toedter.calendar.JDateChooser();
        jpDemandaAnterior = new javax.swing.JPanel();
        jlblPontaDemAnterior = new javax.swing.JLabel();
        jtxtPontaKWAnterior = new javax.swing.JTextField();
        jlblForaPontaDemAnterior = new javax.swing.JLabel();
        jtxtForaPontaKWAnterior = new javax.swing.JTextField();
        jpDemandaSolicitada = new javax.swing.JPanel();
        jlblPontaDemSolicitada = new javax.swing.JLabel();
        jtxtPontaKWSolicitada = new javax.swing.JTextField();
        jlblForaPontaDemSolicitada = new javax.swing.JLabel();
        jtxtForaPontaKWSolicitada = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtaObservacao = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jcboPesquisa = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTClienteTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jtxtEnergisa = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jcboSituacao = new javax.swing.JComboBox<>();
        jbCadSolicitacao = new javax.swing.JButton();
        jbCadCliente = new javax.swing.JButton();
        jbCadUsuario = new javax.swing.JButton();
        jtxtDataEncaminhamento = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jtxtDataLimite = new javax.swing.JTextField();
        jtxtPrioridade = new javax.swing.JTextField();
        jbCadGrupo = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitações de Grandes Clientes");

        jPanel1.setMaximumSize(new java.awt.Dimension(1480, 3767));

        jLabel2.setText("Cliente");

        jtxtCodigo.setEditable(false);
        jtxtCodigo.setBackground(new java.awt.Color(255, 255, 204));

        jLabel3.setText("Solicitação");

        jcboSolicitacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcboSolicitacaoItemStateChanged(evt);
            }
        });
        jcboSolicitacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcboSolicitacaoFocusLost(evt);
            }
        });
        jcboSolicitacao.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                jcboSolicitacaoPopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcboSolicitacaoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcboSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboSolicitacaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Data de Solicitação");

        jtxtDataSolicitacao.setEditable(false);
        jtxtDataSolicitacao.setBackground(new java.awt.Color(204, 255, 204));

        jLabel8.setText("Pesquisar:");

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/cancel.png"))); // NOI18N
        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/magnifier.png"))); // NOI18N
        jbBusca.setText("Pesquisar");
        jbBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaActionPerformed(evt);
            }
        });

        jTSolicitacaoTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "UC", "Energisa", "Cliente", "Responsável", "Solicitação", "SLA_D_U", "Situação", "Prioridade", "Data Solicitação", "Data limite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTSolicitacaoTabela);
        if (jTSolicitacaoTabela.getColumnModel().getColumnCount() > 0) {
            jTSolicitacaoTabela.getColumnModel().getColumn(0).setMinWidth(0);
            jTSolicitacaoTabela.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTSolicitacaoTabela.getColumnModel().getColumn(1).setMinWidth(0);
            jTSolicitacaoTabela.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTSolicitacaoTabela.getColumnModel().getColumn(2).setMinWidth(200);
            jTSolicitacaoTabela.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTSolicitacaoTabela.getColumnModel().getColumn(3).setMinWidth(5);
            jTSolicitacaoTabela.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTSolicitacaoTabela.getColumnModel().getColumn(4).setMinWidth(150);
            jTSolicitacaoTabela.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTSolicitacaoTabela.getColumnModel().getColumn(5).setMinWidth(-10);
            jTSolicitacaoTabela.getColumnModel().getColumn(5).setPreferredWidth(-10);
            jTSolicitacaoTabela.getColumnModel().getColumn(6).setMinWidth(5);
            jTSolicitacaoTabela.getColumnModel().getColumn(6).setPreferredWidth(5);
            jTSolicitacaoTabela.getColumnModel().getColumn(7).setMinWidth(0);
            jTSolicitacaoTabela.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTSolicitacaoTabela.getColumnModel().getColumn(8).setMinWidth(5);
            jTSolicitacaoTabela.getColumnModel().getColumn(8).setPreferredWidth(5);
            jTSolicitacaoTabela.getColumnModel().getColumn(9).setMinWidth(5);
            jTSolicitacaoTabela.getColumnModel().getColumn(9).setPreferredWidth(5);
        }

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/page.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/disk.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/application_edit.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/cross.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/stop.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("CDC");

        jcboCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcboClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboClienteActionPerformed(evt);
            }
        });

        jLabel10.setText("Grupo");

        jcboGrupoSol.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcboGrupoSolPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcboGrupoSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboGrupoSolActionPerformed(evt);
            }
        });

        jLabel11.setText("Data de Encaminhamento");

        jLabel12.setText("Responsável");

        jcboResponsavel.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcboResponsavelPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcboResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboResponsavelActionPerformed(evt);
            }
        });

        jLabel13.setText("Situação (Estado)");

        jLabel14.setText("Data de Resposta");

        jpDemandaAnterior.setBorder(javax.swing.BorderFactory.createTitledBorder("Demanda (KW) Anterior"));

        jlblPontaDemAnterior.setText("Ponta");

        jlblForaPontaDemAnterior.setText("Fora Ponta");

        javax.swing.GroupLayout jpDemandaAnteriorLayout = new javax.swing.GroupLayout(jpDemandaAnterior);
        jpDemandaAnterior.setLayout(jpDemandaAnteriorLayout);
        jpDemandaAnteriorLayout.setHorizontalGroup(
            jpDemandaAnteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDemandaAnteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDemandaAnteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblPontaDemAnterior)
                    .addComponent(jtxtPontaKWAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDemandaAnteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblForaPontaDemAnterior)
                    .addComponent(jtxtForaPontaKWAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jpDemandaAnteriorLayout.setVerticalGroup(
            jpDemandaAnteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDemandaAnteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDemandaAnteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDemandaAnteriorLayout.createSequentialGroup()
                        .addComponent(jlblForaPontaDemAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtForaPontaKWAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDemandaAnteriorLayout.createSequentialGroup()
                        .addComponent(jlblPontaDemAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtPontaKWAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpDemandaSolicitada.setBorder(javax.swing.BorderFactory.createTitledBorder("Demanda (KW) Solicitada"));

        jlblPontaDemSolicitada.setText("Ponta");

        jlblForaPontaDemSolicitada.setText("Fora Ponta");

        javax.swing.GroupLayout jpDemandaSolicitadaLayout = new javax.swing.GroupLayout(jpDemandaSolicitada);
        jpDemandaSolicitada.setLayout(jpDemandaSolicitadaLayout);
        jpDemandaSolicitadaLayout.setHorizontalGroup(
            jpDemandaSolicitadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDemandaSolicitadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDemandaSolicitadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblPontaDemSolicitada)
                    .addComponent(jtxtPontaKWSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDemandaSolicitadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblForaPontaDemSolicitada)
                    .addComponent(jtxtForaPontaKWSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDemandaSolicitadaLayout.setVerticalGroup(
            jpDemandaSolicitadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDemandaSolicitadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDemandaSolicitadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDemandaSolicitadaLayout.createSequentialGroup()
                        .addComponent(jlblForaPontaDemSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtForaPontaKWSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDemandaSolicitadaLayout.createSequentialGroup()
                        .addComponent(jlblPontaDemSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtPontaKWSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtxtaObservacao.setColumns(20);
        jtxtaObservacao.setLineWrap(true);
        jtxtaObservacao.setRows(5);
        jScrollPane2.setViewportView(jtxtaObservacao);

        jLabel19.setText("Observação");

        jcboPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESCOLHA", "UC", "Cliente", "Responsável", "Serviço", "Situação", "Prioridade", "Data Limite" }));
        jcboPesquisa.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcboPesquisaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcboPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboPesquisaActionPerformed(evt);
            }
        });

        jTClienteTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Endereço", "Número", "Bairro", "Cidade", "UF", "Telefone", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTClienteTabela.setMaximumSize(new java.awt.Dimension(2600, 80));
        jTClienteTabela.setPreferredSize(new java.awt.Dimension(2600, 80));
        jScrollPane3.setViewportView(jTClienteTabela);
        if (jTClienteTabela.getColumnModel().getColumnCount() > 0) {
            jTClienteTabela.getColumnModel().getColumn(0).setMinWidth(150);
            jTClienteTabela.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTClienteTabela.getColumnModel().getColumn(1).setMinWidth(0);
            jTClienteTabela.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTClienteTabela.getColumnModel().getColumn(4).setMinWidth(0);
            jTClienteTabela.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTClienteTabela.getColumnModel().getColumn(5).setMinWidth(0);
            jTClienteTabela.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTClienteTabela.getColumnModel().getColumn(6).setMinWidth(100);
            jTClienteTabela.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jLabel1.setText("Código");

        jLabel20.setText("Energisa");

        jtxtEnergisa.setEditable(false);
        jtxtEnergisa.setBackground(new java.awt.Color(204, 255, 204));

        jLabel21.setText("Prioridade");

        jcboSituacao.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcboSituacaoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcboSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboSituacaoActionPerformed(evt);
            }
        });

        jbCadSolicitacao.setText("...");
        jbCadSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadSolicitacaoActionPerformed(evt);
            }
        });

        jbCadCliente.setText("...");
        jbCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadClienteActionPerformed(evt);
            }
        });

        jbCadUsuario.setText("...");
        jbCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadUsuarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Limite Atend.");

        jtxtDataLimite.setEditable(false);
        jtxtDataLimite.setBackground(new java.awt.Color(204, 255, 204));
        jtxtDataLimite.setForeground(new java.awt.Color(255, 0, 0));

        jtxtPrioridade.setEditable(false);
        jtxtPrioridade.setBackground(new java.awt.Color(204, 255, 204));

        jbCadGrupo.setText("...");
        jbCadGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jtxtEnergisa, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtCDC, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(470, 470, 470)
                                .addComponent(jLabel13)
                                .addGap(118, 118, 118)
                                .addComponent(jLabel21)
                                .addGap(125, 125, 125)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 484, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcboSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbCadSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtxtDataLimite, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                        .addGap(310, 310, 310))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jpDemandaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpDemandaSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jbNovo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbAlterar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbCancelar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jbBusca))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jtxtDataSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtxtDataEncaminhamento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel14))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtxtDataResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(11, 11, 11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jcboResponsavel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbCadUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtxtPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcboGrupoSol, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbCadGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel9)
                        .addComponent(jLabel2)
                        .addComponent(jLabel20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtEnergisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCadCliente)
                    .addComponent(jcboSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCadSolicitacao)
                    .addComponent(jtxtDataLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtDataSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcboResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbCadUsuario)
                        .addComponent(jcboGrupoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbCadGrupo))
                    .addComponent(jtxtDataEncaminhamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDataResposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpDemandaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbLimpar)
                            .addComponent(jbBusca)))
                    .addComponent(jpDemandaSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCancelar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbNovo)
                        .addComponent(jbAlterar)
                        .addComponent(jbExcluir))
                    .addComponent(jbSalvar))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1369, 687);
    }// </editor-fold>//GEN-END:initComponents

    private void jcboPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboPesquisaActionPerformed

    private void jcboPesquisaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcboPesquisaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboPesquisaPopupMenuWillBecomeInvisible

    private void jcboResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboResponsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboResponsavelActionPerformed

    private void jcboResponsavelPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcboResponsavelPopupMenuWillBecomeInvisible
        if (jcboResponsavel.isPopupVisible()) {
            modelUsuario = controllerUsuario.getUsuarioController(jcboResponsavel.getSelectedItem().toString());
            codigoResponsavel = modelUsuario.getId_usuario();
        }
    }//GEN-LAST:event_jcboResponsavelPopupMenuWillBecomeInvisible

    private void jcboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboClienteActionPerformed

    private void jcboClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcboClientePopupMenuWillBecomeInvisible
        if (jcboCliente.isPopupVisible()) {
            modelCliente = controllerClientes.retornarClienteController(jcboCliente.getSelectedItem().toString());
            jtxtCDC.setText(String.valueOf(modelCliente.getCdc()));
            codigoCliente = modelCliente.getCdc();
            codEnergisa = modelCliente.getCod_energisa();
            jtxtEnergisa.setText(String.valueOf(modelCliente.getSigla()));
            DefaultTableModel modelo = (DefaultTableModel) jTClienteTabela.getModel();
            modelo.setNumRows(0);
            modelo.addRow(new Object[]{
                modelCliente.getEndereco(),
                modelCliente.getNumero(),
                modelCliente.getBairro(),
                modelCliente.getCidade(),
                modelCliente.getSigla(),
                modelCliente.getNumtel(),
                modelCliente.getEmail()
            });
        }
    }//GEN-LAST:event_jcboClientePopupMenuWillBecomeInvisible

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed

    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        modelSituacao = controllerSituacao.getSituacaoController(jcboSituacao.getSelectedItem().toString());
        codigoSituacao = modelSituacao.getCodSituacao();
        try {
            modelSolicitacaoGC.setCodSolicitacao(Integer.parseInt(jtxtCodigo.getText()));
        } catch (NumberFormatException e) {
        }
        modelSolicitacaoGC.setCodEnergisa(codEnergisa);
        modelSolicitacaoGC.setCDC(codigoCliente);
        modelSolicitacaoGC.setCodServico(codServico);
        modelSolicitacaoGC.setCodGrupo(codigoGrupoSolicitacao);
        modelSolicitacaoGC.setDataSolicitacao(jtxtDataSolicitacao.getText());
        modelSolicitacaoGC.setDataEncaminhamento(jtxtDataEncaminhamento.getDateFormatString());
        modelSolicitacaoGC.setCodResponsavel(codigoResponsavel);
        if (jcboSolicitacao.getSelectedItem().toString().equals("AUMENTO DE DEMANDA CONTRATADA") || (jcboSolicitacao.getSelectedItem().toString().equals("REDUÇÃO DE DEMANDA CONTRATADA"))) {
            System.out.println("teste");
            modelSolicitacaoGC.setDemAnteriorPonta(Integer.valueOf(jtxtPontaKWAnterior.getText()));
            modelSolicitacaoGC.setDemAnteriorForaPonta(Integer.valueOf(jtxtForaPontaKWAnterior.getText()));
            modelSolicitacaoGC.setDemSolicitadaPonta(Integer.valueOf(jtxtPontaKWSolicitada.getText()));
            modelSolicitacaoGC.setDemSolicitadaForaPonta(Integer.valueOf(jtxtForaPontaKWSolicitada.getText()));
        } else {
            modelSolicitacaoGC.setDemAnteriorPonta(0);
            modelSolicitacaoGC.setDemAnteriorForaPonta(0);
            modelSolicitacaoGC.setDemSolicitadaPonta(0);
            modelSolicitacaoGC.setDemSolicitadaForaPonta(0);
        }
        modelSolicitacaoGC.setCodSituacao(codigoSituacao);
        modelSolicitacaoGC.setPrioridade(jtxtPrioridade.getText());
        modelSolicitacaoGC.setDataResposta(jtxtDataResposta.getDateFormatString());
        modelSolicitacaoGC.setDataLimite(jtxtDataLimite.getText());
        modelSolicitacaoGC.setObservacao(jtxtaObservacao.getText());

        System.out.println(modelSolicitacaoGC.getCodEnergisa());
        System.out.println(modelSolicitacaoGC.getCDC());
        System.out.println(modelSolicitacaoGC.getCodServico());
        System.out.println(modelSolicitacaoGC.getCodGrupo());
        System.out.println(modelSolicitacaoGC.getDataSolicitacao());
        System.out.println(modelSolicitacaoGC.getDataEncaminhamento());
        System.out.println(modelSolicitacaoGC.getCodResponsavel());
        System.out.println(modelSolicitacaoGC.getDemAnteriorPonta());
        System.out.println(modelSolicitacaoGC.getDemAnteriorForaPonta());
        System.out.println(modelSolicitacaoGC.getDemSolicitadaPonta());
        System.out.println(modelSolicitacaoGC.getDemSolicitadaForaPonta());
        System.out.println(modelSolicitacaoGC.getCodSituacao());
        System.out.println(modelSolicitacaoGC.getPrioridade());
        System.out.println(modelSolicitacaoGC.getDataResposta());
        System.out.println(modelSolicitacaoGC.getDataLimite());
        System.out.println(modelSolicitacaoGC.getObservacao());

        //JOptionPane.showMessageDialog(this, "Descrição: " + modelServico.getDescricao() + modelServico.getPrazo() + modelServico.getCodPerfil(), "Atenção", JOptionPane.WARNING_MESSAGE);
        if (alterarSalvar.equals("salvar")) {
            if (controllerSolicitacaoGC.salvarSolicitacaoGCController(modelSolicitacaoGC) > 0) {
                JOptionPane.showMessageDialog(this, "Solicitação cadastrada com sucesso!", "Atenção", JOptionPane.WARNING_MESSAGE);
                carregarSolicGC();
                this.habilitarDesabilitarCampos(false);
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar a solicitação!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            /*  if (controllerSolicitacaoGC.atualizarServicoController(modelServico)) {
                JOptionPane.showMessageDialog(this, "Solicitação alterado com sucesso!", "Atenção", JOptionPane.WARNING_MESSAGE);
                //carregarServicos();
                this.habilitarDesabilitarCampos(false);
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao alterar a solicitação!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }*/
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        jtxtDataSolicitacao.setText(getDataAtual());
        habilitarDesabilitarCampos(true);
        jcboSituacao.removeAllItems();
        alterarSalvar = "salvar";
        jcboSituacao.addItem("NÃO INICIADO");
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaActionPerformed

    }//GEN-LAST:event_jbBuscaActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        jtxtPesquisa.setText("");
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jcboSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboSolicitacaoActionPerformed

    }//GEN-LAST:event_jcboSolicitacaoActionPerformed

    private void jcboSolicitacaoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcboSolicitacaoPopupMenuWillBecomeInvisible
        if (jcboSolicitacao.isPopupVisible()) {
            GregorianCalendar gc = new GregorianCalendar();
            int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
            modelServico = controllerServico.getServicoController(jcboSolicitacao.getSelectedItem().toString());
            codServico = modelServico.getCodServico();
            int prazo = modelServico.getPrazo();
            DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate da = LocalDate.parse(jtxtDataSolicitacao.getText(), parser);
            LocalDate prazoLim = da;
            int prazoTotal = 0;
            switch (diaDaSemana) {
                case 2:
                    if (prazo == 0) {
                        prazoLim = da;
                        prazoTotal = 0;
                    } else if (prazo == 1) { // segunda
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 1;
                    } else if (prazo == 2) {
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 3) {
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 3;
                    } else if (prazo == 4) {
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 4;
                    } else if (prazo == 5) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 5;
                    }
                    break;
                case 3:
                    if (prazo == 0) {
                        prazoLim = da;
                        prazoTotal = 0;
                    } else if (prazo == 1) { // terça
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 1;
                    } else if (prazo == 2) {
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 3) {
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 3;
                    } else if (prazo == 4) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 4;
                    } else if (prazo == 5) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 5;
                    }
                    break;
                case 4:
                    if (prazo == 0) {
                        prazoLim = da;
                        prazoTotal = 0;
                    } else if (prazo == 1) { // quarta
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 1;
                    } else if (prazo == 2) {
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 3) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 3;
                    } else if (prazo == 4) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 4;
                    } else if (prazo == 5) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 5;
                    }
                    break;
                case 5:
                    if (prazo == 0) {
                        prazoLim = da;
                        prazoTotal = 0;
                    } else if (prazo == 1) { // quinta
                        prazoLim = da.plusDays(prazo);
                        prazoTotal = prazo + 1;
                    } else if (prazo == 2) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 3) {
                        prazoTotal = prazo + 2;
                        prazoLim = da.plusDays(prazo + 2);
                    } else if (prazo == 4) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 5) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 2;
                    }
                    break;
                case 6:
                    if (prazo == 0) {
                        prazoLim = da;
                        prazoTotal = 0;
                    } else if (prazo == 1) { // sexta
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 2) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 3) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 4) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 2;
                    } else if (prazo == 5) {
                        prazoLim = da.plusDays(prazo + 2);
                        prazoTotal = prazo + 2;
                    }
                    break;
            }
            String dataFormatada = parser.format(prazoLim);
            jtxtDataLimite.setText(dataFormatada);
            mostrarPrioridade(prazoTotal);
        }
    }//GEN-LAST:event_jcboSolicitacaoPopupMenuWillBecomeInvisible

    private void jcboSituacaoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcboSituacaoPopupMenuWillBecomeInvisible
        if (jcboSituacao.isPopupVisible()) {
            modelSituacao = controllerSituacao.getSituacaoController(jcboSituacao.getSelectedItem().toString());
            codigoSituacao = modelSituacao.getCodSituacao();
        }
    }//GEN-LAST:event_jcboSituacaoPopupMenuWillBecomeInvisible

    private void jcboSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboSituacaoActionPerformed

    private void jbCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadClienteActionPerformed
        new ViewCliente().setVisible(true);
    }//GEN-LAST:event_jbCadClienteActionPerformed

    private void jbCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadUsuarioActionPerformed
        new ViewUsuario().setVisible(true);
    }//GEN-LAST:event_jbCadUsuarioActionPerformed

    private void jbCadSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadSolicitacaoActionPerformed
        new ViewServico().setVisible(true);
    }//GEN-LAST:event_jbCadSolicitacaoActionPerformed

    private void jcboSolicitacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcboSolicitacaoFocusLost

    }//GEN-LAST:event_jcboSolicitacaoFocusLost

    private void jcboSolicitacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcboSolicitacaoItemStateChanged
        // TODO add your handling code here:
        String servico = jcboSolicitacao.getSelectedItem().toString();
        if (servico.equals("AUMENTO DE DEMANDA CONTRATADA") || servico.equals("REDUÇÃO DE DEMANDA CONTRATADA")) {
            habilitarDemanda(true);
        } else {
            habilitarDemanda(false);
        }
    }//GEN-LAST:event_jcboSolicitacaoItemStateChanged

    private void jcboSolicitacaoPopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcboSolicitacaoPopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboSolicitacaoPopupMenuCanceled

    private void jcboGrupoSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboGrupoSolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboGrupoSolActionPerformed

    private void jcboGrupoSolPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcboGrupoSolPopupMenuWillBecomeInvisible
        if (jcboGrupoSol.isPopupVisible()) {
            modelGrupoSolicitacao = controllerGrupoSolicitacao.getGrupoSolicitacaoController(jcboGrupoSol.getSelectedItem().toString());
            codigoGrupoSolicitacao = modelGrupoSolicitacao.getCodGrupoSolicitacao();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jcboGrupoSolPopupMenuWillBecomeInvisible

    private void jbCadGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadGrupoActionPerformed
        // TODO add your handling code here:
        new ViewGrupoSolicitacao(this).setVisible(true);
    }//GEN-LAST:event_jbCadGrupoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSolicitacaoGC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSolicitacaoGC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSolicitacaoGC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSolicitacaoGC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSolicitacaoGC().setVisible(true);
            }
        });
    }

    public void habilitarDemanda(boolean condicao) {
        jpDemandaSolicitada.setEnabled(condicao);
        jlblForaPontaDemAnterior.setEnabled(condicao);
        jlblForaPontaDemSolicitada.setEnabled(condicao);
        jlblPontaDemAnterior.setEnabled(condicao);
        jlblPontaDemSolicitada.setEnabled(condicao);
        jpDemandaAnterior.setEnabled(condicao);
        jtxtForaPontaKWAnterior.setEnabled(condicao);
        jtxtForaPontaKWSolicitada.setEnabled(condicao);
        jtxtPontaKWAnterior.setEnabled(condicao);
        jtxtPontaKWSolicitada.setEnabled(condicao);
    }

    private void limparCampos() {
        //jTCodigo.setText("");
        //jTDescricaoServ.setText("");
        //jCBPrazo.addItem("ESCOLHA");
        //jCBPerfil.addItem("ESCOLHA");
    }

    public void mostrarPrioridade(int prazo) {
        switch (prazo) {
            case 0:
            case 1:
                jtxtPrioridade.setText("URGENTE");
                break;
            case 2:
            case 3:
                jtxtPrioridade.setText("ALTA");
                break;
            case 4:
            case 5:
                jtxtPrioridade.setText("NORMAL");
                break;
            default:
                jtxtPrioridade.setText("BAIXA");
                break;
        }
    }

    public void habilitarDesabilitarCampos(boolean condicao) {
        //jTCodigo.setEnabled(condicao);
        jtxtCodigo.setEnabled(condicao);
        jtxtEnergisa.setEnabled(condicao);
        jtxtCDC.setEnabled(condicao);
        jcboCliente.setEnabled(condicao);
        jcboSolicitacao.setEnabled(condicao);
        jcboGrupoSol.setEnabled(condicao);
        jtxtDataSolicitacao.setEnabled(condicao);
        jtxtDataEncaminhamento.setEnabled(condicao);
        jcboResponsavel.setEnabled(condicao);
        jcboSituacao.setEnabled(condicao);
        jtxtDataResposta.setEnabled(condicao);
        jtxtaObservacao.setEnabled(condicao);
        jTClienteTabela.setEnabled(condicao);
        jbCadCliente.setEnabled(condicao);
        jbCadGrupo.setEnabled(condicao);
        jtxtPrioridade.setEnabled(condicao);
        jbCadSolicitacao.setEnabled(condicao);
        jbCadUsuario.setEnabled(condicao);
        jtxtDataLimite.setEnabled(condicao);
        jbSalvar.setEnabled(condicao);
    }

    private void carregarSolicGC() {
        listaModelSolicitacaoGC = controllerSolicitacaoGC.retornarListaClienteController();
        DefaultTableModel modelo = (DefaultTableModel) jTSolicitacaoTabela.getModel();
        modelo.setNumRows(0);
        // inserir produtos na tabela
        int cont = listaModelSolicitacaoGC.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelSolicitacaoGC.get(i).getCDC(),
                listaModelSolicitacaoGC.get(i).getNomeEnergisa(),
                listaModelSolicitacaoGC.get(i).getNomeCliente(),
                listaModelSolicitacaoGC.get(i).getResponsavel(),
                listaModelSolicitacaoGC.get(i).getServico(),
                listaModelSolicitacaoGC.get(i).getSLA_D_U(),
                listaModelSolicitacaoGC.get(i).getSituacao(),
                listaModelSolicitacaoGC.get(i).getPrioridade(),
                listaModelSolicitacaoGC.get(i).getDataSolicitacao(),
                listaModelSolicitacaoGC.get(i).getDataLimite()
            });
        }
        CorNaLinha();
    }

    public void CorNaLinha() {
        jTSolicitacaoTabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Color c = Color.WHITE;
                Object texto = table.getValueAt(row, 7);
                if (texto != null && texto.equals("BAIXA")) {
                    c = Color.GREEN;
                } else if (texto != null && texto.equals("NORMAL")) {
                    c = Color.YELLOW;
                } else if (texto != null && texto.equals("URGENTE")) {
                    c = Color.RED;
                } else if (texto != null && texto.equals("ALTA")) {
                    c = Color.ORANGE;
                }
                label.setBackground(c);
                jTSolicitacaoTabela.setSelectionForeground(Color.BLUE);
                return label;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTClienteTabela;
    private javax.swing.JTable jTSolicitacaoTabela;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbBusca;
    private javax.swing.JButton jbCadCliente;
    private javax.swing.JButton jbCadGrupo;
    private javax.swing.JButton jbCadSolicitacao;
    private javax.swing.JButton jbCadUsuario;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcboCliente;
    private javax.swing.JComboBox<String> jcboGrupoSol;
    private javax.swing.JComboBox<String> jcboPesquisa;
    private javax.swing.JComboBox<String> jcboResponsavel;
    private javax.swing.JComboBox<String> jcboSituacao;
    private javax.swing.JComboBox<String> jcboSolicitacao;
    private javax.swing.JLabel jlblForaPontaDemAnterior;
    private javax.swing.JLabel jlblForaPontaDemSolicitada;
    private javax.swing.JLabel jlblPontaDemAnterior;
    private javax.swing.JLabel jlblPontaDemSolicitada;
    private javax.swing.JPanel jpDemandaAnterior;
    private javax.swing.JPanel jpDemandaSolicitada;
    private javax.swing.JTextField jtxtCDC;
    private javax.swing.JTextField jtxtCodigo;
    private com.toedter.calendar.JDateChooser jtxtDataEncaminhamento;
    private javax.swing.JTextField jtxtDataLimite;
    private com.toedter.calendar.JDateChooser jtxtDataResposta;
    private javax.swing.JTextField jtxtDataSolicitacao;
    private javax.swing.JTextField jtxtEnergisa;
    private javax.swing.JTextField jtxtForaPontaKWAnterior;
    private javax.swing.JTextField jtxtForaPontaKWSolicitada;
    private javax.swing.JTextField jtxtPesquisa;
    private javax.swing.JTextField jtxtPontaKWAnterior;
    private javax.swing.JTextField jtxtPontaKWSolicitada;
    private javax.swing.JTextField jtxtPrioridade;
    private javax.swing.JTextArea jtxtaObservacao;
    // End of variables declaration//GEN-END:variables
}
