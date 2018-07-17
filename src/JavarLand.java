import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavarLand {
	private static final String numA = "0";
	private static final String numB = "1";
	private static final String numC = "2";
	private static final String numD = "3";
	private static final String numE = "4";
	private static final String stA = "A";
	private static final String stB = "B";
	private static final String stC = "C";
	private static final String stD = "D";
	private static final String stE = "E";
	private static final int NUMBER_CHECK_A = 1; //文字数判定用
	private static final int NUMBER_CHECK_B = 10; //文字数判定用
	private static final int NUMBER_CHECK_C = 1; //先頭文字チェック用

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		String[] inNum = null;
		int s_1 = 0;
		int s_2 = 0;
		int sum = 0;

		/** 入力値の受け取り
		 * inNum[]へ格納
		 * 入力チェック
		 */
		try{
			String line = br.readLine();
			inNum = line.split("\\s");

			for(int i=0; i<inNum.length; i++){
				//文字数判定
				if(inNum[i].length() < NUMBER_CHECK_A || NUMBER_CHECK_B < inNum[i].length()){
					System.out.println(NUMBER_CHECK_A+"文字以上、"+NUMBER_CHECK_B+"文字未満のジャバーランド数値を入力してください");
					throw new Exception();
				}
				//文字列判定
				if(inNum[i].matches("[^A-E]*")){
					System.out.println("\"ABCDE\"の中から任意の値を入力してください");
					throw new Exception();
				}
				//先頭文字チェック
				if(NUMBER_CHECK_C < inNum[i].length() && inNum[i].matches("^[A].*")){
					System.out.println(NUMBER_CHECK_C+"文字より多い値を入力する場合は、\"A\"以外の値から始まる値を入力してください");
					throw new Exception();
				}
			}
		}catch(IOException e){
			System.out.println("予期せぬエラーが発生しました。プログラムを終了します");
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println("プログラムを終了します");
			System.exit(-1);
		}finally{
			br.close();
		}

		/** inNum[]の文字列を1文字ずつnum[]へ格納
		 * num[]をswitch文で判定してジャバーランド数から5進数へ変換しリスト化
		 * 5進数を10進数に変換しながらリスト全体を加算
		 */
		for(int i=0,k=0; i<inNum.length; i++,k++){
			sb = new StringBuilder();
			String[] num = inNum[i].split("");

			for(int j=0; j<num.length; j++){
				switch(num[j]){
				case "A":
					sb.append(numA);
					break;
				case "B":
					sb.append(numB);
					break;
				case "C":
					sb.append(numC);
					break;
				case "D":
					sb.append(numD);
					break;
				case "E":
					sb.append(numE);
					break;
				}
			}

			if(k == 0){
				s_1 += Integer.parseInt(sb.toString(),5);
			}else if(k == 1){
				s_2 += Integer.parseInt(sb.toString(),5);
			} //if文
		} //for文

		/** s_1とs_2を加算
		 * 10進数を5進数に変換→Stringに変換
		 * 5進数をジャバーランド数に変換
		 */
		sum = s_1 + s_2;
		String num = String.valueOf(Integer.toString(sum,5));
		String[] aNum = num.split("");
		sb = new StringBuilder();

		for(int i=0; i<aNum.length; i++){
			switch(aNum[i]){
			case "0":
				sb.append(stA);
				break;
			case "1":
				sb.append(stB);
				break;
			case "2":
				sb.append(stC);
				break;
			case "3":
				sb.append(stD);
				break;
			case "4":
				sb.append(stE);
				break;
			}
		}

		System.out.println(sb.toString());
		System.out.println();
	}
}
