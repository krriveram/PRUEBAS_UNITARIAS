package tallerpruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;

public class EmployeeTest {
    
    private Employee workerUSD;
    private Employee workerOtherCurrency;
    private Employee supervisorUSD;
    private Employee supervisorOtherCurrency;
    private Employee managerUSD;
    private Employee managerOtherCurrency;
    
    @Before
    public void setUp() {
        workerUSD = new Employee(1000.0f, "USD", 0.0f, EmployeeType.Worker);
        workerOtherCurrency = new Employee(1000.0f, "EUR", 0.0f, EmployeeType.Worker);
        supervisorUSD = new Employee(2000.0f, "USD", 10.0f, EmployeeType.Supervisor);
        supervisorOtherCurrency = new Employee(2000.0f, "EUR", 10.0f, EmployeeType.Supervisor);
        managerUSD = new Employee(3000.0f, "USD", 20.0f, EmployeeType.Manager);
        managerOtherCurrency = new Employee(3000.0f, "EUR", 20.0f, EmployeeType.Manager);
    }
    
    @Test
    public void testWorkerCsUsdEvenMonth() {
        float result = workerUSD.cs();
        float expected = 1000.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testWorkerCsOtherCurrencyEvenMonth() {
        float result = workerOtherCurrency.cs();
        float expected = 950.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testSupervisorCsUsdEvenMonth() {
        float result = supervisorUSD.cs();
        float expected = 2003.5f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testSupervisorCsOtherCurrencyEvenMonth() {
        float result = supervisorOtherCurrency.cs();
        float expected = 1903.5f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testManagerCsUsdEvenMonth() {
        float result = managerUSD.cs();
        float expected = 3014.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testManagerCsOtherCurrencyEvenMonth() {
        float result = managerOtherCurrency.cs();
        float expected = 2864.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testWorkerYearBonusUsd() {
        float result = workerUSD.CalculateYearBonus();
        float expected = 386.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testWorkerYearBonusOtherCurrency() {
        float result = workerOtherCurrency.CalculateYearBonus();
        float expected = 386.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testSupervisorYearBonusUsd() {
        float result = supervisorUSD.CalculateYearBonus();
        float expected = 2193.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testSupervisorYearBonusOtherCurrency() {
        float result = supervisorOtherCurrency.CalculateYearBonus();
        float expected = 2286.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testManagerYearBonusUsd() {
        float result = managerUSD.CalculateYearBonus();
        float expected = 3386.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testManagerYearBonusOtherCurrency() {
        float result = managerOtherCurrency.CalculateYearBonus();
        float expected = 3236.0f;
        assertEquals(expected, result, 0.01);
    }
    
    @Test
    public void testDecimoCalculation() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        
        float result = workerUSD.cs();
        
        if (month % 2 == 0) {
            assertEquals(1000.0f, result, 0.01);
        } else {
            float expected = 1000.0f + (386.0f / 12 * 2);
            assertEquals(expected, result, 0.01);
        }
    }
    
    @Test
    public void testConstructorValues() {
        Employee emp = new Employee(1500.0f, "USD", 5.0f, EmployeeType.Supervisor);
        float salaryResult = emp.cs();
        assertTrue(salaryResult > 0);
    }
}