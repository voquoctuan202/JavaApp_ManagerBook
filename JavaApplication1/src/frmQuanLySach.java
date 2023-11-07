
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class frmQuanLySach extends javax.swing.JFrame {

    /**
     * Creates new form frmQuanLySach
     */
    MySQLConnect conn;
    private int flag=0;
    public frmQuanLySach() throws SQLException {
        initComponents();
        conn = new MySQLConnect();
        showData();
    }
    
    
    public void showData() throws SQLException{
        String[] columnNames = {"Mã Sách","Tên Sách","Mô tả","NXB","Tác Giả","Thể Loại","Tình Trạng","Tầng","Kệ"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbSach.setModel(model);
        String maSach = "";
        String tenSach = "";
        String mota = "";
        String nxb ="";
        String tacgia="";
        String theloai="";
        String tinhtrang="";
        String tang="";
        String ke="";
        
        ResultSet rs = conn.getData("SELECT * FROM SACH;");
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
    public void showDataDangMuon() throws SQLException{
        String[] columnNames = {"Mã Sách","Tên Sách","Mô tả","NXB","Tác Giả","Thể Loại","Tình Trạng","Tầng","Kệ"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbSach.setModel(model);
        String maSach = "";
        String tenSach = "";
        String mota = "";
        String nxb ="";
        String tacgia="";
        String theloai="";
        String tinhtrang="";
        String tang="";
        String ke="";
        
        ResultSet rs = conn.getData("SELECT * FROM SACH WHERE tinhtrang = 'dangmuon';");
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
    public void showDataConTrong() throws SQLException{
        String[] columnNames = {"Mã Sách","Tên Sách","Mô tả","NXB","Tác Giả","Thể Loại","Tình Trạng","Tầng","Kệ"};
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        tbSach.setModel(model);
        String maSach = "";
        String tenSach = "";
        String mota = "";
        String nxb ="";
        String tacgia="";
        String theloai="";
        String tinhtrang="";
        String tang="";
        String ke="";
        
        ResultSet rs = conn.getData("SELECT * FROM SACH WHERE tinhtrang = '';");
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
    public void ClearText(){
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtMoTa.setText("");
        txtNXB.setText("");
        txtTacGia.setText("");
        txtTheLoai.setText("");
        txtKe.setText("");
        txtTang.setText("");
        
    }
     public void InsertData() throws SQLException{
       
        String []stringsSQL = {txtMaSach.getText(), txtTenSach.getText(),txtMoTa.getText(),txtNXB.getText(),txtTacGia.getText(),txtTheLoai.getText(),"",txtTang.getText(),txtKe.getText()};
        
        int isInsert = conn.ExcuteSQLInsert(stringsSQL);
        if(isInsert>0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại, kiểm tra lại");
        }
        showData();
        ClearText();
     }
     
     public void UpdateData() throws SQLException{
        String []stringsSQL = {txtMaSach.getText(), txtTenSach.getText(),txtMoTa.getText(),txtNXB.getText(),txtTacGia.getText(),txtTheLoai.getText(),"",txtTang.getText(),txtKe.getText()};
        
        int isUpdate = conn.ExcuteSQLUpdate(stringsSQL);
        if(isUpdate>0){
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại, kiểm tra lại");
        }
        showData();
        ClearText();
     }
     public void DeleteData() throws SQLException{
       
        String []stringsSQL = {txtMaSach.getText()};
        
        int isDelete = conn.ExcuteSQLDelete(stringsSQL);
        if(isDelete>0){
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại, kiểm tra lại");
        }
        showData();
        ClearText();
     }
    public void getSelectedData(){
        int selectedRow = tbSach.getSelectedRow();
        
        txtMaSach.setText(tbSach.getValueAt(selectedRow, 0).toString());
        txtTenSach.setText(tbSach.getValueAt(selectedRow, 1).toString());
        txtMoTa.setText(tbSach.getValueAt(selectedRow, 2).toString());
        txtNXB.setText(tbSach.getValueAt(selectedRow, 3).toString());
        txtTacGia.setText(tbSach.getValueAt(selectedRow, 4).toString());
        txtTheLoai.setText(tbSach.getValueAt(selectedRow, 5).toString());
        txtKe.setText(tbSach.getValueAt(selectedRow, 7).toString());
        txtTang.setText(tbSach.getValueAt(selectedRow, 7).toString());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtTheLoai = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLietKe = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbLietKe = new javax.swing.JComboBox<>();
        btnXPhieuMuon = new javax.swing.JButton();
        btnXDocGia = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTang = new javax.swing.JTextField();
        txtKe = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        btnChonSach = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Sách");

        jLabel2.setText("Mã Sách");

        jLabel3.setText("Tên Sách");

        jLabel4.setText("Mô tả");

        jLabel5.setText("Nhà xuất bản");

        jLabel6.setText("Tác giả");

        jLabel7.setText("Thể loại");

        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLietKe.setText("Liệt kê  ");
        btnLietKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLietKeActionPerformed(evt);
            }
        });

        jLabel8.setText("Liệt kê theo:");

        cbLietKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang mượn", "Còn trống" }));

        btnXPhieuMuon.setText("Quản lý phiếu mượn");
        btnXPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXPhieuMuonActionPerformed(evt);
            }
        });

        btnXDocGia.setText("Quản lý tài khoản");
        btnXDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXDocGiaActionPerformed(evt);
            }
        });

        jLabel10.setText("Tầng");

        jLabel9.setText("Kệ");

        jLabel11.setText("Vị trí");

        txtKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeActionPerformed(evt);
            }
        });

        tbSach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbSach);

        btnChonSach.setText("Chọn sách");
        btnChonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSach)
                            .addComponent(txtTenSach)
                            .addComponent(txtMoTa)
                            .addComponent(txtNXB)
                            .addComponent(txtTacGia)
                            .addComponent(txtTheLoai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnXPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnXDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbLietKe, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnLietKe, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnChonSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(299, 299, 299))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtKe, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(323, 323, 323)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa)
                    .addComponent(btnUpdate)
                    .addComponent(btnThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbLietKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLietKe))
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(btnXPhieuMuon)
                        .addComponent(btnXDocGia))
                    .addComponent(txtNXB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonSach))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            // TODO add your handling code here:
            InsertData();
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:
            UpdateData();
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    
    private void btnLietKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLietKeActionPerformed
        // TODO add your handling code here:
        int chon =0;
        chon = cbLietKe.getSelectedIndex();
        switch(chon){
            case 0: 
            {
                try {
                    showData();
                } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 1:
             {
                try {
                    showDataDangMuon();
                } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            case 2:
            {
                try {
                    showDataConTrong();
                } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
        
        }
        
    }//GEN-LAST:event_btnLietKeActionPerformed

    private void txtKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            // TODO add your handling code here:
            DeleteData();
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnChonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSachActionPerformed
        // TODO add your handling code here:
        getSelectedData();
    }//GEN-LAST:event_btnChonSachActionPerformed

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void btnXPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXPhieuMuonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        XemPhieuMuon obj = null;
        try {
            obj = new XemPhieuMuon();
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
    }//GEN-LAST:event_btnXPhieuMuonActionPerformed

    private void btnXDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXDocGiaActionPerformed
        // TODO add your handling code here:
         this.dispose();
        QLTaiKhoan obj = null;
        try {
            obj = new QLTaiKhoan();
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
    }//GEN-LAST:event_btnXDocGiaActionPerformed

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
            java.util.logging.Logger.getLogger(frmQuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmQuanLySach().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLySach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonSach;
    private javax.swing.JButton btnLietKe;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXDocGia;
    private javax.swing.JButton btnXPhieuMuon;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLietKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSach;
    private javax.swing.JTextField txtKe;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTang;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTheLoai;
    // End of variables declaration//GEN-END:variables
}
