package testGridBag;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class TestGridBag {
	static Frame f;
	static GridBagLayout gridBag;
	static GridBagConstraints gbc;
	
	static void adauga(Component comp,int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		
		gridBag.setConstraints(comp, gbc);
		f.add(comp);
	}
	
	public static void main(String args []){
		f = new Frame("Test");
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        System.exit(0);
		    }});
		gridBag = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		gbc.insets = new Insets(5, 5, 5, 5);
		f.setLayout(gridBag);
		
		Label mesaj = new Label("Evidenta persoane",Label.CENTER);
		
		mesaj.setFont(new Font("Arial",Font.BOLD,24));
		mesaj.setBackground(Color.yellow);
		gbc.fill = GridBagConstraints.BOTH;
		adauga(mesaj, 0,0,4,2);
		
		Label nume = new Label("Nume: ");
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		adauga(nume, 0, 2, 1, 1);
		
		Label salariu = new Label("Salariu: ");
		adauga(salariu, 0, 3, 1, 1);
		
		TextField txtNume = new TextField("",30);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		adauga(txtNume, 1,2,2,1);

		TextField txtSalariu = new TextField("",30);
		adauga(txtSalariu, 1,3,2,1);
		
		Button salvare = new Button("Salvare");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		adauga(salvare, 1,4,1,1);

		Button iesire = new Button("Iesire");
		iesire.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);	
			}
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		gbc.fill = GridBagConstraints.HORIZONTAL;
		adauga(iesire, 2,4,1,1);
		f.pack();
		f.show();
	}
}
