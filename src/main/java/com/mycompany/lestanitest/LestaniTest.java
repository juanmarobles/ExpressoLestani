package com.mycompany.lestanitest;

import com.mycompany.lestanitest.igu.Login;


public class LestaniTest {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login lg = new Login();
                lg.setVisible(true);
            }
        });
    }
}
