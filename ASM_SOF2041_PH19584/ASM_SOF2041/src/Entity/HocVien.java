

package Entity;

/**
 *
 * @author Nguyen Truc
 */
public class HocVien {
    private int mahv;
    private int makh;
    private String manh;
    private float diem;

    public HocVien() {
    }

    public HocVien(int mahv, int makh, String manh, float diem) {
        this.mahv = mahv;
        this.makh = makh;
        this.manh = manh;
        this.diem = diem;
    }

    public int getMahv() {
        return mahv;
    }

    public void setMahv(int mahv) {
        this.mahv = mahv;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getManh() {
        return manh;
    }

    public void setManh(String manh) {
        this.manh = manh;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Students{" + "mahv=" + mahv + ", makh=" + makh + ", manh=" + manh + ", diem=" + diem + '}';
    }
    
    
}
