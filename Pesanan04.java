public class Pesanan04 {
    int kodePesanan, harga;
    String namaPesanan;
    Pesanan04 prev, next;

    public Pesanan04(int kodePesanan, String namaPesanan, int harga) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.prev = null;
        this.next = null;
    }
}
