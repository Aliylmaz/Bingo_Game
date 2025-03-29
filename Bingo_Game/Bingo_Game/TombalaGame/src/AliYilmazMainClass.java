public class AliYilmazMainClass {
    public static void main(String[] args) {
        /*// test kartı

        int[][] card1 = {{5, -1, 22, -1, 45, -1, 60, 73, -1},
                        {-1, 10, -1, 31, 47, 58, 68, -1, -1},
                        {-1, 17, 26, 38, -1, -1, -1, 79, 86}};


        int[][] card2 = {{4, -1, 22, -1, 48, -1, 61, 74, -1},
                        {-1, 11, -1, 32, 49, 59, 67, -1, -1},
                        {-1, 18, 27, 39, -1, -1, -1, 80, 85}};

               //random sayı  methodu zaten fonksiyonların içinde var orada cağırıyoruz ama ne olur ne olmaz yazdım
                 int[] randomPermutation = AliYilmazTombalaOyunuClass.generatePermutation(90);





              // Kartları oluştur
        AliYilmazMultiLinkedListClass insertCard1 = AliYilmazTombalaOyunuClass.createCardMultiLinkedList(card1);
        AliYilmazMultiLinkedListClass insertCard2 = AliYilmazTombalaOyunuClass.createCardMultiLinkedList(card2);

        // Oyunu oluştur
        AliYilmazTombalaOyunuGUIClass gameGUI = new AliYilmazTombalaOyunuGUIClass(insertCard1, insertCard2);

        // Oyuncuları oluştur
        AliYilmazPlayerClass player1 = new AliYilmazPlayerClass("Oyuncu 1", insertCard1);
        AliYilmazPlayerClass player2 = new AliYilmazPlayerClass("Oyuncu 2", insertCard2);

        // Oyuncuların kartlarını güncelle
        gameGUI.updatePlayerCardLabel(gameGUI.card1Label, insertCard1, player1.getPlayerName());
        gameGUI.updatePlayerCardLabel(gameGUI.card2Label, insertCard2, player2.getPlayerName());

        // Numara çekme düğmesini etkinleştir
        gameGUI.drawNumberButton.setEnabled(true);

        // Oyunu başlat
        gameGUI.setVisible(true);

         */


        // İlk oyuncu kartını oluştur
        int[][] card1 = AliYilmazTombalaOyunuClass.GenerateCardMatrix();
        AliYilmazMultiLinkedListClass insertCard1 = AliYilmazTombalaOyunuClass.createCardMultiLinkedList(card1);

        // İkinci oyuncu kartını oluştur
        int[][] card2 = AliYilmazTombalaOyunuClass.GenerateCardMatrix();
        AliYilmazMultiLinkedListClass insertCard2 = AliYilmazTombalaOyunuClass.createCardMultiLinkedList(card2);


        AliYilmazTombalaOyunuGUIClass gameGUI = new AliYilmazTombalaOyunuGUIClass(insertCard1, insertCard2);
        AliYilmazPlayerClass player1 = new AliYilmazPlayerClass("Oyuncu 1", insertCard1);
        AliYilmazPlayerClass player2 = new AliYilmazPlayerClass("Oyuncu 2", insertCard2);


        gameGUI.updatePlayerCardLabel(gameGUI.card1Label, insertCard1, player1.getPlayerName());


        gameGUI.updatePlayerCardLabel(gameGUI.card2Label, insertCard2, player2.getPlayerName());

        // Numara çekme düğmesini etkinleştir
        gameGUI.drawNumberButton.setEnabled(true);






        // Oyunu göster
        gameGUI.setVisible(true);




    }

}