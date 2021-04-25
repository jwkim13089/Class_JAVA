
import java.util.Scanner;

public class Snake {

    public static void print_bd(int[][] bd)
    {
        for(int i=0; i<bd.length; i++) {
            for(int j=0; j<bd[i].length; j++) {
                if( bd[i][j] == 0 )
                    System.out.print('.');
                else
                    System.out.print('#');
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
   // write your code here
        int[][] bd = new int[10][10];
        int[][] bd_old = new int[10][10];
        int[] x={4,5,6};
        int[] y={5,5,5};
        int stop = 0;

        // board backup
        for(int i=0;i<bd.length;i++) {
            for(int j=0;j<bd[i].length;j++)
                bd_old[i][j] = bd[i][j];

}
        // put snake on the board
        for(int i=0; i<3; i++) {
            bd[y[i]][x[i]]=1;
        }
        // show the board
        print_bd(bd);
        
        for(;;) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        switch(number) {
        
        //�·� �̵�
        case 4 :
         if (x[0]==0 | x[2]==0) continue;
         for(int i=x.length-1; i>0; i--) {
        	 y[i] = y[i-1];
             x[i] = x[i-1];
             }
         x[0] --;
         break;
          
        //��� �̵�
        case 6 :
         if(x[2]==9 | x[0]==9) continue;
         for(int i=x.length-1; i>0; i--) {
        	 y[i] = y[i-1];
             x[i] = x[i-1];
             }
         x[0] ++;
         break;
           
        //���� �̵�
        case 8 :
         if(y[0]==0 | y[2]==0) continue;
         for(int i=y.length-1;i>0;i--) {
        	 y[i] = y[i-1];
        	 x[i] = x[i-1]; 
          }
         y[0]--;
         break;
         
        //�Ʒ��� �̵�
        case 2 :
         if(y[2]==9 | y[0]==9) continue;
         for(int i=x.length-1; i>0; i--) {
        	 y[i] = y[i-1];
             x[i] = x[i-1];
             }
         y[0] ++;
         break;
           
        //Game ������
        case 5 :
         stop = 1;
         break;
         
        default : 
            System.out.println("��");
            break;
            }
        

        // board restore
        for(int i=0;i<bd.length;i++) {
            for(int j=0;j<bd[i].length;j++)
                bd[i][j] = bd_old[i][j];
         }
        for(int i=0; i<3; i++) {
                bd[y[i]][x[i]]=1;
                }
        print_bd(bd);

        //�ڱ� ���� �ε����� ���� ��
        if((x[0] == x[1] & y[0] == y[1]) | (x[0] == x[2] & y[0] == y[2]) | (x[1] == x[2] & y[1] == y[2])) {
         System.out.println("Game over(Dead)");
            break;
        }

        //Game ������
        if(stop == 1) {
         System.out.println("Game over");
         break;
        }
        }
    }

}
