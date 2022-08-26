
import java.io.Serializable;

public class cauThu {
    String MaCT;
    String Ten;
    int NamSinh;
    String ViTriThiDau;
    float LuongCoBan;

    public cauThu() {
    }

    public String toString() {
        return MaCT + "$" + Ten + "$" + NamSinh + "$" + ViTriThiDau + "$" + LuongCoBan;
    }

    public cauThu(String MaCT, String Ten, int NamSinh, String ViTriThiDau, float LuongCoBan) {
        this.MaCT = MaCT;
        this.Ten = Ten;
        this.NamSinh = NamSinh;
        this.ViTriThiDau = ViTriThiDau;
        this.LuongCoBan = LuongCoBan;
    }

    public String getMaCauThu() {
        return MaCT;
    }

    public void setMaCauThu(String MaCT) {
        this.MaCT = MaCT;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getViTri() {
        return ViTriThiDau;
    }

    public void setViTri(String ViTriThiDau) {
        this.ViTriThiDau = ViTriThiDau;
    }

    public float getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(float LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

}
