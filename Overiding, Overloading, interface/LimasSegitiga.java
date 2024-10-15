public class LimasSegitiga extends Segitiga {
    private double tinggiLimas;

    public LimasSegitiga(double alas, double tinggi, double tinggiLimas) {
        super(alas, tinggi);
        this.tinggiLimas = tinggiLimas;
    }
    
    @Override
    public double hitungVolume() {
        return (hitungLuas() * tinggiLimas) / 3;
    }
}
