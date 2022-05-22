import java.util.*;

public class NganHang {
    Vector<SoNganHang> khoanGui = new Vector<>();

    public void add(Scanner scanner) {
        SoNganHang soNganHang = new SoNganHang();
        soNganHang.input(scanner);
        khoanGui.add(soNganHang);
    }
}