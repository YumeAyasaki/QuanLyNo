public class Luong {
    private int luongBa = 0;
    private int luongMa = 0;
    private int luongChung = 0;

    // Constructor
    public Luong() {

    }

    public Luong(int luongBa, int luongMa, int luongChung) {
        this.luongBa = luongBa;
        this.luongMa = luongMa;
        this.luongChung = luongChung;
    }

    public Luong(Luong luong) {
        this.luongBa = luong.luongBa;
        this.luongMa = luong.luongMa;
        this.luongChung = luong.luongChung;
    }

    // Other method
    public int getLuong() {
        return luongBa + luongMa + luongChung;
    }

    public void setLuong(int luongBa, int luongMa, int luongChung) { // Using for input
        this.luongBa = luongBa;
        this.luongMa = luongMa;
        this.luongChung = luongChung;
    }
}