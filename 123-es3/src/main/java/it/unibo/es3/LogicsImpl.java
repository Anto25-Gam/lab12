package it.unibo.es3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private List<Integer> toExpand = new ArrayList<>();
    private final boolean[] explored;
    private final int width;
    private int numExploredCells;

    /**
     * Constructor.
     * 
     * @param size width of the grid
     */
    public LogicsImpl(final int size) {
        width = size;
        this.numExploredCells = 0;
        explored = new boolean[size * size];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> randomPos() {
        final List<Integer> numeri = new ArrayList<>();
        while (numeri.size() < 3) {
            final int n = (int) (Math.random() * width * width);
            if (!isVisited(n)) {
                numeri.add(n);
                visit(n);
                addToExpand(n);
            } 
        }
        return Collections.unmodifiableList(numeri);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> expand() {
        for (final Integer pos : getExpand()) {
            doExpansion(pos);
        }
        return Collections.unmodifiableList(toExpand);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return this.numExploredCells == explored.length;
    }

    private void doExpansion(final Integer pos) {
        final Pair<Integer, Integer> cPos = new Pair<>(pos / width, pos % width);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                final Pair<Integer, Integer> nPos = new Pair<>(cPos.x() + i, cPos.y() + j);
                if (nPos.x() >= 0 && nPos.x() < width && nPos.y() >= 0 && nPos.y() < width) {
                    final int posToCheck = (nPos.x() * width) + nPos.y();
                    if (validPosition(posToCheck) && !isVisited(posToCheck)) {
                        visit(posToCheck);
                        addToExpand(posToCheck);
                    }
                }
            }
        }
    }

    private List<Integer> getExpand() {
        final List<Integer> expand = toExpand;
        toExpand = new ArrayList<>(); 
        return expand;
    }

    private void addToExpand(final Integer pos) {
        toExpand.add(pos);
    }

    private void visit(final Integer pos) {
        if (pos >= 0 && pos < explored.length) {
            this.numExploredCells++;
            explored[pos] = true;
        }
    }

    private boolean isVisited(final Integer pos) {
        return explored[pos];
    }

    private boolean validPosition(final Integer pos) {
        return pos >= 0 && pos < explored.length;
    }

}
