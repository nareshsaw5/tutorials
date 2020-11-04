package dodo.hrms;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import dodo.learning.dto.Department;
import dodo.learning.dto.DepartmentTypeEnum;
import dodo.learning.dto.Employee;
import dodo.learning.dto.Region;
import dodo.util.HibernateUtil;
import junit.framework.Assert;

public class EmployeeTest {
	
	//Logger logger = LoggerFactory.getLogger(EmployeeTest.class)

	static SessionFactory sessionFactory;
	static Session session;

	@BeforeClass
	public static void setup() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@BeforeMethod
	public static void openSession() {
		session = sessionFactory.openSession();

	}

	@Test
	public void testSession() {
		AssertJUnit.assertNotNull(sessionFactory.openSession());
	}

	@Test
	public void createRegion() {
		Region region = new Region();
		region.setName("Karnataka");
		Transaction tx = session.beginTransaction();
		session.save(region);
		tx.commit();
	}

	@Test
	public void updateRegion() {
		Region region = session.get(Region.class, new Integer(1));
		region.setName("Telangana");
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(region);
		tx.commit();
	}

	@Test
	public void createDepartment() {
		Department dept = new Department();
		dept.setName("IT");
		dept.setType(DepartmentTypeEnum.PERMANENT);

		Set<Employee> employees = new HashSet<>();
		Employee emp = new Employee();
		emp.setFirstName("Bob");
		emp.setDepartment(dept);
		employees.add(emp);

		Transaction tx = session.beginTransaction();
		session.save(dept);
		tx.commit();

		// since Department has CascadeType.save_update, save of department should save
		// associated employee too
		// verify it.
		List<Employee> employeeList = getEmployeeList();
		assertNotNull(employeeList);

	}

	@Test
	public void testSaveEmployee() {

		Employee emp = new Employee();
		emp.setFirstName("Naresh");
		emp.setLastName("Saw");
		emp.setSalary(15000);
		emp.setCreatedon(new Date());
		emp.setUdpdatedon(new Date());

		emp.setRegion(session.get(Region.class, new Integer(1)));
		emp.setDepartment(session.get(Department.class, new Integer(1)));

		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();

		Assert.assertNotNull(getEmployeeList());

	}

	@Test
	public void testDeleteDepartment() {
		Department dept = new Department();
		dept.setName("HR");

		Set<Employee> employees = new HashSet<>();
		Employee emp = new Employee();
		emp.setFirstName("Bob");
		emp.setDepartment(dept);
		employees.add(emp);

		dept.setEmployees(employees);

		Transaction tx = session.beginTransaction();
		session.save(dept);
		tx.commit();

		dept = session.get(Department.class, new Integer(2));
		tx = session.beginTransaction();
		session.delete(dept);
		tx.commit();

		Employee deletedEmp = getEmployee("Bob");
		assertNull(deletedEmp);

	}

	private Employee getEmployee(String name) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("firstName"), name));

		List<Employee> employees = session.createQuery(criteriaQuery).getResultList();
		if (employees != null && employees.size() > 0) {
			return employees.get(0);
		}

		return null;
	}

	private List<Employee> getEmployeeList() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		List<Employee> employees = session.createQuery(criteriaQuery).getResultList();

		return employees;
	}

	@AfterMethod
	public void tearDown() {
		session.close();
	}

}
