package fun.gbr.gui;

import javax.swing.*;
import java.awt.*;

public class ClydeExample extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel folderLabel = new JLabel("Folder path:");
    private JTextField folderTextField = new JTextField();
    private JLabel xOffsetLabel = new JLabel("X offset:");
    private JTextField xOffsetTextField = new JTextField();
    private JLabel yOffsetLabel = new JLabel("Y offset:");
    private JTextField yOffsetTextField = new JTextField();
    private JLabel widthLabel = new JLabel("Width:");
    private JTextField widthTextField = new JTextField();
    private JLabel heightLabel = new JLabel("Height:");
    private JTextField heightTextField = new JTextField();

    public ClydeExample() {
        super("ClydeExample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 4));
        add(folderLabel);
        add(folderTextField);
        add(xOffsetLabel);
        add(xOffsetTextField);
        add(yOffsetLabel);
        add(yOffsetTextField);
        add(widthLabel);
        add(widthTextField);
        add(heightLabel);
        add(heightTextField);
        pack();
        setVisible(true);
    }
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClydeExample example = new ClydeExample();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
