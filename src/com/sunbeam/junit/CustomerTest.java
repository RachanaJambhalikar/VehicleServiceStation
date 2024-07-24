package com.sunbeam.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sunbeam.entities.Customer;
 
public class CustomerTest {

    private Customer customer;
 
    @BeforeEach
	public void setUp() {
        customer = new Customer("Rama", "pune", "1234567890");
    }

    @Test
    public void testCustomer() {
        assertNotNull(customer);
        assertEquals("Rama", customer.getName());
        assertEquals("pune", customer.getAddress());
        assertEquals("1234567890", customer.getPhoneNumber());
        assertNotNull(customer.getVehicles());
        assertTrue(customer.getVehicles().isEmpty());
}
    @Test
    public void testSetName() {
        customer.setName("New Name");
        assertEquals("New Name", customer.getName());
    }

    @Test
    public void testSetAddress() {
        customer.setAddress("New Address");
        assertEquals("New Address", customer.getAddress());
    }
    
    @Test
    public void testSetPhoneNumber() {
        customer.setPhoneNumber("0987654321");
        assertEquals("0987654321", customer.getPhoneNumber());
    }

}