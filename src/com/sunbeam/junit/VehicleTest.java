package com.sunbeam.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.entities.VehicleModel;


class VehicleTest {

	    private Vehicle vehicle;
	    private VehicleModel vehicleModel;

	    @BeforeEach
	    public void setUp() {
	        vehicle = new Vehicle("MH123", vehicleModel);
	        vehicleModel = new VehicleModel(2, "Manufacturer", "ModelName");
	    }

	    @Test
	    public void testVehicle() {
	        assertNotNull(vehicle);
	        assertEquals("MH123", vehicle.getVehicleNumber());
	        assertEquals(vehicleModel, vehicle.getVehicleModel());
	    }

	    @Test
	    public void testSetVehicleNumber() {
	        vehicle.setVehicleNumber("MH789");
	        assertEquals("MH789", vehicle.getVehicleNumber());
	    }

	    @Test
	    public void testSetVehicleModel() {
	        VehicleModel newModel = new VehicleModel(2, "NewManufacturer", "NewModelName");
	        vehicle.setVehicleModel(newModel);
	        assertEquals(newModel, vehicle.getVehicleModel());
	    }

	    @Test
	    public void testHashCode() {
	        Vehicle anotherVehicle = new Vehicle("MH123", vehicleModel);
	        assertEquals(vehicle.hashCode(), anotherVehicle.hashCode());
	    }

	    @Test
	    public void testEquals() {
	        Vehicle anotherVehicle = new Vehicle("MH123", vehicleModel);
	        assertTrue(vehicle.equals(anotherVehicle));
	        
	        Vehicle differentVehicle = new Vehicle("MH789", vehicleModel);
	        assertFalse(vehicle.equals(differentVehicle));
	        
	        assertFalse(vehicle.equals(null));
	        assertFalse(vehicle.equals("Some String"));
	    }

	    @Test
	    public void testToString() {
	        String expectedString = "Vehicle [vehicleNumber=Mh123, vehicleModel=" + vehicleModel + "]";
	        assertEquals(expectedString, vehicle.toString());
	    }
	}