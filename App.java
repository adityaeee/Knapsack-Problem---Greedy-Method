import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i,n,m;

        System.out.print("jumlah objek : ");
        n = input.nextInt();
        System.out.print("total bobot : ");
        m = input.nextInt();

        float [] profit = new float[n];
        float [] weight = new float[n];
        float[] PW = new float[n];
        float[] x = new float[n];


        System.out.println("\nInput Profit");
        for(i=0; i<profit.length; i++){
            System.out.print(" -profit "+(i+1)+" : ");
            profit[i]= input.nextInt();
        }

        System.out.println("\nInput Weight");
        for(i=0; i<weight.length; i++){
            System.out.print(" -weight "+(i+1)+" : ");
            weight[i]= input.nextInt();
        }
        System.out.println("\n");

        for(i=0; i<PW.length; i++){
            PW[i] = (profit[i] / weight[i]);
        }
        
        float bobot=0, sisa;
        float XiPi = 0;
        
        while(bobot < m){
            //menentukan nilai terbesar
            float max = 0;
            int xi = 0;
            for(i=0; i<PW.length; i++){
                if(PW[i]>max){
                    max = PW[i];
                    xi = i; 
                }
            }
            // System.out.println("MAX = "+ max);
            PW[xi] = 0;

            if((weight[xi] + bobot) <= m){
                x[xi] = 1;
                XiPi = XiPi + (x[xi] * profit[xi]);
                bobot = bobot + weight[xi];
            }
            
            else{
                sisa = m - bobot;
                x[xi] = sisa / weight[xi];
                XiPi = XiPi + (x[xi] * profit[xi]);
                bobot = bobot + (x[xi] * weight[xi]);
                //System.out.println("sisa : " + sisa);
            }
            // System.out.println("bobot " + bobot);
        }
        System.out.println("Max profit adalah : " + XiPi);
        System.out.println("\n\n\n");
    }
}