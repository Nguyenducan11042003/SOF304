package DAO;

import Entity.KhoaHoc;
import java.util.List;
import JDBCHelper.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Truc
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, String> {

    String insert = "INSERT INTO KHOAHOC(MACD,HOCPHI,THOILUONG,NGAYKG,GHICHU,MANV,NGAYTAO) VALUES(?,?,?,?,?,?,?)";
    String update = "UPDATE KHOAHOC SET MACD = ? , HOCPHI = ? , THOILUONG = ?, NGAYKG = ?, GHICHU = ?, MANV = ? ,NGAYTAO = ? WHERE MAKH = ?";
    String delete = "DELETE FROM KHOAHOC WHERE MAKH = ?";
    String selectAll = "SELECT *FROM KHOAHOC";
    String selectbyId = "SELECT *FROM KHOAHOC WHERE MAKH = ?";

    @Override
    public void insert(KhoaHoc entity) {
        JDBCHelper.update(insert, entity.getMacd(), entity.getHocphi(), entity.getThoiluong(), entity.getNgaykhaigiang(), entity.getGhichu(),
                 entity.getManv(), entity.getNgaytao());
    }

    @Override
    public void update(KhoaHoc entity) {
        JDBCHelper.update(update, entity.getMacd(), entity.getHocphi(), entity.getThoiluong(), entity.getNgaykhaigiang(), entity.getGhichu(),
                entity.getManv(), entity.getNgaytao(), entity.getMakh());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(delete, id);
    }

    @Override
    public KhoaHoc selectbyId(String id) {
        List<KhoaHoc> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<KhoaHoc> selectbySql(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<KhoaHoc>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                KhoaHoc kh = new KhoaHoc();
                kh.setMakh(rs.getInt("MAKH"));
                kh.setMacd(rs.getString("MACD"));
                kh.setHocphi(rs.getFloat("HOCPHI"));
                kh.setThoiluong(rs.getInt("THOILUONG"));
                kh.setNgaykhaigiang(rs.getDate("NGAYKG"));
                kh.setGhichu(rs.getString("GHICHU"));
                kh.setManv(rs.getString("MANV"));
                kh.setNgaytao(rs.getDate("NGAYTAO"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhoaHoc> selectbyChuyende(String macd) {
        String sql = "SELECT *FROM KHOAHOC WHERE MACD = ?";
        return this.selectbySql(sql, macd);
    }
    
    public List<Integer> selectYear() {
        String sql = "SELECT DISTINCT YEAR(NGAYKG) AS YEAR FROM KHOAHOC ORDER BY YEAR DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
