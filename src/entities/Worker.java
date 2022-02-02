package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.spi.CalendarNameProvider;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HouerContract> contracts = new ArrayList<>();
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HouerContract> getContract() {
		return contracts;
	}

	/* teve que ser apagado o método setContract porque tal médodo setava uma lista inteira de uma vez.
	A lista deve permitir adicionar membros um por vez*. A lista deve começar vazia e permitir 
	que se adicione contratos um a um*/
	
	public void assContract(HouerContract contract) {
		this.contracts.add(contract);
	}
	public void removeContract(HouerContract contract) {
		this.contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HouerContract c: contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}	
}
