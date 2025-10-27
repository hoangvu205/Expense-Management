
package javaqlkd;

// Lớp Giao dịch

import java.util.Date;

public class GiaoDich {
    private String moTa;
    private double soTien;
    private Date ngay;
    private String danhMuc;
    private String ghiChu;

    public GiaoDich(String moTa, double soTien, Date ngay, String danhMuc, String ghiChu) {
        this.moTa = moTa;
        this.soTien = soTien;
        this.ngay = ngay;
        this.danhMuc = danhMuc;
        this.ghiChu = ghiChu;
    }

    public String getLoai() {
        return soTien >= 0 ? "Thu nhập" : "Chi tiêu";
    }
    
    public String toString(){
        return String.format("%s\n%f\n%s\n%s\n%s",moTa,soTien,ngay,danhMuc,ghiChu);
    }

    // Getter và Setter
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
    public double getSoTien() { return soTien; }
    public void setSoTien(double soTien) { this.soTien = soTien; }
    public Date getNgay() { return ngay; }
    public void setNgay(Date ngay) { this.ngay = ngay; }
    public String getDanhMuc() { return danhMuc; }
    public void setDanhMuc(String danhMuc) { this.danhMuc = danhMuc; }
    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}
