import java.io.PrintWriter;

public class MainA {
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
		return sc.nextInt() + sc.nextInt() / 2;
	}
}
