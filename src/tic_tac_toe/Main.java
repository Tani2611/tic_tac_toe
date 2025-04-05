package tic_tac_toe;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		start();
	}

	
	static void start() {
		Scanner in = new Scanner(System.in);
		int error = 0;
		String[][] matrix = { { "　", "１", "２", "３" }, { "１", "□", "□", "□" }, { "２", "□", "□", "□" },{ "３", "□", "□", "□" }, };
		String[][] x = new String[4][4];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				x[i][j] = matrix[i][j];
			}
		}

		//スタートーーーーーーーーーーーーーーーーーーーーーーーー
		while (true) {
		//Player 1ーーーーーーーーーーーーーーーーーーーーーーーー
			do {
				System.out.print("1Player(行)=>"); int p1x = in.nextInt();
				System.out.print("1Player(列)=>"); int p1y = in.nextInt();
				
				if (p1x > 3 || p1y > 3) {
					System.out.println("Input Error"); error = 1;
					break;
				} else {
					switch (x[p1x][p1y]) {
						case "〇", "×": System.out.println("Input Error"); error = 1; break;
						default: x[p1x][p1y] = "〇"; break;
					}
				}
			} while (error == 1);
			//チェック
			if (check1(x)) {
				System.out.println("Bingo!! 1Player Win!");
				break;
			}
			//Player 2ーーーーーーーーーーーーーーーーーーーーーーーー
			do {
				System.out.print("2Player(行)=>"); int p2x = in.nextInt();
				System.out.print("2Player(列)=>"); int p2y = in.nextInt();
				if (p2x > 3 || p2y > 3) {
					System.out.println("Input Error"); error = 1;
				} else {
					switch (x[p2x][p2y]) {
						case "〇", "×": System.out.println("Input Error"); error = 1; break;
						default: x[p2x][p2y] = "×"; break;
					}
				}
			} while (error == 1);
			//チェック
			if (check2(x)) {
				System.out.println("Bingo!! 2Player Win!");
				break;
			}
			
		}//while
	}//start()

	static boolean check1(String[][] x) {
		int[][] bingo = new int[4][4];

		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				switch (x[i][j]) {
					case "〇": bingo[i][j] = 1; break;
					case "×", "□": bingo[i][j] = 0; break;
				}
			}
		}
		print(x);
		return bingoCheck(bingo);
	}

	static boolean check2(String[][] x) {
		int[][] bingo = new int[4][4];

		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				switch (x[i][j]) {
					case "×": bingo[i][j] = 1; break;
					case "〇", "□": bingo[i][j] = 0; break;
				}
			}
		}
		print(x);
		return bingoCheck(bingo);
	}
	
	static void print(String[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}

	static boolean bingoCheck(int[][] bingo) {
		int check = 0;
		if (bingo[1][1] == 1 && bingo[2][1] == 1 && bingo[3][1] == 1 ||
				bingo[1][2] == 1 && bingo[2][2] == 1 && bingo[3][2] == 1 ||
				bingo[1][3] == 1 && bingo[2][3] == 1 && bingo[3][2] == 1 ||
				bingo[1][1] == 1 && bingo[1][2] == 1 && bingo[1][3] == 1 ||
				bingo[2][1] == 1 && bingo[2][2] == 1 && bingo[2][3] == 1 ||
				bingo[3][1] == 1 && bingo[3][2] == 1 && bingo[3][3] == 1 ||
				bingo[1][1] == 1 && bingo[2][2] == 1 && bingo[3][3] == 1 ||
				bingo[1][3] == 1 && bingo[2][2] == 1 && bingo[3][1] == 1) {
			check = 1;
		}
		return check > 0;
	}
}
