/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chk.plugins;

import javax.swing.JOptionPane;

/**
 *
 * @author chk
 */
public class MessageBox {
    public static void infoBox(String msg, String titleBar)
    {
        JOptionPane.showMessageDialog(null, msg, "Info: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void errorBox(String msg, String titleBar)
    {
        JOptionPane.showMessageDialog(null, msg, "Error: " + titleBar, JOptionPane.ERROR_MESSAGE);
    }
}

