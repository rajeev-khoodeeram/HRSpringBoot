const Employee = {
  employeeId: Number,
  employeeFirstName: String,
  employeeLastName: String,
  employeeEmail: String,
  employeePhone: String,
  employeeHireDate: Date,
  employeeTitle: String,
  employeeSalary: Number,
  employeeDepartment: Number,
};

export type Employee = typeof Employee;
