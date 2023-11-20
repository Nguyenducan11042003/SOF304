
package DAO;

import Entity.NguoiHoc;
import java.util.List;
import JDBCHelper.JDBCHelper;
import Utils.Auth;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Truc
 */
public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String>{

    String insert = "INSERT INTO NGUOIHOC(MANH,HOTEN,GIOITINH,NGAYSINH,EMAIL,DIENTHOAI,GHICHU,MANV) VALUES(?,?,?,?,?,?,?,?)";
    String update = "UPDATE NGUOIHOC SET HOTEN = ?,GIOITINH=?,NGAYSINH=?,EMAIL=?,DIENTHOAI=?,GHICHU=? WHERE MANH = ? ";
    String delete = "DELETE FROM NGUOIHOC WHERE MANH = ? ";
    String selectAll = "SELECT *FROM NGUOIHOC";
    String selectbyId = "SELECT *FROM NGUOIHOC WHERE MANH = ?";    
    
    
    @Override
    public void insert(NguoiHoc entity) {
       JDBCHelper.update(insert,entity.getManh(),entity.getHoten(),entity.getGioitinh(),entity.getNgaysinh(),entity.getEmail(),entity.getDienthoai(),
               entity.getGhichu(),Auth.user.getManv());
    }

    @Override
    public void update(NguoiHoc entity) {
        JDBCHelper.update(update, entity.getHoten(),entity.getGioitinh(),entity.getNgaysinh(),entity.getEmail(),entity.getDienthoai(),entity.getGhichu(),
        entity.getManh());    }

    @Override
    public void delete(String id) {
       JDBCHelper.update(delete, id);
    }

    @Override
    public NguoiHoc selectbyId(String id) {
        List<NguoiHoc> list = this.selectbySql(selectbyId, id);
        if(list.isEmpty()){
            return null;
        } 
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> selectAll() {
         return this.selectbySql(selectAll);
    }

    @Override
    protected List<NguoiHoc> selectbySql(String sql, Object... args) {
            List<NguoiHoc> list = new ArrayList<NguoiHoc>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while(rs.next()) {
                NguoiHoc ln = new NguoiHoc();
                ln.setDienthoai(rs.getString("DIENTHOAI"));
                ln.setEmail(rs.getString("EMAIL"));
                ln.setGhichu(rs.getString("GHICHU"));
                ln.setGioitinh(rs.getBoolean("GIOITINH"));
                ln.setHoten(rs.getString("HOTEN"));
                ln.setManh(rs.getString("MANH"));
                ln.setManv(rs.getString("MANV"));
                ln.setNgaydangky(rs.getDate("NGAYDK").toString());
                ln.setNgaysinh(rs.getDate("NGAYSINH").toString());
                list.add(ln);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<NguoiHoc> selectbyKeyword(String keyword) {
        String sql = "SELECT *FROM NGUOIHOC WHERE HOTEN LIKE ?";
        return this.selectbySql(sql,"%"+keyword+"%");
    }
    
    public List<NguoiHoc> selectNotinCourse(int makh, String keyword) {
        String sql = "SELECT *FROM NGUOIHOC WHERE HOTEN LIKE ? AND MANH NOT IN "
                + "(SELECT MANH FROM HOCVIEN WHERE MAKH = ?)";
        return this.selectbySql(sql,"%"+keyword+"%",makh);
    }    
    
}
