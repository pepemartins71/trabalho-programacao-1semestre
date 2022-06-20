import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/*A classe Principal é responsável por fazer o usuário escolher as opções do Menu, 
e também incluindo todos os métodos para que essas ações consigam ser realizadas.*/

public class Principal {

    public static void main(String[] args) {
        ArrayList<Carro> estoque = new ArrayList<Carro>(); //Criação do ArrayList do tipo Carro para armazenar os objetos da classe Carro
        ArrayList<CarroUsado> estoqueUsados = new ArrayList<CarroUsado>(); //Criação do ArrayList do tipo CarroUsado para armazenar os objetos da classe CarroUsado
        Scanner entrada = new Scanner(System.in); //Criação do Scanner
        Carro c = null; //Criação do objeto da classe Carro
        CarroUsado u = null; //Criação do objeto da classe CarroUsado              
        carrosCadastrados(estoque); //Invoca método carrosCadastrados levando como parametro o vetor ArrayList estoque
        carrosCadastradosUsados(estoqueUsados); //Invoca método carrosCadastradosUsados levando como parametro o vetor ArrayList estoqueUsados

        
        int opcao; 
        do{ //Início da estrutura do do-while
             System.out.println("\n------ Menu ------\n");
             System.out.println("1- Cadastrar");
             System.out.println("2- Imprimir");
             System.out.println("3- Excluir");
             System.out.println("4- Buscar");
             System.out.println("5- Ordenar");
             System.out.println("6- Modificar");
             System.out.println("7- Sair");
             System.out.print("Digite a opção desejada: ");
             opcao = entrada.nextInt(); //Usuário digita e armazena na variável inteira opcao

        switch (opcao) { //Inicio da estrutura switch case
            case 1: //Caso a variável "opcao"seja igual a 1
                escolhaTipoCarro();
                int opc = entrada.nextInt();
                if (opc==1){
                c = digitaDados(); //Invoca método digitaDados e retorno da função atribui a variável c
                estoque.add(c); //ArrayList estoque adiciona objeto c
                break; //Encerra estrutura switch case caso opcao seja igual a 1 
                }else if(opc==2){
                    u = digitaDadosUsados(); //Invoca método digitaDadosUsados e retorno da função atribui a variável u
                    estoqueUsados.add(u); //ArrayList estoque adiciona objeto u
                    break;
                }   
            case 2: //Caso a variável "opcao"seja igual a 2
                escolhaTipoCarro(); //Invoca método escolhaTipoCarro para usuário escolher entre Carro e Carro usado
                int opc2 = entrada.nextInt(); 
                if (opc2==1){
                listar(estoque); //Invoca método listar e passa como parâmetro o vetor ArrayList estoque
                break; //Encerra estrutura switch case caso opcao seja igual a 1 
                }else if(opc2==2){
                    listarUsado(estoqueUsados); //Invoca método listar e passa como parâmetro o vetor ArrayList estoqueUsados
                    break;
                } 

                
            case 3: //Caso a variável "opcao"seja igual a 3
                escolhaTipoCarro(); //Invoca método escolhaTipoCarro para usuário escolher entre Carro e Carro usado
                int opc3 = entrada.nextInt();
                if (opc3==1){
                    excluir(estoque); //Invoca o método excluir e passa como parâmetro o vetor ArrayList estoque
                    break;
                }else if(opc3==2){
                    excluirUsado(estoqueUsados); //Invoca o método excluir e passa como parâmetro o vetor ArrayList estoqueUsado
                    break;
                } 

                
            case 4: //Caso a variável "opcao"seja igual a 4                
                escolhaTipoCarro(); //Invoca método escolhaTipoCarro para usuário escolher entre Carro e Carro usado
                int opc4 = entrada.nextInt();
                if (opc4==1){
                    buscar(estoque); // Invoca o método buscar e passa como parâmetro o vetor ArrayList estoque
                    break;
                }else if(opc4==2){
                    buscarUsado(estoqueUsados); // Invoca o método buscar e passa como parâmetro o vetor ArrayList estoque
                    break;
                } 

            
            case 5:
                escolhaTipoCarro(); //Invoca método escolhaTipoCarro para usuário escolher entre Carro e Carro usado
                int opc5 = entrada.nextInt(); //opção para o tipo de carro
                if (opc5==1){ //Caso a opção seja 1, carros serão selecionados
                    System.out.println("\nDeseja ordernar em: ");
                    System.out.println("1- Crescente\n2- Decrescente");
                    entrada = new Scanner(System.in);
                    int opt = entrada.nextInt();
                    if(opt==1){ //Se a opção for 1
                        ordernarCresc(estoque); //Será ordenado o preço dos carros em ordem crescente
                    }else if(opt==2){ //Se a opção for 2
                        ordernarDecresc(estoque); //Será ordenado o preço dos carros em ordem descrescente
                    }else{
                        System.out.println("Opção Inválida.");
                    }
                }else if(opc5==2){ //Caso a opção seja 2, carros usados serão selecionados
                    System.out.println("\nDeseja ordernar em: ");
                    System.out.println("1- Crescente\n2- Decrescente");
                    entrada = new Scanner(System.in);
                    int opt = entrada.nextInt();
                    if(opt==1){ //Se a opção for 1
                        ordernarCrescUsado(estoqueUsados); //Será ordenado os KM's rodados dos carros em ordem crescente
                    }else if(opt==2){ //Se a opção for 2
                        ordernarDecrescUsado(estoqueUsados); //Será ordenado os KM's rodados dos carros em ordem crescente
                    }else{
                        System.out.println("Opção Inválida.");
                    }
                }
                break;
            case 6:
                 escolhaTipoCarro(); //Invoca método escolhaTipoCarro para usuário escolher entre Carro e Carro usado
                 int opc6 = entrada.nextInt();
                if(opc6==1){
                    modificar(estoque);        
                }else if(opc6==2){
                    modificarUsado(estoqueUsados);
                }
            }
        
                      
    }while (opcao != 7); //Fim da Estrutura do-while caso a variável "opcao" seja 5
        System.out.println("Programa encerrado, volte sempre!");
    }
    
    
    
