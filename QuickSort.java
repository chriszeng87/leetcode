import java.util.Random;


public class QuickSort {
	
	public static void quickSort(int[] arr, int low, int high) {
		if(arr == null) {
			return;
		}
		
		if(low >= high) {
			return;
		}
		
		Random random = new Random();
		int randomIndex = random.nextInt(high) % (high-low+1) + low;
		
		int temp = arr[low];
		arr[low] = arr[randomIndex];
		arr[randomIndex] = temp;
		
		int pivotNum = arr[low];
		int left = low;
		int right = high;
		while (left < right) {
			while(arr[right] > pivotNum && left < right) {
				right--;
			}
			arr[left] = arr[right];
			while(arr[left] < pivotNum && left < right) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = pivotNum;
		quickSort(arr, low, left - 1);
		quickSort(arr, left + 1, high);
		
		
	}
	
	static void printArray(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		
		System.out.print("The array is: ");
		for (int val: arr) {
			System.out.print("   " + val);
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2, 4, 3, 1, 5, 8, 6};
		printArray(arr);
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);
	}

}
