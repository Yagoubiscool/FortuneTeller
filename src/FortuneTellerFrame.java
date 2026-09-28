import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;

    private JLabel titleLabel;
    private ImageIcon fortuneIcon;

    private JTextArea fortuneArea;
    private JScrollPane scrollPane;

    private JButton readButton;
    private JButton quitButton;

    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;
    private Random rnd;

    public FortuneTellerFrame() {
        super("Fortune Teller");

        setLayout(new BorderLayout());
        rnd = new Random();

        // 1. Setup Fonts
        Font titleFont = new Font("Serif", Font.BOLD, 48);
        Font displayFont = new Font("SansSerif", Font.PLAIN, 18);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 24);

        // 2. Initialize Panels
        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        // 3. Build Top Panel
        fortuneIcon = new ImageIcon("Fortune Teller.png");

        titleLabel = new JLabel("Fortune Teller", fortuneIcon, JLabel.CENTER);
        titleLabel.setFont(titleFont);

        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        topPanel.add(titleLabel);

        // 4. Build Middle Panel
        fortuneArea = new JTextArea(12, 40);
        fortuneArea.setFont(displayFont);
        fortuneArea.setEditable(false);

        scrollPane = new JScrollPane(fortuneArea);
        middlePanel.add(scrollPane);

        // 5. Build Bottom Panel
        readButton = new JButton("Read My Fortune!");
        readButton.setFont(buttonFont);

        quitButton = new JButton("Quit");
        quitButton.setFont(buttonFont);

        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);

        // 6. Add Panels to Frame
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // 7. Populate Fortunes
        fortunes = new ArrayList<>();

        fortunes.add("You will soon discover a hidden talent for interpretive dance.");
        fortunes.add("A thrilling time is in your immediate future, provided you stay away from geese.");
        fortunes.add("You will be hungry again in exactly one hour.");
        fortunes.add("Your pet is planning something sinister. Stay alert.");
        fortunes.add("Tomorrow, you will accidentally invent a new word. Pretend you did it on purpose.");
        fortunes.add("Error 404: Fortune not found. Please try again later.");
        fortunes.add("Someone is looking up to you. Don't let them down.");
        fortunes.add("You will soon meet a tall, dark, and handsome cup of coffee.");
        fortunes.add("A sudden windfall of Monopoly money is heading your way.");
        fortunes.add("Your code will compile on the first try... eventually.");
        fortunes.add("Beware of low-flying pigeons on Tuesday.");
        fortunes.add("You will finally remember where you left your keys, right after you buy new ones.");

        // 8. Action Listeners
        quitButton.addActionListener(e -> System.exit(0));

        readButton.addActionListener(e -> {
            int newIndex;

            do {
                newIndex = rnd.nextInt(fortunes.size());
            } while (newIndex == lastFortuneIndex);

            lastFortuneIndex = newIndex;

            fortuneArea.append(fortunes.get(newIndex) + "\n");
        });

        // 9. Configure Window Size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int width = (screenSize.width * 3) / 4;
        int height = (screenSize.height * 3) / 4;

        setSize(width, height);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 10. Main Method
    public static void main(String[] args) {
        FortuneTellerFrame frame = new FortuneTellerFrame();
        frame.setVisible(true);
    }
}