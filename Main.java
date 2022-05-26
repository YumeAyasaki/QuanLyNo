// import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void clrscr(){
        //Clears Screen in java
        // try {
        //     if (System.getProperty("os.name").contains("Windows"))
        //         new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        //     else
        //         Runtime.getRuntime().exec("clear");
        // } catch (IOException | InterruptedException ex) {}
        try {
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        }
        catch(Exception err) {
            System.out.println(err);
        }
    }

    public static boolean traTienChiPhi(Luong luong, ChiPhi chiphi) {
        int luongChung = luong.getLuongChung() + luong.getLuongChungDu();
        int chiPhi = chiphi.getChiPhi();
        
        if (luongChung >= chiPhi) {
            luong.setLuongChungDu(luongChung - chiPhi);
            luong.setLuongChung(0);
        } else {
            if (luongChung + luong.getLuongVoChong() >= chiPhi) {
                int temp = luongChung + luong.getLuongVoChong() - chiPhi;
                luong.setLuongVoChong(luong.getLuongVoChong() - temp);
                luong.setLuongChungDu(0);
            } else {
                return false;
            }
        }
        
        return true;
    }

    public static boolean traTienLai(Luong luong, NganHang nganHang, KhoanNo khoanNo1, KhoanNo khoanno2, Date today, Scanner scanner) {
        int laiNoChung = khoanNo1.getLai(today) + khoanno2.getLai(today);
        int laiNganHang = nganHang.getLais(today);

        if (laiNganHang + luong.getLuongChungDu() < laiNoChung)
        {
            if (laiNganHang + luong.getLuongVoChong() + luong.getLuongChungDu() < laiNoChung) {
                return false;
            } else {
                luong.setLuongChungDu(luong.getLuongVoChong() + luong.getLuongChungDu() + laiNganHang - laiNoChung);
                luong.setLuongVoChong(0);
            }
        } else {
            luong.setLuongChungDu(luong.getLuongChungDu() + laiNganHang - laiNoChung);
        }
        return true;
        
    }

    public static void thongBaoVoNo() {
        System.out.println("Vo no.");
    }

    public static void main(String[] args) {
        // Initialize
        Scanner scanner = new Scanner(System.in);

        Luong luong = new Luong();
        ChiPhi chiPhi = new ChiPhi();
        NganHang nganHang = new NganHang();
        Date today = new Date(5, 2022);
        KhoanNo khoanNo1 = new KhoanNo(100000000, true, today);
        KhoanNo khoanNo2 = new KhoanNo(220000000, false, today);
        Boolean[] check = {false, false, false, false, false, false, false, false, false};

        Menu menu = new Menu();
        
        boolean isExit = false;
        do {
            clrscr();
            menu.showStatus(luong, chiPhi, nganHang, khoanNo1, khoanNo2, today);
            int choose = menu.createMenu(scanner);
            switch (choose) {
                case 1:
                    if (check[1] == true) {
                        System.out.println("Ban da nhap luong va chi phi.");
                        break;
                    }
                    luong.input(scanner);
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
                    if (!traTienChiPhi(luong, chiPhi)) {
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
                    if (luong.getLuongVoChong() < 10) {
                        System.out.println("So tien khong du de thuc hien giao dich nay.");
                        break;
                    }
                    nganHang.add(scanner, luong);
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
                    if (!traTienLai(luong, nganHang, khoanNo1, khoanNo2, today, scanner)) {
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
                            luong.setLuongChungDu(luong.getLuongChungDu() + luong.getLuongChung() + luong.getLuongVoChong());
                            luong.setLuongVoChong(0);
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
        } while (!isExit);

        scanner.close();
    } 
}