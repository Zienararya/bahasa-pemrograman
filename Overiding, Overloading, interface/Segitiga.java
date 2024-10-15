public class Segitiga implements Menghitung {
    protected double alas;
    protected double tinggi;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return (alas * tinggi) / 2;
    }
// Segitiga gapunya volume
    @Override
    public double hitungVolume() {
        return 0;
    }
}
