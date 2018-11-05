import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class MainC {
	static FastScanner sc;
	static PrintWriter out;
	public static void main(String[] args){
		sc = new FastScanner();
		out = new PrintWriter(System.out);
		solve();
//		out.println(solve());
		out.flush();
	}

	static void solve(){
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] prefCntList = new int[N];
		Arrays.fill(prefCntList, 0);
		Integer[] matList = new Integer[M];
		HashMap<Integer, Integer>prefMap = new HashMap<>();
		HashMap<Integer, Integer>nthMap = new HashMap<>();
		int tmp,tmp2;
		for(int i=0;i<M;i++){
			tmp = sc.nextInt();
			tmp2 = sc.nextInt();
			prefMap.put(tmp2, tmp);
			nthMap.put(tmp2, i);
			matList[i]= tmp2;
		}
		String[] strList = new String[M];
		Arrays.sort(matList);
		int tmp3,idx;
		for(int i=0;i<M;i++){
			StringBuilder bfsb = new StringBuilder();
			StringBuilder afsb = new StringBuilder();
			bfsb.append("000000");
			afsb.append("000000");
			idx = nthMap.get(matList[i]);
			tmp3 = prefMap.get(matList[i]);
			bfsb.append(tmp3);
			afsb.append(++prefCntList[tmp3-1]);
			bfsb.append(afsb.substring(afsb.length()-6));
		 	strList[idx] = bfsb.substring(bfsb.length()-12);
		}
		for(int i=0;i<M;i++){
			out.println(strList[i]);
		}
	}
}


class FastScanner {
	private final InputStream in = System.in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;
	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		}else{
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0) {
				return false;
			}
		}
		return true;
	}
	private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
	private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
	public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
	public String next() {
		if (!hasNext()) throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while(isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public long nextLong() {
		if (!hasNext()) throw new NoSuchElementException();
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) {
			throw new NumberFormatException();
		}
		while(true){
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			}else if(b == -1 || !isPrintableChar(b)){
				return minus ? -n : n;
			}else{
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}
	public int nextInt() {
		long nl = nextLong();
		if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
		return (int) nl;
	}
	public double nextDouble() { return Double.parseDouble(next());}
}