public class DLLAntrian04 {
    Pembeli04 head, tail;
    int CurrentAntrian = 1;

    public void enQueue(String nama, String noHP) {
        Pembeli04 newNode = new Pembeli04(CurrentAntrian++, nama, noHP);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + newNode.noAntrian);
    }

    public void printQueue() {
        if (head==null){
            System.out.println("Antrian Kosong");
            return;
        }
        System.out.println("===============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("===============================");
        System.out.printf("%-15s %-15s %-15s\n", "No Antrian", "Nama", "No HP");
        Pembeli04 current = head;
        while (current != null) {
            System.out.printf("%-15d %-15s %-15s\n", current.noAntrian, current.namaPembeli, current.noHP);
            current = current.next;
        }
    }

    public Pembeli04 deQueue() {
        if (head == null) {
            return null;
        }
        Pembeli04 removedNode = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return removedNode;
    }
}
