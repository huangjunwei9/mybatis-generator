package org.john.springbootcodegenerator.utils;

/**
 * 名称转换工具类
 * 
 * @author JohnDeng
 * @datatime 2019年1月17日上午9:12:56
 */
public class FormatNameUtlis {

	/**
	 * 首字符变成大写
	 * @author JohnDeng
	 * @datatime 2019年1月22日下午2:54:42
	 * @param ColumnName
	 * @return
	 */
	public static String formatNameIndexToUpperCase(String ColumnName) {
		return ColumnName.substring(0, 1).toUpperCase() + ColumnName.substring(1, ColumnName.length());
	}
	/**
	 * 首字符变成小写
	 * @author JohnDeng
	 * @datatime 2019年1月22日下午2:54:42
	 * @param ColumnName
	 * @return
	 */
	public static String formatNameIndexToLowerCase(String ColumnName) {
		return ColumnName.substring(0, 1).toLowerCase() + ColumnName.substring(1, ColumnName.length());
	}

	/**
	 * 去掉下划线，格式名称，驼峰写法，首字符大写
	 * 格式化name user->User user_role->UserRole
	 *
	 * @param ColumnName
	 * @return
	 * @author John
	 * @datatime 2017年10月30日下午3:14:06
	 */
	public static String formatNameCamelbak(String ColumnName) {
		String arr[] = ColumnName.split("_");
		ColumnName = "";
		for (int i = 0; i < arr.length; i++) {
			ColumnName += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
		}
		return ColumnName;
	}

	/**
	 * 首字母大写改成小写 
	 * 格式化name User->user UserRole->userRole
	 *
	 * @param ColumnName
	 * @return
	 * @author John
	 * @datatime 2017年10月31日上午11:08:15
	 */
	public static String formatNameLowerCase(String ColumnName) {
		String arr[] = ColumnName.split("_");
		ColumnName = "";
		ColumnName += arr[0].substring(0, 1).toLowerCase() + arr[0].substring(1);
		for (int i = 1; i < arr.length; i++) {
			ColumnName += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
		}
		return ColumnName;
	}
	
	public static void main(String[] args) {
		System.out.println(formatNameLowerCase("file"));
	}
}
