

package Entity;

import java.util.Date;

/**
 *
 * @author Nguyen Truc
 */
public class NguoiHoc {
    private String manh;
    private String hoten;
    private Boolean gioitinh;
    private String ngaysinh;
    private String email;
    private String dienthoai;
    private String ghichu;
    private String manv;
    private String ngaydangky;

    public NguoiHoc() {
    }

    public NguoiHoc(String manh, String hoten, Boolean gioitinh, String ngaysinh, String email, String dienthoai, String ghichu, String manv, String ngaydangky) {
        this.manh = manh;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.dienthoai = dienthoai;
        this.ghichu = ghichu;
        this.manv = manv;
        this.ngaydangky = ngaydangky;
    }

    public String getManh() {
        return manh;
    }

    public void setManh(String manh) {
        this.manh = manh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgaydangky() {
        return ngaydangky;
    }

    public void setNgaydangky(String ngaydangky) {
        this.ngaydangky = ngaydangky;
    }

    @Override
    public String toString() {
        return "Learner{" + "manh=" + manh + ", hoten=" + hoten + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh + ", email=" + email + ", dienthoai=" + dienthoai + ", ghichu=" + ghichu + ", manv=" + manv + ", ngaydangky=" + ngaydangky + '}';
    }

    
    
    
}
