package ISN;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.*;


public class Interface {
	static JFrame fenetre; 
	static JPanel panneauG;
	static JTextArea zoneInfos;
	static JPanel panneauBasgauche;
	static JLabel calcul;
	static JLabel resultat;
	static JPanel panneauD;
	static JButton demmarer;
	static JButton relancer;
	static JButton addition;
	static JButton soustraction;
	static JButton multiplication;
	static JButton division;
	static JSlider slider;
	

	//Cette fonction cr�e la fenetre du jeu en fixant des param�tres (ex: taille de fen�tre...)
	public static void creeFenetre(){
		fenetre= new JFrame("Calcul mental"); //Cr�ation de la fen�tre
		fenetre.setLocationRelativeTo(null); // Le programme prendra la taille de la fenetre meme si on 
		fenetre.setSize(500, 500); // La taille de la fen�tre sera 500 pixels * 500 pixels
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quand je clique sur la croix(blanche en haut � droite) de la fenetre elle se ferme
		fenetre.setLayout(new GridLayout(1,2)); // La disposition de la fen�tre sera une grille avec une ligne et de deux colones
		fenetre.setResizable(false); // Rend la impossible � agrandir.
	}

	//Cette fonction cr�e la partie Gauche de la fen�tre du jeu
	public static void creePartieGauche() {
		// PARTIE GAUCHE DE L'ECRAN
		panneauG = new JPanel();  // Cr�ation d'un panneau dans lequel on va mettre nos composants (zone de texte ...)
		panneauG.setBackground(Color.WHITE); // Met la couleur du panneau en Blanc. 
		panneauG.setLayout(new GridLayout(2,1)); // La disposition du panneau Gauche sera une grille avec  deux lignes et une colonne 
				
		zoneInfos = new JTextArea(10,20); // Cr�ation d'un zone de text. Elle permettra d'afficher des informations comme (Comment lancer/rejouer une partie, le resulat de la partie et m�me d'autre informations)
		zoneInfos.setBorder(BorderFactory.createTitledBorder("Informations")); //Ajoute un titre et entoure la zonne de texte d'une ligne (Bordure)
		zoneInfos.setEditable(false); // La zone de texte sera pas modifiable par l'utilisateur.
		zoneInfos.append("1) Choisir le type d'op�ration et le niveau.\n2) Appuyez sur le boutton \"D�mmarer jeu\"."); // Affiche dans la zone de texte d�s le lancement : Comment lancer une partie. 
		
		panneauG.add(zoneInfos); //Ajoute la zone de texte au panneau gauche.

		panneauBasgauche = new JPanel(); // Cr�ation d'un sous panneau Gauche (PanneaubasGauche)
		panneauBasgauche.setLayout(new BorderLayout()); // La disposition de panneau sera de type BorderLayout (Voir Google Image).
		panneauBasgauche.setBackground(Color.WHITE); // Met la couleur du panneau en Blanc. 

		calcul = new JLabel(""); // Cr�ation d'un label (attention il affiche du texte aussi mais c'est pas pareil qu"un  JTextArea) qui va afficher le calcul. Au d�part on affiche rien.
		calcul.setBorder(BorderFactory.createTitledBorder("Calculez")); //Ajoute un titre et entoure le label d'une ligne (Bordure)
		panneauBasgauche.add(calcul, BorderLayout.NORTH); // Place le label calcul au nord par rapport � la disposition du BorderLayout (voir Google Image)


		resultat = new JLabel(""); // Cr�ation d'un label (attention il affiche du texte aussi mais c'est pas pareil qu"un  JTextArea) qui va afficher le resultat. Au d�part on affiche rien.
		resultat.setBorder(BorderFactory.createTitledBorder("R�sultat: ")); //Ajoute un titre et entoure le label d'une ligne (Bordure)
		panneauBasgauche.add(resultat, BorderLayout.CENTER); // Place le label calcul au centre par rapport � la disposition du BorderLayout (voir Google Image)

		panneauG.add(panneauBasgauche); //Ajoute le panneauBasgauche au panneau Gauche.
	}

