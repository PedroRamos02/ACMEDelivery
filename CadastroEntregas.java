import java.util.ArrayList;

public class CadastroEntregas {
	
	private ArrayList<Entrega> entregas;

	public CadastroEntregas() {
		entregas = new ArrayList<Entrega>(10);
	}

	public boolean cadastraEntrega(Entrega entrega) {
		for (Entrega e : entregas) {
            if (e.getCodigo() == entrega.getCodigo()) {
                return false;
            }
        }
        entregas.add(entrega);
        return true; 
	}

	public Entrega pesquisaEntrega(int codigo) {
		for(int i=0 ; i < entregas.size() ; i++){
			Entrega aux = entregas.get(i);
			if(aux.getCodigo().equals(codigo))
				return aux;
		}
		return null;
	}

	/*public List<Entrega> pesquisaEntrega(String emailCliente) {
        List<Entrega> entregasEncontradas = new ArrayList<>();
        for (Entrega entrega : entregas) {
            if (entrega.getCliente().getEmail().equals(emailCliente)) {
                entregasEncontradas.add(entrega);
            }
        }
        return entregasEncontradas.isEmpty() ? null : entregasEncontradas;
    }*/

}
