<script setup lang="ts">
  import Menu from "@/shared/components/Menu.vue";
  import LoginForm from "@/features/auth/components/LoginForm.vue";
</script>

<template >
  <div class="min-h-dvh flex flex-col bg-base-300">
    <Menu/>
     <main class="flex-1 flex items-center justify-center p-4">
      <div class="card bg-base-100 rounded-md shadow-sm w-full max-w-md">
        <LoginForm />
      </div>
    </main>
  </div>
</template>
