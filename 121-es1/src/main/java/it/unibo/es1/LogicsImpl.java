package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final List<Integer> slots;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        slots = new ArrayList<>(Collections.nCopies(size, 0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return slots.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return Collections.unmodifiableList(slots);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return slots.stream().map(x -> x < size()).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        slots.set(elem, slots.get(elem) + 1);
        return slots.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return slots.stream().map(String::valueOf).collect(Collectors.joining("|", "<<", ">>"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return slots.stream().allMatch(x -> x.equals(slots.getFirst()));
    }
}
