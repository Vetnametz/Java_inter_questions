# Java_inter_questions

## For answers, please, create separate branch like: "luke_skywalker"

Objective: Write a class that calculates the cost in bytes of an object.
Requirements:
 - Fast & Light
 - Thread-safe
 - Without specific JVM configuration
 
Api:
class ObjectSize {
	/* The method to implement, it returns the number of bytes. */
	long getSize(Object object) { /* Implement me */ }
}

Reflective capabilities of Java will be used to inspect objects.
The result will obviously be an approximation based on 64-bit JVM.
Pay attention to the difference in size between primitive types and objectives.
The size should be calculated only for the current object and not for nested objects.
Wrapper of primitive types, arrays and strings are calculated as part of the object.
Pay attention to the multidimensional arrays, they are considered part of the object.
Java save memory in blocks of 8 bytes, then objects are rounded with a padding to a size that is a multiple of 8.

Summary of sizes:
boolean, byte - 1 byte
char, short - 2 bytes
int, float - 4 bytes
long, double - 8 bytes
object header - 8 bytes
array header - 12 bytes
reference - 8 bytes
padding - 1-7 bytes

For example:

class A {					// 8 bytes header + padding
	private int a;			// 4 bytes
	private Long c;			// 16 bytes (8 reference + 8 long)
	private String b;		// 32 bytes + 2 * length (header and caches + n-chars)
	private Object d[];		// 12 bytes + 8 * length (header + n-references)
	private Date e;			// 8 bytes (reference to Date object)
}

Size: 80 + (array length * 8) + (string length * 2) + padding

If the above problem was easy, you can try to solve the second part.

Api:
class ObjectSize {
	/* The method to implement, it returns the number of bytes. */
	long getSize(Object object, boolean deep) { /* Implement me */ }
}

In this second part if the deep is true, you have to calculate the size of the entire object (including the children).
The problem in this case will detect if an object contains a reference to itself.
For this purpose we suggest using System.identityHashCode to uniquely identify objects.
The algorithm will require the use of one of the many techniques for detection of the rings of references.
Please note that the class must be thread safe.

## For all questions please provide code snippets. One answer one separate commit please.
