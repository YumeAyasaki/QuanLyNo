import java.util.*;

public class NganHang {
    Vector<SoNganHang> khoanGui = new Vector<>();

    public void add(Scanner scanner, Luong luong) {
        SoNganHang soNganHang = new SoNganHang();
        soNganHang.input(scanner, luong);
        khoanGui.add(soNganHang);
    }

    public int getLais(Date today) {
        int ans = 0;
        for (int i = 0; i < khoanGui.size(); ++i) {
            if (khoanGui.get(i).ngayTra.diffMonths(today) == 0) {
                ans += khoanGui.get(i).getLai();
                khoanGui.remove(i);
            }
        }
        return ans;
    }
}