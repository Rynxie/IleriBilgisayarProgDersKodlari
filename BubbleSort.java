public class BubbleSort {

    // bubble sort ana fonksiyonu
    public static void bubbleSort(int[] array) {
        // dizinin uzunluğunu al
        int n = array.length;

        // dizinin her bir elemanı için döngü başlat
        for (int i = 0; i < n - 1; i++) {
            // her geçişte son eleman yerinde olacağı için n-i-1 kere karşılaştırma yap
            for (int j = 0; j < n - i - 1; j++) {
                // eğer mevcut eleman bir sonraki elemandan büyükse, yer değiştir
                if (array[j] > array[j + 1]) {
                    // takas işlemi
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // diziyi yazdırma fonksiyonu
    public static void printArray(int[] array) {
        // dizideki her elemanı yazdır
        for (int i : array) {
            System.out.print(i + " ");
        }
        // satırı tamamla
        System.out.println();
    }

    // ana fonksiyon
    public static void main(String[] args) {
        // sıralanacak örnek dizi
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        // sıralanmadan önceki diziyi yazdır
        System.out.println("sıralanmadan önceki dizi:");
        printArray(array);

        // bubble sort işlemini başlat
        bubbleSort(array);

        // sıralanmış diziyi yazdır
        System.out.println("bubble sort ile sıralanmış dizi:");
        printArray(array);
    }
}
