import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pro4_QuizGame extends JFrame implements ActionListener {

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private JButton submitButton;
    private ButtonGroup buttonGroup;
    private Timer questionTimer;

    private int currentQuestionIndex;
    private int score;
    private static final int NO_OF_QUESTIONS = 5;
    private static final int TIME_LIMIT_SECONDS = 15;

    private String[] questions = {
            "What is the capital of India?",
            "How many months are there in a year?",
            "What is the full form of USA?",
            "Which continent does India lie in?",
            "Which city is called the IT hub of India?"
    };

    private String[][] options = {
            {"New York", "New Delhi", "Chennai", "Mumbai"},
            {"12 months", "36 months", "8 months", "12 months"},
            {"UNION OF STATES OF AMERICA", "UNITED SOVIETS OF AMERICA", "UNITED STATES OF ATLANTICA", "UNITED STATES OF AMERICA"},
            {"NORTH AMERICA", "AFRICA", "ASIA", "EUROPE"},
            {"Bengaluru", "Kolkata", "Mumbai", "Bengaluru"}
    };

    private int[] correctOptions = {2, 1, 4, 3, 1};

    public Pro4_QuizGame() {
        super("Quiz Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new GridLayout(6, 1));

        // Display welcome message and rules
        showWelcomeMessage();

        // Initialize components for quiz (but keep them disabled initially)
        questionLabel = new JLabel();
        add(questionLabel);

        optionButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            buttonGroup.add(optionButtons[i]);
            add(optionButtons[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        questionTimer = new Timer(TIME_LIMIT_SECONDS * 1000, this);

        setComponentsEnabled(false); // Disable quiz components initially
    }

    private void showWelcomeMessage() {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this,
                    "<html><b>WELCOME</b><br>This is a Quiz Game<br><br>" +
                            "********************  RULES ************************<br>" +
                            "--> You will have 5 questions<br>" +
                            "--> Each question will have 4 options, among them only one is correct<br>" +
                            "--> You have 15 seconds to read and answer the question<br>" +
                            "--> If you fail to answer a question within time, it will be considered invalid, and the next question will be displayed<br><br>" +
                            "*********************  ALL THE BEST  *********************************",
                    "Quiz Game - Rules", JOptionPane.INFORMATION_MESSAGE);

            // After the welcome message is closed, start the quiz
            startQuiz();
        });
    }

    private void setComponentsEnabled(boolean enabled) {
        questionLabel.setEnabled(enabled);
        for (JRadioButton button : optionButtons) {
            button.setEnabled(enabled);
        }
        submitButton.setEnabled(enabled);
    }

    private void startQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        displayQuestion();
        setComponentsEnabled(true); // Enable quiz components after starting quiz
    }

    private void displayQuestion() {
        if (currentQuestionIndex < NO_OF_QUESTIONS) {
            questionLabel.setText(questions[currentQuestionIndex]);

            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[currentQuestionIndex][i]);
                optionButtons[i].setSelected(false); // Deselect all options
            }

            buttonGroup.clearSelection(); // Clear selection
            questionTimer.restart(); // Start the timer
        } else {
            finishQuiz();
        }
    }

    private void finishQuiz() {
        questionLabel.setText("End of Questions!");
        double percentageScore = ((double) score / NO_OF_QUESTIONS) * 100.0;
        JOptionPane.showMessageDialog(this,
                String.format("You answered %d/%d questions correctly. Your score: %.2f%%",
                        score, NO_OF_QUESTIONS, percentageScore),
                "Quiz Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); // Close the application after displaying the result
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            checkAnswer();
        } else if (e.getSource() == questionTimer) {
            JOptionPane.showMessageDialog(this, "Time's up!");
            currentQuestionIndex++;
            displayQuestion();
        }
    }

    private void checkAnswer() {
        questionTimer.stop(); // Stop the timer

        int selectedOption = -1;
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                selectedOption = i + 1; // Option index is 1-based
                break;
            }
        }

        if (selectedOption == -1) {
            JOptionPane.showMessageDialog(this, "You did not select an option. Moving to next question.");
        } else if (selectedOption == correctOptions[currentQuestionIndex]) {
            JOptionPane.showMessageDialog(this, "Correct answer!");
            score++;
        } else {
            JOptionPane.showMessageDialog(this, "Wrong answer!");
        }

        currentQuestionIndex++;
        displayQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Pro4_QuizGame().setVisible(true);
        });
    }
}
