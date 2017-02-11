/**
 * Ethan Gordon
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainClass {
    private static JTextField textNum, textBase, textOutBase, textOut;
    private static JLabel labelNum, labelBase, labelOutBase, labelOut;
    private static JTextArea preamble;
    private static String inNum, outNum;
    private static int inBase, outBase;
    
    //prints output in the output textfield
    public static void giveOutput() {
        if(!textNum.equals("") && !textBase.equals("") && !textOutBase.equals("")) {
            outNum = decToBase( baseToDec(inNum, inBase), outBase);
            textOut.setText(outNum);
        }
    }
    
    //updates input textfield to match what has previously been entered
    public static void updateTextFields() {
        textNum.setText(inNum);
        textBase.setText(String.valueOf(inBase));
        textOutBase.setText(String.valueOf(outBase));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyPanel panel = new MyPanel();
        
        preamble = new JTextArea("Hey, This is my app thing. If it's not updating press ENTER. please base must be between 2 and 36 inclusive.",
            2, 8);
        panel.add(preamble);
        
        labelNum = new JLabel("Enter a number");
        panel.add(labelNum);
        textNum = new JTextField(11);
        textNum.setFont(textNum.getFont().deriveFont(20f));
        panel.add(textNum);
        textNum.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                try {
                    inNum = textNum.getText();
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
            
            @Override
            public void focusLost(FocusEvent fe) {
                focusGained(fe);
            }
        });
        textNum.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    inNum = textNum.getText();
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
        });
        
        
        labelBase = new JLabel("Enter it's base");
        panel.add(labelBase);
        textBase = new JTextField(12);
        textBase.setFont(textBase.getFont().deriveFont(20f));
        panel.add(textBase);
        textBase.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                try {
                    inBase = Integer.parseInt(textBase.getText());
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
            
            @Override
            public void focusLost(FocusEvent fe) {
                focusGained(fe);
            }
        });
        textBase.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    inBase = Integer.parseInt(textBase.getText());
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
        });
        
        labelOutBase = new JLabel("Enter the output base");
        panel.add(labelOutBase);
        textOutBase = new JTextField(9);
        textOutBase.setFont(textBase.getFont().deriveFont(20f));
        panel.add(textOutBase);
        textOutBase.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                try {
                    outBase = Integer.parseInt(textOutBase.getText());
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
            
            @Override
            public void focusLost(FocusEvent fe) {
                focusGained(fe);
            }
        });
        textOutBase.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    outBase = Integer.parseInt(textOutBase.getText());
                } catch(NumberFormatException nfe) {
                    
                }
                
                giveOutput();
                updateTextFields();
            }
        });
        
        labelOut = new JLabel("OUT");
        panel.add(labelOut);
        textOut = new JTextField(15);
        textOut.setFont(textBase.getFont().deriveFont(20f));
        panel.add(textOut);
        
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setTitle("Base Converter by Ethan Gordon");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.requestFocus();
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
        
    }
    /*
     * @param number in base 10
     * @return number in base 2
     */
    public static long decToBin(int n) {
        long bin = 0;
        for(int i = (int)Math.pow(2, 10); i >= 1; i/=2) {//4  2  1
            bin += (int)(n/i) * Math.pow(10.0, (int)(Math.log(i)/Math.log(2)));
            n -= (int)(n/i) * i;
            if(n <= 0) break;
        }
        return bin;
    }
    /*
     * @param number in base 2
     * @return number in base 10
     */
    public static int binToDec(long n) {
        int dec = 0;
        if(n == 0) return 0;
        for(long i = 100000000; i >= 1; i /= 10) {
            dec += (int)(n/i) * Math.pow(2.0, (int)Math.log10(i));
            n -= (int)(n/i) * i;
            if(n <= 0) break;
        }
        return dec;
    }
    /*
     * @param number in base 16
     * @return number in base 10
     */
    public static int hexToDec(String n) {
        int dec = 0;
        for(int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int digit = 0;
            if(c == '0')      digit = 0;
            else if(c == '1') digit = 1;
            else if(c == '2') digit = 2;
            else if(c == '3') digit = 3;
            else if(c == '4') digit = 4;
            else if(c == '5') digit = 5;
            else if(c == '6') digit = 6;
            else if(c == '7') digit = 7;
            else if(c == '8') digit = 8;
            else if(c == '9') digit = 9;
            else if(c == 'A') digit = 10;
            else if(c == 'B') digit = 11;
            else if(c == 'C') digit = 12;
            else if(c == 'D') digit = 13;
            else if(c == 'E') digit = 14;
            else if(c == 'F') digit = 15;
            
            dec += digit * Math.pow(16, (n.length()-1-i));
        }
        return dec;
    }
    /*
     * PRECONDITION: base must be between 2 and 36 (inclusive)
     * @param n - input number
     * @param base - input base
     * @return a number string in decimal
     */
    public static int baseToDec(String n, int base) {
        int dec = 0;
        for(int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int digit = 0;
            if(c == '0')      digit = 0;
            else if(c == '1') digit = 1;
            else if(c == '2') digit = 2;
            else if(c == '3') digit = 3;
            else if(c == '4') digit = 4;
            else if(c == '5') digit = 5;
            else if(c == '6') digit = 6;
            else if(c == '7') digit = 7;
            else if(c == '8') digit = 8;
            else if(c == '9') digit = 9;
            else if(c == 'A') digit = 10;
            else if(c == 'B') digit = 11;
            else if(c == 'C') digit = 12;
            else if(c == 'D') digit = 13;
            else if(c == 'E') digit = 14;
            else if(c == 'F') digit = 15;
            else if(c == 'G') digit = 16;
            else if(c == 'H') digit = 17;
            else if(c == 'I') digit = 18;
            else if(c == 'J') digit = 19;
            else if(c == 'K') digit = 20;
            else if(c == 'L') digit = 21;
            else if(c == 'M') digit = 22;
            else if(c == 'N') digit = 23;
            else if(c == 'O') digit = 24;
            else if(c == 'P') digit = 25;
            else if(c == 'Q') digit = 26;
            else if(c == 'R') digit = 27;
            else if(c == 'S') digit = 28;
            else if(c == 'T') digit = 29;
            else if(c == 'U') digit = 30;
            else if(c == 'V') digit = 31;
            else if(c == 'W') digit = 32;
            else if(c == 'X') digit = 33;
            else if(c == 'Y') digit = 34;
            else if(c == 'Z') digit = 35;
            
            dec += digit * Math.pow(base, (n.length()-1-i));
        }
        return dec;
    }
    /*
     * PRECONDITION: base must be between 2 and 36 (inclusive)
     * @param n - input number
     * @param base - output base
     * @return a number string in the base provided
     */
    public static String decToBase(long n, int base) {
        String hex = "";
        //same thing as using Math.pow() but no overflow
        for(long i = (int)Math.pow(base, 5); i >= 1; i/=base) {
                int digit = (int)(n/i);
                char c = '!';
                if(digit == 0) c = '0';
                else if(digit == 1) c = '1';
                else if(digit == 2) c = '2';
                else if(digit == 3) c = '3';
                else if(digit == 4) c = '4';
                else if(digit == 5) c = '5';
                else if(digit == 6) c = '6';
                else if(digit == 7) c = '7';
                else if(digit == 8) c = '8';
                else if(digit == 9) c = '9';
                else if(digit == 10) c = 'A';
                else if(digit == 11) c = 'B';
                else if(digit == 12) c = 'C';
                else if(digit == 13) c = 'D';
                else if(digit == 14) c = 'E';
                else if(digit == 15) c = 'F';
                else if(digit == 16) c = 'G';
                else if(digit == 17) c = 'H';
                else if(digit == 18) c = 'I';
                else if(digit == 19) c = 'J';
                else if(digit == 20) c = 'K';
                else if(digit == 21) c = 'L';
                else if(digit == 22) c = 'M';
                else if(digit == 23) c = 'N';
                else if(digit == 24) c = 'O';
                else if(digit == 25) c = 'P';
                else if(digit == 26) c = 'Q';
                else if(digit == 27) c = 'R';
                else if(digit == 28) c = 'S';
                else if(digit == 29) c = 'T';
                else if(digit == 30) c = 'U';
                else if(digit == 31) c = 'V';
                else if(digit == 32) c = 'W';
                else if(digit == 33) c = 'X';
                else if(digit == 34) c = 'Y';
                else if(digit == 35) c = 'Z';
                hex += String.valueOf(c);
                n -= digit*i;
                //if(n<=0) break;
        }
        String betterHex = "";
        //delete leading 0s
        for(int i = 0; i < hex.length(); i++) {
            if(hex.charAt(i) == '0') {
                betterHex = hex.substring(1);
            }
            else break;
        }
        return betterHex;
    }
}
