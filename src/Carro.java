/*Criação de uma classe "Carro" 
para construir atributos e métodos.*/


public class Carro {
    private String nome, marca, placa;
    private int ano;
    private double preco;

    public Carro(String nome, String marca, String placa, int ano, double preco) {  //Criação de um construtor para a classe "Carro"
        this.nome = nome;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
    }

    //Criação de getters e setters para conseguir obter valores e atribuir valores na classe "Carro"
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    //Criação de um método "Imprimir" para realizar a saida dos valores obtidos pelo usuário
    public void imprimir(){
        
        System.out.format("%9s %1s %8s %1s %9s %1s %7d %1s %9s",
                    getNome(),"|", getMarca(), " |", getPlaca(), "|", getAno(), "|", getPreco());
            System.out.println();
    }
    

}