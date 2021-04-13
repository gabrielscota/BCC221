package ui.pages.login;

public interface LoginController {
  void validateLogin();
  void validatePassword();
  void auth()throws Exception;
  void loadHomePage()throws Exception;
}
