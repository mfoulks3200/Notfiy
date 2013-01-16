package com.notelek.notify;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui implements ActionListener{

	public Gui(String line1, String line2, String imagepath, int style) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int swidth = width - 320;
		
		
		
		
		
		JDialog notification = new JDialog();
		JPanel main = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		main.setLayout(new GridLayout(2, 1));

		

		JLabel notifyline1 = new JLabel();
		notifyline1.setText(line1);
		notifyline1.setFont(new Font("Minecraft", 1, 20));
		notifyline1.setForeground(new Color(242, 238, 17));
		main.add(notifyline1);

		JLabel notifyline2 = new JLabel();
		notifyline2.setText(line2);
		notifyline2.setFont(new Font("Minecraft", 1, 10));
		notifyline2.setForeground(Color.black);
		main.add(notifyline1);

		notification.add(main);
		notification.setSize(new Dimension(320, 64));
		notification.setLocation(swidth, 0);
		notification.setUndecorated(true);
		notification.setVisible(true);
		notification.getContentPane().setBackground(Color.BLACK);
		//for(int i = -64; i >= 0; i--){
		//	notification.setLocation(swidth, i);
		//}
	}
	
	public static void tray(boolean trayEnable){
		if(trayEnable){
		final PopupMenu trayMenu = new PopupMenu();
		MenuItem dirtPanel = new MenuItem("Dirt Panel Desktop v" + Main.version);
		MenuItem exitItem = new MenuItem("Exit");
		trayMenu.add(dirtPanel);
		trayMenu.add(exitItem);
		
		//exitItem.addActionListener(this);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images/icon.gif"));
		} catch (IOException e) {
		}
		
		try {
			img = ImageIO.read(new File("images/icon.png"));
		} catch (IOException e) {
		}

		final TrayIcon trayIcon = new TrayIcon(img);
		final SystemTray tray = SystemTray.getSystemTray();

		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
		}
		trayIcon.setPopupMenu(trayMenu);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		System.exit(0);
	}

}
