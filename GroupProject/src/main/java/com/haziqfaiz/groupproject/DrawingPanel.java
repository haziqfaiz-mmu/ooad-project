/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haziqfaiz.groupproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author haziq
 */
public class DrawingPanel {
    
    private Point mousePnt = new Point();
    public static Color penColor = new Color(0,0,0);
    private JSlider penSize = new JSlider(JSlider.HORIZONTAL,1,30,4);
    public static int pen =4;
    
    DrawingPanel(){
    JFrame frame = new JFrame("Drawing Panel");
    JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jp = new JPanel();
    toolbar.add(new Label("Drag mouse to draw"));
    toolbar.add(penSize);
    frame.add(toolbar,BorderLayout.SOUTH);
    frame.add(jp,BorderLayout.CENTER);
    frame.setSize(1000,800);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
