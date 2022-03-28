/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haziqfaiz.groupproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author haziq
 */
public class DrawingPanel extends JFrame implements MouseMotionListener, MouseListener, ChangeListener{
    
    private int clickCount =0;
    private Point mousePnt = new Point();
    public static Color penColor = new Color(0,0,0);
    private JSlider penSize = new JSlider(JSlider.HORIZONTAL,1,30,4);
    public static int pen =4;
    public DrawingPanel(){
        super("Painter");
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp = new JPanel();
        toolbar.add(new Label("Drag mouse to draw"));
        toolbar.add(penSize);
        this.add(toolbar,BorderLayout.SOUTH);
        this.add(jp,BorderLayout.CENTER);
        jp.addMouseMotionListener(this);
        jp.addMouseListener(this);
        penSize.addChangeListener(this);
        setSize(1000,800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void mouseMoved(MouseEvent me){
    System.out.println("Mouse moved");}
    
    @Override
    public void mouseDragged(MouseEvent me){
    mousePnt = me.getPoint();
    //repaint is provided by the Jframe
    repaint();
    }
    
    //Override paint method provided by JFrame
    @Override
    public void paint(Graphics g){
        g.setColor(penColor);
        g.drawRect(mousePnt.x, mousePnt.y, pen, pen);
    }
    

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON3){
            penColor = JColorChooser.showDialog(null,"Change pen color", penColor);
        }
        if(me.getButton() == MouseEvent.BUTTON1) {
            System.out.println("Left Click!");
          }
          if(me.getButton() == MouseEvent.BUTTON2) {
            System.out.println("Middle Click!");
          }
          if(me.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Right Click!");
          }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource(); 
        if(!source.getValueIsAdjusting()){
            pen=(int)source.getValue();
        }
    }
}
