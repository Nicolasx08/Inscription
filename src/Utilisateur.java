import javafx.scene.control.RadioButton;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.awt.*;

public class Utilisateur {
    TextField nom;
    TextField nomDeFamille;
    TextField nomUtilisateur;
    TextField Mdp;
    TextField Cmdp;
    String genre;
    SpinnerValueFactory age;

    public TextField getNom() {
        return nom;
    }

    public void setNom(TextField nom) {
        this.nom = nom;
    }

    public TextField getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(TextField nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public TextField getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(TextField nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public TextField getMdp() {
        return Mdp;
    }

    public void setMdp(TextField mdp) {
        Mdp = mdp;
    }

    public TextField getCmdp() {
        return Cmdp;
    }

    public void setCmdp(TextField cmdp) {
        Cmdp = cmdp;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public SpinnerValueFactory getAge() {
        return age;
    }

    public void setAge(SpinnerValueFactory age) {
        this.age = age;
    }
}
