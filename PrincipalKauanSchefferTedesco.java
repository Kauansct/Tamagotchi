public class PrincipalKauanSchefferTedesco{
    public static void main(String[] args){
        TamagotchiKauanSchefferTedesco obj = new TamagotchiKauanSchefferTedesco(); //instanciei um objeto "obj" da classe Tamagotchi 
        obj.setNome(Teclado.leString("Digite o nome de seu Tamagotchi:"));         //para inicializar os atributos e invocar os métodos
        System.out.println("O nome de seu Tamagotchi é "+obj.getNome());
        
        // Este while é para sortear os desejos do tamagotchi até a sua morte
        while (obj.getVivo()){
            int evento = (int) (Math.random() * 3);
            switch (evento) {
                case 0:
                    obj.sono();
                    break;
                case 1:
                    obj.fome();
                    break;
                case 2:
                    obj.entediado();
                    break;
            }
        }
    }
}

