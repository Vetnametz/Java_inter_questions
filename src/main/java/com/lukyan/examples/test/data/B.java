package com.lukyan.examples.test.data;

import java.io.Serializable;
import java.util.Date;

public class B implements Serializable {                    // 8 bytes header + padding
    private int a;            // 4 bytes
    private Long c;            // 16 bytes (8 reference + 8 long)
    private String b;        // 32 bytes + 2 * length (header and caches + n-chars)
    private Object d[];        // 12 bytes + 8 * length (header + n-references)
    private Date e;            // 8 bytes (reference to Date object)
    private B anotherB;
}
