import java.util.*;

public class ArrayPractice {
	
	public PriorityQueue<Integer> pq;
	
	public ArrayPractice(int length) {
		pq = new PriorityQueue<>(length, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}			
		});
	}

	public static int maxSubArray(int arr[]) {
		int newSum = arr[0];
		int maxSum = arr[0];
		for(int i = 1; i < arr.length; i++ ) {
			newSum = Math.max(newSum + arr[i], arr[i]);
			maxSum = Math.max(maxSum, newSum);
		}
		return maxSum;
	}
	
	public void subMatrix(int arr[][], int rows, int cols) {
			int sub[][] = new int[rows][cols];
			
			for(int i = 0; i < cols; i++)
				sub[0][i] = arr[0][i];
			
			for(int i = 0; i < rows; i ++)
				sub[i][0] = arr[i][0];

			for(int i = 1; i < rows; i++){
				for(int j = 1; j < cols; j++) {
					if(arr[i][j] == 1) {
						sub[i][j] = Math.min(sub[i - 1][j - 1], Math.min(sub[i][j - 1], sub[i - 1][j])) + 1;
					} else {
						sub[i][j] = 0;
					}
				}
			}
			
			int max = 0;
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < cols; j++) { 
					if(sub[i][j] > max)
						max = sub[i][j];
				}
			}
			System.out.println("Maximum size square sub-matrix with all 1s: " + max);
	}
	
	public int maxRevenue(int[] windowsTickets, int tickets) {
		int maxRevenue = 0;
		for(int i = 0; i < windowsTickets.length; i++) {
			pq.offer(windowsTickets[i]);
		}
		
		while(tickets > 0) {
			int temp = pq.poll();
			maxRevenue += temp;
			pq.offer(--temp);
			tickets--;
		}
		return maxRevenue;
	}
	
	public static void longestSubstring(String str) {
		HashSet<Character> set = new HashSet<Character>();
		
		String longestTillNow = " ";
		String maxTillNow = " ";
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(set.contains(c)) {
				longestTillNow = " ";
				set.clear();
			}
			
			longestTillNow += c;
			set.add(c);
			if(longestTillNow.length() > maxTillNow.length())
				maxTillNow = longestTillNow;
		}
		System.out.println("The longest substring without repeating characters is" + maxTillNow + " and it's size is " + (maxTillNow.length()-1));
	}
	
	public static void leaderInArray(int arr[]) {
		if(arr == null || arr.length == 0) {
            return;
        }
		int input = arr.length - 1;
		int currentLeader  = arr[input];
		System.out.print("Leaders in the array are: ");
		for(int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] >= currentLeader) {
				currentLeader = arr[i];
				System.out.print(currentLeader + " ");
			} 
		}
	}
	
	public static void missingNumberinDuplicateArray(int arr1[], int arr2[]) {
		if(arr1 == null && arr2 == null)
			System.out.print("Invalid arrays are empty");
		else if(arr1 == null) {
			if(arr2.length == 1)
				System.out.print("Missing element is " + arr2[0] );
			else
				System.out.print("Invalid input");
		} else if (arr2 == null) {
			if(arr1.length == 1)
				System.out.print("Missing element is " + arr1[0] );
			else
				System.out.print("Invalid input");
		} else {
			int len1 = arr1.length;
			int len2 = arr2.length;
			if(Math.abs(len1 - len2) > 1) {
				System.out.print("Invalid input");
			} else {
				if(len1 > len2) {
					missingNumber(arr1, arr2);
				} else {
					missingNumber(arr2, arr1);
				}
			}
		}
	}
	
	private static void missingNumber(int arr1[], int arr2[]) {
		int result = arr1[0];
		for(int i = 1; i < arr1.length; i++) {
			result = result ^ arr1[i];
		}
		for(int i = 0; i < arr2.length; i++) {
			result = result ^ arr2[i];
		}
		System.out.println("The missing number is " + result);
	}
	
	public static void rearrange(int arr[]) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left < right) {
			while(arr[left] < 0 && left < right)
				left++;
			while(arr[right] > 0 && left < right)
				right--;
			if(left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		
		left = 1;
		int high = 0;
		while(arr[high] < 0)
			high++;
		right = high;
		while(arr[left] < 0 && right < arr.length) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left = left + 2;
			right++;
		}
		
		for(int i : arr)
			System.out.print(i + " ");
	}
	
	public static void printSnakeSequence(int matrix[][]) {
		int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLenth =1;
        int maxRow = 0;
        int maxCol = 0;

        //create result matrix
        int [][] result = new int [rows][cols];

        //if no sequence is found then every cell itself is a sequence of length 1
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                result[i][j] =1;
            }
        }

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(i!=0 || j!=0){
                    //check from left
                    if(i>0 && Math.abs(matrix[i][j]-matrix[i-1][j])==1){
                        result[i][j] = Math.max(result[i][j],
                                result[i-1][j]+1);
                        if(maxLenth<result[i][j]){
                            maxLenth = result[i][j];
                            maxRow = i;
                            maxCol = j;
                        }
                    }

                    //check from top
                    if(j>0 && Math.abs(matrix[i][j]-matrix[i][j-1])==1){
                        result[i][j] = Math.max(result[i][j],
                                result[i][j-1]+1);
                        if(maxLenth<result[i][j]){
                            maxLenth = result[i][j];
                            maxRow = i;
                            maxCol = j;
                        }
                    }
                }
            }
        }
        System.out.println("Max Snake Sequence : " + maxLenth);
        printPath(matrix, result, maxLenth, maxRow, maxCol);
	}
	
	public static void printPath(int[][] matrix, int[][] result, int maxLength, int maxRow, int maxCol) {
		while(maxLength>=1){
            System.out.print(" - " + matrix[maxRow][maxCol]);
            if(maxRow>0 && Math.abs(result[maxRow-1][maxCol]-result[maxRow][maxCol])==1){
                maxRow--;
            }else if(maxCol>0 && Math.abs(result[maxRow][maxCol-1]-result[maxRow][maxCol])==1){
                maxCol--;
            }
            maxLength--;
        }
	}
	
	public static void countDP(int arr[][]) {
		int result[][] = new int[arr.length][arr.length];
		
		result[0][0] = 1;
		
		for(int i = 0; i < result.length; i++)
			result[0][i] = 1;
		
		for(int i = 0; i < result.length; i++)
			result[i][0] = 1;
		
		for(int i = 1; i < result.length; i++)
			for(int j = 1; j < result.length; j++)
				result[i][j] = result[i - 1][j] + result[i][j - 1];
		
		System.out.println(result[arr.length-1][arr.length-1]);
	}
	
	public static void countDPWithObstruction(int arr[][]) {
		int result[][] = arr;
		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j < arr.length; j++) {
				if(result[i][j] != -1) {
					result[i][j] = 0;
					if(result[i - 1][j] > 0)
						result[i][j] += result[i - 1][j];
					if(result[i][j - 1] > 0)
						result[i][j] += result[i][j - 1];
				}
			}
		}
		System.out.print(result[arr.length-1][arr.length-1]);
	}

	@SuppressWarnings("unused")
	private static void printDiagonal(int[][] arrC) {
		int row = 0;
		int col;
		
		while(row < arrC.length) {
			int rowTemp = row;
			col = 0;
			while( rowTemp >= 0) {
				System.out.print(arrC[rowTemp][col] + " ");
				rowTemp--;
				col++;
			}
			System.out.println();
			row++;
		}
		
		col = 1;
		while(col < arrC.length) {
			int colTemp = col;
			row = arrC.length - 1;
			while( colTemp <= arrC.length - 1 ) {
				System.out.print(arrC[row][colTemp] + " ");
				row--;
				colTemp++;
			}
			System.out.println();
			col++;
		}
	}
	
	public static void main(String[] args) {
		
		//int arr[] = {2, -9, 5, 1, -4, 6, 0, -7, 8};
		//System.out.print(maxSubArray(arr));
		
		//longestSubstring("stackoverflow");
		
		
		//int arr1[] = { 98, 23, 54, 12, 20, 7, 27 };
		//leaderInArray(arr1);
		
		
		//int arr2[] = {9, 7, 8, 5, 4, 6, 2, 3, 1};
		//int arr3[] = {2, 4, 3, 9, 1, 8, 5, 6 };
		//missingNumberinDuplicateArray(arr2, arr3);
		
//		int arr4[] = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };
//		rearrange(arr4);
		
//		int arr5[][] = {{1, 2, 1, 2},
//                		{7, 7, 2, 5},
//                		{6, 4, 3, 4},
//                		{1, 2, 2, 5}};
//		printSnakeSequence(arr5);
//		System.out.println();
//		
//		int arrA [][] = {{1,1,1},{1,1,1},{1,1,1}};
//		countDP(arrA);
//		System.out.println();
//		
//		int arrB [][] = {{1,1,1},{1,-1,1},{1,-1,1}};
//		countDPWithObstruction(arrB);
//		System.out.println();
		
//		int arrC[][] = {{1,2,3,4},
//						{5,6,7,8},
//						{9,10,11,12},
//						{13,14,15,16}};
//		printDiagonal(arrC);
		
		
		int[] windowsTickets = { 5, 1, 7, 10, 11, 9 };
		int noOfTickets = 5;
		ArrayPractice ap = new ArrayPractice(windowsTickets.length);
		System.out.println("Max revenue generated by selling " + noOfTickets
				+ " tickets: " + ap.maxRevenue(windowsTickets, noOfTickets));
		
		int[][] arrA = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
		
		ap.subMatrix(arrA, 5, 6);
			
	}
}
