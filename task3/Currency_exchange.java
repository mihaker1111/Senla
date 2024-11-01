import java.util.Scanner;

class Currency_exchange{
    //Курс валют по отношению к доллару
    private final double rub=96.64;

    private final double usdt=1;
    private final double eur=1.09;
    private final double cny=7.12;
    private final double kzt=488.15;
    private final double byn=3.32;
    
    public String[] converter(double sum,String cur){
        double k=0;
        if(cur.equals("rub"))
            k=sum/rub;
        else if(cur.equals("usdt"))
            k=sum/usdt;
        else if(cur.equals("eur"))
            k=sum/eur;
        else if(cur.equals("cny"))
            k=sum/cny;
        else if(cur.equals("kzt"))
            k=sum/kzt;
        else if(cur.equals("byn"))
            k=sum/byn;
        else 
        {
            return (new String[0]);

        }
            
        
        
        
        String [] all = {("usdt: "  + (get_usdt(k))),("eur: " +(get_eur(k))),("cny: "  + (get_cny(k))),("kzt: " +(get_kzt(k))),("byn: "  + (get_byn(k))),("rub: "  + (get_rub(k)))};
        return all;
    }
    public double get_rub(double k){
        return rub * k;
    }
    public double get_usdt(double k){
        return usdt * k;
    }
    public double get_eur(double k){
        return eur * k;
    }
    public double get_cny(double k){
        return cny * k;
    }
    public double get_kzt(double k){
        return kzt * k;
    }
    public double get_byn(double k){
        return byn * k;
    }

    public static void main(String[] args)
    {
        Currency_exchange cur = new Currency_exchange();
        while(true){
            System.out.print("Введите сумму:");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextDouble()) {
                System.out.println("Некорректный ввод. Пожалуйста, введите другое число.");
                scanner.next(); 
            }

            
            double userInputSum = scanner.nextDouble();


            System.out.print("Введите валюту(usdt/eur/cny/kzt/byn/rub)(0-для выхода):");
            String userInputСurrency = scanner.next();
            if(userInputСurrency.equals("0")){
                scanner.close();
                return;
            }
            String[] myArray = cur.converter(userInputSum,userInputСurrency);

            for (int i = 0; i  <myArray.length; i++) {

                System.out.print(myArray[i]+'\n');
            }


        
    }
}
}






    
    
    

        
    
    