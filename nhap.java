import java.util.Scanner;
class PhanSo{
    long tu,mau;
    
    public PhanSo(long tu, long mau) {
        long tmp=nhap.gcd(tu,mau);
        tu/=tmp;mau/=tmp;
        this.tu = tu;
        this.mau = mau;
    }
    void PhanSo(){
        long tmp=nhap.gcd(this.tu,this.mau);
        this.tu/=tmp;
        this.mau/=tmp;
    }
    public String toString(){
        return String.format("%d/%d",this.tu,this.mau);
    }
    PhanSo add(PhanSo b){
        long sum_tu=this.tu*b.mau+b.tu*this.mau;
        return new PhanSo(sum_tu,this.mau*b.mau);
    }
}

public class nhap{
    static long gcd(long a,long b){
        while(a>0){
            long tmp=a;
            a=b%a;
            b=tmp;
        }
        return b;
    }
    static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
    static Scanner cin=new Scanner(System.in);
    public static void main(String[] args) {
        PhanSo a=new PhanSo(cin.nextLong(),cin.nextLong());
        PhanSo b=new PhanSo(cin.nextLong(),cin.nextLong());
        a=a.add(b);
        System.out.println(a);
    }
}