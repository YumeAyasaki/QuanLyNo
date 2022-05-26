import java.util.Scanner;

public class KhoanNo {
    protected int soTienNo;
    protected Date ngayTraNo;
    protected boolean chuKy = false; // false: thang, linh hoat | true: nam, co dinh
    protected double phanTramLai = 0;
    
    public KhoanNo()
    {
        
    }

    public KhoanNo(int soTienNo, boolean chuKy, Date ngayTraNo)
    {
        this.soTienNo = soTienNo;
        this.chuKy = chuKy;
        this.ngayTraNo = ngayTraNo;
        if (chuKy) {
            phanTramLai = 6.6;
        }
    }

    public void inputLai(Scanner scanner) {
        if (chuKy == false) {
            System.out.print("Nhap phan tram lai cua thang nay: ");
            phanTramLai = scanner.nextDouble();
        }
    }

    public int getLai(Date date) {
        if (chuKy == true) {
            if (ngayTraNo.diffMonths(date) % 12 != 0) {
                return 0;
            }
        }
        return (int) phanTramLai * soTienNo / 100;
    }
}