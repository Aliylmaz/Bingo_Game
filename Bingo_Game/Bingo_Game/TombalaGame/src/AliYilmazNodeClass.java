class AliYilmazNodeClass {
    int value;
    AliYilmazNodeClass nextColumn; // Pointer to the next node in the row
    AliYilmazNodeClass nextRow; // Pointer to the next node in the column


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AliYilmazNodeClass getNextColumn() {
        return nextColumn;
    }

    public void setNextColumn(AliYilmazNodeClass nextColumn) {
        this.nextColumn = nextColumn;
    }

    public AliYilmazNodeClass getNextRow() {
        return nextRow;
    }

    public void setNextRow(AliYilmazNodeClass nextRow) {
        this.nextRow = nextRow;
    }

    public AliYilmazNodeClass(int data) {
        this.value = data;
        this.nextColumn = null;
        this.nextRow = null;
    }

}

