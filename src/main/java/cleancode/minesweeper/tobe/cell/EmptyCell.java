package cleancode.minesweeper.tobe.cell;

public class EmptyCell extends Cell {
    private static final String EMPTY_SIGN = "■";
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
        if(isOpened){ // 부모의 필드를 직접 참조 -> 결합도가 매우 높은 상황
            return EMPTY_SIGN;
        }
        if(isFlagged){
            return FLAG_SIGN;
        }
        return UNCHECKED_SIGN;
    }
}
