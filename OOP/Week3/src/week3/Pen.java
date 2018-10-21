package week3;

public class Pen {
    private String mauBut;
    private String mauMuc;
    private int luongMuc;

    public String getMauBut() {
        return mauBut;
    }

    public void setMauBut(String mauBut) {
        this.mauBut = mauBut;
    }

    public String getMauMuc() {
        return mauMuc;
    }

    public void setMauMuc(String mauMuc) {
        this.mauMuc = mauMuc;
    }

    public int getLuongMuc() {
        return luongMuc;
    }

    public void setLuongMuc(int luongMuc) {
        this.luongMuc = luongMuc;
    }
    
    boolean conMuc() {
        return luongMuc == 0;
    }
}
