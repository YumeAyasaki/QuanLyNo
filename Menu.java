import java.util.Scanner;

public class Menu {
    protected Scanner scan = new Scanner(System.in);
    protected Boolean loop = true;
    protected int choice;

    public int createMenu()
    {
        System.out.println("|*--Chuong trinh quan ly chi tieu hang thang--*|");
        System.out.println("|*Option 1:       Nhap luong va chi phi       *|");
        System.out.println("|*Option 2:          Tra tien chi phi         *|");
        System.out.println("|*Option 3:       Gui tien vao ngan hang      *|");
        System.out.println("|*Option 4:            Tra tien no            *|");
        System.out.println("|*Option 5:         Thoat chuong trinh        *|");
        System.out.println("|*--------------------------------------------*|");

        do {
            choice = scan.nextInt();
            if (choice >= 1 && choice <= 5) {
                loop = false;
            }
            else {
                System.out.println("Chon lai");
            }
        } while (loop);
        scan.close();
        return choice;
    }
}