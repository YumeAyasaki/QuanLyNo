import java.util.Scanner;

public class KhoanNo {
    protected int soTienNo;
    protected Date ngayMuonNo = new Date();
    protected Date ngayTraNo = new Date();
    protected int chuKy;
    protected boolean linhHoat = false; // true: thang, linh hoat | false: nam, co dinh
    protected double phanTramLai = 0;
    
    public KhoanNo()
    {
        
    }

    public KhoanNo(int soTienNo, int chuKy, boolean linhHoat, Date ngayTraNo)
    {
        this.soTienNo = soTienNo;
        this.chuKy = chuKy;
        this.linhHoat = linhHoat;
        this.ngayTraNo = ngayTraNo;
        if (linhHoat) {
            phanTramLai = 6.6;
        }
    }

    public Date getNgayTraNo() {
        return ngayTraNo;
    }

    public void inputLai(Scanner scanner) {
        if (linhHoat == true) {
            System.out.print("Nhap phan tram lai cua thang nay: ");
            phanTramLai = scanner.nextDouble();
        }
    }

    public int getLai(Date date) {
        if (linhHoat == false) {
            if (ngayTraNo.diffMonths(date) % 12 != 0) {
                return 0;
            }
        }
        return (int) phanTramLai * soTienNo / 100;
    }

    public void input(Scanner scanner, Date today) {
        System.out.println("Nhap no: ");
        System.out.print("Nhap so tien no: ");
        this.soTienNo = scanner.nextInt();
        this.ngayMuonNo = today;
        System.out.println("Nhap ngay tra no: ");
        this.ngayTraNo.input(scanner);
        do {
            System.out.print("Nhap chu ky (thang): ");
            this.chuKy = scanner.nextInt();
        } while (ngayTraNo.diffMonths(ngayMuonNo) < chuKy);
        
        while (true) {
            System.out.print("No co thay doi theo thang (Y/N)? ");
            char c = scanner.next().charAt(0);
            c = Character.toUpperCase(c);
            if (c == 'Y') {
                this.linhHoat = true;
                break;
            }
            else if (c == 'N') {
                this.linhHoat = false;
                break;
            }
        }
        if (this.linhHoat == false) {
            System.out.print("Nhap phan tram lai: ");
            this.phanTramLai = scanner.nextDouble();
        }
    }
}