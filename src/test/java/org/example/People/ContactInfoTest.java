package org.example.People;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactInfoTest {

    @Test
    void testConstructorAndGetters() {
        ContactInfo info = new ContactInfo("a@b.com", "123", "Somewhere");
        assertEquals("a@b.com", info.getEmail());
        assertEquals("123", info.getPhoneNumber());
        assertEquals("Somewhere", info.getAddress());
    }

    @Test
    void testCopyConstructor() {
        ContactInfo original = new ContactInfo("a@b.com", "123", "Somewhere");
        ContactInfo copy = new ContactInfo(original);

        assertEquals(original.getEmail(), copy.getEmail());
        assertEquals(original.getPhoneNumber(), copy.getPhoneNumber());
        assertEquals(original.getAddress(), copy.getAddress());
        assertNotSame(original, copy);
    }

    @Test
    void testToString() {
        ContactInfo info = new ContactInfo("a@b.com", "123", "Somewhere");
        String result = info.toString();
        assertTrue(result.contains("Email"));
        assertTrue(result.contains("Phone"));
    }

}