    public static int encontrarCarro(String placa, ArrayList<Carro> lista){ //Criação da função do tipo inteira "encontrarCarro" que recebe como parâmetro String "placa" e ArrayList do tipo Carro
        for (int i=0; i<lista.size(); i++) //Inicio da estrutura de repetição For
            if(lista.get(i).getPlaca().equals(placa)) //Se variável "placa" no indíce "i" do ArrayList "lista"  seja igual a variável "placa" que a função recebeu como parâmetro, função retorna "i"
                return i; //Função retorna "i"
        System.out.println("Esse produto não existe");
        return -1;  //Se não, retorna -1
    }
    
    public static int encontrarCarroUsado(String placa, ArrayList<CarroUsado> lista){ //Criação da função do tipo inteira "encontrarCarro" que recebe como parâmetro String "placa" e ArrayList do tipo Carro
        for (int i=0; i<lista.size(); i++) //Inicio da estrutura de repetição For
            if(lista.get(i).getPlaca().equals(placa)) //Se variável "placa" no indíce "i" do ArrayList "lista"  seja igual a variável "placa" que a função recebeu como parâmetro, função retorna "i"
                return i; //Função retorna "i"
        System.out.println("Esse produto não existe");
        return -1;  //Se não, retorna -1
    }
    
   
    
    public static String indiquePlaca(){ //Criação da função do tipo String indiquePlaca
       String placa;
       Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha a placa do carro:");
        placa = entrada.next(); //Usuário digita String que é armazenada na variável "placa"
        return placa; //Função retorna String "placa"
    }
    
