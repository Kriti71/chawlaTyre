package com.chawla.tyre.utility;

public class NumberToWord {
	private StringBuilder pw(int n, String ch) {
		StringBuilder sb = new StringBuilder();
		String one[] = { " ", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
				" Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen",
				" Nineteen" };

		String ten[] = { " ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty",
				" Ninety" };

		if (n > 19) {
			sb.append(ten[n / 10] + " " + one[n % 10]);
		} else {
			sb.append(one[n]);
		}
		if (n > 0)
			sb.append(ch);
		return sb;
	}

	public static String convert(Double value) {
		NumberToWord a = new NumberToWord();
		int n = value.intValue();
		StringBuilder sb = a.pw((n / 1000000000), " Hundred");
		sb.append(a.pw((n / 10000000) % 100, " Crore"));
		sb.append(a.pw(((n / 100000) % 100), " Lakh"));
		sb.append(a.pw(((n / 1000) % 100), " Thousand"));
		sb.append(a.pw(((n / 100) % 10), " Hundred"));
		sb.append(a.pw((n % 100), ""));
		return String.valueOf(sb);
	}
}
