import javafx.scene.control.RadioButton;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.awt.*;

public class Utilisateur {
    String nom;
    String nomDeFamille;
    String nomUtilisateur;
    String Mdp;
    String Cmdp;
    String genre;
    int age;
    byte MdpCharactere[];

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String mdp) {
        Mdp = mdp;
    }

    public String getCmdp() {
        return Cmdp;
    }

    public void setCmdp(String cmdp) {
        Cmdp = cmdp;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte[] getMdpCharactere() {
        return MdpCharactere;
    }

    public void setMdpCharactere(byte[] mdpCharactere) {
        MdpCharactere = mdpCharactere;
    }
}