	//Cette fonction cr�e la partie DROITE de la fen�tre du jeu
	public static void creePartieDroite() {
		// PARTIE DROITE DE L'ECRAN
		panneauD = new JPanel(); // Cr�ation d'un panneau dans lequel on va mettre nos composants (Boutons et le curseur)
		panneauD.setLayout(new GridLayout(1,2));  // La disposition de la fen�tre sera une grille avec une ligne et de deux colones
		panneauD.setBackground(Color.WHITE); // Met la couleur du panneau en Blanc. 

		// PARTIE DROITE GAUCHE
		JPanel panneauActions = new JPanel(); // Cr�ation d'un sous panneau actions
		panneauActions.setBackground(Color.WHITE);// Met la couleur du panneau en Blanc. 
		panneauActions.setBorder(BorderFactory.createTitledBorder("Actions"));  //Ajoute un titre et entoure le paneauActions d'une ligne (Bordure)
		demmarer = new JButton("D�mmarer jeu"); // Cr�ation d'un bouton avec comme titre "D�mmarrer jeu".  PS Le titre sera afficher � l'�cran
		relancer =  new JButton("Relancer jeu"); // Cr�ation d'un bouton avec comme titre "Relancer jeu". 
		panneauActions.add(demmarer); //Ajoute le bouton demmarrer au panneau Action
		panneauActions.add(relancer); //Ajoute le bouton relancer au panneau Action

		//PARTIE DROITE DROITE
		JPanel panneauReglage = new JPanel(); //Cr�ation d'un sous panneau R�glage
		panneauReglage.setLayout(new GridLayout(2,1));

		JPanel panneauOper = new JPanel(); //Creation d'un sous panneai Op�ration
		panneauOper.setBackground(Color.WHITE); // Met la couleur du panneau en Blanc. 
		panneauOper.setBorder(BorderFactory.createTitledBorder("Op�rations")); //Ajoute un titre et entoure le panneau op�ration d'une ligne (Bordure)


		addition= new JButton("Addition"); //Cr�ation d'un bouton pour le +
		soustraction=new JButton("Soustraction"); //Cr�ation d'un bouton pour le -
		multiplication=new JButton("Multiplication"); //Cr�ation d'un bouton pour le *
		division=new JButton("Division"); //Cr�ation d'un bouton pour le /

		panneauOper.add(addition); //Ajout le bouton au panneau op�ration 
		panneauOper.add(soustraction); //Ajout le bouton au panneau op�ration 
		panneauOper.add(multiplication);//Ajout le bouton au panneau op�ration 
		panneauOper.add(division);//Ajout le bouton au panneau op�ration 

		panneauReglage.add(panneauOper); //ajout le panneau Op�ration au panneau r�glage

		slider = new JSlider(JSlider.VERTICAL,1,3,1); /* Cr�ation du curseur vertical pour que le joueur indique le niveau des calculs avec comme valeur min=1, max=3 et par defaut (Au lancement) la valeur 
		du curseur sera �gale � 1 */
		slider.setBackground(Color.WHITE); // Met la couleur du panneau en Blanc. 
		slider.setBorder(BorderFactory.createTitledBorder("Niveaux")); //Ajoute un titre et entoure le curseur d'une ligne (Bordure)
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>(); //D 'ici
		labelTable.put( new Integer( 1 ), new JLabel("1") );
		labelTable.put( new Integer( 2 ), new JLabel("2") );
		labelTable.put( new Integer( 3 ), new JLabel("3") );
		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true); // A ICI, �a permet d'afficher les valeurs (1,2 et 3)  du cuseur sur l'�cran. Sinon on ne fait pas �a il n'affichera pas les valeurs � cot� du curseur.
		panneauReglage.add(slider); //Ajoute le cuseur au panneau R�glage

		panneauD.add(panneauActions); //Ajoute le panneau Actions le panneau droit.
		panneauD.add(panneauReglage); // Ajoute le panneau R�glage dans le panneau droit.
		
