import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public static void main(String[] args) {
        // Initialize
        Scanner scanner = new Scanner(System.in);

        Luong luong = new Luong();
        ChiPhi chiPhi = new ChiPhi();
        NganHang nganHang = new NganHang();
        KhoanNo khoanNo100tr = new KhoanNo(100000000);
        KhoanNo khoanNo220tr = new KhoanNo(220000000);

        Menu menu = new Menu();
        
        boolean isExit = false;
        do {
            clrscr();
            menu.showStatus(luong, chiPhi, nganHang, khoanNo100tr, khoanNo220tr);
            int choose = menu.createMenu(scanner);
            switch (choose) {
                case 1:
                    luong.input(scanner);
                    chiPhi.input(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    nganHang.add(scanner);
                    break;
                case 4:
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    break;
            }
        } while (!isExit);

        scanner.close();
    } 
}