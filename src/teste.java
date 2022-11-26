public class teste {
    public static void main(String[] args) {
        try{
            moedas teste = new moedas();

            System.out.println(teste.last("USD","EUR"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
