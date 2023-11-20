
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import JDBCHelper.JDBCHelper;
/**
 *
 * @author Nguyen Truc
 */
public class ThongKeDAO {
    public List<Object[]> getListofArray(String sql,String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBCHelper.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getBangDiem(Integer MAKH) {
        String sql = "{CALL sp_Bangdiem(?)}";
        String[] cols = {"MANH","HOTEN","DIEM"};
        return this.getListofArray(sql, cols, MAKH);
    }
    
    public List<Object[]> getLuongNguoiHoc(){
        String sql = "{CALL sp_Thongkenguoihoc}";
        String[] cols = {"NAM","SOLUONG","DAUTIEN","CUOICUNG"};
        return this.getListofArray(sql, cols);
    }
    
    public List<Object[]> getDiemChuyenDe(){
        String sql = "{CALL sp_Thongkediem}";
        String[] cols = {"TENCHUYENDE","SOHV","DIEMTN","DIEMCN","DIEMTB"};
        return this.getListofArray(sql, cols);
    }    
    
    public List<Object[]> getDoanhThu(int NAM){
        String sql = "{CALL sp_Thongkedoanhthu(?)}";
        String[] cols = {"TENCHUYENDE","SOKH","SOHV","DOANHTHU","DTHUTN","DTHUCN","HPHITB"};
        return this.getListofArray(sql, cols, NAM);
    }

}
