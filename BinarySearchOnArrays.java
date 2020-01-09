import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ソートされた整数を保存する Array と探しているキーが渡されて もしそのキーが Array の中にある場合はキーの Index を返す.
 * そのキーが無ければ -1 を返す.
 *
 * Runtime Complexity: O(logn) Memory Comokexity: O(logn)
 *
 * [処理の流れ] 1.Array 内の最大最小 Index を調べる (high / low とする). 2.中間地点の Index を調べる (mid
 * とする). 3.mid の持つ value が キーと同じであれば mid を返却して終了. 4.mid の value > キーであれば, high =
 * mid - 1 にする. 5.mid の value < キーであれば, low = mid + 1 にする. 6.low > high
 * なってしまった場合には, キーが存在しないことになるので -1 を返却して終了.
 */
public class BinarySearchOnArrays {
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162,
				176, 188, 199, 200, 210, 222));
		int key = 47;
		BinarySearchOnArrays bs = new BinarySearchOnArrays();
		System.out.println(bs.binarySearch(list, key, 0, list.size() - 1));
	}

	private int binarySearch(List<Integer> list, int key, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;
		int midValue = list.get(mid);
		if (key == midValue) {
			return mid;
		} else if (key < midValue) {
			return binarySearch(list, key, low, mid - 1);
		} else {
			return binarySearch(list, key, mid + 1, high);
		}
	}
}
