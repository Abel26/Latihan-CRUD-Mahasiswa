package CRUD.Mahasiswa;

public class Siswa {
    private int id;
    private String nama;
    private int umur;
    private String alamat;

    public Siswa(int id, String nama, int umur, String alamat){
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }

    public Siswa(String nama, int umur, String alamat){
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }

    // getId
    public int getId() {
        return id;
    }

    // setId
    public void setId(int id) {
        this.id = id;
    }

    // getNama
    public String getNama() {
        return nama;
    }

    // setNama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // getUmur
    public int getUmur() {
        return umur;
    }

    // setUmur
    public void setUmur(int umur) {
        this.umur = umur;
    }

    // getAlamat
    public String getAlamat() {
        return alamat;
    }

    // setAlamat
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "Siswa{id=" + id + ", nama='" + nama + "', umur=" + umur + ", alamat='" + alamat + "'}";
    }
}
