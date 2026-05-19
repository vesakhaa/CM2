import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLLAntrian04 antrian = new DLLAntrian04();
        DLLPesanan04 pesanan = new DLLPesanan04();

        // Data dummy untuk mempermudah pengujian awal
        antrian.enqueue("Ainra", "08224500000");
        antrian.enqueue("Danra", "08224511111");
        antrian.enqueue("Sanri", "08224522222");
        antrian.enqueue("Vania", "08422234556");
        System.out.println("\n[Sistem]: Data awal antrean telah di-generate secara otomatis.\n");

        int menu;
        do {
            System.out.println("=========================================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("=========================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan (Pilih Nomor)");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            menu = sc.nextInt();
            sc.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String hp = sc.nextLine();
                    antrian.enqueue(nama, hp);
                    break;
                case 2:
                    antrian.printQueue();
                    break;
                case 3:
                    if (antrian.head == null) {
                        System.out.println("Antrian saat ini kosong!");
                        break;
                    }
                
                    antrian.printQueue();
                    
                    System.out.print("\nMasukkan Nomor Antrian yang ingin dihapus/dilayani: ");
                    int noPilihan = sc.nextInt();
                    sc.nextLine(); 
                    
                    Pembeli04 pembeliDipanggil = antrian.removeByNoAntrian(noPilihan);
                    
                    if (pembeliDipanggil != null) {
                        System.out.println("\n--- Input Pesanan untuk " + pembeliDipanggil.namaPembeli + " ---");
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine();
                        
                        pesanan.addPesanan(kode, namaPesanan, harga);
                        System.out.println("\n[Sukses]: " + pembeliDipanggil.namaPembeli + " (No Antrian " + noPilihan + ") telah dihapus dari antrean dan memesan " + namaPesanan);
                    } else {
                        System.out.println("Nomor antrean " + noPilihan + " tidak ditemukan!");
                    }
                    break;
                case 4:
                    pesanan.printPesanan();
                    break;
                case 0:
                    System.out.println("Keluar dari sistem...");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
            System.out.println();
        } while (menu != 0);
        
        sc.close();
    }
}