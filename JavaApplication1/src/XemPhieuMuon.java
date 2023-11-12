
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
        String[] columnNames = {"Số thứ tự","Mã phiếu","Mã đọc giả","Số lượng","Ngày mượn","Ngày trả","Ghi chú","Tình trạng"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbPhieumuon.setModel(model);
        int stt =0;
        int maPhieumuon = 0;
        int maDocGia = 0;
        int slSach =0;
        String ngaymuon="";
        String ngaytra="";
        String ghichu="";
        String tinhtrang="";
        
        ResultSet rs = conn.getData("select a.maPhieumuon,c.maDocgia,count(*) as slSach,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang "
                + "                 from muonsach as a join sach as b on a.maSach = b.maSach "
                + "                 join docgia as c on a.maDocGia = c.maDocgia where a.tinhtrang = 'Đang mượn'"
                + "                 group by a.maPhieuMuon,c.maDocgia,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang ; ");
        try{
            while(rs.next()){
                stt = stt+1;
                maPhieumuon = rs.getInt("maPhieumuon");
                maDocGia = rs.getInt("maDocgia");
                slSach = rs.getInt("slSach");
                ngaymuon = rs.getString("ngayMuon");
                ngaytra = rs.getString("ngayTra");
                ghichu = rs.getString("ghichu");
                tinhtrang = rs.getString("tinhtrang");
               
                
                model.addRow(new Object[]{stt,maPhieumuon,maDocGia, slSach, ngaymuon, ngaytra, ghichu, tinhtrang});
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void showDataDangDuyet() throws SQLException{
        String[] columnNames = {"Số thứ tự","Mã phiếu","Mã đọc giả","Số lượng","Ngày mượn","Ngày trả","Ghi chú","Tình trạng"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbPhieumuon.setModel(model);
        int stt =0;
        int maPhieumuon = 0;
        int maDocGia = 0;
        int slSach =0;
        String ngaymuon="";
        String ngaytra="";
        String ghichu="";
        String tinhtrang="";
        
        ResultSet rs = conn.getData("select a.maPhieumuon,c.maDocgia,count(*) as slSach,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang "
                + "                 from muonsach as a join sach as b on a.maSach = b.maSach "
                + "                 join docgia as c on a.maDocGia = c.maDocgia where a.tinhtrang = 'Đang duyệt'"
                + "                 group by a.maPhieuMuon,c.maDocgia,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang ; ");
        try{
            while(rs.next()){
                stt = stt+1;
                maPhieumuon = rs.getInt("maPhieumuon");
                maDocGia = rs.getInt("maDocgia");
                slSach = rs.getInt("slSach");
                ngaymuon = rs.getString("ngayMuon");
                ngaytra = rs.getString("ngayTra");
                ghichu = rs.getString("ghichu");
                tinhtrang = rs.getString("tinhtrang");
               
                
                model.addRow(new Object[]{stt,maPhieumuon,maDocGia, slSach, ngaymuon, ngaytra, ghichu, tinhtrang});
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void showDataDaTra() throws SQLException{
        String[] columnNames = {"Số thứ tự","Mã phiếu","Mã đọc giả","Số lượng","Ngày mượn","Ngày trả","Ghi chú","Tình trạng"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbPhieumuon.setModel(model);
        int stt =0;
        int maPhieumuon = 0;
        int maDocGia = 0;
        int slSach =0;
        String ngaymuon="";
        String ngaytra="";
        String ghichu="";
        String tinhtrang="";
        
        ResultSet rs = conn.getData("select a.maPhieumuon,c.maDocgia,count(*) as slSach,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang "
                + "                 from muonsach as a join sach as b on a.maSach = b.maSach "
                + "                 join docgia as c on a.maDocGia = c.maDocgia where a.tinhtrang = 'Đã trả'"
                + "                 group by a.maPhieuMuon,c.maDocgia,a.ngayMuon,a.ngayTra,a.ghichu,a.tinhtrang ; ");
        try{
            while(rs.next()){
                stt = stt+1;
                maPhieumuon = rs.getInt("maPhieumuon");
                maDocGia = rs.getInt("maDocgia");
                slSach = rs.getInt("slSach");
                ngaymuon = rs.getString("ngayMuon");
                ngaytra = rs.getString("ngayTra");
                ghichu = rs.getString("ghichu");
                tinhtrang = rs.getString("tinhtrang");
               
                
                model.addRow(new Object[]{stt,maPhieumuon,maDocGia, slSach, ngaymuon, ngaytra, ghichu, tinhtrang});
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void DuyetPhieu() throws SQLException{
        int selectedRow = tbPhieumuon.getSelectedRow();
        System.out.print(selectedRow);
        
        int maphieu = parseInt(tbPhieumuon.getValueAt(selectedRow, 1).toString());
        int maDG = parseInt( tbPhieumuon.getValueAt(selectedRow, 2).toString());
        int soluong = parseInt(tbPhieumuon.getValueAt(selectedRow, 3).toString());
        String ngaymuon = tbPhieumuon.getValueAt(selectedRow, 4).toString();
        String ngaytra = tbPhieumuon.getValueAt(selectedRow, 5).toString();
        String ghichu = tbPhieumuon.getValueAt(selectedRow, 6).toString(); 
        String tinhtrang =tbPhieumuon.getValueAt(selectedRow,7).toString();
        System.out.println(maphieu);
        
        if(tinhtrang.equals("Đang duyệt")){
            
            DuyetPhieuMuon obj = null;
            obj = new DuyetPhieuMuon(maphieu,maDG,soluong,ngaymuon,ngaytra,ghichu) ;
            obj.setVisible(true);
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
        jLabel3 = new javax.swing.JLabel();
        cbXemphieumuon = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieumuon = new javax.swing.JTable();
        btnXemphieumuon = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("XEM PHIẾU MƯỢN");

        jLabel3.setText("Tình trạng:");

        cbXemphieumuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang chờ duyệt", "Đang mượn", "Đã trả" }));
        cbXemphieumuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbXemphieumuonActionPerformed(evt);
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

        btnChon.setText("Duyệt");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbXemphieumuon, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnXemphieumuon, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbXemphieumuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnXemphieumuon)
                    .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        try {
            // TODO add your handling code here:
            DuyetPhieu();
        } catch (SQLException ex) {
            Logger.getLogger(XemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChonActionPerformed

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
    private javax.swing.JButton btnXemphieumuon;
    private javax.swing.JComboBox<String> cbXemphieumuon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPhieumuon;
    // End of variables declaration//GEN-END:variables
}
