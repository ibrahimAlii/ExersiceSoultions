package IntroductionToJavaProgramming.chapter27_binary_search_tree;

import javax.swing.*;
import java.awt.*;

public class TreeControl extends JPanel {
    private BinarySearchTree<Integer> tree;
    private JTextField jtfKey = new JTextField(5);
    private TreeView treeView = new TreeView();
    private JButton jbtInsert = new JButton("Insert");
    private JButton jbtDelete = new JButton("Delete");

    public TreeControl(BinarySearchTree<Integer> tree) {
        this.tree = tree;
        setUI();
    }

    /**
     * Initialize UI for binary tree
     */
    private void setUI() {
        this.setLayout(new BorderLayout());
        add(treeView, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter a key: "));
        panel.add(jtfKey);
        panel.add(jbtInsert);
        panel.add(jbtDelete);
        add(panel, BorderLayout.SOUTH);

        jbtInsert.addActionListener(e -> {
            int key = Integer.parseInt(jtfKey.getText());
            if (tree.search(key)) { // If key in tree already
                JOptionPane.showMessageDialog(null, key + " is already in the tree");
            } else {
                tree.insert(key);
                treeView.repaint();
            }
        });

        jbtDelete.addActionListener(e -> {
            int key = Integer.parseInt(jtfKey.getText());
            if (!tree.delete(key)) { // If element not in the tree
                JOptionPane.showMessageDialog(null, key + " is not in the tree");
            } else {
                tree.delete(key);
                treeView.repaint();
            }
        });
    }


    // Inner class TreeView for displaying a tree on a panel
    class TreeView extends JPanel {
        private int radius = 20; // Tree node radius
        private int vGap = 50; // Gap between to levels in a tree

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (tree.getRoot() != null) {
                // Display tree recursively
                displayTree(g, tree.getRoot(), getWidth() / 2, 30, getWidth() / 4);
            }
        }

        private void displayTree(Graphics g, TreeNode<Integer> root, int x, int y, int hGap) {
            //Display the root
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.drawString(root.element + "", x - 6, y + 4);

            if (root.left != null) {
                // Draw line to left node
                connectTwoCircles(g, x - hGap, y + vGap, x, y);

                // Draw the left subtree
                displayTree(g, root.left, x - hGap, y + vGap, hGap / 2);
            }

            if (root.right != null) {
                // Draw line to right node
                connectTwoCircles(g, x + hGap, y + vGap, x, y);

                // Draw the right subtree
                displayTree(g, root.right, x + hGap, y + vGap, hGap / 2);
            }
        }

        private void connectTwoCircles(Graphics g, int x1, int y1, int x2, int y2) {
            double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
            int x11 = (int) (x1 - radius * (x1 - x2) / d);
            int y11 = (int) (y1 - radius * (y1 - y2) / d);
            int x21 = (int) (x2 + radius * (x1 - x2) / d);
            int y21 = (int) (y2 + radius * (x1 - x2) / d);

            g.drawLine(x11, y11, x21, y21);
        }
    }
}
