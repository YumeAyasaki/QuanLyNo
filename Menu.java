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
        System.out.println("|*Option 5:        Sang thang tiep theo       *|");
        System.out.println("|*Option 6:         Thoat chuong trinh        *|");
        System.out.println("|*--------------------------------------------*|");

        do {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 6) {
                loop = false;
            }
            else {
                System.out.println("Chon lai");
            }
        } while (loop);
        return choice;
    }

    public void showStatus(ThuNhap thuNhap, ChiPhi chiPhi, NganHang nganHang, KhoanNo khoanNo1, KhoanNo khoanNo2, Date today) {
        // Lich
        System.out.println("Lich: " + Integer.toString(today.getMonth()) + "/" + Integer.toString(today.getYear()));

        // Luong
        System.out.println("Luong: ");
        System.out.println("    + Vo chong: " + Integer.toString(thuNhap.getLuongVoChong()) +        
        " | Chung: " + Integer.toString(thuNhap.getLuongChung()) + 
        " | Du: " + Integer.toString(thuNhap.getLuongChungDu()));

        // Chi phi
        System.out.println("Chi phi: ");
        System.out.println("    + Dien: " + Integer.toString(chiPhi.getDien()) + 
        " | Nuoc: " + Integer.toString(chiPhi.getNuoc()) + 
        " | An uong: " + Integer.toString(chiPhi.getAnUong()) + 
        " | Khac: " + Integer.toString(chiPhi.getChiPhiKhac()));

        // Ngan hang
        System.out.println("Ngan hang: ");
        System.out.println("   + Lai chung: " + Integer.toString(nganHang.getLais(today)));

        // Khoan no
        System.out.println("No du kien thang nay:");
        System.out.println("+ No chung: " + Integer.toString(khoanNo1.getLai(today) + khoanNo2.getLai(today)));

        
    }
}