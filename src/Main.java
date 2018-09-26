import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class Main extends Application {

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) {

        stage.setWidth(700);
        stage.setHeight(900);

        Label nomUtilisateur = new Label("Nom d'utilisateur");
        nomUtilisateur.setPrefSize(100,20);
        nomUtilisateur.setTranslateX(300);
        nomUtilisateur.setTranslateY(360);

        TextField username = new TextField();
        username.setPromptText("Username");
        username.setTranslateX(300);
        username.setTranslateY(380);

        Label password = new Label("Password");
        password.setPrefSize(100,20);
        password.setTranslateX(300);
        password.setTranslateY(420);

        PasswordField mdp = new PasswordField();
        mdp.setPromptText("Quelle est le mot de passe?");
        mdp.setTranslateX(300);
        mdp.setTranslateY(440);

        Label Iprenom = new Label("Prénom");
        Iprenom.setTranslateY(20);
        Iprenom.setTranslateX(300);
        Iprenom.setPrefSize(100,20);

        TextField Ipre = new TextField();
        Ipre.setTranslateX(300);
        Ipre.setTranslateY(40);
        Ipre.setPromptText("Prénom");

        Label INDF = new Label("Nom de famille");
        INDF.setPrefSize(100,20);
        INDF.setTranslateX(300);
        INDF.setTranslateY(80);

        TextField INomDeFamille = new TextField();
        INomDeFamille.setPromptText("Nom de famille");
        INomDeFamille.setTranslateY(100);
        INomDeFamille.setTranslateX(300);

        Group rootInscription = new Group(Iprenom,Ipre,INDF,INomDeFamille);
        Group chargement = new Group();
        Group photo = new Group();

        Button inscription = new Button("S'inscrire");
        inscription.setTranslateX(390);
        inscription.setTranslateY(480);
        inscription.setPrefSize(70,20);
        inscription.setOnAction((event)->{
            stage.setScene(new Scene(rootInscription));
        });

        Button connection = new Button("Se connecter");
        connection.setTranslateX(300);
        connection.setTranslateY(480);
        connection.setPrefSize(90,20);

        Group rootLogin = new Group(nomUtilisateur,username,password,mdp,inscription,connection);


        stage.setScene( new Scene(rootLogin));
        stage.show();
    }
}
