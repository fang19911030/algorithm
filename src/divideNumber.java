package algorithms;

/**
 * Created by fang on 6/30/17.
 */
public class divideNumber {

    public static String divide(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(num+"=");
        divide(num,2,sb);
        return sb.toString();

    }

    private static void divide(int num, int cur, StringBuilder sb){
        boolean flag = false;
        int tmp = num;
        for(int i=cur;i<=Math.sqrt(num);i++){
            if(num%i==0){
                tmp = num/i;
                cur = i;
                sb.append(i+"*");
                flag=true;
                break;
            }
        }
        if(flag==true){
            divide(tmp,cur,sb);
        }else{
            sb.append(tmp);
        }
    }

    public static void main(String[] args){
        String res = divide( 300);
        System.out.println(res);
    }
}
