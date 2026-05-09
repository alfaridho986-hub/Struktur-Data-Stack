public class AlfaridhoOktaRamadhani_25161562036_stak {
    // === BAGIAN 1: Deklarasi Stack ===
    static String[] stack = new String[10];
    static int top = -1;
    // === BAGIAN 2: Operasi Stack ===

    // TODO: Lengkapi method push()
    static void push (String tiket) {
        if(top == stack.length -1) {
            System.out.println("Stack penuh!");
        } else {
            top++;
            stack[top] = tiket;
        }
    }

    //TODO: Lengkapi method pop()
    static String pop () {
        if(isEmpty()) {
            return "Stack kosong!";
        } else {
            top--;
            return stack[top + 1];
        }
    }

    //TODO: Lengkapi method peek()
    static String peek () {
        if(isEmpty()) {
            return "Stack kosong!";
        } else {
            return stack[top];
        }
    }
    
    static boolean isEmpty () {
        return top == -1;
    }

    static void tampilStack () {
        System.out.println("=== Isi Stack (TOP -> BOTTOM) ===");
        for (int i = top; i >= 0; i--) {
            System.out.println("|" + stack[i] + "|");
        }
        System.out.println("===============================");
    }

    static void hitungTotal () {
        int total = 0;

        //Menelusuri selurh stack dari top sampai bottom
        for(int i = top; i>=0; i--) {
            String tiket = stack[i];

            //Ekstrak harga dari string tiket
            //Mencari posisi karakter 'R' dari "Rp"
            int posisiRp = tiket.indexOf("Rp");

            //Ambil angka setelah "Rp"
            String hargaString = tiket.substring(posisiRp + 2); //+ 2 untuk melewati "Rp"

            //Hilangkan titik pemisah ribuan (contoh: "50.000" menjadi "50000")
            hargaString = hargaString.replace(".", "");

            //Konversi string menjadi integer
            int harga = Integer.parseInt(hargaString);

            //Jumlahkan ke total
            total = total + harga;
        }
        //Tampilkan total dengan format ribuan menggunakan titik
        String totalFormatted = String.format("%,d", total).replace(",", ".");
        System.out.println("Total harga tiket: Rp" + totalFormatted);
    }

    // === BAGIAN 3: Main Program ===
    public static void main (String[] args) {

        //TODO: push 3 transaksi berikut kedalam stack:
        push ("Tiket A01: Avengers Rp50.000");
        push ("Tiket B02: Interstellar Rp45.000");
        push ("Tiket C03: Inception Rp45.000");

        tampilStack();

        //TODO: tampilkan tiket paling atas (peek)
        System.out.println("Tiket terakhir masuk: " + peek());

        hitungTotal();

        //TODO: batalkan 1 transaksi teratas (pop) dan tamplkan
        System.out.println("Tiket dibatalkan: " + pop());

        tampilStack();
    }
}

