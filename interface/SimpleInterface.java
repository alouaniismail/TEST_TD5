//import tec.Vehicule;//(transparent a l'utilisateur)
//les fichiers tests on les inclus dans le package
//pour ne pas faire avoir a cette situation
//mais le code client exploitateur qui a un BUT
//qui est important.(il en as pas besoin(voir le fichier))

import tec.Transport;

//import tec.Passager;

import tec.Usager;
import tec.FabriqueTec;
//import tec.Autobus;

//import tec.PassagerStandard;

//On les enleve ici.
//On enleve meme les autres ; car::
//les deux classes concretes sont internes au paquetage soit un appel
//ne sert à rien. 
//import tec.Usager et import tec.Transport restent. 

class SimpleInterface {

  /*
   * Affiche l'etat des deux instances passees en parametre.
   * La methode println(Object x) de la classe PrintWriter 
   * declenche la methode toString() sur l'objet passe 
   * en parametre (x.toString()) et affiche la chaine 
   * de caracteres obtenue..
   */
  static private void deboguerEtat (Transport t, Usager p) {
    System.out.println(p);
    System.out.println(t);
  }
    //elle instancie , mais le but:
    //est que qu'elle ait pas acces aux methodes declarees
    //dans les interfaces internes au paquetage...

  static public void main (String[] args) {
    Transport serenity = FabriqueTec.faireAutobus(1, 2);

    /*Passager teste=new PassagerStandard("tester",6);*/

    //meme avec import tec.Passager ca ne marche pas (et le deuxieme import
    //aussi).
    
    //erreur; pas acces aux methodes internes
    //soit les methodes
    //des 2 classes abstraites.(meme une declaration Passager=... au tl
    //est une erreur) contrairement a avant.
    
    Usager kaylee = FabriqueTec.fairePassagerStandard("Kaylee", 4);
    Usager jayne = FabriqueTec.fairePassagerStandard("Jayne", 4);
    Usager inara = FabriqueTec.fairePassagerStandard("Inara", 5);

    //0
    System.out.println(serenity);

    serenity.allerArretSuivant();
    //1
    kaylee.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);

    serenity.allerArretSuivant();
    //2
    jayne.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);

    serenity.allerArretSuivant();
    //3
    inara.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //4
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //5
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
    //System.out.println(inara.estDehors());
    //test de la portée limitée des méthodes.
  }
}

/* Resultat de l'execution: 
[arret 0] assis<1> debout<2>
[arret 1] assis<0> debout<2>
Kaylee <assis>
[arret 2] assis<0> debout<1>
Kaylee <assis>
Jayne <debout>
[arret 3] assis<0> debout<0>
Kaylee <assis>
Jayne <debout>
Inara <debout>
[arret 4] assis<1> debout<1>
Kaylee <endehors>
Jayne <endehors>
Inara <debout>
[arret 5] assis<1> debout<2>
Kaylee <endehors>
Jayne <endehors>
Inara <endehors>
*/

