public class CarroUsado extends Carro {
    private double kmRodados;
    private String reparosNecessarios;

    public CarroUsado(double kmRodados, String reparosNecessarios, String nome, String marca, String placa, int ano, double preco) {
        super(nome, marca, placa, ano, preco);
        this.kmRodados = kmRodados;
        this.reparosNecessarios = reparosNecessarios;
    }

    public double getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(double kmRodados) {
        this.kmRodados = kmRodados;
    }

    public String getReparosNecessarios() {
        return reparosNecessarios;
    }

    public void setReparosNecessarios(String reparosNecessarios) {
        this.reparosNecessarios = reparosNecessarios;
    }

    public void imprimirUsado(){
        
        System.out.format("%9s %1s %8s %1s %7s %1s %8d %1s %9s %1s %13s %1s %9s ",
                    getNome(),"|", getMarca(), " |", getPlaca(), "|", getAno(), "|", getPreco(), "|", getKmRodados(), "|", getReparosNecessarios());
            System.out.println();
    }    
}