public class DLLAntrian04 {
    Pembeli04 head, tail;
    int currentQueueNumber = 1;

    public void enqueue(String nama, String hp) {
        Pembeli04 newNode = new Pembeli04(currentQueueNumber++, nama, hp);
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
        if (head == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=========================================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("=========================================");
        System.out.printf("%-15s %-15s %-15s\n", "No Antrian", "Nama", "No HP");
        Pembeli04 current = head;
        while (current != null) {
            System.out.printf("%-15d %-15s %-15s\n", current.noAntrian, current.namaPembeli, current.noHP);
            current = current.next;
        }
    }

    public Pembeli04 removeByNoAntrian(int targetNo) {
        if (head == null) {
            return null;
        }

        Pembeli04 current = head;

        while (current != null && current.noAntrian != targetNo) {
            current = current.next;
        }

        if (current == null) {
            return null;
        }

        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        }

        else if (current == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }

        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        current.next = null;
        current.prev = null;

        return current; 
    }
}