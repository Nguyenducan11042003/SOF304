

package Entity;

/**
 *
 * @author Nguyen Truc
 */
public class ChuyenDe {
    private String macd;
    private String tencd;
    private float hocphi;
    private int thoiluong;
    private String hinh;
    private String mota;

    public ChuyenDe() {
    }

    public ChuyenDe(String macd, String tencd, float hocphi, int thoiluong, String hinh, String mota) {
        this.macd = macd;
        this.tencd = tencd;
        this.hocphi = hocphi;
        this.thoiluong = thoiluong;
        this.hinh = hinh;
        this.mota = mota;
    }

    public String getMacd() {
        return macd;
    }

    public void setMacd(String macd) {
        this.macd = macd;
    }

    public String getTencd() {
        return tencd;
    }

    public void setTencd(String tencd) {
        this.tencd = tencd;
    }

    public float getHocphi() {
        return hocphi;
    }

    public void setHocphi(float hocphi) {
        this.hocphi = hocphi;
    }

    public int getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(int thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return tencd ;
    }

    @Override
    public boolean equals(Object obj) {
        ChuyenDe other = (ChuyenDe) obj;
        return other.getMacd().equals(this.getMacd());
    }
    
    
}