    public static void modificar(ArrayList<Carro> lista){
       Scanner entrada = new Scanner(System.in);
       String placa;
       placa = indiquePlaca(); //Invocação da função indiquePlaca, atribuindo o retorno a variável "placa"
       int i;
       i = encontrarCarro(placa, lista);  //Invocação da função encontrarCarro passando como parâmetro String "placa" e ArrayList<Carro> lista, atribuindo o retorno a variável "i"
       if (i>=0){ //Se "i" for maior ou igual a zero
           System.out.println("Deseja modificar:\n1-Nome\n2-Marca\n3-Placa\n4-Ano\n5-Preco");
           System.out.println("Digite a opção desejada: ");
           int escolha = entrada.nextInt();
         switch(escolha){ //Switch para escolher o atributo que será modificado
             case 1:
                 System.out.println("Digite o novo nome:");
                 String novoNome = entrada.next();
                 lista.get(i).setNome(novoNome); //Usar o Set do atributo para aplicar o novo nome do atributo
                 break;
             case 2:
                 System.out.println("Digite o nova marca:");
                 String novaMarca = entrada.next();
                 lista.get(i).setMarca(novaMarca);
                 break;
             case 3:
                 System.out.println("Digite o nova placa:");
                 String novaPlaca = entrada.next();
                 lista.get(i).setPlaca(novaPlaca);
                 break;
            case 4:
                 System.out.println("Digite o novo ano:");
                 int novoAno = entrada.nextInt();
                 lista.get(i).setAno(novoAno);
                 break;
            case 5:
                 System.out.println("Digite o novo preco:");
                 double novoPreco = entrada.nextDouble();
                 lista.get(i).setPreco(novoPreco);
                 break;
         }
                  
       }else{}
    }
    
    public static void modificarUsado(ArrayList<CarroUsado> lista){
        Scanner entrada = new Scanner(System.in);
         String placa;
       placa = indiquePlaca(); //Invocação da função indiquePlaca, atribuindo o retorno a variável "placa"
       int i;
       i = encontrarCarroUsado(placa, lista);  //Invocação da função encontrarCarro passando como parâmetro String "placa" e ArrayList<Carro> lista, atribuindo o retorno a variável "i"
       if (i>=0){ //Se "i" for maior ou igual a zero
           System.out.println("Deseja modificar:\n1-Nome\n2-Marca\n3-Placa\n4-Ano\n5-Preco\n6-Km rodados\n7-Reparos necessários");
           System.out.println("Digite a opção desejada: ");
           int escolha = entrada.nextInt();
         switch(escolha){
             case 1:
                 System.out.println("Digite o novo nome:");
                 String novoNome = entrada.next();
                 lista.get(i).setNome(novoNome);
                 break;
             case 2:
                 System.out.println("Digite o nova marca:");
                 String novaMarca = entrada.next();
                 lista.get(i).setMarca(novaMarca);
                 break;
             case 3:
                 System.out.println("Digite o nova placa:");
                 String novaPlaca = entrada.next();
                 lista.get(i).setPlaca(novaPlaca);
                 break;
            case 4:
                 System.out.println("Digite o novo ano:");
                 int novoAno = entrada.nextInt();
                 lista.get(i).setAno(novoAno);
                 break;
            case 5:
                 System.out.println("Digite o novo preco:");
                 double novoPreco = entrada.nextDouble();
                 lista.get(i).setPreco(novoPreco);
                 break;
            case 6:
                System.out.println("Digite os novos km rodados:");
                 double novoKm = entrada.nextDouble();
                 lista.get(i).setKmRodados(novoKm);
                 break;
            case 7:
                System.out.println("Digite os novos reparos necessários:");
                 String novoReparos = entrada.next();
                 lista.get(i).setReparosNecessarios(novoReparos);
                 break;  
         }
                  
       }else{}
    }
    
    public static void buscar(ArrayList<Carro> lista){ //Criação da função do tipo void "buscar" recebendo como parâmetro ArrayList do tipo Carro
       String placa;
       placa = indiquePlaca(); //Invocação da função indiquePlaca, atribuindo o retorno a variável "placa"
       int i;
       i = encontrarCarro(placa, lista);  //Invocação da função encontrarCarro passando como parâmetro String "placa" e ArrayList<Carro> lista, atribuindo o retorno a variável "i"
       if (i>=0){ //Se "i" for maior ou igual a zero           
         tabelaBuscar();
          lista.get(i).imprimir(); //Invoca função imprimir, imprimindo o objeto armazenado no índice "i" do ArrayList "lista"        
       }else{}           
    }
    
