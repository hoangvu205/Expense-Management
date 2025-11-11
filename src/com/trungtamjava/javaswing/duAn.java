package com.trungtamjava.javaswing;
import com.trungtamjava.javaswing.giaoDich;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class duAn {
    private String tenDuAn;
    private double vonDauTu;
    private double chiPhiDuKien;
    private double mucTieuLoiNhuan;
    private ArrayList<giaoDich> danhSachgiaoDich;

    public duAn(String tenDuAn, double vonDauTu, double chiPhiDuKien, double mucTieuLoiNhuan) {
        this.tenDuAn = tenDuAn;
        this.vonDauTu = vonDauTu;
        this.chiPhiDuKien = chiPhiDuKien;
        this.mucTieuLoiNhuan = mucTieuLoiNhuan;
        this.danhSachgiaoDich = new ArrayList<>();
    }
    public String toString(){
        return String.format("%s\n%f\n%f\n%f",tenDuAn,vonDauTu,chiPhiDuKien,mucTieuLoiNhuan);
    }
    public void themgiaoDich(String moTa, double soTien, String ngay, String ghiChu) {
        String danhMuc = soTien >= 0 ? "Thu nhập dự án" : "Chi phí dự án";
        danhSachgiaoDich.add(new giaoDich(moTa, danhMuc, ngay, soTien, ghiChu));
    }

    public double tinhTongThuNhap() {
        return danhSachgiaoDich.stream()
                .filter(gd -> gd.getSoTien() > 0)
                .mapToDouble(giaoDich::getSoTien)
                .sum();
    }

    public double tinhTongChiPhi() {
        return danhSachgiaoDich.stream()
                .filter(gd -> gd.getSoTien() < 0)
                .mapToDouble(giaoDich::getSoTien)
                .sum();
    }

    public double tinhLoiNhuan() {
        return tinhTongThuNhap() + tinhTongChiPhi();
    }

    public int tongSogiaoDich() {
        return danhSachgiaoDich.size();
    }
    // Getter và Setter
    public String getTenDuAn() { return tenDuAn; }
    public double getVonDauTu() { return vonDauTu; }
    public void setVonDauTu(double vonDauTu) { this.vonDauTu = vonDauTu; }
    public double getMucTieuLoiNhuan() { return mucTieuLoiNhuan; }
    public double getChiPhiDuKien(){return chiPhiDuKien;}
    public void setTenDuAn(String tenDuAn){this.tenDuAn=tenDuAn;}
    public void setMucTieuLoiNhuan(){
        this.mucTieuLoiNhuan=mucTieuLoiNhuan;
    }
    public void setChiPhiDuKien(double chiPhiDuKien){
        this.chiPhiDuKien=chiPhiDuKien;
    }
    public void setMucTieuLoiNhuan(double mucTieuLoiNhuan){
        this.mucTieuLoiNhuan=mucTieuLoiNhuan;
    }
    public ArrayList<giaoDich> getDanhSachgiaoDich() { return danhSachgiaoDich; }
}

