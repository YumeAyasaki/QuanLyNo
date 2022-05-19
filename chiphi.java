public class chiphi{
    private long dien;
    private double nuoc;
    private double anuong;
    private double chiphikhac;

    public void setDien(long dien){
        this.dien=dien;
    }
    public void setNuoc(double nuoc){
        this.nuoc=nuoc;
    }
    public void setAnUong(double anuong){
        this.anuong=anuong;
    }
    public void setChiPhiKhac(double chiphikhac){
        this.chiphikhac=chiphikhac;
    }
    public double getNuoc(){
        return this.nuoc;
    }
    public long getDien(){
        return this.dien;
    }
    public double getAnUong(){
        return this.anuong;
    }
    public double getChiPhiKhac(){
        return this.chiphikhac;
    }
    public long getChiPhi(){
        return (long) (getDien()+getNuoc()+getChiPhiKhac()+getAnUong());
    }
}