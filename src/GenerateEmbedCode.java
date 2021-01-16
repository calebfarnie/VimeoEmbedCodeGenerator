import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @author Caleb Farnie
 * @date 15 January 2021
 * 
 * Copyright 2021 Caleb Farnie
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class GenerateEmbedCode extends JFrame{
	
	public static GenerateEmbedCode gui;
	public static JTextField url;
	public static JTextArea embed;

	public GenerateEmbedCode() {
		setTitle("Vimeo Embed Code Generator v0.1");
		setSize(new Dimension(400, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(vimeoLinkRow(), BorderLayout.NORTH);
		add(embedCodeRow(), BorderLayout.CENTER);
		add(buttonRow(), BorderLayout.SOUTH);
}
	
	public JPanel vimeoLinkRow() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(0, 1));
		
		TitledBorder title = new TitledBorder(new EtchedBorder(), "Enter Vimeo link:");
		panel.setBorder(title);
		
		url = new JTextField("https://vimeo.com/");

		panel.add(url);
		
		return panel;
	}
	
	public JPanel embedCodeRow() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(0, 1));
		
		TitledBorder title = new TitledBorder(new EtchedBorder(), "Embed code:");
		panel.setBorder(title);
		
		embed = new JTextArea();
		embed.setEditable(false);
		embed.setLineWrap(true);

		panel.add(embed);
		
		return panel;
	}
	
	public JPanel buttonRow() {
		JPanel panel = new JPanel();
		
		JButton generate = new JButton("Generate!");
		JButton copy = new JButton("Copy to Clipboard");
		
		generate.addActionListener(new GenerateListener());
		copy.addActionListener(new CopyListener());
		
		panel.add(generate);
		panel.add(copy);
		
		return panel;
	}
	
	public static String processURL(String url) {
		String findStr = "vimeo.com/";
		String videoID = "";
		
		int start = url.indexOf(findStr) + findStr.length();		
		int end;
		
		if(url.indexOf("/", start) == -1) {
			end = url.length();
		}else {
			end = url.indexOf("/", start);
		}
		
		try {
			videoID = url.substring(start, end);
		}catch (Exception e){
			System.out.println(e.getMessage());
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1));
			JLabel line1 = new JLabel("Please make sure your Vimeo link follow this format (with forward slashes):");
			JLabel line2 = new JLabel("");
			JLabel line3 = new JLabel("https://vimeo.com/1234567890/1234567890/");
			JLabel line4 = new JLabel("or");
			JLabel line5 = new JLabel("https://vimeo.com/1234567890/");
			line1.setHorizontalAlignment(SwingConstants.CENTER);
			line2.setHorizontalAlignment(SwingConstants.CENTER);
			line3.setHorizontalAlignment(SwingConstants.CENTER);
			line4.setHorizontalAlignment(SwingConstants.CENTER);
			line5.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(line1);
			panel.add(line2);
			panel.add(line3);
			panel.add(line4);
			panel.add(line5);
			JOptionPane.showMessageDialog(GenerateEmbedCode.gui, panel, "Error: Incorrect Vimeo link", JOptionPane.PLAIN_MESSAGE);
		}
		
		return videoID;
	}
	
	public static String generateEmbed(String videoID) {
		if(videoID.equals("")) {
			return "";
		}else {
			String embedCode = "<iframe src=\"https://player.vimeo.com/video/" + videoID + "\" width=\"640\" height=\"360\" frameborder=\"0\" allow=\"autoplay; fullscreen\" allowfullscreen></iframe>";
			return embedCode;
		}
	}
	
	public static void main(String[] args) {
		
		GenerateEmbedCode gui = new GenerateEmbedCode();
		gui.setLocationRelativeTo(null); // centers on screen
		gui.setVisible(true);
		
		// display splash screen
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		
		JLabel line1 = new JLabel("This program was designed for the Trefny");
		JLabel line2 = new JLabel("Center at the Colorado School of Mines.");
		line1.setHorizontalAlignment(SwingConstants.CENTER);
		line2.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(line1);
		panel.add(line2);

		JOptionPane.showMessageDialog(gui, panel, "� 2021 Caleb Farnie", JOptionPane.INFORMATION_MESSAGE);

	}

}
