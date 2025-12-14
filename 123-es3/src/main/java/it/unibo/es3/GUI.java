package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();

    private final transient Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(panel, BorderLayout.CENTER);
        this.getContentPane().add(panel2);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                //final var pos = new Pair<>(j, i);
                final JButton button = new JButton(" "); //!
                this.cells.add(button);
                //button.addActionListener(e -> button.setText(String.valueOf(cells.indexOf(button))));
                panel.add(button);
            }
        }

        showExpansion(logics.randomPos());

        final JButton step = new JButton(">");
        panel2.add(step, BorderLayout.SOUTH);

        step.addActionListener(e -> {
            showExpansion(logics.expand());
            if (logics.toQuit()) {
                dispose();
            }
        });

        pack();
        this.setVisible(true);
    }

    private void showExpansion(final List<Integer> positions) {
        for (final Integer num : positions) {
            this.cells.get(num).setText("*");
        }
    }
}
