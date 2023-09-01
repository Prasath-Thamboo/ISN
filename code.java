package ISN;

public class calcul_mental implements Runnable {
	

	static int a; // une variable declar�e static est utilisable pour dire qu'une variable est identique dans tout le code

	static int b;
	static int calc = 0;
	static int res = 0;
	static int oper = 0;
	static int pts_gagne = 0;
	static int nb_oper = 10;
	static int niveau=0;
	
	/* Cette fonction initialise les variables du jeu.
	 * Elle sera utile si on veut recommancer une nouvelle partie automatiquement.
	 */
	public static void initialiseJeu(){
		calc = 0;
		res = 0;
		pts_gagne = 0;
		nb_oper = 10;
	
	}

	
	/* Cette fonction teste si la r�ponse entr�e par l'utilisateur est correcte ou pas.
	 * Elle affiche ensuite "1
	 * " ou "FAUX" avec le bon r�sultat.
	 */
	public static void testValeur(){
		if (res == calc) {
			Interface.resultat.setText("BRAVO !");
			//System.out.println(" BRAVO");
			pts_gagne++;
		} else {
			Interface.resultat.setText("Faux, la r�ponse �tait : " + Interface.calcul.getText() +" "+ calc);
			//System.out.println("FAUX");
			//System.out.println("    La r�ponse est  " + calc);

		}
	}
	
	/* Cette fonction g�re les diff�rentes phases du jeu.
	 * Gestion du score.
	 * Gestion du nombre de tours jou�.
	 * Cr�ation des valeurs pour les calcules...
	 */
	public static void jouer() {
		initialiseJeu(); 
		while (nb_oper != 0) { // Gestion du nombre de tours jou�. Et on fait �a dans n'importe quel cas (+,-,* ou /)
			nb_oper--;  // Gestion du nombre de tours jou�. Et on fait �a dans n'importe quel cas (+,-,* ou /)
			
			if(oper!=4){ // Si le joueur choisit tous sauf la division alors pour (+,- et *) on fait toujours presque la m�me chose.
				a = (int) (Math.random() * niveau); //on fait toujours �a pour le +,- et le *
				b = (int) (Math.random() * niveau); //on fait toujours �a pour le +,- et le *
			
				
				
				// Ici il faut faire attention car le calcule sera diff�rent en fonction de si le joueur a choisit (+,- ou *)
				if (oper == 1) {
					Interface.calcul.setText(""+a);
					//System.out.print(a); //on fait toujours �a pour le +,- et le *
					calc = a + b;
					Interface.calcul.setText(Interface.calcul.getText()+"+");
					//System.out.print("+");
				} else if (oper==2){
					if(b > a){ // pour �viter d'avoir des resultats n�gatifs.
						int temp = a;
						a=b;
						b=temp;
					}
					Interface.calcul.setText(""+a);
					//System.out.print(a); 
					calc = a - b;
					Interface.calcul.setText(Interface.calcul.getText()+"-");
					//System.out.print("-");
				} else if (oper==3){
					Interface.calcul.setText(""+a);
					//System.out.print(a);
					calc = a * b;
					Interface.calcul.setText(Interface.calcul.getText()+"x");
					//System.out.print("x");
				} 			
				//On sort du IF et saute le "else" pour aller....
				
			} else { // Ici c'est le cas ou le joueur a choisit la division. Car oper sera forcement �gale � 4.
				do { //Obliger � avoir un r�sulat de la divison entre a et b �gale � un entier
				a = (int) (Math.random() * niveau);
				b = (int) (Math.random() * niveau);
				} while (b==0 || a<b || (a % b) != 0 ); // Si b=0 (division interdite) ou si a < b (Donnera des 0,xxx) ou si le reste de la division entre a et b est diff�rent de 0 alors on retire au sort a et b 
				calc = a  / b;
				Interface.calcul.setText(""+a);
				//System.out.print(a);
				Interface.calcul.setText(Interface.calcul.getText()+"/");
			}
			
			//........ ICI !!!!
			

			Interface.calcul.setText(Interface.calcul.getText()+b);
			//System.out.print(b); //on fait �a dans n'importe quel cas (+,-,* ou /)
			Interface.calcul.setText(Interface.calcul.getText()+"=");
			//System.out.print("="); //on fait �a dans n'importe quel cas (+,-,* ou /)
			
			System.out.println("Entrez votre r�sultat: ");
			res = Isn.readInt();
			testValeur(); //on fait �a dans n'importe quel cas (+,-,* ou /)
		}
		
		//System.out.println(" \nVotre score " + pts_gagne + "/" + 10); //on fait �a dans n'importe quel cas (+,-,* ou /)
		Interface.zoneInfos.append("\n\nVotre score " + pts_gagne + "/" + 10);
		Interface.zoneInfos.append("\n\nPour rejouer, appuyez sur le boutton\n\"Relancer\" puis suivre \nles instructions 1) et 2).");
	}
	
	
	@Override
	public void run() {
		jouer();
		
	}
}