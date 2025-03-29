


import java.util.Random;

public class AliYilmazTombalaOyunuClass {

    private AliYilmazMultiLinkedListClass card1;


    public void setCard1(AliYilmazMultiLinkedListClass card1) {
        this.card1 = card1;
    }

    public void setCard2(AliYilmazMultiLinkedListClass card2) {
        this.card2 = card2;
    }

    private AliYilmazMultiLinkedListClass card2;


    public AliYilmazTombalaOyunuClass() {
        card1 = new AliYilmazMultiLinkedListClass();
        card2 = new AliYilmazMultiLinkedListClass();

    }




    public static int[][] GenerateCardMatrix() {
        int k = 0;
        int[][] card = new int[3][9];
        Random ran = new Random();
        for (int i = 0; i < 3; i++) {
            int[] newMatrix = generatePermutation(9);
            for (int j = 0; j < 4; j++) {
                int z = newMatrix[j];
                if (z == 9) {
                    z = 0;
                }
                card[i][z] = -1;//ilk 4 hücre boş
            }

        }
        int gap = 0;

        do {
            for (int i = 0; i < 9; i++) {
                int[] newMatrix = generatePermutation(9);
                for (k = 0; k < 3; k++) {
                    if (card[k][i] == 0) {
                        card[k][i] = newMatrix[k] + i * 9 + gap;
                    }
                }
                gap++;

            }

        } while (k != 3);

        return card;
    }

    public static AliYilmazMultiLinkedListClass createCardMultiLinkedList(int[][] cardMatrix) {
        AliYilmazMultiLinkedListClass multiLinkedList = new AliYilmazMultiLinkedListClass();

        for (int i = 0; i < cardMatrix.length; i++) {
            for (int j = 0; j < cardMatrix[i].length; j++) {
                multiLinkedList.addNode(cardMatrix[i][j], i, j);
            }
        }

        return multiLinkedList;
    }





    static int[] generatePermutation(int size) {
        Random random = new Random();
        int[] permutation = new int[size];
        for (int i = 0; i < size; i++) {
            permutation[i] = i + 1; // 1'den 90'a kadar sayıları diziye ekle
        }
        for (int i = size - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = permutation[index];
            permutation[index] = permutation[i];
            permutation[i] = temp;
        }
        return permutation;
    }

    boolean markNumber(AliYilmazMultiLinkedListClass card, int number) {
        AliYilmazNodeClass currentRow = card.head;
        while (currentRow != null) {
            AliYilmazNodeClass currentCol = currentRow;
            while (currentCol != null) {
                if (currentCol.value == number) {
                    currentCol.value = 0; // Bulunan numarayı 0 olarak işaretle
                    return true; // Numara bulunduğu için true döndür
                }
                currentCol = currentCol.nextColumn; // Bir sonraki sütuna geç
            }
            currentRow = currentRow.nextRow; // Bir sonraki satıra geç
        }
        return false; // Numara bulunamadı, false döndür
    }


    static boolean checkTombala(AliYilmazMultiLinkedListClass card) {
        int count = 0;
        AliYilmazNodeClass currentRow = card.head;
        while (currentRow != null) {
            AliYilmazNodeClass currentColumn = currentRow;

            while (currentColumn != null) {
                if (currentColumn.value == 0) {
                    count++;
                }
                currentColumn = currentColumn.nextColumn;
            }
            if (count == 15) {
                return true;
            }
            currentRow = currentRow.nextRow;
        }
        return false;
    }

    static boolean checkCinko(AliYilmazMultiLinkedListClass card) {
        int count = 0;
        AliYilmazNodeClass currentRow = card.head;
        while (currentRow != null) {
            AliYilmazNodeClass currentColumn = currentRow;
            while (currentColumn != null) {
                if (currentColumn.value == 0) {
                    count++;
                }
                currentColumn = currentColumn.nextColumn;
            }
            if (count == 5) {
                return true;
            }
            currentRow = currentRow.nextRow;
        }
        return false;
    }


    // İkinci çinko kontrolü 10. sayı çekildiğinde yapılacak
    static boolean checkIkinciCinko(AliYilmazMultiLinkedListClass card) {
        int count = 0;
        AliYilmazNodeClass currentRow = card.head;
        while (currentRow != null) {
            AliYilmazNodeClass currentColumn = currentRow;
            while (currentColumn != null) {
                if (currentColumn.value == 0) {
                    count++;
                }
                currentColumn = currentColumn.nextColumn;
            }
            if (count == 10) {
                return true;
            }
            currentRow = currentRow.nextRow;
        }
        return false;

    }

    boolean isGameFinished(AliYilmazMultiLinkedListClass card1, AliYilmazMultiLinkedListClass card2) {
        return checkTombala(card1) || checkTombala(card2);


    }


}








