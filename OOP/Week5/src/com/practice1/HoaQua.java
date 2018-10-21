package com.practice1;

class Date {
    int day;
    int month;
    int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}

class HoaQua {
    private double khoiLuong;
    private String nguonGoc;
    private int giaBan;

    public double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }
    
    
}

class Cam extends HoaQua {
    
}

class Tao extends HoaQua {
    private int soQua;

    public int getSoQua() {
        return soQua;
    }

    public void setSoQua(int soQua) {
        this.soQua = soQua;
    }
    
}

class CamCaoPhong extends Cam {
    private Date ngayNhap;
    private int HSD;

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getHSD() {
        return HSD;
    }

    public void setHSD(int HSD) {
        this.HSD = HSD;
    }
    
}

class CamSanh extends Cam {
    private Date ngayNhap;
    private int HSD;

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getHSD() {
        return HSD;
    }

    public void setHSD(int HSD) {
        this.HSD = HSD;
    }
    
    public static void main(String[] args) {
        HoaQua hq = new HoaQua();
        HoaQua cam = new Cam();
        
    }
    
}
