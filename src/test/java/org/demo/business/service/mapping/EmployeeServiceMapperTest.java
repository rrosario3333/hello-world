/*
 * Created on 3 avr. 2014 ( Time 19:39:42 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.Employee;
import org.demo.bean.jpa.EmployeeEntity;
import org.demo.bean.jpa.ShopEntity;
import org.demo.bean.jpa.BadgeEntity;
import org.demo.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class EmployeeServiceMapperTest {

	private EmployeeServiceMapper employeeServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		employeeServiceMapper = new EmployeeServiceMapper();
		employeeServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'EmployeeEntity' to 'Employee'
	 * @param employeeEntity
	 */
	@Test
	public void testMapEmployeeEntityToEmployee() {
		// Given
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setFirstName(mockValues.nextString(40));
		employeeEntity.setLastName(mockValues.nextString(40));
		employeeEntity.setManager(mockValues.nextShort());
		employeeEntity.setEmail(mockValues.nextString(60));
		employeeEntity.setShop(new ShopEntity());
		employeeEntity.getShop().setCode(mockValues.nextString(3));
		employeeEntity.setBadge(new BadgeEntity());
		employeeEntity.getBadge().setBadgeNumber(mockValues.nextInteger());
		
		// When
		Employee employee = employeeServiceMapper.mapEmployeeEntityToEmployee(employeeEntity);
		
		// Then
		assertEquals(employeeEntity.getFirstName(), employee.getFirstName());
		assertEquals(employeeEntity.getLastName(), employee.getLastName());
		assertEquals(employeeEntity.getManager(), employee.getManager());
		assertEquals(employeeEntity.getEmail(), employee.getEmail());
		assertEquals(employeeEntity.getShop().getCode(), employee.getShopCode());
		assertEquals(employeeEntity.getBadge().getBadgeNumber(), employee.getBadgeNumber());
	}
	
	/**
	 * Test : Mapping from 'Employee' to 'EmployeeEntity'
	 */
	@Test
	public void testMapEmployeeToEmployeeEntity() {
		// Given
		Employee employee = new Employee();
		employee.setFirstName(mockValues.nextString(40));
		employee.setLastName(mockValues.nextString(40));
		employee.setManager(mockValues.nextShort());
		employee.setEmail(mockValues.nextString(60));
		employee.setShopCode(mockValues.nextString(3));
		employee.setBadgeNumber(mockValues.nextInteger());

		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		// When
		employeeServiceMapper.mapEmployeeToEmployeeEntity(employee, employeeEntity);
		
		// Then
		assertEquals(employee.getFirstName(), employeeEntity.getFirstName());
		assertEquals(employee.getLastName(), employeeEntity.getLastName());
		assertEquals(employee.getManager(), employeeEntity.getManager());
		assertEquals(employee.getEmail(), employeeEntity.getEmail());
		assertEquals(employee.getShopCode(), employeeEntity.getShop().getCode());
		assertEquals(employee.getBadgeNumber(), employeeEntity.getBadge().getBadgeNumber());
	}

}