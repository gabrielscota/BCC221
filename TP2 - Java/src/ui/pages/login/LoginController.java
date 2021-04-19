package ui.pages.login;

public interface LoginController {
  boolean validateLogin();
  boolean validatePassword();
  void auth()throws Exception;
  void loadHomePage()throws Exception;
}
