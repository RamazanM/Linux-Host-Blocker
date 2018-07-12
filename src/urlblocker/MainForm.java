package urlblocker;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ramazan
 */
public class MainForm extends javax.swing.JFrame {
    public String selectedLine=null;
    public MainForm() {
        initComponents();
        updateForm();
        urlList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(!lse.getValueIsAdjusting()){
                    selectedLine=urlList.getSelectedValue();
                    deleteSelected.setText("Sil("+selectedLine+")");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        urlTxt = new javax.swing.JTextField();
        engelleBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        urlList = new javax.swing.JList<>();
        deleteSelected = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Engellenecek Site:");

        engelleBtn.setText("Engelle");
        engelleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engelleBtnActionPerformed(evt);
            }
        });

        urlList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(urlList);

        deleteSelected.setText("Seçileni Sil");
        deleteSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(engelleBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(deleteSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(urlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(engelleBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteSelected)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void engelleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engelleBtnActionPerformed
        blockUrl(urlTxt.getText());
        try {
            getBlockedUrls();
            updateForm();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_engelleBtnActionPerformed

    private void deleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedActionPerformed
        try {
            deleteUrl(selectedLine);
            updateForm();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_deleteSelectedActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    
    public ArrayList<UrlClass> getBlockedUrls() throws IOException{
        Path hostsPath=Paths.get("/etc/hosts");
        ArrayList<UrlClass> retList= new ArrayList<>();
        Charset cs=Charset.defaultCharset();
        BufferedReader reader=Files.newBufferedReader(hostsPath,cs);
        String line=null;
        while ((line = reader.readLine()) != null) {
            if(line.startsWith("0")){
                String[] splitted=line.split(" ");
                retList.add(new UrlClass(splitted[0], splitted[1]));
            }
        }
        reader.close();
        return retList;
    }
    public void blockUrl(String url){
        String urls[]={
            "0.0.0.0 "+url+"\n",
            "0.0.0.0 http://www."+url+"\n",
            "0.0.0.0 www."+url+"\n",
            "0.0.0.0 *."+url+"\n"
        };
        Path p = Paths.get("/etc/hosts");

        try (OutputStream out = new BufferedOutputStream(
          Files.newOutputStream(p, CREATE, APPEND))) {
          for(String tUrl:urls) out.write(tUrl.getBytes(), 0, tUrl.getBytes().length);  
          out.close();
        } catch (IOException x) {
          System.err.println(x);
        }
        
    }
    
    public void deleteUrl(String urlLineStr) throws IOException{
        Path hostsPath=Paths.get("/etc/hosts");
        ArrayList<String> list= new ArrayList<>();
        Charset cs=Charset.defaultCharset();
        BufferedReader reader=Files.newBufferedReader(hostsPath,cs);
        String line=null;
        while ((line = reader.readLine()) != null) 
            if(!line.contains(urlLineStr))list.add(line+"\n");
        OutputStream out = new BufferedOutputStream(Files.newOutputStream(hostsPath, StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING));
        for(String tLine:list) out.write(tLine.getBytes(), 0, tLine.getBytes().length);              
        reader.close();
        out.close();
    }
    
    public void updateForm(){
        try {
            ArrayList<UrlClass> blockedUrls=getBlockedUrls();
            DefaultListModel<String> lm=new DefaultListModel();
            for(UrlClass url:blockedUrls)lm.addElement(url.url);
            urlList.setModel(lm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteSelected;
    private javax.swing.JButton engelleBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> urlList;
    private javax.swing.JTextField urlTxt;
    // End of variables declaration//GEN-END:variables
}
