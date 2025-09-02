<script setup lang="ts">
import Navbar from "@/views/admin/Navbar.vue";
import "./admin.css";
</script>

<template>
  <div class="admin-layout">
    <!-- Navbar always visible -->
    <Navbar />

    <!-- Page content changes here -->
    <main class="content">
      <router-view /> 
    </main>
  </div>
</template>

<style scoped>
.admin-layout {
  display: flex;
  flex-direction: column;
  height: 100vh;
}
.content {
  flex: 1;
  padding: 5rem;
}
</style>
