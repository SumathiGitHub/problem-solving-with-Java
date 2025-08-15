package com.practice.java8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONObject;

public class ParsingExercises {

	public static void main(String[] args) {
		
		ParsingExercises pe = new ParsingExercises();
		pe.parsingExercise01();
		pe.parsingExercise02();
		pe.parsingExercise03();
		pe.parsingExercise04();
		pe.parsingExercise05();
		pe.parsingExercise06();
		pe.parsingExercise07();
		pe.parsingExercise08();
		pe.parsingExercise09();
		pe.parsingExercise10();
		pe.parsingExercise11();
		pe.parsingExercise12();
		pe.parsingExercise13();
		pe.parsingExercise14();
		pe.parsingExercise15();
		pe.parsingExercise16();
		pe.parsingExercise17();
		pe.parsingExercise18();

	}

	/*Exercise 1: Parse a String to int and handle invalid input gracefully.
	Problem Statement:
		Write a Java program that takes several strings representing integers. For each string:
		If the string is null or empty, print an appropriate message.
		Try to parse it into an int.
		If parsing fails (invalid format), catch the exception and print a friendly error message.
		If parsing succeeds, print the integer value.
	 */
	
	public void parsingExercise01() {

		String[] inputs = { "100", "200", "abc", "300", null, "300xyz", "400" };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else {
				try {
					int no = Integer.parseInt(value.trim());
					System.out.println("Parsed int value ::: " + no);
				} catch (Exception e) {
					System.out.println("Error: " + value + " is not a valid integer.");
				}
			}
		}
		System.out.println("1---------------------------------------------------------------------");
	}

	/*Exercise 2: Parse a String to double and handle invalid input gracefully.
	Problem Statement:
		Write a Java program that takes multiple strings representing decimal numbers. For each string:
		If the string is null or empty, print an appropriate message.
		Try to parse it into an double.
		If parsing fails (invalid format), catch the exception and print a friendly error message.
		If parsing succeeds, print the number formatted to 2 decimal places.
	 */
	
	public void parsingExercise02() {

		String[] inputs = { "100.895", "89.780", "65.80", null, "300xyz", "34.50" };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else {
				try {
					double no = Double.parseDouble(value);
					///format to 2 deciaml places
					String formatted = String.format("%.2f", no);
					System.out.println("Parsed decimal value ::: " + formatted);
				} catch (Exception e) {
					System.out.println("Error: " + value + " is not a valid decimal number.");
				}
			}
		}
		System.out.println("2---------------------------------------------------------------------");
	}
	
	
	/*Exercise 3: Parse a string to a float and check if the value is between 0.0 and 100.0.
	Problem Statement:
	/Write a Java program that takes multiple strings representing decimal numbers. For each string:
	 If the string is null or empty, print a message and skip it.
	 Try to parse it into a float.
	 If parsing fails, catch the exception and display an error message.
	 If parsing succeeds, check whether the value is between 0.0 and 100.0(inclusive).
	 Print a message indicating whether the value is within range or out of range.
	 */
	
	public void parsingExercise03() {

        String[] inputs = { "100.90", "xyz67", "90.35", "45.50", "abc", null, "300" };

        for (String value : inputs) {
            if (value == null || value.trim().isEmpty()) {
                System.out.println("Skipped : Value Should not be null or empty...! ");
            } else {
                try {
                    float no = Float.parseFloat(value.trim());
                    if (no >= 0.0 && no <= 100.0) {
                        System.out.println(no + " - Value is within a range!");
                    } else {
                        System.out.println(no + " - Value is out of range!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + value + " is not a valid float number.");
                }
            }
        }
        System.out.println("3--------------------------------------------------------------------------");
    }
	
	
	/*Exercise 4: Parse a string to a long and compare it with Long.MAX_VALUE and Long.MIN_VALUE.
	  Problem Statement:
	  Write a Java program that takes multiple strings representing whole numbers. For each string:
	  If the string is null or empty, print a message and skip it.
	  Try to parse it into a long.
	  If parsing fails, catch the exception and display an error message.
	  If parsing succeeds, compare it with Long.MAX_VALUE and Long.MIN_VALUE.
      Print a message indicating:
      If it equals Long.MAX_VALUE or Long.MIN_VALUE
      If it is less than Long.MIN_VALUE or greater than Long.MAX_VALUE (should not happen unless manually checking)
      Or if it’s just within the range.
	 * */
	
	public void parsingExercise04() {

		String[] inputs = { "100", "9223372036854775807", "-9223372036854775808", 
				"999999999999999999999999", null, "abc" };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else {
				try {
					long no = Long.parseLong(value.trim());
					if(no==Long.MAX_VALUE) {
						System.out.println("Maximum value is ::: " + no);
					}
					else if(no==Long.MIN_VALUE) {
						System.out.println("Minimum value is :::" + no);
					}
					else {
						System.out.println(no + " Number is within a long range!");
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: " + value + " is not a valid number.");
				}
			}
		}
		System.out.println("4-------------------------------------------------------------------");
	}
	
	
	//Exercise 5:Parse a string to a boolean ignoring case ("True", "FALSE").
	/*Write a Java program that takes an array of strings representing boolean values, 
	Parse each string to a boolean ignoring case, and print the result.
	Treat only "true" (case-insensitive) as true; everything else becomes false.
	Handle null and empty strings safely.
	Log invalid or unexpected boolean strings for clarity.
	 * */
	
	public void parsingExercise05() {
		
		String[] inputs = { 
			    "true", 
			    "TRUE", 
			    "TrUe", 
			    "false", 
			    "FALSE", 
			    "FaLsE", 
			    "yes", 
			    "no", 
			    "1", 
			    "0", 
			    null, 
			    "", 
			    "   ", 
			    "maybe" 
			};

		for(String value :inputs) {
			if(value==null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
				continue;
			}
			try {
				boolean ip = Boolean.parseBoolean(value);
				System.out.println("Parsed boolean value ::: " + ip);
			}
			catch(NumberFormatException e) {
				System.out.println("Error: " + value + " is not a valid boolean string.");
			}
		}
		
		System.out.println("5-----------------------------------------------------------------------");
	}
	
	
	//Exercise 6: Extract and parse the first character from a String
	/*Write a Java program that takes an array of strings and:
	Extracts the first character of each non-empty string.
	Parses it into the appropriate type (for example, as a char or convert to its ASCII integer value).
	Handles null, empty strings, and strings with only spaces gracefully.*/
	
	
	public void parsingExercise06() {

		String[] inputs = { "Sumathi", "Malathi", "Karthik", "Arun" };
		for (String name : inputs) {
			if (name == null || name.trim().isEmpty())
				System.out.println("Skipped : Value Should not be null or empty...! ");
			else {

				char first = name.charAt(0);
				int ascii = name.charAt(0);
				System.out.println("First char ::: " + first + " -ASCII ::: " + ascii);
			}
		}

		System.out.println("6------------------------------------------------------------------------------------");
	}
	
	
	//Exercise 7: Parse hexadecimal String (e.g. "1A3F") to int
	/*Write a Java program that takes several strings representing hexadecimal numbers (e.g., "1A3F", "FF", "abc123").
	For each string:
	If null or empty, skip with a message.
	Try to parse it into an int using base 16.
	If parsing fails, catch the exception and display an error.
	If parsing succeeds, print both the decimal and binary equivalent.
	*/
	
	public void parsingExercise07() {

		String[] inputs = { "1A3F", "FF", "abc123", null, "", "XYZ" };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else { 
				try {
					int decimalValue = Integer.parseInt(value, 16);
					System.out.println("Decimal equivalent of " + value+ " is ::: " + decimalValue);
					// printing binary equvalent
					String binaryValue = Integer.toBinaryString(decimalValue);
					System.out.println("Binary equivalent of " + value + " is ::: " + binaryValue);
				} catch (NumberFormatException e) {
					System.out.println("Error: " + value + " is not a valid hexadecimal String.");
				}
			}
		}
		System.out.println("7-----------------------------------------------------------------------");
	}
	
	
	//Exercise 8: Parse binary String (e.g. "101101") to int
	/*Write a Java program that takes an array of strings representing binary numbers (e.g., "101101", "1111", "100000").
	For each string:
	If null or empty, skip it.
	Try to parse it into an integer using base 2:
	If parsing fails (invalid binary characters), catch the exception.
	Print:The decimal equivalent.
	The hexadecimal equivalent*/
	
	public void parsingExercise08() {

		String[] inputs = { "101101", "1111", "100000", null, "", "12345" };
		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else {
				try {
					
					int decimalValue = Integer.parseInt(value, 2);					
					System.out.println("Decimal equivalent of " + value + "is " + decimalValue);
					String hexadecimalValue = Integer.toHexString(decimalValue);					
					System.out.println("Hexadecimal equivalent of " + value + "is " + hexadecimalValue );
				} catch (NumberFormatException e) {
					System.out.println("Error: " + value + " is not a valid binary String.");
				}
			}
		}
		System.out.println("8------------------------------------------------------------------------");
	}
	
	
	// Exercise 9: Parse Octal String to Integer
	/*Write a Java program that takes several strings representing octal numbers (e.g., "755", "17", "1234").
	For each string:
	If the string is null or empty, skip it with a clear message.
	Attempt to parse the string into an integer using base 8 (Integer.parseInt(value, 8)).
	If parsing fails (invalid characters or out-of-range value), catch the exception and display an error message.
	If parsing succeeds, display:
	Decimal equivalent of the octal number.
	Binary equivalent of the octal number.*/
	
	public void parsingExercise09() {

		String[] inputs = { "755", "17", "1234", null, "", "89" };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else {
				try {

					int decimalValue = Integer.parseInt(value, 8);
					System.out.println("Decimal equivalent of the octal number " + value + " is " + decimalValue);
					String binary = Integer.toBinaryString(decimalValue).replaceAll("(.{4})(?!$)", "$1 ");
					System.out.println("Binary equivalent of the octal number " + value + " is " + binary);
				} catch (NumberFormatException e) {
					System.out.println("Error: " + value + " is not a valid octal String.");
				}
			}
		}
		System.out.println("9---------------------------------------------------------------------------");
	}
	
	
	//Exercise 10: Parse a comma-separated numbers string into an integer array.
	/*You will be given a string of comma-separated values such as "10, 20, 30, 40".
	The program should:
	Check if the input string is null or empty — if so, print a message and skip processing.
	Split the string by commas.
	For each value:Trim spaces.
	Try to parse it into an int.
	If parsing fails, print an error message for that element and skip it.
	Store successfully parsed integers in an array.
	Print the final integer array.*/

	public void parsingExercise10() {

		String[] inputs = { "10, 20, 30, 40", "5, 15, abc, 25", null, "", "100, 200, -50, xyz, 300",
				"  7 ,   14,21 , 28 " };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else {
				System.out.println("Parsing: " + value);
				String[] splitedString = value.split(",");

				for (String s : splitedString) {
					String trimStr = s.trim();
					try {
						int valInput = Integer.parseInt(trimStr);
						System.out.println("Parsed Integer ::: " + valInput);
					}

					catch (NumberFormatException e) {
						System.out.println("Error: " + value + " is not a valid element.");
					}
				}
			}
		}

		System.out.println("10---------------------------------------------------------------------");
	}
	
	
	
	//Exercise 11: Parse a CSV line with mixed data types (int, double, boolean, String)
	//Write a Java program that takes several CSV strings, where each value may represent a different data type:
	/*For each value in the CSV:
		If the value is null or empty, skip it with a message.
		Try parsing it to int. If that fails, try parsing to double.
		If that also fails, try parsing to boolean.
		If all parsing fails, treat it as a plain String.
		Print the detected data type and its parsed value.*/
	
	public void parsingExercise11() {

		String[] inputs = { "123, 45.67, true, Hello", "999, false, 3.1415, Java", null, "", "42, yes, 0.75, Goodbye",
				"abc, 100, 200.5, FALSE" };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else {
				System.out.println("Parsing ::: " + value);
				String[] splittedString = value.split(",");

				for (String part : splittedString) {
					String trimStr = part.trim();

					if (trimStr.isEmpty()) {
						System.out.println("Empty element found..!");
						continue;
					}
					/// parsing int value
					try {
						int intValue = Integer.parseInt(trimStr);
						System.out.println("Integer value::: " + intValue);
						continue;
					} catch (NumberFormatException ignored) {
					}

					/// parsing to double
					try {
						double doubleVal = Double.parseDouble(trimStr);
						System.out.println("Double value ::: " + doubleVal);
						continue;
					} catch (NumberFormatException ignored) {
					}

					/// parsing to boolean
					if(trimStr.equalsIgnoreCase("true") || trimStr.equalsIgnoreCase("false")) {
						boolean booleanVal = Boolean.parseBoolean(trimStr);
						System.out.println("Boolean value ::: " + booleanVal);
						continue;				
					}
						

					System.out.println("String ::: " + trimStr);
				}
			}
		}

		System.out.println("11--------------------------------------------------------------------------");
	}

	
	
	//Exercise 12: Parse a date string in format "dd-MM-yyyy" to java.util.Date
	/*Write a Java program that takes several strings representing dates in the format dd-MM-yyyy.
	For each string:
	If the string is null or empty, skip with a message.
	Try to parse it into a java.util.Date using SimpleDateFormat.
	If parsing fails (invalid date or wrong format), display an error message.
	If parsing succeeds, print the date in both:
	the original format (dd-MM-yyyy)
	and another format, e.g. (EEEE, MMM dd, yyyy for a more readable form).*/
	
	public void parsingExercise12() {

		String[] inputs = { "13-08-2025", 
				"31-02-2024", // invalid date
				null, "", "01-01-2000", "15-12-1999" };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Skipped : Value Should not be null or empty...! ");
			} else {
				try {
					SimpleDateFormat orginalFormat = new SimpleDateFormat("dd-MM-yyyy");
					orginalFormat.setLenient(false);
					Date date = orginalFormat.parse(value);
					
					String orginalString  = orginalFormat.format(date);
					System.out.println("Original format::: " + orginalString);

					SimpleDateFormat readableFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy");
					String ready = readableFormat.format(date);
					System.out.println("Readable format ::: " + ready);
				} catch (Exception e) {
					System.out.println("Invalid date format::: " + value);
				}
			}
		}
		System.out.println("12--------------------------------------------------------------------------");

	}
	
	
	
	//Exercise 13: Parse a datetime string "yyyy-MM-dd HH:mm:ss" to java.time.LocalDateTime
	/*Write a program that parses a date-time string in the format "yyyy-MM-dd HH:mm:ss" into a java.time.LocalDateTime object.
	 The program should:
	 Skip and report inputs that are null or empty.
	 Parse valid date-time strings into a LocalDateTime object using DateTimeFormatter.
     Display the date-time in both the original format and a more human-readable format (e.g., "Wednesday, Aug 13 2025 14:30:00").
     Detect and handle invalid date-time inputs (e.g., incorrect format, non-existent dates like "2023-02-29") by printing an error message.
	 * */
	
	public void parsingExercise13() {
		
		String[] inputs = {
	            "2025-08-13 14:30:00",
	            "1999-12-31 23:59:59",
	            null,
	            "",
	            "2024-02-29 12:00:00", /// valid leap year date
	            "2023-02-29 08:15:30"  /// invalid date
	    };
		
		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Value should not be null or empty!");
			} else {
				try {
					String[] parts = value.split(" ");
					if (parts.length != 2) {
						throw new IllegalArgumentException("Invalid datetime format");
					} else {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						LocalDateTime dateTime = LocalDateTime.parse(value, formatter);
						String orginalFormat = formatter.format(dateTime);
						System.out.println("Original format is ::: " + orginalFormat);

						DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy HH:mm:ss");
						String anotherFormat = newFormatter.format(dateTime);
						System.out.println("Readable format is ::: " + anotherFormat);
					}

				} catch (Exception e) {
					System.out.println("Invalid datetime format ::: " + value);
				}
			}
		}
		System.out.println("13------------------------------------------------------------------------------");
	}
	
	
	
	//Exercise 14: Parse a time string "HH:mm:ss" to java.time.LocalTime
	/*Given an array of time strings in "HH:mm:ss" format, parse each string into a java.time.LocalTime.
	  Skip if the string is null or empty.
	  Reject if the time is invalid (e.g., "25:00:00", "12:61:00", "12:00:99").
	  Print both the original format and a more human-readable format (e.g., "hh:mm a" for 12-hour clock with AM/PM).
	 */
	
	public void parsingExercise14() {
		
		String[] inputs = { "14:30:00", "23:59:59", "00:00:00", 
				"25:00:00", /// invalid hour
				null, "", 
				"12:61:00" /// invalid minute
		};
		
		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Value should not be null or empty!");
			} else {
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
							.withResolverStyle(ResolverStyle.STRICT);
					LocalTime time = LocalTime.parse(value, formatter);
					String originalString = formatter.format(time);
					System.out.println("Original format is ::: " + originalString);

					DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("hh:mm a");
					String readableString = newFormatter.format(time);
					System.out.println("Readable format is ::: " + readableString);

				} catch (Exception e) {
					System.out.println("Invalid time format ::: " + value);
				}
			}

		}
		System.out.println("14--------------------------------------------------------------------------------");
	}
	
	
	
	
	//Exercise 15: Parse an ISO 8601 date-time string to java.time.ZonedDateTime
	
	public void parsingExercise15() {
		
		  String[] inputs = {
			        "2025-08-13T14:30:00+05:30[Asia/Kolkata]",
			        "2023-02-29T08:15:30Z", /// invalid date (Feb 29 on non-leap year)
			        "1999-12-31T23:59:59-05:00[America/New_York]",
			        null, "",
			        "2024-02-29T12:00:00+01:00[Europe/Paris]" /// valid leap year
			    };
		
				for (String value : inputs) {
					if (value == null || value.trim().isEmpty()) {
						System.out.println("Value should not be null or empty!");
					} else {
						try {
							ZonedDateTime zonedDateTime = ZonedDateTime.parse(value,
									DateTimeFormatter.ISO_ZONED_DATE_TIME);
							System.out.println("Parsed zone date and time is ::: " + zonedDateTime);

							DateTimeFormatter formatter = DateTimeFormatter
									.ofPattern("EEEE, MMM dd yyyy HH:mm:ss zzzz");
							String readableFormat = formatter.format(zonedDateTime);
							System.out.println("Readable zone date and time is ::: " + readableFormat);
						} catch (Exception e) {
							System.out.println("Invalid time format ::: " + value);
						}
					}
				}
				
		System.out.println("15-----------------------------------------------------------------------------");
	}
	
		
	
	
	//Exercise 17: Parse a String with extra spaces (e.g. "  123  ") to int
	/*Write a program to parse a string containing extra spaces into an integer.
	The input string may have leading and/or trailing spaces (e.g., " 123 ").
	Ignore null or empty inputs.
	Trim the spaces before parsing.
	If the trimmed string represents a valid integer, print the integer value.
	If it is not a valid integer, print an error message.
	The program should handle both positive and negative integers.*/
	
	public void parsingExercise16() {
		
		String[] inputs = {
			    "  123  ",   /// extra spaces around
			    "   -45",    /// extra leading spaces, negative number
			    "78   ",     /// extra trailing spaces
			    "   0   ",   /// zero with spaces
			    "abc",       /// invalid integer
			    null,        /// null input
			    "",          /// empty string
			    "   "        /// only spaces
			};
		
			for (String value : inputs) {
				if (value == null || value.trim().isEmpty()) {
					System.out.println("Value should not be null or empty!");
				} else {
					try {
						System.out.println("Parsing input ::: " + value);
						int trimmedInteger = Integer.parseInt(value.trim());
						System.out.println("Integer input ::: " + trimmedInteger);
					} catch (NumberFormatException e) {
						System.out.println("Invalid string input : " + value);
					}
				}
			}

		System.out.println("16---------------------------------------------------------------------------------------");
		}
	
	
	
	
	//Exercise 18: Parse a String with currency symbols (e.g. "$123.45") to double
	/*Given a string containing a currency symbol (e.g., $123.45, ₹500, €78.9), extract the numeric part, 
	 *remove the symbol, and parse it into a double. Handle cases with extra spaces, invalid formats, or null/empty values.
	*/
	
	public void parsingExercise17() {
		String[] inputs = {
			    "$123.45",          /// USD format
			    "₹500",             /// Indian Rupee
			    "€78.9",            /// Euro
			    "  £1,234.56  ",    /// Pounds with spaces and comma
			    "-$99.99",          /// Negative amount
			    "JPY 1000",         /// Currency code prefix
			    null,               /// Null input
			    "",                 /// Empty string
			    "   ",              /// Only spaces
			    "$abc",             /// Invalid numeric part
			    "CAD -250.75"       /// Canadian dollars with negative sign
			};

			for (String value : inputs) {
				if (value == null || value.trim().isEmpty()) {
					System.out.println("Value should not be null or empty!");
				} else {
					try {
						String numericOnly = value.trim().replaceAll("[^0-9+-\\,.]", "");
						numericOnly = numericOnly.replace(",", "");

						double outputVal = Double.parseDouble(numericOnly);
						System.out.println("Parsing double value afer extracting numeric part only :: " + outputVal);
					} catch (Exception e) {
						System.out.println("Invalid string input ::: " + value);
					}
				}

			}
			System.out.println("17-------------------------------------------------------------------------------------");
		}
	
	

	
	//Exercise 19: Parse JSON string containing numeric fields (using org.json or Jackson)
	/*Given a JSON string containing one or more numeric fields, parse the JSON and extract those numeric values 
	 into Java primitive types (int, double, long, etc.).
     The program should handle:
     Valid numeric fields (integers, decimals)
     Missing fields (graceful handling with defaults)
     Invalid numeric formats (throw or catch exceptions)
     Null or empty JSON string
     Different numeric types (e.g., integer for quantity, double for price, long for timestamp)*/
	
	public void parsingExercise18() {

	    String[] inputs = {
	        "{\"id\": 101, \"price\": 45.75, \"quantity\": 10}",      // valid
	        "{\"id\": 202, \"price\": 99.99}",                        // missing quantity
	        "{\"id\": 303, \"price\": \"abc\", \"quantity\": 5}",     // invalid price format
	        "{\"id\": null, \"price\": 12.5, \"quantity\": null}",    // null fields
	        "{}",                                                     // empty JSON
	        null,                                                     // null input
	        "",                                                       // empty string
	        "   ",                                                    // spaces only
	        "{\"id\": 999, \"price\": -500.75, \"quantity\": -3}"     // negative values
	    };

		for (String value : inputs) {
			if (value == null || value.trim().isEmpty()) {
				System.out.println("Value should not be null or empty!");
			} else {
				try {
					JSONObject obj = new JSONObject(value);

					// Safe parsing using optX
					int id = parseIntSafely(obj, "id");
					double price = parseDoubleSafely(obj, "price");
					int quantity = parseIntSafely(obj, "quantity");

					System.out.println("id ::: " + id + ", price ::: " + price + ", quantity ::: " + quantity);

				} catch (Exception e) {
					System.out.println("Invalid JSON structure ::: " + value);
				}
			}
		}
		System.out.println("18-------------------------------------------------------------------------------------");
	}

	/// Helper for safe int parsing
	private int parseIntSafely(JSONObject obj, String key) {
		try {
			if (obj.has(key) && !obj.isNull(key)) {
				return Integer.parseInt(obj.get(key).toString());
			}
		} catch (NumberFormatException e) {
			System.out.println("Warning: '" + key + "' is not a valid integer.");
		}
		return 0;
	}

	/// Helper for safe double parsing
	private double parseDoubleSafely(JSONObject obj, String key) {
		try {
			if (obj.has(key) && !obj.isNull(key)) {
				return Double.parseDouble(obj.get(key).toString());
			}
		} catch (NumberFormatException e) {
			System.out.println("Warning: '" + key + "' is not a valid double.");
		}
		return 0.0;
	}
	
	
	
	
	
	//Exercise 19: Parse Date/Time Strings in Multiple Formats
	/*Write a Java program that takes a list of date/time strings in different formats 
	 *(e.g., "2025-08-15", "15/08/2025", "Aug 15, 2025", "2025-08-15 14:30", etc.), and parses them into a 
	 *LocalDate or LocalDateTime object.If the format is invalid, print an error message saying it could not be parsed.
	 */
	
	public void parsingExercise19() {
		String[] inputs = {
			    "2025-08-15",       // yyyy-MM-dd
			    "15/08/2025",       // dd/MM/yyyy
			    "Aug 15, 2025",     // MMM dd, yyyy
			    "2025-08-15 14:30", // yyyy-MM-dd HH:mm
			    "15-Aug-2025",      // dd-MMM-yyyy
			    "2025/08/15",       // yyyy/MM/dd
			    "15 08 2025",       // dd MM yyyy
			    "2025-15-08",       // invalid
			    "abc",              // invalid text
			    "",                 // empty
			    null                // null
			};

        DateTimeFormatter[] formats = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("MMM dd, yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("dd-MMM-yyyy"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd"),
            DateTimeFormatter.ofPattern("dd MM yyyy")
        };

        for (String value : inputs) {
            if (value == null || value.trim().isEmpty()) {
                System.out.println("Skipped: Value should not be null or empty...!");
                continue;
            }

            boolean parsed = false;
            for (DateTimeFormatter fmt : formats) {
                try {
                    LocalDate date = LocalDate.parse(value.trim(), fmt);
                    System.out.println("Parsed date ::: " + date + " using format " + fmt);
                    parsed = true;
                    break; 
                } catch (DateTimeParseException e) {
                    
                }
            }

            if (!parsed) {
                System.out.println("Error: \"" + value + "\" is not a valid date in supported formats.");
            }
        }
	}

	
	
	//Exercise 20: Parse user input from Scanner as different types safely with error messages
		/*Write a Java program that:
		Reads user input from the console using a Scanner.
		Prompts the user for three different types of data:
		An integer
		A double
		A date in yyyy-MM-dd format
		Validates each input to ensure it is of the correct type.
		Displays clear error messages when the input is invalid (e.g., wrong format, empty string).
		Re-prompts the user until valid input is entered for each type.
		After all inputs are successfully read, prints them back in a formatted output.
		 */

	   public void parsingExercise20() {

			Scanner scanner = new Scanner(System.in);

			int intValue = readInt(scanner, "Enter an integer: ");
			double doubleValue = readDouble(scanner, "Enter a double: ");
			LocalDate dateValue = readDate(scanner, "Enter a date (yyyy-MM-dd): ");

			System.out.println("You entered -> Integer: " + intValue + ", Double: " + doubleValue + ", Date: " + dateValue);

			scanner.close();

		}

		private static int readInt(Scanner sc, String prompt) {
			while (true) {
				System.out.print(prompt);
				String input = sc.nextLine().trim();
				try {
					return Integer.parseInt(input);
				} catch (NumberFormatException e) {
					System.out.println("Invalid integer! Please try again.");
				}
			}
		}

		private static double readDouble(Scanner sc, String prompt) {
			while (true) {
				System.out.print(prompt);
				String input = sc.nextLine().trim();
				try {
					return Double.parseDouble(input);
				} catch (NumberFormatException e) {
					System.out.println("Invalid double! Please try again.");
				}
			}
		}

		private static LocalDate readDate(Scanner sc, String prompt) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			while (true) {
				System.out.print(prompt);
				String input = sc.nextLine().trim();
				try {
					return LocalDate.parse(input, formatter);
				} catch (DateTimeParseException e) {
					System.out.println("Invalid date format! Please use yyyy-MM-dd.");
				}
			}
		}
		
}




