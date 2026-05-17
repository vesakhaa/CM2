import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLLAntrian04 antrian = new DLLAntrian04();
        DLLPesanan04 pesanan = new DLLPesanan04();
        
        int menu;
        do {
            System.out.println("=========================================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("=========================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
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
                    antrian.enQueue(nama, hp);
                    break;
                case 2:
                    antrian.printQueue();
                    break;
                case 3:
                    Pembeli04 pembeliDipanggil = antrian.deQueue();
                    if (pembeliDipanggil != null) {
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine();
                        
                        pesanan.addPesanan(kode, namaPesanan, harga);
                        System.out.println(pembeliDipanggil.namaPembeli + " telah memesan " + namaPesanan);
                    } else {
                        System.out.println("Antrian saat ini kosong!");
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