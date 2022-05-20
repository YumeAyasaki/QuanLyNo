import java.util.Scanner;

public class ChiPhi{
    private int dien;
    private int nuoc;
    private int anuong;
    private int chiphikhac;

    public void setDien(int dien) {
        this.dien = dien;
    }

    public void setNuoc(int nuoc) {
        this.nuoc = nuoc;
    }
    
    public void setAnUong(int anuong) {
        this.anuong = anuong;
    }

    public void setChiPhiKhac(int chiphikhac) {
        this.chiphikhac = chiphikhac;
    }

    public int getNuoc() {
        return this.nuoc;
    }

    public int getDien() {
        return this.dien;
    }

    public int getAnUong() {
        return this.anuong;
    }

    public int getChiPhiKhac() {
        return this.chiphikhac;
    }
    
    public int getChiPhi() {
        return (int) (getDien()+getNuoc()+getChiPhiKhac()+getAnUong());
    }

    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập chi phí:");
        System.out.print("Nhập tiền điện: ");
        this.dien = scan.nextInt(); 
        System.out.print("Nhập tiền nước: ");
        this.nuoc = scan.nextInt(); 
        System.out.print("Nhập tiền ăn uống: ");
        this.anuong = scan.nextInt(); 
        System.out.print("Nhập tiền chi phí khác: ");
        this.chiphikhac = scan.nextInt(); 
        scan.close();
    }
}