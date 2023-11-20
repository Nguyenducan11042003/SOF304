/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Entity.HocVien;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author nguye
 */
public class HocVienDAOTest {
    
    private HocVienDAO hocVienDAO;

    @Before
    public void setUp() {
        hocVienDAO = new HocVienDAO();
    }

    @Test
    public void testInsert() {
        HocVien hocVien = new HocVien();
        hocVien.setMakh(2);
        hocVien.setManh("8888");
        hocVien.setDiem(8.5f);

        // Thực hiện phương thức insert
        hocVienDAO.insert(hocVien);

        // Kiểm tra xem HocVien có được thêm vào cơ sở dữ liệu không
        HocVien retrievedHocVien = hocVienDAO.selectbyId("2"); // Giả sử "1" là mã học viên mới được thêm
        assertNotNull(retrievedHocVien);
        assertEquals(2, retrievedHocVien.getMakh());
        assertEquals("8888", retrievedHocVien.getManh());
        assertEquals(8.5f, retrievedHocVien.getDiem(), 0.01); // 0.01 là sai số cho phép
    }

    @Test
    public void testUpdate() {
        HocVien hocVien = new HocVien();
        hocVien.setMahv(1); // Giả sử học viên có mã 1 cần được cập nhật
        hocVien.setDiem(9.0f);

        // Thực hiện phương thức update
        hocVienDAO.update(hocVien);

        // Kiểm tra xem HocVien đã được cập nhật trong cơ sở dữ liệu không
        HocVien updatedHocVien = hocVienDAO.selectbyId("1"); // Giả sử "1" là mã học viên đã được cập nhật
        assertNotNull(updatedHocVien);
        assertEquals(9.0f, updatedHocVien.getDiem(), 0.01); // 0.01 là sai số cho phép
    }

    @Test
    public void testDelete() {
        // Thực hiện phương thức delete
        hocVienDAO.delete("1"); // Giả sử "1" là mã học viên cần xóa

        // Kiểm tra xem HocVien có bị xóa khỏi cơ sở dữ liệu không
        HocVien deletedHocVien = hocVienDAO.selectbyId("1"); // Giả sử "1" là mã học viên đã bị xóa
        assertNull(deletedHocVien);
    }

    @Test
    public void testSelectById() {
        // Kiểm tra phương thức selectbyId
        HocVien hocVien = hocVienDAO.selectbyId("1"); // Giả sử "1" là mã học viên tồn tại
        assertNotNull(hocVien);
        assertEquals(1, hocVien.getMahv());
    }

    @Test
    public void testSelectAll() {
        // Kiểm tra phương thức selectAll
        List<HocVien> hocVienList = hocVienDAO.selectAll();
        assertNotNull(hocVienList);
        assertFalse(hocVienList.isEmpty());
    }

    @Test
    public void testSelectByKhoahoc() {
        // Kiểm tra phương thức selectByKhoahoc
        List<HocVien> hocVienList = hocVienDAO.selectByKhoahoc(1); // Giả sử "1" là mã khóa học tồn tại
        assertNotNull(hocVienList);
        assertFalse(hocVienList.isEmpty());
    }
}
