import { Employee } from "@/types/Employee";

/**
 * Fetch all employees from the API.
 * @returns A promise that resolves to an array of employees.
 */
export const getEmployees = async () => {
  const response = await fetch("http://localhost:8080/api/employees");
  if (!response.ok) {
    throw new Error("Failed to fetch employees");
  }
  const employees: Employee[] = await response.json();
  return employees;
};

/**
 * Fetch an employee by ID from the API.
 * @param id The ID of the employee to fetch.
 * @returns A promise that resolves to the employee object.
 */
export const getEmployeeById = async (id: number) => {
  const response = await fetch(`http://localhost:8080/api/employees/${id}`);
  if (!response.ok) {
    throw new Error("Failed to fetch employee");
  }
  const employee: Employee = await response.json();
  return employee;
};