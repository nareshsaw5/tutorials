package dodo.learning.dao;

import java.util.List;

import dodo.learning.dto.Employee;

public interface EmployeeDao {
   
    public void save(Employee emp);
    public boolean delete(Employee emp);
    public Employee getEmployee(int id);
    public List<Employee> getEmployees();

}