		ajouteActionBouttons(); 
	}

	// Cette fonction permet de d�finir les actions que doit faire le programme quand l'utilisateur clique sur un boutton.
	public static void ajouteActionBouttons() {
		// Quand l'utilisatuer clique sur le botton "D�mmarre jeu" 
		demmarer.addActionListener(new ActionListener() {
			@Override
			//A chaque fois que l'utilisateur clique sur le bouton d�mmarer, cette fonction est appel�e.
			public void actionPerformed(ActionEvent e) {
				/* Pour �vit� que l'utilisateur change de type d'op�ration au cours de la partie on d�active tous les autres types d'op�rations pendant la partie.
				Et on les r�active quand il relance le jeu. Si l'utilisateur n'a choisit aucun type d'op�ration et qu'il lance une partie (se fils de pute) bas on lui affiche un message dans la zone de texte */
				if(calcul_mental.oper==1){
					soustraction.setEnabled(false);
					multiplication.setEnabled(false);
					division.setEnabled(false);
				}else if (calcul_mental.oper==2){
					addition.setEnabled(false);
					multiplication.setEnabled(false);
					division.setEnabled(false);
				}else if (calcul_mental.oper==3){
					addition.setEnabled(false);
					soustraction.setEnabled(false);
					division.setEnabled(false);
				}else if (calcul_mental.oper==4){
					addition.setEnabled(false);
					soustraction.setEnabled(false);
					multiplication.setEnabled(false);
				} else {
					zoneInfos.append("\n\nVeuillez choisir un type d'op�ration !!!"); // S'il n'a pas choisit un type d'op�ration alors on lui affiche dans la zone de texte un message.
					return;
				}
				slider.setEnabled(false); /* Ici pareil on rend le cursuer inchangable pendant la partie pour �viter les triches. 
				Et on le rendra changable quand il relancera une partie. Par defaut le niveau (le slider) sera de 1. */
				
				/*Ici en fonction du niveau choisit, la valeur de l'interval des nombres propos�s dans les calculs seront diff�rentes. 
				Par exemple, si l'utilisateur choisit niveau 3 alors les valeurs seront entre 0 et 100 */
				if (slider.getValue()== 1){
					calcul_mental.niveau=10;
				} else if (slider.getValue() ==2){
					calcul_mental.niveau=50;			
				}else {
					calcul_mental.niveau =100;
				}
				
				demmarer.setEnabled(false); // Pour �viter que l'utilisateur (ste con) lance deux fois de suite une partie, on d�active ce bon jusqu'� qu'il relance une partie 
				//Lancement de la partie en arri�re plan. Au premier plan c'est l'interface graphique qui tourne.
				Thread monTread = new Thread(new calcul_mental());
				monTread.start(); //Lancement de la partie.
			}
		});
		
		//A chaque fois que l'utilisateur clique sur le bouton relancer, cette fonction est appel�e.
		relancer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcul.setText(""); //Efface ce qui est affich� dans le label calcul
				resultat.setText("");//Efface ce qui est affich� dans le label calcul
				zoneInfos.setText("1) Choisir le type d'op�ration et le niveau.\n2) Appuyez sur le boutton \"D�mmarer jeu\"."); // Affiche dans la zone de texte d�s le lancement : Comment lancer une partie. 
				Interface.slider.setEnabled(true); //rend le curseur modifiable
				Interface.demmarer.setEnabled(true); // rend le bouton d�mmarer cliquable
				addition.setEnabled(true); // rend le bouton + cliquable
				soustraction.setEnabled(true); // rend le bouton - cliquable
				multiplication.setEnabled(true); // rend le bouton * cliquable
				division.setEnabled(true); // rend le bouton / cliquable
			}
		});
		
		addition.addActionListener(new ActionListener() {
			//A chaque fois que l'utilisateur clique sur le bouton Addition, cette fonction est appel�e.
			@Override
			public void actionPerformed(ActionEvent e) {
				calcul_mental.oper=1;
			}
		});

		soustraction.addActionListener(new ActionListener() {
			//A chaque fois que l'utilisateur clique sur le bouton Soustraction, cette fonction est appel�e.
			@Override
			public void actionPerformed(ActionEvent e) {
				calcul_mental.oper=2;
			}
		});
		multiplication.addActionListener(new ActionListener() {
			//A chaque fois que l'utilisateur clique sur le bouton multplication, cette fonction est appel�e.
			@Override
			public void actionPerformed(ActionEvent e) {
				calcul_mental.oper=3;
			}
		});
		division.addActionListener(new ActionListener() {
			//A chaque fois que l'utilisateur clique sur le bouton Division, cette fonction est appel�e.
			@Override
			public void actionPerformed(ActionEvent e) {
				calcul_mental.oper=4;
			}
		});
		
	}

	public static void main(String[] args) {
		creeFenetre(); 
		creePartieGauche(); 
		creePartieDroite();
		fenetre.add(panneauG); //Ajoute le panneau Gauche � la fen�tre
		fenetre.add(panneauD); //Ajoute le panneau Droit � la fen�tre
		fenetre.setVisible(true); //Affiche la fen�tre
	}
}
