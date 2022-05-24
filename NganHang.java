import java.util.*;

public class NganHang {
    Vector<SoNganHang> khoanGui = new Vector<>();

    public void add(Scanner scanner) {
        SoNganHang soNganHang = new SoNganHang();
        soNganHang.input(scanner);
        khoanGui.add(soNganHang);
    }

    public int getLais() {
        int ans = 0;
        for (int i = 0; i < khoanGui.size(); ++i) {
            ans += khoanGui.get(i).getLai();
        }
        return ans;
    }
}