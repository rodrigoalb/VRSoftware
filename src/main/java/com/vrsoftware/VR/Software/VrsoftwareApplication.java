package com.vrsoftware.VR.Software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class VrsoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(VrsoftwareApplication.class, args);
		System.setProperty("java.awt.headless", "false");
		SwingUtilities.invokeLater(() -> new MainForm());
	}

}
