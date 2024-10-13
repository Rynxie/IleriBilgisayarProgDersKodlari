public class MergeSort {

    // merge sort ana fonksiyonu
    public static void mergeSort(int[] array, int left, int right) {
        // eğer sol indeks sağdan küçükse (bölünebiliyorsa)
        if (left < right) {
            // orta noktayı bul
            int middle = (left + right) / 2;

            // sol yarıyı böl ve sırala
            mergeSort(array, left, middle);
            
            // sağ yarıyı böl ve sırala
            mergeSort(array, middle + 1, right);

            // bölünmüş dizileri birleştir
            merge(array, left, middle, right);
        }
    }

    // iki alt diziyi birleştiren yardımcı fonksiyon
    public static void merge(int[] array, int left, int middle, int right) {
        // sol ve sağ dizilerin boyutlarını hesapla
        int size1 = middle - left + 1;
        int size2 = right - middle;

        // geçici diziler oluştur
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // verileri geçici dizilere kopyala
        for (int i = 0; i < size1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < size2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // alt dizileri birleştir
        int i = 0, j = 0;
        int k = left;

        // her iki dizideki elemanları karşılaştır ve sıralı şekilde ana diziye koy
        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // sol dizide kalan elemanları ana diziye kopyala
        while (i < size1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // sağ dizide kalan elemanları ana diziye kopyala
        while (j < size2) {
            array[k] = rightArray[j];
            j++;
            k++;
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
        int[] array = {12, 11, 13, 5, 6, 7};
        
        // sıralanmadan önceki diziyi yazdır
        System.out.println("sıralanmadan önceki dizi:");
        printArray(array);

        // merge sort işlemini başlat
        mergeSort(array, 0, array.length - 1);

        // sıralanmış diziyi yazdır
        System.out.println("merge sort ile sıralanmış dizi:");
        printArray(array);
    }
}
