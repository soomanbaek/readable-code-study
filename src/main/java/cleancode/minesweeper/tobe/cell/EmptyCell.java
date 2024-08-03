package cleancode.minesweeper.tobe.cell;

public class EmptyCell implements Cell {
    private static final String EMPTY_SIGN = "■";

    private final CellState cellState = CellState.initialize();

    @Override
    public boolean isLandMine() {
        return false;
    }

    @Override
    public boolean hasLandMineCount() {
        return false;
    }

    @Override
    public String getSign() {
        if(cellState.isOpened()){ // 부모의 필드를 직접 참조 -> 결합도가 매우 높은 상황
            return EMPTY_SIGN;
        }
        if(cellState.isFlagged()){
            return FLAG_SIGN;
        }
        return UNCHECKED_SIGN;
    }
    @Override
    public void flag() {
        cellState.flag();
    }

    @Override
    public void open() {
        cellState.open();
    }

    @Override
    public boolean isChecked() {
        return cellState.isChecked();
    }

    @Override
    public boolean isOpened() {
        return cellState.isOpened();
    }
}
