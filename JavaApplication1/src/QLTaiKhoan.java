
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

public class QLTaiKhoan extends javax.swing.JFrame {

    /**
     * Creates new form QLTaiKhoan
     */
    int matk =0;
    MySQLConnect conn;
    public QLTaiKhoan() throws SQLException {
        initComponents();
        conn = new MySQLConnect();
        showData();
    }
    public void showData() throws SQLException{
        String[] columnNames = {"Mã tài khoản","Tên tài khoản","Mật khẩu","Tên người dùng","Số điện thoại","Email","Quyền"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbTK.setModel(model);
        int maTK =0;
        String tenTK = "";
        String matkhau ="";
        String sdt="";
        String quyen="";
        String tenND ="";
        String email="";
    
        
        
        ResultSet rsDG = conn.getData("select a.maTK,a.tenTaiKhoan,a.matkhau,b.tenDocgia,b.email,b.sdt,a.quyen\n" +
                                        "from taikhoan as a\n" +
                                        "join docgia as b\n" +
                                        "on b.maTK = a.maTK;");
        ResultSet rsQL = conn.getData("select a.maTK,a.tenTaiKhoan,a.matkhau,b.tenQuanly,b.email,b.sdt,a.quyen\n" +
                                        "from taikhoan as a\n" +
                                        "join quanly as b\n" +
                                        "on b.maTK = a.maTK;");
        try{
            while(rsDG.next()){
                maTK = rsDG.getInt("maTK");
                tenTK = rsDG.getString("tenTaiKhoan");
                matkhau = rsDG.getString("matkhau");
                tenND = rsDG.getString("tenDocgia");
                sdt = rsDG.getString("sdt");
                email = rsDG.getString("email");
                quyen = rsDG.getString("quyen");

                
                model.addRow(new Object[]{maTK,tenTK,matkhau,tenND, sdt,  email, quyen});
            } 
            while(rsQL.next()){
                maTK = rsQL.getInt("maTK");
                tenTK = rsQL.getString("tenTaiKhoan");
                matkhau = rsQL.getString("matkhau");
                quyen = rsQL.getString("quyen");
                sdt = rsQL.getString("sdt");
                tenND = rsQL.getString("tenQuanly");
                email = rsQL.getString("email");
               
               
                
                model.addRow(new Object[]{maTK,tenTK,matkhau,tenND, sdt,  email, quyen});
            }
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void showDataQuanLy() throws SQLException{
        String[] columnNames = {"Mã tài khoản","Tên tài khoản","Mật khẩu","Tên người dùng","Số điện thoại","Email","Quyền"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbTK.setModel(model);
        int maTK =0;
        String tenTK = "";
        String matkhau ="";
        String sdt="";
        String quyen="";
        String tenND ="";
        String email="";
      
        
        
       ResultSet rsQL = conn.getData("select a.maTK,a.tenTaiKhoan,a.matkhau,b.tenQuanly,b.email,b.sdt,a.quyen\n" +
                                        "from taikhoan as a\n" +
                                        "join quanly as b\n" +
                                        "on b.maTK = a.maTK;");
        try{
            while(rsQL.next()){
                maTK = rsQL.getInt("maTK");
                tenTK = rsQL.getString("tenTaiKhoan");
                matkhau = rsQL.getString("matkhau");
                quyen = rsQL.getString("quyen");
                sdt = rsQL.getString("sdt");
                tenND = rsQL.getString("tenQuanly");
                email = rsQL.getString("email");
               
                
                
                model.addRow(new Object[]{maTK,tenTK,matkhau,tenND, sdt,  email, quyen});
            }
       
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void showDataDocGia() throws SQLException{
        String[] columnNames = {"Mã tài khoản","Tên tài khoản","Mật khẩu","Tên người dùng","Số điện thoại","Email","Quyền"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbTK.setModel(model);
        int maTK =0;
        String tenTK = "";
        String matkhau ="";
        String sdt="";
        String quyen="";
        String tenND ="";
        String email="";
        String str_quyen="";
        
        
        ResultSet rsDG = conn.getData("select a.maTK,a.tenTaiKhoan,a.matkhau,b.tenDocgia,b.email,b.sdt,a.quyen\n" +
                                        "from taikhoan as a\n" +
                                        "join docgia as b\n" +
                                        "on b.maTK = a.maTK;");
        try{
            while(rsDG.next()){
                maTK = rsDG.getInt("maTK");
                tenTK = rsDG.getString("tenTaiKhoan");
                matkhau = rsDG.getString("matkhau");
                tenND = rsDG.getString("tenDocgia");
                sdt = rsDG.getString("sdt");
                email = rsDG.getString("email");
                quyen = rsDG.getString("quyen");
               
                
                model.addRow(new Object[]{maTK,tenTK,matkhau,tenND, sdt,  email, quyen});
            } 
       
          }catch(SQLException ex){
              ex.printStackTrace();
          }
     }
    public void getData(){
        int selectedRow = tbTK.getSelectedRow();
        
        matk = parseInt(tbTK.getValueAt(selectedRow, 0).toString());
        txtTenTK.setText(tbTK.getValueAt(selectedRow, 1).toString());
        txtMatKhau.setText(tbTK.getValueAt(selectedRow, 2).toString());
        String quyen = tbTK.getValueAt(selectedRow, 6).toString();
        if(quyen.equals("Độc giả")){
            cbQuyen.setSelectedIndex(1);
        }else{
           cbQuyen.setSelectedIndex(2);
        }
        
        txtTenND.setText(tbTK.getValueAt(selectedRow, 3).toString());
        txtEmail.setText(tbTK.getValueAt(selectedRow, 5).toString());
        txtSDT.setText(tbTK.getValueAt(selectedRow, 4).toString());
      
    
    }
    public void ClearText(){
       
        txtTenTK.setText("");
        txtMatKhau.setText("");
        cbQuyen.setSelectedIndex(0);
        txtTenND.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
    }
    public void DeleteData() throws SQLException{
        
        String quyen ="";
        if(cbQuyen.getSelectedIndex()==1){
            quyen="Độc giả";
        }else{
            quyen="Quản lý";
        }
        int isDelete = conn.ExcuteSQLDeleteTaiKhoan(matk,quyen);
        if(isDelete>0){
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại, kiểm tra lại");
        }
        showData();
        ClearText();
     }
    public void UpdateData() throws SQLException{
        String quyen ="";
        if(cbQuyen.getSelectedIndex()==1){
            quyen="Độc giả";
        }else{
            quyen="Quản lý";
        }
        String []stringsSQL = {txtTenTK.getText(),txtMatKhau.getText(),quyen,txtTenND.getText(),txtEmail.getText(),txtSDT.getText()};
        
        int isUpdate = conn.ExcuteSQLUpdateTaiKhoan(matk,stringsSQL);
        if(isUpdate>0){
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại, kiểm tra lại");
        }
        showData();
        ClearText();
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTK = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTenTK = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        lable = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbChonTK = new javax.swing.JComboBox<>();
        btnXem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenND = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cbQuyen = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quản lý tài khoản");

        btnCapNhat.setText("Câp nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        tbTK.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbTK);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên tài khoản");

        jLabel4.setText("Số điện thoại");

        lable.setText("Mật khẩu");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Quyền");

        jLabel6.setText("Chọn tài khoản");

        cbChonTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Độc giả", "Quản lý" }));

        btnXem.setText("Xem");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên người dùng");

        jLabel7.setText("Email: ");

        cbQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Người dùng", "Quản lý" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbChonTK, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnXem))
                                .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTenND, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(txtTenTK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                                .addComponent(cbQuyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(477, 477, 477))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnChon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTenND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbChonTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXem))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnCapNhat))
                        .addGap(25, 126, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        getData();
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            // TODO add your handling code here:
            DeleteData();
        } catch (SQLException ex) {
            Logger.getLogger(QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        int index = cbChonTK.getSelectedIndex();
        switch(index){
            case 0: {
                try {
                    showData();
                } catch (SQLException ex) {
                    Logger.getLogger(QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case 1: {
                try {
                    showDataDocGia();
                } catch (SQLException ex) {
                    Logger.getLogger(QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case 2: {
                try {
                    showDataQuanLy();
                } catch (SQLException ex) {
                    Logger.getLogger(QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           break;

        }
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            // TODO add your handling code here:
            UpdateData();
        } catch (SQLException ex) {
            Logger.getLogger(QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

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
            java.util.logging.Logger.getLogger(QLTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QLTaiKhoan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbChonTK;
    private javax.swing.JComboBox<String> cbQuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lable;
    private javax.swing.JTable tbTK;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenND;
    private javax.swing.JTextField txtTenTK;
    // End of variables declaration//GEN-END:variables
}
