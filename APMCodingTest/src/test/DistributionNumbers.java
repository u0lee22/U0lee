package test;

public class DistributionNumbers {
	private int numMax = 0;
	private int boxMax = 0;
	private int InNum = 0;
	private int[][] box;
	
	private int mNum = 0;
	private int setNum = 0;

	public int[][] getBox(int n, int k) {
		//문제요구사항에 필요한 변수
		numMax = ((int) Math.pow(2, n)) - 1; // (2^n)-1
		boxMax = (int) Math.pow(2, k);       // 2^k
		InNum = (int) Math.pow(2, n - k);    // 2^(n-k)		
		box = new int[boxMax][InNum];        // 2^k개의 박스와 2^(n-k)의 숫자가 들어갈 배열 생성
		
		//중간과정을 위한 변수
		mNum = (numMax + 1) / InNum;	     //(2^n)-1의 숫자를 2^(n-k)	로 나누어 패턴을 만듬
		setNum = (numMax + 1) / 2;           //(2^n)-1의 숫자를 절반으로 나누어 각각의 보수를 구하기 위한 변수
		
		/*
		 * [풀이]
		 * 1.(2^n)-1의 숫자를 2^k개의 박스에 2^(n-k)개 만큼 넣는다.
		 * 2.(2^n)-1의 숫자를 절반으로 나누어 보수를 구한 후 2^k개의 박스에 끝쪽부터 채워 넣는다.
		*/
		
		try {
			int binaryNum = Integer.parseInt(Integer.toBinaryString(numMax));
			for (int i = 0; i < box.length; i++) {
				for (int j = 0; j < (box[i].length / 2); j++) {
					for (int h = 0; h < setNum; h++) {
						if (h % mNum == i) {
							box[i][j] = h;
							int a = Integer.parseInt(Integer.toBinaryString(h));
							String b = "" + (binaryNum - a);
							box[i][box[i].length - j - 1] = Integer.parseInt(b, 2);
							j++;
						}
					}
				}
			}
		} catch (NumberFormatException ex) { // handle your exception
			System.out.println("[Error] NumberFormatException");
		}

		return box;
	}

}
