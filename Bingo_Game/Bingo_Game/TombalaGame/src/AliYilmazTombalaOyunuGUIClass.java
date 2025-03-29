import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AliYilmazTombalaOyunuGUIClass extends JFrame {

    JLabel card1Label;
    JLabel card2Label;
    JButton drawNumberButton;
    private JButton resetButton;
    AliYilmazTombalaOyunuClass oyun;

    public AliYilmazTombalaOyunuGUIClass(AliYilmazMultiLinkedListClass insertCard1, AliYilmazMultiLinkedListClass insertCard2) {
        super("Tombala Oyunu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 500);
        setLayout(new BorderLayout());


        oyun = new AliYilmazTombalaOyunuClass();


        card1Label = new JLabel();
        updatePlayerCardLabel(card1Label, insertCard1, "Oyuncu 1");
        add(card1Label, BorderLayout.WEST);

        // İkinci oyuncu kartını oluştur

        card2Label = new JLabel();
        updatePlayerCardLabel(card2Label, insertCard2, "Oyuncu 2");
        add(card2Label, BorderLayout.EAST);

        // Numara çekme düğmesi
        drawNumberButton = new JButton("Numara Çek");
        drawNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cinko1 = false;
                boolean cinko2 = false;
                boolean ikinciCinko1 = false;
                boolean ikinciCinko2 = false;
                boolean tombala1 = false;
                boolean tombala2 = false;

                int[] numbers = AliYilmazTombalaOyunuClass.generatePermutation(90);
                if (numbers.length == 0) {
                    JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyun bitti, tüm numaralar çekildi!");

                    return;
                }

                AliYilmazMultiLinkedListClass multi = new AliYilmazMultiLinkedListClass(); // Tek bir MultiLinkedList nesnesi oluşturuldu

                for (int number : numbers) {
                    JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Çekilen Numara: " + number);

                    boolean foundInCard1 = oyun.markNumber(insertCard1, number);
                    boolean foundInCard2 = oyun.markNumber(insertCard2, number);

                    if (foundInCard1) {
                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyuncu 1 kartın'da sayı bulundu ! Bulunan Sayı :" + number);
                        System.out.println("Oyuncu 1 Kartı");
                        multi.PrintMultiLinkedCard(insertCard1);
                        System.out.println();
                    }
                    if (!cinko1 && AliYilmazTombalaOyunuClass.checkCinko(insertCard1)) {
                        cinko1 = true;
                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyuncu 1 Çinko Yaptı !");
                        System.out.println("Oyuncu 1 Çinko Yaptı ! Kart :");
                        multi.PrintMultiLinkedCard(insertCard1);

                        System.out.println();
                    }
                    if (!ikinciCinko1 && AliYilmazTombalaOyunuClass.checkIkinciCinko(insertCard1)) {
                        ikinciCinko1 = true;
                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyuncu 1 ikinci çinko yaptı!");
                        System.out.println("Oyuncu 1 ikinci Çinko Yaptı! Kart :");
                        multi.PrintMultiLinkedCard(insertCard1);

                        System.out.println();
                    }
                    if (!tombala1 && AliYilmazTombalaOyunuClass.checkTombala(insertCard1)) {
                        tombala1 = true;
                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyuncu 1 Tombala Yaptı! Oyunu Kazandı!");
                        System.out.println("Oyuncu 1 Tombala Yaptı! Kart :");
                        multi.PrintMultiLinkedCard(insertCard1);

                        System.out.println();

                        break;
                    }

                    if (foundInCard2) {
                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyuncu 2 kartın'da sayı bulundu ! Bulunan Sayı :" + number);
                        System.out.println("Oyuncu 2 Kartı");
                        multi.PrintMultiLinkedCard(insertCard2);
                        System.out.println();
                    }
                    if (!cinko2 && AliYilmazTombalaOyunuClass.checkCinko(insertCard2)) {
                        cinko2 = true;
                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyuncu 2 çinko yaptı!");
                        System.out.println("Oyuncu 2 Kartı Çinko Yaptı! Kart :");
                        multi.PrintMultiLinkedCard(insertCard2);

                        System.out.println();
                    }
                    if (!ikinciCinko2 && AliYilmazTombalaOyunuClass.checkIkinciCinko(insertCard2)) {
                        ikinciCinko2 = true;
                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyuncu 2 ikinci çinko yaptı!");
                        System.out.println("Oyuncu 2  ikinci Çinko! Kart :");
                        multi.PrintMultiLinkedCard(insertCard2);

                        System.out.println();
                    }
                    if (!tombala2 && AliYilmazTombalaOyunuClass.checkTombala(insertCard2)) {
                        tombala2 = true;
                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyuncu 2 Tombala Yaptı! Oyunu Kazandı!");
                        System.out.println("Oyuncu 2 Tombala Yaptı! Kart :");

                        multi.PrintMultiLinkedCard(insertCard2);


                        System.out.println();

                        break;
                    }
                    if (tombala1 && tombala2) {

                        JOptionPane.showMessageDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyun Berabere Bitti!");
                        break;
                    }

                    // Kartların güncellenmesi
                    updatePlayerCardLabel(card1Label, insertCard1, "Oyuncu 1");
                    updatePlayerCardLabel(card2Label, insertCard2, "Oyuncu 2");

                }
                updatePlayerCardLabel(card1Label, insertCard1, "Oyuncu 1");
                updatePlayerCardLabel(card2Label, insertCard2, "Oyuncu 2");

                if (oyun.isGameFinished(insertCard1, insertCard2)) {
                    int result = JOptionPane.showConfirmDialog(AliYilmazTombalaOyunuGUIClass.this, "Oyun Bitti Yeni oyun oynamak ister misin! ", "Oyun Bitti", JOptionPane.YES_NO_OPTION);
                    drawNumberButton.setEnabled(false);
                    resetButton.setEnabled(false);

                    if (result == JOptionPane.YES_OPTION) {

                        resetGame();

                    } else {
                        System.exit(0);
                    }

                }


            }


        });


        // Yeniden başlatma düğmesi
        resetButton = new JButton("Yeniden Başla");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(drawNumberButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void resetGame() {
        // Kartları sıfırla
        int[][] card1 = AliYilmazTombalaOyunuClass.GenerateCardMatrix();
        AliYilmazMultiLinkedListClass insertCard1 = AliYilmazTombalaOyunuClass.createCardMultiLinkedList(card1);
        updatePlayerCardLabel(card1Label, insertCard1, "Oyuncu 1");

        int[][] card2 = AliYilmazTombalaOyunuClass.GenerateCardMatrix();
        AliYilmazMultiLinkedListClass insertCard2 = AliYilmazTombalaOyunuClass.createCardMultiLinkedList(card2);
        updatePlayerCardLabel(card2Label, insertCard2, "Oyuncu 2");

        // Yeni bir oyun örneği oluştur
        AliYilmazTombalaOyunuGUIClass newGame = new AliYilmazTombalaOyunuGUIClass(insertCard1, insertCard2);

        // Önceki oyun penceresini kapat
        this.dispose();

        // Yeni oyun penceresini göster
        newGame.setVisible(true);

        // Düğmeleri etkinleştir
        drawNumberButton.setEnabled(true);
        resetButton.setEnabled(true);

        // Mesajları temizle
        JOptionPane.showMessageDialog(this, "Yeni oyun başlatıldı!");
    }



    void updatePlayerCardLabel(JLabel label, AliYilmazMultiLinkedListClass card, String playerName) {
        int[][] matrix = card.getMatrix();
        StringBuilder sb = new StringBuilder("<html><center><h2>" + playerName + "</h2><br><table>");

        for (int i = 0; i < matrix.length; i++) {
            sb.append("<tr>");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append("<td width='50' height='50' style='border: 1px solid black; text-align: center;'>");
                if (matrix[i][j] == -1) {
                    sb.append(""); // Boş bırak
                } else if (matrix[i][j] == 0) {
                    sb.append("<b>0</b>");
                } else {
                    sb.append(matrix[i][j]);
                }
                sb.append("</td>");
            }
            sb.append("</tr>");
        }

        sb.append("</table></center></html>");
        label.setText(sb.toString());
    }



}
