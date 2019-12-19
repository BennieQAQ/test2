package org.wangyu.test;

public class Test {
	/*
	 char charAt(int index):返回指定索引处的 char 值。 
	 int compareTo(String anotherString):按字典顺序比较两个字符串。 
	 int compareToIgnoreCase(String str):按字典顺序比较两个字符串，不考虑大小写。 
	 boolean contains(CharSequence s):当且仅当此字符串包含指定的 char 值序列时，返回 true。 
	 boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束。 
	 boolean equals(Object anObject):将此字符串与指定的对象比较。 
	 boolean equalsIgnoreCase(String anotherString):将此 String 与另一个 String 比较，不考虑大小写。 
	 byte[] getBytes():使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。 
	 int hashCode():返回此字符串的哈希码
	 int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。 
	 int indexOf(String str):返回指定子字符串在此字符串中第一次出现处的索引。 
	 boolean isEmpty():当且仅当 length() 为 0 时返回 true。 
	 int lastIndexOf(int ch):返回指定字符在此字符串中最后一次出现处的索引。 
	 int lastIndexOf(String str):返回指定子字符串在此字符串中最右边出现处的索引。 
	 int length() :返回此字符串的长度。 
	 String replace(char oldChar, char newChar):返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。 
	 String replace(CharSequence target, CharSequence replacement) :使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。 
	 String replaceAll(String regex, String replacement):使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。 
	 String replaceFirst(String regex, String replacement):使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。 
	 String[] split(String regex):根据给定正则表达式的匹配拆分此字符串。 
	 boolean startsWith(String prefix):测试此字符串是否以指定的前缀开始。 
	 String substring(int beginIndex):返回一个新的字符串，它是此字符串的一个子字符串。 
	 String substring(int beginIndex, int endIndex):返回一个新字符串，它是此字符串的一个子字符串。 
	 char[] toCharArray():将此字符串转换为一个新的字符数组 
	 String toLowerCase():使用默认语言环境的规则将此 String 中的所有字符都转换为小写。 
	 String toString():返回此对象本身(它已经是一个字符串！) 
	 String toUpperCase():使用默认语言环境的规则将此 String 中的所有字符都转换为大写。 
	 String trim():返回字符串的副本，忽略前导空白和尾部空白 
	 static String valueOf(xxx b):将xxx类型的b值转成String类型
	*/
	
	public static void main(String[] args) {
		
		String str = "Today is Friday and I am feeling good!";
		
		char values = str.charAt(4);//指定索引处的char值
		System.out.println("values-->"+values);//  
		String str1 = "今天天气真好!";
		String str2 = "今天天气不好!";
		int count = str1.compareTo(str2);//返回字符串与给定参数之间的差值(ascii码值)
		System.out.println("count-->"+count);
		System.out.println("str.contains()-->"+str.contains("feeling")); //是否包含指定的字符串，是则返回true
		System.out.println("str.endsWith()-->"+str.endsWith("good!"));//判断字符串是否以给定的参数为后缀 是则返回true
		
		System.out.println("-----------------------------------------------------");
		String str3 = "hello";
		System.out.println("str3.equals()-->"+str3.equals("hello"));//判断对象是否等于此"对象"，
		System.out.println("str3.equalsIgnoreCase()-->"+str3.equalsIgnoreCase("HEllO"));//与其他的字符串相比较,不考虑大小写
		byte[] strArray = str3.getBytes();//将此 String 编码为 byte 序列
		for(int i=0;i<str3.length();i++) {
			System.out.print(strArray[i]+" ");
		}
		System.out.println();
		System.out.println("-----------------------------------------------------");
		String str4 = "HelloWord!";
		String str5 = "HelloWord!";
		System.out.println("str4.hashCode()-->"+str4.hashCode());//返回的hashcode值为对象在内存中的某块地址的虚拟出来的数值,整数的形式表现出来,如果两个对象的hashcode值一样说明指向的都是同一个对象
		System.out.println("str5.hashCode()-->"+str5.hashCode());//String对象中有常量池的存在 所以并没有在创建一个对象，两个引用类型指向的同一个对象,String 重写了Object类的hashcode方法,是比较两个数值
		System.out.println("str4.indexOf(101)-->"+str4.indexOf(101));//返回指定字符在此字符串中第一次出现处的索引。 1-->e
		System.out.println("str4.indexOf()-->"+str4.indexOf("e"));
		
		System.out.println("-----------------------------------------------------");
		String  str6 = "empty";
		System.out.println("str6.isEmpty()-->"+str6.isEmpty());//false,判断字符串长度是否为0，当length()-->0的时候,值为true
		System.out.println("str6.indexOf()-->"+str6.indexOf("y"));//key-->4,value-->y
		System.out.println("str6.length()-->"+str6.length());
		System.out.println("str6.replace()-->"+str6.replace("e", "E"));
		
		System.out.println("-----------------------------------------------------");
		String str7 = "www.baidu.com";
		System.out.println("str7.replaceAll()-->"+str7.replaceAll("(.*)baidu(.*)","hello"));//如果给定的regex正则表达式匹配此字符串，那么就用给定的replacement替换。
		System.out.println("str7.replaceAll()-->"+str7.replaceAll("(.*)goole(.*)","hello"));//如果不匹配则不替换,并且返回原来的字符串
//		String[] StrArray = str7.split("(.*)baidu(.*)");
//		System.out.println(StrArray);
//		for(int i=0;i<StrArray.length;i++) {
//			System.out.print(StrArray[i]);
//		},我也不会这个方法，用都没用过
		System.out.println("str7.startsWith()-->"+str7.startsWith("www"));//判断是否为前缀，是返回true，否则返回false
		
		System.out.println("-----------------------------------------------------");
		String str8 = "I have a dream";
		System.out.println("str8.substring()-->"+str8.substring(2));//返回一个在原有的字符串的基础上给定的索引处到最后索引的字符串
		System.out.println("str8.substring()-->"+str8.substring(7, 14));//给定新的前后索引截取处新的字符串
		String str9 = "ApplicationClassPath";
		char[] charArray = str9.toCharArray();//将字符串拆分返回一个字符类型的数组
		System.out.print("拆分字符串-->");
		for(int i=0;i<charArray.length;i++) {
			System.out.print(charArray[i]+" ");
		}
		System.out.println();
		String str10 = "HelloWORD";
		System.out.println("str10.toLowerCase()-->"+str10.toLowerCase());//字符串转小写
		System.out.println(str10.toString());//返回字符串本身
		System.out.println("str10.toUpperCase()-->"+str10.toUpperCase());//字符串转大写
		
		
		System.out.println("-----------------------------------------------------");
		String str11 = "   welcome to nanjing          ";
		System.out.println("str11.trim()-->"+str11.trim());//去除前后空格
		System.out.println("String.valueOf()-->"+String.valueOf(555555555));//将其他类型的值转为String，我是int转成String类型
	}

}
