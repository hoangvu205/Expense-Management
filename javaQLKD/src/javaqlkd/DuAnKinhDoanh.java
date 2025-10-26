package javaqlkd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DuAnKinhDoanh {
    private String tenDuAn;
    private double vonDauTu;
    private double chiPhiDuKien;
    private double mucTieuLoiNhuan;
    private List<GiaoDich> danhSachGiaoDich;

    public DuAnKinhDoanh(String tenDuAn, double vonDauTu, double chiPhiDuKien, double mucTieuLoiNhuan) {
        this.tenDuAn = tenDuAn;
        this.vonDauTu = vonDauTu;
        this.chiPhiDuKien = chiPhiDuKien;
        this.mucTieuLoiNhuan = mucTieuLoiNhuan;
        this.danhSachGiaoDich = new ArrayList<>();
    }

    public void themGiaoDich(String moTa, double soTien, Date ngay, String ghiChu) {
        String danhMuc = soTien >= 0 ? "Thu nhập dự án" : "Chi phí dự án";
        danhSachGiaoDich.add(new GiaoDich(moTa, soTien, ngay, danhMuc, ghiChu));
    }

    public double tinhTongThuNhap() {
        return danhSachGiaoDich.stream()
                .filter(gd -> gd.getSoTien() > 0)
                .mapToDouble(GiaoDich::getSoTien)
                .sum();
    }

    public double tinhTongChiPhi() {
        return danhSachGiaoDich.stream()
                .filter(gd -> gd.getSoTien() < 0)
                .mapToDouble(GiaoDich::getSoTien)
                .sum();
    }

    public double tinhLoiNhuan() {
        return tinhTongThuNhap() + tinhTongChiPhi();
    }

    public int tongSoGiaoDich() {
        return danhSachGiaoDich.size();
    }

    // Getter và Setter
    public String getTenDuAn() { return tenDuAn; }
    public double getVonDauTu() { return vonDauTu; }
    public void setVonDauTu(double vonDauTu) { this.vonDauTu = vonDauTu; }
    public double getMucTieuLoiNhuan() { return mucTieuLoiNhuan; }
    public List<GiaoDich> getDanhSachGiaoDich() { return danhSachGiaoDich; }
}

