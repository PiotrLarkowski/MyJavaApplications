package PACKAGE;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Opcje  extends JDialog implements ActionListener
{
	public JButton bWyjœcie;
	public JLabel lLewaGranica, lPrawaGranica, lTechnika, lWybórLiczb, lWiadomosc;
	public static int Bitowosc;
	public JComboBox BitCombo;
	public String BIT = "32";
	
	public Opcje(JFrame owner)
	{
		super(owner, "Informacje", true);
		setSize(400,200);
		setLayout(null);
		
		bWyjœcie = new JButton("Zaakceptuj");
		bWyjœcie.setBounds(260, 100, 100, 20);
		add(bWyjœcie);
		bWyjœcie.addActionListener(this);
		
		lWybórLiczb = new JLabel("Opcje przedzia³u liczb pierwszych");
		lWybórLiczb.setBounds(50, 20, 500, 20);
		lWybórLiczb.setFont(new Font("SansSerif", Font.BOLD, 16));
		add(lWybórLiczb);
		
		lLewaGranica = new JLabel("Podaj wartoœæ bitow¹ liczby: ");
		lLewaGranica.setBounds(10, 50, 2000, 20);
		add(lLewaGranica);
		
		lWiadomosc = new JLabel();
		lWiadomosc.setBounds(220,80,1000,20);
		add(lWiadomosc);
		
		BitCombo = new JComboBox();
		BitCombo.setBounds(40,100, 50, 20);
		BitCombo.addItem("32");
		BitCombo.addItem("64");
		BitCombo.addItem("128");
		BitCombo.addItem("256");
		BitCombo.addItem("512");
		BitCombo.addItem("1024");
		add(BitCombo);
		BitCombo.addActionListener(this);
	}
	
	public static int getBit()
	{
		return(Bitowosc);
	}
	
	public static void main(String[] args)
	{
		Opcje okienko = new Opcje(null);
		okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okienko.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		Object z = e.getSource();
		
		if(z == bWyjœcie)
		{
			Bitowosc = Integer.valueOf(BIT);
			setVisible(false);
			Okno_Glowne.setBit(Bitowosc);
		}
		else if(z == BitCombo)
		{
			BIT = BitCombo.getSelectedItem().toString();
		}
	}
}