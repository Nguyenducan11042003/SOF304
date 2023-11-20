

package Entity;

/**
 *
 * @author Nguyen Truc
 */
public class NhanVien {
    private String manv;
    private String matkhau;
    private String hoten;
    private Boolean vaitro;

    public NhanVien() {
    }

    public NhanVien(String manv, String matkhau, String hoten, Boolean vaitro) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.vaitro = vaitro;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Boolean getVaitro() {
        return vaitro;
    }

    public void setVaitro(Boolean vaitro) {
        this.vaitro = vaitro;
    }

    @Override
    public String toString() {
        return "Staff{" + "manv=" + manv + ", matkhau=" + matkhau + ", hoten=" + hoten + ", vaitro=" + vaitro + '}';
    }
    
    
    
}
