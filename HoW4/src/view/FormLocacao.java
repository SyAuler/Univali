package view;

import dao.DAOCliente;
import dao.DAOCarro;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import dao.DAOLocacao;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelCliente;
import model.ModelCarro;
import model.ModelLocacao;

public class FormLocacao extends javax.swing.JDialog {

    DAOLocacao daoLocacao = new DAOLocacao();
    DAOCliente daoCliente = new DAOCliente();
    DAOCarro DAOCarro = new DAOCarro();

    public void atualizaTabela() {
        listObjetos.clear();
        listObjetos.addAll(daoLocacao.getLista());
        int linha = listObjetos.size() - 1;
        if (linha >= 0) {
            tblObjetos.setRowSelectionInterval(linha, linha);
            tblObjetos.scrollRectToVisible(tblObjetos.getCellRect(linha, linha, true));
        }
    }

    public FormLocacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listCliente.clear();
        listCarro.clear();
        listCliente.addAll(daoCliente.getLista());
        listCarro.addAll(DAOCarro.getLista());
        atualizaTabela();
        trataEdicao(false);
    }

    private void trataEdicao(boolean editando) {
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnEditar.setEnabled(!editando);
        btnExcluir.setEnabled(!editando);
        btnNovo.setEnabled(!editando);
        btnFechar.setEnabled(!editando);
        btnPrimeiro.setEnabled(!editando);
        btnProximo.setEnabled(!editando);
        btnUltimo.setEnabled(!editando);
        btnAnterior.setEnabled(!editando);
        txtCodigo.setEnabled(editando);              
        cbxCliente.setEnabled(editando);    
        cbxCarro.setEnabled(editando);     
        txtValor.setEnabled(editando); 
        txtDataRetirada.setEnabled(editando);
        txtDataDevolucao.setEnabled(editando);
        jTextAreaObservacao.setEnabled(editando);
        tblObjetos.setEnabled(!editando);
    }

    public boolean validaCampos() {
        
        if (!(cbxCliente.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Cliente");
            cbxCliente.requestFocus();
            return false;
        }
        
        if (!(cbxCarro.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Informe o carro");
            cbxCarro.requestFocus();
            return false;
        }
        
        if (!(txtValor.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o valor do aluguel");
            txtValor.requestFocus();
            return false;
        }
        
        if (!(txtDataRetirada.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe a data de retirada");
            txtDataRetirada.requestFocus();
            return false;
        }
        
        if (!(txtDataDevolucao.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe a data de devolução");
            txtDataDevolucao.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listObjetos = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<model.ModelLocacao>())
        ;
        listCliente = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<ModelCliente>());
        listCarro = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<model.ModelCarro>())
        ;
        painelNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        abas = new javax.swing.JTabbedPane();
        abaListagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblObjetos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btn_Pesquisar = new javax.swing.JButton();
        abaDados = new javax.swing.JPanel();
        painelAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel_codigo = new javax.swing.JLabel();
        jLabel_nome = new javax.swing.JLabel();
        jLabel_produto = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDataRetirada = new javax.swing.JTextField();
        jLabel_cliente = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<String>();
        jLabel_filme = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtDataDevolucao = new javax.swing.JTextField();
        jLabel_filme1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObservacao = new javax.swing.JTextArea();
        jLabel_filme2 = new javax.swing.JLabel();
        cbxCarro = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pacotes");
        setMinimumSize(new java.awt.Dimension(900, 600));

        painelNavegacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Navegação"));
        painelNavegacao.setMaximumSize(new java.awt.Dimension(800, 80));
        painelNavegacao.setMinimumSize(new java.awt.Dimension(800, 80));
        painelNavegacao.setPreferredSize(new java.awt.Dimension(800, 80));
        painelNavegacao.setLayout(new java.awt.GridLayout(1, 0));

        btnPrimeiro.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/primeiro.png"))); // NOI18N
        btnPrimeiro.setText("Primeiro");
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnPrimeiro);

        btnAnterior.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anterior.png"))); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnAnterior);

        btnProximo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/proximo.png"))); // NOI18N
        btnProximo.setText("Proximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnProximo);

        btnUltimo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ultimo.png"))); // NOI18N
        btnUltimo.setText("Ultimo");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnUltimo);

        btnFechar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnFechar);

        getContentPane().add(painelNavegacao, java.awt.BorderLayout.NORTH);

        abas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        abaListagem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        abaListagem.setLayout(new java.awt.BorderLayout());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listObjetos, tblObjetos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cliente}"));
        columnBinding.setColumnName("Cliente");
        columnBinding.setColumnClass(model.ModelCliente.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${carro}"));
        columnBinding.setColumnName("Carro");
        columnBinding.setColumnClass(model.ModelCarro.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valor}"));
        columnBinding.setColumnName("Valor");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataRetirada}"));
        columnBinding.setColumnName("Data Retirada");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataDevolucao}"));
        columnBinding.setColumnName("Data Devolucao");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${observacao}"));
        columnBinding.setColumnName("Observacao");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblObjetos);

        abaListagem.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Pesquisa");

        txtPesquisar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPesquisar.setMaximumSize(new java.awt.Dimension(600, 40));
        txtPesquisar.setMinimumSize(new java.awt.Dimension(600, 40));
        txtPesquisar.setPreferredSize(new java.awt.Dimension(600, 40));

        btn_Pesquisar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btn_Pesquisar.setText("Pesquisar");
        btn_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Pesquisar)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Pesquisar))
                .addContainerGap())
        );

        abaListagem.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        abas.addTab("Listagem", abaListagem);

        abaDados.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        abaDados.setMaximumSize(null);
        abaDados.setRequestFocusEnabled(false);

        painelAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));
        painelAcoes.setMaximumSize(new java.awt.Dimension(800, 80));
        painelAcoes.setMinimumSize(new java.awt.Dimension(800, 80));
        painelAcoes.setPreferredSize(new java.awt.Dimension(800, 80));
        painelAcoes.setLayout(new java.awt.GridLayout(1, 0));

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        painelAcoes.add(btnNovo);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnEditar);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unavailable.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnCancelar);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnSalvar);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        painelAcoes.add(btnExcluir);

        jLabel_codigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_codigo.setText("Código");

        jLabel_nome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_nome.setText("Data de Retirada");

        jLabel_produto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_produto.setText("Data de Devolução");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblObjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigo}"), txtCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtDataRetirada.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblObjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtDataRetirada, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtDataRetirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataRetiradaActionPerformed(evt);
            }
        });

        jLabel_cliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_cliente.setText("Cliente");

        cbxCliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCliente, cbxCliente);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblObjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cliente.nome}"), cbxCliente, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel_filme.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_filme.setText("Carro");

        txtValor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDataDevolucao.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDevolucaoActionPerformed(evt);
            }
        });

        jLabel_filme1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_filme1.setText("Valor");

        jTextAreaObservacao.setColumns(20);
        jTextAreaObservacao.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservacao);

        jLabel_filme2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_filme2.setText("Observações");

        cbxCarro.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCarro, cbxCarro);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblObjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.carro.nome}"), cbxCarro, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout abaDadosLayout = new javax.swing.GroupLayout(abaDados);
        abaDados.setLayout(abaDadosLayout);
        abaDadosLayout.setHorizontalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel_cliente)
                                    .addComponent(jLabel_filme)
                                    .addComponent(jLabel_filme1)
                                    .addComponent(jLabel_codigo))
                                .addGap(18, 18, 18)
                                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor)
                                    .addComponent(cbxCliente, 0, 366, Short.MAX_VALUE)
                                    .addComponent(cbxCarro, 0, 366, Short.MAX_VALUE)))
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel_filme2)
                                    .addComponent(jLabel_nome)
                                    .addComponent(jLabel_produto))
                                .addGap(18, 18, 18)
                                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 284, Short.MAX_VALUE)))
                .addContainerGap())
        );
        abaDadosLayout.setVerticalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_codigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_cliente)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_filme)
                    .addComponent(cbxCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_filme1))
                .addGap(11, 11, 11)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nome)
                    .addComponent(txtDataRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_produto)
                    .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_filme2))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        abas.addTab("Dados", abaDados);

        getContentPane().add(abas, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        listObjetos.add((ModelLocacao) new ModelLocacao());
        int linha = listObjetos.size() - 1;
        tblObjetos.setRowSelectionInterval(linha, linha);
        trataEdicao(true);
        txtDataRetirada.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validaCampos()) {
            int linhaSelecionada = tblObjetos.getSelectedRow();
            ModelLocacao obj = listObjetos.get(linhaSelecionada);
            daoLocacao.salvar(obj);
            trataEdicao(false);
            atualizaTabela();
    }//GEN-LAST:event_btnSalvarActionPerformed
    }
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        trataEdicao(true);
        txtDataRetirada.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        trataEdicao(false);
        atualizaTabela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tblObjetos.getSelectedRow();
        ModelLocacao obj = listObjetos.get(linhaSelecionada);
        daoLocacao.remover(obj);
        atualizaTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        tblObjetos.setRowSelectionInterval(0, 0);
        tblObjetos.scrollRectToVisible(tblObjetos.getCellRect(0, 0, true));
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        int linha = tblObjetos.getSelectedRow();
        if ((linha - 1) >= 0) {
            linha--;
        }      
        tblObjetos.setRowSelectionInterval(linha, linha);
        tblObjetos.scrollRectToVisible(tblObjetos.getCellRect(linha, 0, true));
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        int linha = tblObjetos.getSelectedRow();
        if ((linha + 1) <= (tblObjetos.getRowCount() - 1)) {
            linha++;
        }
        tblObjetos.setRowSelectionInterval(linha, linha);
        tblObjetos.scrollRectToVisible(tblObjetos.getCellRect(linha, 0, true));
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        int linha = tblObjetos.getRowCount() - 1;
        tblObjetos.setRowSelectionInterval(linha, linha);
        tblObjetos.scrollRectToVisible(tblObjetos.getCellRect(linha, 0, true));
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btn_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesquisarActionPerformed
        TableModel modelo = (TableModel) this.tblObjetos.getModel();
        final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
        this.tblObjetos.setRowSorter(classificador);
        String texto = txtPesquisar.getText().toLowerCase();
        classificador.setRowFilter(RowFilter.regexFilter(texto, 1));
    }//GEN-LAST:event_btn_PesquisarActionPerformed

    private void txtDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDevolucaoActionPerformed

    private void txtDataRetiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataRetiradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataRetiradaActionPerformed

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
            java.util.logging.Logger.getLogger(FormLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormLocacao dialog = new FormLocacao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaDados;
    private javax.swing.JPanel abaListagem;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btn_Pesquisar;
    private javax.swing.JComboBox cbxCarro;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_cliente;
    private javax.swing.JLabel jLabel_codigo;
    private javax.swing.JLabel jLabel_filme;
    private javax.swing.JLabel jLabel_filme1;
    private javax.swing.JLabel jLabel_filme2;
    private javax.swing.JLabel jLabel_nome;
    private javax.swing.JLabel jLabel_produto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaObservacao;
    private java.util.List<ModelCarro> listCarro;
    private java.util.List<ModelCliente> listCliente;
    private java.util.List<model.ModelLocacao> listObjetos;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelNavegacao;
    private javax.swing.JTable tblObjetos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDataDevolucao;
    private javax.swing.JTextField txtDataRetirada;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtValor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
