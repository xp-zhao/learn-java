package com.xp.FactoryMethod.button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author zhaoxiaoping
 * @Description: window 按钮实现
 * @Date 2020-10-16
 **/
public class WindowButton implements Button {

  JPanel panel = new JPanel();
  JFrame frame = new JFrame();
  JButton button;

  @Override
  public void render() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel label = new JLabel("Hello World!");
    label.setOpaque(true);
    label.setBackground(new Color(235, 233, 126));
    label.setFont(new Font("Dialog", Font.BOLD, 44));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel.setLayout(new FlowLayout(FlowLayout.CENTER));
    frame.getContentPane().add(panel);
    panel.add(label);
    onClick();
    panel.add(button);

    frame.setSize(320, 200);
    frame.setVisible(true);
    onClick();
  }

  @Override
  public void onClick() {
    button = new JButton("Exit");
    button.addActionListener(e -> {
      frame.setVisible(false);
      System.exit(0);
    });
  }
}
