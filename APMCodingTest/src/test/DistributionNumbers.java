package test;

public class DistributionNumbers {
	private int numMax = 0;
	private int boxMax = 0;
	private int InNum = 0;
	private int mNum = 0;
	private int setNum = 0;
	private int[][] box;

	public int[][] getBox(int n, int k) {
		numMax = ((int) Math.pow(2, n)) - 1;
		boxMax = (int) Math.pow(2, k);
		InNum = (int) Math.pow(2, n - k);
		mNum = (numMax + 1) / InNum;
		setNum = (numMax + 1) / 2;
		box = new int[boxMax][InNum];

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
