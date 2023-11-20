package DAO;

import Entity.ChuyenDe;
import java.util.List;
import JDBCHelper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Truc
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String> {

    String insert = "INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES(?,?,?,?,?,?)";
    String update = "UPDATE CHUYENDE SET TENCD = ? , HOCPHI = ? , THOILUONG = ?, HINH = ?, MOTA = ? WHERE MACD = ?";
    String delete = "DELETE FROM CHUYENDE WHERE MACD = ?";
    String selectAll = "SELECT *FROM CHUYENDE";
    String selectbyId = "SELECT *FROM CHUYENDE WHERE MACD = ?";

    @Override
    public void insert(ChuyenDe entity) {
        JDBCHelper.update(insert, entity.getMacd(), entity.getTencd(), entity.getHocphi(), entity.getThoiluong(), entity.getHinh(), entity.getMota());
    }

    @Override
    public void update(ChuyenDe entity) {
        JDBCHelper.update(update, entity.getTencd(), entity.getHocphi(), entity.getThoiluong(), entity.getHinh(), entity.getMota(), entity.getMacd());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(delete, id);
    }

    @Override
    public ChuyenDe selectbyId(String id) {
        List<ChuyenDe> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<ChuyenDe> selectbySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<ChuyenDe>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                ChuyenDe cd = new ChuyenDe();
                cd.setMacd(rs.getString("MACD"));
                cd.setTencd(rs.getString("TENCD"));
                cd.setThoiluong(rs.getInt("THOILUONG"));
                cd.setHocphi(rs.getFloat("HOCPHI"));
                cd.setHinh(rs.getString("HINH"));
                cd.setMota(rs.getString("MOTA"));
                list.add(cd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
