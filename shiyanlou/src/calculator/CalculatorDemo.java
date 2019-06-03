package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CalculatorDemo {
    String str1 = "0";
    String str2 = "0";
    String signal = "+";
    String result = "";

    JFrame frame = new JFrame("Calculator");

    JTextField result_textfield = new JTextField(result,20);
    JButton button_c = new JButton("C");
    JButton button_0 = new JButton("0");
    JButton button_1 = new JButton("1");
    JButton button_2 = new JButton("2");
    JButton button_3 = new JButton("3");
    JButton button_4 = new JButton("4");
    JButton button_5 = new JButton("5");
    JButton button_6 = new JButton("6");
    JButton button_7 = new JButton("7");
    JButton button_8 = new JButton("8");
    JButton button_9 = new JButton("9");
    JButton button_dot = new JButton(".");
    JButton button_add = new JButton("+");
    JButton button_sub = new JButton("-");
    JButton button_mis = new JButton("*");
    JButton button_div = new JButton("/");
    JButton button_result = new JButton("=");

    private CalculatorDemo(){
        /**
         */
        button_0.setMnemonic(KeyEvent.VK_0);
        button_1.setMnemonic(KeyEvent.VK_1);
        button_2.setMnemonic(KeyEvent.VK_2);
        button_3.setMnemonic(KeyEvent.VK_3);
        button_4.setMnemonic(KeyEvent.VK_4);
        button_5.setMnemonic(KeyEvent.VK_5);
        button_6.setMnemonic(KeyEvent.VK_6);
        button_7.setMnemonic(KeyEvent.VK_7);
        button_8.setMnemonic(KeyEvent.VK_8);
        button_9.setMnemonic(KeyEvent.VK_9);
        button_dot.setMnemonic(KeyEvent.VK_D);
        button_add.setMnemonic(KeyEvent.VK_ADD);
        button_sub.setMnemonic(KeyEvent.VK_SUBTRACT);
        button_mis.setMnemonic(KeyEvent.VK_MINUS);
        button_div.setMnemonic(KeyEvent.VK_DIVIDE);
        button_result.setMnemonic(KeyEvent.VK_ENTER);

        result_textfield.setHorizontalAlignment(JTextField.RIGHT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,5,5));

        panel.add(button_1);
        panel.add(button_2);
        panel.add(button_3);
        panel.add(button_add);

        panel.add(button_4);
        panel.add(button_5);
        panel.add(button_6);
        panel.add(button_sub);

        panel.add(button_7);
        panel.add(button_8);
        panel.add(button_9);
        panel.add(button_mis);

        panel.add(button_dot);
        panel.add(button_0);
        panel.add(button_result);
        panel.add(button_div);

        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(result_textfield,BorderLayout.WEST);
        panel1.add(button_c,BorderLayout.EAST);

        frame.setLocation(600,400);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel1,BorderLayout.NORTH);
        frame.getContentPane().add(panel,BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("NotFound");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("UI");
        }
        CalculatorDemo cal = new CalculatorDemo();


    }




}
