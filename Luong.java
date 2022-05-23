import java.util.Scanner;

public class Luong {
    private int luongChong = 0;
    private int luongVo = 0;
    private int luongChung = 0;

    // Constructor
    public Luong() {

    }

    public Luong(int luongChong, int luongVo, int luongChung) {
        this.luongChong = luongChong;
        this.luongVo = luongVo;
        this.luongChung = luongChung;
    }

    public Luong(Luong luong) {
        this.luongChong = luong.luongChong;
        this.luongVo = luong.luongVo;
        this.luongChung = luong.luongChung;
    }

    // Other method
    public int getLuong() {
        return luongChong + luongVo + luongChung;
    }

    public void setLuong(int luongChong, int luongVo, int luongChung) { // Using for input
        this.luongChong = luongChong;
        this.luongVo = luongVo;
        this.luongChung = luongChung;
    }

    public void input(Scanner scanner)
    {
        System.out.println("Nhap luong: ");
        System.out.print("Nhap luong chong: ");
        scanner.nextLine();
        luongChong = scanner.nextInt();
        System.out.print("Nhap luong vo: ");
        luongVo = scanner.nextInt();
        System.out.print("Nhap luong chung: ");
        luongChung = scanner.nextInt();
        this.setLuong(luongChong, luongVo, luongChung);
    }
}