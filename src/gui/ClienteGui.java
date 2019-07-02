/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.*;
import arquivo.Arquivo;
import conexoes.ConexaoSqliteArquivo;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodri
 */
public class ClienteGui extends javax.swing.JFrame {

    private long tamanhoPermitidoKB = 5120; // Igual a 5MB
    private Arquivo arquivo;
    private String usuario;
    private ArrayList<Arquivo> arquivos = new ArrayList();

    /**
     * Creates new form ClienteGui
     */
    public ClienteGui(String nome) {

        this.usuario = nome;

        initComponents();
        addRowInTable();

    }

    private void addRowInTable() {

        DefaultTableModel model = (DefaultTableModel) jTableArquivos.getModel();
        ArrayList<Arquivo> list = listarArquivos();
        Object rowData[] = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getNome();
            rowData[1] = list.get(i).getUsuario();
            rowData[2] = list.get(i).getDataModificacao();
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFrame2 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jTextFieldPorta = new javax.swing.JTextField();
        jButtonArquivo = new javax.swing.JButton();
        jButtonEnviar = new javax.swing.JButton();
        jButtonCompartilhar = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelTamanho = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableArquivos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UTFBox");
        setBackground(new java.awt.Color(0, 255, 0));
        setMaximumSize(new java.awt.Dimension(2147483, 2147483647));

        jLabel1.setText("Arquivo");

        jLabel2.setText("IP:");

        jLabel3.setText("Porta:");

        jLabel4.setText("Usuario: " + this.usuario);

        jLabel5.setText("Arquivos");

        jTextFieldPorta.setToolTipText("");

        jButtonArquivo.setText("Selecionar Arquivo");
        jButtonArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArquivoActionPerformed(evt);
            }
        });

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jButtonCompartilhar.setText("Compartilhar");

        jButtonDeletar.setText("Deletar");
        jButtonDeletar.setToolTipText("");

        jTextFieldNome.setEditable(false);

        jLabelTamanho.setText("Tamanho: ");

        jTableArquivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Autor", "Data Alteração"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableArquivos.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableArquivos);
        jTableArquivos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton1.setText("Baixar");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonArquivo)
                            .addComponent(jLabelTamanho)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonEnviar)
                                .addGap(34, 34, 34)
                                .addComponent(jButtonCompartilhar)
                                .addGap(168, 168, 168)
                                .addComponent(jButtonDeletar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(46, 46, 46)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextFieldNome)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel4)))
                .addGap(0, 202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButtonArquivo)
                .addGap(18, 18, 18)
                .addComponent(jLabelTamanho)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnviar)
                    .addComponent(jButtonCompartilhar)
                    .addComponent(jButtonDeletar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArquivoActionPerformed
        FileInputStream fis;
        try {

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setDialogTitle("Escolha o arquivo");

            if (chooser.showOpenDialog(this) == JFileChooser.OPEN_DIALOG) {
                File fileSelected = chooser.getSelectedFile();

                byte[] bFile = new byte[(int) fileSelected.length()];
                fis = new FileInputStream(fileSelected);
                fis.read(bFile);
                fis.close();

                long kbSize = fileSelected.length() / 1024;
                jTextFieldNome.setText(fileSelected.getName());
                jLabelTamanho.setText("Tamanho: " + kbSize + " KB");

                arquivo = new Arquivo();
                arquivo.setConteudo(bFile);
                arquivo.setDataHoraUpload(new Date());
                arquivo.setNome(fileSelected.getName());
                arquivo.setTamanhoKB(kbSize);
                arquivo.setIpDestino(jTextFieldIP.getText());
                arquivo.setPortaDestino(jTextFieldPorta.getText());
                arquivo.setUsuario(this.usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonArquivoActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        enviarArquivoServidor();
        this.dispose();
        new ClienteGui(this.usuario).setVisible(true);

    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //baixarArquivo(this.arquivo);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    private ArrayList listarArquivos() {
        ConexaoSqliteArquivo conexao = new ConexaoSqliteArquivo();
        ArrayList<Arquivo> arq = conexao.buscarArquivosUser(this.usuario);

        for (int i = 0; i < arq.size(); i++) {
            System.out.println(arq.get(i).getNome());
            //arquivos = conexao.buscarArquivosUser(this.usuario);
        }
        return arq;

    }

    private void enviarArquivoServidor() {
        if (validaArquivo()) {
            try {
                Socket socket = new Socket(jTextFieldIP.getText().trim(),
                        Integer.parseInt(jTextFieldPorta.getText().trim()));

                BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());

                byte[] bytea = serializarArquivo();
                bf.write(bytea);
                bf.flush();
                bf.close();
                socket.close();
                JOptionPane.showMessageDialog(null, "Arquivo enviado com sucesso!");

            } catch (UnknownHostException e) {
                //System.out.print("falha 1");
                JOptionPane.showMessageDialog(null, "Erro ao acessar o servidor");
                e.printStackTrace();
            } catch (IOException e) {
                //System.out.print("falha 2");
                JOptionPane.showMessageDialog(null, "Erro ao acessar o servidor");
                e.printStackTrace();
            }
        }
    }

    /*public void baixarArquivo(File file) {
        int buffer;
        Socket socket = null;
        BufferedInputStream in = null;
        DataOutputStream out = null;
        try {
            socket = new Socket(jTextFieldIP.getText().trim(),
                    Integer.parseInt(jTextFieldPorta.getText().trim()));
            in = new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)));
            out = new DataOutputStream(socket.getOutputStream());

            while ((buffer = in.read()) != -1) {
                out.write(buffer);
                out.flush();
                //totalEnviado++;
            }
            //detalhes();
        } catch (IOException e) {
            e.printStackTrace(out);
        } finally {
            try {
                socket.close();
                in.close();
                out.flush();
                out.close();
            } catch (IOException e) {
                //e.printStackTrace(outUsu);
            }
        }
    }*/

    private byte[] serializarArquivo() {
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream ous;
            ous = new ObjectOutputStream(bao);
            ous.writeObject(arquivo);
            return bao.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean validaArquivo() {
        if (arquivo.getTamanhoKB() > tamanhoPermitidoKB) {
            JOptionPane.showMessageDialog(this,
                    "Tamanho máximo permitido atingido (" + (tamanhoPermitidoKB / 1024) + ")");
            return false;
        } else {
            return true;
        }
    }

    /*
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteGui().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonArquivo;
    private javax.swing.JButton jButtonCompartilhar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTamanho;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableArquivos;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPorta;
    // End of variables declaration//GEN-END:variables
}
