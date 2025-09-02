<template>
 <section
    id="contact">
    <section class="grid grid-cols-1 md:grid-cols-2 gap-8">
      <!-- form -->
      <Card class="bg-muted/60 dark:bg-card">
        <CardHeader class="text-primary text-2xl"> </CardHeader>
        <CardContent>
          <form
            @submit.prevent="createEmployee"
            class="grid gap-4"
          >
            <div class="flex flex-col md:flex-row gap-8">
              <div class="flex flex-col w-full gap-1.5">
                <Label for="first-name">First Name</Label>
                <Input
                  id="first-name"
                  type="text"
                  placeholder="Leopoldo"
                  v-model="contactForm.employeeFirstName"
                />
              </div>

              <div class="flex flex-col w-full gap-1.5">
                <Label for="last-name">Last Name</Label>
                <Input
                  id="last-name"
                  type="text"
                  placeholder="Miranda"
                  v-model="contactForm.employeeLastName"
                />
              </div>
            </div>

            <div class="flex flex-col gap-1.5">
              <Label for="email">Email</Label>
              <Input
                id="email"
                type="email"
                placeholder="leomirandadev@gmail.com"
                v-model="contactForm.employeeEmail"
              />
            </div>

            <div class="flex flex-col gap-1.5">
              <Label for="phone">Phone</Label>
              <Input
                id="phone"
                type="text"
                placeholder="(123) 456-7890"
                v-model="contactForm.employeePhone"
              />
            </div>

            <div class="flex flex-col gap-1.5">
              <Label for="hire-date">Hire Date</Label>
              <Input
                id="hire-date"
                type="date"
                v-model="contactForm.employeeHireDate"
              />
            </div>

            <div class="flex flex-col gap-1.5">
              <Label for="title">Title</Label>
              <Input
                id="title"
                type="text"
                placeholder="Software Engineer"
                v-model="contactForm.employeeTitle"
              />
            </div>

            <div class="flex flex-col gap-1.5">
              <Label for="salary">Salary</Label>
              <Input
                id="salary"
                type="number"
                placeholder="50000"
                v-model="contactForm.employeeSalary"
              />
            </div>

            <div class="flex flex-col gap-1.5">
              <Label for="department">Department</Label>
              <Input
                id="departmentId"
                type="text"
                placeholder="Department"
                v-model="contactForm.departmentId"
              />
            </div>

            <Alert
              v-if="invalidInputForm"
              variant="destructive"
            >
              <AlertCircle class="w-4 h-4" />
              <AlertTitle>Error</AlertTitle>
              <AlertDescription>
                There is an error in the form. Please check your input.
              </AlertDescription>
            </Alert>

            <Button class="mt-4">{{ isEditing ? "Update Employee" : "Create Employee" }}</Button>
          </form>
        </CardContent>

        <CardFooter></CardFooter>
      </Card>
    </section>
  </section>
</template>

<script setup lang="ts">
import { ref,  computed, onMounted} from "vue";


import { Card, CardHeader, CardContent, CardFooter } from "../../components/ui/card";
import { Button } from "../../components/ui/button";

import { Label } from "../../components/ui/label";
import { Input } from "../../components/ui/input";

import { Alert, AlertDescription, AlertTitle } from "@/components/ui/alert";
import { AlertCircle } from "lucide-vue-next";
import { useRoute, useRouter } from "vue-router";
import dayjs from "dayjs";

function formatDate(dateStr: string): string {
  return dayjs(dateStr).format("YYYY-MM-DD");
}


const contactForm = ref({
  employeeFirstName: "",
  employeeLastName: "",
  employeeEmail: "",
  employeePhone: "",
  employeeHireDate: "",
  employeeTitle: "",
  employeeSalary: 0,
  departmentId: 0,
});



const invalidInputForm = ref<boolean>(false);

//for editing
const route = useRoute();
const isEditing = computed(() => !!id);
const id = route.params.id;

onMounted(async () => {
  if (isEditing.value) {
    // Fetch employee by ID
     const res = await fetch(`http://localhost:8080/api/employees/${id}`);
     const data = await res.json();
     data.employeeHireDate = formatDate(data.employeeHireDate);
     contactForm.value = data;


     console.log("Employee data to edit:", formatDate(data.employeeHireDate));
     console.log("Fetched employee:", contactForm.value);
  }
});



const createEmployee = async () => {
  if (contactForm.value.employeeFirstName.trim() === "" ||
     contactForm.value.employeeLastName.trim() === "" ||
     contactForm.value.employeeEmail.trim() === "" ||
     contactForm.value.employeePhone.trim() === "" ||
     contactForm.value.employeeHireDate.trim() === "" ||
     contactForm.value.employeeTitle.trim() === "" ||
     contactForm.value.employeeSalary <= 0 ||
     contactForm.value.departmentId <= 0
  ) {
    invalidInputForm.value = true;
    return;
  }

if (isEditing.value) {
  console.log("Updating employee:", contactForm.value);
  try {
    const response = await fetch(`http://localhost:8080/api/employees/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(contactForm.value),
    });
    if (response.ok) {
      // Employee created successfully
      console.log("Employee updated:", contactForm);
      invalidInputForm.value = false;
      // Redirect to the employees list page
      window.location.href = "/admin/employees";

    } else {
      console.error("Error updating employee (response):", response.statusText);
    }
  } catch (error) {
    console.error("Error updating employee", error);
  }
} else {
  try {
    const response = await fetch("http://localhost:8080/api/employees", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(contactForm),
    });
    if (response.ok) {
      // Employee created successfully
      console.log("Employee created:", contactForm);
      invalidInputForm.value = false;
      // Redirect to the employees list page
      window.location.href = "/admin/employees";

    } else {
      console.error("Error creating employee (response):", response.statusText);
    }
  } catch (error) {
    console.error("Error creating employee - catch:", error);
  }
}
};  
</script>
