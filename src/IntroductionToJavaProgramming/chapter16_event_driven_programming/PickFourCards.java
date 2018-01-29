package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PickFourCards extends JFrame{

    private Image imageIcon;
    private final JPanel cards;
    private final File file;

    public PickFourCards(){
        file = new File("C:\\Users\\Ibrahim\\Downloads\\evennumberedexercise\\image//card");
        JButton refresh = new JButton("Refresh");
        cards = new JPanel(new GridLayout(1, 4));

        addNewCards();

        add(refresh, BorderLayout.SOUTH);
        add(cards);

        // Add Listener to button
        refresh.addActionListener(new RefreshListener());
    }

    private void addNewCards() {
        for (int i = 0; i < 4; i++) {
            imageIcon = new ImageIcon(String.valueOf(file.getPath()) + "\\" + ((int)(Math.random() * 50)) + ".png").getImage();
            cards.add(new ImageViewer(imageIcon));
        }
    }


    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

    }

    class RefreshListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            addNewCards();
            requestFocusInWindow();
            add(cards);
            repaint();
        }
    }
}
