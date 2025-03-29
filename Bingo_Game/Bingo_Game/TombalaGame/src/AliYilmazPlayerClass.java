public class AliYilmazPlayerClass {
    private String playerName;
    private AliYilmazMultiLinkedListClass kart;

    public AliYilmazPlayerClass(String playerName, AliYilmazMultiLinkedListClass kart) {
        this.playerName = playerName;
        this.kart = kart;
    }

    public String getPlayerName() {
        return playerName;
    }

    public AliYilmazMultiLinkedListClass getKart() {
        return kart;
    }

    public void setKart(AliYilmazMultiLinkedListClass kart) {
        this.kart = kart;
    }

    public void printCard(AliYilmazMultiLinkedListClass card) {
        AliYilmazNodeClass currentRow = card.head;
        System.out.println("_____________________");
        while (currentRow != null) {
            System.out.print("|---|---|---|---|---|---|---|---|---|");
            AliYilmazNodeClass currentColumn = currentRow;
            while (currentColumn != null) {
                int number = currentColumn.value;
                if (number == -1) {
                    System.out.printf("|%3s", " ");
                } else {
                    System.out.printf("|%3d", number);
                }
                currentColumn = currentColumn.nextColumn; // Bir sonraki sütuna geç
            }
            System.out.println("|");
            currentRow = currentRow.nextRow; // Bir sonraki satıra geç
        }
        System.out.println("_____________________");
    }

}


