<template>
<div class="employee-list-container">
  <a href="/admin/employees/create" class="btn btn-primary">Create Employee</a>  
  <h1>Employee List</h1>
  <p v-if="employees.length === 0">No employees found.</p>
    <table v-else class="employees-table">
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Hire Date</th>
          <th>Title</th>
          <th>Salary</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="employee in employees" :key="employee.employeeId">
          <td>{{ employee.employeeFirstName }}</td>
          <td>{{ employee.employeeLastName }}</td>
          <td>{{ employee.employeeEmail }}</td>
          <td>{{ employee.employeePhone }}</td>
          <td>{{ formatDate(employee.employeeHireDate) }}</td>
          <td>{{ employee.employeeTitle}}</td>
          <td>{{ employee.employeeSalary }}</td>
          <td>
            <button @click="router.push(`/admin/employees/edit/${employee.employeeId}`)">Edit</button>
            <button @click="deleteEmployee(employee)">Delete</button>
          </td>
          </tr>
      </tbody>
    </table>
    </div>
</template>

<script setup lang="ts">
import { Employee } from "@/types/Employee";
import { onMounted, ref } from "vue";
import dayjs from "dayjs";
import router from "@/router";
import { getEmployees } from "./EmployeeAPI";

function formatDate(dateStr: string): string {
  return dayjs(dateStr).format("DD-MM-YYYY");
}

const employees = ref<Employee[]>([]);

onMounted(async () => {
  try {
    // const response = await fetch("http://localhost:8080/api/employees");
    employees.value = await getEmployees();
    console.log("Fetched employees:", employees.value);
  } catch (error) {
    console.error("Error fetching employees:", error);
  } finally {
  }
});


/**
 * Delete an existing employee.
 * @param employee 
 */
function deleteEmployee(employee: Employee) {
  if (confirm(`Are you sure you want to delete ${employee.employeeFirstName} ${employee.employeeLastName}?`)) {
    // Send a DELETE request to the API to delete the employee
    fetch(`http://localhost:8080/api/employees/${employee.employeeId}`, {
      method: "DELETE",
    })
    .then((response) => {
      if (response.ok) {
        // Remove the deleted employee from the list
        employees.value = employees.value.filter((e) => e.employeeId !== employee.employeeId);
      } else {
        console.error("Error deleting employee:", response.statusText);
      }
    })
    .catch((error) => {
      console.error("Error deleting employee - catch:", error);
    });
}
}

</script>