package DAO;

import Entity.HocVien;
import java.util.List;
import JDBCHelper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Truc
 */
public class HocVienDAO extends EduSysDAO<HocVien, String> {

    String insert = "INSERT INTO HOCVIEN(MAKH,MANH,DIEM) VALUES(?,?,?)";
    String update = "UPDATE HOCVIEN SET DIEM = ? WHERE MAHV = ?";
    String delete = "DELETE FROM HOCVIEN WHERE MAHV = ?";
    String selectAll = "SELECT *FROM HOCVIEN";
    String selectbyId = "SELECT *FROM HOCVIEN WHERE MAHV = ?";

    @Override
    public void insert(HocVien entity) {
        JDBCHelper.update(insert, entity.getMakh(), entity.getManh(), entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        JDBCHelper.update(update, entity.getDiem(),entity.getMahv());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(delete, id);
    }

    @Override
    public HocVien selectbyId(String id) {
        List<HocVien> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<HocVien> selectbySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<HocVien>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while(rs.next()) {
                HocVien hv = new HocVien();
                    hv.setMahv(rs.getInt("MAHV"));
                    hv.setMakh(rs.getInt("MAKH"));
                    hv.setManh(rs.getString("MANH"));
                    hv.setDiem(rs.getFloat("DIEM"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HocVien> selectByKhoahoc(int makh) {
        String sql = "SELECT *FROM HOCVIEN WHERE MAKH = ?";
        return this.selectbySql(sql, makh);
    }
}
