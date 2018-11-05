import java.io.PrintWriter;

public class MainB {
	static FastScanner sc;
	static PrintWriter out;
	public static void main(String[] args){
		sc = new FastScanner();
		out = new PrintWriter(System.out);
//		solve();
		out.println(solve());
		out.flush();
	}

	static int solve(){
		int N = sc.nextInt();
		int T = sc.nextInt();
		int A = sc.nextInt();
		double min = Integer.MAX_VALUE;
		double tmp = 0;
		int idx = 0;
		for(int i=1;i<=N;i++){
			tmp = Math.abs(A- (T - sc.nextInt() * 0.006));
			if(tmp < min){
				idx = i;
				min = tmp;
			}
		}
		return idx;
	}
}
