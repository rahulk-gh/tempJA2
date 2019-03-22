/*
 * The purpose of this class is to be a first demo of threads, 
combined with mouse clicks, and Jframe?
 */
package com.java24hours;

import java.awt.*;
import java.awt.event.*;//for ActionListener
import java.io.*;
import javax.swing.*;//for jframe
import java.net.*;


/**
 *
 * @author rahulk-gh
 */
public class LinkRotator extends JFrame 
        implements Runnable, ActionListener {
    String[] pageTitle = new String[6];
    URI[] pageLink = new URI[6];
    int current =0;
    Thread runner;
    JLabel siteLabel = new JLabel();
    
    public LinkRotator(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        add(siteLabel);
        pageTitle = new String[]{
            "Oracle's java site", "server side",
            "JavaWorld", "Java in 24h", 
            "Sams publishing", "Workbench"
        };
        pageLink[0] = getURI("http://www.oracle.com/technetwork/java");
        pageLink[1] = getURI("http://www.theserverside");
        pageLink[2] = getURI("http://www.javaworld.com");
        pageLink[3] = getURI("http://www.java24hours.com");
        pageLink[4] = getURI("http://www.sampublishing.com");
        pageLink[5] = getURI("http://www.workbench.cadenhead.org");
        Button visitButton = new Button("Visit Site");
        visitButton.addActionListener(this);//here, 'this' populated automaticly
        add(visitButton);
        setVisible(true);
        start();
    }
    
    private URI getURI(String urlText){
        URI pageURI = null;
        try{
            pageURI = new URI(urlText);
        } catch(URISyntaxException ex){
            //nuffin mah muffin
        }
        return pageURI;
    }
     
    public void start() {
        if (runner == null){
            runner = new Thread(this);
            runner.start();
        }
    }
    
    public void run(){
        Thread thisThread = Thread.currentThread();
        while(runner == thisThread){
            current++;
            if (current > 5){
                current = 0;
            }
            siteLabel.setText(pageTitle[current]);
            repaint();
            try{
                Thread.sleep(2000);
            } catch(InterruptedException exc){
                //uhhh ....no..no
            }
                    
        }
    }
    
    public void actionPerformed(ActionEvent event){
        Desktop desktop = Desktop.getDesktop();
        if (pageLink[current] !=null) {
            try {
                desktop.browse(pageLink[current]);
                runner = null;
                System.exit(0);
            }catch (IOException exc) {
                //te nada amigo
            }
        }
    }
    
    public static void main(String[] args){
        new LinkRotator();
    }
}
