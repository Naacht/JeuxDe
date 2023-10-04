package Autre;
import java.lang.Math;
public class JeuDé {

	public static void main(String[] args) throws InterruptedException {


				// Définir les joueurs
				String player1, player2;
				player1 = Saisie.lire_String("Saisir le nom du premier joueur : ");
				player2 = Saisie.lire_String("Saisir le nom du deuxième joueur : ");
				
				// Les noms qui s'affrontent
				System.out.println(player1 + " vs " + player2);
				System.out.println("[-----------------]");
				
				
				// Définir qui commence
				int min = 1;
				int max = 2;
				int range = max - min + 1;
				int start = (int) (Math.random() * range) + min;
				
				// Définir le commencement
				boolean commence1 = false;
				boolean commence2 = false;
				
				// Si c'est joueur 1 qui commence
				if (start == 1) {
					System.out.println("Le joueur qui commence est : " + player1);
					System.out.println("[-----------------]");
					commence1 = true;
					commence2 = false;
					// Sinon c'est le joueur 2
				} else {
					System.out.println("Le joueur qui commence est : " + player2);
					System.out.println("[-----------------]");
					commence1 = false;
					commence2 = true;
				}
				// Ralentir le run a chaque message
				Thread.sleep(3000);

				// Définir les scores des joueurs
				int scorep1 = 0;
				int scorep2 = 0;
				
				// Répéter jusqu'a que la game soit true
				boolean game = false;

				// Mise en place des dés
				while (game == false) {
					for (int c = 0; c < 1; c++) {
						var dé1 = (int) (Math.random() * 6 + 1);
						var dé2 = (int) (Math.random() * 6 + 1);
						
						// Joueur 1 qui commence
						if (commence1 == true) {
							scorep1 = scorep1 + dé1;
							System.out.println(" ") ;
							System.out.println("Le joueur " + player1 + " a obtenu le dé : " + dé1);
							System.out.println("Le score du joueur " + player1 + " est a : " + scorep1);
							System.out.println(" ") ;
							System.out.println("[-----------------]");
							
							
							Thread.sleep(3000);
							
							// Si le score du joueur 1 atteint 30
							if (scorep1 >= 30 && scorep1 >= scorep2) {
								System.out.println(" ") ;
								// Annonce du gagnant
								System.out.println("Vainqueur du jeu est : " + player1) ;
								game = true;
								
								// Le joueur 1 recommence si le dé obtenue est 6
							} else if (dé1 == 6) {
								System.out.println(" ") ;
								System.out.println("Le joueur " + player1 + " a obtenu 6, il peut rejouer") ;
								// Le joueur 1 recommence et le joueur 2 ne joue pas
								commence1 = true ;
								commence2 = false ;
								// Le joueur 1 a joué et donc c'est au tour du joueur 2
							} else {
								commence1 = false;
								commence2 = true;
								}
							}
						
						// Commencement du joueur 2
						if (commence2 == true) {
							scorep2 = scorep2 + dé2;
							System.out.println(" ") ;
							System.out.println("Le joueur " + player2 + " a obtenu le dé : " + dé2);
							System.out.println("Le score du joueur " + player2 + " est a : " + scorep2);
							System.out.println(" ") ;
							System.out.println("[-----------------]");
							
							
							Thread.sleep(3000);
							
							// Si le score du joueur 2 atteint 30
							if (scorep2 >= 30 && scorep2 >= scorep1) {
								System.out.println(" ") ;
								// Annonce du gagnant
								System.out.println("Vainqueur du jeu est : " + player2) ;
								game = true ;
							
								// Si le joueur 2 obtient un 6
							} else if (dé2 == 6) {
								System.out.println(" ") ;
								System.out.println("Le joueur " + player2 + " a obtenue 6, il peut rejouer") ;
								// Le joueur 1 ne joue pas et le joueur 2 rejoue
								commence1 = false ;
								commence2 = true ;
								
							} else {
							commence1 = true;
							commence2 = false;
							}
						}
					}
				}
			}

	}
