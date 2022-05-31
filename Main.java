
// import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void clrscr() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public static boolean traTienChiPhi(ThuNhap thuNhap, ChiPhi chiphi) {
        int luongChung = thuNhap.getLuongChung() + thuNhap.getLuongChungDu();
        int chiPhi = chiphi.getChiPhi();

        if (luongChung >= chiPhi) {
            thuNhap.setLuongChungDu(luongChung - chiPhi);
            thuNhap.setLuongChung(0);
        } else {
            if (luongChung + thuNhap.getLuongVoChong() >= chiPhi) {
                int temp = luongChung + thuNhap.getLuongVoChong() - chiPhi;
                thuNhap.setLuongVoChong(thuNhap.getLuongVoChong() - temp);
                thuNhap.setLuongChungDu(0);
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean traTienLai(ThuNhap thuNhap, NganHang nganHang, KhoanNo khoanNo1, KhoanNo khoanno2, Date today,
            Scanner scanner) {
        khoanno2.inputLai(scanner);
        int laiNoChung = khoanNo1.getLai(today) + khoanno2.getLai(today);
        int laiNganHang = nganHang.getLais(today);

        if (laiNganHang < laiNoChung) {
            if (laiNganHang + thuNhap.getLuongVoChong() < laiNoChung) {
                return false;
            } else {
                thuNhap.setThuNhapTraNo(thuNhap.getLuongVoChong() + laiNganHang - laiNoChung);
                thuNhap.setLuongVoChong(0);
            }
        } else {
            thuNhap.setThuNhapTraNo(laiNganHang - laiNoChung);
        }
        return true;
    }

    public static void thongBaoVoNo() {
        System.out.println("Vo no.");
    }

    public static void inputKhoanNo(Scanner scanner, Vector<KhoanNo> khoanNos, Date today) {
        System.out.println("Nhap so khoan no: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; ++i) {
            khoanNos.add(new KhoanNo());
            khoanNos.get(i).input(scanner, today);
        }

        // Sort vector khoanNo
        Collections.sort(khoanNos);
    }

    public static boolean traTienNo(ThuNhap thuNhap, Vector<KhoanNo> khoanNos, Date today) {
        for (int i = 0; i < khoanNos.size(); ++i) {
            if (khoanNos.get(i).getNgayTraNo().isEqual(today)) {
                if (thuNhap.getThuNhapTraNo() < khoanNos.get(i).getTienNo()) {
                    return false;
                } else {
                    khoanNos.remove(i);
                    i--;
                    thuNhap.setThuNhapTraNo(thuNhap.getThuNhapTraNo() - khoanNos.get(i).getTienNo());
                }
            }
        }
        return true;
    }

    public static boolean duDoanNo(ThuNhap thuNhap, ChiPhi chiPhi, NganHang nganHang, Vector<KhoanNo> khoanNos,
            Date today) {
        // Lay tong thu nhap
        int vao = thuNhap.getThuNhapTraNo();
        // Chot cho ngan hang
        int pivot = 0;
        for (int i = 0; i < khoanNos.size(); ++i) {
            // Lay ti le => Tong tien tich luy toi ngay tra no
            Date temp2 = new Date(khoanNos.get(i).getNgayTraNo());
            while (temp2.isGreater(nganHang.getKhoanGui().get(pivot).getNgayTra())) {
                vao += nganHang.getKhoanGui().get(pivot).getLai();
                pivot++;
            }
            if (vao >= khoanNos.get(i).getTienNo()) {
                vao -= khoanNos.get(i).getTienNo();
            } else {
                // Khong tra no thanh cong
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Initialize
        // System.out.println(new Date(11, 2022).isEqual(new Date(11, 2022)));
        Scanner scanner = new Scanner(System.in);

        ThuNhap thuNhap = new ThuNhap();
        ChiPhi chiPhi = new ChiPhi();
        NganHang nganHang = new NganHang();
        Date today = new Date(5, 2022);
        //
        Vector<KhoanNo> khoanNos = new Vector<KhoanNo>();
        KhoanNo khoanNo1 = new KhoanNo(); // Co dinh?
        KhoanNo khoanNo2 = new KhoanNo(); // Co dinh?
        Boolean[] check = { false, false, false, false, false, false, false, false, false };
        Date lastDate = new Date();

        inputKhoanNo(scanner, khoanNos, today);
        // for (int i = 0; i < khoanNos.size(); ++i) {
        // Date temp = khoanNos.get(i).getNgayTraNo();
        // System.out.println(Integer.toString(temp.getMonth()) + ' ' +
        // Integer.toString(temp.getYear()));
        // }
        // khoanNo1.input(scanner, today);
        // khoanNo2.input(scanner, today);
        lastDate = Date.max(khoanNo1.getNgayTraNo(), khoanNo2.getNgayTraNo());

        Menu menu = new Menu();

        boolean isExit = false;
        today.plusMonths(1);
        do {
            if (!traTienNo(thuNhap, khoanNos, today)) {
                thongBaoVoNo();
                break;
            }
            clrscr();
            menu.showStatus(thuNhap, chiPhi, nganHang, khoanNo1, khoanNo2, today);
            int choose = menu.createMenu(scanner);
            switch (choose) {
                case 1:
                    if (check[1] == true) {
                        System.out.println("Ban da nhap luong va chi phi.");
                        break;
                    }
                    thuNhap.input(scanner);
                    chiPhi.input(scanner);
                    check[1] = true;
                    break;
                case 2:
                    if (check[1] == false) {
                        System.out.println("Ban chua nhap luong va chi phi.");
                        break;
                    }
                    if (check[2] == true) {
                        System.out.println("Ban da tra chi phi.");
                        break;
                    }
                    if (!traTienChiPhi(thuNhap, chiPhi)) {
                        thongBaoVoNo();
                        System.exit(0);
                    }
                    check[2] = true;
                    break;
                case 3:
                    if (check[1] == false) {
                        System.out.println("Ban chua nhap luong va chi phi.");
                        break;
                    }
                    if (check[3] == true) {
                        System.out.println("Ban da gui ngan hang.");
                        break;
                    }
                    nganHang.add(scanner, thuNhap);
                    check[3] = true;
                    break;
                case 4:
                    if (check[1] == false) {
                        System.out.println("Ban chua nhap luong va chi phi.");
                        break;
                    }
                    if (check[4] == true) {
                        System.out.println("Ban da tra no.");
                        break;
                    }
                    if (!traTienLai(thuNhap, nganHang, khoanNo1, khoanNo2, today, scanner)) {
                        thongBaoVoNo();
                        System.exit(0);
                    }
                    check[4] = true;
                    break;
                case 5:
                    if (check[2] && check[4]) {
                        if (!(check[1] || check[3])) {
                            System.out.println("Ban chua nhan luong.");
                        } else {
                            today.plusMonths(1);
                            for (int i = 1; i < 5; ++i) {
                                check[i] = false;
                            }
                            thuNhap.setLuongChungDu(
                                    thuNhap.getLuongChungDu() + thuNhap.getLuongChung() + thuNhap.getLuongVoChong());
                            thuNhap.setLuongVoChong(0);
                        }
                    } else {
                        System.out.println("Ban chua tra chi phi hoac no.");
                    }
                    break;
                case 6:
                    isExit = true;
                    break;

                default:
                    break;
            }
            System.out.println("Press enter to continue ...");
            String line = scanner.nextLine();

            // Ngay cuoi?
            if (Date.max(today, lastDate) == today) {
                isExit = true;
            }
        } while (!isExit);
        scanner.close();
    }
}