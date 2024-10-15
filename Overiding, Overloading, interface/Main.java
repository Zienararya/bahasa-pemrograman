import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input nilai alas dan tinggi segitiga
        System.out.print("Masukkan panjang alas segitiga: ");
        double alas = input.nextDouble();

        System.out.print("Masukkan tinggi segitiga: ");
        double tinggi = input.nextDouble();

        // Menghitung luas segitiga
        Segitiga segitiga = new Segitiga(alas, tinggi);
        System.out.println("Luas Segitiga: " + segitiga.hitungLuas());

        // Input tinggi prisma
        System.out.print("\nMasukkan tinggi prisma segitiga: ");
        double tinggiPrisma = input.nextDouble();

        // Menghitung volume prisma segitiga
        PrismaSegitiga prisma = new PrismaSegitiga(alas, tinggi, tinggiPrisma);
        System.out.println("Volume Prisma Segitiga: " + prisma.hitungVolume());

        // Input tinggi limas
        System.out.print("\nMasukkan tinggi limas segitiga: ");
        double tinggiLimas = input.nextDouble();

        // Menghitung volume limas segitiga
        LimasSegitiga limas = new LimasSegitiga(alas, tinggi, tinggiLimas);
        System.out.println("Volume Limas Segitiga: " + limas.hitungVolume());
    }
}