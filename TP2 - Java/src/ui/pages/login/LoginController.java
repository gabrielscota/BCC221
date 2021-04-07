package ui.pages.login;

public interface LoginController {
  void validatePassword(String password);

  void auth();
  void printTest();
}
