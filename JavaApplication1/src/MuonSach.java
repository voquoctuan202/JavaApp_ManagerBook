
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class MuonSach extends javax.swing.JFrame {

    /**
     * Creates new form MuonSach
     */
    String tk ="";
    MySQLConnect conn;
    DefaultTableModel modelTBMuonSach;
    ArrayList<String> danhsachmuon = new ArrayList<String>();
    public  MuonSach(String tentk) throws SQLException {
        initComponents();
        conn = new MySQLConnect();
        showData();
        modelTBMuonSach = createTableMuonSach();
        this.tk = tentk;
        System.out.print("Đây là tk: "+tk);
    }
       
    public void showData() throws SQLException{
        String[] columnNames = {"Mã Sách","Tên Sách","Mô tả","NXB","Tác Giả","Thể Loại","Tình Trạng","Tầng","Kệ"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbSachTrong.setModel(model);
        String maSach = "";
        String tenSach = "";
        String mota = "";
        String nxb ="";
        String tacgia="";
        String theloai="";
        String tinhtrang="";
        String tang="";
        String ke="";
        
        ResultSet rs = conn.getData("SELECT * FROM SACH WHERE tinhtrang='';");
        try{
            while(rs.next()){
                maSach = rs.getString("maSach");
                tenSach = rs.getString("tenSach");
                mota = rs.getString("mota");
                nxb = rs.getString("nxb");
                tacgia = rs.getString("tacgia");
                theloai = rs.getString("theloai");
                tinhtrang = rs.getString("tinhtrang");
                tang = rs.getString("tang");
                ke = rs.getString("ke");
                
                model.addRow(new Object[]{maSach, tenSach, mota, nxb, tacgia, theloai, tinhtrang, tang, ke});
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
     public void getSelectedData(){
        int selectedRow = tbSachTrong.getSelectedRow();
        
        txtMaSach.setText(tbSachTrong.getValueAt(selectedRow, 0).toString());
        
    }
     public void removeSelectedData(){
        int selectedRow = tbSachMuon.getSelectedRow();
       
        modelTBMuonSach.removeRow(selectedRow);
        danhsachmuon.remove(selectedRow);
       
        
        
        
    }
    public DefaultTableModel createTableMuonSach(){
        String[] columnNames = {"Mã Sách","Tên Sách","Mô tả","NXB","Tác Giả","Thể Loại"};
        DefaultTableModel model = new DefaultTableModel();
  
        model.setColumnIdentifiers(columnNames);
        tbSachMuon.setModel(model);
        return model; 
    }
    
    public void themSach() throws SQLException{
        String maSach = txtMaSach.getText();
        
        ResultSet rs = conn.getData("Select * from SACH Where maSach='"+maSach+"'");
        String tenSach = "";
        String mota = "";
        String nxb ="";
        String tacgia="";
        String theloai="";
        String tinhtrang="";
        if(!rs.next()){
            JOptionPane.showMessageDialog(this, "Mã sách không hợp lệ");
        }else{
            rs = conn.getData("Select * from SACH Where maSach='"+maSach+"'");
            try{

               while(rs.next()){
                   danhsachmuon.add(maSach);
                   tenSach = rs.getString("tenSach");
                   mota = rs.getString("mota");
                   nxb = rs.getString("nxb");
                   tacgia = rs.getString("tacgia");
                   theloai = rs.getString("theloai");
                   tinhtrang = rs.getString("tinhtrang");
                   if(tinhtrang.equals("")){

                       modelTBMuonSach.addRow(new Object[]{maSach, tenSach, mota, nxb, tacgia, theloai});

                   }else{
                        JOptionPane.showMessageDialog(this, "Mã sách này đã có người mượn");
                   }


               }    
             }catch(SQLException ex){
                 JOptionPane.showMessageDialog(this, "Mã sách không hợp lệ");
                 ex.printStackTrace();
             }
        }

    }
    public boolean kiemTraNgay(String chuoiNgay) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // Tắt chế độ linh hoạt của SimpleDateFormat

        try {
            // Chuyển chuỗi thành đối tượng Date
            Date ngay = sdf.parse(chuoiNgay);

            // Kiểm tra xem ngày có lớn hơn ngày hiện tại không
            Date ngayHienTai = new Date();
            return ngay.after(ngayHienTai);
        } catch (ParseException e) {
            // Nếu có lỗi ParseException, chuỗi không đúng định dạng
            return false;
        }
    }
    
    
    public void XacNhan() throws SQLException{
        String ngay = txtNgayTra.getText();
        if(kiemTraNgay(ngay)){
            int maPM = conn.createNewID("muonsach");
            String ngaytra = txtNgayTra.getText();
            Date ngayHienTai = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String ngaymuon = sdf.format(ngayHienTai);
           
            this.dispose();
            PhieuMuon obj = null;
            obj = new PhieuMuon(tk,maPM,ngaymuon,ngaytra,danhsachmuon);
            obj.setVisible(true);
//            System.out.println(maPM );
//            System.out.println(ngaymuon );
//            System.out.println(ngaytra );
//            System.out.println(danhsachmuon );
        }else{
            JOptionPane.showMessageDialog(this, "Ngày sai do không đúng định dạng \n hoặc ngày không ở tương lai");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSachTrong = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSachMuon = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnChon = new javax.swing.JButton();
        txtXoa = new javax.swing.JButton();
        txtThoat = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("MƯỢN SÁCH");

        jLabel2.setText("Mã Sách");

        jLabel4.setText("Danh sách còn trống");

        tbSachTrong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbSachTrong);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("DANH SÁCH MƯỢN");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbSachMuon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbSachMuon);

        jLabel6.setText("Ngày trả");

        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jButton3.setText("Trả sách");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("dd/mm/yyyy ");

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        txtXoa.setText("Xóa");
        txtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXoaActionPerformed(evt);
            }
        });

        txtThoat.setText("Thoát");
        txtThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnChon))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                                    .addComponent(txtThoat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtMaSach, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNgayTra, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                        .addComponent(jButton3)))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(btnXacNhan)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtXoa)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jButton3)
                    .addComponent(txtXoa)
                    .addComponent(txtThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXacNhan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(btnChon))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            themSach();
        } catch (SQLException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        getSelectedData();
    }//GEN-LAST:event_btnChonActionPerformed

    private void txtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXoaActionPerformed
        // TODO add your handling code here:
        removeSelectedData();
    }//GEN-LAST:event_txtXoaActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        try {
            // TODO add your handling code here:
            XacNhan();
        } catch (SQLException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login obj = null;
        obj = new Login();
        obj.setVisible(true);
        
    }//GEN-LAST:event_txtThoatActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         this.dispose();
        TraSach obj = null;
        obj = new TraSach(tk);
        obj.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MuonSach("").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbSachMuon;
    private javax.swing.JTable tbSachTrong;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JButton txtThoat;
    private javax.swing.JButton txtXoa;
    // End of variables declaration//GEN-END:variables
}
