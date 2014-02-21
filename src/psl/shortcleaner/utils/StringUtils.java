package psl.shortcleaner.utils;

public class StringUtils {
	//join(String array,delimiter)
	public static String join(String r[],String d)
	{
		if (r.length == 0) return "";
		StringBuilder sb = new StringBuilder();
		int i;
		for(i=0;i<r.length-1;i++)
			sb.append(r[i]+d);
		return sb.toString()+r[i];
	}
}
