package pikomino.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pikomino.model.GameBoard;
import pikomino.model.Model;
import pikomino.utils.Images;
import pikomino.utils.JTextFieldLimit;
import pikomino.view.screen.Screen;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * This class is a Panel, this panel is where all the information about the game
 * is drawn, this information is drawn by the current screen (class Screen).
 * In junction with the PikominoFrame and Screen class represents the Vision and
 * Control of the MVC.
 *
 */
public class PlayersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static public int widthScreen = 800;
	static public int heightScreen = 624;
	
	private int posX, posY, widthImage, heightImage;
	
	private GameBoard gameBoard = null;
	
	private String [] players = null;
	private List<JLabel> labels = new ArrayList<JLabel>(); 
	private List<JTextField> textFiels = new ArrayList<JTextField>();
	private JComboBox<Integer> comboBox;

	public PlayersPanel(final JPanel gamePanel, final Model model) {
		super();
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("196px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("40px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(52dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(80dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(150dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("64px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(24dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
				
		JLabel lblStartPlay = new JLabel("Players Menu");
		lblStartPlay.setForeground(new Color(139, 69, 19));
		lblStartPlay.setFont(new Font("Arial", Font.BOLD, 40));
		add(lblStartPlay, "2, 2, 11, 1, center, default");
		
		JLabel lblNumberOfPlayers = new JLabel("Number of players:");
		lblNumberOfPlayers.setFont(new Font("Arial", Font.BOLD, 20));
		lblNumberOfPlayers.setForeground(new Color(139, 69, 19));
		add(lblNumberOfPlayers, "2, 8, right, center");
		
		comboBox = new JComboBox<Integer>();
		comboBox.setForeground(new Color(139, 69, 19));
		comboBox.setFont(new Font("Arial", Font.BOLD, 15));
		
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {2, 3, 4, 5, 6, 7}));
		comboBox.setSelectedIndex(0);
		add(comboBox, "4, 8, 1, 2, fill, top");
		comboBox.setMaximumRowCount(6);
		lblNumberOfPlayers.setLabelFor(comboBox);
		
		JButton btnPlay = new JButton("Start Play");
		btnPlay.setForeground(new Color(139, 69, 19));

		btnPlay.setFont(new Font("Arial", Font.BOLD, 15));
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNamesPlayerOfTextBox();
				gameBoard = new GameBoard(players);
				gamePanel.removeAll();
				model.setGameBoard(gameBoard);
				JPanel newGamePanel = new GamePanel(model);
				gamePanel.add(newGamePanel, BorderLayout.CENTER);
				gamePanel.updateUI();
			}
		});
		add(btnPlay, "10, 8, 1, 3");
		
		JLabel lblPlayer1 = new JLabel("Player 1:");
		lblPlayer1.setForeground(new Color(139, 69, 19));
		lblPlayer1.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblPlayer1, "2, 12, right, default");
		labels.add(lblPlayer1);
		
		JTextField player1 = new JTextField();
		player1.setFont(new Font("Arial", Font.BOLD, 15));
		player1.setForeground(Color.GRAY);
		add(player1, "4, 12, 3, 1, fill, default");
		player1.setDocument(new JTextFieldLimit(10));
		player1.setColumns(10);
		textFiels.add(player1);
		
				
		JLabel lblPlayer2 = new JLabel("Player 2:");
		lblPlayer2.setForeground(new Color(139, 69, 19));
		lblPlayer2.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblPlayer2, "2, 16, right, default");
		labels.add(lblPlayer2);
		
		JTextField player2 = new JTextField();
		player2.setFont(new Font("Arial", Font.BOLD, 15));
		player2.setForeground(Color.GRAY);
		add(player2, "4, 16, 3, 1, fill, default");
		player2.setDocument(new JTextFieldLimit(10));
		player2.setColumns(10);
		textFiels.add(player2);
		
		JLabel lblPlayer3 = new JLabel("Player 3:");
		lblPlayer3.setForeground(new Color(139, 69, 19));
		lblPlayer3.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblPlayer3, "2, 20, right, default");
		labels.add(lblPlayer3);
		
		JTextField player3 = new JTextField();
		player3.setFont(new Font("Arial", Font.BOLD, 15));
		player3.setForeground(Color.GRAY);
		add(player3, "4, 20, 3, 1, fill, default");
		player3.setDocument(new JTextFieldLimit(10));
		player3.setColumns(10);
		textFiels.add(player3);
		
		JLabel lblPlayer4 = new JLabel("Player 4:");
		lblPlayer4.setForeground(new Color(139, 69, 19));
		lblPlayer4.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblPlayer4, "2, 24, right, default");
		labels.add(lblPlayer4);
		
		JTextField player4 = new JTextField();
		player4.setFont(new Font("Arial", Font.BOLD, 15));
		player4.setForeground(Color.GRAY);
		add(player4, "4, 24, 3, 1, fill, default");
		player4.setDocument(new JTextFieldLimit(10));
		player4.setColumns(10);
		textFiels.add(player4);
		
		JLabel lblPlayer5 = new JLabel("Player 5:");
		lblPlayer5.setForeground(new Color(139, 69, 19));
		lblPlayer5.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblPlayer5, "2, 28, right, default");
		labels.add(lblPlayer5);
		
		JTextField player5 = new JTextField();
		player5.setFont(new Font("Arial", Font.BOLD, 15));
		player5.setForeground(Color.GRAY);
		add(player5, "4, 28, 3, 1, fill, default");
		player5.setDocument(new JTextFieldLimit(10));
		player5.setColumns(10);
		textFiels.add(player5);
		
		JLabel lblPlayer6 = new JLabel("Player 6:");
		lblPlayer6.setForeground(new Color(139, 69, 19));
		lblPlayer6.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblPlayer6, "2, 32, right, default");
		labels.add(lblPlayer6);
		
		JTextField player6 = new JTextField();
		player6.setFont(new Font("Arial", Font.BOLD, 15));
		player6.setForeground(Color.GRAY);
		add(player6, "4, 32, 3, 1, fill, default");
		player6.setDocument(new JTextFieldLimit(10));
		player6.setColumns(10);
		textFiels.add(player6);
		
		JLabel lblPlayer7 = new JLabel("Player 7:");
		lblPlayer7.setForeground(new Color(139, 69, 19));
		lblPlayer7.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblPlayer7, "2, 36, right, default");
		labels.add(lblPlayer7);
		
		JTextField player7 = new JTextField();
		player7.setFont(new Font("Arial", Font.BOLD, 15));
		player7.setForeground(Color.GRAY);
		add(player7, "4, 36, 3, 1, fill, default");
		player7.setDocument(new JTextFieldLimit(10));
		player7.setColumns(10);
		textFiels.add(player7);
		
		comboBox.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				setVisibilite();
			}
		});
	}
	
	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public String[] getPlayers() {
		return players;
	}

	public void setPlayers(String[] players) {
		this.players = players;
	}
	
	@Override
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);

		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gs.getDefaultConfiguration();

		BufferedImage bimage = gc.createCompatibleImage(widthScreen,
				heightScreen, Transparency.OPAQUE);
		
		g.fillRect(0, 0, getWidth(), getHeight());

		g.drawImage(Images.getBackgroundPlayers(), 0, 0, widthScreen, heightScreen,null);

	}
	private void setVisibilite(){
		Integer i=1;
		while(i <= (Integer)comboBox.getSelectedItem()){
			labels.get(i-1).setVisible(true);
			textFiels.get(i-1).setVisible(true);
			i++;
		}
		for(int j=i; j< comboBox.getItemCount()+2; j++){
			labels.get(i-1).setVisible(false);
			textFiels.get(i-1).setVisible(false);
			i++;
		}
	}
	
	private void setNamesPlayerOfTextBox(){
		players = new String [(Integer)comboBox.getSelectedItem()];
		
		for(Integer i =0; i< (Integer)comboBox.getSelectedItem(); i++){
			String name = textFiels.get(i).getText();
			if(name.equals("")){
				name = labels.get(i).getText().replace(":", "");
			}
			players[i]=name;
		}
	}
	
}
