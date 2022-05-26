import java.util.Scanner;

public class Luong {
    private int luongVoChong = 0;
    private int luongChung = 0;
    private int luongChungDu = 0;

    // Constructor
    public Luong() {

    }

    public Luong(int luongVoChong, int luongChung) {
        this.luongVoChong = luongVoChong;
        this.luongChung = luongChung;
    }

    public Luong(Luong luong) {
        this.luongVoChong = luong.luongVoChong;
        this.luongChung = luong.luongChung;
    }

    // Other method
    public int getLuongVoChong() {
        return luongVoChong;
    }

    public int getLuongChung() {
        return luongChung;
    }

    public int getLuongChungDu() {
        return luongChungDu;
    }

    public int getLuong() {
        return luongVoChong + luongChung;
    }

    public void setLuongVoChong(int luongVoChong) {
        this.luongVoChong = luongVoChong;
    }

    public void setLuong(int luongVoChong, int luongChung) { // Using for input
        this.luongVoChong = luongVoChong;
        this.luongChung = luongChung;
    }

    public void setLuongChungDu(int luongChungDu) {
        this.luongChungDu = luongChungDu;
    }

    public void setLuongChung(int luongChung) {
        this.luongChung = luongChung;
    }

    public void input(Scanner scanner)
    {
        int temp = 0;
        System.out.println("Nhap luong: ");
        System.out.print("Nhap luong chong: ");
        scanner.nextLine();
        temp += scanner.nextInt();
        System.out.print("Nhap luong vo: ");
        temp += scanner.nextInt();
        System.out.print("Nhap luong chung: ");
        luongChung = scanner.nextInt();
        this.setLuong(temp, luongChung);
    }
}