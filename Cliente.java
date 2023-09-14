import java.util.ArrayList;

public class Cliente {
	private String email;
	private String nome;
	private String endereco;
	private ArrayList<Entrega> entregas;

	public Cliente(String email, String nome, String endereco) {
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.entregas = new ArrayList<>();
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco(){
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void adicionaEntrega(Entrega entrega) {
        entregas.add(entrega);
    }

    public ArrayList<Entrega> pesquisaEntregas() {
        return entregas;
    }
}


