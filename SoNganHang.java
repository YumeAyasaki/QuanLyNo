import java.util.*;
import java.text.*;

public class SoNganHang {
    protected int soTienGui = 0;
    protected Date ngayGui = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

    public SoNganHang() {
        
    }

    public SoNganHang(int soTienGui, Date ngayGui) {
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
    }

    public SoNganHang(SoNganHang SoMoi)
    {
        this.soTienGui = SoMoi.soTienGui;
        this.ngayGui = SoMoi.ngayGui;
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
}