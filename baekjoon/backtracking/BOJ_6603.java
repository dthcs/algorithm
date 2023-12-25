package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    static int n;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if(n == 0)
                break;

            arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = new int[6];
            visit = new boolean[n];
            dfs(0,0);

            System.out.println(sb);
        }
    }

    static void dfs(int start, int depth){
        if(depth == 6){
            for(int val:result){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                result[depth] = arr[i];
                dfs(i, depth+1);
                visit[i] = false;
            }
        }
    }
}
