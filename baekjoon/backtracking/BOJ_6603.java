package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    static int k;
    static int[] arr;
    static boolean[] visit;
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if(k == 0)
                break;

            arr = new int[k];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = new int[6];
            visit = new boolean[k];
            dfs(0,0);

            System.out.println();
        }
    }

    static void dfs(int start, int depth){
        if(depth == 6){
            for(int i = 0; i < k; i++){
                if(visit[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i = start; i < k; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i, depth+1);
                visit[i] = false;
            }
        }
    }
}
