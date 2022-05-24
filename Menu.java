import java.util.Scanner;

public class Menu {
    protected Boolean loop = true;
    protected int choice;

    public int createMenu(Scanner scanner)
    {
        System.out.println("|*--Chuong trinh quan ly chi tieu hang thang--*|");
        System.out.println("|*Option 1:       Nhap luong va chi phi       *|");
        System.out.println("|*Option 2:          Tra tien chi phi         *|");
        System.out.println("|*Option 3:       Gui tien vao ngan hang      *|");
        System.out.println("|*Option 4:            Tra tien no            *|");
        System.out.println("|*Option 5:         Thoat chuong trinh        *|");
        System.out.println("|*--------------------------------------------*|");

        do {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 5) {
                loop = false;
            }
            else {
                System.out.println("Chon lai");
            }
        } while (loop);
        return choice;
    }

    public void showStatus(Luong luong, ChiPhi chiPhi, NganHang nganHang, KhoanNo khoanNo1, KhoanNo khoanNo2) {
        // Luong
        System.out.println("Luong: ");
        System.out.println("    + Chong: " + Integer.toString(luong.getLuongChong()) +        
        " | Vo: " + Integer.toString(luong.getLuongVo()) + 
        " | Chung: " + Integer.toString(luong.getLuongChung()));

        // Chi phi
        System.out.println("Chi phi: ");
        System.out.println("    + Dien: " + Integer.toString(chiPhi.getDien()) + 
        " | Nuoc: " + Integer.toString(chiPhi.getNuoc()) + 
        " | An uong: " + Integer.toString(chiPhi.getAnUong()) + 
        " | Khac:" + Integer.toString(chiPhi.getChiPhiKhac()));

        // Ngan hang
        System.out.println("Ngan hang: ");
        System.out.println("   + Lai chung: " + Integer.toString(nganHang.getLais()));

        // Khoan no
    }
}