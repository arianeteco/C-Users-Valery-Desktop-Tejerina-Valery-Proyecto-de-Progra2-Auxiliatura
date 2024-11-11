package juegoTrika;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Casilla extends JButton{
	private static boolean turnoJugadorUno = true;
	private static boolean ganar, empate=false;
	
	private static String simbolo;
	
	public Casilla () {
		this.setFont(new Font("Arial", Font.BOLD, 100));
		this.setBackground(Color.CYAN);
		
	}
	public static void logicaJuego(Casilla[][] casillas, Casilla c) {
		
		pintarCasilla(c);
		compruebaLinea(casillas);
		compruebaColumna(casillas);
		compruebaDiagonal(casillas);
		compruebaEmpate(casillas);
		
	}
	private static void compruebaEmpate(Casilla[][] casillas) {
		empate = true;

		for(Casilla []arrayCasillas: casillas) {
			for (Casilla c:arrayCasillas) {
				if(c.getText().equals("")) empate=false;
			}
		}
		if(empate) ganar ("Es un empate.");
	}
	private static void compruebaDiagonal(Casilla[][] casillas) {
		ganar=true;
		simbolo=casillas[0][0].getText();
		if(!simbolo.equals("")) {
			for(int i=1; i<casillas.length; i++) {
				if (!simbolo.equals(casillas[i][i].getText())) ganar=false;
			}
			if(ganar) ganar("ha ganado el jugador " + simbolo);
		}
		ganar=true;
		simbolo=casillas[0][2].getText();
		if(!simbolo.equals("")) {
			for(int i=1, j=1; i<casillas.length; i++, j--) {
				if (!simbolo.equals(casillas[i][j].getText())) ganar=false;
			}
			if(ganar) ganar("ha ganado el jugador " + simbolo);
		}
	}
	
	private static void compruebaColumna(Casilla[][] casillas) {
		for(int j=0; j<casillas.length; j++) {
			ganar=true;
			simbolo=casillas[0][j].getText();
			if(!simbolo.equals("")) {
				for(int i=0; i<casillas[0].length; i++) {
					if (!simbolo.equals(casillas[i][j].getText())) ganar=false;
				}
				if(ganar) ganar("ha ganado el jugador " + simbolo);
				
			}
		}
	
		
	}
	private static void compruebaLinea(Casilla[][] casillas) {
		for(int i=0; i<casillas.length; i++) {
			ganar=true;
			simbolo=casillas[i][0].getText();
			if(!simbolo.equals("")) {
				for(int j=0; j<casillas[0].length; j++) {
					if (!simbolo.equals(casillas[i][j].getText())) ganar=false;
				}
				if(ganar) ganar("ha ganado el jugador " + simbolo);
				
			}
		}
			
	}
	private static void ganar(String s) {
		JOptionPane.showMessageDialog(null,s);
		System.exit(0);
		
		
	}
	private static void pintarCasilla( Casilla c) {
		if(turnoJugadorUno) {
			c.setText("X");
			turnoJugadorUno=false;
			c.setEnabled(false);
		}else {
			c.setText("O");
			turnoJugadorUno=true;
			c.setEnabled(false);
		}
		
		
	}

}
