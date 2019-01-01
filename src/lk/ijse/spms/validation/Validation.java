/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.validation;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author User
 */
public class Validation {
    
    public static void emailValidate(JTextField textField) {
        String text = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!text.matches("^[a-z]([a-z0-9]+\\.)*[a-z0-9]+@[a-z0-9]+([a-z0-9]+\\.)*(\\.[a-z0-9]+)+$")) {
            //textField.setText(textField.getText().substring(0, textField.getText ().length() - 1));
            textField.setForeground(Color.red);
        }else{
            textField.setForeground(Color.black);
        }
    }

    public static void grnbuttonEnable(JToggleButton button, JComboBox cmb, JComboBox modelCmb, JTextField... textFields) {
        boolean enable = true;

        for (JTextField textField : textFields) {

            if (textField.getText().isEmpty()) {
                enable = false;
            }

            if (cmb.getActionCommand().isEmpty()) {
                enable = false;
            }

            if (modelCmb.getActionCommand().isEmpty()) {
                enable = false;
            }

            button.setEnabled(enable);

        }

    }

    public static void nicValidation(JTextField nicTextField) {

        String text = nicTextField.getText();
        int caretPosition = nicTextField.getCaretPosition();
        if (!text.matches("[0-9]{0,9}[vVxX]?")) {
            text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
            nicTextField.setBackground(Color.red);
            nicTextField.setForeground(Color.WHITE);
            nicTextField.setText(text);
            nicTextField.setCaretPosition(caretPosition - 1);
        } else {

            nicTextField.setForeground(Color.BLACK);
            nicTextField.setBackground(Color.WHITE);
        }

    }

    public static void validatePhoneNumber(JTextField textField) {
        String text = textField.getText();
        /*int caretPosition = textField.getCaretPosition();
        if (!text.matches("^[0-9]{0,10}$")) {
            text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
            textField.setText(text);
            textField.setCaretPosition(caretPosition - 1);
        }
        if (text.matches("^[0][1-9]{2}[0-9]{7}$")) {
            textField.setBackground(Color.WHITE);
            textField.setForeground(Color.BLACK);

        } else {
            textField.setBackground(Color.red);
            textField.setForeground(Color.WHITE);
        }*/
        if (!text.matches("\\d{3}\\-\\d{7}")) {
            textField.setForeground(Color.red);
        }else{
            textField.setForeground(Color.black);
        }
    }

    public static void validatePrice(JTextField textField) {
        String txt = textField.getText();

        /*int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[0-9]+[.]?[0-9]{0,2}$")) {
            txt = txt.substring(0, caretPosition + 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition + 1);
        }

        if (txt.matches("^[0-9]+[.]?[0-9]{0,2}$")) {

            textFild.setBackground(Color.WHITE);
            textFild.setForeground(Color.black);
        } else {

            textFild.setBackground(Color.RED);
            textFild.setForeground(Color.WHITE);
        }*/
        if(txt.matches(".+\\.\\d{2}") || txt.matches("\\d+")){
            textField.setForeground(Color.black);
        }else{
            textField.setForeground(Color.red);
        }
    }

    public static void validateName(JTextField textFild) {
        String txt = textFild.getText();
        int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[a-zA-Z ]+?$")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition - 1);
        }

        if (txt.matches("^[a-zA-Z ]+?$")) {

            textFild.setBackground(Color.WHITE);
            textFild.setForeground(Color.black);
        } else {

            textFild.setBackground(Color.RED);
            textFild.setForeground(Color.WHITE);
        }
    }

    public static void validateAutoId(JTextField textFild) {
        String txt = textFild.getText();
        int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("[S][0-9]{0,3}?")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition - 1);
        }

        if (txt.matches("[S][0-9]{0,3}?")) {

            textFild.setBackground(Color.WHITE);
            textFild.setForeground(Color.black);
        } else {

            textFild.setBackground(Color.RED);
            textFild.setForeground(Color.WHITE);
        }
    }

    public static void validateInt(JTextField textField) {
        String txt = textField.getText();
        //int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[0-9]+$")) {
           /* txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition - 1);*/
            textField.setText(textField.getText().substring(0, textField.getText ().length() - 1));
        }

        if (txt.matches("^[0-9]+$")) {

 
        } else {


        }
    }

}
