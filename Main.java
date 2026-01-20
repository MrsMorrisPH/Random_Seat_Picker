import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class Main {
    private static final String[] ROW_LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    private static final String[] SEAT_NUMBERS = {"1", "2", "3", "4"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowUi);
    }

    private static void createAndShowUi() {
        JFrame frame = new JFrame("Random Seat Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel resultLabel = new JLabel("Click the button to get a seat", JLabel.CENTER);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        JButton randomSeatButton = new JButton("Random Seat");
        randomSeatButton.setPreferredSize(new Dimension(160, 40));
        randomSeatButton.addActionListener(e -> {
            String seat = getRandomSeat(ROW_LETTERS, SEAT_NUMBERS);
            resultLabel.setText("Your seat is: " + seat);
        });

        JPanel panel = new JPanel();
        panel.add(randomSeatButton);

        frame.setLayout(new BorderLayout(10, 10));
        frame.add(resultLabel, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setSize(360, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static String getRandomSeat(String[] rows, String[] seats) {
        int randomRowIndex = (int) (Math.random() * rows.length);
        int randomSeatIndex = (int) (Math.random() * seats.length);
        return rows[randomRowIndex] + seats[randomSeatIndex];
    }
}