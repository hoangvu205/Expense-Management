package com.trungtamjava.javaswing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class giaoDich {
    private String moTa;
    private String loai;
    private LocalDate ngay;
    protected double soTien;
    private String ghiChu;
    public giaoDich(String moTa,String loai,String ngay,double soTien,String ghiChu){
        this.moTa=moTa;
        this.loai=loai;
        this.ngay=LocalDate.parse(ngay,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.soTien=soTien;
        this.ghiChu=ghiChu;
    }
    public String toString(){
        return String.format("%s %s %s %f %s",moTa,loai,ngay.toString(),soTien,ghiChu);
    }
    public String getMoTa() {
        return moTa;
    }
    public String getLoai() {
        return loai;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public double getSoTien() {
        return soTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
    
    
    
    public double tinhSoTienThuc(){
        return soTien;
    }
}
