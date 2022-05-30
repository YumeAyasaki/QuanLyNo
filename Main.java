// import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void clrscr() {
        try {
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        }
        catch(Exception err) {
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

    public static boolean traTienLai(ThuNhap thuNhap, NganHang nganHang, KhoanNo khoanNo1, KhoanNo khoanno2, Date today, Scanner scanner) {
        khoanno2.inputLai(scanner);
        int laiNoChung = khoanNo1.getLai(today) + khoanno2.getLai(today);
        int laiNganHang = nganHang.getLais(today);

        if (laiNganHang + thuNhap.getLuongChungDu() < laiNoChung)
        {
            if (laiNganHang + thuNhap.getLuongVoChong() + thuNhap.getLuongChungDu() < laiNoChung) {
                return false;
            } else {
                thuNhap.setLuongChungDu(thuNhap.getLuongVoChong() + thuNhap.getLuongChungDu() + laiNganHang - laiNoChung);
                thuNhap.setLuongVoChong(0);
            }
        } else {
            thuNhap.setLuongChungDu(thuNhap.getLuongChungDu() + laiNganHang - laiNoChung);
        }
        return true;   
    }

    public static void thongBaoVoNo() {
        System.out.println("Vo no.");
    }

    public static void inputKhoanNo(Scanner scanner, KhoanNo khoanNo1, KhoanNo khoanNo2) {
        // System.out.println("Nhap so khoan no: ");
        // int count = scanner.nextInt();
        
        // Tao vector
        // Nhap, add
    }

    public static void main(String[] args) {
        // Initialize
        Scanner scanner = new Scanner(System.in);

        ThuNhap thuNhap = new ThuNhap();
        ChiPhi chiPhi = new ChiPhi();
        NganHang nganHang = new NganHang();
        Date today = new Date(5, 2022);
        KhoanNo khoanNo1 = new KhoanNo(); // Co dinh?
        KhoanNo khoanNo2 = new KhoanNo(); // Co dinh?
        Boolean[] check = {false, false, false, false, false, false, false, false, false};
        Date lastDate = new Date();

        // inputKhoanNo(scanner, khoanNo1, khoanNo2);
        khoanNo1.input(scanner, today);
        khoanNo2.input(scanner, today);
        lastDate = Date.max(khoanNo1.getNgayTraNo(), khoanNo2.getNgayTraNo());

        Menu menu = new Menu();
        
        boolean isExit = false;
        today.plusMonths(1);
        do {
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
                    if (check[1] == false)
                    {
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
                    if (check[1] == false)
                    {
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
                    if (check[1] == false)
                    {
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
                    if (check[2] && check[4])
                    {
                        if (!(check[1] || check[3])) {
                            System.out.println("Ban chua nhan luong.");
                        }
                        else {
                            today.plusMonths(1);
                            for (int i = 1; i < 5; ++i) {
                                check[i] = false;
                            }
                            thuNhap.setLuongChungDu(thuNhap.getLuongChungDu() + thuNhap.getLuongChung() + thuNhap.getLuongVoChong());
                            thuNhap.setLuongVoChong(0);
                        }
                    }
                    else {
                        System.out.println("Ban chua tra chi phi hoac no.");
                    }
                    break;
                case 6:
                    isExit = true;
                    break;
                    
                default:
                    break;
            }
            scanner.nextLine();

            // Ngay cuoi?
            if (Date.max(today, lastDate) == today) {
                isExit = true;
            }
        } while (!isExit);

        scanner.close();
    } 
}