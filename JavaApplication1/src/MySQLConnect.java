
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

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
    public int createNewID(String tableName) throws SQLException{
      ResultSet rs = null;  
      Connection conn = getJDBCConnection();
      
      PreparedStatement statement = null;
      int s = 0;
      switch (tableName) { //mã sách được nhập nên không cần tạo ID
        case "PhieuMuon":
            statement = conn.prepareStatement("SELECT * FROM PhieuMuon");
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
        String sql = "UPDATE muonsach SET tinhtrang = 'datra',ghichu=? WHERE maPhieumuon=?";
        
        PreparedStatement statement;
        try{
            statement =  conn.prepareStatement(sql);
            statement.setString(1,ghichu);
            statement.setInt(2,maPhieu);
            
            
            
            rowsUpdated = statement.executeUpdate();
        }catch (SQLException ex){
            System.out.print(ex);
        }     
        return rowsUpdated ;
    }
    public int ExcuteSQLDuyetSachmuon(int stt,String ghichu) throws SQLException{
        int rowsUpdated =0;
        Connection conn = getJDBCConnection();
        String sql = "UPDATE muonsach SET tinhtrang = 'datra',ghichu=? WHERE stt=?";
        
        PreparedStatement statement;
        try{
            statement =  conn.prepareStatement(sql);
            statement.setString(1,ghichu);
            statement.setInt(2,stt);
            
            
            
            rowsUpdated = statement.executeUpdate();
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
            sql1 =  "UPDATE QuanLy SET tenDocgia=?, email=?, sdt=?  WHERE maTK=?";
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

}

