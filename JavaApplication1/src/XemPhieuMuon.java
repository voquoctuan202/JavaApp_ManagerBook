
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class XemPhieuMuon extends javax.swing.JFrame {

    /**
     * Creates new form XemPhieuMuon
     */
    MySQLConnect conn;
    int stt=0;
    public XemPhieuMuon() throws SQLException {
        initComponents();
        conn = new MySQLConnect();
        showDataDangDuyet();
    }
    public void showData() throws SQLException{
        String[] columnNames = {"Số thứ tự","Mã phiếu","Tên đọc giả","Tên sách","Ngày mượn","Ngày trả","Ghi chú","Tình trạng"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbPhieumuon.setModel(model);
        int stt =0;
        int maPhieumuon = 0;
        String tenDocGia = "";
        String tenSach ="";
        String ngaymuon="";
        String ngaytra="";
        String ghichu="";
        String tinhtrang="";
        
        ResultSet rs = conn.getData("select a.stt,a.maPhieumuon,c.tenDocgia,b.tenSach,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang from muonsach as a join sach as b on a.maSach = b.maSach join docgia as c on a.maDocGia = c.maDocgia;");
        try{
            while(rs.next()){
                stt = rs.getInt("stt");
                maPhieumuon = rs.getInt("maPhieumuon");
                tenDocGia = rs.getString("tenDocgia");
                tenSach = rs.getString("tenSach");
                ngaymuon = rs.getString("ngayMuon");
                ngaytra = rs.getString("ngayTra");
                ghichu = rs.getString("ghichu");
                tinhtrang = rs.getString("tinhtrang");
               
                
                model.addRow(new Object[]{stt,maPhieumuon,tenDocGia, tenSach, ngaymuon, ngaytra, ghichu, tinhtrang});
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void showDataDangMuon() throws SQLException{
        String[] columnNames = {"Số thứ tự","Mã phiếu","Tên đọc giả","Tên sách","Ngày mượn","Ngày trả","Ghi chú","Tình trạng"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbPhieumuon.setModel(model);
        int stt =0;
        int maPhieumuon = 0;
        String tenDocGia = "";
        String tenSach ="";
        String ngaymuon="";
        String ngaytra="";
        String ghichu="";
        String tinhtrang="";
        
        ResultSet rs = conn.getData("select a.stt,a.maPhieumuon,c.tenDocgia,b.tenSach,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang from muonsach as a join sach as b on a.maSach = b.maSach join docgia as c on a.maDocGia = c.maDocgia where a.tinhtrang = 'dangmuon'; ");
        try{
            while(rs.next()){
                stt = rs.getInt("stt");
                maPhieumuon = rs.getInt("maPhieumuon");
                tenDocGia = rs.getString("tenDocgia");
                tenSach = rs.getString("tenSach");
                ngaymuon = rs.getString("ngayMuon");
                ngaytra = rs.getString("ngayTra");
                ghichu = rs.getString("ghichu");
                tinhtrang = rs.getString("tinhtrang");
               
                
                model.addRow(new Object[]{stt,maPhieumuon,tenDocGia, tenSach, ngaymuon, ngaytra, ghichu, tinhtrang});
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void showDataDangDuyet() throws SQLException{
        String[] columnNames = {"Số thứ tự","Mã phiếu","Tên đọc giả","Tên sách","Ngày mượn","Ngày trả","Ghi chú","Tình trạng"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbPhieumuon.setModel(model);
        int stt =0;
        int maPhieumuon = 0;
        String tenDocGia = "";
        String tenSach ="";
        String ngaymuon="";
        String ngaytra="";
        String ghichu="";
        String tinhtrang="";
        
        ResultSet rs = conn.getData("select a.stt,a.maPhieumuon,c.tenDocgia,b.tenSach,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang from muonsach as a join sach as b on a.maSach = b.maSach join docgia as c on a.maDocGia = c.maDocgia where a.tinhtrang = 'dangduyet'; ");
        try{
            while(rs.next()){
                stt = rs.getInt("stt");
                maPhieumuon = rs.getInt("maPhieumuon");
                tenDocGia = rs.getString("tenDocgia");
                tenSach = rs.getString("tenSach");
                ngaymuon = rs.getString("ngayMuon");
                ngaytra = rs.getString("ngayTra");
                ghichu = rs.getString("ghichu");
                tinhtrang = rs.getString("tinhtrang");
               
                
                model.addRow(new Object[]{stt,maPhieumuon,tenDocGia, tenSach, ngaymuon, ngaytra, ghichu, tinhtrang});
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void showDataDaTra() throws SQLException{
        String[] columnNames = {"Số thứ tự","Mã phiếu","Tên đọc giả","Tên sách","Ngày mượn","Ngày trả","Ghi chú","Tình trạng"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbPhieumuon.setModel(model);
        int stt =0;
        int maPhieumuon = 0;
        String tenDocGia = "";
        String tenSach ="";
        String ngaymuon="";
        String ngaytra="";
        String ghichu="";
        String tinhtrang="";
        
        ResultSet rs = conn.getData("select a.stt,a.maPhieumuon,c.tenDocgia,b.tenSach,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang from muonsach as a join sach as b on a.maSach = b.maSach join docgia as c on a.maDocGia = c.maDocgia where a.tinhtrang = 'datra'; ");
        try{
            while(rs.next()){
                stt = rs.getInt("stt");
                maPhieumuon = rs.getInt("maPhieumuon");
                tenDocGia = rs.getString("tenDocgia");
                tenSach = rs.getString("tenSach");
                ngaymuon = rs.getString("ngayMuon");
                ngaytra = rs.getString("ngayTra");
                ghichu = rs.getString("ghichu");
                tinhtrang = rs.getString("tinhtrang");
               
                
                model.addRow(new Object[]{stt,maPhieumuon,tenDocGia, tenSach, ngaymuon, ngaytra, ghichu, tinhtrang});
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void getSelectedData(){
        int selectedRow = tbPhieumuon.getSelectedRow();
        stt =  parseInt(tbPhieumuon.getValueAt(selectedRow,0).toString()) ;
        String tinhtrang =tbPhieumuon.getValueAt(selectedRow,7).toString();
        if(tinhtrang.equals("dangduyet")){
            txtMaPhieumuon.setText(tbPhieumuon.getValueAt(selectedRow, 1).toString());
            txtTenSach.setText(tbPhieumuon.getValueAt(selectedRow, 3).toString());
            txtGhichu.setText(tbPhieumuon.getValueAt(selectedRow, 6).toString());
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng lựa chọn phiếu đang duyệt");
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhieumuon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbXemphieumuon = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieumuon = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnDuyetPhieu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhichu = new javax.swing.JTextArea();
        btnXemphieumuon = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        btnDuyetSach = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Xem phiếu mượn");

        jLabel2.setText("Mã phiếu mượn");

        jLabel3.setText("Tình trạng");

        cbXemphieumuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang mượn", "Đang chờ duyệt", "Đã trả" }));
        cbXemphieumuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbXemphieumuonActionPerformed(evt);
            }
        });

        jButton1.setText("Xem ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbPhieumuon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPhieumuon);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Duyệt phiếu mượn");

        btnDuyetPhieu.setText("Duyệt theo phiếu");
        btnDuyetPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuyetPhieuActionPerformed(evt);
            }
        });

        jLabel5.setText("Tình trạng thực tế");

        txtGhichu.setColumns(20);
        txtGhichu.setRows(5);
        jScrollPane2.setViewportView(txtGhichu);

        btnXemphieumuon.setText("Xem");
        btnXemphieumuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemphieumuonActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        jLabel6.setText("Tên sách:");

        btnDuyetSach.setText("Duyệt theo sách");
        btnDuyetSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuyetSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDuyetSach, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDuyetPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addGap(404, 404, 404))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMaPhieumuon)
                                        .addGap(84, 84, 84))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(312, 312, 312)
                                        .addComponent(btnChon))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbXemphieumuon, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnXemphieumuon)))))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTenSach))
                                .addGap(404, 404, 404))))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbXemphieumuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXemphieumuon))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaPhieumuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnChon))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDuyetSach)
                            .addComponent(btnDuyetPhieu))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbXemphieumuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbXemphieumuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbXemphieumuonActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         this.dispose();
        frmQuanLySach obj = null;
        try {
            obj = new frmQuanLySach();
        } catch (SQLException ex) {
            Logger.getLogger(XemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnXemphieumuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemphieumuonActionPerformed
        // TODO add your handling code here:
        int chon =0;
        chon = cbXemphieumuon.getSelectedIndex();
        switch (chon){
            case 0:
            {
                try {
                    showDataDangMuon();
                } catch (SQLException ex) {
                    Logger.getLogger(XemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 1:
                {
                try {
                    showDataDangDuyet();
                } catch (SQLException ex) {
                    Logger.getLogger(XemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2:
                {
                try {
                    showDataDaTra();
                } catch (SQLException ex) {
                    Logger.getLogger(XemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }//GEN-LAST:event_btnXemphieumuonActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        getSelectedData();
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnDuyetPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuyetPhieuActionPerformed
        // TODO add your handling code here:
        int maphieu =  parseInt(txtMaPhieumuon.getText());
        String ghichu =  txtGhichu.getText();
        if (ghichu.equals("")){
            JOptionPane.showMessageDialog(this, "Phải nhập tình trạng thực tế");
        }else{
           try {
            conn.ExcuteSQLDuyetPhieuMuon(maphieu, ghichu);
            showDataDangDuyet();
           } catch (SQLException ex) {
            Logger.getLogger(XemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        
    }//GEN-LAST:event_btnDuyetPhieuActionPerformed

    private void btnDuyetSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuyetSachActionPerformed
        // TODO add your handling code here:
   
        String ghichu =  txtGhichu.getText();
       if (ghichu.equals("")){
            JOptionPane.showMessageDialog(this, "Phải nhập tình trạng thực tế");
        }else{
           try {
            conn.ExcuteSQLDuyetSachmuon(stt, ghichu);
            showDataDangDuyet();
        } catch (SQLException ex) {
            Logger.getLogger(XemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        
    }//GEN-LAST:event_btnDuyetSachActionPerformed

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
            java.util.logging.Logger.getLogger(XemPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new XemPhieuMuon().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(XemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnDuyetPhieu;
    private javax.swing.JButton btnDuyetSach;
    private javax.swing.JButton btnXemphieumuon;
    private javax.swing.JComboBox<String> cbXemphieumuon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPhieumuon;
    private javax.swing.JTextArea txtGhichu;
    private javax.swing.JTextField txtMaPhieumuon;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
