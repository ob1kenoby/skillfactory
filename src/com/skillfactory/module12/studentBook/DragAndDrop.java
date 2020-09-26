package com.skillfactory.module12.studentBook;

public class DragAndDrop extends Task implements Autochecked {
    String[][] options;

    public DragAndDrop() {
        super();
        this.options = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
    }
}
