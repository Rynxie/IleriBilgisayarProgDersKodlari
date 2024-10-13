public class QuickSort {

    // quick sort ana fonksiyonu
    public static void quickSort(int[] array, int low, int high) {
        // eğer alt sınır üst sınırdan küçükse
        if (low < high) {
            // pivot indeksini al
            int pivotIndex = partition(array, low, high);

            // pivotun solundaki alt diziyi sırala
            quickSort(array, low, pivotIndex - 1);

            // pivotun sağındaki alt diziyi sırala
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // pivotu belirleyen ve diziyi bölen yardımcı fonksiyon
    public static int partition(int[] array, int low, int high) {
        // pivotu dizinin son elemanı olarak seç
        int pivot = array[high];

        // pivotun doğru yerini bulmak için diziyi ikiye ayır
        int i = low - 1; // küçük elemanların dizinini tutmak için

        for (int j = low; j < high; j++) {
            // eğer mevcut eleman pivotdan küçük veya eşitse
            if (array[j] <= pivot) {
                i++;

                // i ve j indekslerindeki elemanları takas et
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // pivotu doğru yerine yerleştir (i+1 ile takas et)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // pivotun yeni indeksini döndür
        return i + 1;
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
        int[] array = {10, 7, 8, 9, 1, 5};

        // sıralanmadan önceki diziyi yazdır
        System.out.println("sıralanmadan önceki dizi:");
        printArray(array);

        // quick sort işlemini başlat
        quickSort(array, 0, array.length - 1);

        // sıralanmış diziyi yazdır
        System.out.println("quick sort ile sıralanmış dizi:");
        printArray(array);
    }
}
