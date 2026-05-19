
public class DLLPesanan04 {

    Pesanan04 head, tail;

    public void addPesanan(int kode, String nama, int harga) {
        Pesanan04 newNode = new Pesanan04(kode, nama, harga);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void sortPesananByNama() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Pesanan04 current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.namaPesanan.compareToIgnoreCase(current.next.namaPesanan) > 0) {
                    int tempKode = current.kodePesanan;
                    String tempNama = current.namaPesanan;
                    int tempHarga = current.harga;

                    current.kodePesanan = current.next.kodePesanan;
                    current.namaPesanan = current.next.namaPesanan;
                    current.harga = current.next.harga;

                    current.next.kodePesanan = tempKode;
                    current.next.namaPesanan = tempNama;
                    current.next.harga = tempHarga;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void printPesanan() {
        if (head == null) {
            System.out.println("Belum ada data pesanan.");
            return;
        } 
        int totalHarga = 0;
        Pesanan04 current = head;
        while (current != null) {
            totalHarga += current.harga;
            current = current.next;
        }
        
        sortPesananByNama();

        System.out.println("=========================================");
        System.out.println("LAPORAN PESANAN");
        System.out.println("=========================================");
        System.out.printf("%-15s %-20s %-15s\n", "Kode Pesanan", "Nama Pesanan", "Harga");
        current = head;
        while (current != null) {
            System.out.printf("%-15d %-20s %-15d\n", current.kodePesanan, current.namaPesanan, current.harga);
            current = current.next;
        }
        System.out.println("=========================================");
        System.out.println("Total Harga: " + totalHarga);
    }

}


