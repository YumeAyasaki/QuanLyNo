import java.util.Scanner;

public class SoNganHang {
    protected int soTienGui = 0;
    protected Date ngayGui = new Date();
    protected Date ngayTra = new Date();
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

    public void setNgayTra(Date ngayGui)
    {
        this.ngayTra = ngayGui;
        if (getKyHan()) {
            this.ngayTra.plusMonths(12);
        } else {
            this.ngayTra.plusMonths(6);
        }
    }

    public int getLai()
    {
        if (this.getKyHan()) {
            return (int) (this.getSoTienGui() * 6.6 / 100 + this.getSoTienGui());
        }
        return (int) (this.getSoTienGui() * 6 / 100 + this.getSoTienGui());
    }

    public void input(Scanner scanner, Luong luong) {
        System.out.println("Nhap so tien muon gui tiet kiem: ");
        int temp = scanner.nextInt();
        this.setSoTienGui(temp);
        luong.setLuongVoChong(luong.getLuongVoChong() - temp);
        System.out.println("Chon ky han: \n 1. 6 thang (6%)\n 2. 1 nam (6.6%)");
        Boolean loop = true;
        do {
            temp = scanner.nextInt();
            switch (temp) {
                case 1:
                    this.setKyHan(false);
                    loop = false;
                    break;

                case 2:
                    this.setKyHan(true);
                    loop = false;
                    break;

                default:
                    System.out.println("Chon lai");
                    break;
            }
        } while (loop);
        setNgayTra(ngayGui);
    }
}