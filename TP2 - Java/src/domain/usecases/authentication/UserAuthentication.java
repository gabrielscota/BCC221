package domain.usecases.authentication;

public interface UserAuthentication {
  String auth(AuthenticationParams params);
}
