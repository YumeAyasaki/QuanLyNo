import java.util.Scanner;

public class SoNganHang {
    protected int soTienGui = 0;
    protected Date ngayGui = new Date();
    protected Boolean kyHan = false; // false = 6 thang, true = 1 nam

    public SoNganHang() {
        
    }

    public SoNganHang(int soTienGui, Date ngayGui, Boolean kyHan) {
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.kyHan = kyHan;
    }

    public SoNganHang(SoNganHang SoMoi)
    {
        this.soTienGui = SoMoi.soTienGui;
        this.ngayGui = SoMoi.ngayGui;
        this.kyHan = SoMoi.kyHan;
    }

    public int getSoTienGui()
    {
        return this.soTienGui;
    }

    public void setSoTienGui(int soTienGui)
    {
        this.soTienGui = soTienGui;
    }

    public Date getNgayGui()
    {
        return this.ngayGui;
    }

    public void setNgayGui(Date ngayGui)
    {
        this.ngayGui = ngayGui;
    }

    public Boolean getKyHan()
    {
        return this.kyHan;
    }

    public void setKyHan(Boolean kyHan)
    {
        this.kyHan = kyHan;
    }

    public int getLai()
    {
        if (this.getKyHan()) {
            return (int) (this.getSoTienGui() * 6.6 / 100);
        }
        return (int) (this.getSoTienGui() * 6 / 100);
    }

    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập số tiền muốn gửi tiết kiệm: ");
        int temp = scan.nextInt();
        this.setSoTienGui(temp);
        System.out.println("Chọn kỳ hạn: \n 1. 6 tháng (6%)\n 2. 1 năm(6.6%)");
        Boolean loop = true;
        do {
            temp = scan.nextInt();
            switch (temp) {
                case 1:
                    this.setKyHan(false);
                    break;

                case 2:
                    this.setKyHan(true);
                    break;

                default:
                    System.out.println("Chon lai");
                    break;
            }
        } while (loop);
        scan.close();
    }
}