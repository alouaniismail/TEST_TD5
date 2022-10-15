package tec;
/**
 * Cette classe représente la position d'un passager par rapport à un transport.
 * Une position a trois états possibles : assis dans un transport,
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2019
 **/
class Position {

  // private static final int DEHORS = 1;
  // private static final int ASSIS = 2;
  // private static final int DEBOUT = 3;
  private static final Position Assis = new Position();
  private static final Position Debout = new Position();
  private static final Position Dehors = new Position();

  // private final int courant;

  /**
   * construit une l'instance dans la position dehors.
   * 
   */
  // public Position() {
  // courant = DEHORS;
  // }

  /**
   * Construit une instance en précisant une des positions du passager.
   * 
   * @param e valeur d'une des positions.
   */
  // private Position() {
  // }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
    return this == Position.Dehors;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    return this == Position.Assis;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    return this == Position.Debout;
  }

  /**
   * La position est-elle assis ou debout ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    return this != Position.Dehors;
  }

  /**
   * Retourne une instance de Position assis.
   *
   * @return instance dans l'état assis.
   */
  public static Position assis() {
    return Position.Assis;
  }

  /**
   * Retourne une instance de Position debout.
   *
   * @return instance dans l'état debout.
   */
  public static Position debout() {
    return Position.Debout;
  }

  /**
   * Retourne une instance de Position dehors.
   *
   * @return instance dans l'état dehors.
   */
  public static Position dehors() {
    return Position.Dehors;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une
   * chaîne de caractères correspondant à l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   */
  @Override
  public String toString() {
    String nom = null;
    if (estDehors())
      nom = "endehors";
    else if (estAssis())
      nom = "assis";
    else if (estDebout())
      nom = "debout";
    return "<" + nom + ">";
  }
}