    public static void buscarUsado(ArrayList<CarroUsado> lista){ //Criação da função do tipo void "buscar" recebendo como parâmetro ArrayList do tipo Carro
       String placa;
       placa = indiquePlaca(); //Invocação da função indiquePlaca, atribuindo o retorno a variável "placa"
       int i;
       i = encontrarCarroUsado(placa, lista);  //Invocação da função encontrarCarro passando como parâmetro String "placa" e ArrayList<Carro> lista, atribuindo o retorno a variável "i"
       if (i>=0){ //Se "i" for maior ou igual a zero           
         tabelaBuscarUsado();
          lista.get(i).imprimirUsado(); //Invoca função imprimir, imprimindo o objeto armazenado no índice "i" do ArrayList "lista"        
       }else{}           
    }
   
    public static void listar(ArrayList<Carro> lista){ //Criação da função do tipo void "listar" recebendo como parâmetro ArrayList do tipo Carro  
        tabelaListar();    
        for (Carro list : lista) {
            System.out.format("%10s %1s %11s %1s %9s %1s %9s",
                    list.getNome(),"|", list.getMarca(), " |", list.getPlaca(), " |", list.getPreco());
            System.out.println();
        }
           }
    
    public static void listarUsado(ArrayList<CarroUsado> lista){ //Criação da função do tipo void "listar" recebendo como parâmetro ArrayList do tipo Carro
       
        tabelaListarUsado();
        
        for (CarroUsado list : lista) {
            System.out.format("%10s %1s %10s %1s %8s %1s %9s",
                    list.getNome(),"|", list.getMarca(), " |", list.getPlaca(), " |", list.getKmRodados());
            System.out.println();
        }
                }
    
    public static void excluir(ArrayList<Carro> lista){ //Criação da função do tipo void "excluir" recebendo como parâmetro ArrayList do tipo Carro
        Scanner entrada = new Scanner(System.in);
        String placa;
        placa = indiquePlaca();  //Invocação da função indiquePlaca, atribuindo o retorno a variável "placa"
        int i;
        i = encontrarCarro(placa, lista);  //Invocação da função encontrarCarro passando como parâmetro String "placa" e ArrayList<Carro> lista, atribuindo o retorno a variável "i"
        if (i>=0){ //Se "i" for maior ou igual a zero
            System.out.println("Deseja realmente excluir esse produto?");
            System.out.println("1- SIM");
            System.out.println("2- NAO");
            System.out.print("Digite a opcao desejada: ");
            int opcao = entrada.nextInt();
            if(opcao == 1){ //Se a opção for 1
                System.out.println("Excluído com sucesso");
                lista.remove(i);  //Remove objeto armazenado no índice "i" do ArrayList "lista"
            }
            else if(opcao == 2){System.out.println("Ação cancelada");} //Se a opção for 2 a ação será cancelada
        }
    }
    
    public static void excluirUsado(ArrayList<CarroUsado> lista){ //Criação da função do tipo void "excluirUsado" recebendo como parâmetro ArrayList do tipo Carro
        Scanner entrada = new Scanner(System.in);
        String placa;
        placa = indiquePlaca();  //Invocação da função indiquePlaca, atribuindo o retorno a variável "placa"
        int i;
        i = encontrarCarroUsado(placa, lista);  //Invocação da função encontrarCarro passando como parâmetro String "placa" e ArrayList<Carro> lista, atribuindo o retorno a variável "i"
        if (i>=0){ //Se "i" for maior ou igual a zero
            System.out.println("Deseja realmente excluir esse produto?");
            System.out.println("1- SIM");
            System.out.println("2- NAO");
            System.out.print("Digite a opcao desejada: ");
            int opcao = entrada.nextInt();
            if(opcao == 1){ //Se a opção for 1
                System.out.println("Excluído com sucesso");
                lista.remove(i);  //Remove objeto armazenado no índice "i" do ArrayList "lista"
            }
            else if(opcao == 2){ //Se a opção for 2 a ação será cancelada
                System.out.println("Ação cancelada");
            }
        }
    }
         
