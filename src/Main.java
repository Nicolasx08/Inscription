import com.sun.xml.internal.ws.api.server.EndpointReferenceExtensionContributor;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) {

        stage.setWidth(700);
        stage.setHeight(900);

        Label wrong = new Label();
        wrong.setTextFill(Color.RED);
        wrong.setTranslateX(300);
        wrong.setTranslateY(440);
        wrong.setPrefSize(400,20);

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

        TextField iPre = new TextField();
        iPre.setTranslateX(300);
        iPre.setTranslateY(40);
        iPre.setPromptText("Prénom");

        Label INDF = new Label("Nom de famille");
        INDF.setPrefSize(100,20);
        INDF.setTranslateX(300);
        INDF.setTranslateY(80);

        TextField iNomDeFamille = new TextField();
        iNomDeFamille.setPromptText("Nom de famille");
        iNomDeFamille.setTranslateY(100);
        iNomDeFamille.setTranslateX(300);

        Label INomUti = new Label("Nom d'utilisateur");
        INomUti.setPrefSize(100,20);
        INomUti.setTranslateX(300);
        INomUti.setTranslateY(130);

        TextField iNomUtilisateur = new TextField();
        iNomUtilisateur.setPromptText("Nom d'utilisateur");
        iNomUtilisateur.setTranslateX(300);
        iNomUtilisateur.setTranslateY(150);

        Label Imdp = new Label("Mot de passe");
        Imdp.setTranslateY(180);
        Imdp.setTranslateX(300);
        Imdp.setPrefSize(100,20);

        PasswordField iMotDePasse = new PasswordField();
        iMotDePasse.setTranslateX(300);
        iMotDePasse.setTranslateY(200);
        iMotDePasse.setPromptText("Mot de passe");

        Label IConfirm = new Label("Confirmer le mot de passe");
        IConfirm.setPrefSize(100,20);
        IConfirm.setTranslateX(300);
        IConfirm.setTranslateY(230);

        PasswordField iMDPC = new PasswordField();
        iMDPC.setTranslateX(300);
        iMDPC.setTranslateY(250);
        iMDPC.setPromptText("Confirmer le mot de passe");

        Label genre = new Label("Genre");
        genre.setTranslateX(300);
        genre.setTranslateY(280);
        genre.setPrefSize(100,20);

        RadioButton homme = new RadioButton("Homme");
        homme.setTranslateX(300);
        homme.setTranslateY(300);
        homme.setPrefSize(80,20);
        RadioButton femme = new RadioButton("Femme");
        femme.setTranslateX(380);
        femme.setTranslateY(300);
        femme.setPrefSize(80,20);
        RadioButton autre = new RadioButton("Autre");
        autre.setTranslateX(460);
        autre.setTranslateY(300);
        autre.setPrefSize(80,20);

        ToggleGroup groupe = new ToggleGroup();
        homme.setToggleGroup(groupe);
        femme.setToggleGroup(groupe);
        autre.setToggleGroup(groupe);

        Label age = new Label("Âge");
        age.setTranslateY(330);
        age.setTranslateX(300);
        age.setPrefSize(100,20);

        Spinner Iage = new Spinner(18,150,18);
        Iage.setTranslateX(300);
        Iage.setTranslateY(350);
        Iage.setPrefSize(100,20);

        CheckBox condition = new CheckBox("J'accepte les conditions d'utilisation");
        condition.setTranslateX(300);
        condition.setTranslateY(380);


        Group rootInscription = new Group(wrong,Iprenom,iPre,INDF,iNomDeFamille,INomUti,iNomUtilisateur,Imdp,iMotDePasse,IConfirm,iMDPC, genre,homme,femme,autre,age,Iage,condition);
        Scene inscrip = new Scene(rootInscription);
        Button inscription = new Button("S'inscrire");
        inscription.setTranslateX(390);
        inscription.setTranslateY(480);
        inscription.setPrefSize(70,20);
        inscription.setOnAction((event)->{
            stage.setScene(inscrip);
        });
        Group chargement = new Group();
        Scene charg= new Scene(chargement);

        Button connection = new Button("Se connecter");
        connection.setTranslateX(300);
        connection.setTranslateY(480);
        connection.setPrefSize(90,20);
        connection.setOnAction((event)->{
            stage.setScene(charg);
        });

        Group rootLogin = new Group(nomUtilisateur,username,password,mdp,inscription,connection);
        Scene login=new Scene(rootLogin);

        Button IInscription = new Button("S'inscrire");
        rootInscription.getChildren().add(IInscription);
        IInscription.setPrefSize(100,20);
        IInscription.setTranslateX(300);
        IInscription.setTranslateY(410);
        IInscription.setOnAction((event)->{
            if (iPre.getText().equals("")){
                wrong.setText("Vous n'avez pas entrer de prénom");
            }
            else if (iNomDeFamille.getText().equals("")){
                wrong.setText("Vous n'avez pas entrer de nom de famille");
            }
            else if (iNomUtilisateur.getText().equals("")){
                wrong.setText("Vous n'avez pas entrer de nom d'utilisateur");
            }
            else if (iMotDePasse.getText().equals("")){
                wrong.setText("Vous n'avez pas entrer de mot de passe");
            }
            else if (iMDPC.getText().equals("")){
                wrong.setText("Vous n'avez rien entrer dans confirmation de mot de passe");
            }
            else if (!iMotDePasse.getText().equals(iMDPC.getText())){
                wrong.setText("Les mot de passe ne correspondent pas");
            }
            else if (!homme.isSelected()&& !femme.isSelected() && !autre.isSelected()){
                wrong.setText("Vous n'avez pas sélectionner de genre");
            }
            else if (!condition.isSelected()){
                wrong.setText("Vous n'avez pas accepter les conditions d'utilisation");
            }
            else {
                iPre.clear();
                iNomDeFamille.clear();
                iNomUtilisateur.clear();
                iMotDePasse.clear();
                iMDPC.clear();
                groupe.getSelectedToggle().setSelected(false);
                condition.setSelected(false);
                stage.setScene(login);
            }

        });

        Button effacer = new Button("Effacer");
        effacer.setTranslateY(410);
        effacer.setTranslateX(400);
        effacer.setPrefSize(100,20);
        rootInscription.getChildren().add(effacer);

        Button retour = new Button("Retour");
        retour.setTranslateX(500);
        retour.setTranslateY(410);
        retour.setPrefSize(100,20);
        rootInscription.getChildren().add(retour);
        retour.setOnAction((event)->{
            stage.setScene(login);
        });

        Group photo = new Group();

        Scene resultat = new Scene(photo);

        Image image = new Image("https://scontent.fyhu1-1.fna.fbcdn.net/v/t1.15752-9/42614821_330417904396028_5321954024411365376_n.png?_nc_cat=111&oh=9a7133a421a39350305ea5d50e0a152b&oe=5C1AA0B0");
        Image image1 = new Image("https://scontent.fyhu1-1.fna.fbcdn.net/v/t1.15752-9/s2048x2048/42629554_1935782183110952_5880434351396618240_n.jpg?_nc_cat=109&oh=c5bea8fc76f33d276a8b6f15ee3bb261&oe=5C27DAAD");
        ImageView imageview1 = new ImageView(image1);
        ImageView imageview= new ImageView(image);
        photo.getChildren().add(imageview1);

        imageview.setTranslateX(200);
        imageview.setTranslateY(200);
        imageview.setFitHeight(200);
        imageview.setFitWidth(200);

        imageview1.setTranslateX(200);
        imageview1.setTranslateY(650);
        imageview1.setFitHeight(200);
        imageview1.setFitWidth(200);

        photo.getChildren().add(imageview);
        RotateTransition rt = new RotateTransition(Duration.millis(3000),imageview);
        rt.setByAngle(360);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();

        ScaleTransition sc = new ScaleTransition(Duration.millis(1500),imageview1);
        sc.setByX(1.3);
        sc.setByY(1.3);
        sc.setInterpolator(Interpolator.LINEAR);
        sc.setCycleCount(Timeline.INDEFINITE);
        sc.setAutoReverse(true);
        sc.play();

        RotateTransition rt1 = new RotateTransition(Duration.millis(3000),imageview1);
        rt1.setByAngle(360);
        rt1.setCycleCount(Timeline.INDEFINITE);
        rt1.setInterpolator(Interpolator.LINEAR);
        rt1.play();

        ProgressIndicator rond = new ProgressIndicator(0);
        rond.setTranslateX(300);
        rond.setTranslateY(400);


        chargement.getChildren().add(rond);
        ProgressIndicator rond1 = new ProgressIndicator();
        rond1.setTranslateY(340);
        rond1.setTranslateX(300);
        chargement.getChildren().add(rond1);

        Button bouton = new Button("Progresser");
        bouton.setTranslateY(460);
        bouton.setTranslateX(300);
        bouton.setOnAction(event->{
            rond.setProgress(rond.getProgress() + 0.1);
            if (rond.progressProperty().intValue()==1){
                stage.setScene(resultat);
            }
        });
        chargement.getChildren().add(bouton);

        stage.setScene(login);
        stage.show();
    }

}
