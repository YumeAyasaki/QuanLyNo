import java.util.*;

public class NganHang {
    Vector<SoNganHang> khoanGui = new Vector<>();

    public void add(Scanner scanner, ThuNhap thuNhap, Date today) {
        SoNganHang soNganHang = new SoNganHang();
        soNganHang.input(scanner, thuNhap, today);
        khoanGui.add(soNganHang);
    }

    public int getLais(Date today) {
        int ans = 0;
        for (int i = 0; i < khoanGui.size(); ++i) {
            if (khoanGui.get(i).getNgayTra().isEqual(today)) {
                ans += khoanGui.get(i).getLai();
            }
        }
        return ans;
    }

    public Vector<SoNganHang> getKhoanGui() {
        return khoanGui;
    }
}