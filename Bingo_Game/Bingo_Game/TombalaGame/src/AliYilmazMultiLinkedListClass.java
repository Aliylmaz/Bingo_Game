public class AliYilmazMultiLinkedListClass {
    AliYilmazNodeClass head; // Başlangıç düğümü

    // Yeni bir düğüm ekle
    public void addNode(int value, int row, int col) {//1.ve2. satırın ilk degerleri boş gözüküyor
        AliYilmazNodeClass newNode = new AliYilmazNodeClass(value); // Yeni düğüm oluştur

        if (head == null) {
            head = newNode; // Eğer liste boşsa, yeni düğümü başa ekle
        } else {
            AliYilmazNodeClass currentRow = head;
            for (int i = 0; i < row; i++) {
                if (currentRow.nextRow == null) {
                    // Belirtilen satırın sonuna ulaşıldı, yeni düğümü eklemek için önceki satıra geç
                    // Belirtilen satır matrisin ortasında veya sonundayken
                    currentRow.nextRow = newNode;
                    return;
                }
                currentRow = currentRow.nextRow; // Bir sonraki satıra geç
            }

            //Node prevCol = null;
            AliYilmazNodeClass prevCol = null;
            AliYilmazNodeClass currentCol = currentRow;

            for (int i = 0; i < col; i++) {
                if (currentCol == null) {
                    // Belirtilen sütunun sonuna ulaşıldı, yeni düğümü eklemek için önceki sütuna geç
                    // Belirtilen sütun matrisin ortasında veya sonundayken
                    prevCol.nextColumn = newNode;


                    return;
                }

                prevCol = currentCol;
                currentCol = currentCol.nextColumn; // Bir sonraki sütuna geç

            }
            currentCol = newNode;

            // Belirtilen sütuna yeni düğümü ekle
            if (prevCol != null) {
                prevCol.nextColumn = newNode;


            } else {
                currentRow.nextColumn = newNode; // Eğer belirtilen sütun matrisin başıysa
            }


        }
    }


    // Kartı yazdır
    public void printCard() {
        System.out.println("_____________________");
        System.out.println("|---|---|---|---|---|---|---|---|---|");
        AliYilmazNodeClass currentRow = head;
        while (currentRow != null) {
            System.out.print("|");
            AliYilmazNodeClass currentColumn = currentRow;
            while (currentColumn != null) {
                int number = currentColumn.value;
                if (number == -1) {
                    System.out.print("   |"); // -1 değeri boş bir kutuyu temsil eder
                } else {
                    if (number < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + number + "|");
                }
                currentColumn = currentColumn.nextRow; // Bir sonraki sütuna geç
            }
            System.out.println("\n|---|---|---|---|---|---|---|---|---|");
            currentRow = currentRow.nextColumn; // Bir sonraki satıra geç
        }
        System.out.println("_____________________");
    }


    public void PrintMultiLinkedCard(AliYilmazMultiLinkedListClass card) {


        System.out.println("_____________________");
        AliYilmazNodeClass currentRow = card.head;
        while (currentRow != null) {
            System.out.println("|---|---|---|---|---|---|---|---|---|");
            AliYilmazNodeClass currentColumn = currentRow;
            for (int i = 0; i < 9; i++) {
                int number = currentColumn != null ? currentColumn.value : -1;
                if (number == -1) {
                    System.out.printf("|%3s", " ");
                } else {
                    System.out.printf("|%3d", number);
                }
                if (currentColumn != null) {
                    currentColumn = currentColumn.nextColumn;
                }
            }
            System.out.println("|");
            currentRow = currentRow.nextRow;
        }
        System.out.println("|---|---|---|---|---|---|---|---|---|");
        System.out.println("_____________________\n\n");
    }

    public int[][] getMatrix() {
        if (head == null) {
            return new int[0][0]; // Boş bir matris döndür
        }

        int[][] matrix = new int[3][9];
        AliYilmazNodeClass currentRow = head;
        for (int i = 0; i < 3 && currentRow != null; i++) { // currentRow null olmadığı sürece devam et
            AliYilmazNodeClass currentColumn = currentRow;
            for (int j = 0; j < 9 && currentColumn != null; j++) { // currentColumn null olmadığı sürece devam et
                matrix[i][j] = currentColumn.value;
                currentColumn = currentColumn.nextColumn;
            }
            currentRow = currentRow.nextRow;
        }
        return matrix;
    }


    public boolean containsNumber(int card1Matrix) {

        AliYilmazNodeClass currentRow = head;
        while (currentRow != null) {
            AliYilmazNodeClass currentColumn = currentRow;
            while (currentColumn != null) {
                if (currentColumn.value == card1Matrix) {
                    return true;
                }
                currentColumn = currentColumn.nextRow; // Bir sonraki sütuna geç
            }
            currentRow = currentRow.nextColumn; // Bir sonraki satıra geç
        }
        return false;
    }
}
