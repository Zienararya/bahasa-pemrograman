import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class tugas {
    public static void main(String[] args) {
        ArrayList<String> mahasiswaList = new ArrayList<>();
        String[] options = {"Tambah Mahasiswa", "Hapus Mahasiswa", "Ubah Mahasiswa", "Urutkan Mahasiswa", "Tampilkan Mahasiswa", "Keluar"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        
        while (true) {
            JOptionPane.showMessageDialog(null, comboBox, "Database Mahasiswa", JOptionPane.DEFAULT_OPTION);
            String selectedOption = (String) comboBox.getSelectedItem();

            switch (selectedOption) {
                case "Tambah Mahasiswa":
                    String namaBaru = JOptionPane.showInputDialog("Masukkan nama mahasiswa baru:");
                    if (namaBaru != null && !namaBaru.trim().isEmpty()) {
                        mahasiswaList.add(namaBaru.trim());
                        JOptionPane.showMessageDialog(null, "Nama Mahasiswa: " + namaBaru + ", berhasil ditambahkan");
                    }
                    break;
                    
                case "Hapus Mahasiswa":
                    String namaHapus = JOptionPane.showInputDialog("Masukkan nama mahasiswa yang akan dihapus:");
                    if (namaHapus != null && mahasiswaList.contains(namaHapus.trim())) {
                        mahasiswaList.remove(namaHapus.trim());
                        JOptionPane.showMessageDialog(null, "Nama Mahasiswa: " + namaHapus + ", berhasil dihapus");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nama Mahasiswa tidak ditemukan");
                    }
                    break;
                    
                case "Ubah Mahasiswa":
                    String namaUbah = JOptionPane.showInputDialog("Masukkan nama mahasiswa yang akan diubah:");
                    if (namaUbah != null && mahasiswaList.contains(namaUbah.trim())) {
                        String namaBaruUbah = JOptionPane.showInputDialog("Masukkan nama baru untuk mahasiswa:");
                        if (namaBaruUbah != null && !namaBaruUbah.trim().isEmpty()) {
                            mahasiswaList.set(mahasiswaList.indexOf(namaUbah.trim()), namaBaruUbah.trim());
                            JOptionPane.showMessageDialog(null, "Nama Mahasiswa: " + namaUbah + " berhasil diubah menjadi " + namaBaruUbah);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nama Mahasiswa tidak ditemukan");
                    }
                    break;
                    
                case "Urutkan Mahasiswa":
                    Collections.sort(mahasiswaList);
                    JOptionPane.showMessageDialog(null, "Data Mahasiswa berhasil diurutkan.");
                    break;
                    
                case "Tampilkan Mahasiswa":
                    StringBuilder sb = new StringBuilder("Daftar Mahasiswa:\n");
                    for (String nama : mahasiswaList) {
                        sb.append(nama).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;
                    
                case "Keluar":
                    System.exit(0);
                    break;
                    
                default:
                    break;
            }
        }
    }
}
