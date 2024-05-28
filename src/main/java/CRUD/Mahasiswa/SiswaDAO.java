package CRUD.Mahasiswa;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SiswaDAO {
    /**
     * Method untuk menambahkan mahasiswa
     * @param siswa
     */
    public void addSiswa(Siswa siswa){
        String query = "INSERT INTO siswa (nama,umur,alamat) VALUES (?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,siswa.getNama());
            statement.setInt(2,siswa.getUmur());
            statement.setString(3,siswa.getAlamat());
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("Data siswa berhasil ditambahkan.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Method untuk mendapatkan semua data mahasiswa
     */
    public List<Siswa> getAllSiswa() {
        List<Siswa> siswaList = new ArrayList<>();
        String query = "SELECT * FROM siswa";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                int umur = resultSet.getInt("umur");
                String alamat = resultSet.getString("alamat");
                siswaList.add(new Siswa(id, nama, umur, alamat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siswaList;
    }

    public Siswa getSiswaById(int id) {
        Siswa siswa = null;
        String query = "SELECT * FROM siswa WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nama = resultSet.getString("nama");
                    int umur = resultSet.getInt("umur");
                    String alamat = resultSet.getString("alamat");
                    siswa = new Siswa(id, nama, umur, alamat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siswa;
    }

    public void updateSiswa(Siswa siswa, Scanner scanner) {
        Siswa oldSiswa = getSiswaById(siswa.getId());
        if (oldSiswa != null) {
            System.out.println("Data lama:");
            System.out.println("Nama: " + oldSiswa.getNama());
            System.out.println("Umur: " + oldSiswa.getUmur());
            System.out.println("Alamat: " + oldSiswa.getAlamat());

            System.out.print("Masukkan nama baru (kosongkan jika tidak ingin mengubah): ");
            String namaBaru = scanner.nextLine();
            if (!namaBaru.isEmpty()) {
                siswa.setNama(namaBaru);
            }

            System.out.print("Masukkan umur baru (kosongkan jika tidak ingin mengubah): ");
            String umurBaru = scanner.nextLine();
            if (!umurBaru.isEmpty()) {
                siswa.setUmur(Integer.parseInt(umurBaru));
            }

            System.out.print("Masukkan alamat baru (kosongkan jika tidak ingin mengubah): ");
            String alamatBaru = scanner.nextLine();
            if (!alamatBaru.isEmpty()) {
                siswa.setAlamat(alamatBaru);
            }

            String query = "UPDATE siswa SET nama = ?, umur = ?, alamat = ? WHERE id = ?";
            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, siswa.getNama());
                statement.setInt(2, siswa.getUmur());
                statement.setString(3, siswa.getAlamat());
                statement.setInt(4, siswa.getId());
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Data siswa berhasil diperbarui.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Siswa tidak ditemukan.");
        }
    }


    public void deleteSiswa(int id) {
        String query = "DELETE FROM siswa WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Data siswa berhasil dihapus.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
