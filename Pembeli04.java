public class Pembeli04 {
    int noAntrian;
    String namaPembeli, noHP;
    Pembeli04 prev, next;

    public Pembeli04(int noAntrian, String namaPembeli, String noHP) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHP = noHP;
        this.prev = null;
        this.next = null;
    }
}