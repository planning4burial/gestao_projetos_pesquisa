package estrutura;

public interface Autenticavel {
	
    boolean realizarLogin(String email, String senha);
    void realizarLogout();

}
