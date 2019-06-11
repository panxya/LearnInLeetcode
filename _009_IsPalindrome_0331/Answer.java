package _009_IsPalindrome_0331;

public class Answer {

	public static void main(String[] args) {
		String str = "0-1";
		int a = myAtoi(str);
		System.out.println(a);
	}

	public static int myAtoi(String str) {

		if (str == null || str.length() == 0)
			return 0;
		char[] array = str.toCharArray();
		long result = 0; // 要返回的结果result
		int count = 0; // 记录‘+’或者‘-’出现的次数
		int num = 0; // 判断空格出现的位置
		int flag = 1; // 正数还是负数
		for (int i = 0; i < array.length; i++) {
			Character c = array[i];
			if (c >= '0' && c <= '9') {
				result = result * 10 + c - '0';
				// 判断是否溢出
				if (flag == 1 && result > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (flag == -1 && -result < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				num++;
			} else if (c == ' ' && num == 0 && count == 0)
				continue;
			else if (c == '+' && count == 0) {
				count = 1;

			} else if (c == '-' && count == 0) {
				flag = -1;
				count = 1;
//			} else if (c == '-' && count == 0 && array[(i - 1)] == 0) {
//				flag = -1;
//				count = 1;
			} else {
				return (int) (flag * result);

			}
			
		}
		return (int) (flag * result);

	}
}