package test;

import java.util.Scanner;

public class APMCodingTest {

	public static void main(String[] args) {
		while (true) {
			System.out.println("N�� K�� �Է��ϼ���.(1��K<N��16)");
			Scanner s = new Scanner(System.in);
			// ���� (1��K<N��16)
			int n = s.nextInt();
			int k = s.nextInt();
			if (n > 16 || n < k || k > n || k < 1) {
				while (n > 16 || n < k || k > n || k < 1) {
					System.out.println("���� �ٽ� �Է��ϼ���. (1��K<N��16)");
					n = s.nextInt();
					k = s.nextInt();
				}
			}
			DistributionNumbers dn = new DistributionNumbers();
			int[][] arr = dn.getBox(n, k);

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println();
		}

	}

}
