import java.util.ArrayList;

public class Clientela {
	String email;
	private ArrayList<Cliente> clientes;

	public Clientela() {
		clientes = new ArrayList<Cliente>();
	}

	public boolean cadastraCliente(Cliente novoCliente) {
        // Verificar se já existe um cliente com o mesmo e-mail
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(novoCliente.getEmail())) {
                return false; // Cliente com o mesmo e-mail já cadastrado
            }
        }

        clientes.add(novoCliente);
        return true; // Cadastro bem-sucedido
    }



	/*public boolean cadastraCliente(Cliente cliente) {
		for (Cliente c : clientes) {
            if (c.getEmail().equals(email)) {
                return false;
            }
        }
        clientes.add(cliente);
        return true;
	}*/

	public Cliente pesquisaCliente(String email) {
		for(int i=0 ; i < clientes.size() ; i++){
			Cliente aux = clientes.get(i);
			if(aux.getEmail().equals(email))
				return aux;
		}
		return null;
	}

}
