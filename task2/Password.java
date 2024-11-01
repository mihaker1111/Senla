import java.util.Random;
import java.util.Scanner;

class Password{
    private String pas="";
    private Random random;
    Password() {
        random= new Random();
    }
    public int[] reliability_check(int[] rand_pas,int len){
        int digit=0;
        int big_char=0;
        int small_char=0;
        int special_simbols=0;

        for(int i=0; i< rand_pas.length;i++){
            if(rand_pas[i]>47 &&rand_pas[i]<58){ //символ - цифра
                digit++;
            }
            else if(rand_pas[i]>64 &&rand_pas[i]<91){ //символ - большая буква
                big_char++;
            }
            else if(rand_pas[i]>96 && rand_pas[i]<123){ //символ - маленькая буква
                small_char++;
            }
            else{
                special_simbols++; //символ - спецсимвол
            }
        }
        if(digit==0 || big_char==0||small_char==0||special_simbols==0)
        {
            rand_pas[random.nextInt(0,len)] =get_random_ascii_num();
            reliability_check(rand_pas,len);
        }
        return rand_pas;
        
    }


    public int get_random_ascii_num(){
        
        return (random.nextInt(33,126));
    }

    public String create_pas(int len){
        
        pas="";
        if(len<8 ||len>12 )
        {
            return "";
        }
        int[] ascii_password=new int[len];
        for(int i=0; i < len;i++)
        {
            ascii_password[i]=get_random_ascii_num();
        }
        ascii_password=reliability_check(ascii_password,len);
        for(int i=0; i < len;i++)
        {
            pas+=(char)ascii_password[i];
        }
        for (int i = 0; i < ascii_password.length; i++) {
            ascii_password[i] = 0; 
        }
        return (pas);
        //Не самый оптимизированный метод, но пароль заполняется произвольными символами, что повышает его надежность.
    }

    public static void main(String[] args)
    {
        Password cur = new Password();
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите длину пароля от 8 до 12 символов/для выхода ввести '0': ");
            int len;
            while (true) {
                try {
                    len=Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Некорректный ввод. Попробуйте снова: ");
                }
            }
            if(len==0){

                scanner.close();
                return;
            }
            String myPassword=cur.create_pas(len);
            if(myPassword.length()==0){
                System.out.println("Введите корректную длину пароля");
                

            }
            else System.out.println(myPassword);
        }
        
       
    }   

}

    
    
