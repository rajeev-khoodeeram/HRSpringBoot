import { createRouter, createWebHistory } from "vue-router";

import PublicLayout from "../views/layouts/PublicLayout.vue";
import AdminLayout from "../views/layouts/AdminLayout.vue";

import Home from "../views/public/Home.vue";
import About from "../views/public/About.vue";

const routes = [
  {
    path: "/",
    component: PublicLayout,
    children: [
      { path: "", component: Home },
      { path: "about", component: About },
    ],
  },
  {
    path: "/admin",
    component: AdminLayout,
    children: [
    { path: "employees", component: () => import("@/views/admin/Employees.vue") },
    { path: "department", component: () => import("@/views/admin/Department.vue") },
    { path: "employees/create", component: () => import("@/components/employee/EmployeeNew.vue") },
    { path: "employees/edit/:id", component: () => import("@/components/employee/EmployeeNew.vue"), props: true }
  ],
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
