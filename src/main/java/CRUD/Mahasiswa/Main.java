package CRUD.Mahasiswa;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SiswaDAO siswaDAO = new SiswaDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Lihat Semua Siswa");
            System.out.println("3. Cari Siswa berdasarkan ID");
            System.out.println("4. Update Siswa");
            System.out.println("5. Hapus Siswa");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline setelah nextInt

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan umur: ");
                    int umur = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan alamat: ");
                    String alamat = scanner.nextLine();
                    Siswa siswa = new Siswa(nama, umur, alamat);
                    siswaDAO.addSiswa(siswa);
                    break;
                case 2:
                    List<Siswa> siswaList = siswaDAO.getAllSiswa();
                    for (Siswa s : siswaList) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    System.out.print("Masukkan ID siswa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Siswa siswaById = siswaDAO.getSiswaById(id);
                    if (siswaById != null) {
                        System.out.println(siswaById);
                    } else {
                        System.out.println("Siswa tidak ditemukan");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan ID siswa yang akan diupdate: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    Siswa siswaUpdate = siswaDAO.getSiswaById(idUpdate);
                    if (siswaUpdate != null) {
                        siswaDAO.updateSiswa(siswaUpdate, scanner);
                    } else {
                        System.out.println("Siswa tidak ditemukan");
                    }
                    break;
                case 5:
                    System.out.print("Masukkan ID siswa yang akan dihapus: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();
                    siswaDAO.deleteSiswa(idDelete);
                    break;
                case 6:
                    System.out.println("Keluar...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}
