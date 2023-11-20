/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Entity.NguoiHoc;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author nguye
 */
public class NguoiHocDAOTest {
    
     private NguoiHocDAO nguoiHocDAO;

    @Before
    public void setUp() {
        nguoiHocDAO = new NguoiHocDAO();
    }

    @Test
    public void testInsert() {
        NguoiHoc nguoiHoc = new NguoiHoc();
        nguoiHoc.setManh("NH0024");
        nguoiHoc.setHoten("John Doe");
        nguoiHoc.setGioitinh(true);
        nguoiHoc.setNgaysinh("1990-01-01");
        nguoiHoc.setEmail("john.doe@example.com");
        nguoiHoc.setDienthoai("123456789");
        nguoiHoc.setGhichu("Test");
        nguoiHoc.setManv("NV001");

        // Thực hiện phương thức insert
        nguoiHocDAO.insert(nguoiHoc);

//        // Kiểm tra xem NguoiHoc có được thêm vào cơ sở dữ liệu không
//        NguoiHoc retrievedNguoiHoc = nguoiHocDAO.selectbyId("NH002"); // Giả sử "NH002" là mã người học mới được thêm
//        assertNotNull(retrievedNguoiHoc);
//        assertEquals("John Doe", retrievedNguoiHoc.getHoten());
//        assertTrue(retrievedNguoiHoc.getGioitinh());
//        assertEquals("1990-01-01", retrievedNguoiHoc.getNgaysinh());
//        assertEquals("john.doe@example.com", retrievedNguoiHoc.getEmail());
//        assertEquals("123456789", retrievedNguoiHoc.getDienthoai());
//        assertEquals("Test", retrievedNguoiHoc.getGhichu());
//        assertEquals("02", retrievedNguoiHoc.getManv());
    }

    @Test
    public void testUpdate() {
        NguoiHoc nguoiHoc = new NguoiHoc();
        nguoiHoc.setManh("NH002"); // Giả sử người học có mã NH002 cần được cập nhật
        nguoiHoc.setHoten("Updated Name new1");
        nguoiHoc.setGioitinh(false);
        nguoiHoc.setNgaysinh("1995-01-01");
        nguoiHoc.setEmail("updated.email@example.com");
        nguoiHoc.setDienthoai("987654321");
        nguoiHoc.setGhichu("Updated Test");
        nguoiHoc.setManv("NV002");

        // Thực hiện phương thức update
        nguoiHocDAO.update(nguoiHoc);

        // Kiểm tra xem NguoiHoc đã được cập nhật trong cơ sở dữ liệu không
        NguoiHoc updatedNguoiHoc = nguoiHocDAO.selectbyId("NH002"); // Giả sử "NH002" là mã người học đã được cập nhật
        assertNotNull(updatedNguoiHoc);
        assertEquals("Updated Name new1", updatedNguoiHoc.getHoten());
        assertFalse(updatedNguoiHoc.getGioitinh());
        assertEquals("1995-01-01", updatedNguoiHoc.getNgaysinh());
        assertEquals("updated.email@example.com", updatedNguoiHoc.getEmail());
        assertEquals("987654321", updatedNguoiHoc.getDienthoai());
        assertEquals("Updated Test", updatedNguoiHoc.getGhichu());
        assertEquals("NV002", updatedNguoiHoc.getManv());
    }

    @Test
    public void testDelete() {
        // Thực hiện phương thức delete
        nguoiHocDAO.delete("1"); // Giả sử "NH002" là mã người học cần xóa

        // Kiểm tra xem NguoiHoc có bị xóa khỏi cơ sở dữ liệu không
        NguoiHoc deletedNguoiHoc = nguoiHocDAO.selectbyId("1"); // Giả sử "NH002" là mã người học đã bị xóa
        assertNull(deletedNguoiHoc);
    }

////    @Test
////    public void testSelectById() {
////        // Kiểm tra phương thức selectbyId
////        NguoiHoc nguoiHoc = nguoiHocDAO.selectbyId("NH002"); // Giả sử "NH002" là mã người học tồn tại
////        assertNotNull(nguoiHoc);
////        assertEquals("NH002", nguoiHoc.getManh());
////    }
//
////    @Test
////    public void testSelectAll() {
////        // Kiểm tra phương thức selectAll
////        List<NguoiHoc> nguoiHocList = nguoiHocDAO.selectAll();
////        assertNotNull(nguoiHocList);
////        assertFalse(nguoiHocList.isEmpty());
////    }
////
////    @Test
////    public void testSelectbyKeyword() {
////        // Kiểm tra phương thức selectbyKeyword
////        List<NguoiHoc> nguoiHocList = nguoiHocDAO.selectbyKeyword("John");
////        assertNotNull(nguoiHocList);
////        assertFalse(nguoiHocList.isEmpty());
////    }
////
////    @Test
////    public void testSelectNotinCourse() {
////        // Kiểm tra phương thức selectNotinCourse
////        List<NguoiHoc> nguoiHocList = nguoiHocDAO.selectNotinCourse(1, "John");
////        assertNotNull(nguoiHocList);
////        assertFalse(nguoiHocList.isEmpty());
////    }
}
    
