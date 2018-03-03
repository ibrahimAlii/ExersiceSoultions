import javax.swing.*;
import java.awt.*;

public class DescriptionPanel extends JFrame {

    /**
     * Label for displaying an image icon and a title
     */
    private JLabel jLabelImageTitle = new JLabel();

    /**
     * Text area for displaying text
     */
    private JTextArea jtaDescription = new JTextArea();

    public DescriptionPanel() {
        // Center the icon and text and place the text under the icon
        jLabelImageTitle.setHorizontalAlignment(JLabel.CENTER);
        jLabelImageTitle.setHorizontalTextPosition(JLabel.CENTER);
        jLabelImageTitle.setVerticalTextPosition(JLabel.BOTTOM);

        // Set the font in the label and the text field
        jLabelImageTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
        jtaDescription.setFont(new Font("Serif", Font.PLAIN, 14));

        // Set lineWrap and wrapStyleWord true for the text area
        jtaDescription.setLineWrap(true);
        jtaDescription.setWrapStyleWord(true);
        jtaDescription.setEditable(false);

        // Create a scroll pane to hold the text area
        JScrollPane scrollPane = new JScrollPane(jtaDescription);

        // Set BorderLayout for the panel, add label and scroll pane
        setLayout(new BorderLayout(5, 5));
        add(scrollPane, BorderLayout.CENTER);
        add(jLabelImageTitle, BorderLayout.WEST);
    }

    public void setTitle(String title) {
        jLabelImageTitle.setText(title);
    }

    public void setImageIcon(ImageIcon icon) {
        jLabelImageTitle.setIcon(icon);
    }

    public void setDescription(String text) {
        jtaDescription.setText(text);
    }

}
