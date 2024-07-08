public class TamagotchiKauanSchefferTedesco{
    // Os atributos da classe Tamagotchi
    private String nome;
    private int diasAcordado = 0;
    private int dia = 0;
    private int peso = 1;
    private boolean vivo = true;
    
    // método costrutor
    public TamagotchiKauanSchefferTedesco(){
        this.nome = nome;
        this.diasAcordado = diasAcordado;
        this.dia = dia;
        this.peso = peso;
        this.vivo = vivo;
    }
    
    // geters e seters dos atributos
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getDiasAcordado(){
        return diasAcordado;
    }
    public void setDiasAcordado(int diasAcordado){
        this.diasAcordado = diasAcordado;
    }
    
    public int getDia(){
        return dia;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
    
    public int getPeso(){
        return peso;
    }
    public void setPeso(int peso){
        this.peso = peso;
    }
    
    public boolean getVivo(){
        return vivo;
    }
    public void setVivo(boolean vivo){
        this.vivo = vivo;
    }
    
    // métodos dos eventos sorteados
    public void sono(){
        String s = Teclado.leString(nome+" está com sono. Digite a opção para "+nome+" : (Dormir) ou (Permanecer acordado)");
        if (s.equals ("Dormir")){
                // Sempre que o Tamagotchi dorme ele aumenta sua idade em 1 dia. Quando o Tamagotchi chega a 15 dias, ele morre.
                System.out.println("ZZZzzzz...");
                setDiasAcordado(0);
                dia += 1;
                System.out.println("Dia: "+getDia());
                if (dia == 15){
                    System.out.println(nome+" morreu de velhice");
                    setVivo(false);
                }
        }
        // Ao escolher a opção "Permanecer acordado", após permancer acordado 5 vezes, o Tamagotchi irá dormir
        else if (s.equals ("Permanecer acordado")){
                diasAcordado += 1;
                System.out.println("Dias acordado: "+getDiasAcordado());
                if (diasAcordado > 5){
                    System.out.println("ZZZzzzz...");
                    setDiasAcordado(0);
                    dia += 1;
                    System.out.println("Dia: "+getDia());
                    if (dia == 15){
                        System.out.println(nome+" morreu de velhice");
                        setVivo(false);
                    }
                }
        }
        else{
            System.out.println("Você digitou a opção de maneira errada");
            sono();
        }
    }
    
    
    public void fome(){
        String f = Teclado.leString(nome+" está com fome. Digite a opção para "+nome+" : (Comer muito), (Comer pouco) ou (Sem comer)");
        if (f.equals ("Comer muito")){
                // comer muito aumenta 5 quilos, e logo deve dormir. Se o Tamagotchi ultrapassar os 20 quilos ou ultrapassar os 15 dias,
                peso += 5;                                                                 // após ter dormido, ele morre.
                System.out.println("Peso: "+getPeso());
                System.out.println("ZZZzzzz...");
                setDiasAcordado(0);
                dia += 1;
                System.out.println("Dia: "+getDia());
                if (peso > 20 || dia == 15){
                    System.out.println(nome+" morreu");
                    setVivo(false);
                }
        }
        else if (f.equals ("Comer pouco")){
                // aumenta 1 quilo a cada vez que come pouco. Se o Tamagotchi ultrapassar os 20 quilos ele explode.
                peso += 1;
                System.out.println("Peso: "+getPeso());
                if (peso > 20){
                    System.out.println(nome+" explodiu");
                    setVivo(false);
                }
        }
        else if (f.equals ("Sem comer")){
                // não comer emagrece 2 quilos a cada vez. Se o Tamagotchi chegar a zero quilos, ele fica desnutrido e morre.  
                peso += -2;
                System.out.println("Peso: "+getPeso());
                if (peso <= 0){
                    System.out.println(nome+" está desnutrido");
                    setVivo(false);
                }
        }
        else{
            System.out.println("Você digitou a opção de maneira errada");
            fome();
        }
    }
    
    public void entediado(){
        String e = Teclado.leString(nome+" está entediado. Digite a opção para "+nome+" : (Correr 10 minutos) ou (Caminhar 10 minutos)");
        if (e.equals ("Correr 10 minutos")){
                peso += 1;// "Depois de correr por 10 minutos, o Tamagotchi automaticamente emagrece 4 quilos e come muito".
                dia += 1; //  Ou seja, emagrece (-4 quilos), come muito (+5 quilos) e ao comer muito dorme (+1 dia).
                System.out.println("peso: "+getPeso());
                System.out.println("ZZZzzzz...");
                System.out.println("Dia: "+getDia());
                if (peso > 20 || dia == 15){
                    System.out.println(nome+" morreu");
                    setVivo(false);
                }
        }
         // Depois de caminhar, o Tamagotchi sempre emagrece 1 quilo e fica com fome. 
        else if (e.equals ("Caminhar 10 minutos")){
            peso += -1;
            System.out.println("Peso: "+getPeso());
            if (peso <= 0){
                System.out.println(nome+" está desnutrido");
                setVivo(false);
            }
            if (vivo){
             fome();   
            }
        }
        else{
            System.out.println("Você digitou a opção de maneira errada");
            entediado();
        }
    }
}
