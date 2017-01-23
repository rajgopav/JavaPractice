import java.util.*;

public class Company {
	public static class Employee {
		private final int id;
		private final String name;
		private List<Employee> reports;
		
		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
			this.reports = new ArrayList<Employee>();
		}
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public List<Employee> getReports() {
			return reports;
		}
		
		public void addReports(Employee employee) {
			reports.add(employee);
		}
	}
	
	public static class EmployeeTreeNode {
		private Employee self;
		private EmployeeTreeNode parent;
		private int level;
		
		public EmployeeTreeNode(Employee self, EmployeeTreeNode parent, int level) {
			super();
			this.self = self;
			this.parent = parent;
			this.level = level;
		}

		public Employee getSelf() {
			return self;
		}

		public EmployeeTreeNode getParent() {
			return parent;
		}

		public int getLevel() {
			return level;
		}
	}
	
	public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee) {
		EmployeeTreeNode firstNode = null;
		EmployeeTreeNode secondNode = null;
		
		int level = 0;
		Stack<EmployeeTreeNode> st = new Stack<EmployeeTreeNode>();
		st.push(new EmployeeTreeNode(ceo, null, level));
		do {
			EmployeeTreeNode parent = st.pop();
			level++;
			for(Employee e : parent.getSelf().getReports()) {
				EmployeeTreeNode employee = new EmployeeTreeNode(e, parent, level);
				st.add(employee);
				
				if(employee.getSelf().getId() == firstEmployee.getId()) {
					firstNode = employee;
				} else if(employee.getSelf().getId() == secondEmployee.getId()) {
					secondNode = employee;
				}
			}
		} while(!st.isEmpty());
		
		return searchCommonParent(firstNode, secondNode);
	}
	 
	private static Employee searchCommonParent(EmployeeTreeNode firstNode, EmployeeTreeNode secondNode) {
		if (firstNode == null || secondNode == null) {
			throw new RuntimeException("Could not find common parent");
		}
		
		if(firstNode.getSelf().getId() == secondNode.getParent().getSelf().getId())
			return firstNode.getSelf();
		else if(firstNode.getParent().getSelf().getId() == secondNode.getSelf().getId())
			return secondNode.getSelf();
		
		EmployeeTreeNode firstParent = firstNode.getParent();
		EmployeeTreeNode secondParent = secondNode.getParent();
		while(firstParent.getSelf().getId() != secondParent.getSelf().getId()) {
			if(firstParent.getLevel() > secondParent.getLevel())
				firstParent = firstParent.getParent();
			else
				secondParent = secondParent.getParent();
		}
		return firstParent.getSelf();
	}

	public static void main(String[] args) {
		Employee bill = new Employee(1,"Bill");
		Employee dom = new Employee(2,"Dom");
		Employee samir = new Employee(3,"Samir");
		Employee michael = new Employee(4,"Michael");
		Employee peter = new Employee(5,"Peter");
		Employee bob = new Employee(6,"Bob");
		Employee porter = new Employee(7,"Porter");
		Employee milton = new Employee(8,"Milton");
		Employee nina = new Employee(9,"Nina");

		bill.addReports(dom);
		bill.addReports(samir);
		bill.addReports(michael);
		
		dom.addReports(peter);
		dom.addReports(bob);
		dom.addReports(porter);
		
		peter.addReports(milton);
		peter.addReports(nina);
		
		Employee test = closestCommonManager(bill, milton, nina);
		System.out.println("The closet manager for " + milton.getName() + " and " + nina.getName() + " is: " + test.getName());
		
		test = closestCommonManager(bill, nina, porter);
		System.out.println("The closet manager for " + nina.getName() + " and " + porter.getName() + " is: " + test.getName());
		
		test = closestCommonManager(bill, nina, samir);
		System.out.println("The closet manager for " + nina.getName() + " and " + samir.getName() + " is: " + test.getName());
		
		test = closestCommonManager(bill, peter, nina);
		System.out.println("The closet manager for " + peter.getName() + " and " + nina.getName() + " is: " + test.getName());
	}

}
