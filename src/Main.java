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
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public class Main extends Application {

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<Utilisateur> tableauDonnée= new ArrayList<>();
        load(tableauDonnée);
        stage.setWidth(700);
        stage.setHeight(900);

        final boolean[] check = {false,false,false,false,false};
        final boolean[] check1 = {false,false,false,false,false};


        Label wrong = new Label();
        wrong.setTextFill(Color.RED);
        wrong.setTranslateX(300);
        wrong.setTranslateY(440);
        wrong.setPrefSize(400,20);

        Label wrong1 = new Label("");
        wrong1.setTextFill(Color.RED);
        wrong1.setTranslateX(300);
        wrong1.setTranslateY(520);
        wrong1.setPrefSize(400,20);

        Label save = new Label("");
        save.setTextFill(Color.RED);
        save.setTranslateX(300);
        save.setTranslateY(520);
        save.setPrefSize(400,20);

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
        inscription.setTranslateX(410);
        inscription.setTranslateY(480);
        inscription.setPrefSize(70,20);
        inscription.setOnAction((event)->{
            wrong1.setText("");
            stage.setScene(inscrip);
        });
        Group chargement = new Group();
        Scene charg= new Scene(chargement);

        Button connection = new Button("Se connecter");
        connection.setTranslateX(300);
        connection.setTranslateY(480);
        connection.setPrefSize(90,20);
        connection.setOnAction(( event) ->{
            for (int i=0;i<tableauDonnée.size();i++){
                if (tableauDonnée.get(i).getNomUtilisateur().equals(username.getText())) {
                    check[i]=true;
                }
                if (hashing(mdp.getText()).equals(tableauDonnée.get(i).getMdp())){
                    check1[i]=true;
                }
            }
            if (tableauDonnée.size()==0){
                wrong1.setText("La connexion a échoué. Vous n'avez aucun utilisateur d'inscrit.");
            }
            for (int i=0;i<tableauDonnée.size();i++){

                if (check[i] && check1[i]){
                    check[i] = false;
                    check1[i]=false;
                    wrong1.setText("");
                    save.setText("");
                    stage.setScene(charg);
                }
                else if (check1[i] && !check[i]){
                    wrong1.setText("Votre nom d'utilisateur n'est pas bon");
                    check1[i]=false;
                    check[i]=false;
                }
                else if (check[i] && !check1[i]){
                    wrong1.setText("Votre mot de passe n'est pas bon");
                    check1[i]=false;
                    check[i]=false;
                }
                else {
                        save.setText(wrong1.getText());
                        wrong1.setText(save.getText());
                }

            }


        });

        Group rootLogin = new Group(nomUtilisateur,username,password,mdp,inscription,connection,wrong1,save);
        Scene login=new Scene(rootLogin);
        AtomicBoolean correct = new AtomicBoolean(true);
        Button IInscription = new Button("S'inscrire");
        rootInscription.getChildren().add(IInscription);
        IInscription.setPrefSize(100,20);
        IInscription.setTranslateX(300);
        IInscription.setTranslateY(410);
        IInscription.setOnAction((event)->{

            Utilisateur uti = new Utilisateur();
            correct.set(true);
            for (int i=0;i<tableauDonnée.size();i++){
                if (iNomUtilisateur.getText().equals(tableauDonnée.get(i).getNom())){
                    wrong.setText("Le nom d'utilisateur est déjà pris");
                    correct.set(false);
                }
            }

            while (correct.get()){
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
                else if (groupe.getSelectedToggle()==null){
                    wrong.setText("Vous n'avez pas sélectionner de genre");
                }
                else if (!condition.isSelected()){
                    wrong.setText("Vous n'avez pas accepter les conditions d'utilisation");
                }
                else {
                    uti.setNom(iPre.getText());
                    uti.setNomDeFamille(iNomDeFamille.getText());
                    uti.setNomUtilisateur(iNomUtilisateur.getText());
                    iMDPC.setText(hashing(iMDPC.getText()));
                    uti.setMdp(iMDPC.getText());
                    RadioButton selectedRadioButton = (RadioButton) groupe.getSelectedToggle();
                    String toogleGroupValue = selectedRadioButton.getText();
                    uti.setGenre(toogleGroupValue);
                    uti.setAge((int)Iage.getValueFactory().getValue());
                    tableauDonnée.add(uti);
                    inscriptionMethod(uti);
                    iPre.clear();
                    iNomDeFamille.clear();
                    iNomUtilisateur.clear();
                    iMotDePasse.clear();
                    iMDPC.clear();
                    if (groupe.getSelectedToggle()!=null){
                        groupe.getSelectedToggle().setSelected(false);
                    }
                    Iage.getValueFactory().setValue(18);
                    condition.setSelected(false);
                    wrong.setText("");
                    tableauDonnée.add(uti);
                    correct.set(false);
                    stage.setScene(login);
                }
            }


        });

        Button effacer = new Button("Effacer");
        effacer.setTranslateY(410);
        effacer.setTranslateX(400);
        effacer.setPrefSize(100,20);
        rootInscription.getChildren().add(effacer);
        effacer.setOnAction((event)->{
            iPre.clear();
            iNomDeFamille.clear();
            iNomUtilisateur.clear();
            iMotDePasse.clear();
            iMDPC.clear();
            if (groupe.getSelectedToggle()!=null){
                groupe.getSelectedToggle().setSelected(false);
            }

            Iage.getValueFactory().setValue(18);
            condition.setSelected(false);
            wrong.setText("");
        });

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

    public void load(ArrayList liste) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("Excel.csv"));
            String var;
            for (int i = 0; (var = allLines.get(i)) != null; i++) {
                String[] partie = var.split(",");
                Utilisateur user = new Utilisateur();
                user.setNom(partie[0]);
                user.setNomDeFamille(partie[1]);
                user.setNomUtilisateur(partie[2]);
                user.setMdp(partie[3]);
                user.setGenre(partie[4]);
                user.setAge(Integer.parseInt(partie[5]));
                liste.add(user);
            }
        } catch (Exception e) {

        }
    }
    public String hashing(String string) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(string.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public void inscriptionMethod(Utilisateur user){
        File file = new File("Excel.csv");
        String   csv = user.getNom()+","+user.getNomDeFamille()+","+user.getNomUtilisateur()+","+ user.getMdp()+","+user.getGenre()+","+user.getAge()+'\n';
        try {
            if (file.exists())
                Files.write(Paths.get("Excel.csv"), csv.getBytes(), StandardOpenOption.APPEND);
            else
                Files.write(Paths.get("Excel.csv"), csv.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {

        }
    }

}
