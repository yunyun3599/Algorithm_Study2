import java.util.*;

public class Main{
	static int R, C;
	static char[][] puzzle;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static ArrayList<String> word = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        puzzle = new char[R][C];
        for(int i=0; i<R; i++){
            char[] tmp = sc.next().toCharArray();
            for(int j=0; j<C; j++){
                puzzle[i][j] = tmp[j];
            }
        }
        
        for(int i=0; i<R; i++) find(i, 0, 0);
        for(int i=0; i<C; i++) find(0, i, 1);
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(puzzle[i][j]=='#'){
                    for(int k=0; k<2; k++) {
                    	int nx = i+dx[k];
                    	int ny = j+dy[k];
                    	if(nx<R && ny<C) find(nx, ny, k);
                    }
                }
            }
        }
        
        Collections.sort(word);
        System.out.println(word.get(0));
        sc.close();
    }
    
    static void find(int x, int y, int dir){
    	if(puzzle[x][y]=='#') return;
        StringBuilder sb = new StringBuilder("");
        sb.append(puzzle[x][y]);
        int nx = x+dx[dir];
        int ny = y+dy[dir];
        while(nx<R && ny<C && puzzle[nx][ny]!='#'){
            sb.append(puzzle[nx][ny]);
            nx+=dx[dir];
            ny+=dy[dir];
        }
        if(sb.length()>1)
            word.add(sb.toString());
    }
}
