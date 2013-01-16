package com.notelek.notify;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main{
	
	public static String version = "0.0.01";
	
	public static void main(String[] args){
		if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
		
		
		Gui.tray(true);
		Gui notify = new Gui("Achievement Get!", "Line 2", "path", 0);
		
	}
}
