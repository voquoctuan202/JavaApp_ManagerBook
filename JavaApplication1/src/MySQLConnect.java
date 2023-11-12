
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;

public class MySQLConnect {
    
    public static Connection getJDBCConnection() throws SQLException {
        final String url =
        "jdbc:mysql://localhost:3306/qlthuvien?autoReconnect=true&useSSL=false";
        final String user = "root";
        final String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
     }
    public static void main(String[] args) throws SQLException {
        Connection connection = getJDBCConnection();
        Login obj = null;
        obj = new Login();
        obj.setVisible(true);
        if (connection != null) {
            System.out.println("Data connection successful");
        } else {
            System.out.println("Data connection failed");
        }
        
      }
    public ResultSet getData(String stringSQL) throws SQLException{
        ResultSet rs = null;
        Connection conn = getJDBCConnection();
        try{
            Statement state = conn.createStatement();
            rs = state.executeQuery(stringSQL);           
        }catch (SQLException ex){
            System.out.println(ex);
         
        }
        return rs;
    }
   
    
    public int ExcuteSQLInsert(String[] stringsSQL) throws SQLException{
        int rowsInserted =0;
        Connection conn = getJDBCConnection();
        String sql = "INSERT INTO SACH(maSach,tenSach,mota,nxb,tacgia,theloai,tinhtrang,tang,ke) VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement statement;
        try{
            statement =conn.prepareStatement(sql);
            statement.setString(1,stringsSQL[0]);
            statement.setString(2,stringsSQL[1]);
            statement.setString(3,stringsSQL[2]);
            statement.setString(4,stringsSQL[3]);
            statement.setString(5,stringsSQL[4]);
            statement.setString(6,stringsSQL[5]);
            statement.setString(7,stringsSQL[6]);
            statement.setString(8,stringsSQL[7]);
            statement.setString(9,stringsSQL[8]);
            
            rowsInserted = statement.executeUpdate();
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsInserted;
    }
    public int ExcuteSQLDelete(String[] stringsSQL) throws SQLException{
        int rowsDeleted =0;
        Connection conn = getJDBCConnection();
        String sql = "DELETE FROM SACH WHERE maSach=?";
        
        PreparedStatement statement;
        try{
            statement =conn.prepareStatement(sql);
            statement.setString(1,stringsSQL[0]);
            
            
            rowsDeleted = statement.executeUpdate();
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsDeleted ;
    }
    public int DeleteSach(String[] stringsSQL) throws SQLException{
        CallableStatement cStmt = null;
        Connection conn = getJDBCConnection();
        //call stored procedure "getBalance(IN username varchar(8), OUT balance int)"
        cStmt = conn.prepareCall("{call DeleteSach(?,?)}");
        cStmt.setString(1,stringsSQL[0]);
      
        int i=0;
        cStmt.registerOutParameter(2, Types.INTEGER); //đăng ký tham số OUT
        cStmt.executeQuery(); //gọi thủ tục
        return cStmt.getInt(2);
        
        
    }
    public int InsertSach(String[] stringsSQL) throws SQLException{
        CallableStatement cStmt = null;
        Connection conn = getJDBCConnection();
        //call stored procedure "getBalance(IN username varchar(8), OUT balance int)"
        cStmt = conn.prepareCall("{call InsertSach(?,?,?,?,?,?,?,?,?,?)}");
        cStmt.setString(1,stringsSQL[0]);
        cStmt.setString(2,stringsSQL[1]);
        cStmt.setString(3,stringsSQL[2]);
        cStmt.setString(4,stringsSQL[3]);
        cStmt.setString(5,stringsSQL[4]);
        cStmt.setString(6,stringsSQL[5]);
        cStmt.setString(7,stringsSQL[6]);
        cStmt.setString(8,stringsSQL[7]);
        cStmt.setString(9,stringsSQL[8]);
        int i=0;
        cStmt.registerOutParameter(10, Types.INTEGER); //đăng ký tham số OUT
        cStmt.executeQuery(); //gọi thủ tục
        return cStmt.getInt(10);
        
        
    }
    public int UpdateSach(String[] stringsSQL) throws SQLException{
        CallableStatement cStmt = null;
        Connection conn = getJDBCConnection();
        //call stored procedure "getBalance(IN username varchar(8), OUT balance int)"
        cStmt = conn.prepareCall("{call UpdateSach(?,?,?,?,?,?,?,?,?,?)}");
        cStmt.setString(1,stringsSQL[0]);
        cStmt.setString(2,stringsSQL[1]);
        cStmt.setString(3,stringsSQL[2]);
        cStmt.setString(4,stringsSQL[3]);
        cStmt.setString(5,stringsSQL[4]);
        cStmt.setString(6,stringsSQL[5]);
        cStmt.setString(7,stringsSQL[6]);
        cStmt.setString(8,stringsSQL[7]);
        cStmt.setString(9,stringsSQL[8]);
        cStmt.registerOutParameter(10, Types.INTEGER); //đăng ký tham số OUT
        cStmt.executeQuery(); //gọi thủ tục
        return cStmt.getInt(10);
        
        
    }
    public int ExcuteSQLUpdate(String[] stringsSQL) throws SQLException{
        int rowsUpdated =0;
        Connection conn = getJDBCConnection();
        String sql = "UPDATE SACH SET tenSach=?,mota=?,nxb=?,tacgia=?,theloai=?,tinhtrang=?,tang=?,ke=? WHERE maSach=?";
        
        PreparedStatement statement;
        try{
            statement =  conn.prepareStatement(sql);
            statement.setString(1,stringsSQL[1]);
            statement.setString(2,stringsSQL[2]);
            statement.setString(3,stringsSQL[3]);
            statement.setString(4,stringsSQL[4]);
            statement.setString(5,stringsSQL[5]);
            statement.setString(6,stringsSQL[6]);
            statement.setString(7,stringsSQL[7]);
            statement.setString(8,stringsSQL[8]);
            statement.setString(9,stringsSQL[0]);
            
            
            rowsUpdated = statement.executeUpdate();
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsUpdated ;
    }
    public int ExcuteSQLDuyetPhieuMuon(int maPhieu,String ghichu) throws SQLException{
        int rowsUpdated =0;
        Connection conn = getJDBCConnection();
        String sql = "UPDATE muonsach SET tinhtrang = 'Đã trả',ghichu=? WHERE maPhieumuon=?";
        
        PreparedStatement statement;
        try{
            statement =  conn.prepareStatement(sql);
            statement.setString(1,ghichu);
            statement.setInt(2,maPhieu);
            rowsUpdated = statement.executeUpdate();
            
            this.setTraSach(this.getDSByMaPhieu(maPhieu));
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsUpdated ;
    }
    
    
    public int ExcuteSQLDeleteTaiKhoan(int matk,String quyen) throws SQLException{
        int rowsDeleted1 =0;
        int rowsDeleted2 =2;
        Connection conn = getJDBCConnection();
        
        String sql1="", sql2="";
        if(quyen.equals("Độc giả")){
            sql1 =  " DELETE FROM TaiKhoan WHERE maTK=?; ";
            sql2=   " DELETE FROM DocGia WHERE maTK=?; " ;
           
        }else{
            sql1 =  "DELETE FROM TaiKhoan WHERE maTK=?; ";
            sql2= "DELETE FROM QuanLy WHERE maTK=?;";
        }
        
        
        PreparedStatement statement1;
        PreparedStatement statement2;
        try{
            statement1 =conn.prepareStatement(sql1);
            statement1.setInt(1,matk);
            
            statement2 =conn.prepareStatement(sql2);
            statement2.setInt(1,matk);
            
            rowsDeleted2 = statement2.executeUpdate();
            rowsDeleted1 = statement1.executeUpdate();
           
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsDeleted1 + rowsDeleted2 ;
    }
    
    public int ExcuteSQLUpdateTaiKhoan(int matk, String[] stringsSQL) throws SQLException{
        int rowsUpdated1 =0,rowsUpdated2 =0 ;
        Connection conn = getJDBCConnection();
        
        String sql1 = "";
        String sql2 = "";
        
        if(stringsSQL[2].equals("Độc giả")){
            sql1 = "UPDATE DocGia SET tenDocgia=?, email=?, sdt=?  WHERE maTK=?";
            sql2 = "UPDATE TaiKhoan SET tenTaiKhoan=?, matkhau=? WHERE maTK=?";
        }else{
            sql1 =  "UPDATE QuanLy SET tenQuanly=?, email=?, sdt=?  WHERE maTK=?";
            sql2 =  "UPDATE TaiKhoan SET tenTaiKhoan=?, matkhau=? WHERE maTK=?";
        }
        
        PreparedStatement statement1;
        PreparedStatement statement2;
        try{
            statement1 =conn.prepareStatement(sql1);
            statement1.setString(1,stringsSQL[3]);
            statement1.setString(2,stringsSQL[4]);
            statement1.setString(3,stringsSQL[5]);
            statement1.setInt(4,matk);
            
            statement2 =conn.prepareStatement(sql2);
            statement2.setString(1,stringsSQL[0]);
            statement2.setString(2,stringsSQL[1]);
            statement2.setInt(3,matk);
            
            
            rowsUpdated2 = statement2.executeUpdate();
            rowsUpdated1 = statement1.executeUpdate();
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsUpdated2 + rowsUpdated1 ;
    }
    
    
    
    public int GetAccountByTenTk(String tenTK) throws SQLException{
        CallableStatement cStmt = null;
        Connection conn = getJDBCConnection();
        //call stored procedure "getBalance(IN username varchar(8), OUT balance int)"
        cStmt = conn.prepareCall("{call getmatk(?,?)}");
        cStmt.setString(1,tenTK);
        
        cStmt.registerOutParameter(2, Types.INTEGER); //đăng ký tham số OUT
        cStmt.executeQuery(); //gọi thủ tục
        return cStmt.getInt(2);
       
    }
    public void CreateDocGia(int maTK,String tenDocgia,String email, String sdt) throws SQLException{
        int rowsInserted =0;
        Connection conn = getJDBCConnection();
        String sql = "INSERT INTO DocGia(maTK,tenDocGia,email,sdt) VALUES(?,?,?,?)";
        
        PreparedStatement statement;
        try{
            statement =conn.prepareStatement(sql);
            statement.setInt(1,maTK);
            statement.setString(2,tenDocgia);
            statement.setString(3,email);
            statement.setString(4,sdt);
           
            rowsInserted = statement.executeUpdate();
            
            
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        
    }
    public int Register(String[] stringsTK) throws SQLException{
        int rowsInserted =0;
        Connection conn = getJDBCConnection();
        String sql = "INSERT INTO TAIKHOAN(tenTaiKhoan,matkhau) VALUES(?,?)";
        
        PreparedStatement statement;
        try{
            statement =conn.prepareStatement(sql);
            statement.setString(1,stringsTK[0]);
            statement.setString(2,stringsTK[4]);
           
            rowsInserted = statement.executeUpdate();
            
            int matk = this.GetAccountByTenTk(stringsTK[0]);
            this.CreateDocGia(matk,stringsTK[3] , stringsTK[2], stringsTK[1]);
            
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsInserted;
    }
    
    //Login
    public String[] Login(String[] stringsTK) throws SQLException{
        Connection conn = getJDBCConnection();
        String sql = "SELECT * FROM taikhoan WHERE tenTaiKhoan='"+ stringsTK[0] + "' and matkhau='"+ stringsTK[1]+"' and quyen='"+stringsTK[2]+"';";
        ResultSet rs = null;
        PreparedStatement statement;
        try{
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery(sql);
            if(rs.next()){
                String quyen = rs.getString("quyen");
                String tenTK = rs.getString("tenTaiKhoan");
             
                String[] kq = {tenTK,quyen};  
                return kq;   
            }
            
        }catch(SQLException ex){
             System.out.print(ex);
        }
        return null;
    }
    public int createNewID(String tableName) throws SQLException{
      ResultSet rs = null;  
      Connection conn = getJDBCConnection();
      
      PreparedStatement statement = null;
      int s = 0;
      switch (tableName) { //mã sách được nhập nên không cần tạo ID
        case "muonsach":
            statement = conn.prepareStatement("SELECT * FROM muonsach");
            rs = statement.executeQuery();
       
            while(rs.next()){
                s = rs.getInt("maPhieumuon"); //lấy mã độc giả ở vị trí cuối cùng
            }
            return s+1; //cộng thêm một để tạo ra ID mới

        case "TaiKhoan":
            statement = conn.prepareStatement("SELECT * FROM TaiKhoan");
            rs = statement.executeQuery();
       
            while(rs.next()){
                s = rs.getInt("maTK");
            }
            return s+1;
        case "DocGia":
            statement = conn.prepareStatement("SELECT * FROM DocGia");
            rs = statement.executeQuery();
       
            while(rs.next()){
                s = rs.getInt("maDocGia");
            }
            return s+1;
        case "QuanLy":
            statement = conn.prepareStatement("SELECT * FROM QuanLy");
            rs = statement.executeQuery();
       
            while(rs.next()){
                s = rs.getInt("maQuanLy");
            }
            return s+1;
        }
    
      return 999;
    }
    
    public String getTenDocGiaByTK(String tentk) throws SQLException{
        CallableStatement cStmt = null;
        Connection conn = getJDBCConnection();
        //call stored procedure "getBalance(IN username varchar(8), OUT balance int)"
        cStmt = conn.prepareCall("{call getTenDocGiaByTK(?,?)}");
        cStmt.setString(1,tentk);
        
        cStmt.registerOutParameter(2, Types.VARCHAR); //đăng ký tham số OUT
        cStmt.executeQuery(); //gọi thủ tục
        return cStmt.getString(2);
       
    }
    
    public int getMaDocGiaByTK(String tentk) throws SQLException{
        CallableStatement cStmt = null;
        Connection conn = getJDBCConnection();
        //call stored procedure "getBalance(IN username varchar(8), OUT balance int)"
        cStmt = conn.prepareCall("{call getMaDocGiaByTK(?,?)}");
        cStmt.setString(1,tentk);
        
        cStmt.registerOutParameter(2, Types.INTEGER); //đăng ký tham số OUT
        cStmt.executeQuery(); //gọi thủ tục
        return cStmt.getInt(2);
       
    }
   
    
    
    public void createPhieumuon(int maPhieumuon,int maDocGia,String maSach, String ngaymuon, String ngaytra) throws SQLException{
        int rowsInserted =0;
        Connection conn = getJDBCConnection();
        String sql = "INSERT INTO muonsach(maPhieuMuon,maDocGia,maSach,ngayMuon,ngayTra,tinhtrang) VALUES(?,?,?,?,?,'Đang mượn')";
        
        PreparedStatement statement;
        try{
            statement =conn.prepareStatement(sql);
            statement.setInt(1,maPhieumuon);
            statement.setInt(2,maDocGia);
            statement.setString(3,maSach);
            statement.setString(4,ngaymuon);
            statement.setString(5,ngaytra);
           
            rowsInserted = statement.executeUpdate();
            
            
        }catch (SQLException ex){
            System.out.print(ex);
        } 
    }
    public void setTrangThaiSach(String ms, String trangthai) throws SQLException{
       
        Connection conn = getJDBCConnection();
        String sql = "UPDATE sach SET tinhtrang=? WHERE maSach=?";
        
        PreparedStatement statement;
        try{
            statement =  conn.prepareStatement(sql);
            statement.setString(1,trangthai);
            statement.setString(2,ms);
            
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        
    }
    
    public int IsDangMuon(int maphieu) throws SQLException{
        CallableStatement cStmt = null;
        Connection conn = getJDBCConnection();
        //call stored procedure "getBalance(IN username varchar(8), OUT balance int)"
        cStmt = conn.prepareCall("{call IsDangMuon(?,?)}");
        cStmt.setInt(1,maphieu);
        
        cStmt.registerOutParameter(2, Types.INTEGER); //đăng ký tham số OUT
        cStmt.executeQuery(); //gọi thủ tục
        return cStmt.getInt(2);
    }
     public int IsNguoiMuon(int maphieu,int maDG) throws SQLException{
        CallableStatement cStmt = null;
        Connection conn = getJDBCConnection();
        //call stored procedure "getBalance(IN username varchar(8), OUT balance int)"
        cStmt = conn.prepareCall("{call IsNguoiMuon(?,?,?)}");
        cStmt.setInt(1,maphieu);
        cStmt.setInt(2,maDG);
        
        cStmt.registerOutParameter(3, Types.INTEGER); //đăng ký tham số OUT
        cStmt.executeQuery(); //gọi thủ tục
        return cStmt.getInt(3);
    }
    
    
    public int TraSach(int maphieu, String ghichu) throws SQLException{
        int rowsUpdated =0;
        Connection conn = getJDBCConnection();
        String sql = "UPDATE muonsach SET tinhtrang = 'Đang duyệt',ghichu=? WHERE maPhieumuon=?";
        
        PreparedStatement statement;
        try{
            statement =  conn.prepareStatement(sql);
            statement.setString(1,ghichu);
            statement.setInt(2,maphieu);
            
            rowsUpdated = statement.executeUpdate();
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsUpdated ;
    }
    public ArrayList<String> getDSByMaPhieu(int maphieu) throws SQLException{
        ArrayList<String> ds = new ArrayList<String>();
        ResultSet rs = this.getData("SELECT * FROM muonsach WHERE maPhieumuon = '"+maphieu+"';");
        try{
            while(rs.next()){
                ds.add(rs.getString("maSach"));
            }    
          }catch(SQLException ex){
              ex.printStackTrace();
          }
        return ds;
    }
    public void setTraSach(ArrayList<String> ds) throws SQLException{
        int i;
        String ms;
        for(i=0;i<= ds.size()-1;i++){
            ms = ds.get(i);
            this.setTrangThaiSach(ms, "");
        }
    }
    
    

}

