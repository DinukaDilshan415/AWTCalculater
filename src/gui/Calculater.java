package gui;

import java.awt.*;
import java.awt.event.*;

class Close extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }

}

class Cal implements ActionListener {

    TextField tf, tf2;

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17,
            b18, b19, b20, b21, b22, b23, b24, b25, b26;

    String fv = "0";
    String sv = "0";
    String op = "0";  // firstValue, SecondValue, Oparation
    Double fdv = 0.0;
    Double sdv = 0.0;
    Double tot = 0.0;  //firstdoublevalue, seconddoublevalue, total

    String displaytext;

    Cal() {
        Frame frame = new Frame();
        frame.addWindowListener(new Close());
        frame.setBackground(Color.BLACK);
        frame.setTitle("My Calculater");
        frame.setResizable(false);
        frame.setSize(400, 630);
        frame.setLocationRelativeTo(null);
        
        Image image = Toolkit.getDefaultToolkit().getImage("src\\gui\\Calculator_512.png");
        frame.setIconImage(image);
        
        Font font1 = new Font("MS Outlook", Font.BOLD, 30);
        Font font2 = new Font("Calibri", Font.BOLD, 30);
        Font font3 = new Font("Calibri", Font.BOLD, 40);
        Font font4 = new Font("Calibri", Font.PLAIN, 25);

        MenuBar menubar = new MenuBar();

        Menu menu1 = new Menu("View");
        MenuItem menuItem = new MenuItem("Standard");
        MenuItem menuItem_1 = new MenuItem("Settings");
        MenuItem menuItem_2 = new MenuItem("Exit");
        menu1.add(menuItem);
        menu1.add(menuItem_1);
        menu1.add(menuItem_2);

        Menu menu2 = new Menu("Edit");
        MenuItem menuItem2 = new MenuItem("Copy");
        MenuItem menuItem3 = new MenuItem("Cut");
        menu2.add(menuItem2);
        menu2.add(menuItem3);

        Menu menu3 = new Menu("Help");
        MenuItem menuItem_03 = new MenuItem("Check For Updates");
        MenuItem menuItem_04 = new MenuItem("Release Note");
        MenuItem menuItem_05 = new MenuItem("About");
        menu3.add(menuItem_03);
        menu3.add(menuItem_04);
        menu3.add(menuItem_05);

        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);

        frame.setMenuBar(menubar);

