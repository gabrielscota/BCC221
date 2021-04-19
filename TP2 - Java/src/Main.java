import data.usecases.authentication.LocalAuthentication;
import data.usecases.receptionist.LocalEditReceptionist;
import domain.entities.Clinic;
import domain.entities.Receptionist;
import domain.entities.UserPermissions;
import javafx.application.Application;
import javafx.stage.Stage;
import presentation.controllers.PresentationLoginController;
import presentation.controllers.PresentationReceptionistController;
import ui.pages.login.LoginPage;
import ui.pages.receptionist.ReceptionistPage;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
//    LoginPage loginPage = new LoginPage(new PresentationLoginController(new LocalAuthentication(), primaryStage));
//    loginPage.build(primaryStage);
    buildReceptionistPage(primaryStage);
  }

  public void buildReceptionistPage(Stage stage) throws Exception {
    UUID clinicUUID = UUID.randomUUID();
    UUID receptionistUUID = UUID.randomUUID();
    List<String> permissions = Arrays.asList("SCHEDULE");
    UserPermissions userPermissions = new UserPermissions(receptionistUUID.toString(), permissions);
    Receptionist receptionist = new Receptionist(receptionistUUID.toString(), "Ana Silva", "ana", "123456", userPermissions);
    Clinic clinic = new Clinic(clinicUUID.toString(), receptionist, null);
    ReceptionistPage receptionistPage = new ReceptionistPage(new PresentationReceptionistController(
            new LocalEditReceptionist(clinic),
            receptionist.getName()
    ));
    receptionistPage.build(stage);
  }
}