    public static Carro digitaDados(){ //Criação da função do tipo Carro "digitaDados"
     Scanner entrada = new Scanner(System.in); //Criação do Scanner
             String nome,placa,marca; 
             int ano;
             double preco;
             Carro c = null;

        System.out.println("Informe o nome do veículo: ");
        nome = entrada.next(); //Usuário digita String e armazena na variável "nome"
        System.out.println("Informe a marca do veículo: ");
        marca = entrada.next(); //Usuário digita String e armazena na variável "marca"
        placa = indiquePlaca(); //Invocação da função indiquePlaca, atribuindo o retorno à variável "placa"
        System.out.println("Informe o ano do veículo: ");
        ano = entrada.nextInt(); //Usuário digita int e armazena na variável "ano"
        System.out.println("Informe o preço do veículo: ");
        preco = entrada.nextDouble();   //Usuário digita double e armazena na variável "preco"
        c = new Carro(nome,marca,placa,ano,preco); // "c" invoca construtor da classe Carro passando como parâmetro variáveis "nome", "marca", "placa", "ano" e "preco"
        
        return c; //Função retorna "c"           
    }
    
    public static CarroUsado digitaDadosUsados(){
        Scanner entrada = new Scanner(System.in); //Criação do Scanner
             String nome,placa,marca; 
             int ano;
             double preco;
             CarroUsado u = null;
             double kmRodados;
             String reparosNecessarios;
             
        System.out.println("Informe o nome do veículo: ");
        nome = entrada.next(); //Usuário digita String e armazena na variável "nome"
        System.out.println("Informe a marca do veículo: ");
        marca = entrada.next(); //Usuário digita String e armazena na variável "marca"
        placa = indiquePlaca(); //Invocação da função indiquePlaca, atribuindo o retorno à variável "placa"
        System.out.println("Informe o ano do veículo: ");
        ano = entrada.nextInt(); //Usuário digita int e armazena na variável "ano"
        System.out.println("Informe o preço do veículo: ");
        preco = entrada.nextDouble();   //Usuário digita double e armazena na variável "preco"
        System.out.println("Informa a quantidade de Km rodados do veículo: ");
        kmRodados = entrada.nextDouble();
        System.out.println("Informe os reparos necessários do veículo: ");
        reparosNecessarios = entrada.next();
        u = new CarroUsado(kmRodados, reparosNecessarios,nome,marca,placa,ano,preco); // "c" invoca construtor da classe Carro passando como parâmetro variáveis "nome", "marca", "placa", "ano" e "preco"
        
        return u; //Função retorna "c"
    }
    
    public static void carrosCadastrados(ArrayList<Carro> lista){ //Criação da função do tipo void "carrosCadastrados" recebendo como parâmetro ArrayList do tipo Carro
        Carro c = null;
        c = new Carro("Fusca","Volkswagen","BRA2E19",2007,60000.00); // "c" invoca construtor da classe Carro passando como parâmetro variáveis "nome", "marca", "placa", "ano" e "preco"
        lista.add(c); ////Adiciona objeto na ArrayList "lista"
        c = new Carro("Corola","Toyota","PIA2A19",2010,36400.00);
        lista.add(c);
        c = new Carro("Onix","Chevrolet","BEE4R22",2012,36990.00);
        lista.add(c);
        c = new Carro("Uno","Fiat","BRA0S17",2022,60090.00);
        lista.add(c);
        c = new Carro("Palio", "Fiat","FTX6604",2022,80210.00);
        lista.add(c);
        c = new Carro("C180","Mercedes","DQE2H66",2021,180000.00);
        lista.add(c);
        c = new Carro("R8","Audi","ACI6967",2014,770000.99);
        lista.add(c);   
    }
    
