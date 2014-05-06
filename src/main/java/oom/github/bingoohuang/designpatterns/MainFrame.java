package oom.github.bingoohuang.designpatterns;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1639098303912593036L;

    public static void main(String[] args) {
        new MainFrame();
    }

    private static Map<String, User> registry = new HashMap<String, User>();

    MainFrame() {
        // make the frame half the height and width
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setSize(width / 2, height / 2);

        setLocationRelativeTo(null);
        setTitle("User Management Console - Practise for Design Patterns");
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        top.add(new JLabel("Command:"), BorderLayout.LINE_START);

        final JTextField jTextField = new JTextField();
        top.add(jTextField, BorderLayout.CENTER);

        JButton jButton = new JButton("Execute");
        JButton cleanButton = new JButton("Clear");

        Panel buttonPanel = new Panel();
        buttonPanel.add(jButton);
        buttonPanel.add(cleanButton);

        top.add(buttonPanel, BorderLayout.LINE_END);

        final JTextArea textPane = new JTextArea();
        textPane.setEditable(false);
        textPane.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(textPane);

        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
            }
        });

        add(top, BorderLayout.PAGE_START);
        add(jsp, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    doCommand(jTextField, textPane);
                }
            }
        });

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCommand(jTextField, textPane);
            }
        });
    }

    private void doCommand(JTextField jTextField, JTextArea textPane) {
        String commandLine = jTextField.getText();
        String[] fields = commandLine.split(" ");
        String commandType = fields[0];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        textPane.setText(textPane.getText() + simpleDateFormat.format(new Date()) + "$ " + commandLine + "\r\n");

        Command command;
        if ("add".equals(commandType)) {
            String id = fields[1];
            String name = fields[2];
            command = new AddCommand(registry, id, name);
        } else if ("get".equals(commandType)) {
            String id = fields[1];
            command = new GetCommand(registry, id);
        } else if ("del".equals(commandType)) {
            String id = fields[1];
            command = new DelCommand(registry, id);
        } else {
            command = new BadCommand();
        }

        String result = command.execute();
        textPane.setText(textPane.getText() + result + ".\r\n");

        jTextField.setText("");
    }

}
