package oop.java;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

class CTAActivity extends JFrame implements ActionListener {
	int r, res, x;
	JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	JButton b2, b1;
	JTextField t1, t2, t3, t4, t5;
	Container contentPane;
	JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9;

	CTAActivity() {
		setTitle("Students Grading System");
		// Instantion of Labels
		l = new JLabel("Grade Calculator");
		l2 = new JLabel("Enter IA-1 Marks: ");
		l3 = new JLabel("Enter IA-2 Marks: ");
		l4 = new JLabel("Enter IA-3 Marks: ");
		l5 = new JLabel("Enter CTA Marks: ");
		l6 = new JLabel("Enter SEE Marks: ");
		l7 = new JLabel();
		l7.setText("");
		l8 = new JLabel();
		l8.setText("");
		l10 = new JLabel("   ");
		b2 = new JButton("Eligibility Check");
		b1 = new JButton("     Compute    ");
		b1.addActionListener(this);
		b2.addActionListener(this);
		// Instantiation of TextField
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		t4 = new JTextField(10);
		t5 = new JTextField(10);
		// Setting Colour
		b2.setBackground(Color.WHITE);
		b1.setBackground(Color.WHITE);
		l.setForeground(Color.BLACK);
		l7.setForeground(Color.BLACK);
		l8.setForeground(Color.BLACK);
		b2.setForeground(Color.BLACK);
		// Instantiation of Panels
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		p9 = new JPanel();
		// Adding Components to Panels
		p1.add(l);
		p2.add(l2);
		p2.add(t1);
		p3.add(l3);
		p3.add(t2);
		p4.add(l4);
		p4.add(t3);
		p5.add(l5);
		p5.add(t4);
		p9.add(b1);
		p6.add(l6);
		p6.add(t5);
		p7.add(b2);
		p8.add(l7);
		p8.add(l10);
		p8.add(l8);
		// Adding Panels to Frame
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p7);
	}

	// Interface Implementation
	@Override
	public void actionPerformed(ActionEvent e) {
		int a, b, c, d;
		double s = 0;
		// Button Implement
		if (e.getSource() == b2) {
			// Taking input as Zero if Text field is empty
			if (t1.getText().isEmpty())
				a = 0;
			else
				a = Integer.parseInt(t1.getText());

			if ((t2.getText()).isEmpty())
				b = 0;
			else
				b = Integer.parseInt(t2.getText());

			if (t3.getText().isEmpty())
				c = 0;
			else
				c = Integer.parseInt(t3.getText());

			if (t4.getText().isEmpty())
				d = 0;
			else
				d = Integer.parseInt(t4.getText());

			if (a > 20 || a < 0) {
				JOptionPane.showMessageDialog(this, "IA-1 marks Invalid", "error", JOptionPane.ERROR_MESSAGE);
				t1.setText("");
				return;
			}
			// Checking Invalid Marks Entering
			if (b > 20 || b < 0) {
				JOptionPane.showMessageDialog(this, " IA-2 marks invalid", "error", JOptionPane.ERROR_MESSAGE);
				t2.setText("");
				return;
			}

			if (c > 20 || c < 0) {
				JOptionPane.showMessageDialog(this, "IA-3 marks Invalid", "error", JOptionPane.ERROR_MESSAGE);
				t3.setText("");
				return;
			}
			if (d > 10 || d < 0) {
				JOptionPane.showMessageDialog(this, "entered invalid CTA marks", "error", JOptionPane.ERROR_MESSAGE);
				t4.setText("");
				return;
			}
			if (b >= a && c >= a) {
				r = b + c + d;
			} else if (a >= b && c >= b) {
				r = a + c + d;
			} else {
				r = a + b + d;
			}

			try {
				if (r < 20) {
					throw new Exception(); // Exception Handling
				}
			} catch (Exception ae) {
				JOptionPane.showMessageDialog(this, "Student is Detained for SEE", "message",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		setBounds(0, 0, 599, 499); 

		add(p6);
		add(p9);
		add(p8);

		if (e.getSource() == b1) {

			if (t5.getText().isEmpty())
				s = 0;
			else
				s = Integer.parseInt(t5.getText());

			if (s > 100 || s < 0) {
				JOptionPane.showMessageDialog(this, "SEE marks Invalid", "error", JOptionPane.ERROR_MESSAGE);
				t5.setText("");
				l8.setText("");
				l7.setText("");
				return;
			}
			String g;

			if (s < 38) {
				l8.setText("Grade: F");
				l7.setText("");
				// add(p8);
				setBounds(0, 0, 597, 497);
				return;
			}
			if (s == 38 || s == 39) {
				s = 40;
			}

			s = (s / 2);
			x = (int) Math.ceil(s);
			res = r + x;
			// Grade Calculation
			if (res <= 100 && res >= 90)
				g = "S";

			else if (res < 90 && res >= 80)
				g = "A";

			else if (res < 80 && res >= 70)
				g = "B";

			else if (res < 70 && res >= 60)
				g = "C";
			else if (res < 60 && res >= 50)
				g = "D";
			else if (res < 50 && res >= 40)
				g = "E";
			else
				g = "F";

			l7.setText("Total Marks: " + res);
			;
			l8.setText("Grade: " + g);
			setBounds(0, 0, 598, 498);
		}
	}
}

public class IaMarks {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		CTAActivity c = new CTAActivity();
		c.setVisible(true);
		c.setBounds(0, 0, 500, 400);
		c.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		c.setLayout(new GridLayout(10, 0));
		return;
	}
}
