package fun.gbr.gui;

import java.awt.EventQueue;
import java.nio.file.InvalidPathException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import fun.gbr.gui.config.ConfigManager;

public class ConfigGUI {

	private JFrame frame;
	private JTextField pathField;
	private JTextField xOffsetField;
	private JTextField widthField;
	private JTextField yOffsetField;
	private JTextField heightField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigGUI window = new ConfigGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConfigGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ConfigManager manager = new ConfigManager();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 543, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Screenshot Cropper Config");
		
		JLabel pathLabel = new JLabel("Destination Folder");
		
		pathField = new JTextField();
		pathField.setColumns(10);
		pathField.setText(manager.getPath());
		
		JButton browseButton = new JButton("Browse");
		
		JLabel xOffsetLabel = new JLabel("X Offset");
		
		xOffsetField = new JTextField();
		xOffsetField.setColumns(10);
		xOffsetField.setText(manager.getXOffset());
		
		JLabel widthLabel = new JLabel("Width");
		
		widthField = new JTextField();
		widthField.setColumns(10);
		widthField.setText(manager.getWidth());
		
		JLabel yOffsetLabel = new JLabel("Y Offset");
		
		yOffsetField = new JTextField();
		yOffsetField.setColumns(10);
		yOffsetField.setText(manager.getYOffset());
		
		JLabel heightLabel = new JLabel("Height");
		
		heightField = new JTextField();
		heightField.setColumns(10);
		heightField.setText(manager.getHeight());
		
		JButton saveButton = new JButton("Save"); 
		saveButton.addActionListener(event -> {
			try {
				manager.save(this);
			} catch(InvalidPathException ipe) {
				JOptionPane.showMessageDialog(saveButton, "The destination folder path is not valid!", SAVE_FAILED, JOptionPane.ERROR_MESSAGE);
			} catch(NumberFormatException ne) {
				JOptionPane.showMessageDialog(saveButton, "Input value is not an integer. " + ne.getLocalizedMessage(), SAVE_FAILED, JOptionPane.ERROR_MESSAGE);
			} catch(Exception e) {
				JOptionPane.showMessageDialog(saveButton, e.getMessage(), SAVE_FAILED, JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(event -> frame.dispose());
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(saveButton)
							.addGap(140)
							.addComponent(closeButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pathLabel)
							.addGap(18)
							.addComponent(pathField, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(browseButton)))
					.addGap(126))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(yOffsetLabel)
									.addGap(18)
									.addComponent(yOffsetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(heightLabel))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(xOffsetLabel)
									.addGap(18)
									.addComponent(xOffsetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(widthLabel)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(widthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(heightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(162, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pathLabel)
						.addComponent(pathField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(browseButton))
					.addGap(34)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(xOffsetLabel)
						.addComponent(xOffsetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(widthLabel)
						.addComponent(widthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(yOffsetLabel)
						.addComponent(yOffsetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(heightLabel)
						.addComponent(heightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(closeButton)
						.addComponent(saveButton))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JTextField getPathField() {
		return pathField;
	}

	public JTextField getxOffsetField() {
		return xOffsetField;
	}

	public JTextField getWidthField() {
		return widthField;
	}

	public JTextField getyOffsetField() {
		return yOffsetField;
	}

	public JTextField getHeightField() {
		return heightField;
	}
	
	public static final String SAVE_FAILED = "Save failed";
}