    public static void carrosCadastradosUsados(ArrayList<CarroUsado> lista){ //Criação da função do tipo void "carrosCadastradosUsados" recebendo como parâmetro ArrayList do tipo CarroUsado
        CarroUsado u = null;
        u = new CarroUsado(1235, "Rodas","Opala","Volkswagen","BRA123E",1970,600.00); // "u" invoca construtor da classe Carro passando como parâmetro variáveis "kmRodados" "reparosNecessarios" "nome", "marca", "placa", "ano" e "preco"
        lista.add(u); ////Adiciona objeto na ArrayList "lista"
        u = new CarroUsado(9999, "Vidro","Celta","Chevrolet","PEE124A",2000,2000.00); 
        lista.add(u); 
        u = new CarroUsado(50, "Porta","Civic","Honda","BRA999E",2010,60000.00); 
        lista.add(u); 
        u = new CarroUsado(760, "Estepe","Gol","Volkswagen","URU432A",2005,30000.00); 
        lista.add(u);        
    }
    
    public static void tabelaListar (){ //Criação da função para imprimir tabela 
        System.out.println("-----------------------------------------------------");
        System.out.printf("%10s %11s %12s %12s", "NOME", "MARCA", "PLACA", "PRECO");
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }
    
    public static void tabelaListarUsado (){ //Criação da função para imprimir tabela 
        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s %11s %10s %14s", "NOME", "MARCA", "PLACA", "KM RODADOS");
        System.out.println();
        System.out.println("------------------------------------------------------------");
    }
    
    public static void tabelaBuscar (){ //Criação da função para imprimir tabela 
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s", "NOME", "MARCA", "PLACA", "ANO", "PRECO");
        System.out.println();
        System.out.println("---------------------------------------------------------------------");
    }
    
    public static void tabelaBuscarUsado (){ //Criação da função para imprimir tabela 
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s %14s %10s ", "NOME", "MARCA", "PLACA", "ANO", "PRECO", "KM RODADOS", "REPAROS");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    public static void ordernarCresc(ArrayList<Carro> lista){ //Criação da função para ordenar objetos do ArrayList com base no atributo "preco" em ordem crescente
        for(int i=0; i<lista.size(); i++){ 
            for(int j=i+1; j<lista.size(); j++){ 
                if(lista.get(i).getPreco()>lista.get(j).getPreco()){ 
                   Collections.swap(lista, i, j);
                }   
            }
        }
    }
    
    public static void ordernarDecresc(ArrayList<Carro> lista){ //Criação da função para ordenar objetos do ArrayList com base no atributo "preco" em ordem decrescente
        for(int i=0; i<lista.size(); i++){
            for(int j=i+1; j<lista.size(); j++){
                if(lista.get(i).getPreco()<lista.get(j).getPreco()){
                   Collections.swap(lista, i, j);
                }   
            }
        }
    }

public static void ordernarCrescUsado(ArrayList<CarroUsado> lista){ //Criação da função para ordenar objetos do ArrayList com base no atributo "preco" em ordem crescente
        for(int i=0; i<lista.size(); i++){
            for(int j=i+1; j<lista.size(); j++){
                if(lista.get(i).getKmRodados()>lista.get(j).getKmRodados()){
                   Collections.swap(lista, i, j);
                }   
            }
        }
    }
    
    public static void ordernarDecrescUsado(ArrayList<CarroUsado> lista){ //Criação da função para ordenar objetos do ArrayList com base no atributo "preco" em ordem decrescente
        for(int i=0; i<lista.size(); i++){
            for(int j=i+1; j<lista.size(); j++){
                if(lista.get(i).getKmRodados()<lista.get(j).getKmRodados()){
                   Collections.swap(lista, i, j);
                }   
            }
        }
    }
    
    public static void escolhaTipoCarro(){ //Modularização para escolha do tipo de carro
          System.out.println("\n1- Carro Novo\n2- Carro Usado");
          System.out.print("Digite a opção desejada: ");
    }
}
