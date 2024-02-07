package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import Constant.CommonConstants;

public class WelcomePage extends Form implements ActionListener {

    JLabel welcomLabel, greetingLabel, dateTimeLable, t1Label;
    JTextArea textArea;
    JButton exit, generate;
    String username;

    public WelcomePage(String username) {
        super("");
        this.username = username;
        addGuiComponents();
    }

    private void addGuiComponents() {

        // Create a user name label
        greetingLabel = new JLabel("Good morning"); // good morning, noon, afternoon, evening
        greetingLabel.setBounds(30, 60, 400, 35);
        greetingLabel.setForeground(CommonConstants.TEXT_COLOR);
        greetingLabel.setFont(new Font("Bell MT", Font.BOLD, 27));
        add(greetingLabel);

        // get the date and time
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour < 12) {
            greetingLabel.setText("Good Morning!");
        } else if (hour < 17) {
            greetingLabel.setText("Good Afternoon!");
        } else {
            greetingLabel.setText("Good Evening!");
        }

        // Create a user name label
        dateTimeLable = new JLabel();
        dateTimeLable.setBounds(30, 90, 400, 25);
        dateTimeLable.setForeground(CommonConstants.TEXT_COLOR);
        dateTimeLable.setFont(new Font("Bell MT", Font.BOLD, 18));
        add(dateTimeLable);

        // get time day,date and year, like: Tue, Feb 06 2024
        dateTimeLable.setText(date.toString().substring(0, 3) + ", " + date.toString().substring(4, 10) + " "
                + date.toString().substring(24));

        // Create a label to welcome
        welcomLabel = new JLabel("Welcome " + username + "!");
        welcomLabel.setBounds(30, 150, 400, 25);
        welcomLabel.setForeground(CommonConstants.TEXT_COLOR);
        welcomLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(welcomLabel);

        // Create a label to display text
        t1Label = new JLabel("Quote of the day is");
        t1Label.setBounds(30, 190, 400, 25);
        t1Label.setForeground(CommonConstants.TEXT_COLOR);
        t1Label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        add(t1Label);

        // create a text area to display quotes
        textArea = new JTextArea();
        textArea.setBounds(40, 240, 430, 220);
        textArea.setForeground(CommonConstants.TEXT_COLOR);
        textArea.setBackground(CommonConstants.PRIMARY_COLOR);
        textArea.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        textArea.setEditable(false);
        add(textArea);
        generateQuotes();

        // create a exit button
        generate = new JButton("Re-Generate");
        generate.setBounds(300, 490, 150, 30);
        generate.setFont(new Font("Bell MT", Font.BOLD, 18));
        generate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        generate.setBackground(CommonConstants.SECONDARY_COLOR);
        generate.setForeground(CommonConstants.TEXT_COLOR);
        add(generate);
        generate.addActionListener(this);

        // create a exit button
        exit = new JButton("Exit");
        exit.setBounds(350, 550, 100, 30);
        exit.setFont(new Font("Bell MT", Font.BOLD, 18));
        exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exit.setBackground(CommonConstants.SECONDARY_COLOR);
        exit.setForeground(CommonConstants.TEXT_COLOR);
        add(exit);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == generate) {

            // add method to display quote
            generateQuotes();

        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    private void generateQuotes() {
        // generate random number
        int num = 0;
        num = generateNum(num);

        switch (num) {
            case 1:
                textArea.setText("\"In the world of coding, the hustle is your code compiling, the grind is your keyboard tapping, and success is your flawless execution.\"");
                break;
            case 2:
                textArea.setText("\"Debugging is not a setback; it's a setup for a breakthrough. Embrace the challenges, hustle through the bugs, and watch your code rise.\"");
                break;
            case 3:
                textArea.setText("\"Coding is not just a skill; it's a mindset. Hustle through the challenges, iterate on your mistakes, and let your code tell your success story.\"");
                break;
            case 4:
                textArea.setText("\"In the coding realm, the late-night commits and relentless debugging are the currency of success. Hustle hard, code harder.\"");
                break;
            case 5:
                textArea.setText("\"Your code is your legacy. Hustle with passion, write with precision, and let your algorithms be the symphony of your success.\"");
                break;
            case 6:
                textArea.setText("\"Every line of code is a step towards your programming masterpiece. Hustle diligently, refine your craft, and watch your software soar.\"");
                break;
            case 7:
                textArea.setText("\"Success in coding is not about the lines you write; it's about the impact they make. Hustle with purpose, and let your code speak volumes.\"");
                break;
            case 8:
                textArea.setText("\"Coding is an art form, and every bug is a chance to refine your masterpiece. Embrace the challenge, hustle through the syntax, and create magic.\"");
                break;
            case 9:
                textArea.setText("\"The coding journey is paved with challenges, but each bug fixed is a victory won. Hustle relentlessly, and let your code be your triumph.\"");
                break;
            case 10:
                textArea.setText("\"In the coding world, success favors the persistent. Keep coding, keep learning, and let your hustle be the code that compiles your dreams.\"");
                break;
            case 11:
                textArea.setText("\"Hustle like your code depends on it, because it does. The more you invest in your craft, the greater the dividends of success.\"");
                break;
            case 12:
                textArea.setText("\"Coding is not just about algorithms; it's about attitude. Hustle with resilience, debug with determination, and watch your code redefine possibilities.\"");
                break;
            case 13:
                textArea.setText("\"The best coders are not the ones who write the most code; they are the ones who hustle through challenges and turn complexity into clarity.\"");
                break;
            case 14:
                textArea.setText("\"Coding is a journey of problem-solving. Hustle through the puzzles, code through the challenges, and let your solutions speak for themselves.\"");
                break;
            case 15:
                textArea.setText("\"The beauty of coding lies in the struggle. Hustle through the errors, debug with determination, and witness the elegance of your resilient code.\"");
                break;
            case 16:
                textArea.setText("\"Coding is not just about typing; it's about tenacity. Hustle through the complexities, debug with dedication, and let your code shine.\"");
                break;
            case 17:
                textArea.setText("\"Success in coding is not a sprint; it's a marathon of consistent effort and continuous learning. Hustle hard, and enjoy the coding journey.\"");
                break;
            case 18:
                textArea.setText("\"In the coding universe, your hustle is your commit history, your grind is your algorithmic finesse, and success is your software changing the game.\"");
                break;
            case 19:
                textArea.setText("\"Coding is not for the faint-hearted. Hustle through the complexities, debug with courage, and let your code be the testament to your determination.\"");
                break;
            case 20:
                textArea.setText("\"Write code that makes a difference. Hustle like your innovations depend on it, because they do. The world awaits the impact of your keystrokes.\"");
                break;
            case 21:
                textArea.setText("\"Your passion is your fuel; let it drive you to hustle harder than yesterday and conquer your dreams.\"");
                break;
            case 22:
                textArea.setText("\"Excuses will always be there, but opportunities won't. Rise above the excuses, hustle relentlessly, and seize every chance.\"");
                break;
            case 23:
                textArea.setText("\"Be so dedicated to your vision that your hustle becomes a lifestyle. Success is the natural byproduct of unwavering commitment.\"");
                break;
            case 24:
                textArea.setText("\"The road to success is paved with hard work, determination, and a refusal to settle for mediocrity. Keep hustling, keep pushing.\"");
                break;
            case 25:
                textArea.setText("\"In the world of hustle, consistency is the ultimate currency. Stay committed to your goals, and success will follow.\"");
                break;
        }
    }

    private int generateNum(int num) {
        Random rd = new Random();
        return (1 + rd.nextInt(25));
    }
}
