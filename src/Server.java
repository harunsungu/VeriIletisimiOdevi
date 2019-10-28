/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import  java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends javax.swing.JFrame {

    public Server() throws FileNotFoundException {
        initComponents();
         
    }
    ServerSocket serverSocket = null;
 Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
                FileInputStream fr=null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gonderButton = new javax.swing.JButton();
        dosyaYolutText = new javax.swing.JTextField();
        dosyaYoluLabel = new javax.swing.JLabel();
        portNoLabel = new javax.swing.JLabel();
        portNoText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gonderButton.setText("Gönder");
        gonderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gonderButtonActionPerformed(evt);
            }
        });

        dosyaYolutText.setText("C:\\Users\\ASUS\\Desktop\\dosya/yenidosya.txt");
        dosyaYolutText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaYolutTextActionPerformed(evt);
            }
        });

        dosyaYoluLabel.setText("Dosya Yolu :");

        portNoLabel.setText("Port No : ");

        portNoText.setText("3547");
        portNoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portNoTextActionPerformed(evt);
            }
        });

        jLabel1.setText("       Server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(portNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(dosyaYoluLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(portNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dosyaYolutText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(gonderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosyaYolutText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dosyaYoluLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gonderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dosyaYolutTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaYolutTextActionPerformed
      
    }//GEN-LAST:event_dosyaYolutTextActionPerformed

    private void portNoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portNoTextActionPerformed
      
    }//GEN-LAST:event_portNoTextActionPerformed

    private void gonderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gonderButtonActionPerformed
           String dosya=dosyaYolutText.getText();
        String port=portNoText.getText();
        int port1=Integer.valueOf(port);
        try {                                        
            try {
                serverSocket = new ServerSocket(port1);
            } catch (IOException ex) {
                System.out.println("Bu port kullanılamıyor");
            }
            ////////////////////////////////////////////////////////////////////
            try {
                socket = serverSocket.accept();
            } catch (IOException ex) {
                System.out.println("Client bağlanamadı");
            }
            ////////////////////////////////////////////////////////////////////
            try {
                
                out= socket.getOutputStream();
            } catch (IOException ex) {
                System.out.println("Soket Hatası ");
            }
            ////////////////////////////////////////////////////////////////////////
            try {
                fr = new FileInputStream(dosya);
                
            } catch (FileNotFoundException ex) {
                System.out.println("Dosya Bulunamadı. ");
            }
            ////////////////////////////////////////////////////////////////////////
            byte[] bytes = new byte[16 * 1024];
            try {
                fr.read(bytes,0,bytes.length);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            ////////////////////////////////////////////////////////////////////////
            try {
                out.write(bytes,0,bytes.length);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.close();
            in.close();
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_gonderButtonActionPerformed
    public static void main(String args[]) throws IOException {
       /* 
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Server().setVisible(true);
                    //new Client().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dosyaYoluLabel;
    private javax.swing.JTextField dosyaYolutText;
    private javax.swing.JButton gonderButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel portNoLabel;
    private javax.swing.JTextField portNoText;
    // End of variables declaration//GEN-END:variables
}
