package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.commandinterpreter.SimpleCommandInterpreter;
import com.github.bingoohuang.designpatterns.commands.ProxyCommand;
import com.github.bingoohuang.designpatterns.observers.UserChangedObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1639098303912593036L;

    public static void main(String[] args) {
        new MainFrame();
    }

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

        final JTextField textObserver = new JTextField();

        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                textObserver.setText("");
            }
        });

        add(top, BorderLayout.PAGE_START);
        add(jsp, BorderLayout.CENTER);
        add(textObserver, BorderLayout.PAGE_END);

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

        UserRegistry.getInstance().addUserChangedObserver(new UserChangedObserver() {
            @Override
            public void onAdd(User user) {
                textObserver.setText(user + " was added!");
            }

            @Override
            public void onDel(User user) {
                textObserver.setText(user + " was deleted!");
            }
        });
    }


    private void doCommand(JTextField jTextField, JTextArea textPane) {
        String commandLine = jTextField.getText().trim();
        if ("".equals(commandLine)) return;

        SimpleCommandInterpreter commandInterpreter = new SimpleCommandInterpreter(commandLine);

        CommandParser commandParser = CommandParserFactory.create(commandInterpreter);
        Command command = commandParser.parseCommand();
        Command proxy = new ProxyCommand(command);

        String result = proxy.execute();

        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        textPane.setText(textPane.getText() + time + "$ " + commandLine + "\r\n" + result + ".\r\n");
        jTextField.setText("");
    }

}