        Panel p1 = new Panel();
        Panel p3 = new Panel();
        Panel p2 = new Panel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 400);
            }
        };
        GridLayout gl = new GridLayout(6, 4, 1, 1);
        p2.setLayout(gl);
        p2.setBackground(Color.lightGray);

        tf = new TextField(16);
        tf.setFont(font3);
        tf.setEditable(true);
        tf.setForeground(Color.WHITE);
        tf.setBackground(Color.DARK_GRAY);
        tf.setText("0");
        p1.add(tf);

        // Add a key listener to allow only numeric input
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Handle backspace key release
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (tf.getText().isEmpty()) {
                        // Set text to "0" if empty
                        tf.setText("0");
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Allow control characters like backspace and delete
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }

                // Allow digits and keypad numbers
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && (e.getKeyCode() < KeyEvent.VK_NUMPAD0 || e.getKeyCode() > KeyEvent.VK_NUMPAD9)) {
                    e.consume();  // Ignore the event
                }
            }
        });

        Color textcolo1 = new Color(252, 184, 119); // RGB color for textfield text

        tf2 = new TextField(16);
        tf2.setFont(font4);
        tf2.setEditable(false);
        tf2.setForeground(textcolo1);
        tf2.setBackground(Color.BLACK);
        tf2.setText("");
        p3.add(tf2);

        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        b10 = new Button("0");
        b11 = new Button("%");
        b12 = new Button("_/`"); //√
        b13 = new Button("x");
        b14 = new Button("1/x");
        b15 = new Button("CE");
        b16 = new Button("C");
        b17 = new Button("<<");
        b18 = new Button("/");
        b19 = new Button("*");
        b20 = new Button("-");
        b21 = new Button("+");
        b22 = new Button("=");
        b23 = new Button(".");
        b24 = new Button("+-");

        Color bColor1 = new Color(217, 124, 37); // RGB color for background     orange
        Color bColor2 = new Color(28, 28, 28); // RGB color for background      darkgray      
        Color textColor = new Color(255, 255, 255);    // RGB color for text     white
        Color hoverColor = new Color(71, 71, 71);   // Hover background color    gray   
        Color hoverColor2 = new Color(58, 100, 133);   // Hover background color Blue

        b1.setBackground(bColor2);
        b2.setBackground(bColor2);
        b3.setBackground(bColor2);
        b4.setBackground(bColor2);
        b5.setBackground(bColor2);
        b6.setBackground(bColor2);
        b7.setBackground(bColor2);
        b8.setBackground(bColor2);
        b9.setBackground(bColor2);
        b10.setBackground(bColor2);
        b11.setBackground(Color.DARK_GRAY);
        b12.setBackground(Color.DARK_GRAY);
        b13.setBackground(Color.DARK_GRAY);
        b14.setBackground(Color.DARK_GRAY);
        b15.setBackground(bColor1);
        b16.setBackground(bColor1);
        b17.setBackground(bColor1);
        b18.setBackground(bColor1);
        b19.setBackground(bColor1);
        b20.setBackground(bColor1);
        b21.setBackground(bColor1);
        b22.setBackground(bColor1);
        b23.setBackground(bColor1);
        b24.setBackground(bColor1);

        b1.setForeground(textColor);
        b2.setForeground(textColor);
        b3.setForeground(textColor);
        b4.setForeground(textColor);
        b5.setForeground(textColor);
        b6.setForeground(textColor);
        b7.setForeground(textColor);
        b8.setForeground(textColor);
        b9.setForeground(textColor);
        b10.setForeground(textColor);
        b11.setForeground(textColor);
        b12.setForeground(textColor);
        b13.setForeground(textColor);
        b14.setForeground(textColor);
        b15.setForeground(textColor);
        b16.setForeground(textColor);
        b17.setForeground(textColor);
        b18.setForeground(textColor);
        b19.setForeground(textColor);
        b20.setForeground(textColor);
        b21.setForeground(textColor);
        b22.setForeground(textColor);
        b23.setForeground(textColor);
        b24.setForeground(textColor);

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b1.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b1.setBackground(bColor2);
            }
        });
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b2.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b2.setBackground(bColor2);
            }
        });
        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b3.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b3.setBackground(bColor2);
            }
        });
        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b4.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b4.setBackground(bColor2);
            }
        });
        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b5.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b5.setBackground(bColor2);
            }
        });
        b6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b6.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b6.setBackground(bColor2);
            }
        });
        b7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b7.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b7.setBackground(bColor2);
            }
        });
        b8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b8.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b8.setBackground(bColor2);
            }
        });
        b9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b9.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b9.setBackground(bColor2);
            }
        });
        b10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b10.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b10.setBackground(bColor2);
            }
        });
        b11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b11.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b11.setBackground(Color.DARK_GRAY);
            }
        });
        b12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b12.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b12.setBackground(Color.DARK_GRAY);
            }
        });
        b13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b13.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b13.setBackground(Color.DARK_GRAY);
            }
        });
        b14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b14.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b14.setBackground(Color.DARK_GRAY);
            }
        });
        b15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b15.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b15.setBackground(bColor1);
            }
        });
        b16.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b16.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b16.setBackground(bColor1);
            }
        });
        b17.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b17.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b17.setBackground(bColor1);
            }
        });
        b18.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b18.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b18.setBackground(bColor1);
            }
        });
        b19.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b19.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b19.setBackground(bColor1);
            }
        });
        b20.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b20.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b20.setBackground(bColor1);
            }
        });
        b21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b21.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b21.setBackground(bColor1);
            }
        });
        b22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b22.setBackground(hoverColor2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b22.setBackground(bColor1);
            }
        });
        b23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b23.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b23.setBackground(bColor1);
            }
        });
        b24.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b24.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b24.setBackground(bColor1);
            }
        });

        b1.setFont(font1);
        b2.setFont(font1);
        b3.setFont(font1);
        b4.setFont(font1);
        b5.setFont(font1);
        b6.setFont(font1);
        b7.setFont(font1);
        b8.setFont(font1);
        b9.setFont(font1);
        b10.setFont(font1);
        b11.setFont(font1);
        b12.setFont(font1);
        b13.setFont(font1);
        b14.setFont(font1);
        b15.setFont(font1);
        b16.setFont(font1);
        b17.setFont(font1);
        b18.setFont(font1);
        b19.setFont(font1);
        b20.setFont(font1);
        b21.setFont(font1);
        b22.setFont(font1);
        b23.setFont(font1);
        b24.setFont(font1);

        p2.add(b11);
        p2.add(b12);
        p2.add(b13);
        p2.add(b14);
        p2.add(b15);
        p2.add(b16);
        p2.add(b17);
        p2.add(b18);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b19);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b20);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b21);
        p2.add(b24);
        p2.add(b10);
        p2.add(b23);
        p2.add(b22);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);
        b21.addActionListener(this);
        b22.addActionListener(this);
        b23.addActionListener(this);
        b24.addActionListener(this);

        frame.add(p1);
        frame.add(p3, BorderLayout.NORTH);
        frame.add(p2, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent d) {

        Object o = d.getSource();

        String currentText = tf.getText();

        if (tf.getText().equals("0")) {
            tf.setText("");

            if (o.equals(b1)) {
                tf.setText(tf.getText() + b1.getLabel());

            } else if (o.equals(b2)) {
                tf.setText(tf.getText() + b2.getLabel());

            } else if (o.equals(b3)) {
                tf.setText(tf.getText() + b3.getLabel());

            } else if (o.equals(b4)) {
                tf.setText(tf.getText() + b4.getLabel());

            } else if (o.equals(b5)) {
                tf.setText(tf.getText() + b5.getLabel());

            } else if (o.equals(b6)) {
                tf.setText(tf.getText() + b6.getLabel());

            } else if (o.equals(b7)) {
                tf.setText(tf.getText() + b7.getLabel());

            } else if (o.equals(b8)) {
                tf.setText(tf.getText() + b8.getLabel());

            } else if (o.equals(b9)) {
                tf.setText(tf.getText() + b9.getLabel());

            } else if (o.equals(b10)) {                   // 0
                tf.setText(tf.getText() + b10.getLabel());

            } else if (o.equals(b23)) {                   // .
                if (!currentText.contains(".")) {
                    tf.setText(currentText + b23.getLabel());
                }

            } else if (o.equals(b17)) {                   // <<
                tf2.setText("");

                if (currentText.length() > 1) {
                    tf.setText(currentText.substring(0, currentText.length() - 1));

                } else if (currentText.length() == 1) {
                    tf.setText("0");
                }

            } else if (o.equals(b15)) {                   // CE
                tf.setText("0");
                tf2.setText("");
                op = "0";

            } else if (o.equals(b16)) {                   // C
                op = b16.getLabel();
                tf.setText("0");
                tf2.setText("");

            } else if (o.equals(b20)) {                   // -
                tf.setText("0");
                fv = tf.getText();
                op = b20.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b21)) {                   // +
                tf.setText("0");
                fv = tf.getText();
                op = b21.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b19)) {                   // *
                tf.setText("0");
                fv = tf.getText();
                op = b19.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b18)) {                   // /
                tf.setText("0");
                fv = tf.getText();
                op = b18.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b12)) {                   // √
                fv = tf.getText();
                tf.setText("0");

            } else if (o.equals(b22)) {                   // =

                if (currentText.length() < 1) {
                    tf.setText("0");
                }

                sv = tf.getText();

                try {

                    fdv = Double.parseDouble(fv);
                    sdv = Double.parseDouble(sv);

                } catch (Exception e) {
                    tf2.setText("Invalid Operation");
                }

                tf.setText("");

                if (op.equals("+")) {           // + Oparation
                    tot = fdv + sdv;
                    tf.setText(tot + "");

                } else if (op.equals("-")) {    // - Oparation
                    tot = fdv - sdv;
                    tf.setText(tot + "");

                } else if (op.equals("*")) {    // * Oparation
                    tot = fdv * sdv;
                    tf.setText(tot + "");

                } else if (op.equals("/")) {    // / Oparation                
                    if (fdv != 0) {
                        tot = fdv / sdv;
                        tf.setText(tot + "");
                    } else {
                        tf.setText("0");
                    }
                }
            }

        } else {                                                       // No "0"
            if (o.equals(b1)) {
                tf.setText(tf.getText() + b1.getLabel());

            } else if (o.equals(b2)) {
                tf.setText(tf.getText() + b2.getLabel());

            } else if (o.equals(b3)) {
                tf.setText(tf.getText() + b3.getLabel());

            } else if (o.equals(b4)) {
                tf.setText(tf.getText() + b4.getLabel());

            } else if (o.equals(b5)) {
                tf.setText(tf.getText() + b5.getLabel());

            } else if (o.equals(b6)) {
                tf.setText(tf.getText() + b6.getLabel());

            } else if (o.equals(b7)) {
                tf.setText(tf.getText() + b7.getLabel());

            } else if (o.equals(b8)) {
                tf.setText(tf.getText() + b8.getLabel());

            } else if (o.equals(b9)) {
                tf.setText(tf.getText() + b9.getLabel());

            } else if (o.equals(b10)) {                   // 0
                tf.setText(tf.getText() + b10.getLabel());

            } else if (o.equals(b23)) {                   // .
                if (!currentText.contains(".")) {
                    tf.setText(currentText + b23.getLabel());
                }

            } else if (o.equals(b17)) {                   // <<
                tf2.setText("");

                if (currentText.length() > 1) {
                    tf.setText(currentText.substring(0, currentText.length() - 1));

                } else if (currentText.length() == 1) {
                    tf.setText("0");
                }

            } else if (o.equals(b15)) {                   // CE
                tf.setText("0");
                tf2.setText("");
                op = "0";

            } else if (o.equals(b16)) {                   // C
                op = b16.getLabel();
                tf.setText("0");
                tf2.setText("");

            } else if (o.equals(b20)) {                   // -
                fv = tf.getText();
                op = b20.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b21)) {                   // +
                fv = tf.getText();
                op = b21.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b19)) {                   // *
                fv = tf.getText();
                op = b19.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b18)) {                   // /
                fv = tf.getText();
                op = b18.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b11)) {                   // %
                fv = tf.getText();
                op = b11.getLabel();
                displaytext = fv + op;
                tf2.setText(displaytext);
                tf.setText("");

            } else if (o.equals(b12)) {                   // √

                if (currentText.length() < 1) {
                    tf.setText("0");
                }

                fv = tf.getText();
                fdv = Double.parseDouble(fv);
                op = b12.getLabel();
                tot = Math.sqrt(fdv);
                tf.setText(tot + "");
                displaytext = op + fv;
                tf2.setText(displaytext);

            } else if (o.equals(b22)) {                     // =

                if (currentText.length() < 1) {
                    tf.setText("0");
                }

                sv = tf.getText();

                try {

                    fdv = Double.parseDouble(fv);
                    sdv = Double.parseDouble(sv);

                } catch (Exception e) {
                    tf2.setText("Invalid Operation");
                }

                tf.setText("");

                if (op.equals("+")) {           // + Oparation
                    tot = fdv + sdv;
                    tf.setText(tot + "");
                    tf2.setText(displaytext + sv);

                } else if (op.equals("-")) {    // - Oparation
                    tot = fdv - sdv;
                    tf.setText(tot + "");
                    tf2.setText(displaytext + sv);

                } else if (op.equals("*")) {    // * Oparation
                    tot = fdv * sdv;
                    tf.setText(tot + "");
                    tf2.setText(displaytext + sv);

                } else if (op.equals("%")) {    // % Oparation
                    tot = (fdv * sdv) / 100;
                    tf.setText(tot + "");
                    tf2.setText(displaytext + sv);

                } else if (op.equals("/")) {    // / Oparation                
                    if (fdv != 0) {
                        tot = fdv / sdv;
                        tf.setText(tot + "");
                        tf2.setText(displaytext + sv);
                    } else {
                        tf.setText("0");
                    }

                }
            }
        }
    }

}

public class Calculater {

    public static void main(String[] args) {
        new Cal();
    }
}
