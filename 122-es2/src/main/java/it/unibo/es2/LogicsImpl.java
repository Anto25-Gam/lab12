package it.unibo.es2;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final boolean[][] board;

    /**
     * Constructor.
     * 
     * @param size size of grid
     */
    public LogicsImpl(final int size) {
        this.board = new boolean[size][size];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLabel(final Pair<Integer, Integer> position) {
        this.board[position.x()][position.y()] = !this.board[position.x()][position.y()];
        return this.board[position.x()][position.y()] ? "*" : " ";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit(final Pair<Integer, Integer> position) {
        boolean x = true;
        boolean y = true;
        for (int i = 0; i < board.length; i++) {
            if (!board[position.x()][i]) {
                y = false;
            }
            if (!board[i][position.y()]) {
                x = false;
            }
        }
        return y || x;
    }
}
